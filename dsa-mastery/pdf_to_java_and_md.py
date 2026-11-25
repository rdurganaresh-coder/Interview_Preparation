import os
import re
import json
import time
from pathlib import Path
from pypdf import PdfReader

ROOT_DIR = Path(".")
SOURCE_DOCS_DIR = ROOT_DIR / "docs"

# Maps topic keywords to (module_folder, java_subpackage)
MODULE_ROUTES = [
    (("linked list", "skip list", "lru", "lfu", "xor"), ("linked-lists", "linkedlists")),
    (("stack", "queue", "deque", "spaghetti"), ("stacks-queues", "stacksqueues")),
    (("tree", "trie", "heap", "graph", "fenwick", "segment", "avl", "red-black", "red black", "splay", "treap", "b-tree", "dimensional"), ("trees-graphs", "trees")),
    (("array", "string", "suffix", "anagram", "matrix", "hash", "bloom", "palindrom"), ("arrays-strings", "arrays")),
    (("sort", "search", "divide"), ("sorting-searching", "sorting")),
    (("dp", "dynamic", "knapsack", "recursion", "backtrack", "greedy"), ("dynamic-programming", "dp")),
]

GENERAL_ROOT_DOCS = {"dsa", "analysis-of-algorithms", "advanced-data-structures"}

CODE_PREFIXES = (
    "#include", "#define", "using namespace", "typedef ", "struct ",
    "public ", "private ", "protected ", "class ", "interface ",
    "void ", "int ", "long ", "boolean ", "bool ", "char ", "String ", "unsigned ",
    "import ", "package ", "if (", "if(", "else", "for (", "for(", "while (", "while(",
    "return ", "new ", "delete ", "printf", "cout", "System.out"
)


def slugify(text: str) -> str:
    return re.sub(r"[\s_]+", "-", re.sub(r"[^\w\s-]", "", text.lower())).strip("-")


def to_pascal_case(title: str) -> str:
    clean = re.sub(r"\|.*|\(.*?\)|Set\s*\d+|Part\s*\d+", "", title)
    words = re.findall(r"[A-Za-z0-9]+", clean)
    name = "".join(w.capitalize() for w in words[:4]) or "AlgorithmSolution"
    return f"Algo{name}" if name.isdigit() else name


def resolve_module(topic_title: str, pdf_stem: str) -> tuple[str, str]:
    lowered = f"{topic_title} {pdf_stem}".lower()
    for keywords, target in MODULE_ROUTES:
        if any(k in lowered for k in keywords):
            return target
    return "math-and-misc-algorithms", "misc"


def resolve_md_destination(pdf_path: Path) -> Path:
    clean_slug = slugify(pdf_path.stem)
    if clean_slug in GENERAL_ROOT_DOCS:
        return SOURCE_DOCS_DIR / f"{clean_slug}.md"
    module_name, _ = resolve_module(pdf_path.stem, pdf_path.stem)
    target_docs = ROOT_DIR / module_name / "docs"
    target_docs.mkdir(parents=True, exist_ok=True)
    return target_docs / f"{clean_slug}.md"


def cpp_to_java_heuristic(code: str, class_name: str, pkg_name: str) -> str:
    lines = []
    for line in code.splitlines():
        s = line.strip()
        if s.startswith(("#include", "#define", "using namespace", "typedef ")):
            continue
        line = re.sub(r"\bbool\b", "boolean", line)
        line = re.sub(r"\bNULL\b|\bnullptr\b", "null", line)
        line = re.sub(r"\bstruct\s+(\w+)", r"static class \1", line)
        line = re.sub(r"(\w+)\s*->\s*", r"\1.", line)
        line = re.sub(r"\bprintf\s*\(", "System.out.printf(", line)
        line = re.sub(r"cout\s*<<\s*(.*?)\s*<<\s*endl\s*;", r"System.out.println(\1);", line)
        line = re.sub(r"cout\s*<<\s*(.*?)\s*;", r"System.out.print(\1);", line)
        lines.append("    " + line)

    body = "\n".join(lines).strip()
    return (
        f"package com.dsamastery.{pkg_name};\n\n"
        f"import java.util.*;\n\n"
        f"public class {class_name} {{\n\n"
        f"    {body}\n"
        f"}}\n"
    )


def translate_with_gemini(title: str, raw_text: str, pkg_name: str, class_name: str) -> dict | None:
    api_key = os.environ.get("GEMINI_API_KEY")
    if not api_key:
        return None
    try:
        from google import genai
        client = genai.Client(api_key=api_key)
        prompt = (
            f"Convert this DSA chapter into:\n"
            f"1. A complete, compilable Java 17 class named `{class_name}` in package `com.dsamastery.{pkg_name}` "
            f"(translate any C/C++ pointer code into idiomatic Java 17).\n"
            f"2. Clean Markdown documentation for the chapter (fix broken PDF line wraps and include the Java code block).\n"
            f"Return strictly valid JSON with keys: `java_code` and `markdown`.\n\n"
            f"Chapter Title: {title}\n\nRaw Text:\n{raw_text[:12000]}"
        )
        resp = client.models.generate_content(
            model="gemini-2.5-flash",
            contents=prompt,
            config={"response_mime_type": "application/json"}
        )
        time.sleep(2)  # Avoid free-tier rate limit bursts
        return json.loads(resp.text)
    except Exception as e:
        print(f"  [Offline fallback for '{title}': {e}]")
        return None


def parse_chapter_offline(raw_text: str) -> tuple[str, str]:
    lines = raw_text.splitlines()
    out_lines = []
    code_buffer = []
    extracted_code = []
    in_block_comment = False
    brace_depth = 0

    def flush_code():
        nonlocal brace_depth
        if code_buffer:
            while code_buffer and code_buffer[-1].strip() == "":
                code_buffer.pop()
            if code_buffer:
                extracted_code.extend(code_buffer)
                out_lines.append("\n```java")
                out_lines.extend(code_buffer)
                out_lines.append("```\n")
            code_buffer.clear()
        brace_depth = 0

    for line in lines:
        stripped = line.strip()
        if stripped.isdigit() or stripped.startswith(("Post navigation", "Writing code in comment?", "← ", "→ ")):
            continue
        if not code_buffer and stripped.startswith(("http://", "https://")):
            out_lines.append(f"- [Reference Link]({stripped})")
            continue

        opens_comment = "/*" in stripped and "*/" not in stripped
        closes_comment = "*/" in stripped
        looks_like_code = (
            in_block_comment or opens_comment or closes_comment or brace_depth > 0
            or stripped.startswith(CODE_PREFIXES)
            or stripped.startswith(("//", "@Override"))
            or stripped.endswith((";", "{", "}", "\\"))
            or bool(re.match(r"^[A-Za-z_][\w<>\[\]*\s]+\([^)]*\)\s*\{?$", stripped))
        )

        if code_buffer and stripped == "":
            code_buffer.append("")
            continue

        if looks_like_code:
            code_buffer.append(line)
            if opens_comment:
                in_block_comment = True
            if closes_comment:
                in_block_comment = False
            brace_depth = max(0, brace_depth + stripped.count("{") - stripped.count("}"))
        else:
            flush_code()
            if stripped in ("Output:", "Examples:", "Example:", "Solution", "Source", "References:"):
                out_lines.append(f"\n### {stripped.rstrip(':')}\n")
            else:
                out_lines.append(line)

    flush_code()

    merged = []
    in_fence = False
    for line in out_lines:
        s = line.strip()
        if s.startswith("```"):
            in_fence = not in_fence
            merged.append(line)
            continue
        if in_fence or not s or s.startswith(("#", "-", "*", ">", "|")):
            merged.append(line)
        elif (
            merged and merged[-1].strip()
            and not merged[-1].strip().startswith(("#", "-", "*", ">", "|", "```"))
            and not merged[-1].strip().endswith((".", ":", "?", "!", ";"))
        ):
            merged[-1] = merged[-1].rstrip() + " " + s
        else:
            merged.append(line)

    return re.sub(r"\n{3,}", "\n\n", "\n".join(merged)).strip(), "\n".join(extracted_code)


def write_java_file(module_name: str, pkg_name: str, class_name: str, java_code: str) -> Path:
    target_dir = ROOT_DIR / module_name / "src" / "main" / "java" / "com" / "dsamastery" / pkg_name
    target_dir.mkdir(parents=True, exist_ok=True)
    java_path = target_dir / f"{class_name}.java"
    counter = 2
    while java_path.exists():
        java_path = target_dir / f"{class_name}{counter}.java"
        counter += 1
    java_path.write_text(java_code, encoding="utf-8")
    return java_path


def process_pdf(pdf_path: Path):
    md_path = resolve_md_destination(pdf_path)
    if md_path.exists():
        print(f"Skipping (already converted): {md_path}")
        return

    print(f"Reading: {pdf_path} ...")
    reader = PdfReader(str(pdf_path))
    pages = [re.sub(r"\n\d+\s*$", "", p.extract_text() or "") for p in reader.pages]
    combined = "\n".join(pages)
    chapters = re.split(r"(?m)^Chapter\s+(\d+)\s*\n+([^\n]+)", combined)

    rel_pdf = Path(os.path.relpath(pdf_path, md_path.parent)).as_posix()
    title = pdf_path.stem.replace("-", " ").title()

    if len(chapters) > 1:
        toc = ["## Table of Contents\n"]
        sections = []

        for i in range(1, len(chapters), 3):
            chap_num = chapters[i].strip()
            chap_title = chapters[i + 1].strip()
            chap_body = chapters[i + 2]

            heading = f"Chapter {chap_num}: {chap_title}"
            toc.append(f"- [{heading}](#{slugify(heading)})")
            print(f"  -> Processing {heading}")

            module_name, pkg_name = resolve_module(chap_title, pdf_path.stem)
            class_name = to_pascal_case(chap_title)

            ai_result = translate_with_gemini(chap_title, chap_body, pkg_name, class_name)
            if ai_result and ai_result.get("java_code"):
                java_code = ai_result["java_code"]
                chap_md = ai_result["markdown"]
            else:
                chap_md, raw_code = parse_chapter_offline(chap_body)
                java_code = cpp_to_java_heuristic(raw_code, class_name, pkg_name) if raw_code.strip() else ""

            java_link_line = ""
            if java_code.strip():
                saved_java = write_java_file(module_name, pkg_name, class_name, java_code)
                rel_java = Path(os.path.relpath(saved_java, md_path.parent)).as_posix()
                java_link_line = f"> **Java Implementation:** [`{saved_java.name}`]({rel_java}) (`{module_name}`)\n\n"

            sections.append(f"## {heading}\n\n{java_link_line}{chap_md}\n\n[↑ Back to Top](#table-of-contents)")

        final_md = (
            f"# {title}\n\n"
            f"> **Original PDF:** [{pdf_path.name}]({rel_pdf})\n\n"
            + "\n".join(toc) + "\n\n---\n\n" + "\n\n---\n\n".join(sections)
        )
    else:
        module_name, pkg_name = resolve_module(title, pdf_path.stem)
        class_name = to_pascal_case(title)
        ai_result = translate_with_gemini(title, combined, pkg_name, class_name)
        if ai_result and ai_result.get("java_code"):
            java_code = ai_result["java_code"]
            body_md = ai_result["markdown"]
        else:
            body_md, raw_code = parse_chapter_offline(combined)
            java_code = cpp_to_java_heuristic(raw_code, class_name, pkg_name) if raw_code.strip() else ""

        java_link_line = ""
        if java_code.strip():
            saved_java = write_java_file(module_name, pkg_name, class_name, java_code)
            rel_java = Path(os.path.relpath(saved_java, md_path.parent)).as_posix()
            java_link_line = f"> **Java Implementation:** [`{saved_java.name}`]({rel_java}) (`{module_name}`)\n\n"

        final_md = f"# {title}\n\n> **Original PDF:** [{pdf_path.name}]({rel_pdf})\n\n{java_link_line}---\n\n{body_md}"

    md_path.write_text(final_md, encoding="utf-8")
    print(f"Saved MD: {md_path}")


if __name__ == "__main__":
    if not SOURCE_DOCS_DIR.exists():
        print("Error: 'docs' folder not found at project root.")
    else:
        pdfs = list(SOURCE_DOCS_DIR.glob("*.pdf"))
        print(f"Found {len(pdfs)} PDFs in {SOURCE_DOCS_DIR}/")
        for pdf in pdfs:
            process_pdf(pdf)
