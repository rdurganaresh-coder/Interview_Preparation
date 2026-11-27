# 1771. Maximize Palindrome Length From Subsequences

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/maximize-palindrome-length-from-subsequences/

---

[中文文档](/solution/1700-1799/1771.Maximize%20Palindrome%20Length%20From%20Subsequences/README.md)

## Description

<p>You are given two strings, <code>word1</code> and <code>word2</code>. You want to construct a string in the following manner:</p>

<ul>
	<li>Choose some <strong>non-empty</strong> subsequence <code>subsequence1</code> from <code>word1</code>.</li>
	<li>Choose some <strong>non-empty</strong> subsequence <code>subsequence2</code> from <code>word2</code>.</li>
	<li>Concatenate the subsequences: <code>subsequence1 + subsequence2</code>, to make the string.</li>
</ul>

<p>Return <em>the <strong>length</strong> of the longest <strong>palindrome</strong> that can be constructed in the described manner. </em>If no palindromes can be constructed, return <code>0</code>.</p>

<p>A <strong>subsequence</strong> of a string <code>s</code> is a string that can be made by deleting some (possibly none) characters from <code>s</code> without changing the order of the remaining characters.</p>

<p>A <strong>palindrome</strong> is a string that reads the same forward&nbsp;as well as backward.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> word1 = &quot;cacb&quot;, word2 = &quot;cbba&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> Choose &quot;ab&quot; from word1 and &quot;cba&quot; from word2 to make &quot;abcba&quot;, which is a palindrome.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> word1 = &quot;ab&quot;, word2 = &quot;ab&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> Choose &quot;ab&quot; from word1 and &quot;a&quot; from word2 to make &quot;aba&quot;, which is a palindrome.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> word1 = &quot;aa&quot;, word2 = &quot;bb&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> You cannot construct a palindrome from the described method, so return 0.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word1.length, word2.length &lt;= 1000</code></li>
	<li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> Pick a nonempty subsequence from each word and concatenate them into a palindrome. That is LPS on $s=\textit{word1}+\textit{word2}$, with the two ends coming from different words.
>
> $f[i][j]$ is the LPS of $s[i..j]$. Equal ends add $2$ to the inside, and we record the length when $i$ is in the first word and $j$ in the second; unequal ends take the better one-sided state.

First, we concatenate strings $\textit{word1}$ and $\textit{word2}$ to get string $s$. Then we can transform the problem into finding the length of the longest palindromic subsequence in string $s$. However, when calculating the final answer, we need to ensure that at least one character in the palindrome string comes from $\textit{word1}$ and another character comes from $\textit{word2}$.

We define $f[i][j]$ as the length of the longest palindromic subsequence in the substring of string $s$ with index range $[i, j]$.

If $s[i] = s[j]$, then $s[i]$ and $s[j]$ must be in the longest palindromic subsequence, at this time $f[i][j] = f[i + 1][j - 1] + 2$. At this point, we also need to judge whether $s[i]$ and $s[j]$ come from $\textit{word1}$ and $\textit{word2}$. If so, we update the maximum value of the answer to $\textit{ans}=\max(\textit{ans}, f[i][j])$.

If $s[i] \neq s[j]$, then $s[i]$ and $s[j]$ will definitely not appear in the longest palindromic subsequence at the same time, at this time $f[i][j] = \max(f[i + 1][j], f[i][j - 1])$.

Finally, we return the answer.

The time complexity is $O(n^2)$, and the space complexity is $O(n^2)$, where $n$ is the length of string $s$.

#### Java

```java
class Solution {
    public int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][i] = 1;
        }
        int ans = 0;
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                    if (i < word1.length() && j >= word1.length()) {
                        ans = Math.max(ans, f[i][j]);
                    }
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return ans;
    }
}
```
