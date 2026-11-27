# 44. Wildcard Matching

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/wildcard-matching/

---

[中文文档](/solution/0000-0099/0044.Wildcard%20Matching/README.md)

## Description

<p>Given an input string (<code>s</code>) and a pattern (<code>p</code>), implement wildcard pattern matching with support for <code>&#39;?&#39;</code> and <code>&#39;*&#39;</code> where:</p>

<ul>
	<li><code>&#39;?&#39;</code> Matches any single character.</li>
	<li><code>&#39;*&#39;</code> Matches any sequence of characters (including the empty sequence).</li>
</ul>

<p>The matching should cover the <strong>entire</strong> input string (not partial).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aa&quot;, p = &quot;a&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> &quot;a&quot; does not match the entire string &quot;aa&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aa&quot;, p = &quot;*&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong>&nbsp;&#39;*&#39; matches any sequence.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cb&quot;, p = &quot;?a&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong>&nbsp;&#39;?&#39; matches &#39;c&#39;, but the second letter is &#39;a&#39;, which does not match &#39;b&#39;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length, p.length &lt;= 2000</code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
	<li><code>p</code> contains only lowercase English letters, <code>&#39;?&#39;</code> or <code>&#39;*&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Memoization Search

> **Thinking**
>
> The first idea is recurse character by character: literals and `?` match one, `*` eats empty or more. Correct, but without memo the `*` branches explode. $|s|, |p| \le 2000$ will time out.
>
> The bottleneck is asking the same suffix pair $(i, j)$ over and over. The state is only “does $s[i:]$ match $p[j:]$”; subproblems overlap heavily.
>
> Cache $\textit{dfs}(i, j)$. The three `*` moves (consume one, advance both, skip `*`) are transitions on that state. Memoization turns exponential search into $O(mn)$.

We design a function $\textit{dfs}(i, j)$, which represents whether the string $s$ starting from the $i$-th character matches the string $p$ starting from the $j$-th character. The answer is $\textit{dfs}(0, 0)$.

The execution process of the function $\textit{dfs}(i, j)$ is as follows:

- If $i \geq \textit{len}(s)$, then $\textit{dfs}(i, j)$ is true only when $j \geq \textit{len}(p)$ or $p[j] = '*'$ and $\textit{dfs}(i, j + 1)$ is true.
- If $j \geq \textit{len}(p)$, then $\textit{dfs}(i, j)$ is false.
- If $p[j] = '*'$, then $\textit{dfs}(i, j)$ is true if and only if $\textit{dfs}(i + 1, j)$ or $\textit{dfs}(i + 1, j + 1)$ or $\textit{dfs}(i, j + 1)$ is true.
- Otherwise, $\textit{dfs}(i, j)$ is true if and only if $p[j] = '?'$ or $s[i] = p[j]$ and $\textit{dfs}(i + 1, j + 1)$ is true.

To avoid repeated calculations, we use the method of memoization search and store the result of $\textit{dfs}(i, j)$ in a hash table.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the lengths of the strings $s$ and $p$, respectively.

#### Java

```java
class Solution {
    private Boolean[][] f;
    private char[] s;
    private char[] p;
    private int m;
    private int n;

    public boolean isMatch(String s, String p) {
        this.s = s.toCharArray();
        this.p = p.toCharArray();
        m = s.length();
        n = p.length();
        f = new Boolean[m][n];
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i >= m) {
            return j >= n || (p[j] == '*' && dfs(i, j + 1));
        }
        if (j >= n) {
            return false;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        if (p[j] == '*') {
            f[i][j] = dfs(i + 1, j) || dfs(i + 1, j + 1) || dfs(i, j + 1);
        } else {
            f[i][j] = (p[j] == '?' || s[i] == p[j]) && dfs(i + 1, j + 1);
        }
        return f[i][j];
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> Solution 1 already fills this match table from shorter prefixes to longer ones. The $f[i][j]$ below is that same table.

Solution 1 already fills this table from shorter prefixes to longer ones.

Define $f[i][j]$ to represent whether the first $i$ characters of string $s$ match the first $j$ characters of string $p$. Initially, $f[0][0] = \textit{true}$, indicating that two empty strings are matching. For $j \in [1, n]$, if $p[j-1] = '*'$, then $f[0][j] = f[0][j-1]$.

Next, we consider the case of $i \in [1, m]$ and $j \in [1, n]$:

- If $p[j-1] = '*'$, then $f[i][j] = f[i-1][j] \lor f[i][j-1] \lor f[i-1][j-1]$.
- Otherwise, $f[i][j] = (p[j-1] = '?' \lor s[i-1] = p[j-1]) \land f[i-1][j-1]$.

The final answer is $f[m][n]$.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the lengths of the strings $s$ and $p$, respectively.

#### Java

```java
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int j = 1; j <= n; ++j) {
            if (p.charAt(j - 1) == '*') {
                f[0][j] = f[0][j - 1];
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i - 1][j] || f[i][j - 1] || f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i - 1][j - 1]
                        && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1));
                }
            }
        }
        return f[m][n];
    }
}
```

### Solution 3: Dynamic Programming

> **Thinking**
>
> Matching one character at a time is the natural first idea: a literal or `?` consumes one character, and `*` consumes the empty string or any run. Both strings can have length $2000$, and the first move on `*` is always $\textit{dfs}(i+1, j)$, so that chain is as deep as $|s|$ and exceeds the default recursion limit.
>
> The same index pair is asked repeatedly, and whether two prefixes match depends only on shorter prefixes.
>
> Let $f[i][j]$ mean the first $i$ characters of $s$ match the first $j$ characters of $p$. The empty pair is true, and a run of `*` on the pattern inherits along $j$. Filling $i$ and $j$ from small to large works because a `*` reads the cell above, the cell to the left, and the diagonal, while a literal or `?` reads only the diagonal.

Define $f[i][j]$ to represent whether the first $i$ characters of string $s$ match the first $j$ characters of string $p$. Initially, $f[0][0] = \textit{true}$, indicating that two empty strings are matching. For $j \in [1, n]$, if $p[j-1] = '*'$, then $f[0][j] = f[0][j-1]$.

Next, we consider the case of $i \in [1, m]$ and $j \in [1, n]$:

- If $p[j-1] = '*'$, then $f[i][j] = f[i-1][j] \lor f[i][j-1] \lor f[i-1][j-1]$.
- Otherwise, $f[i][j] = (p[j-1] = '?' \lor s[i-1] = p[j-1]) \land f[i-1][j-1]$.

The final answer is $f[m][n]$.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the lengths of the strings $s$ and $p$, respectively.

#### Java

```java
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int j = 1; j <= n; ++j) {
            if (p.charAt(j - 1) == '*') {
                f[0][j] = f[0][j - 1];
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i - 1][j] || f[i][j - 1] || f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i - 1][j - 1]
                        && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1));
                }
            }
        }
        return f[m][n];
    }
}
```
