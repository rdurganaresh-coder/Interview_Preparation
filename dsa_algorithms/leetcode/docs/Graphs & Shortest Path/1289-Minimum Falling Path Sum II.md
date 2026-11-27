# 1289. Minimum Falling Path Sum II

**Difficulty:** Hard  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/minimum-falling-path-sum-ii/

---

[中文文档](/solution/1200-1299/1289.Minimum%20Falling%20Path%20Sum%20II/README.md)

## Description

<p>Given an <code>n x n</code> integer matrix <code>grid</code>, return <em>the minimum sum of a <strong>falling path with non-zero shifts</strong></em>.</p>

<p>A <strong>falling path with non-zero shifts</strong> is a choice of exactly one element from each row of <code>grid</code> such that no two elements chosen in adjacent rows are in the same column.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1200-1299/1289.Minimum%20Falling%20Path%20Sum%20II/images/falling-grid.jpg" style="width: 244px; height: 245px;" />
<pre>
<strong>Input:</strong> grid = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> 13
<strong>Explanation:</strong> 
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is&nbsp;[1,5,7], so the answer is&nbsp;13.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[7]]
<strong>Output:</strong> 7
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == grid.length == grid[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 200</code></li>
	<li><code>-99 &lt;= grid[i][j] &lt;= 99</code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming (Rolling Array)

> **Thinking**
>
> A falling path cannot reuse a column on the next row. $n \le 200$ allows $O(n^3)$. The best way to end row $i$ in column $j$ is the previous row's minimum excluding $j$, plus $\textit{grid}[i][j]$.
>
> We keep only the previous $n$ values and add “min except this column” in place. A rolling array drops the row dimension.

Let $f[i][j]$ be the minimum path sum using the first $i$ rows and ending in column $j$:

$$
f[i][j] = \min_{k \neq j} f[i - 1][k] + \textit{grid}[i - 1][j]
$$

The answer is $\min_{0 \leq j < n} f[n][j]$. After rolling, only the last row remains, so this is the minimum of the 1D array $f$.

$f[i][j]$ depends only on the previous row, so we keep two arrays $f$ and $g$ of length $n$.

The time complexity is $O(n^3)$, and the space complexity is $O(n)$, where $n$ is the number of rows.

#### Java

```java
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] f = new int[n];
        final int inf = 1 << 30;
        for (int[] row : grid) {
            int[] g = row.clone();
            for (int i = 0; i < n; ++i) {
                int t = inf;
                for (int j = 0; j < n; ++j) {
                    if (j != i) {
                        t = Math.min(t, f[j]);
                    }
                }
                g[i] += (t == inf ? 0 : t);
            }
            f = g;
        }
        return Arrays.stream(f).min().getAsInt();
    }
}
```
