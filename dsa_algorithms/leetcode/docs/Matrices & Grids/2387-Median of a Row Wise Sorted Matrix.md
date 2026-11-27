# 2387. Median of a Row Wise Sorted Matrix

**Difficulty:** Medium  
**Category:** Matrices & Grids  
**LeetCode:** https://leetcode.com/problems/median-of-a-row-wise-sorted-matrix/

---

[中文文档](/solution/2300-2399/2387.Median%20of%20a%20Row%20Wise%20Sorted%20Matrix/README.md)

## Description

<p>Given an <code>m x n</code> matrix <code>grid</code> containing an <strong>odd</strong> number of integers where each row is sorted in <strong>non-decreasing</strong> order, return <em>the <strong>median</strong> of the matrix</em>.</p>

<p>You must solve the problem in less than <code>O(m * n)</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,1,2],[2,3,3],[1,3,4]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The elements of the matrix in sorted order are 1,1,1,2,<u>2</u>,3,3,3,4. The median is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,1,3,3,4]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The elements of the matrix in sorted order are 1,1,<u>3</u>,3,4. The median is 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 500</code></li>
	<li><code>m</code> and <code>n</code> are both odd.</li>
	<li><code>1 &lt;= grid[i][j] &lt;= 10<sup>6</sup></code></li>
	<li><code>grid[i]</code> is sorted in non-decreasing order.</li>
</ul>

## Solutions

### Solution 1: Two Binary Searches

> **Thinking**
>
> Each row is sorted; we need the median of the whole matrix without flattening. It is the $\lceil mn/2 \rceil$-th value, so we binary-search the value domain.
>
> To test $x$, $\textit{bisect}$ each row for the count of entries $\le x$. If that count meets the target, the median is at most $x$. An outer search on the domain finishes it.

The median is actually the $\textit{target} = \left \lceil \frac{m \times n}{2} \right \rceil$-th number after sorting.

We perform a binary search on the elements of the matrix $x$, counting the number of elements in the grid that are greater than $x$, denoted as $\textit{cnt}$. If $\textit{cnt} \ge \textit{target}$, it means the median is on the left side of $x$ (including $x$); otherwise, it is on the right side.

The time complexity is $O(m \log n \log M)$, and the space complexity is $O(1)$, where $m$ and $n$ are the number of rows and columns of the grid, respectively, and $M$ is the maximum element in the grid.

#### Java

```java
class Solution {
    private int[][] grid;

    public int matrixMedian(int[][] grid) {
        this.grid = grid;
        int m = grid.length, n = grid[0].length;
        int target = (m * n + 1) >> 1;
        int left = 0, right = 1000010;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (count(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int count(int x) {
        int cnt = 0;
        for (var row : grid) {
            int left = 0, right = row.length;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (row[mid] > x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            cnt += left;
        }
        return cnt;
    }
}
```
