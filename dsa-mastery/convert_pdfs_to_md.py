import re
from pathlib import Path
from pypdf import PdfReader

ROOT_DIR = Path(".")

CODE_PREFIXES = (
    "#include", "#define", "using namespace", "typedef ", "struct ",
    "public ", "private ", "protected ", "class ", "interface ",
    "void ", "int ", "long ", "boolean ", "bool ", "char ", "String ", "unsigned ",
    "import ", "package ", "if (", "if(", "else", "for (", "for(", "while (", "while(",
    "return ", "new ", "delete ", "printf", "cout", "System.out", "Node ", "TrieNode",
    "TreeNode", "SegmentTree", "LazySegmentTree"
)

def slugify(text: str) -> str:
    slug = re.sub(r"[^\w\s-]", "", text.lower())
    return re.sub(r"[\s_]+", "-", slug).strip("-")

def detect_language(block_lines: list[str]) -> str:
    joined = "\n".join(block_lines)
    if any(k in joined for k in ("#include", "printf", "cout", "malloc", "struct ", "nullptr", "NULL", "->")):
        return "cpp"
    return "java"

def clean_and_format_chapter(raw_text: str) -> str:
    lines = raw_text.splitlines()
    out_lines = []
    code_buffer = []
    in_block_comment = False
    brace_depth = 0

    def flush_code():
        nonlocal brace_depth
        if code_buffer:
            # Trim trailing blank lines inside code block
            while code_buffer and code_buffer[-1].strip() == "":
                code_buffer.pop()
            if code_buffer:
                lang = detect_language(code_buffer)
                out_lines.append(f"\n```{lang}")
                out_lines.extend(code_buffer)
                out_lines.append("```\n")
            code_buffer.clear()
        brace_depth = 0

    for line in lines:
        stripped = line.strip()

        # Skip standalone page numbers and blog footer clutter
        if stripped.isdigit() or stripped.startswith(("Post navigation", "Writing code in comment?", "← ", "→ ")):
            continue

        # Handle Reference URLs outside code blocks
        if not code_buffer and stripped.startswith(("http://", "https://")):
            out_lines.append(f"- [Reference Link]({stripped})")
            continue

        # Track multi-line /* ... */ comments
        opens_comment = "/*" in stripped and "*/" not in stripped
        closes_comment = "*/" in stripped

        # Check if line looks like code
        looks_like_code = (
            in_block_comment
            or opens_comment
            or closes_comment
            or brace_depth > 0
            or stripped.startswith(CODE_PREFIXES)
            or stripped.startswith(("//", "@Override"))
            or stripped.endswith((";", "{", "}", "\\"))
            or re.match(r"^[A-Za-z_][\w<>\[\]*\s]+\([^)]*\)\s*\{?$", stripped)
        )

        # Keep blank lines inside an active code block instead of splitting it
        if code_buffer and stripped == "":
            code_buffer.append("")
            continue

        if looks_like_code:
            code_buffer.append(line)
            if opens_comment:
                in_block_comment = True
            if closes_comment:
                in_block_comment = False
            brace_depth += stripped.count("{") - stripped.count("}")
            brace_depth = max(0, brace_depth)
        else:
            flush_code()
            if stripped in ("Output:", "Examples:", "Example:", "Solution", "Source", "References:"):
                out_lines.append(f"\n### {stripped.rstrip(':')}\n")
            else:
                out_lines.append(line)

    flush_code()

    # Merge broken prose lines that don't end with punctuation or Markdown syntax
    merged_lines = []
    in_fence = False
    for line in out_lines:
        s = line.strip()
        if s.startswith("```"):
            in_fence = not in_fence
            merged_lines.append(line)
            continue
        if in_fence or not s or s.startswith(("#", "-", "*", ">", "|")):
            merged_lines.append(line)
        elif (
            merged_lines
            and merged_lines[-1].strip()
            and not merged_lines[-1].strip().startswith(("#", "-", "*", ">", "|", "```"))
            and not merged_lines[-1].strip().endswith((".", ":", "?", "!", ";"))
        ):
            merged_lines[-1] = merged_lines[-1].rstrip() + " " + s
        else:
            merged_lines.append(line)

    return re.sub(r"\n{3,}", "\n\n", "\n".join(merged_lines)).strip()

def find_source_links(pdf_path: Path) -> str:
    for parent in pdf_path.parents:
        java_src = parent / "src" / "main" / "java"
        if java_src.exists():
            depth = len(pdf_path.parent.relative_to(parent).parts)
            prefix = "../" * depth if depth > 0 else "./"
            return f"[Module Java Source]({prefix}src/main/java)"

    if pdf_path.parent.name == "docs":
        return (
            "[Trees & Graphs](../trees-graphs/src/main/java) | "
            "[Linked Lists](../linked-lists/src/main/java) | "
            "[Arrays & Strings](../arrays-strings/src/main/java)"
        )
    return "[Project Root](..)"

def convert_pdf(pdf_path: Path):
    reader = PdfReader(str(pdf_path))
    full_text_pages = []
    for page in reader.pages:
        txt = page.extract_text() or ""
        txt = re.sub(r"\n\d+\s*$", "", txt)
        full_text_pages.append(txt)

    combined_text = "\n".join(full_text_pages)
    chapter_splits = re.split(r"(?m)^Chapter\s+(\d+)\s*\n+([^\n]+)", combined_text)

    source_links = find_source_links(pdf_path)
    title = pdf_path.stem.replace("-", " ").title()
    md_path = pdf_path.with_suffix(".md")

    if len(chapter_splits) > 1:
        toc_lines = ["## Table of Contents\n"]
        body_sections = []

        for i in range(1, len(chapter_splits), 3):
            chap_num = chapter_splits[i].strip()
            chap_title = chapter_splits[i + 1].strip()
            chap_body = chapter_splits[i + 2]

            heading = f"Chapter {chap_num}: {chap_title}"
            anchor = slugify(heading)
            toc_lines.append(f"- [{heading}](#{anchor})")

            formatted_body = clean_and_format_chapter(chap_body)
            body_sections.append(f"## {heading}\n\n{formatted_body}\n\n[↑ Back to Top](#table-of-contents)")

        final_md = (
            f"# {title}\n\n"
            f"> **Original PDF:** [{pdf_path.name}](./{pdf_path.name}) | "
            f"**Jump to Java Code:** {source_links}\n\n"
            + "\n".join(toc_lines)
            + "\n\n---\n\n"
            + "\n\n---\n\n".join(body_sections)
        )
    else:
        formatted_body = clean_and_format_chapter(combined_text)
        final_md = (
            f"# {title}\n\n"
            f"> **Original PDF:** [{pdf_path.name}](./{pdf_path.name}) | "
            f"**Jump to Java Code:** {source_links}\n\n---\n\n"
            + formatted_body
        )

    md_path.write_text(final_md, encoding="utf-8")
    print(f"Generated: {md_path}")

if __name__ == "__main__":
    for pdf in ROOT_DIR.rglob("*.pdf"):
        if "target" in pdf.parts or ".git" in pdf.parts:
            continue
        convert_pdf(pdf)
