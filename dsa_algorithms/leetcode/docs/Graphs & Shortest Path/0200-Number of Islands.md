# 200. Number of Islands

**Difficulty:** Medium  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/number-of-islands/

---

[中文文档](/solution/0200-0299/0200.Number%20of%20Islands/README.md)

## Description

<p>Given an <code>m x n</code> 2D binary grid <code>grid</code> which represents a map of <code>&#39;1&#39;</code>s (land) and <code>&#39;0&#39;</code>s (water), return <em>the number of islands</em>.</p>

<p>An <strong>island</strong> is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> grid = [
  [&quot;1&quot;,&quot;1&quot;,&quot;1&quot;,&quot;1&quot;,&quot;0&quot;],
  [&quot;1&quot;,&quot;1&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;],
  [&quot;1&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;,&quot;0&quot;],
  [&quot;0&quot;,&quot;0&quot;,&quot;0&quot;,&quot;0&quot;,&quot;0&quot;]
]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [
  [&quot;1&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;,&quot;0&quot;],
  [&quot;1&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;,&quot;0&quot;],
  [&quot;0&quot;,&quot;0&quot;,&quot;1&quot;,&quot;0&quot;,&quot;0&quot;],
  [&quot;0&quot;,&quot;0&quot;,&quot;0&quot;,&quot;1&quot;,&quot;1&quot;]
]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 300</code></li>
	<li><code>grid[i][j]</code> is <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> Counting every cell with value $1$ as its own island would double-count 4-connected land. With $m,n \le 300$, a full scan is acceptable, but each connected component must be cleared in one search.
>
> Adjacent land cells form one component, so a DFS from any unseen land cell covers the whole island. We scan the grid, start DFS at each $1$, rewrite visited land to $0$, and increment the answer once per search.

We can use depth-first search (DFS) to traverse each island. We iterate through each cell $(i, j)$ in the grid. If the cell's value is '1', it means we have found a new island. We can start a DFS from this cell, marking all connected land cells as '0' to avoid duplicate counting. Each time we find a new island, we increment the island count by 1.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns in the grid, respectively.

#### Java

```java
class Solution {
    private char[][] grid;
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j) {
        grid[i][j] = '0';
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; ++k) {
            int x = i + dirs[k];
            int y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                dfs(x, y);
            }
        }
    }
}
```

### Solution 2: BFS

> **Thinking**
>
> Solution 1 clears each component by recursion. A long island uses a call depth equal to its cell count. The same 4-connectivity can be expanded with a queue.
>
> The scan order matches Solution 1. The extra space is still the size of the frontier.

We can also use breadth-first search (BFS) to traverse each island. We iterate through each cell $(i, j)$ in the grid. If the cell's value is '1', it means we have found a new island. We can start a BFS from this cell, marking all connected land cells as '0' to avoid duplicate counting. Each time we find a new island, we increment the island count by 1.

The specific BFS process is as follows:

1. Enqueue the starting cell $(i, j)$ and mark its value as '0'.
2. While the queue is not empty, perform the following operations:
    - Dequeue a cell $p$.
    - Iterate through the four adjacent cells $(x, y)$ of $p$. If $(x, y)$ is within the grid bounds and its value is '1', enqueue it and mark its value as '0'.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns in the grid, respectively.

#### Java

```java
class Solution {
    private char[][] grid;
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    bfs(i, j);
                    ++ans;
                }
            }
        }
        return ans;
    }

    private void bfs(int i, int j) {
        grid[i][j] = '0';
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int k = 0; k < 4; ++k) {
                int x = p[0] + dirs[k];
                int y = p[1] + dirs[k + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                    q.offer(new int[] {x, y});
                    grid[x][y] = '0';
                }
            }
        }
    }
}
```

### Solution 3: Union-Find

> **Thinking**
>
> If we want adjacency as an explicit partition, treat each land cell as a union-find node and union it with neighboring land.
>
> The number of islands is the number of components after the scan. Unions and finds are nearly linear; space remains proportional to the grid.

We can use the Union-Find data structure to solve this problem. We traverse each cell $(i, j)$ in the grid, and if the cell's value is '1', we merge it with adjacent land cells. Finally, we count the number of distinct root nodes in the Union-Find structure, which represents the number of islands.

The time complexity is $O(mn \log (mn))$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns in the grid, respectively.

#### Java

```java
class Solution {
    private int[] p;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n];
        for (int i = 0; i < p.length; ++i) {
            p[i] = i;
        }
        int[] dirs = {1, 0, 1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 2; ++k) {
                        int x = i + dirs[k];
                        int y = j + dirs[k + 1];
                        if (x < m && y < n && grid[x][y] == '1') {
                            p[find(x * n + y)] = find(i * n + j);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && i * n + j == find(i * n + j)) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
```

### Solution 4: Explicit Stack

> **Thinking**
>
> Counting every cell with value $1$ as its own island would double-count 4-connected land. With $m,n \le 300$, a full scan is acceptable, but each component must be cleared in one search.
>
> Recursing along a snake of $1000$ land cells overflows the call stack, and a $300\times 300$ grid can hold that snake.
>
> Clearing an island does not need a return value. It only rewrites 4-connected $1$s to $0$.
>
> When a $1$ is found, push it onto an explicit stack. Pop a cell and push each neighboring $1$ after marking it. Each time a search starts, add one to the answer.

Scan every cell. When the value is `'1'`, flood the island with an explicit stack, rewrite connected land to `'0'`, and add one to the answer.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns in the grid, respectively.

#### Java

```java
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        Deque<int[]> stk = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    stk.push(new int[] {i, j});
                    while (!stk.isEmpty()) {
                        int[] cur = stk.pop();
                        int a = cur[0], b = cur[1];
                        for (int k = 0; k < 4; ++k) {
                            int x = a + dirs[k];
                            int y = b + dirs[k + 1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                stk.push(new int[] {x, y});
                            }
                        }
                    }
                    ++ans;
                }
            }
        }
        return ans;
    }
}
```
