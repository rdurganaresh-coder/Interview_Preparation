# 3290. Maximum Multiplication Score

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/maximum-multiplication-score/

---

[中文文档](/solution/3200-3299/3290.Maximum%20Multiplication%20Score/README.md)

## Description

<p>You are given an integer array <code>a</code> of size 4 and another integer array <code>b</code> of size <strong>at least</strong> 4.</p>

<p>You need to choose 4 indices <code>i<sub>0</sub></code>, <code>i<sub>1</sub></code>, <code>i<sub>2</sub></code>, and <code>i<sub>3</sub></code> from the array <code>b</code> such that <code>i<sub>0</sub> &lt; i<sub>1</sub> &lt; i<sub>2</sub> &lt; i<sub>3</sub></code>. Your score will be equal to the value <code>a[0] * b[i<sub>0</sub>] + a[1] * b[i<sub>1</sub>] + a[2] * b[i<sub>2</sub>] + a[3] * b[i<sub>3</sub>]</code>.</p>

<p>Return the <strong>maximum</strong> score you can achieve.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">a = [3,2,5,6], b = [2,-6,4,-5,-3,2,-7]</span></p>

<p><strong>Output:</strong> <span class="example-io">26</span></p>

<p><strong>Explanation:</strong><br />
We can choose the indices 0, 1, 2, and 5. The score will be <code>3 * 2 + 2 * (-6) + 5 * 4 + 6 * 2 = 26</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">a = [-1,4,5,-2], b = [-5,-1,-3,-2,-4]</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong><br />
We can choose the indices 0, 1, 3, and 4. The score will be <code>(-1) * (-5) + 4 * (-1) + 5 * (-2) + (-2) * (-4) = -1</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>a.length == 4</code></li>
	<li><code>4 &lt;= b.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= a[i], b[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Memoization

> **Thinking**
>
> $a$ has four entries; we pick four increasing indices in $b$ and maximize the dot product. $|b|\le 10^5$ forbids $O(n^4)$ index tuples. There are only four stages, so we DP on the position in $b$.
>
> $\textit{dfs}(i,j)$: $i$ of $a$ used, at $b[j]$. Skip $b[j]$, or take $a[i]\times b[j]$ and advance both. Memoized states are $4\times n$.

We design a function $\textit{dfs}(i, j)$, which represents the maximum score that can be obtained starting from the $i$-th element of array $a$ and the $j$-th element of array $b$. Then the answer is $\textit{dfs}(0, 0)$.

The function $\textit{dfs}(i, j)$ is calculated as follows:

- If $j \geq \textit{len}(b)$, it means array $b$ has been completely traversed. At this point, if array $a$ has also been completely traversed, return $0$; otherwise, return negative infinity.
- If $i \geq \textit{len}(a)$, it means array $a$ has been completely traversed. Return $0$.
- Otherwise, we can either skip the $j$-th element of array $b$ and move to the next element, i.e., $\textit{dfs}(i, j + 1)$; or we can choose the $j$-th element of array $b$, in which case the score is $a[i] \times b[j]$ plus $\textit{dfs}(i + 1, j + 1)$. We take the maximum of these two values as the return value of $\textit{dfs}(i, j)$.

We can use memoization to avoid redundant calculations.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the lengths of arrays $a$ and $b$, respectively.

#### Java

```java
class Solution {
    private Long[][] f;
    private int[] a;
    private int[] b;

    public long maxScore(int[] a, int[] b) {
        f = new Long[a.length][b.length];
        this.a = a;
        this.b = b;
        return dfs(0, 0);
    }

    private long dfs(int i, int j) {
        if (j >= b.length) {
            return i >= a.length ? 0 : Long.MIN_VALUE / 2;
        }
        if (i >= a.length) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        return f[i][j] = Math.max(dfs(i, j + 1), 1L * a[i] * b[j] + dfs(i + 1, j + 1));
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> $a$ has four entries; we pick four increasing indices in $b$ and maximize the dot product. $|b|\le 10^5$ forbids $O(n^4)$ index tuples. There are only four stages, so the position in $b$ is the other axis.
>
> From stage $i$ at $b[j]$, the next choice is either $b[j+1]$ with the same stage, or $b[j+1]$ at stage $i+1$ after adding $a[i]\times b[j]$. A search of that recurrence still calls $j+1$ before it returns, so the chain has depth $n$ and overflows the stack.
>
> Column $j+1$ is known if we walk from the end of $b$. Let $f[i][j]$ be the best score, with $f[i][n]$ equal to $0$ once every entry of $a$ is used and negative infinity otherwise.
>
> Fill $j$ from $n-1$ down to $0$ and return $f[0][0]$.

Let $f[i][j]$ be the maximum score starting from the $i$-th element of array $a$ and the $j$-th element of array $b$. The answer is $f[0][0]$.

If $j = n$, array $b$ is finished. The value is $0$ when array $a$ is also finished, and negative infinity otherwise. If $i = m$, array $a$ is finished, so the remaining suffix of $b$ scores $0$.

Otherwise we either skip $b[j]$, which scores $f[i][j + 1]$, or take it, which scores $a[i] \times b[j] + f[i + 1][j + 1]$. $f[i][j]$ is the larger of the two.

We calculate $f$ from $j = n - 1$ down to $0$.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the lengths of arrays $a$ and $b$, respectively.

#### Java

```java
class Solution {
    public long maxScore(int[] a, int[] b) {
        int m = a.length, n = b.length;
        long[][] f = new long[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            f[i][n] = Long.MIN_VALUE / 2;
        }
        for (int j = n - 1; j >= 0; --j) {
            for (int i = m - 1; i >= 0; --i) {
                f[i][j] = Math.max(f[i][j + 1], 1L * a[i] * b[j] + f[i + 1][j + 1]);
            }
        }
        return f[0][0];
    }
}
```
