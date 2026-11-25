import re
from collections import defaultdict

# Ordered by priority. Whole-word matching prevents substrings like "order" matching "inorder".
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

DIFFICULTY_BADGES = {
    "Easy": "🟢 Easy",
    "Medium": "🟡 Medium",
    "Hard": "🔴 Hard"
}

# Precompile whole-word regexes for accurate matching
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

def make_anchor(text: str) -> str:
    anchor = text.lower().replace("&", "").replace(",", "")
    return re.sub(r"\s+", "-", anchor.strip())

def parse_and_export_md(file_path: str, output_path: str):
    categorized = defaultdict(list)
    diff_counts = {"Easy": 0, "Medium": 0, "Hard": 0}
    line_pattern = re.compile(r"^(\d+)\s+(.+?)\s+(Easy|Medium|Hard)\s*$")
    
    with open(file_path, "r", encoding="utf-8") as f:
        for line in f:
            match = line_pattern.match(line.strip())
            if match:
                prob_id, title, difficulty = match.groups()
                concept = get_primary_concept(title)
                
                categorized[concept].append({
                    "id": int(prob_id),
                    "title": title,
                    "difficulty": difficulty,
                    "url": make_leetcode_url(title)
                })
                diff_counts[difficulty] += 1

    total = sum(diff_counts.values())
    ordered_concepts = [c for c, _ in CONCEPT_KEYWORDS if c in categorized]
    if "Arrays, Hashing & Greedy" in categorized:
        ordered_concepts.append("Arrays, Hashing & Greedy")

    with open(output_path, "w", encoding="utf-8") as out:
        # Top Header
        out.write("# AlgoMap LeetCode Problem Bank\n\n")
        out.write(
            f"**Total Problems: {total}** "
            f"(🟢 Easy: {diff_counts['Easy']} | "
            f"🟡 Medium: {diff_counts['Medium']} | "
            f"🔴 Hard: {diff_counts['Hard']})\n\n"
        )
        
        # Table of Contents
        out.write("## Table of Contents\n")
        for concept in ordered_concepts:
            count = len(categorized[concept])
            anchor = make_anchor(f"{concept} ({count})")
            out.write(f"- [{concept} ({count})](#{anchor})\n")
        out.write("\n---\n\n")

        # Concept Sections with 5-column Tables
        for concept in ordered_concepts:
            items = sorted(categorized[concept], key=lambda x: x["id"])
            easy_c = sum(1 for i in items if i["difficulty"] == "Easy")
            med_c = sum(1 for i in items if i["difficulty"] == "Medium")
            hard_c = sum(1 for i in items if i["difficulty"] == "Hard")

            out.write(f"## {concept} ({len(items)})\n\n")
            out.write(f"🟢 Easy: {easy_c} | 🟡 Medium: {med_c} | 🔴 Hard: {hard_c}\n\n")
            
            out.write("| ID | Problem | Difficulty | LeetCode | Status |\n")
            out.write("| :-: | :--- | :--- | :-: | :-: |\n")
            
            for item in items:
                badge = DIFFICULTY_BADGES[item["difficulty"]]
                out.write(
                    f"| {item['id']} | {item['title']} | {badge} | "
                    f"[Solve]({item['url']}) | <input type=\"checkbox\"> |\n"
                )
            out.write("\n")

    print(f"Exported {total} problems into styled Markdown tables at {output_path}.")

if __name__ == "__main__":
    # Save your pasted text into 'problems.txt' before running
    parse_and_export_md("D:\\Github\\Interview_Preparation\\dsa-mastery\\AlgoMapIO.txt", "categorized_problems.md")
