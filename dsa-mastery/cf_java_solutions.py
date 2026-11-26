#!/usr/bin/env python3
"""
Generate Java solutions for Codeforces problems using Claude Code (your Claude
subscription) - no API key needed.

For each problem it:
  1. downloads the statement (helpers from cf_to_pdf.py - keep both files in one folder)
  2. runs `claude -p` to get a Java solution (class Main, stdin/stdout)
  3. compiles it with javac and runs the sample tests from the statement
  4. if a sample fails, asks Claude again with the error (up to --retries times)
  5. saves  <pid> - <name>.java  (marked UNVERIFIED if the samples never passed)

Setup:
    pip install requests beautifulsoup4 markdownify
    Install Claude Code and log in once with your Pro/Max account:  run `claude` and follow the login
    JDK 11+ (javac and java on PATH) unless you use --no-verify

Examples:
    python cf_java_solutions.py --tags dp --min-rating 800 --max-rating 1200 --count 5
    python cf_java_solutions.py --problems 4A 1800A --out my_java
    python cf_java_solutions.py --tags greedy --count 5 --no-verify --model sonnet
"""
import argparse
import re
import shutil
import subprocess
import sys
import tempfile
import time
from pathlib import Path

from bs4 import BeautifulSoup

try:
    from cf_to_pdf import (list_problems, lookup_problems, fetch_statement,
                           to_markdown, safe)
except ImportError:
    sys.exit("Put cf_java_solutions.py in the same folder as cf_to_pdf.py")

SYSTEM = (
    "You are an expert competitive programmer solving Codeforces problems in Java. "
    "Do NOT use any tools, do not read or write files, do not run commands: answer with text only. "
    "Rules: the public class must be named Main; read standard input and write standard output; "
    "use fast I/O (BufferedReader/StreamTokenizer, StringBuilder/PrintWriter); use long where "
    "values can overflow; avoid deep recursion unless run inside a Thread with a big stack; "
    "respect the time and memory limits with an efficient algorithm. "
    "Reply with a brief idea (2-4 sentences) followed by the complete program in a single "
    "```java code block, with short comments in the code."
)


def extract_samples(raw_html):
    """Return [(input, expected_output), ...] from the statement HTML."""
    soup = BeautifulSoup(raw_html, "html.parser")
    found = {"input": [], "output": []}
    for kind in found:
        for pre in soup.select(f".sample-test .{kind} pre"):
            for br in pre.find_all("br"):
                br.replace_with("\n")
            found[kind].append(pre.get_text().strip() + "\n")
    return list(zip(found["input"], found["output"]))


def extract_java(text):
    blocks = re.findall(r"```(?:java)?[ \t]*\n(.*?)```", text, re.DOTALL)
    return max(blocks, key=len).strip() if blocks else None


def compile_java(code, workdir):
    (workdir / "Main.java").write_text(code, encoding="utf-8")
    try:
        r = subprocess.run(["javac", "Main.java"], cwd=workdir, capture_output=True,
                           text=True, timeout=90)
    except subprocess.TimeoutExpired:
        return False, "javac timed out"
    return r.returncode == 0, r.stderr[:2000]


def run_samples(workdir, samples, timeout):
    for i, (inp, exp) in enumerate(samples, 1):
        try:
            r = subprocess.run(["java", "-Xmx256m", "Main"], cwd=workdir, input=inp,
                               capture_output=True, text=True, timeout=timeout)
        except subprocess.TimeoutExpired:
            return False, f"Sample {i}: time limit exceeded ({timeout}s)"
        if r.returncode != 0:
            return False, f"Sample {i}: runtime error\n{r.stderr[:1500]}"
        if r.stdout.split() != exp.split():
            return False, (f"Sample {i}: wrong answer\nInput:\n{inp}\n"
                           f"Expected:\n{exp}\nGot:\n{r.stdout[:1500]}")
    return True, ""


def ask_claude(claude_exe, args, prompt, cwd):
    """Run `claude -p` with the prompt on stdin and return the text reply."""
    cmd = [claude_exe, "-p", "--append-system-prompt", SYSTEM]
    if args.model:
        cmd += ["--model", args.model]
    try:
        r = subprocess.run(cmd, input=prompt, capture_output=True, text=True,
                           encoding="utf-8", cwd=cwd, timeout=args.claude_timeout)
    except subprocess.TimeoutExpired:
        raise RuntimeError(f"claude timed out after {args.claude_timeout}s")
    if r.returncode != 0:
        raise RuntimeError((r.stderr or r.stdout or "claude failed").strip()[:500])
    return r.stdout


def solve(claude_exe, args, statement_md, samples):
    """Returns (code, status). status == '' means the samples passed."""
    base_prompt = "Solve this Codeforces problem in Java.\n\n" + statement_md
    prompt = base_prompt
    code, last_err = None, ""
    workdir = Path(tempfile.mkdtemp(prefix="cfjava_"))  # claude also runs here: no access to your files
    try:
        for attempt in range(1, args.retries + 2):
            text = ask_claude(claude_exe, args, prompt, workdir)
            new_code = extract_java(text)
            if not new_code:
                last_err = "no code block in the reply"
            else:
                code = new_code
                if args.no_verify:
                    return code, "not verified (--no-verify)"
                ok, err = compile_java(code, workdir)
                if ok and samples:
                    ok, err = run_samples(workdir, samples, args.timeout)
                if ok:
                    return code, ""
                last_err = err
            print(f"    attempt {attempt} failed: {last_err.splitlines()[0] if last_err else '?'}")
            prompt = (base_prompt + "\n\nYour previous solution:\n```java\n" + (code or "") +
                      "\n```\n\nIt failed with:\n" + last_err +
                      "\n\nFix it and send the complete corrected program in one ```java block.")
        return code, f"samples still failing: {last_err.splitlines()[0] if last_err else '?'}"
    finally:
        shutil.rmtree(workdir, ignore_errors=True)


def main():
    ap = argparse.ArgumentParser(description="Codeforces problems -> Java solutions via Claude Code")
    ap.add_argument("--tags", help="comma separated Codeforces tags, e.g. 'dp,greedy'")
    ap.add_argument("--min-rating", type=int)
    ap.add_argument("--max-rating", type=int)
    ap.add_argument("--count", type=int, default=10, help="how many problems (0 = all)")
    ap.add_argument("--all", action="store_true", help="all matching problems (will hit usage limits!)")
    ap.add_argument("--sort", choices=["popular", "rating", "newest"], default="popular")
    ap.add_argument("--problems", nargs="*", help="explicit IDs, e.g. 1800A 4A")
    ap.add_argument("--out", default="java_solutions", help="output folder")
    ap.add_argument("--model", default="", help="optional model for claude: sonnet, opus, or a full model id "
                                                "(default: whatever Claude Code uses)")
    ap.add_argument("--retries", type=int, default=2, help="fix attempts after a failed sample")
    ap.add_argument("--timeout", type=int, default=10, help="seconds per sample run")
    ap.add_argument("--claude-timeout", type=int, default=600, help="max seconds for one claude call")
    ap.add_argument("--no-verify", action="store_true", help="skip javac / sample tests")
    ap.add_argument("--delay", type=float, default=2.0, help="seconds between problems")
    args = ap.parse_args()

    claude_exe = shutil.which("claude")
    if not claude_exe:
        sys.exit("`claude` not found on PATH. Install Claude Code and log in with your Claude account first.")
    if not args.no_verify and not (shutil.which("javac") and shutil.which("java")):
        sys.exit("javac/java not found on PATH. Install a JDK, or use --no-verify.")

    if args.problems:
        problems = lookup_problems(args.problems)
    else:
        tags = [t.strip() for t in args.tags.split(",")] if args.tags else []
        problems = list_problems(tags, args.min_rating, args.max_rating,
                                 0 if args.all else args.count, args.sort)
    if not problems:
        sys.exit("No problems matched.")

    out_dir = Path(args.out)
    out_dir.mkdir(parents=True, exist_ok=True)
    print(f"{len(problems)} problems -> {out_dir.resolve()}")

    verified = unverified = skipped = failed = 0
    for i, p in enumerate(problems, 1):
        pid = f"{p['contestId']}{p['index']}"
        fname = f"{pid} - {safe(p['name'])}.java" if p.get("name") else f"{pid}.java"
        path = out_dir / fname
        print(f"[{i}/{len(problems)}] {pid} {p.get('name') or ''}")
        if path.exists():
            print("  = already exists, skipping")
            skipped += 1
            continue
        try:
            url, raw = fetch_statement(p["contestId"], p["index"])
        except Exception as e:
            print(f"  ! statement download failed: {e}")
            failed += 1
            time.sleep(args.delay)
            continue
        try:
            code, status = solve(claude_exe, args, to_markdown(p, url, raw), extract_samples(raw))
        except Exception as e:
            print(f"  ! claude error: {e}")
            failed += 1
            time.sleep(args.delay)
            continue
        if not code:
            print("  ! no code produced")
            failed += 1
        else:
            header = f"// {pid} - {p.get('name') or ''}\n// {url}\n"
            if status:
                header += f"// STATUS: UNVERIFIED ({status})\n"
                unverified += 1
            else:
                header += "// STATUS: passed all sample tests\n"
                verified += 1
            path.write_text(header + "\n" + code + "\n", encoding="utf-8")
            print(f"  -> {path}" + (f"   [{status}]" if status else "   [samples OK]"))
        time.sleep(args.delay)

    print(f"\nDone. passed samples: {verified} | unverified: {unverified} | "
          f"skipped: {skipped} | failed: {failed}")


if __name__ == "__main__":
    main()
