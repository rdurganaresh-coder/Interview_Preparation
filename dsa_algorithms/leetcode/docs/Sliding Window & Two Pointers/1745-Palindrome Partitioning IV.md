# 1745. Palindrome Partitioning IV

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/palindrome-partitioning-iv/

---

[中文文档](/solution/1700-1799/1745.Palindrome%20Partitioning%20IV/README.md)

## Description

<p>Given a string <code>s</code>, return <code>true</code> <em>if it is possible to split the string</em> <code>s</code> <em>into three <strong>non-empty</strong> palindromic substrings. Otherwise, return </em><code>false</code>.​​​​​</p>

<p>A string is said to be palindrome if it the same string when reversed.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcbdd&quot;
<strong>Output:</strong> true
<strong>Explanation: </strong>&quot;abcbdd&quot; = &quot;a&quot; + &quot;bcb&quot; + &quot;dd&quot;, and all three substrings are palindromes.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;bcbddxy&quot;
<strong>Output:</strong> false
<strong>Explanation: </strong>s cannot be split into 3 palindromes.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= s.length &lt;= 2000</code></li>
	<li><code>s</code>​​​​​​ consists only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> Split the string into three palindromes. Checking each candidate split from scratch is $O(n^3)$ palindrome tests. $n$ can be a few hundred, so precompute palindromes.
>
> $f[i][j]$ is whether $s[i..j]$ is a palindrome. After filling it by interval length, try two cuts; the total is $O(n^2)$.

We define $f[i][j]$ to indicate whether the substring of $s$ from the $i$-th character to the $j$-th character is a palindrome, initially $f[i][j] = \textit{true}$.

Then we can calculate $f[i][j]$ using the following state transition equation:

$$
f[i][j] = \begin{cases}
\textit{true}, & \text{if } s[i] = s[j] \text{ and } (i + 1 = j \text{ or } f[i + 1][j - 1]) \\
\textit{false}, & \text{otherwise}
\end{cases}
$$

Since $f[i][j]$ depends on $f[i + 1][j - 1]$, we need to enumerate $i$ from large to small and $j$ from small to large, so that when calculating $f[i][j]$, $f[i + 1][j - 1]$ has already been calculated.

Next, we enumerate the right endpoint $i$ of the first substring and the right endpoint $j$ of the second substring. The left endpoint of the third substring can be enumerated in the range $[j + 1, n - 1]$, where $n$ is the length of the string $s$. If the first substring $s[0..i]$, the second substring $s[i+1..j]$, and the third substring $s[j+1..n-1]$ are all palindromes, then we have found a feasible partitioning scheme and return $\textit{true}$.

After enumerating all partitioning schemes, if no valid partitioning scheme is found, return $\textit{false}$.

The time complexity is $O(n^2)$, and the space complexity is $O(n^2)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (var g : f) {
            Arrays.fill(g, true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 == j || f[i + 1][j - 1]);
            }
        }
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                if (f[0][i] && f[i + 1][j] && f[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
```
