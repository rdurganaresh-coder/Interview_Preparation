# 2486. Append Characters to String to Make Subsequence

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/

---

[中文文档](/solution/2400-2499/2486.Append%20Characters%20to%20String%20to%20Make%20Subsequence/README.md)

## Description

<p>You are given two strings <code>s</code> and <code>t</code> consisting of only lowercase English letters.</p>

<p>Return <em>the minimum number of characters that need to be appended to the end of </em><code>s</code><em> so that </em><code>t</code><em> becomes a <strong>subsequence</strong> of </em><code>s</code>.</p>

<p>A <strong>subsequence</strong> is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;coaching&quot;, t = &quot;coding&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong> Append the characters &quot;ding&quot; to the end of s so that s = &quot;coachingding&quot;.
Now, t is a subsequence of s (&quot;<u><strong>co</strong></u>aching<u><strong>ding</strong></u>&quot;).
It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcde&quot;, t = &quot;a&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> t is already a subsequence of s (&quot;<u><strong>a</strong></u>bcde&quot;).
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;z&quot;, t = &quot;abcde&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> Append the characters &quot;abcde&quot; to the end of s so that s = &quot;zabcde&quot;.
Now, t is a subsequence of s (&quot;z<u><strong>abcde</strong></u>&quot;).
It can be shown that appending any 4 characters to the end of s will never make t a subsequence.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, t.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> and <code>t</code> consist only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> We may only append to $s$ so that $t$ becomes a subsequence; the extra length is the unmatched suffix of $t$. At $n\le 10^5$, greedily match $t$'s prefix inside $s$ and return $n-j$.

We define two pointers $i$ and $j$, pointing to the first characters of strings $s$ and $t$ respectively. We iterate through string $s$, if $s[i] = t[j]$, then we move $j$ one step forward. Finally, we return $n - j$, where $n$ is the length of string $t$.

The time complexity is $O(m + n)$, and the space complexity is $O(1)$, where $m$ and $n$ are the lengths of strings $s$ and $t$ respectively.

#### Java

```java
class Solution {
    public int appendCharacters(String s, String t) {
        int n = t.length(), j = 0;
        for (int i = 0; i < s.length() && j < n; ++i) {
            if (s.charAt(i) == t.charAt(j)) {
                ++j;
            }
        }
        return n - j;
    }
}
```
