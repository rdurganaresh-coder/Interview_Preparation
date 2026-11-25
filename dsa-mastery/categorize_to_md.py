import re
from collections import defaultdict

# Ordered by priority: the first matching category becomes the problem's single primary concept.
CONCEPT_KEYWORDS = [
    ("SQL & Database", [
        "salary", "salaries", "employee", "department", "customer", "order", 
        "sales", "product", "table", "user", "login", "student", "league", 
        "cinema", "movie", "trip", "tweet", "account", "follower", "rank scores",
        "apples & oranges", "warehouse", "managers", "sellers", "buyers"
    ]),
    ("Trees & Tries", [
        "tree", "bst", "trie", "leaf", "leaves", "ancestor", "preorder", 
        "inorder", "postorder", "quad-tree", "n-ary"
    ]),
    ("Linked Lists", [
        "linked list", "list node", "nodes in", "doubly linked", "circular list"
    ]),
    ("Graphs & Shortest Path", [
        "graph", "island", "course", "path", "connected", "bipartite", 
        "network", "city", "cities", "route", "flight", "maze", "cycle", 
        "topological", "bridges", "shortest distance"
    ]),
    ("Heaps & Priority Queues", [
        "kth largest", "k-th largest", "top k", "median from data stream", 
        "merge k", "k closest", "k pairs", "scheduler"
    ]),
    ("Backtracking", [
        "permutation", "combination", "subset", "n-queens", "sudoku", 
        "word search", "generate parentheses", "phone number", "ip addresses"
    ]),
    ("Dynamic Programming", [
        "climb", "robber", "coin", "subsequence", "knapsack", "ways to", 
        "partition", "edit distance", "palindromic", "stone game", "paint", 
        "buy and sell stock", "jump game", "score", "cost"
    ]),
    ("Binary Search", [
        "binary search", "rotated sorted", "search insert", "peak element", 
        "kth smallest", "k-th smallest", "median of two", "ship packages"
    ]),
    ("Stacks & Queues", [
        "stack", "queue", "parentheses", "bracket", "calculator", "temperatures", 
        "histogram", "monotonic", "asteroid", "decode string"
    ]),
    ("Sliding Window & Two Pointers", [
        "substring", "subarray", "window", "palindrome", "3sum", "4sum", 
        "two sum", "container", "water", "consecutive", "duplicates"
    ]),
    ("Design & Data Structures", [
        "design", "implement", "cache", "iterator", "stream", "system", 
        "tracker", "allocator", "browser", "twitter", "underground"
    ]),
    ("Matrices & Grids", [
        "matrix", "grid", "board", "spiral", "rotate image", "diagonal", 
        "rectangle", "triangle", "battleships", "minesweeper"
    ]),
    ("Bit Manipulation & Math", [
        "bit", "xor", "binary", "prime", "gcd", "lcm", "factorial", "pow", 
        "digit", "integer", "roman", "fraction", "square", "power of", "modulo"
    ]),
    ("Strings", [
        "string", "word", "anagram", "prefix", "suffix", "vowel", "character", 
        "sentence", "acronym", "capital"
    ])
]

DIFFICULTY_ORDER = ["Easy", "Medium", "Hard"]

def get_primary_concept(title: str) -> str:
    title_lower = title.lower()
    for concept, keywords in CONCEPT_KEYWORDS:
        if any(kw in title_lower for kw in keywords):
            return concept
    return "Arrays, Hashing & Greedy"

def make_leetcode_url(title: str) -> str:
    # Converts title to LeetCode URL slug (e.g., "Two Sum" -> "https://leetcode.com")
    slug = title.lower()
    slug = re.sub(r"[^a-z0-9\s-]", "", slug)
    slug = re.sub(r"[\s-]+", "-", slug).strip("-")
    return f"https://leetcode.com{slug}/"

def make_anchor(text: str) -> str:
    anchor = text.lower().replace("&", "").replace(",", "")
    return re.sub(r"\s+", "-", anchor.strip())

def parse_and_export_md(file_path: str, output_path: str):
    # Structure: categorized[concept][difficulty] = list of problems
    categorized = defaultdict(lambda: defaultdict(list))
    line_pattern = re.compile(r"^(\d+)\s+(.+?)\s+(Easy|Medium|Hard)\s*$")
    total_count = 0
    
    with open(file_path, "r", encoding="utf-8") as f:
        for line in f:
            match = line_pattern.match(line.strip())
            if match:
                prob_id, title, difficulty = match.groups()
                concept = get_primary_concept(title)
                
                entry = {
                    "id": int(prob_id),
                    "title": title,
                    "url": make_leetcode_url(title)
                }
                
                categorized[concept][difficulty].append(entry)
                total_count += 1

    # Preserve our logical priority order for the sections
    ordered_concepts = [c for c, _ in CONCEPT_KEYWORDS if c in categorized]
    if "Arrays, Hashing & Greedy" in categorized:
        ordered_concepts.append("Arrays, Hashing & Greedy")

    with open(output_path, "w", encoding="utf-8") as out:
        out.write(f"# AlgoMap Problem Bank ({total_count} Problems)\n\n")
        
        # Table of Contents
        out.write("## Table of Contents\n")
        for concept in ordered_concepts:
            concept_total = sum(len(categorized[concept][d]) for d in DIFFICULTY_ORDER)
            anchor = make_anchor(f"{concept} ({concept_total})")
            out.write(f"- [{concept} ({concept_total})](#{anchor})\n")
        out.write("\n---\n\n")

        # Sections grouped by Concept -> Difficulty
        for concept in ordered_concepts:
            concept_total = sum(len(categorized[concept][d]) for d in DIFFICULTY_ORDER)
            out.write(f"## {concept} ({concept_total})\n\n")
            
            for diff in DIFFICULTY_ORDER:
                items = categorized[concept][diff]
                if not items:
                    continue
                
                # Sort by Problem ID
                items.sort(key=lambda x: x["id"])
                out.write(f"### {diff} ({len(items)})\n\n")
                
                for item in items:
                    out.write(f"- [ ] [{item['id']}. {item['title']}]({item['url']})\n")
                out.write("\n")

    print(f"Successfully exported {total_count} unique problems to {output_path}.")

if __name__ == "__main__":
    # Save your pasted text into 'problems.txt' before running
    parse_and_export_md("D:\\Github\\Interview_Preparation\\dsa-mastery\\AlgoMapIO.txt", "categorized_problems.md")
