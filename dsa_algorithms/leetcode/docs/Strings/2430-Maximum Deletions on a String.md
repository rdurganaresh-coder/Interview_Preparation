# 2430. Maximum Deletions on a String

**Difficulty:** Hard  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/maximum-deletions-on-a-string/

---

[中文文档](/solution/2400-2499/2430.Maximum%20Deletions%20on%20a%20String/README.md)

## Description

<p>You are given a string <code>s</code> consisting of only lowercase English letters. In one operation, you can:</p>

<ul>
	<li>Delete <strong>the entire string</strong> <code>s</code>, or</li>
	<li>Delete the <strong>first</strong> <code>i</code> letters of <code>s</code> if the first <code>i</code> letters of <code>s</code> are <strong>equal</strong> to the following <code>i</code> letters in <code>s</code>, for any <code>i</code> in the range <code>1 &lt;= i &lt;= s.length / 2</code>.</li>
</ul>

<p>For example, if <code>s = &quot;ababc&quot;</code>, then in one operation, you could delete the first two letters of <code>s</code> to get <code>&quot;abc&quot;</code>, since the first two letters of <code>s</code> and the following two letters of <code>s</code> are both equal to <code>&quot;ab&quot;</code>.</p>

<p>Return <em>the <strong>maximum</strong> number of operations needed to delete all of </em><code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcabcdabc&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong>
- Delete the first 3 letters (&quot;abc&quot;) since the next 3 letters are equal. Now, s = &quot;abcdabc&quot;.
- Delete all the letters.
We used 2 operations so return 2. It can be proven that 2 is the maximum number of operations needed.
Note that in the second operation we cannot delete &quot;abc&quot; again because the next occurrence of &quot;abc&quot; does not happen in the next 3 letters.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aaabaab&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong>
- Delete the first letter (&quot;a&quot;) since the next letter is equal. Now, s = &quot;aabaab&quot;.
- Delete the first 3 letters (&quot;aab&quot;) since the next 3 letters are equal. Now, s = &quot;aab&quot;.
- Delete the first letter (&quot;a&quot;) since the next letter is equal. Now, s = &quot;ab&quot;.
- Delete all the letters.
We used 4 operations so return 4. It can be proven that 4 is the maximum number of operations needed.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aaaaa&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> In each operation, we can delete the first letter of s.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 4000</code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Memoization Search

> **Thinking**
>
> With $n\le 4000$, an operation deletes a prefix that equals the next block of the same length. Search states collapse to the start $i$ of the remaining suffix. From $i$, try lengths $j$ and compare slices $s[i:i+j]$ and $s[i+j:i+2j]$; a match moves to $i+j$ with one extra deletion. Deleting everything at once is always legal, so the answer is at least $1$.
>
> Memoize $\textit{dfs}(i)$. Slice comparison is linear in $j$, and the total time $O(n^2)$ fits the limit.

We design a function $\textit{dfs}(i)$, which represents the maximum number of operations needed to delete all characters from $s[i..]$. The answer is $\textit{dfs}(0)$.

The calculation process of the function $\textit{dfs}(i)$ is as follows:

- If $i \geq n$, then $\textit{dfs}(i) = 0$, return directly.
- Otherwise, we enumerate the length of the string $j$, where $1 \leq j \leq (n-1)/2$. If $s[i..i+j] = s[i+j..i+j+j]$, we can delete $s[i..i+j]$, then $\textit{dfs}(i)=\max(\textit{dfs}(i), \textit{dfs}(i+j)+1)$. We need to enumerate all $j$ to find the maximum value of $\textit{dfs}(i)$.

Here we need to quickly determine whether $s[i..i+j]$ is equal to $s[i+j..i+j+j]$. We can preprocess all the longest common prefixes of string $s$, that is, $g[i][j]$ represents the length of the longest common prefix of $s[i..]$ and $s[j..]$. In this way, we can quickly determine whether $s[i..i+j]$ is equal to $s[i+j..i+j+j]$, that is, $g[i][i+j] \geq j$.

To avoid repeated calculations, we can use memoization search and use an array $f$ to record the value of the function $\textit{dfs}(i)$.

The time complexity is $O(n^2)$, and the space complexity is $O(n^2)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    private int n;
    private Integer[] f;
    private int[][] g;

    public int deleteString(String s) {
        n = s.length();
        f = new Integer[n];
        g = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    g[i][j] = g[i + 1][j + 1] + 1;
                }
            }
        }
        return dfs(0);
    }

    private int dfs(int i) {
        if (i == n) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        f[i] = 1;
        for (int j = 1; j <= (n - i) / 2; ++j) {
            if (g[i][i + j] >= j) {
                f[i] = Math.max(f[i], 1 + dfs(i + j));
            }
        }
        return f[i];
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> Method 1 compares slices repeatedly and pays recursion overhead. Precompute LCP $g[i][j]$ so equality is $g[i][i+j]\ge j$ in $O(1)$. Fill $f[i]$ from the back; besides the LCP table the DP is one-dimensional.

We can change the memoization search in Solution 1 to dynamic programming. Define $f[i]$ to represent the maximum number of operations needed to delete all characters from $s[i..]$. Initially, $f[i]=1$, and the answer is $f[0]$.

We can enumerate $i$ from back to front. For each $i$, we enumerate the length of the string $j$, where $1 \leq j \leq (n-1)/2$. If $s[i..i+j] = s[i+j..i+j+j]$, we can delete $s[i..i+j]$, then $f[i]=\max(f[i], f[i+j]+1)$. We need to enumerate all $j$ to find the maximum value of $f[i]$.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int deleteString(String s) {
        int n = s.length();
        int[][] g = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    g[i][j] = g[i + 1][j + 1] + 1;
                }
            }
        }
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            f[i] = 1;
            for (int j = 1; j <= (n - i) / 2; ++j) {
                if (g[i][i + j] >= j) {
                    f[i] = Math.max(f[i], f[i + j] + 1);
                }
            }
        }
        return f[0];
    }
}
```
