# 131. Palindrome Partitioning

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/palindrome-partitioning/

---

[中文文档](/solution/0100-0199/0131.Palindrome%20Partitioning/README.md)

## Description

<p>Given a string <code>s</code>, partition <code>s</code> such that every <span data-keyword="substring-nonempty">substring</span> of the partition is a <span data-keyword="palindrome-string"><strong>palindrome</strong></span>. Return <em>all possible palindrome partitioning of </em><code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "aab"
<strong>Output:</strong> [["a","a","b"],["aa","b"]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "a"
<strong>Output:</strong> [["a"]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 16</code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Preprocessing + DFS (Backtracking)

> **Thinking**
>
> List every way to cut $s$ into palindromic pieces. $n\le 16$, so at most $2^{n-1}$ partitions; backtracking is fine. Checking palindromes at each cut rescans the same spans.
>
> Precompute $f[i][j]$ whether $s[i..j]$ is a palindrome, then try the next cut only when $f[i][j]$ is true.

We can use dynamic programming to preprocess whether any substring in the string is a palindrome, i.e., $f[i][j]$ indicates whether the substring $s[i..j]$ is a palindrome.

Next, we design a function $\textit{dfs}(i)$, which represents starting from the $i$-th character of the string and partitioning it into several palindromic substrings, with the current partition scheme being $t$.

If $i = |s|$, it means the partitioning is complete, and we add $t$ to the answer array and then return.

Otherwise, we can start from $i$ and enumerate the end position $j$ from small to large. If $s[i..j]$ is a palindrome, we add $s[i..j]$ to $t$, then continue to recursively call $\textit{dfs}(j+1)$. When backtracking, we need to pop $s[i..j]$.

The time complexity is $O(n 2^n)$, and the space complexity is $O(n^2)$, where $n$ is the length of the string.

#### Java

```java
class Solution {
    private int n;
    private String s;
    private boolean[][] f;
    private List<String> t = new ArrayList<>();
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }
        this.s = s;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                t.add(s.substring(i, j + 1));
                dfs(j + 1);
                t.remove(t.size() - 1);
            }
        }
    }
}
```
