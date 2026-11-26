import os
import re

INPUT_FILE = r"D:\Github\Interview_Preparation\dsa-mastery\AlgoMapIO.txt"  # Save your copied AlgoMap text file as algomap.txt (or update this path)
OUTPUT_MD = "algomap_problem_bank.md"


def slugify(title: str) -> str:
    slug = title.lower().strip()
    slug = re.sub(r"[^a-z0-9\s-]", "", slug)
    slug = re.sub(r"\s+", "-", slug)
    return slug.strip("-")


problems = []
seen_ids = set()

with open(INPUT_FILE, mode="r", encoding="utf-8", errors="replace") as f:
    for line in f:
        line = line.strip()
        if not line:
            continue

        # Match lines formatted as: <ID> <Problem Name> <Easy|Medium|Hard>
        match = re.match(r"^(\d+)\s+(.+?)\s+(Easy|Medium|Hard)\s*$", line)
        if match:
            prob_id = int(match.group(1))
            title = match.group(2).strip()
            difficulty = match.group(3).strip()

            if prob_id not in seen_ids:
                seen_ids.add(prob_id)
                problems.append((prob_id, title, difficulty))

# Count by difficulty
easy_count = sum(1 for _, _, d in problems if d == "Easy")
med_count = sum(1 for _, _, d in problems if d == "Medium")
hard_count = sum(1 for _, _, d in problems if d == "Hard")

with open(OUTPUT_MD, mode="w", encoding="utf-8") as md:
    md.write("# AlgoMap LeetCode Problem Bank\n\n")
    md.write(
        f"**Total Problems:** {len(problems)} "
        f"(🟢 Easy: {easy_count} | 🟡 Medium: {med_count} | 🔴 Hard: {hard_count})\n\n"
    )
    md.write("| ID | Problem | Difficulty | LeetCode | Status |\n")
    md.write("| :---: | :--- | :---: | :---: | :---: |\n")

    for prob_id, title, difficulty in problems:
        safe_title = title.replace("|", "\\|")
        badge = {"Easy": "🟢 Easy", "Medium": "🟡 Medium", "Hard": "🔴 Hard"}[difficulty]
        lc_url = f"https://leetcode.com/problems//problems/{slugify(title)}/"
        md.write(f"| {prob_id} | {safe_title} | {badge} | [Solve]({lc_url}) | ⬜ |\n")

print(f"Successfully generated {OUTPUT_MD} with {len(problems)} problems!")
