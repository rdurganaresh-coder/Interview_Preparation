import csv
import re

INPUT_CSV = r"D:\Github\Interview_Preparation\dsa-mastery\docs\GeeksForgeeks.xlsx"  # Replace with your actual CSV filename
OUTPUT_MD = "geeksforgeeks_master_sheet_clean.md"

# Set these toggles to True or False as needed
REMOVE_GLOBAL_DUPLICATES = True
EXCLUDE_INTERVIEW_EXPERIENCES = True

# Keywords used to detect company interview experience sections or rows
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


def make_anchor(title: str) -> str:
    anchor = title.lower().strip()
    anchor = re.sub(r"[^\w\s-]", "", anchor)
    anchor = re.sub(r"\s+", "-", anchor)
    return anchor


def is_interview_item(title: str, link: str) -> bool:
    combined = f"{title} {link}".lower()
    return any(keyword in combined for keyword in INTERVIEW_KEYWORDS)


categories = {}
current_category = "Arrays & General"
seen_global_links = set()

with open(INPUT_CSV, mode="r", encoding="utf-8", errors="replace") as f:
    reader = csv.reader(f)
    header = next(reader, None)  # Skip "Question,Question Link"

    for row in reader:
        if not row or not row[0].strip():
            continue

        title = row[0].strip()
        link = row[1].strip() if len(row) > 1 else ""

        # Category header rows have a title and an empty URL column
        if not link:
            current_category = title
            continue

        # Skip company interview experiences if enabled
        if EXCLUDE_INTERVIEW_EXPERIENCES and (
            is_interview_item(current_category, "") or is_interview_item(title, link)
        ):
            continue

        # Normalize URL (http vs https, trailing slash) to catch identical articles
        norm_link = link.replace("http://", "https://").rstrip("/")

        # Global deduplication across all categories
        if REMOVE_GLOBAL_DUPLICATES:
            if norm_link in seen_global_links:
                continue
            seen_global_links.add(norm_link)

        if current_category not in categories:
            categories[current_category] = []

        # Local deduplication within the same category
        if not any(existing_link.replace("http://", "https://").rstrip("/") == norm_link for _, existing_link in categories[current_category]):
            categories[current_category].append((title, link))

with open(OUTPUT_MD, mode="w", encoding="utf-8") as md_file:
    total_count = sum(len(items) for items in categories.values())
    md_file.write("# GeeksforGeeks Master DSA & Programming Sheet (Clean)\n\n")
    md_file.write(
        f"**Total Unique Problems & Articles:** {total_count} across "
        f"{len(categories)} categories\n\n"
    )

    # Table of Contents
    md_file.write("## Table of Contents\n\n")
    for category, items in categories.items():
        anchor = make_anchor(f"{category} ({len(items)})")
        md_file.write(f"- [{category} ({len(items)})](#{anchor})\n")
    md_file.write("\n---\n\n")

    # Category Tables
    for category, items in categories.items():
        md_file.write(f"## {category} ({len(items)})\n\n")
        md_file.write("| # | Problem / Article | Link | Status |\n")
        md_file.write("| :--- | :--- | :--- | :---: |\n")

        for idx, (title, link) in enumerate(items, start=1):
            safe_title = title.replace("|", "\\|")
            md_file.write(f"| {idx} | {safe_title} | [View on GFG]({link}) | ⬜ |\n")

        md_file.write("\n")

print(f"Successfully generated {OUTPUT_MD} with {total_count} unique entries across {len(categories)} categories!")
