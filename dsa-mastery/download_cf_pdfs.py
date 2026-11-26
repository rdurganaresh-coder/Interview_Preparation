import json
import os
import random
import re
import time
from playwright.sync_api import sync_playwright

CACHE_FILE = "Codeforces\\cf_problems_cache.json"
OUTPUT_DIR = os.path.join("Codeforces", "cf_pdfs")
CDP_URL = "http://127.0.0.1:9222"
BASE_PROBLEM_URL = "https://codeforces.com"


def sanitize_filename(name):
    return re.sub(r'[\\/*?:"<>|]', "", name).strip()


def main():
    if not os.path.exists(CACHE_FILE):
        raise FileNotFoundError(
            f"'{CACHE_FILE}' not found. Run cf_to_md.py first to generate the problem cache."
        )

    with open(CACHE_FILE, "r", encoding="utf-8") as f:
        problems = json.load(f)

    total = len(problems)
    os.makedirs(OUTPUT_DIR, exist_ok=True)
    print(f"Loaded {total} problems. Saving PDFs to '{OUTPUT_DIR}/'...")

    with sync_playwright() as p:
        try:
            browser = p.chromium.connect_over_cdp(CDP_URL)
        except Exception as e:
            raise RuntimeError(
                f"Could not connect to Chrome on {CDP_URL}. "
                "Start Chrome first with --remote-debugging-port=9222"
            ) from e

        context = next(iter(browser.contexts), None) or browser.new_context()
        page = context.new_page()

        for i, prob in enumerate(problems, 1):
            num = prob.get("number", i)
            cid = prob["contestId"]
            idx = prob["index"]
            name = sanitize_filename(prob["name"])
            filename = f"{num:03d}_{cid}{idx}_{name}.pdf"
            filepath = os.path.join(OUTPUT_DIR, filename)

            if os.path.exists(filepath):
                print(f"[{num}/{total}] Skipping existing: {filename}")
                continue

            clean_url = f"{BASE_PROBLEM_URL}/{cid}/{idx}"
            url = f"{clean_url}?locale=en"
            print(f"[{num}/{total}] Downloading {cid}{idx} - {prob['name']}...")

            try:
                page.goto(url, wait_until="domcontentloaded", timeout=45000)
                page.wait_for_selector(".problem-statement", timeout=30000)

                page.evaluate(
                    """([problemNum, totalCount, problemUrl]) => {
                        const statement = document.querySelector('.problem-statement');
                        if (statement) {
                            document.body.innerHTML = '';
                            const linkBar = document.createElement('div');
                            linkBar.style.marginBottom = '15px';
                            linkBar.style.fontFamily = 'sans-serif';
                            linkBar.style.fontSize = '14px';
                            linkBar.innerHTML = `<strong>Problem #${problemNum} of ${totalCount}</strong> | <strong>Link:</strong> <a href="${problemUrl}">${problemUrl}</a>`;
                            document.body.appendChild(linkBar);
                            document.body.appendChild(statement);
                            document.body.style.padding = '20px';
                        }
                    }""",
                    [num, total, clean_url],
                )

                page.pdf(path=filepath, format="A4", print_background=True)
                time.sleep(random.uniform(4.0, 6.5))
            except Exception as e:
                print(f"  -> Failed to download #{num} ({cid}{idx}): {e}")
                time.sleep(5)

        page.close()
    print(f"Done! Processed {total} problems.")


if __name__ == "__main__":
    main()
