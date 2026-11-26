import os
import re
import json
from collections import defaultdict
from curl_cffi import requests

API_URL = "https://codeforces.com/problemset/problem//problemset/problem/"
LOCAL_CACHE = "cf_problems_cache.json"

def make_slug(text: str) -> str:
    return re.sub(r"[^a-z0-9]+", "-", text.lower()).strip("-")

def get_difficulty_bucket(rating) -> str:
    if not rating:
        return "Unrated"
    if rating <= 1100:
        return "🟢 Beginner (800 - 1100)"
    if rating <= 1500:
        return "🟡 Intermediate (1200 - 1500)"
    if rating <= 1900:
        return "🟠 Advanced (1600 - 1900)"
    return "🔴 Expert+ (2000+)"

DIFFICULTY_BUCKETS = [
    "🟢 Beginner (800 - 1100)",
    "🟡 Intermediate (1200 - 1500)",
    "🟠 Advanced (1600 - 1900)",
    "🔴 Expert+ (2000+)",
    "Unrated"
]

def load_problems_data() -> dict:
    # 1. Try fetching directly by impersonating Chrome's TLS fingerprint
    try:
        print("Fetching all problems from Codeforces API (Chrome impersonation)...")
        response = requests.get(API_URL, impersonate="chrome", timeout=30)
        response.raise_for_status()
        data = response.json()
        
        # Save a local backup so you don't have to re-fetch repeatedly
        with open(LOCAL_CACHE, "w", encoding="utf-8") as cache:
            json.dump(data, cache)
        return data
    except Exception as e:
        print(f"Direct API fetch failed ({e}).")
        
    # 2. Fallback: Read from cf_problems_cache.json if you saved it manually from your browser
    if os.path.exists(LOCAL_CACHE):
        print(f"Loading from local cache: {LOCAL_CACHE}...")
        with open(LOCAL_CACHE, "r", encoding="utf-8") as f:
            return json.load(f)
            
    raise RuntimeError(
        f"Could not fetch API. Open {API_URL} in your browser, press Ctrl+S, "
        f"save it as '{LOCAL_CACHE}' in this folder, and re-run the script."
    )

def fetch_and_export_md(output_path: str):
    data = load_problems_data()

    if data.get("status") != "OK":
        raise RuntimeError(f"Codeforces API Error: {data.get('comment')}")

    problems = data["result"]["problems"]
    
    categorized = defaultdict(lambda: defaultdict(list))
    bucket_counts = defaultdict(int)

    for prob in problems:
        contest_id = prob.get("contestId")
        index = prob.get("index")
        name = prob.get("name")
        rating = prob.get("rating")
        tags = prob.get("tags", [])

        if not contest_id or not index:
            continue

        # Fix: tags[0].title() gets the first tag cleanly
        primary_tag = tags[0].title() if tags else "Untagged"
        bucket = get_difficulty_bucket(rating)
        url = f"https://codeforces.com/problemset/problem//problemset/problem/{contest_id}/{index}"

        categorized[primary_tag][bucket].append({
            "code": f"{contest_id}{index}",
            "contest_id": contest_id,
            "index": index,
            "name": name,
            "rating": rating if rating else "—",
            "all_tags": ", ".join(tags) if tags else "—",
            "url": url
        })
        bucket_counts[bucket] += 1

    total = sum(bucket_counts.values())
    ordered_tags = sorted(categorized.keys())

    with open(output_path, "w", encoding="utf-8") as out:
        out.write('<a id="top"></a>\n\n')
        out.write("# Codeforces Complete Problemset\n\n")
        out.write(
            f"**Total Problems: {total}** | "
            f"🟢 Beginner: {bucket_counts['🟢 Beginner (800 - 1100)']} | "
            f"🟡 Intermediate: {bucket_counts['🟡 Intermediate (1200 - 1500)']} | "
            f"🟠 Advanced: {bucket_counts['🟠 Advanced (1600 - 1900)']} | "
            f"🔴 Expert+: {bucket_counts['🔴 Expert+ (2000+)']}\n\n"
        )

        # Table of Contents
        out.write("## Table of Contents\n")
        for tag in ordered_tags:
            tag_total = sum(len(categorized[tag][b]) for b in DIFFICULTY_BUCKETS)
            anchor = make_slug(tag)
            out.write(f"- [{tag} ({tag_total})](#{anchor})\n")
        out.write("\n---\n\n")

        # Sections grouped by Tag -> Rating Sub-Tables
        for tag in ordered_tags:
            tag_total = sum(len(categorized[tag][b]) for b in DIFFICULTY_BUCKETS)
            anchor = make_slug(tag)

            out.write(f'<a id="{anchor}"></a>\n\n')
            out.write(f"## {tag} ({tag_total})\n\n")

            for bucket in DIFFICULTY_BUCKETS:
                items = categorized[tag][bucket]
                if not items:
                    continue

                items.sort(key=lambda x: (-x["contest_id"], x["index"]))

                out.write(f"### {bucket} ({len(items)})\n\n")
                out.write("| ID | Problem | Rating | Tags | Link | Status |\n")
                out.write("| :-: | :--- | :-: | :--- | :-: | :-: |\n")

                for item in items:
                    safe_name = item["name"].replace("|", "\\|")
                    out.write(
                        f"| {item['code']} | {safe_name} | {item['rating']} | "
                        f"{item['all_tags']} | [Solve]({item['url']}) | <input type=\"checkbox\"> |\n"
                    )

                out.write("\n[↑ Back to Top](#top)\n\n")

            out.write("---\n\n")

    print(f"Successfully exported {total} Codeforces problems to {output_path}.")

if __name__ == "__main__":
    fetch_and_export_md("codeforces_problems.md")
