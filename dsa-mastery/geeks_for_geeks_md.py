import csv
import re

INPUT_CSV = r"D:\GeeksForgeeks.xlsx"  # Replace with your actual CSV filename
OUTPUT_MD = "geeksforgeeks_master_sheet.md"


def make_anchor(title):
    anchor = title.lower().strip()
    anchor = re.sub(r"[^\w\s-]", "", anchor)
    anchor = re.sub(r"\s+", "-", anchor)
    return anchor


# 1. Parse the CSV using cp1252 encoding (with errors="replace" as a safety fallback)
categories = {}
current_category = "General & Arrays"

with open(INPUT_CSV, mode="r", encoding="cp1252", errors="replace") as f:
    reader = csv.reader(f)
    header = next(reader, None)  # Skip header row

    for row in reader:
        if not row or not row[0].strip():
            continue

        title = row[0].strip()
        link = row[1].strip() if len(row) > 1 else ""

        # Rows without a link act as category headers
        if not link:
            current_category = title
            continue

        if current_category not in categories:
            categories[current_category] = []

        if (title, link) not in categories[current_category]:
            categories[current_category].append((title, link))

# 2. Write everything into a single master Markdown file in UTF-8
with open(OUTPUT_MD, mode="w", encoding="utf-8") as md_file:
    total_count = sum(len(items) for items in categories.values())
    md_file.write("# GeeksforGeeks Master DSA & Programming Sheet\n\n")
    md_file.write(
        f"**Total Problems & Articles:** {total_count} across"
        f" {len(categories)} categories\n\n"
    )

    # Generate Table of Contents
    md_file.write("## Table of Contents\n\n")
    for category, items in categories.items():
        anchor = make_anchor(f"{category} ({len(items)})")
        md_file.write(f"- [{category} ({len(items)})](#{anchor})\n")
    md_file.write("\n---\n\n")

    # Generate Tables for Each Category
    for category, items in categories.items():
        md_file.write(f"## {category} ({len(items)})\n\n")
        md_file.write("| # | Problem / Article | Link | Status |\n")
        md_file.write("| :--- | :--- | :--- | :---: |\n")

        for idx, (title, link) in enumerate(items, start=1):
            safe_title = title.replace("|", "\\|")
            md_file.write(
                f"| {idx} | {safe_title} | [View on GFG]({link}) | ⬜ |\n"
            )

        md_file.write("\n")

print(
    f"Successfully generated {OUTPUT_MD} with {total_count} total entries!"
)
