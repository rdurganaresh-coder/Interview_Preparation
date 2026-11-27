# 3407. Substring Matching Pattern

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/substring-matching-pattern/

---

[中文文档](/solution/3400-3499/3407.Substring%20Matching%20Pattern/README.md)

## Description

<p>You are given a string <code>s</code> and a pattern string <code>p</code>, where <code>p</code> contains <strong>exactly one</strong> <code>&#39;*&#39;</code> character.</p>

<p>The <code>&#39;*&#39;</code> in <code>p</code> can be replaced with any sequence of zero or more characters.</p>

<p>Return <code>true</code> if <code>p</code> can be made a <span data-keyword="substring-nonempty">substring</span> of <code>s</code>, and <code>false</code> otherwise.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;leetcode&quot;, p = &quot;ee*e&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>By replacing the <code>&#39;*&#39;</code> with <code>&quot;tcod&quot;</code>, the substring <code>&quot;eetcode&quot;</code> matches the pattern.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;car&quot;, p = &quot;c*v&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>There is no substring matching the pattern.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;luck&quot;, p = &quot;u*&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>The substrings <code>&quot;u&quot;</code>, <code>&quot;uc&quot;</code>, and <code>&quot;uck&quot;</code> match the pattern.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 50</code></li>
	<li><code>1 &lt;= p.length &lt;= 50 </code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
	<li><code>p</code> contains only lowercase English letters and exactly one <code>&#39;*&#39;</code></li>
</ul>

## Solutions

### Solution 1: String Matching

> **Thinking**
>
> $p$ contains a single $*$, and both strings are at most length $50$, so even backtracking would pass. We only need the literal pieces on both sides of the star to appear in order in $s$, with any (possibly empty) gap between them.
>
> Matching $p$ as a regex against the entire $s$ would confuse “substring” with “whole-string match”. The star-expanded pattern only has to be some substring of $s$.
>
> We therefore split $p$ on $*$, then $\textit{find}$ each literal from left to right, moving the start pointer forward only. If any piece is missing, the answer is false.

According to the problem description, `*` can be replaced by any sequence of zero or more characters, so we can split the pattern string $p$ by `*` into several substrings. If these substrings appear in order in the string $s$, then $p$ can become a substring of $s$.

Therefore, we first initialize a pointer $i$ to the start of string $s$, then iterate over each substring $t$ obtained by splitting the pattern string $p$ by `*`. For each $t$, we search for it in $s$ starting from position $i$. If it is found, we move the pointer $i$ to the end of $t$ and continue searching for the next substring. If it is not found, it means the pattern string $p$ cannot become a substring of $s$, and we return $\textit{false}$. If all substrings are found, we return $\textit{true}$.

The time complexity is $O(nm)$, and the space complexity is $O(m)$, where $n$ and $m$ are the lengths of strings $s$ and $p$, respectively.

#### Java

```java
class Solution {
    public boolean hasMatch(String s, String p) {
        int i = 0;
        for (String t : p.split("\\*")) {
            int j = s.indexOf(t, i);
            if (j == -1) {
                return false;
            }
            i = j + t.length();
        }
        return true;
    }
}
```
