# 130. Surrounded Regions

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/surrounded-regions/

---

[中文文档](/solution/0100-0199/0130.Surrounded%20Regions/README.md)

## Description

<p>You are given an <code>m x n</code> matrix <code>board</code> containing <strong>letters</strong> <code>&#39;X&#39;</code> and <code>&#39;O&#39;</code>, <strong>capture regions</strong> that are <strong>surrounded</strong>:</p>

<ul>
	<li><strong>Connect</strong>: A cell is connected to adjacent cells horizontally or vertically.</li>
	<li><strong>Region</strong>: To form a region <strong>connect every</strong> <code>&#39;O&#39;</code> cell.</li>
	<li><strong>Surround</strong>: A region is surrounded if none of the <code>&#39;O&#39;</code> cells in that region are on the edge of the board. Such regions are <strong>completely enclosed </strong>by <code>&#39;X&#39;</code> cells.</li>
</ul>

<p>To capture a <strong>surrounded region</strong>, replace all <code>&#39;O&#39;</code>s with <code>&#39;X&#39;</code>s <strong>in-place</strong> within the original board. You do not need to return anything.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">board = [[&quot;X&quot;,&quot;X&quot;,&quot;X&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;O&quot;,&quot;O&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;X&quot;,&quot;O&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;O&quot;,&quot;X&quot;,&quot;X&quot;]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[[&quot;X&quot;,&quot;X&quot;,&quot;X&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;X&quot;,&quot;X&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;X&quot;,&quot;X&quot;,&quot;X&quot;],[&quot;X&quot;,&quot;O&quot;,&quot;X&quot;,&quot;X&quot;]]</span></p>

<p><strong>Explanation:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0130.Surrounded%20Regions/images/xogrid.jpg" style="width: 367px; height: 158px;" />
<p>In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">board = [[&quot;X&quot;]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[[&quot;X&quot;]]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == board.length</code></li>
	<li><code>n == board[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>board[i][j]</code> is <code>&#39;X&#39;</code> or <code>&#39;O&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Depth-First Search (DFS)

> **Thinking**
>
> Surrounded `'O'`s become `'X'`; those connected to the border stay. $m,n\le 200$. Starting from interior cells to ask “am I surrounded?” must flood a whole component and is easy to get wrong on the border.
>
> Mark the unsurrounded cells instead. DFS from every border `'O'`, paint those cells with a placeholder, flip remaining `'O'`s to `'X'`, then restore the placeholders.

We can start from the boundary of the matrix, taking each 'O' on the matrix boundary as a starting point, and perform depth-first search. All 'O's found in the search are replaced with '.'.

Then we traverse the matrix again, for each position:

- If it is '.', replace it with 'O';
- Otherwise, if it is 'O', replace it with 'X'.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns in the matrix, respectively.

#### Java

```java
class Solution {
    private final int[] dirs = {-1, 0, 1, 0, -1};
    private char[][] board;
    private int m;
    private int n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        for (int i = 0; i < m; ++i) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int j = 0; j < n; ++j) {
            dfs(0, j);
            dfs(m - 1, j);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '.';
        for (int k = 0; k < 4; ++k) {
            dfs(i + dirs[k], j + dirs[k + 1]);
        }
    }
}
```

### Solution 2: Union-Find Set

> **Thinking**
>
> Solution 1 uses DFS paint to mark border-connected cells. Union-find links adjacent `'O'`s and hooks every border `'O'` to a dummy node. Any `'O'` not in that component is surrounded. No recursion stack, and the connectivity is explicit.

We can also use a union-find set, connecting each 'O' on the matrix boundary with a super node $m \times n$, and connecting each 'O' in the matrix with the 'O's above, below, left, and right of it.

Then we traverse this matrix, for each position, if it is 'O' and it is not connected to the super node, then we replace it with 'X'.

The time complexity is $O(mn \alpha(mn))$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns in the matrix, respectively, and $\alpha$ is the inverse Ackermann function.

#### Java

```java
class Solution {
    private int[] p;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        p = new int[m * n + 1];
        for (int i = 0; i < p.length; ++i) {
            p[i] = i;
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        p[find(i * n + j)] = find(m * n);
                    } else {
                        for (int k = 0; k < 4; ++k) {
                            int x = i + dirs[k];
                            int y = j + dirs[k + 1];
                            if (board[x][y] == 'O') {
                                p[find(x * n + y)] = find(i * n + j);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O' && find(i * n + j) != find(m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
```
