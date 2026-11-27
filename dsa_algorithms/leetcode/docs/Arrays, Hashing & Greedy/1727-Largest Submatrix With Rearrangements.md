# 1727. Largest Submatrix With Rearrangements

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/largest-submatrix-with-rearrangements/

---

[中文文档](/solution/1700-1799/1727.Largest%20Submatrix%20With%20Rearrangements/README.md)

## Description

<p>You are given a binary matrix <code>matrix</code> of size <code>m x n</code>, and you are allowed to rearrange the <strong>columns</strong> of the <code>matrix</code> in any order.</p>

<p>Return <em>the area of the largest submatrix within </em><code>matrix</code><em> where <strong>every</strong> element of the submatrix is </em><code>1</code><em> after reordering the columns optimally.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1700-1799/1727.Largest%20Submatrix%20With%20Rearrangements/images/screenshot-2020-12-30-at-40536-pm.png" style="width: 500px; height: 240px;" />
<pre>
<strong>Input:</strong> matrix = [[0,0,1],[1,1,1],[1,0,1]]
<strong>Output:</strong> 4
<strong>Explanation:</strong> You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 4.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1700-1799/1727.Largest%20Submatrix%20With%20Rearrangements/images/screenshot-2020-12-30-at-40852-pm.png" style="width: 500px; height: 62px;" />
<pre>
<strong>Input:</strong> matrix = [[1,0,1,0,1]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> You can rearrange the columns as shown above.
The largest submatrix of 1s, in bold, has an area of 3.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> matrix = [[1,1,0],[1,0,1]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger than an area of 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>matrix[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>

## Solutions

### Solution 1: Preprocessing + Sorting

> **Thinking**
>
> Columns may be reordered; we want the largest all-ones submatrix. $m\cdot n\le 10^5$ forbids trying permutations.
>
> Reordering changes column order, not the upward run of ones in a column. After rewriting each $1$ as that height, a row is a histogram.
>
> Sort the row descending. The $k$-th largest height $v$ forms a $v\times k$ all-ones block. Take the maximum over rows.

Since the matrix can be rearranged by columns, we can preprocess each column of the matrix first.

For each element with value $1$, we update its value to the maximum number of consecutive $1$s above it (including itself), i.e., $\textit{matrix}[i][j] = \textit{matrix}[i-1][j] + 1$.

Next, we sort each row of the updated matrix. Then we traverse each row and compute the maximum area of an all-$1$ submatrix with that row as the bottom edge. The detailed calculation is as follows:

For a given row, let the $k$-th largest element be $\textit{val}_k$, where $k \geq 1$. Then there are at least $k$ elements in that row no less than $\textit{val}_k$, forming an all-$1$ submatrix with area $\textit{val}_k \times k$. We iterate through the elements of the row from largest to smallest, take the maximum value of $\textit{val}_k \times k$, and update the answer.

The time complexity is $O(mn \log n)$, and the space complexity is $O(\log n)$, where $m$ and $n$ are the number of rows and columns of the matrix, respectively.

#### Java

```java
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        int ans = 0;
        for (var row : matrix) {
            Arrays.sort(row);
            for (int j = n - 1, k = 1; j >= 0 && row[j] > 0; --j, ++k) {
                int s = row[j] * k;
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }
}
```
