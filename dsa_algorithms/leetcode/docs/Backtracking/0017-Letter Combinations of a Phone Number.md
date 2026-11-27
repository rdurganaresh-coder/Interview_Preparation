# 17. Letter Combinations of a Phone Number

**Difficulty:** Medium  
**Category:** Backtracking  
**LeetCode:** https://leetcode.com/problems/letter-combinations-of-a-phone-number/

---

[中文文档](/solution/0000-0099/0017.Letter%20Combinations%20of%20a%20Phone%20Number/README.md)

## Description

<p>Given a string containing digits from <code>2-9</code> inclusive, return all possible letter combinations that the number could represent. Return the answer in <strong>any order</strong>.</p>

<p>A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.</p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0017.Letter%20Combinations%20of%20a%20Phone%20Number/images/1200px-telephone-keypad2svg.png" style="width: 300px; height: 243px;" />
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> digits = &quot;23&quot;
<strong>Output:</strong> [&quot;ad&quot;,&quot;ae&quot;,&quot;af&quot;,&quot;bd&quot;,&quot;be&quot;,&quot;bf&quot;,&quot;cd&quot;,&quot;ce&quot;,&quot;cf&quot;]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> digits = &quot;2&quot;
<strong>Output:</strong> [&quot;a&quot;,&quot;b&quot;,&quot;c&quot;]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= digits.length &lt;= 4</code></li>
	<li><code>digits[i]</code> is a digit in the range <code>[&#39;2&#39;, &#39;9&#39;]</code>.</li>
</ul>

## Solutions

### Solution 1: Traversal

> **Thinking**
>
> $n\le 4$, so at most $4^n$ combinations; any enumeration would pass. The problem is a Cartesian product of letter groups. Nested loops cannot be written when $n$ is not fixed.
>
> Start from the empty string: each new digit replaces the current prefixes with every concatenation against that digit’s letters. That is the product expanded layer by layer.
>
> So we keep a mapping array and grow from a list that holds only the empty string. An empty input returns an empty list.

First, we use an array or hash table to store the letters corresponding to each digit. Then we traverse each digit, combine its corresponding letters with the previous results to get the new results.

The time complexity is $O(4^n)$, and the space complexity is $O(4^n)$, where $n$ is the length of the input digits.

#### Java

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        ans.add("");
        String[] d = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (char i : digits.toCharArray()) {
            String s = d[i - '2'];
            List<String> t = new ArrayList<>();
            for (String a : ans) {
                for (String b : s.split("")) {
                    t.add(a + b);
                }
            }
            ans = t;
        }
        return ans;
    }
}
```

### Solution 2: DFS

> **Thinking**
>
> Solution 1 already enumerates every answer, but each layer allocates a new prefix list, so intermediate strings stay $O(4^n)$.
>
> If we walk a single path and backtrack, extra space drops to $O(n)$ (depth and path length).
>
> So we DFS by index: pick one letter for the current digit, go deeper, then undo. The combinations are the same; only the generation order changes from “expand by layer” to “one path to the end”.

We can use the method of depth-first search to enumerate all possible letter combinations. Suppose that a part of the letter combination has been generated, but some digits have not been exhausted. At this time, we take out the letters corresponding to the next digit, and then enumerate each letter corresponding to this digit one by one, add them to the letter combination that has been generated before, to form all possible combinations.

The time complexity is $O(4^n)$, and the space complexity is $O(n)$, where $n$ is the length of the input digits.

#### Java

```java
class Solution {
    private final String[] d = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private String digits;
    private List<String> ans = new ArrayList<>();
    private StringBuilder t = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        this.digits = digits;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i >= digits.length()) {
            ans.add(t.toString());
            return;
        }
        String s = d[digits.charAt(i) - '2'];
        for (char c : s.toCharArray()) {
            t.append(c);
            dfs(i + 1);
            t.deleteCharAt(t.length() - 1);
        }
    }
}
```
