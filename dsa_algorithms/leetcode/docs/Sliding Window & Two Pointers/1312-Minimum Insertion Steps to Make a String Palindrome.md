# 1312. Minimum Insertion Steps to Make a String Palindrome

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

---

[中文文档](/solution/1300-1399/1312.Minimum%20Insertion%20Steps%20to%20Make%20a%20String%20Palindrome/README.md)

## Description

<p>Given a string <code>s</code>. In one step you can insert any character at any index of the string.</p>

<p>Return <em>the minimum number of steps</em> to make <code>s</code>&nbsp;palindrome.</p>

<p>A&nbsp;<b>Palindrome String</b>&nbsp;is one that reads the same backward as well as forward.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;zzazz&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> The string &quot;zzazz&quot; is already palindrome we do not need any insertions.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;mbadm&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> String can be &quot;mbdadbm&quot; or &quot;mdbabdm&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;leetcode&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> Inserting 5 characters the string becomes &quot;leetcodocteel&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 500</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> We want the fewest insertions that make $s$ a palindrome. Enumerating insertion plans is hopeless for $n \le 500$. A subproblem is an interval: matching ends reduce to the open interval; otherwise we insert a copy of one end beside the other and take the cheaper side plus one.
>
> Intervals overlap, so the same $(i,j)$ is asked many times. Memoizing $\textit{dfs}(i,j)$ evaluates each interval once, in $O(n^2)$.

#### Java

```java
class Solution {
    private Integer[][] f;
    private String s;

    public int minInsertions(String s) {
        this.s = s;
        int n = s.length();
        f = new Integer[n][n];
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = 1 << 30;
        if (s.charAt(i) == s.charAt(j)) {
            ans = dfs(i + 1, j - 1);
        } else {
            ans = Math.min(dfs(i + 1, j), dfs(i, j - 1)) + 1;
        }
        return f[i][j] = ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Memoization still uses a call stack and a cache. The same recurrence as a table $f[i][j]$, filled with $i$ decreasing and $j$ increasing, makes $f[i+1][j-1]$, $f[i+1][j]$, and $f[i][j-1]$ already known, so the recursion disappears.

#### Java

```java
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i + 1][j], f[i][j - 1]) + 1;
                }
            }
        }
        return f[0][n - 1];
    }
}
```

### Solution 3

> **Thinking**
>
> Filling by endpoint indices is only one valid order. Enumerating interval length $k$ and then the left end $i$ (with $j=i+k-1$) computes shorter intervals first. The transition is unchanged; only an outer length loop is added.

#### Java

```java
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int k = 2; k <= n; ++k) {
            for (int i = 0; i + k - 1 < n; ++i) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i + 1][j], f[i][j - 1]) + 1;
                }
            }
        }
        return f[0][n - 1];
    }
}
```
