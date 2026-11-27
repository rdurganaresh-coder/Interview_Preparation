# 2946. Matrix Similarity After Cyclic Shifts

**Difficulty:** Easy  
**Category:** Matrices & Grids  
**LeetCode:** https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/

---

[中文文档](/solution/2900-2999/2946.Matrix%20Similarity%20After%20Cyclic%20Shifts/README.md)

## Description

<p>You are given an <code>m x n</code> integer matrix <code>mat</code> and an integer <code>k</code>. The matrix rows are 0-indexed.</p>

<p>The following process happens <code>k</code> times:</p>

<ul>
	<li><strong>Even-indexed</strong> rows (0, 2, 4, ...) are cyclically shifted to the left.</li>
</ul>

<p><img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2900-2999/2946.Matrix%20Similarity%20After%20Cyclic%20Shifts/images/lshift.jpg" style="width: 283px; height: 90px;" /></p>

<ul>
	<li><strong>Odd-indexed</strong> rows (1, 3, 5, ...) are cyclically shifted to the right.</li>
</ul>

<p><img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2900-2999/2946.Matrix%20Similarity%20After%20Cyclic%20Shifts/images/rshift-stlone.jpg" style="width: 283px; height: 90px;" /></p>

<p>Return <code>true</code> if the final modified matrix after <code>k</code> steps is identical to the original matrix, and <code>false</code> otherwise.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">mat = [[1,2,3],[4,5,6],[7,8,9]], k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>In each step left shift is applied to rows 0 and 2 (even indices), and right shift to row 1 (odd index).</p>

<p><img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2900-2999/2946.Matrix%20Similarity%20After%20Cyclic%20Shifts/images/t1-2.jpg" style="width: 857px; height: 150px;" /></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p><img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2900-2999/2946.Matrix%20Similarity%20After%20Cyclic%20Shifts/images/t1-3.jpg" style="width: 632px; height: 150px;" /></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">mat = [[2,2],[2,2]], k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>As all the values are equal in the matrix, even after performing cyclic shifts the matrix will remain the same.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= mat.length &lt;= 25</code></li>
	<li><code>1 &lt;= mat[i].length &lt;= 25</code></li>
	<li><code>1 &lt;= mat[i][j] &lt;= 25</code></li>
	<li><code>1 &lt;= k &lt;= 50</code></li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> Odd rows shift right by $k$ and even rows left by $k$; the matrix must stay unchanged. $k$ may be reduced modulo the width, but comparing the cell that would land on $(i,j)$ avoids rotating.
>
> On odd rows inspect $\textit{mat}[i][(j+k)\bmod n]$, on even rows $\textit{mat}[i][(j-k+n)\bmod n]$. One mismatch rejects. The matrix is at most $25 \times 25$.

We iterate over each element of the matrix and check whether its position after the cyclic shift is the same as the element at the original position.

For odd-indexed rows, we shift elements to the right by $k$ positions, so element $(i, j)$ moves to position $(i, (j + k) \bmod n)$ after the cyclic shift, where $n$ is the number of columns.

For even-indexed rows, we shift elements to the left by $k$ positions, so element $(i, j)$ moves to position $(i, (j - k + n) \bmod n)$ after the cyclic shift.

If at any point during the traversal we find that an element's position after the cyclic shift differs from the original, we return $\textit{false}$. If all elements remain the same after the full traversal, we return $\textit{true}$.

The time complexity is $O(mn)$, and the space complexity is $O(1)$, where $m$ and $n$ are the number of rows and columns of the matrix, respectively.

#### Java

```java
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k %= n;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i % 2 == 1 && mat[i][j] != mat[i][(j + k) % n]) {
                    return false;
                }
                if (i % 2 == 0 && mat[i][j] != mat[i][(j - k + n) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
```
