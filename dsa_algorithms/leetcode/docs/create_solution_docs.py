#!/usr/bin/env python3
r"""
Create one Markdown study note per problem in categorized_problems.md, with the
full problem description, the explained approaches (idea, complexity) and the
Java code.

Content comes from the English README of each problem in the public repo
doocs/leetcode (description + written solution explanations + code). The
script keeps only the languages you ask for (Java by default).

Usage (Windows example):
    python create_solution_docs.py "D:\path\categorized_problems.md" -o solution_docs
    python create_solution_docs.py categorized_problems.md --langs java python3
    python create_solution_docs.py categorized_problems.md --only 1 94 146   # test a few

Output:
    solution_docs/<Category>/0094-Binary Tree Inorder Traversal.md
    solution_docs/_missing.txt       (problems the repo has no write-up for)

Standard library only. Uses raw.githubusercontent.com, so no API rate limit.
"""
import argparse
import os
import re
import sys
import urllib.error
import urllib.parse
import urllib.request
import time
from concurrent.futures import ThreadPoolExecutor

REPO = "doocs/leetcode"
BRANCH = "main"
RAW = f"https://raw.githubusercontent.com/{REPO}/{BRANCH}"


# ----------------------------------------------------------------- parsing
def parse_problems(md_path):
    """Return list of dicts: id, title, category, difficulty, link."""
    category, problems, seen = "Uncategorized", [], set()
    h2 = re.compile(r"^##\s+(?!#)(.+?)\s*\(\d+\)\s*$")
    row = re.compile(r"^\|\s*(\d+)\s*\|\s*(.+?)\s*\|\s*(.+?)\s*\|(.*)$")
    link = re.compile(r"\((https://leetcode\.com/problems/[^)\s]+)\)")
    with open(md_path, encoding="utf-8") as f:
        for line in f:
            line = line.rstrip("\r\n")
            m = h2.match(line)
            if m and "Table of Contents" not in line:
                category = m.group(1).strip()
                continue
            m = row.match(line)
            if m and int(m.group(1)) not in seen:
                pid = int(m.group(1))
                seen.add(pid)
                lk = link.search(m.group(4))
                diff = re.sub(r"[^\w ]", "", m.group(3)).strip()  # drop emoji
                problems.append(dict(id=pid, title=m.group(2).strip(), category=category,
                                     difficulty=diff, link=lk.group(1) if lk else ""))
    return problems


# -------------------------------------------------------------------- http
def fetch(url, retries=3):
    for attempt in range(retries):
        try:
            req = urllib.request.Request(url, headers={"User-Agent": "solution-doc-builder"})
            with urllib.request.urlopen(req, timeout=30) as r:
                return r.read().decode("utf-8")
        except urllib.error.HTTPError as e:
            if e.code == 404:
                return None
            if attempt == retries - 1:
                raise
        except Exception:
            if attempt == retries - 1:
                raise
        time.sleep(1.5 * (attempt + 1))


def readme_url(pid, title):
    lo = pid // 100 * 100
    folder = f"solution/{lo:04d}-{lo + 99:04d}/{pid:04d}.{title}/README_EN.md"
    return f"{RAW}/{urllib.parse.quote(folder)}"


# --------------------------------------------------------------- transform
TABS = re.compile(r"<!--\s*tabs:start\s*-->(.*?)<!--\s*tabs:end\s*-->", re.S)
FRONT = re.compile(r"\A---\s*\n.*?\n---\s*\n", re.S)
COMMENT = re.compile(r"<!--.*?-->", re.S)


def filter_tabs(block, langs):
    """Keep only the '#### <Lang>' sections whose name is in langs."""
    parts = re.split(r"(?m)^####\s+(.+?)\s*$", block)
    # parts = [preamble, name1, body1, name2, body2, ...]
    kept = []
    for i in range(1, len(parts), 2):
        if parts[i].strip().lower() in langs:
            kept.append(f"#### {parts[i].strip()}\n{parts[i + 1].rstrip()}\n")
    return "\n".join(kept)


def transform(text, langs):
    text = FRONT.sub("", text, count=1)
    text = TABS.sub(lambda m: "\n" + filter_tabs(m.group(1), langs) + "\n", text)
    text = COMMENT.sub("", text)
    text = re.sub(r"\n{3,}", "\n\n", text).strip()
    # drop the repo's own H1 (we write our own header)
    text = re.sub(r"\A#\s+\[.*?\]\(.*?\)\s*\n", "", text)
    return text


def build_doc(p, body):
    head = [f"# {p['id']}. {p['title']}", ""]
    meta = [f"**Difficulty:** {p['difficulty']}", f"**Category:** {p['category']}"]
    if p["link"]:
        meta.append(f"**LeetCode:** {p['link']}")
    head.append("  \n".join(meta))
    return "\n".join(head) + "\n\n---\n\n" + body + "\n"


# -------------------------------------------------------------------- main
def safe(name):
    return re.sub(r'[<>:"/\\|?*]+', "", name).strip().rstrip(".")


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("markdown", help="path to categorized_problems.md")
    ap.add_argument("-o", "--out", default="solution_docs")
    ap.add_argument("--langs", nargs="+", default=["java"],
                    help="code languages to keep, e.g. java python3 cpp (default: java)")
    ap.add_argument("--flat", action="store_true", help="don't group by category")
    ap.add_argument("--only", nargs="+", type=int, help="only these problem IDs (for testing)")
    ap.add_argument("--workers", type=int, default=8)
    ap.add_argument("--overwrite", action="store_true")
    args = ap.parse_args()

    langs = {l.lower() for l in args.langs}
    problems = parse_problems(args.markdown)
    if args.only:
        problems = [p for p in problems if p["id"] in set(args.only)]
    print(f"{len(problems)} problems to process (languages: {', '.join(sorted(langs))})", flush=True)

    def work(p):
        try:
            return p, fetch(readme_url(p["id"], p["title"]))
        except Exception as e:
            print(f"  ! {p['id']} {p['title']}: {e}", file=sys.stderr, flush=True)
            return p, None

    written, missing = 0, []
    with ThreadPoolExecutor(max_workers=args.workers) as ex:
        for i, (p, text) in enumerate(ex.map(work, problems), 1):
            if not text:
                missing.append(p)
            else:
                base = args.out if args.flat else os.path.join(args.out, safe(p["category"]))
                os.makedirs(base, exist_ok=True)
                dest = os.path.join(base, f"{p['id']:04d}-{safe(p['title'])}.md")
                if args.overwrite or not os.path.exists(dest):
                    with open(dest, "w", encoding="utf-8", newline="\n") as f:
                        f.write(build_doc(p, transform(text, langs)))
                    written += 1
            if i % 100 == 0:
                print(f"  {i}/{len(problems)} processed...", flush=True)

    print(f"\nDone. {written} files written, {len(missing)} problems without a write-up.")
    if missing:
        os.makedirs(args.out, exist_ok=True)
        path = os.path.join(args.out, "_missing.txt")
        with open(path, "w", encoding="utf-8") as f:
            for p in missing:
                f.write(f"{p['id']}\t{p['title']}\t{p['category']}\n")
        print(f"Missing list: {path}")


if __name__ == "__main__":
    main()
