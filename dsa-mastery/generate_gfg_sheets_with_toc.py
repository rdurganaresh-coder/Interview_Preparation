import os
import re
import pandas as pd

# ==========================================
# CONFIGURATION
# ==========================================
INPUT_FILE = r"D:\Github\Interview_Preparation\dsa-mastery\docs\GeeksForgeeks.xlsx"
OUTPUT_DIR = r"D:\Github\Interview_Preparation\dsa-mastery\gfg_dsa_sheets"

REMOVE_GLOBAL_DUPLICATES = True
EXCLUDE_INTERVIEW_EXPERIENCES = True
SORT_PROBLEMS_ALPHABETICALLY = True
LOCAL_TOC_THRESHOLD = 60  # Add A-Z jump links if a sheet has >= 60 problems

INTERVIEW_KEYWORDS = (
    "interview experience",
    "interview set",
    "placement drive",
    "campus recruitment",
    "campus placement",
    "recruitment process",
    "toptalent.in",
    "geek-on-the-top",
    "geek-top",
    "ibm",
    "microsoft",
    "samsung",
    "uber",
    "appdynamics",
    "bank of america",
    "kla tencor",
    "zoho on campus",
)

os.makedirs(OUTPUT_DIR, exist_ok=True)


def sanitize_filename(name: str) -> str:
    clean = re.sub(r"[^a-zA-Z0-9_-]+", "_", name.strip()).strip("_").lower()
    return clean or "sheet"


def make_anchor(text: str) -> str:
    anchor = text.lower().strip()
    anchor = re.sub(r"[^\w\s-]", "", anchor)
    anchor = re.sub(r"\s+", "-", anchor)
    return anchor


def is_interview_item(title: str, link: str) -> bool:
    combined = f"{title} {link}".lower()
    return any(keyword in combined for keyword in INTERVIEW_KEYWORDS)


def clean_title(title: str) -> str:
    # Decode escaped unicode sequences if present (e.g., \u2013)
    if "\\u" in title:
        try:
            title = title.encode("utf-8").decode("unicode_escape")
        except Exception:
            pass
    return title.strip().rstrip(":").strip()


def get_index_letter(title: str) -> str:
    for ch in title:
        if ch.isalpha():
            return ch.upper()
    return "0-9 / Symbols"


def load_sheets(filepath: str) -> dict:
    """Loads Excel tabs or CSV category blocks into {sheet_name: DataFrame}."""
    ext = os.path.splitext(filepath)[1].lower()
    if ext in (".xlsx", ".xls"):
        return pd.read_excel(filepath, sheet_name=None, header=None)
    df = pd.read_csv(filepath, header=None, encoding="cp1252", encoding_errors="replace")
    return {"Default": df}


# 1. Parse input file into categorized sheets
raw_sheets = load_sheets(INPUT_FILE)
sections = {}
seen_global_links = set()

for tab_name, df in raw_sheets.items():
    if df.empty:
        continue

    # Skip header row if first row is "Question, Question Link"
    first_cell = str(df.iloc[0, 0]).strip().lower() if pd.notna(df.iloc[0, 0]) else ""
    if first_cell == "question":
        df = df.iloc[1:].reset_index(drop=True)

    current_section = "Arrays & General" if tab_name == "Default" else tab_name

    for _, row in df.iterrows():
        raw_title = str(row[0]).strip() if pd.notna(row[0]) else ""
        link = str(row[1]).strip() if len(row) > 1 and pd.notna(row[1]) else ""

        if not raw_title or raw_title.lower() == "nan":
            continue

        title = clean_title(raw_title)

        # Category header row inside CSV/Excel (empty URL column)
        if not link or link.lower() == "nan":
            current_section = title
            continue

        # Filter interview experiences if enabled
        if EXCLUDE_INTERVIEW_EXPERIENCES and (
            is_interview_item(current_section, "") or is_interview_item(title, link)
        ):
            continue

        # Normalize URL to deduplicate
        norm_link = link.replace("http://", "https://").rstrip("/")
        if REMOVE_GLOBAL_DUPLICATES:
            if norm_link in seen_global_links:
                continue
            seen_global_links.add(norm_link)

        sections.setdefault(current_section, [])
        if not any(
            existing_link.replace("http://", "https://").rstrip("/") == norm_link
            for _, existing_link in sections[current_section]
        ):
            sections[current_section].append((title, link))

# 2. Write separate .md files with local A-Z Table of Contents for large sheets
toc_entries = []

for idx, (section_name, items) in enumerate(sections.items(), start=1):
    if not items:
        continue

    if SORT_PROBLEMS_ALPHABETICALLY:
        items.sort(key=lambda x: x[0].lower())

    filename = f"{idx:02d}_{sanitize_filename(section_name)}.md"
    filepath = os.path.join(OUTPUT_DIR, filename)
    toc_entries.append((idx, section_name, filename, len(items)))

    with open(filepath, mode="w", encoding="utf-8") as md:
        md.write("[← Back to Master Table of Contents](README.md)\n\n")
        md.write(f"# {section_name}\n\n")
        md.write(f"**Total Problems & Articles:** {len(items)}\n\n")

        # Group by starting letter if sheet is large
        if len(items) >= LOCAL_TOC_THRESHOLD:
            grouped = {}
            for title, link in items:
                letter = get_index_letter(title)
                grouped.setdefault(letter, []).append((title, link))

            # Sort keys so A-Z comes first, numbers/symbols last
            sorted_letters = sorted(
                grouped.keys(), key=lambda k: (len(k) > 1, k)
            )

            # Local Table of Contents
            md.write("## Quick Jump (Local Table of Contents)\n\n")
            jump_links = [
                f"[{letter} ({len(grouped[letter])})](#{make_anchor(letter)})"
                for letter in sorted_letters
            ]
            md.write(" | ".join(jump_links) + "\n\n---\n\n")

            counter = 1
            for letter in sorted_letters:
                md.write(f"## {letter}\n\n")
                md.write("| # | Problem / Article | Link | Status |\n")
                md.write("| :--- | :--- | :--- | :---: |\n")
                for title, link in grouped[letter]:
                    safe_title = title.replace("|", "\\|")
                    md.write(f"| {counter} | {safe_title} | [View on GFG]({link}) | ⬜ |\n")
                    counter += 1
                md.write("\n")
        else:
            # Standard single table for smaller sheets
            md.write("| # | Problem / Article | Link | Status |\n")
            md.write("| :--- | :--- | :--- | :---: |\n")
            for item_idx, (title, link) in enumerate(items, start=1):
                safe_title = title.replace("|", "\\|")
                md.write(f"| {item_idx} | {safe_title} | [View on GFG]({link}) | ⬜ |\n")
            md.write("\n")

# 3. Generate Master Table of Contents (README.md)
readme_path = os.path.join(OUTPUT_DIR, "README.md")
total_problems = sum(count for _, _, _, count in toc_entries)

with open(readme_path, mode="w", encoding="utf-8") as readme:
    readme.write("# GeeksforGeeks DSA & Programming Sheets — Master Table of Contents\n\n")
    readme.write(
        f"**Total Unique Problems & Articles:** {total_problems} across "
        f"**{len(toc_entries)}** sheets\n\n"
    )
    readme.write("| # | Sheet / Topic | Problems | File |\n")
    readme.write("| :---: | :--- | :---: | :--- |\n")
    for idx, section_name, filename, count in toc_entries:
        readme.write(f"| {idx} | [{section_name}]({filename}) | {count} | `{filename}` |\n")

print(f"Done! Created {len(toc_entries)} clean sheet files + README.md in:\n{OUTPUT_DIR}")
