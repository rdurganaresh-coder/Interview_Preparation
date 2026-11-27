# 2556. Disconnect Path in a Binary Matrix by at Most One Flip

**Difficulty:** Medium  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/

---

[中文文档](/solution/2500-2599/2556.Disconnect%20Path%20in%20a%20Binary%20Matrix%20by%20at%20Most%20One%20Flip/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> <code>m x n</code> <strong>binary</strong> matrix <code>grid</code>. You can move from a cell <code>(row, col)</code> to any of the cells <code>(row + 1, col)</code> or <code>(row, col + 1)</code> that has the value <code>1</code>.&nbsp;The matrix is <strong>disconnected</strong> if there is no path from <code>(0, 0)</code> to <code>(m - 1, n - 1)</code>.</p>

<p>You can flip the value of <strong>at most one</strong> (possibly none) cell. You <strong>cannot flip</strong> the cells <code>(0, 0)</code> and <code>(m - 1, n - 1)</code>.</p>

<p>Return <code>true</code> <em>if it is possible to make the matrix disconnect or </em><code>false</code><em> otherwise</em>.</p>

<p><strong>Note</strong> that flipping a cell changes its value from <code>0</code> to <code>1</code> or from <code>1</code> to <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2500-2599/2556.Disconnect%20Path%20in%20a%20Binary%20Matrix%20by%20at%20Most%20One%20Flip/images/yetgrid2drawio.png" style="width: 441px; height: 151px;" />
<pre>
<strong>Input:</strong> grid = [[1,1,1],[1,0,0],[1,1,1]]
<strong>Output:</strong> true
<strong>Explanation:</strong> We can change the cell shown in the diagram above. There is no path from (0, 0) to (2, 2) in the resulting grid.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2500-2599/2556.Disconnect%20Path%20in%20a%20Binary%20Matrix%20by%20at%20Most%20One%20Flip/images/yetgrid3drawio.png" />
<pre>
<strong>Input:</strong> grid = [[1,1,1],[1,0,1],[1,1,1]]
<strong>Output:</strong> false
<strong>Explanation:</strong> It is not possible to change at most one cell such that there is not path from (0, 0) to (2, 2).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 1000</code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
	<li><code>grid[0][0] == grid[m - 1][n - 1] == 1</code></li>
</ul>

## Solutions

### Solution 1: Two DFS Traversals

> **Thinking**
>
> Moves are only right or down. We may flip at most one non-endpoint cell to disconnect $(0,0)$ from the exit. Trying every flip is cubic.
>
> Two internally vertex-disjoint paths cannot be cut by a single flip. DFS once, zeroing visited cells (then restore the two ends), and DFS again: a second success means a disjoint path remains, so one flip is not enough.

First, we perform a DFS traversal to determine whether there is a path from $(0, 0)$ to $(m - 1, n - 1)$, and we denote the result as $a$. During the DFS process, we set the value of the visited cells to $0$ to prevent revisiting.

Next, we set the values of $(0, 0)$ and $(m - 1, n - 1)$ to $1$, and perform another DFS traversal to determine whether there is a path from $(0, 0)$ to $(m - 1, n - 1)$, and we denote the result as $b$. During the DFS process, we set the value of the visited cells to $0$ to avoid revisiting.

Finally, if both $a$ and $b$ are `true`, we return `false`, otherwise, we return `true`.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns of the matrix, respectively.

#### Java

```java
class Solution {
    private int[][] grid;
    private int m;
    private int n;

    public boolean isPossibleToCutPath(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        boolean a = dfs(0, 0);
        grid[0][0] = 1;
        grid[m - 1][n - 1] = 1;
        boolean b = dfs(0, 0);
        return !(a && b);
    }

    private boolean dfs(int i, int j) {
        if (i >= m || j >= n || grid[i][j] == 0) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        grid[i][j] = 0;
        return dfs(i + 1, j) || dfs(i, j + 1);
    }
}
```

### Solution 2: Two Explicit Stack Passes

> **Thinking**
>
> Moves are only right or down. We may flip at most one non-endpoint cell to disconnect $(0,0)$ from the exit. Trying every flip is cubic. Two internally vertex-disjoint paths cannot be cut by a single flip. Search down-first, zero the visited cells, restore the two ends, and search again. There can be $1000$ rows, and the first move is always down, so a recursive search has depth $m$. An explicit stack keeps that order: push the right neighbor, then the cell below.

The search uses an explicit stack, clears a cell when it is entered, and handles the cell below before the cell to the right.

First, we search once with an explicit stack to determine whether there is a path from $(0, 0)$ to $(m - 1, n - 1)$, and we denote the result as $a$. During the search, we set the value of the visited cells to $0$ to prevent revisiting.

Next, we set the values of $(0, 0)$ and $(m - 1, n - 1)$ to $1$, and search once more with an explicit stack to determine whether there is a path from $(0, 0)$ to $(m - 1, n - 1)$, and we denote the result as $b$. During the search, we set the value of the visited cells to $0$ to avoid revisiting.

Finally, if both $a$ and $b$ are `true`, we return `false`, otherwise, we return `true`.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns of the matrix, respectively.

#### Java

```java
class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean a = dfs(grid, m, n);
        grid[0][0] = 1;
        grid[m - 1][n - 1] = 1;
        boolean b = dfs(grid, m, n);
        return !(a && b);
    }

    private boolean dfs(int[][] grid, int m, int n) {
        int[] stk = new int[m * n * 2];
        int top = 0;
        stk[top++] = 0;
        while (top > 0) {
            int cur = stk[--top];
            int i = cur / n;
            int j = cur % n;
            if (i >= m || j >= n || grid[i][j] == 0) {
                continue;
            }
            grid[i][j] = 0;
            if (i == m - 1 && j == n - 1) {
                return true;
            }
            if (j + 1 < n) {
                stk[top++] = i * n + j + 1;
            }
            if (i + 1 < m) {
                stk[top++] = (i + 1) * n + j;
            }
        }
        return false;
    }
}
```
