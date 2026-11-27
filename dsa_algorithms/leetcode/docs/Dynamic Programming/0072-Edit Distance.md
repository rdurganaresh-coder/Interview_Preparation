# 72. Edit Distance

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/edit-distance/

---

[中文文档](/solution/0000-0099/0072.Edit%20Distance/README.md)

## Description

<p>Given two strings <code>word1</code> and <code>word2</code>, return <em>the minimum number of operations required to convert <code>word1</code> to <code>word2</code></em>.</p>

<p>You have the following three operations permitted on a word:</p>

<ul>
	<li>Insert a character</li>
	<li>Delete a character</li>
	<li>Replace a character</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> word1 = &quot;horse&quot;, word2 = &quot;ros&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> 
horse -&gt; rorse (replace &#39;h&#39; with &#39;r&#39;)
rorse -&gt; rose (remove &#39;r&#39;)
rose -&gt; ros (remove &#39;e&#39;)
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> word1 = &quot;intention&quot;, word2 = &quot;execution&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> 
intention -&gt; inention (remove &#39;t&#39;)
inention -&gt; enention (replace &#39;i&#39; with &#39;e&#39;)
enention -&gt; exention (replace &#39;n&#39; with &#39;x&#39;)
exention -&gt; exection (replace &#39;n&#39; with &#39;c&#39;)
exection -&gt; execution (insert &#39;u&#39;)
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li>
	<li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> The first idea is recursion: at each position of $\textit{word1}$ try insert, delete, or replace, then take the best. Correct, but exponential. $m,n \le 500$ needs a polynomial.
>
> The bottleneck is overlapping subproblems — converting prefix $i$ into prefix $j$ is solved many times. Let $f[i][j]$ be that minimum. Equal last characters inherit the diagonal; otherwise the three operations map to three neighbors, take $\min$ plus one. Empty-string borders are delete-all / insert-all. The answer is $f[m][n]$.

We define $f[i][j]$ as the minimum number of operations to convert $\textit{word1}$ of length $i$ to $\textit{word2}$ of length $j$. $f[i][0] = i$, $f[0][j] = j$, $i \in [1, m], j \in [0, n]$.

We consider $f[i][j]$:

- If $\textit{word1}[i - 1] = \textit{word2}[j - 1]$, then we only need to consider the minimum number of operations to convert $\textit{word1}$ of length $i - 1$ to $\textit{word2}$ of length $j - 1$, so $f[i][j] = f[i - 1][j - 1]$;
- Otherwise, we can consider insert, delete, and replace operations, then $f[i][j] = \min(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1]) + 1$.

Finally, we can get the state transition equation:

$$
f[i][j] = \begin{cases}
i, & \text{if } j = 0 \\
j, & \text{if } i = 0 \\
f[i - 1][j - 1], & \text{if } \textit{word1}[i - 1] = \textit{word2}[j - 1] \\
\min(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1]) + 1, & \text{otherwise}
\end{cases}
$$

Finally, we return $f[m][n]$.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the lengths of $\textit{word1}$ and $\textit{word2}$ respectively.

#### Java

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int j = 1; j <= n; ++j) {
            f[0][j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            f[i][0] = i;
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j - 1], f[i - 1][j - 1])) + 1;
                }
            }
        }
        return f[m][n];
    }
}
```
