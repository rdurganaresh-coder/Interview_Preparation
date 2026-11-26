import json
import os
import re

INPUT_FILE = "pasted_problems.txt"
CACHE_FILE = "cf_problems_cache.json"
MD_OUTPUT = "cf_problems.md"

KNOWN_TAGS = sorted(
    [
        "2-sat", "binary search", "bitmasks", "brute force",
        "chinese remainder theorem", "combinatorics", "communication",
        "constructive algorithms", "data structures", "dfs and similar",
        "divide and conquer", "dp", "dsu", "expression parsing", "fft",
        "flows", "games", "geometry", "graph matchings", "graphs", "greedy",
        "hashing", "implementation", "interactive", "math", "matrices",
        "meet-in-the-middle", "number theory", "probabilities",
        "schedules", "shortest paths", "sortings", "string suffix structures",
        "strings", "ternary search", "trees", "two pointers",
    ],
    key=len,
    reverse=True,
)


def parse_pasted_problems(filepath):
    if not os.path.exists(filepath):
        raise FileNotFoundError(
            f"'{filepath}' not found. Paste your copied Codeforces problemset text into '{filepath}'."
        )

    with open(filepath, "r", encoding="utf-8") as f:
        lines = [line.strip() for line in f if line.strip()]

    problems = []
    line_pattern = re.compile(
        r"^(\d+)([A-Z]\d?)\s+(.+?)\s+Submit(?:\s+(\d+))?(?:\s+x(\d+))?$"
    )

    for line in lines:
        m = line_pattern.match(line)
        if not m:
            continue

        contest_id = int(m.group(1))
        index = m.group(2)
        name_and_tags = m.group(3).strip()
        rating = int(m.group(4)) if m.group(4) else None

        found_tags = []
        changed = True
        while changed:
            changed = False
            for tag in KNOWN_TAGS:
                if name_and_tags.endswith(tag):
                    found_tags.append(tag)
                    name_and_tags = name_and_tags[: -len(tag)].rstrip(" ,")
                    changed = True
                    break

        entry = {
            "number": len(problems) + 1,
            "contestId": contest_id,
            "index": index,
            "name": name_and_tags,
            "tags": sorted(set(found_tags)),
        }
        if rating is not None:
            entry["rating"] = rating

        problems.append(entry)

    return problems


def main():
    problems = parse_pasted_problems(INPUT_FILE)

    with open(CACHE_FILE, "w", encoding="utf-8") as f:
        json.dump(problems, f, indent=2)
    print(f"Parsed and saved {len(problems)} problems to '{CACHE_FILE}'.")

    with open(MD_OUTPUT, "w", encoding="utf-8") as f:
        f.write(f"# Codeforces Problems (Total: {len(problems)})\n\n")
        for p in problems:
            num = p["number"]
            cid = p["contestId"]
            idx = p["index"]
            name = p["name"]
            rating = p.get("rating", "Unrated")
            tags = ", ".join(p.get("tags", []))
            url = f"https://codeforces.com/problemset/problem/{cid}/{idx}"
            f.write(f"{num}. [{cid}{idx} - {name}]({url}) (Rating: {rating}) | Tags: {tags}\n")
    print(f"Generated '{MD_OUTPUT}' with {len(problems)} numbered problems.")


if __name__ == "__main__":
    main()
