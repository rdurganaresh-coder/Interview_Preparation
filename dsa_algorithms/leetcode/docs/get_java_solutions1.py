#!/usr/bin/env python3
r"""
Download Java solutions for every problem in categorized_problems.md AND add
test cases to each one. Running a downloaded file prints the Input, the
solution's Output and the Expected value for every example of the problem.

Source: the public GitHub repo doocs/leetcode
(solution/<range>/<id>.<Title>/Solution.java + README_EN.md with the examples).

Files are grouped into one sub-folder per category (trees_tries,
dynamic_programming, strings, ...) inside the output folder, named like
0035_Search_Insert_Position.java. Use --flat to put everything in the output
folder itself. The output folder can be a Maven/Gradle source folder such as
src/main/java/com/leetcode .

For every file the script also:
  * adds a package line: base package taken from the output path when it contains
    src/main/java/... (or from --package), plus the category, e.g.
    com.leetcode.dynamic_programming  (with --flat just com.leetcode),
  * renames each top-level class with the problem number (Solution -> Solution0035,
    UnionFind -> UnionFind0035, ...) so hundreds of files can live in the same
    package without "duplicate class" errors.

Usage (Windows example):
    python get_java_solutions.py "D:\path\categorized_problems.md" -o "D:\proj\src\main\java\com\leetcode"
    python get_java_solutions.py list.md -o out --only 1 44 283   # try a few problems
    python get_java_solutions.py list.md -o out --no-tests        # solutions only
    python get_java_solutions.py list.md -o out --flat            # no category folders
    python get_java_solutions.py list.md -o out --no-package      # no package line

Existing files are never touched (so your own edits are safe). Add --overwrite
only if you really want to replace them.

Run a downloaded file (JDK 11+), or press "Run" above main() in VS Code:
    java "src\main\java\com\leetcode\0044_Wildcard_Matching.java"

Test cases are added when the method uses int/long/double/boolean/char/String,
arrays of those, or List<...> of those. Problems with TreeNode, ListNode, Node,
Map or design-style classes get the plain solution (listed in _no_tests.txt).

If you hit "HTTP 403 rate limit exceeded", the script falls back automatically
to raw.githubusercontent.com. Optionally set GITHUB_TOKEN to use the faster
API mode (cmd: set GITHUB_TOKEN=xxx / PowerShell: $env:GITHUB_TOKEN="xxx").

Only needs the standard library.
"""
import argparse
import html
import json
import os
import re
import sys
import time
import urllib.error
import urllib.parse
import urllib.request
from concurrent.futures import ThreadPoolExecutor

REPO = "doocs/leetcode"
BRANCH = "main"
API = f"https://api.github.com/repos/{REPO}"
RAW = f"https://raw.githubusercontent.com/{REPO}/{BRANCH}"
MAX_APPROACHES = 12  # fallback mode probes Solution.java, Solution2.java, ...
MARK = "// ===== Generated test cases"


def log(*a):
    print(*a, file=sys.stderr, flush=True)


# ----------------------------------------------------------------- parsing
def parse_problems(md_path):
    """Return list of (id, title, category) from the markdown tables."""
    category = "Uncategorized"
    problems, seen = [], set()
    h2 = re.compile(r"^##\s+(?!#)(.+?)\s*\(\d+\)\s*$")
    row = re.compile(r"^\|\s*(\d+)\s*\|\s*(.+?)\s*\|")
    with open(md_path, encoding="utf-8") as f:
        for line in f:
            line = line.rstrip("\r\n")
            m = h2.match(line)
            if m and "Table of Contents" not in line:
                category = m.group(1).strip()
                continue
            m = row.match(line)
            if m:
                pid = int(m.group(1))
                if pid in seen:
                    continue
                seen.add(pid)
                problems.append((pid, m.group(2).strip(), category))
    return problems


# ------------------------------------------------------------------ http
class RateLimited(Exception):
    pass


def _headers():
    h = {"User-Agent": "java-solution-fetcher", "Accept": "application/vnd.github+json"}
    tok = os.environ.get("GITHUB_TOKEN")
    if tok:
        h["Authorization"] = f"Bearer {tok}"
    return h


def _get(url, headers=None, retries=3):
    """Return bytes, or None on 404. Raises RateLimited on 403/429."""
    for attempt in range(retries):
        try:
            req = urllib.request.Request(url, headers=headers or {"User-Agent": "java-solution-fetcher"})
            with urllib.request.urlopen(req, timeout=30) as r:
                return r.read()
        except urllib.error.HTTPError as e:
            if e.code == 404:
                return None
            if e.code in (403, 429):
                raise RateLimited(url)
            if attempt == retries - 1:
                raise
        except Exception:
            if attempt == retries - 1:
                raise
        time.sleep(1.5 * (attempt + 1))


def api_json(path):
    data = _get(f"{API}{path}", _headers())
    if data is None:
        raise RuntimeError(f"Not found: {path}")
    return json.loads(data)


def raw_url(path):
    return f"{RAW}/{urllib.parse.quote(path)}"


# ----------------------------------------------------------- mode 1: API
def build_index():
    """Map problem id -> list of repo paths to .java files (uses GitHub API)."""
    top = api_json(f"/git/trees/{BRANCH}:solution")
    index = {}
    for ent in top["tree"]:
        if ent["type"] != "tree":
            continue
        sub = api_json(f"/git/trees/{ent['sha']}?recursive=1")
        for item in sub["tree"]:
            if item["type"] != "blob" or not item["path"].endswith(".java"):
                continue
            folder = item["path"].split("/")[0]
            m = re.match(r"(\d+)\.", folder)
            if m:
                index.setdefault(int(m.group(1)), []).append(
                    f"solution/{ent['path']}/{item['path']}")
        log(f"  indexed {ent['path']}")
    return index


# ------------------------------------------------------ fetching a problem
def guess_folder(pid, title):
    lo = pid // 100 * 100
    return f"solution/{lo:04d}-{lo + 99:04d}/{pid:04d}.{title}"


def fetch_solutions(pid, title, index):
    """-> (repo_folder, [(file_name, text)]) using the index or by probing raw URLs."""
    if index is not None:
        paths = sorted(index.get(pid, []))
        if not paths:
            return None, []
        out = []
        for p in paths:
            data = _get(raw_url(p))
            if data:
                out.append((os.path.basename(p), data.decode("utf-8", "replace")))
        return os.path.dirname(paths[0]), out
    folder = guess_folder(pid, title)
    out = []
    for n in range(1, MAX_APPROACHES + 1):
        name = "Solution.java" if n == 1 else f"Solution{n}.java"
        data = _get(raw_url(f"{folder}/{name}"))
        if data is None:
            break
        out.append((name, data.decode("utf-8", "replace")))
    return folder, out


# ================================================================ test cases
EXAMPLE = re.compile(
    r"Input:\s*(.*?)\s*Output:\s*(.*?)\s*(?=Explanation:|Example\s*\d|Constraints:|Input:|\n\s*\n|\Z)", re.S)


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


def lit(v, t):
    """Python (JSON) value -> Java literal of type t. Raises ValueError if unsupported."""
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


def class_span(text, name="Solution"):
    """(start, index of closing brace) of top-level class `name`, or None."""
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
    r"(?m)(?:^|(?<=[{};]))\s*public\s+((?:static\s+|final\s+)*)([\w.<>\[\],? ]+?)\s+(\w+)\s*\(([^)]*)\)"
    r"\s*(?:throws\s+[\w., ]+)?\{")


def find_method(body):
    for m in SIG.finditer(body):
        if "static" in m.group(1) or m.group(3) == "main":
            continue
        return m.group(2).strip(), m.group(3), split_params(m.group(4))
    return None


HELPER_SHOW = '''
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }
'''

HELPER_LIST = '''
    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }
'''


def jstr(s):
    return json.dumps(s, ensure_ascii=True)


def build_tests(sig, examples, cls):
    """-> (java_block, number_of_tests) or None."""
    ret, name, params = sig
    tests = []
    for inp, outp in examples:
        try:
            vals = [json.loads(v) for v in split_assignments(inp)]
            if len(vals) != len(params):
                raise ValueError("arg count")
            decl = [f"{t} {n} = {lit(v, t)};" for (t, n), v in zip(params, vals)]
            call = f"_tcSol.{name}({', '.join(n for _, n in params)})"
            if ret == "void":
                if not params or not params[0][0].endswith("[]"):
                    raise ValueError("void without array")
                json.loads(outp)  # make sure expected is parseable
                body = "\n".join(decl) + f"\n{call};\nSystem.out.println(\"  Output  : \" + _tcShow({params[0][1]}));"
            else:
                lit(json.loads(outp), ret)  # type-check the expected value
                body = "\n".join(decl) + f"\nSystem.out.println(\"  Output  : \" + _tcShow({call}));"
        except (ValueError, json.JSONDecodeError):
            continue
        k = len(tests) + 1
        body = "\n".join("            " + ln for ln in body.split("\n"))
        tests.append(
            f'        System.out.println("Test {k}");\n'
            f'        System.out.println("  Input   : " + {jstr(inp)});\n'
            f"        try {{\n{body}\n"
            f"        }} catch (Throwable e) {{\n"
            f'            System.out.println("  Output  : ERROR " + e);\n'
            f"        }}\n"
            f'        System.out.println("  Expected: " + {jstr(outp)});\n'
            f"        System.out.println();\n")
    if not tests:
        return None
    main = ("\n    public static void main(String[] args) {\n"
            f"        {cls} _tcSol = new {cls}();\n"
            + "\n".join(tests) + "    }\n")
    block = f"\n    {MARK} (from the problem examples) =====" + HELPER_SHOW
    if "_tcL(" in main:
        block += HELPER_LIST
    return block + main, len(tests)


def add_tests(java_text, examples, cls="Solution"):
    """-> (new_text, None) on success, or (None, reason)."""
    if MARK in java_text:
        return None, "already has tests"
    if re.search(r"static\s+void\s+main\s*\(", java_text):
        return None, "already has main"
    span = class_span(java_text, cls)
    if not span:
        return None, "no class Solution"
    start, end = span
    sig = find_method(java_text[start:end])
    if not sig:
        return None, "no public instance method"
    if not examples:
        return None, "no examples found"
    built = build_tests(sig, examples, cls)
    if not built:
        return None, f"unsupported types ({sig[0]} {sig[1]}(...))"
    return java_text[:end] + built[0] + java_text[end:], None


# ------------------------------------------------- naming / package / classes
def blank(text):
    """Replace comments, strings and char literals by spaces (keeps offsets and newlines)."""
    out, i, n = list(text), 0, len(text)

    def wipe(a, b):
        for k in range(a, b):
            if out[k] != "\n":
                out[k] = " "

    while i < n:
        if text.startswith("//", i):
            j = text.find("\n", i)
            j = n if j < 0 else j
            wipe(i, j)
            i = j
        elif text.startswith("/*", i):
            j = text.find("*/", i + 2)
            j = n if j < 0 else j + 2
            wipe(i, j)
            i = j
        elif text[i] in "\"'":
            q, j = text[i], i + 1
            while j < n and text[j] != q:
                j += 2 if text[j] == "\\" else 1
            j = min(j + 1, n)
            wipe(i, j)
            i = j
        else:
            i += 1
    return "".join(out)


TYPE_DECL = re.compile(r"\b(?:class|interface|enum|record)\s+([A-Za-z_]\w*)")


def top_level_types(text):
    """Names of the top-level classes / interfaces / enums / records in a file."""
    b = blank(text)
    depth_at, d = [], 0
    for ch in b:
        depth_at.append(d)
        if ch == "{":
            d += 1
        elif ch == "}":
            d -= 1
    names = []
    for m in TYPE_DECL.finditer(b):
        if depth_at[m.start()] == 0 and not b[:m.start()].rstrip().endswith("."):
            names.append(m.group(1))
    return names


def rename_types(text, tag):
    """Append `tag` to every top-level type so files don't clash in one package.
    -> (new_text, {old_name: new_name})"""
    text = re.sub(r"(?m)^public\s+((?:abstract\s+|final\s+)*(?:class|interface|enum|record)\b)", r"\1", text)
    names = list(dict.fromkeys(top_level_types(text)))
    if not names:
        return text, {}
    mapping = {n: f"{n}{tag}" for n in names}
    pat = re.compile(r"\b(" + "|".join(map(re.escape, names)) + r")\b")
    return pat.sub(lambda m: mapping[m.group(1)], text), mapping


def infer_package(out_dir):
    """com.leetcode for .../src/main/java/com/leetcode ; None if not inside src/main/java."""
    parts = os.path.abspath(out_dir).replace("\\", "/").split("/")
    for i in range(len(parts) - 2):
        if parts[i:i + 3] == ["src", "main", "java"]:
            return ".".join(parts[i + 3:])
    return None


def slug(title):
    return re.sub(r"[^A-Za-z0-9]+", "_", title).strip("_")


def approach_of(file_name):
    """'Solution.java' -> '' ; 'Solution2.java' -> '2'"""
    stem = file_name[:-len(".java")]
    m = re.fullmatch(r"Solution(\d*)", stem)
    return m.group(1) if m else re.sub(r"\W+", "_", stem)


def out_name(pid, title, approach=""):
    return f"{pid:04d}_{slug(title)}" + (f"_{approach}" if approach else "") + ".java"


# -------------------------------------------------------------------- main
def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("markdown", help="path to categorized_problems.md")
    ap.add_argument("-o", "--out", default="java_solutions")
    ap.add_argument("--package", help="Java package line to add (default: taken from the "
                    "output path if it contains src/main/java/..., else none)")
    ap.add_argument("--flat", action="store_true", help="don't create category sub-folders")
    ap.add_argument("--no-package", action="store_true", help="don't add a package line")
    ap.add_argument("--no-tests", action="store_true", help="download solutions without test cases")
    ap.add_argument("--overwrite", action="store_true",
                    help="replace files that already exist (this overwrites your own edits!)")
    ap.add_argument("--only", nargs="+", type=int, help="only these problem IDs (for testing)")
    ap.add_argument("--workers", type=int, default=8)
    args = ap.parse_args()

    problems = parse_problems(args.markdown)
    if args.only:
        problems = [p for p in problems if p[0] in set(args.only)]
    print(f"Parsed {len(problems)} problems from {args.markdown}", flush=True)

    base_pkg = None if args.no_package else (args.package if args.package is not None
                                             else infer_package(args.out))
    print(f"Output folder: {os.path.abspath(args.out)}  |  base package: {base_pkg or '(none)'}"
          f"  |  {'flat' if args.flat else 'one folder per category'}", flush=True)

    def cat_slug(cat):
        return re.sub(r"[^a-z0-9]+", "_", cat.lower()).strip("_")

    def base_for(cat):
        return args.out if args.flat else os.path.join(args.out, cat_slug(cat))

    def package_for(cat):
        if not base_pkg:
            return None
        return base_pkg if args.flat else f"{base_pkg}.{cat_slug(cat)}"

    # try the API index first; fall back to raw URL probing when rate limited
    index = None
    print("Indexing Java files in the solutions repo...", flush=True)
    try:
        index = build_index()
    except RateLimited:
        log("\nGitHub API rate limit hit -> switching to raw-download mode "
            "(slower, matches by problem title). Set GITHUB_TOKEN to avoid this.\n")

    def work(p):
        pid, title, cat = p
        try:
            # resume support: skip problems whose main file already exists
            first = os.path.join(base_for(cat), out_name(pid, title))
            if os.path.exists(first) and not args.overwrite:
                return p, "exists", [], None
            folder, files = fetch_solutions(pid, title, index)
            if not files:
                return p, "missing", [], None
            examples, why = [], None
            if not args.no_tests:
                readme = _get(raw_url(f"{folder}/README_EN.md"))
                if readme is None:
                    why = "problem page not found"
                else:
                    examples = extract_examples(readme.decode("utf-8", "replace"))
            results = []
            for name, text in files:
                ap_ = approach_of(name)
                tag = f"{pid:04d}" + (f"_{ap_}" if ap_ else "")
                text, mapping = rename_types(text, tag)
                reason = why
                if not args.no_tests and not why:
                    cls = mapping.get("Solution")
                    if cls is None:
                        reason = "no class Solution"
                    else:
                        new, reason = add_tests(text, examples, cls)
                        if new is not None:
                            text = new
                if package_for(cat):
                    text = f"package {package_for(cat)};\n\n" + text
                results.append((out_name(pid, title, ap_), text, reason))
            return p, "ok", results, None
        except Exception as e:
            return p, "error", [], str(e)

    found = tested = plain = 0
    missing, no_tests, errors = [], [], []
    with ThreadPoolExecutor(max_workers=args.workers) as ex:
        for i, (p, status, results, err) in enumerate(ex.map(work, problems), 1):
            pid, title, cat = p
            if status == "missing":
                missing.append(p)
            elif status == "error":
                errors.append((p, err))
                log(f"  ! {pid} {title}: {err}")
            elif status == "ok":
                found += 1
                os.makedirs(base_for(cat), exist_ok=True)
                for fname, text, reason in results:
                    dest = os.path.join(base_for(cat), fname)
                    if os.path.exists(dest) and not args.overwrite:
                        continue  # never clobber the user's own files
                    with open(dest, "w", encoding="utf-8", newline="\n") as f:
                        f.write(text)
                    if reason is None and not args.no_tests:
                        tested += 1
                    elif not args.no_tests:
                        plain += 1
                        no_tests.append((fname, reason))
            if i % 100 == 0:
                print(f"  {i}/{len(problems)} processed...", flush=True)

    print(f"\nDone. {found} problems downloaded: {tested} files with test cases, "
          f"{plain} without; {len(missing)} problems have no Java solution"
          + (f"; {len(errors)} errors (re-run to retry)." if errors else "."))
    os.makedirs(args.out, exist_ok=True)
    if missing:
        with open(os.path.join(args.out, "_missing.txt"), "w", encoding="utf-8") as f:
            for pid, title, cat in missing:
                f.write(f"{pid}\t{title}\t{cat}\n")
        print(f"Problems without Java solutions: {os.path.join(args.out, '_missing.txt')} (SQL is expected here)")
    if no_tests:
        with open(os.path.join(args.out, "_no_tests.txt"), "w", encoding="utf-8") as f:
            for fname, reason in no_tests:
                f.write(f"{reason}\t{fname}\n")
        print(f"Files without test cases: {os.path.join(args.out, '_no_tests.txt')}")


if __name__ == "__main__":
    main()