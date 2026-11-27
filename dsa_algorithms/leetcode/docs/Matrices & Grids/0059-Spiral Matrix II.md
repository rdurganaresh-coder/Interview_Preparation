# 59. Spiral Matrix II

**Difficulty:** Medium  
**Category:** Matrices & Grids  
**LeetCode:** https://leetcode.com/problems/spiral-matrix-ii/

---

[中文文档](/solution/0000-0099/0059.Spiral%20Matrix%20II/README.md)

## Description

<p>Given a positive integer <code>n</code>, generate an <code>n x n</code> <code>matrix</code> filled with elements from <code>1</code> to <code>n<sup>2</sup></code> in spiral order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0059.Spiral%20Matrix%20II/images/spiraln.jpg" style="width: 242px; height: 242px;" />
<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> [[1,2,3],[8,9,4],[7,6,5]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> [[1]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 20</code></li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> The first idea is to fill by layers: four edges per layer, then shrink. $n \le 20$ would pass, with the same boundary bugs.
>
> The waste is hand-managing four edges. As in spiral read: keep the direction, turn right when the next cell is out of bounds or already filled. Empty cells are $0$, filled cells are nonzero, so no extra $\textit{vis}$.
>
> So cycle directions and write $1$ through $n^2$.

We can directly simulate the process of generating the spiral matrix.

Define a 2D array $\textit{ans}$ to store the spiral matrix. Use $i$ and $j$ to represent the current row and column indices, and use $k$ to represent the current direction index. $\textit{dirs}$ represents the mapping between direction indices and directions.

Starting from $1$, fill each position in the matrix sequentially. After filling a position, calculate the row and column indices of the next position. If the next position is out of bounds or has already been filled, change the direction and then calculate the row and column indices of the next position.

The time complexity is $O(n^2)$, and the space complexity is $O(1)$, where $n$ is the side length of the matrix.

#### Java

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        final int[] dirs = {0, 1, 0, -1, 0};
        int i = 0, j = 0, k = 0;
        for (int v = 1; v <= n * n; ++v) {
            ans[i][j] = v;
            int x = i + dirs[k], y = j + dirs[k + 1];
            if (x < 0 || x >= n || y < 0 || y >= n || ans[x][y] != 0) {
                k = (k + 1) % 4;
            }
            i += dirs[k];
            j += dirs[k + 1];
        }
        return ans;
    }
}
```
