import os
import re
from pathlib import Path
from collections import defaultdict

# Ordered by priority: first matching category becomes the primary concept
CONCEPT_KEYWORDS = [
    ("Trees & Tries", [
        "tree", "trees", "bst", "trie", "leaf", "leaves", "ancestor", "preorder", 
        "inorder", "postorder", "quad-tree", "n-ary"
    ]),
    ("Linked Lists", [
        "linked list", "list node", "nodes in", "doubly linked", "circular list"
    ]),
    ("Graphs & Shortest Path", [
        "graph", "island", "islands", "course", "courses", "path", "paths", 
        "connected", "bipartite", "network", "city", "cities", "route", "routes", 
        "flight", "flights", "maze", "cycle", "topological", "bridges", "shortest distance"
    ]),
    ("Heaps & Priority Queues", [
        "kth largest", "k-th largest", "top k", "median from data stream", 
        "merge k", "k closest", "k pairs", "scheduler"
    ]),
    ("Backtracking", [
        "permutation", "permutations", "combination", "combinations", "subset", 
        "subsets", "n-queens", "sudoku", "word search", "generate parentheses", 
        "phone number", "ip addresses"
    ]),
    ("Dynamic Programming", [
        "climb", "climbing", "robber", "coin", "coins", "subsequence", "knapsack", 
        "ways to", "partition", "edit distance", "palindromic", "stone game", 
        "paint", "buy and sell stock", "jump game", "score", "cost"
    ]),
    ("Binary Search", [
        "binary search", "rotated sorted", "search insert", "peak element", 
        "kth smallest", "k-th smallest", "median of two", "ship packages"
    ]),
    ("Stacks & Queues", [
        "stack", "stacks", "queue", "queues", "parentheses", "bracket", 
        "calculator", "temperatures", "histogram", "monotonic", "asteroid", "decode string"
    ]),
    ("Sliding Window & Two Pointers", [
        "substring", "substrings", "subarray", "subarrays", "window", "palindrome", 
        "3sum", "4sum", "two sum", "container", "water", "consecutive", "duplicates"
    ]),
    ("Design & Data Structures", [
        "design", "implement", "cache", "iterator", "stream", "system", 
        "tracker", "allocator", "browser", "twitter", "underground"
    ]),
    ("Matrices & Grids", [
        "matrix", "grid", "board", "spiral", "rotate image", "diagonal", 
        "rectangle", "rectangles", "triangle", "battleships", "minesweeper"
    ]),
    ("Bit Manipulation & Math", [
        "bit", "bits", "xor", "binary", "prime", "primes", "gcd", "lcm", 
        "factorial", "pow", "digit", "digits", "integer", "roman", "fraction", 
        "square", "power of", "modulo"
    ]),
    ("SQL & Database", [
        "salary", "salaries", "employee", "employees", "department", "departments", 
        "customer", "customers", "orders", "sales", "product", "products", 
        "table", "user", "users", "login", "student", "students", "league", 
        "cinema", "movie", "movies", "trip", "trips", "tweet", "tweets", 
        "account", "accounts", "follower", "followers", "rank scores",
        "apples & oranges", "warehouse", "managers", "sellers", "buyers", "sql"
    ]),
    ("Strings", [
        "string", "strings", "word", "words", "anagram", "anagrams", "prefix", 
        "suffix", "vowel", "vowels", "character", "characters", "sentence", 
        "acronym", "capital"
    ])
]

DIFFICULTY_ORDER = ["Easy", "Medium", "Hard", "Unknown"]

DIFFICULTY_BADGES = {
    "Easy": "🟢 Easy",
    "Medium": "🟡 Medium",
    "Hard": "🔴 Hard",
    "Unknown": "⚪ Unknown"
}

COMPILED_CONCEPTS = [
    (concept, re.compile(r"\b(?:" + "|".join(re.escape(k) for k in kws) + r")\b", re.IGNORECASE))
    for concept, kws in CONCEPT_KEYWORDS
]

def get_primary_concept(title: str) -> str:
    for concept, pattern in COMPILED_CONCEPTS:
        if pattern.search(title):
            return concept
    return "Arrays, Hashing & Greedy"

def make_leetcode_url(title: str) -> str:
    slug = title.lower()
    slug = re.sub(r"[^a-z0-9\s-]", "", slug)
    slug = re.sub(r"[\s-]+", "-", slug).strip("-")
    return f"https://leetcode.com{slug}/"

def make_slug(text: str) -> str:
    return re.sub(r"[^a-z0-9]+", "-", text.lower()).strip("-")

def load_problem_metadata(txt_path: str) -> dict:
    """Loads ID -> (title, difficulty) from problems.txt if available."""
    metadata = {}
    if not os.path.exists(txt_path):
        return metadata
        
    line_pattern = re.compile(r"^(\d+)\s+(.+?)\s+(Easy|Medium|Hard)\s*$")
    with open(txt_path, "r", encoding="utf-8") as f:
        for line in f:
            match = line_pattern.match(line.strip())
            if match:
                prob_id, title, diff = match.groups()
                metadata[int(prob_id)] = (title, diff)
    return metadata

def scan_pdfs_and_export_md(root_dir: str, txt_path: str, output_path: str):
    root = Path(root_dir).resolve()
    metadata = load_problem_metadata(txt_path)
    
    categorized = defaultdict(lambda: defaultdict(list))
    diff_counts = {"Easy": 0, "Medium": 0, "Hard": 0, "Unknown": 0}
    
    # Matches PDF names starting with a number, e.g., "1. Two Sum.pdf" or "0001 - Two Sum.pdf"
    pdf_name_pattern = re.compile(r"^(\d+)[\s._-]+(.+?)\.pdf$", re.IGNORECASE)

    # Walk through all subdirectories (1 - 100, 101 - 200, etc.)
    for pdf_file in root.rglob("*.pdf"):
        match = pdf_name_pattern.match(pdf_file.name)
        if not match:
            continue
            
        prob_id = int(match.group(1))
        raw_title = match.group(2).strip()
        
        # Use official title & difficulty from problems.txt if available, else fallback to filename
        if prob_id in metadata:
            title, difficulty = metadata[prob_id]
        else:
            title, difficulty = raw_title, "Unknown"
            
        concept = get_primary_concept(title)
        
        # Create relative path with forward slashes and URL-encoded spaces for Markdown links
        rel_path = pdf_file.relative_to(root).as_posix().replace(" ", "%20")
        
        categorized[concept][difficulty].append({
            "id": prob_id,
            "title": title,
            "difficulty": difficulty,
            "url": make_leetcode_url(title),
            "pdf_link": rel_path
        })
        diff_counts[difficulty] += 1

    total = sum(diff_counts.values())
    ordered_concepts = [c for c, _ in CONCEPT_KEYWORDS if c in categorized]
    if "Arrays, Hashing & Greedy" in categorized:
        ordered_concepts.append("Arrays, Hashing & Greedy")

    with open(output_path, "w", encoding="utf-8") as out:
        out.write('<a id="top"></a>\n\n')
        out.write("# AlgoMap PDF Problem Bank\n\n")
        out.write(
            f"**Total PDFs Found: {total}** "
            f"(🟢 Easy: {diff_counts['Easy']} | "
            f"🟡 Medium: {diff_counts['Medium']} | "
            f"🔴 Hard: {diff_counts['Hard']})\n\n"
        )
        
        # Table of Contents
        out.write("## Table of Contents\n")
        for concept in ordered_concepts:
            concept_total = sum(len(categorized[concept][d]) for d in DIFFICULTY_ORDER)
            anchor = make_slug(concept)
            out.write(f"- [{concept} ({concept_total})](#{anchor})\n")
        out.write("\n---\n\n")

        # Concept Sections with Separate Easy / Medium / Hard Sub-Tables
        for concept in ordered_concepts:
            concept_total = sum(len(categorized[concept][d]) for d in DIFFICULTY_ORDER)
            easy_c = len(categorized[concept]["Easy"])
            med_c = len(categorized[concept]["Medium"])
            hard_c = len(categorized[concept]["Hard"])
            anchor = make_slug(concept)

            out.write(f'<a id="{anchor}"></a>\n\n')
            out.write(f"## {concept} ({concept_total})\n\n")
            out.write(f"🟢 Easy: {easy_c} | 🟡 Medium: {med_c} | 🔴 Hard: {hard_c}\n\n")
            
            for diff in DIFFICULTY_ORDER:
                items = sorted(categorized[concept][diff], key=lambda x: x["id"])
                if not items:
                    continue

                badge = DIFFICULTY_BADGES[diff]
                out.write(f"### {badge} ({len(items)})\n\n")
                
                out.write("| ID | Problem | Difficulty | Local PDF | LeetCode | Status |\n")
                out.write("| :-: | :--- | :--- | :-: | :-: | :-: |\n")
                
                for item in items:
                    out.write(
                        f"| {item['id']} | {item['title']} | {badge} | "
                        f"[Open PDF]({item['pdf_link']}) | "
                        f"[Solve]({item['url']}) | <input type=\"checkbox\"> |\n"
                    )
                
                out.write("\n[↑ Back to Top](#top)\n\n")

            out.write("---\n\n")

    print(f"Scanned folders and exported {total} PDFs into {output_path}.")

if __name__ == "__main__":
    # Place this script in the parent folder containing '1 - 100', '101 - 200', etc.
    # Keep 'problems.txt' in the same folder so it automatically maps Difficulty levels.
    scan_pdfs_and_export_md(
        root_dir=".", 
        txt_path="problems.txt", 
        output_path="categorized_pdfs.md"
    )
