# 1139. Largest 1-Bordered Square

**Difficulty:** Medium  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/largest-1-bordered-square/

---

[中文文档](/solution/1100-1199/1139.Largest%201-Bordered%20Square/README.md)

## Description

<p>Given a 2D <code>grid</code> of <code>0</code>s and <code>1</code>s, return the number of elements in&nbsp;the largest <strong>square</strong>&nbsp;subgrid that has all <code>1</code>s on its <strong>border</strong>, or <code>0</code> if such a subgrid&nbsp;doesn&#39;t exist in the <code>grid</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,1,1],[1,0,1],[1,1,1]]
<strong>Output:</strong> 9
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,1,0,0]]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= grid.length &lt;= 100</code></li>
	<li><code>1 &lt;= grid[0].length &lt;= 100</code></li>
	<li><code>grid[i][j]</code> is <code>0</code> or <code>1</code></li>
</ul>

## Solutions

### Solution 1: Prefix Sum + Enumeration

> **Thinking**
>
> Checking four sides of every $k\times k$ square by walking them multiplies the cubic enumeration by $k$. After storing, for each cell, the run of $1$s down and right, each side is an $O(1)$ length test.
>
> Enumerate $k$ from large to small and the top-left corner; the first success is the maximum area.

We can use the prefix sum method to preprocess the number of consecutive 1s down and to the right of each position, denoted as `down[i][j]` and `right[i][j]`.

Then we enumerate the side length $k$ of the square, starting from the largest side length. Then we enumerate the upper left corner position $(i, j)$ of the square. If it meets the condition, we can return $k^2$.

The time complexity is $O(mn \min(m, n))$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns of the grid, respectively.

#### Java

```java
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] down = new int[m][n];
        int[][] right = new int[m][n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 1) {
                    down[i][j] = i + 1 < m ? down[i + 1][j] + 1 : 1;
                    right[i][j] = j + 1 < n ? right[i][j + 1] + 1 : 1;
                }
            }
        }
        for (int k = Math.min(m, n); k > 0; --k) {
            for (int i = 0; i <= m - k; ++i) {
                for (int j = 0; j <= n - k; ++j) {
                    if (down[i][j] >= k && right[i][j] >= k && right[i + k - 1][j] >= k
                        && down[i][j + k - 1] >= k) {
                        return k * k;
                    }
                }
            }
        }
        return 0;
    }
}
```
