#!/usr/bin/env python3
"""
Download Codeforces problems (filtered by tag / rating) and convert them to
a single Markdown table, PDF, or Markdown statements.

Install:
    pip install requests beautifulsoup4 markdownify playwright
    playwright install chromium          # PDF engine (works on Windows/Mac/Linux)
    (alternative PDF engine: pip install weasyprint -- needs GTK/Pango on Windows)
    (optional, if you get HTTP 403 from Cloudflare: pip install cloudscraper)

Examples:
    python cf_to_pdf.py --tags dp --min-rating 1200 --max-rating 1600 --count 50
    python cf_to_pdf.py --tags dp --all --out dp_problems
    python cf_to_pdf.py --problems 1800A 1800B 1791C
    python cf_to_pdf.py --tags dp --count 5 --format pdf     # table | pdf | md | both
"""
import argparse
import html
import re
import sys
import time
from collections import Counter
from pathlib import Path

import requests
from bs4 import BeautifulSoup
from markdownify import markdownify as md_convert

BASE = "https://codeforces.com"
HEADERS = {"User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 "
                         "(KHTML, like Gecko) Chrome/124.0 Safari/537.36"}

try:
    import cloudscraper
    session = cloudscraper.create_scraper()
except ImportError:
    session = requests.Session()
session.headers.update(HEADERS)

CSS = """
@page { size: A4; margin: 18mm; }
body { font-family: "DejaVu Sans", Arial, sans-serif; font-size: 10.5pt; line-height: 1.45; color: #111; }
section.problem { page-break-after: always; }
section.problem:last-child { page-break-after: auto; }
.title { font-size: 17pt; font-weight: bold; margin-bottom: 4px; }
.meta { color: #555; font-size: 9pt; margin-bottom: 10px; }
.header { margin-bottom: 12px; }
.header .property-title { font-weight: bold; }
.section-title { font-size: 12pt; font-weight: bold; margin: 14px 0 4px; }
pre { background: #f4f4f4; border: 1px solid #ddd; padding: 6px; white-space: pre-wrap;
      font-family: "DejaVu Sans Mono", monospace; font-size: 9.5pt; }
.input, .output { margin: 4px 0; }
.title-bar, .test-example-line { }
.input-output-copier { display: none; }
img { max-width: 100%; }
i { font-family: "DejaVu Serif", serif; }
ul, ol { margin: 4px 0 4px 20px; }
table { border-collapse: collapse; }
td, th { border: 1px solid #999; padding: 2px 6px; }
"""

LATEX = {
    r"\le": "≤", r"\leq": "≤", r"\ge": "≥", r"\geq": "≥", r"\ne": "≠", r"\neq": "≠",
    r"\cdot": "·", r"\times": "×", r"\ldots": "…", r"\dots": "…", r"\cdots": "⋯",
    r"\oplus": "⊕", r"\lfloor": "⌊", r"\rfloor": "⌋", r"\lceil": "⌈", r"\rceil": "⌉",
    r"\to": "→", r"\rightarrow": "→", r"\infty": "∞", r"\in": "∈", r"\sum": "Σ",
    r"\prod": "Π", r"\min": "min", r"\max": "max", r"\gcd": "gcd", r"\bmod": "mod",
    r"\pmod": "mod", r"\mod": "mod", r"\&": "&", r"\%": "%", r"\,": " ", r"\;": " ",
    r"\ ": " ", r"\{": "{", r"\}": "}", r"\alpha": "α", r"\beta": "β", r"\pi": "π",
    r"\lt": "<", r"\gt": ">", r"\mid": "|", r"\lor": "∨", r"\land": "∧",
    r"\log": "log", r"\sqrt": "√", r"\ll": "≪", r"\gg": "≫", r"\neq": "≠",
}


def latex_to_html(tex: str) -> str:
    """Very small LaTeX -> HTML converter, good enough for CF statements."""
    s = tex
    # \text{..}, \mathrm{..}, \operatorname{..}, \mathbf{..}
    s = re.sub(r"\\(?:text|mathrm|operatorname|mathbf|mathit|textbf)\{([^{}]*)\}", r"\1", s)
    # \frac{a}{b}
    s = re.sub(r"\\frac\{([^{}]*)\}\{([^{}]*)\}", r"(\1)/(\2)", s)
    # sqrt{..}
    s = re.sub(r"\\sqrt\{([^{}]*)\}", r"√(\1)", s)
    for k in sorted(LATEX, key=len, reverse=True):
        s = s.replace(k, LATEX[k])
    # sub / superscripts (braced then single char)
    for _ in range(3):
        s = re.sub(r"\^\{([^{}]*)\}", r"<sup>\1</sup>", s)
        s = re.sub(r"_\{([^{}]*)\}", r"<sub>\1</sub>", s)
    s = re.sub(r"\^(\w)", r"<sup>\1</sup>", s)
    s = re.sub(r"_(\w)", r"<sub>\1</sub>", s)
    s = s.replace("{", "").replace("}", "").replace("\\", "")
    return f"<i>{s}</i>"


def convert_math(raw_html: str) -> str:
    # Codeforces uses $$$...$$$ for inline math and $$$$$$...$$$$$$ for display math.
    raw_html = re.sub(r"\${6}(.+?)\${6}",
                      lambda m: "<div style='text-align:center'>" + latex_to_html(m.group(1)) + "</div>",
                      raw_html, flags=re.DOTALL)
    raw_html = re.sub(r"\${3}(.+?)\${3}",
                      lambda m: latex_to_html(m.group(1)), raw_html, flags=re.DOTALL)
    return raw_html


def get_json(url, params=None):
    r = session.get(url, params=params, timeout=30)
    r.raise_for_status()
    data = r.json()
    if data.get("status") != "OK":
        raise RuntimeError(data.get("comment", "API error"))
    return data["result"]


def list_problems(tags, min_rating, max_rating, count, sort):
    params = {}
    if tags:
        params["tags"] = ";".join(tags)
    result = get_json(f"{BASE}/api/problemset.problems", params)
    stats = {(s["contestId"], s["index"]): s["solvedCount"] for s in result["problemStatistics"]}
    problems = []
    for p in result["problems"]:
        rating = p.get("rating")
        if (min_rating or max_rating) and rating is None:
            continue  # unrated problems are kept only when no rating filter is used
        if min_rating and rating < min_rating:
            continue
        if max_rating and rating > max_rating:
            continue
        p["solved"] = stats.get((p["contestId"], p["index"]), 0)
        problems.append(p)
    if sort == "popular":
        problems.sort(key=lambda p: -p["solved"])
    elif sort == "rating":
        problems.sort(key=lambda p: p.get("rating") or 0)
    else:  # newest first (API default order)
        pass
    return problems if not count else problems[:count]


def parse_id(pid: str):
    m = re.fullmatch(r"(\d+)([A-Za-z]\d?)", pid.strip())
    if not m:
        raise ValueError(f"Bad problem id: {pid} (expected like 1800A)")
    return int(m.group(1)), m.group(2).upper()


def lookup_problems(ids):
    """Fill in name / tags / rating for explicit IDs like 1800A."""
    result = get_json(f"{BASE}/api/problemset.problems")
    by_id = {(p["contestId"], p["index"]): p for p in result["problems"]}
    out = []
    for pid in ids:
        cid, idx = parse_id(pid)
        out.append(by_id.get((cid, idx),
                   {"contestId": cid, "index": idx, "name": None, "rating": None, "tags": []}))
    return out


def write_table(problems, out_path):
    """Write ALL problems into one Markdown file as a table."""
    lines = ["| # | Problem | Category | Rating |",
             "|---|---------|----------|--------|"]
    for i, p in enumerate(problems, 1):
        pid = f"{p['contestId']}{p['index']}"
        url = f"{BASE}/problemset/problem/{p['contestId']}/{p['index']}"
        name = (p.get("name") or pid).replace("|", "\\|")
        tags = ", ".join(p.get("tags", [])) or "-"
        rating = p.get("rating") or "-"
        lines.append(f"| {i} | [{pid} - {name}]({url}) | {tags} | {rating} |")
    Path(out_path).write_text("\n".join(lines) + "\n", encoding="utf-8")
    print(f"  -> {out_path}")


def fetch_statement(contest_id, index):
    url = f"{BASE}/problemset/problem/{contest_id}/{index}"
    r = session.get(url, timeout=30)
    if r.status_code == 403:
        raise RuntimeError("403 Forbidden (Cloudflare). Try: pip install cloudscraper")
    r.raise_for_status()
    soup = BeautifulSoup(r.text, "html.parser")
    node = soup.select_one("div.problem-statement")
    if node is None:
        raise RuntimeError("problem-statement not found")
    # absolute image URLs
    for img in node.find_all("img"):
        src = img.get("src", "")
        if src.startswith("//"):
            img["src"] = "https:" + src
        elif src.startswith("/"):
            img["src"] = BASE + src
    for junk in node.select(".input-output-copier"):
        junk.decompose()
    # Preserve line breaks inside sample tests
    for pre in node.select("pre"):
        for div in pre.find_all("div", class_="test-example-line"):
            div.append("\n")
    return url, str(node)


def to_markdown(p, url, raw):
    """Statement HTML -> Markdown. Math stays as LaTeX ($...$ / $$...$$)."""
    soup = BeautifulSoup(raw, "html.parser")
    t = soup.select_one(".header .title")
    if t:
        t.name = "h1"
    for st in soup.select(".section-title"):
        st.name = "h3"
    for st in soup.select(".sample-tests .section-title"):
        st.name = "h3"
    for pre in soup.find_all("pre"):  # flatten sample lines to avoid blank lines
        text = pre.get_text()
        pre.clear()
        pre.string = text
    s = str(soup)
    s = re.sub(r"\${6}(.+?)\${6}", lambda m: "\n\n$$" + m.group(1).strip() + "$$\n\n", s, flags=re.DOTALL)
    s = re.sub(r"\${3}(.+?)\${3}", lambda m: "$" + m.group(1).strip() + "$", s, flags=re.DOTALL)
    md = md_convert(s, heading_style="ATX", escape_underscores=False,
                    escape_asterisks=False, escape_misc=False)
    md = re.sub(r"\n{3,}", "\n\n", md).strip()
    tags = ", ".join(p.get("tags", [])) or "-"
    meta = f"*Rating: {p.get('rating') or '?'} | Tags: {tags} | [{url}]({url})*"
    # put meta line right after the title (first line)
    lines = md.split("\n", 1)
    return lines[0] + "\n\n" + meta + "\n\n" + (lines[1] if len(lines) > 1 else "") + "\n"


def build_section(p, url, body):
    tags = ", ".join(p.get("tags", []))
    meta = f"Rating: {p.get('rating') or '?'} &nbsp;|&nbsp; Tags: {html.escape(tags) or '-'} &nbsp;|&nbsp; <a href='{url}'>{url}</a>"
    return f"<section class='problem'><div class='meta'>{meta}</div>{body}</section>"


def render(sections, out_path, backend="auto"):
    doc = f"<html><head><meta charset='utf-8'><style>{CSS}</style></head><body>{''.join(sections)}</body></html>"
    out_path = str(out_path)

    if backend in ("auto", "playwright"):
        try:
            from playwright.sync_api import sync_playwright
            with sync_playwright() as pw:
                browser = pw.chromium.launch()
                page = browser.new_page()
                page.set_content(doc, wait_until="load")
                page.pdf(path=out_path, prefer_css_page_size=True, print_background=True)
                browser.close()
            print(f"  -> {out_path}")
            return
        except Exception as e:
            if backend == "playwright":
                raise SystemExit(f"Playwright failed: {e}\nRun: pip install playwright && playwright install chromium")
            print(f"  (playwright unavailable: {type(e).__name__}; trying weasyprint)")

    try:
        from weasyprint import HTML
        HTML(string=doc, base_url=BASE).write_pdf(out_path)
        print(f"  -> {out_path}")
    except (ImportError, OSError) as e:
        raise SystemExit(
            "No PDF engine available.\n"
            "Easiest fix:  pip install playwright  &&  playwright install chromium\n"
            "Or use --format table / md (no PDF engine needed).\n"
            f"Details: {e}")


def title_from_html(raw):
    t = BeautifulSoup(raw, "html.parser").select_one(".header .title")
    if not t:
        return None
    return re.sub(r"^[A-Za-z]\d?\.\s*", "", t.get_text().strip())  # drop "A. " prefix


def safe(name):
    return re.sub(r"[^\w\-. ]+", "_", name).strip()


def main():
    ap = argparse.ArgumentParser(description="Codeforces problems -> table / PDF / Markdown")
    ap.add_argument("--tags", help="comma separated Codeforces tags, e.g. 'dp,greedy'")
    ap.add_argument("--min-rating", type=int)
    ap.add_argument("--max-rating", type=int)
    ap.add_argument("--count", type=int, default=10, help="how many problems (0 = all)")
    ap.add_argument("--all", action="store_true", help="include ALL matching problems")
    ap.add_argument("--sort", choices=["popular", "rating", "newest"], default="popular")
    ap.add_argument("--problems", nargs="*", help="explicit IDs, e.g. 1800A 1791C (skips filters)")
    ap.add_argument("--format", choices=["table", "pdf", "md", "both"], default="table",
                    help="table = ONE .md file with a table of name(link) / category / rating (default, "
                         "no statement download); pdf / md / both = full statements")
    ap.add_argument("--out", default="codeforces_problems", help="output folder (created if missing); all files are saved inside it")
    ap.add_argument("--backend", choices=["auto", "playwright", "weasyprint"], default="auto", help="PDF engine")
    ap.add_argument("--split", action="store_true", help="(always on now) one file per problem for pdf / md / both")
    ap.add_argument("--delay", type=float, default=2.0, help="seconds between requests (be polite)")
    args = ap.parse_args()

    if args.problems:
        problems = lookup_problems(args.problems)
    else:
        tags = [t.strip() for t in args.tags.split(",")] if args.tags else []
        problems = list_problems(tags, args.min_rating, args.max_rating, 0 if args.all else args.count, args.sort)

    if not problems:
        sys.exit("No problems matched.")

    out_dir = Path(args.out[:-4] if args.out.lower().endswith((".pdf", ".md")) else args.out)
    out_dir.mkdir(parents=True, exist_ok=True)
    print(f"Saving to: {out_dir.resolve()}")

    # ---- table mode: single md file, no statement downloads needed ----
    if args.format == "table":
        print(f"Writing table of {len(problems)} problems...")
        write_table(problems, out_dir / (out_dir.name + ".md"))
        print("Done.")
        return

    # ---- statement modes (pdf / md / both) ----
    print(f"Fetching {len(problems)} problems...")
    if len(problems) > 50 and not (args.split or args.all):
        print("  Tip: that's a lot for a single file - consider --split (also lets you resume).")
    if len(problems) > 50:
        print(f"  Estimated time: ~{int(len(problems) * (args.delay + 1) / 60)} min. Re-run the same command to resume.")
    name_counts = Counter(safe(p["name"]) for p in problems if p.get("name"))

    want_pdf = args.format in ("pdf", "both")
    want_md = args.format in ("md", "both")
    sections, md_parts = [], []
    args.split = True  # always one file per problem (no merged PDF)

    exts = ([".pdf"] if want_pdf else []) + ([".md"] if want_md else [])
    for i, p in enumerate(problems, 1):
        pid = f"{p['contestId']}{p['index']}"
        api_name = safe(p["name"]) if p.get("name") else None

        def stem(n):  # same-named problems get their ID appended, deterministically
            return f"{n} ({pid})" if name_counts.get(n, 0) > 1 else n

        print(f"[{i}/{len(problems)}] {pid} {p.get('name') or ''}")
        if args.split and api_name:
            b = stem(api_name)
            if all((out_dir / (b + x)).exists() for x in exts):
                print("  = already downloaded, skipping")
                continue
        try:
            url, raw = fetch_statement(p["contestId"], p["index"])
        except Exception as e:
            print(f"  ! skipped: {e}")
            time.sleep(args.delay)
            continue
        sec = build_section(p, url, convert_math(raw)) if want_pdf else None
        md = to_markdown(p, url, raw) if want_md else None
        if args.split:
            name = api_name or safe(title_from_html(raw) or "") or pid
            base = stem(name)
            if not api_name and any((out_dir / (base + x)).exists() for x in (".pdf", ".md")):
                base = f"{name} ({pid})"
            if want_pdf:
                render([sec], out_dir / (base + ".pdf"), args.backend)
            if want_md:
                (out_dir / (base + ".md")).write_text(md, encoding="utf-8")
                print(f"  -> {out_dir / (base + '.md')}")
        else:
            if want_pdf:
                sections.append(sec)
            if want_md:
                md_parts.append(md)
        time.sleep(args.delay)

    if not args.split:
        if not (sections or md_parts):
            sys.exit("Nothing downloaded.")
        base = out_dir / out_dir.name   # merged files live inside the folder too
        if want_pdf:
            render(sections, str(base) + ".pdf", args.backend)
        if want_md:
            Path(str(base) + ".md").write_text("\n\n---\n\n".join(md_parts), encoding="utf-8")
            print(f"  -> {base}.md")
    print("Done.")


if __name__ == "__main__":
    main()