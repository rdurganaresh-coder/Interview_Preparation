# 498. Diagonal Traverse

**Difficulty:** Medium  
**Category:** Matrices & Grids  
**LeetCode:** https://leetcode.com/problems/diagonal-traverse/

---

[中文文档](/solution/0400-0499/0498.Diagonal%20Traverse/README.md)

## Description

<p>Given an <code>m x n</code> matrix <code>mat</code>, return <em>an array of all the elements of the array in a diagonal order</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0400-0499/0498.Diagonal%20Traverse/images/diag1-grid.jpg" style="width: 334px; height: 334px;" />
<pre>
<strong>Input:</strong> mat = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [1,2,4,7,5,3,6,8,9]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> mat = [[1,2],[3,4]]
<strong>Output:</strong> [1,2,3,4]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= mat[i][j] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Fixed Point Traversal

> **Thinking**
>
> Traverse the matrix in zigzag diagonals. Simulating a direction and bouncing off edges needs many boundary cases. There are $m+n-1$ diagonals, each with a closed-form start.
>
> Diagonal $k$ is collected top-right to bottom-left, starting at $(0,k)$ when $k<n$ and $(k-n+1,n-1)$ otherwise. Even $k$ is reversed to match the required zigzag.
>
> Always walking down-left and flipping on even $k$ avoids switching a direction vector on the border.

For each round $k$, we fix the starting point from the top-right and traverse diagonally to the bottom-left to get $t$. If $k$ is even, we reverse $t$.

The time complexity is $O(mn)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        List<Integer> t = new ArrayList<>();
        for (int k = 0; k < m + n - 1; ++k) {
            int i = k < n ? 0 : k - n + 1;
            int j = k < n ? k : n - 1;
            while (i < m && j >= 0) {
                t.add(mat[i][j]);
                ++i;
                --j;
            }
            if (k % 2 == 0) {
                Collections.reverse(t);
            }
            for (int v : t) {
                ans[idx++] = v;
            }
            t.clear();
        }
        return ans;
    }
}
```
