# 1638. Count Substrings That Differ by One Character

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/count-substrings-that-differ-by-one-character/

---

[中文文档](/solution/1600-1699/1638.Count%20Substrings%20That%20Differ%20by%20One%20Character/README.md)

## Description

<p>Given two strings <code>s</code> and <code>t</code>, find the number of ways you can choose a non-empty substring of <code>s</code> and replace a <strong>single character</strong> by a different character such that the resulting substring is a substring of <code>t</code>. In other words, find the number of substrings in <code>s</code> that differ from some substring in <code>t</code> by <strong>exactly</strong> one character.</p>

<p>For example, the underlined substrings in <code>&quot;<u>compute</u>r&quot;</code> and <code>&quot;<u>computa</u>tion&quot;</code> only differ by the <code>&#39;e&#39;</code>/<code>&#39;a&#39;</code>, so this is a valid way.</p>

<p>Return <em>the number of substrings that satisfy the condition above.</em></p>

<p>A <strong>substring</strong> is a contiguous sequence of characters within a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aba&quot;, t = &quot;baba&quot;
<strong>Output:</strong> 6
<strong>Explanation:</strong> The following are the pairs of substrings from s and t that differ by exactly 1 character:
(&quot;<u>a</u>ba&quot;, &quot;<u>b</u>aba&quot;)
(&quot;<u>a</u>ba&quot;, &quot;ba<u>b</u>a&quot;)
(&quot;ab<u>a</u>&quot;, &quot;<u>b</u>aba&quot;)
(&quot;ab<u>a</u>&quot;, &quot;ba<u>b</u>a&quot;)
(&quot;a<u>b</u>a&quot;, &quot;b<u>a</u>ba&quot;)
(&quot;a<u>b</u>a&quot;, &quot;bab<u>a</u>&quot;)
The underlined portions are the substrings that are chosen from s and t.
</pre>

​​<strong class="example">Example 2:</strong>

<pre>
<strong>Input:</strong> s = &quot;ab&quot;, t = &quot;bb&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The following are the pairs of substrings from s and t that differ by 1 character:
(&quot;<u>a</u>b&quot;, &quot;<u>b</u>b&quot;)
(&quot;<u>a</u>b&quot;, &quot;b<u>b</u>&quot;)
(&quot;<u>ab</u>&quot;, &quot;<u>bb</u>&quot;)
​​​​The underlined portions are the substrings that are chosen from s and t.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, t.length &lt;= 100</code></li>
	<li><code>s</code> and <code>t</code> consist of lowercase English letters only.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Both strings have length at most $100$. A valid pair differs in exactly one position; extending from that mismatch, the runs of equal characters on each side determine how many cuts work.
>
> Enumerate $(i,j)$ with $s[i]\ne t[j]$, measure equal spans $l$ and $r$, and add $(l+1)(r+1)$.

#### Java

```java
class Solution {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        int m = s.length(), n = t.length();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s.charAt(i) != t.charAt(j)) {
                    int l = 0, r = 0;
                    while (i - l > 0 && j - l > 0 && s.charAt(i - l - 1) == t.charAt(j - l - 1)) {
                        ++l;
                    }
                    while (i + r + 1 < m && j + r + 1 < n
                        && s.charAt(i + r + 1) == t.charAt(j + r + 1)) {
                        ++r;
                    }
                    ans += (l + 1) * (r + 1);
                }
            }
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 extends from every mismatch and repeats comparisons. Precompute the longest equal suffix $f$ ending at $(i,j)$ and the longest equal prefix $g$ starting there.
>
> Each mismatch then contributes $(f[i][j]+1)(g[i+1][j+1]+1)$ in $O(mn)$ total time.

#### Java

```java
class Solution {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        int m = s.length(), n = t.length();
        int[][] f = new int[m + 1][n + 1];
        int[][] g = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s.charAt(i) == t.charAt(j)) {
                    f[i + 1][j + 1] = f[i][j] + 1;
                }
            }
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (s.charAt(i) == t.charAt(j)) {
                    g[i][j] = g[i + 1][j + 1] + 1;
                } else {
                    ans += (f[i][j] + 1) * (g[i + 1][j + 1] + 1);
                }
            }
        }
        return ans;
    }
}
```
