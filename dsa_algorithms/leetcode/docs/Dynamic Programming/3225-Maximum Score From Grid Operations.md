# 3225. Maximum Score From Grid Operations

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/maximum-score-from-grid-operations/

---

[中文文档](/solution/3200-3299/3225.Maximum%20Score%20From%20Grid%20Operations/README.md)

## Description

<p>You are given a 2D matrix <code>grid</code> of size <code>n x n</code>. Initially, all cells of the grid are colored white. In one operation, you can select any cell of indices <code>(i, j)</code>, and color black all the cells of the <code>j<sup>th</sup></code> column starting from the top row down to the <code>i<sup>th</sup></code> row.</p>

<p>The grid score is the sum of all <code>grid[i][j]</code> such that cell <code>(i, j)</code> is white and it has a horizontally adjacent black cell.</p>

<p>Return the <strong>maximum</strong> score that can be achieved after some number of operations.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[0,0,0,0,0],[0,0,3,0,0],[0,1,0,0,0],[5,0,0,3,0],[0,0,0,0,2]]</span></p>

<p><strong>Output:</strong> <span class="example-io">11</span></p>

<p><strong>Explanation:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3200-3299/3225.Maximum%20Score%20From%20Grid%20Operations/images/one.png" style="width: 300px; height: 200px;" />
<p>In the first operation, we color all cells in column 1 down to row 3, and in the second operation, we color all cells in column 4 down to the last row. The score of the resulting grid is <code>grid[3][0] + grid[1][2] + grid[3][3]</code> which is equal to 11.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[10,9,0,0,15],[7,1,0,8,0],[5,20,0,11,0],[0,0,0,1,2],[8,12,1,10,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">94</span></p>

<p><strong>Explanation:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3200-3299/3225.Maximum%20Score%20From%20Grid%20Operations/images/two-1.png" style="width: 300px; height: 200px;" />
<p>We perform operations on 1, 2, and 3 down to rows 1, 4, and 0, respectively. The score of the resulting grid is <code>grid[0][0] + grid[1][0] + grid[2][1] + grid[4][1] + grid[1][3] + grid[2][3] + grid[3][3] + grid[4][3] + grid[0][4]</code> which is equal to 94.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;n == grid.length &lt;= 100</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming + Prefix Sum

> **Thinking**
>
> Each column is painted black from the top for some height; a white cell scores only if a neighbor column is black there. $n\le 100$, so enumerating height tuples is $(n+1)^n$. Column $j$'s score depends only on its height and its two neighbors, which suggests a column DP.
>
> $f[h_1][h_2]$ is the best score with current height $h_1$ and previous height $h_2$. When enumerating the next height, $\max(h_2,h_p)$ makes the addend piecewise, so prefix/suffix maxima over $h_2$ drop a column from $O(n^3)$ to $O(n^2)$. Column prefix sums precompute white-range totals.

For each column $j$, let $k[j] \in \{0, 1, \ldots, n\}$ be the number of cells colored black from the top. A white cell $(i, j)$ scores if and only if at least one horizontally adjacent cell is black, and it is counted only once. The contribution of column $j$ is therefore:

$$
\max\bigl(0,\ s[j][\max(k[j-1], k[j+1])] - s[j][k[j]]\bigr)
$$

where $s[j][h]$ is the prefix sum of the first $h$ cells in column $j$ (boundary column heights are treated as $0$).

Let $f[h_1][h_2]$ be the maximum score after processing column $j$ with $k[j] = h_1$ and $k[j-1] = h_2$. When choosing the next height $hp = k[j+1]$:

$$
g[hp][h_1] = \max_{h_2}\bigl(f[h_1][h_2] + \max(0,\ s[j][\max(h_2, hp)] - s[j][h_1])\bigr)
$$

Split the transition into $h_2 \le hp$ and $h_2 > hp$, and maintain prefix / suffix maxima so that each column costs $O(n^2)$ instead of $O(n^3)$.

The time complexity is $O(n^3)$, and the space complexity is $O(n^2)$, where $n$ is the grid size.

#### Java

```java
class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        final long inf = Long.MIN_VALUE / 2;
        long[][] s = new long[n][n + 1];
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < n; ++i) {
                s[j][i + 1] = s[j][i] + grid[i][j];
            }
        }
        long[][] f = new long[n + 1][n + 1];
        for (long[] row : f) {
            Arrays.fill(row, inf);
        }
        for (int h = 0; h <= n; ++h) {
            f[h][0] = 0;
        }
        for (int j = 0; j < n - 1; ++j) {
            long[][] g = new long[n + 1][n + 1];
            for (long[] row : g) {
                Arrays.fill(row, inf);
            }
            for (int h1 = 0; h1 <= n; ++h1) {
                long[] pre = new long[n + 2];
                pre[0] = f[h1][0];
                for (int h2 = 1; h2 <= n; ++h2) {
                    pre[h2] = Math.max(pre[h2 - 1], f[h1][h2]);
                }
                long[] suf = new long[n + 2];
                Arrays.fill(suf, inf);
                for (int h2 = n; h2 >= 0; --h2) {
                    long v = f[h1][h2] == inf ? inf : f[h1][h2] + Math.max(0, s[j][h2] - s[j][h1]);
                    suf[h2] = Math.max(suf[h2 + 1], v);
                }
                for (int hp = 0; hp <= n; ++hp) {
                    long add = Math.max(0, s[j][hp] - s[j][h1]);
                    long v1 = pre[hp] == inf ? inf : pre[hp] + add;
                    g[hp][h1] = Math.max(v1, suf[hp + 1]);
                }
            }
            f = g;
        }
        long ans = 0;
        for (int h1 = 0; h1 <= n; ++h1) {
            for (int h2 = 0; h2 <= n; ++h2) {
                if (f[h1][h2] != inf) {
                    ans = Math.max(ans, f[h1][h2] + Math.max(0, s[n - 1][h2] - s[n - 1][h1]));
                }
            }
        }
        return ans;
    }
}
```
