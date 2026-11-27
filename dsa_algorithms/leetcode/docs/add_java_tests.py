#!/usr/bin/env python3
r"""
Add runnable test cases to the downloaded Java solutions.

For every file in the solutions folder (named like "0001-Two Sum.java"):
  1. fetch the problem's examples (Input / Output) from the doocs/leetcode README,
  2. read the signature of the public method in `class Solution`,
  3. insert a `public static void main` into class Solution that runs every
     example and prints PASS / FAIL.

Run a result with the Java source launcher (JDK 11+):
    java "java_with_tests\Arrays, Hashing & Greedy\0001-Two Sum.java"

Usage (Windows example):
    python add_java_tests.py "D:\path\categorized_problems.md" --src java_solutions --out java_with_tests
    python add_java_tests.py categorized_problems.md --only 1 9 --out /tmp/t     # try a few
    python add_java_tests.py categorized_problems.md --inplace                   # edit files in place

Supported parameter / return types: int, long, double, boolean, char, String,
their boxed forms, arrays of those (any depth) and List<...> of those.
Problems that use TreeNode, ListNode, Node, Map, design-style classes, or where
the example output can't be parsed are skipped and listed in _skipped.txt.
Standard library only; downloads come from raw.githubusercontent.com.
"""
import argparse
import html
import json
import os
import re
import shutil
import sys
import time
import urllib.error
import urllib.parse
import urllib.request
from collections import Counter
from concurrent.futures import ThreadPoolExecutor

REPO = "doocs/leetcode"
BRANCH = "main"
RAW = f"https://raw.githubusercontent.com/{REPO}/{BRANCH}"
MARK = "// ===== Generated test cases"


# ------------------------------------------------------------ problem list
def parse_titles(md_path):
    row = re.compile(r"^\|\s*(\d+)\s*\|\s*(.+?)\s*\|")
    titles = {}
    with open(md_path, encoding="utf-8") as f:
        for line in f:
            m = row.match(line.rstrip("\r\n"))
            if m:
                titles.setdefault(int(m.group(1)), m.group(2).strip())
    return titles


# -------------------------------------------------------------------- http
def fetch(url, retries=3):
    for attempt in range(retries):
        try:
            req = urllib.request.Request(url, headers={"User-Agent": "java-test-adder"})
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


def get_readme(pid, title, cache):
    path = os.path.join(cache, f"{pid:04d}.md")
    if os.path.exists(path):
        with open(path, encoding="utf-8") as f:
            return f.read()
    lo = pid // 100 * 100
    folder = f"solution/{lo:04d}-{lo + 99:04d}/{pid:04d}.{title}/README_EN.md"
    text = fetch(f"{RAW}/{urllib.parse.quote(folder)}")
    if text:
        os.makedirs(cache, exist_ok=True)
        with open(path, "w", encoding="utf-8") as f:
            f.write(text)
    return text


# ---------------------------------------------------------------- examples
EXAMPLE = re.compile(
    r"Input:\s*(.*?)\s*Output:\s*(.*?)\s*(?=Explanation:|Example\s*\d|Constraints:|\n\s*\n|\Z)", re.S)


def extract_examples(readme):
    """-> list of (input_text, output_text) from the problem description."""
    desc = readme.split("## Solutions")[0]
    desc = re.sub(r"<[^>]+>", "", desc)
    desc = html.unescape(desc).replace("\r", "")
    return [(" ".join(i.split()), " ".join(o.split())) for i, o in EXAMPLE.findall(desc)]


def split_assignments(s):
    """'nums = [2,7], target = 9' -> ['[2,7]', '9'] (values in order)."""
    hits = []
    for m in re.finditer(r"(?:(?<=^)|(?<=[\s,]))([A-Za-z_]\w*)\s*=\s*", s):
        if s[:m.start()].count('"') % 2 == 0:
            hits.append(m)
    vals = []
    for i, m in enumerate(hits):
        end = hits[i + 1].start() if i + 1 < len(hits) else len(s)
        vals.append(s[m.end():end].strip().rstrip(",").strip())
    return vals


# ------------------------------------------------------- java literal gen
def lit(v, t):
    t = t.replace(" ", "")
    if t.endswith("[]"):
        if v is None:
            return "null"
        if not isinstance(v, list):
            raise ValueError("array expected")
        return f"new {t}{{" + ", ".join(lit(x, t[:-2]) for x in v) + "}"
    m = re.fullmatch(r"(?:java\.util\.)?List<(.+)>", t)
    if m:
        if v is None:
            return "null"
        if not isinstance(v, list):
            raise ValueError("list expected")
        return "_tcL(" + ", ".join(lit(x, m.group(1)) for x in v) + ")"
    if v is None and t[0].isupper():
        return "null"
    if t in ("int", "Integer"):
        if isinstance(v, int) and not isinstance(v, bool) and -2**31 <= v < 2**31:
            return str(v)
    elif t in ("long", "Long"):
        if isinstance(v, int) and not isinstance(v, bool):
            return f"{v}L"
    elif t in ("double", "Double"):
        if isinstance(v, (int, float)) and not isinstance(v, bool):
            return repr(float(v))
    elif t == "float":
        if isinstance(v, (int, float)) and not isinstance(v, bool):
            return repr(float(v)) + "f"
    elif t in ("boolean", "Boolean"):
        if isinstance(v, bool):
            return "true" if v else "false"
    elif t in ("char", "Character"):
        if isinstance(v, str) and len(v) == 1:
            c = {"'": "\\'", "\\": "\\\\", "\n": "\\n"}.get(v, v)
            return f"'{c}'"
    elif t == "String":
        if isinstance(v, str):
            return json.dumps(v, ensure_ascii=True)
    raise ValueError(f"unsupported {t}")


def jload(s):
    return json.loads(s)


# ------------------------------------------------------- java source work
def class_span(text, name="Solution"):
    """(start, closing_brace_index) of top-level class `name`, or None."""
    m = re.search(rf"\bclass\s+{name}\b[^{{;]*\{{", text)
    if not m:
        return None
    i, depth, n = m.end() - 1, 0, len(text)
    while i < n:
        c = text[i]
        if text.startswith("//", i):
            i = text.find("\n", i)
            if i < 0:
                return None
            continue
        if text.startswith("/*", i):
            i = text.find("*/", i + 2)
            if i < 0:
                return None
            i += 2
            continue
        if c in "\"'":
            q = c
            i += 1
            while i < n and text[i] != q:
                i += 2 if text[i] == "\\" else 1
        elif c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
            if depth == 0:
                return m.start(), i
        i += 1
    return None


def split_params(s):
    out, depth, cur = [], 0, ""
    for ch in s:
        if ch == "<":
            depth += 1
        elif ch == ">":
            depth -= 1
        if ch == "," and depth == 0:
            out.append(cur)
            cur = ""
        else:
            cur += ch
    if cur.strip():
        out.append(cur)
    res = []
    for p in out:
        p = re.sub(r"\bfinal\b", "", p).strip()
        t, _, name = p.rpartition(" ")
        res.append((t.strip(), name.strip()))
    return res


SIG = re.compile(
    r"(?m)^\s*public\s+((?:static\s+|final\s+)*)([\w.<>\[\],? ]+?)\s+(\w+)\s*\(([^)]*)\)"
    r"\s*(?:throws\s+[\w., ]+)?\{")


def find_method(body):
    for m in SIG.finditer(body):
        if "static" in m.group(1) or m.group(3) == "main":
            continue
        return m.group(2).strip(), m.group(3), split_params(m.group(4))
    return None


HELPERS = '''
    // ===== Generated test cases (from the problem examples) =====
    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    private static String _tcStr(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    private static int _tcFailed = 0;

    private static void _tcCheck(int n, java.util.concurrent.Callable<Object> run, Object exp) {
        try {
            Object got = run.call();
            boolean ok = java.util.Objects.deepEquals(got, exp);
            if (!ok && got instanceof Double && exp instanceof Double) {
                ok = Math.abs((Double) got - (Double) exp) < 1e-5;
            }
            if (ok) {
                System.out.println("PASS test " + n);
            } else {
                _tcFailed++;
                System.out.println("FAIL test " + n + ": got " + _tcStr(got) + ", expected " + _tcStr(exp));
            }
        } catch (Throwable e) {
            _tcFailed++;
            System.out.println("ERROR test " + n + ": " + e);
        }
    }
'''


def build_tests(sig, examples):
    ret, name, params = sig
    calls = []
    for inp, outp in examples:
        try:
            vals = [jload(v) for v in split_assignments(inp)]
            if len(vals) != len(params):
                raise ValueError("arg count")
            decl = [f"{t} p{i} = {lit(v, t)};" for i, ((t, _), v) in enumerate(zip(params, vals))]
            args = ", ".join(f"p{i}" for i in range(len(params)))
            if ret == "void":
                if not params or not params[0][0].endswith("[]"):
                    raise ValueError("void without array")
                exp = lit(jload(outp), params[0][0])
                body = " ".join(decl) + f" new Solution().{name}({args}); return p0;"
            else:
                exp = lit(jload(outp), ret)
                body = " ".join(decl) + f" return new Solution().{name}({args});"
            calls.append(f"        _tcCheck({len(calls) + 1}, () -> {{ {body} }}, {exp});")
        except (ValueError, json.JSONDecodeError):
            continue
    if not calls:
        return None
    main = ("\n    public static void main(String[] args) {\n"
            + "\n".join(calls)
            + "\n        System.out.println(_tcFailed == 0 ? \"All tests passed\" : _tcFailed + \" test(s) failed\");"
            + "\n        if (_tcFailed > 0) System.exit(1);\n    }\n")
    return HELPERS + main, len(calls)


def add_tests(java_text, examples):
    """-> (new_text, n_tests) or (None, reason)."""
    if MARK in java_text:
        return None, "already has tests"
    if re.search(r"static\s+void\s+main\s*\(", java_text):
        return None, "already has main"
    span = class_span(java_text)
    if not span:
        return None, "no class Solution"
    start, end = span
    sig = find_method(java_text[start:end])
    if not sig:
        return None, "no public instance method"
    if not examples:
        return None, "no examples found"
    built = build_tests(sig, examples)
    if not built:
        return None, f"unsupported types ({sig[0]} {sig[1]}(...))"
    block, n = built
    return java_text[:end] + block + java_text[end:], n


# -------------------------------------------------------------------- main
FILE_RE = re.compile(r"^(\d{4})-(.+?)(?: \([^)]*\))?\.java$")


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("markdown", help="path to categorized_problems.md (for exact problem titles)")
    ap.add_argument("--src", default="java_solutions", help="folder with downloaded solutions")
    ap.add_argument("--out", default="java_with_tests", help="output folder (ignored with --inplace)")
    ap.add_argument("--inplace", action="store_true")
    ap.add_argument("--only", nargs="+", type=int, help="only these problem IDs")
    ap.add_argument("--cache", default=".readme_cache")
    ap.add_argument("--workers", type=int, default=8)
    args = ap.parse_args()

    titles = parse_titles(args.markdown)
    files = []
    for root, _, names in os.walk(args.src):
        for fn in names:
            m = FILE_RE.match(fn)
            if m and (not args.only or int(m.group(1)) in args.only):
                files.append((int(m.group(1)), os.path.join(root, fn)))
    files.sort()
    print(f"{len(files)} Java files found in {args.src}", flush=True)

    ids = sorted({pid for pid, _ in files})

    def load(pid):
        try:
            return pid, get_readme(pid, titles.get(pid, ""), args.cache)
        except Exception as e:
            print(f"  ! {pid}: {e}", file=sys.stderr, flush=True)
            return pid, None

    readmes = {}
    with ThreadPoolExecutor(max_workers=args.workers) as ex:
        for i, (pid, txt) in enumerate(ex.map(load, ids), 1):
            readmes[pid] = txt
            if i % 200 == 0:
                print(f"  fetched {i}/{len(ids)} problem pages...", flush=True)

    done, skipped, reasons = 0, [], Counter()
    for pid, path in files:
        dest = path if args.inplace else os.path.join(args.out, os.path.relpath(path, args.src))
        with open(path, encoding="utf-8") as f:
            text = f.read()
        readme = readmes.get(pid)
        examples = extract_examples(readme) if readme else []
        new, info = add_tests(text, examples)
        if new is None:
            reason = info if readme else "problem page not found"
            skipped.append((path, reason))
            reasons[reason.split(" (")[0]] += 1
            if not args.inplace:  # keep the plain solution in the output tree too
                os.makedirs(os.path.dirname(dest), exist_ok=True)
                shutil.copyfile(path, dest)
            continue
        os.makedirs(os.path.dirname(dest), exist_ok=True)
        with open(dest, "w", encoding="utf-8", newline="\n") as f:
            f.write(new)
        done += 1

    print(f"\nDone. Tests added to {done} files; {len(skipped)} left without tests.")
    for r, c in reasons.most_common():
        print(f"   {c:5d}  {r}")
    if skipped:
        report = os.path.join(args.src if args.inplace else args.out, "_skipped.txt")
        os.makedirs(os.path.dirname(report), exist_ok=True)
        with open(report, "w", encoding="utf-8") as f:
            for p, r in skipped:
                f.write(f"{r}\t{p}\n")
        print(f"Skipped list: {report}")


if __name__ == "__main__":
    main()
