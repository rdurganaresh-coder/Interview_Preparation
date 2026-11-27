# 3567. Minimum Absolute Difference in Sliding Submatrix

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/

---

[中文文档](/solution/3500-3599/3567.Minimum%20Absolute%20Difference%20in%20Sliding%20Submatrix/README.md)

## Description

<p>You are given an <code>m x n</code> integer matrix <code>grid</code> and an integer <code>k</code>.</p>

<p>For every contiguous <code>k x k</code> <strong>submatrix</strong> of <code>grid</code>, compute the <strong>minimum absolute</strong> difference between any two <strong>distinct</strong> values within that <strong>submatrix</strong>.</p>

<p>Return a 2D array <code>ans</code> of size <code>(m - k + 1) x (n - k + 1)</code>, where <code>ans[i][j]</code> is the minimum absolute difference in the submatrix whose top-left corner is <code>(i, j)</code> in <code>grid</code>.</p>

<p><strong>Note</strong>: If all elements in the submatrix have the same value, the answer will be 0.</p>
A submatrix <code>(x1, y1, x2, y2)</code> is a matrix that is formed by choosing all cells <code>matrix[x][y]</code> where <code>x1 &lt;= x &lt;= x2</code> and <code>y1 &lt;= y &lt;= y2</code>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[1,8],[3,-2]], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[[2]]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There is only one possible <code>k x k</code> submatrix: <code><span class="example-io">[[1, 8], [3, -2]]</span></code><span class="example-io">.</span></li>
	<li>Distinct values in the submatrix are<span class="example-io"> <code>[1, 8, 3, -2]</code>.</span></li>
	<li>The minimum absolute difference in the submatrix is <code>|1 - 3| = 2</code>. Thus, the answer is <code>[[2]]</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[3,-1]], k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">[[0,0]]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Both <code>k x k</code> submatrix has only one distinct element.</li>
	<li>Thus, the answer is <code>[[0, 0]]</code>.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[1,-2,3],[2,3,5]], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[[1,2]]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There are two possible <code>k &times; k</code> submatrix:
    <ul>
    	<li>Starting at <code>(0, 0)</code>: <code>[[1, -2], [2, 3]]</code>.
    	<ul>
    		<li>Distinct values in the submatrix are <code>[1, -2, 2, 3]</code>.</li>
    		<li>The minimum absolute difference in the submatrix is <code>|1 - 2| = 1</code>.</li>
    	</ul>
    	</li>
    	<li>Starting at <code>(0, 1)</code>: <code>[[-2, 3], [3, 5]]</code>.
    	<ul>
    		<li>Distinct values in the submatrix are <code>[-2, 3, 5]</code>.</li>
    		<li>The minimum absolute difference in the submatrix is <code>|3 - 5| = 2</code>.</li>
    	</ul>
    	</li>
    </ul>
    </li>
    <li>Thus, the answer is <code>[[1, 2]]</code>.</li>

</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= m == grid.length &lt;= 30</code></li>
	<li><code>1 &lt;= n == grid[i].length &lt;= 30</code></li>
	<li><code>-10<sup>5</sup> &lt;= grid[i][j] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= min(m, n)</code></li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> Each $k \times k$ window needs the minimum absolute difference between distinct values. After sorting the $k^2$ entries, that minimum is a gap between adjacent unequal values.
>
> Enumerate the top-left corner, collect, sort, and scan adjacent pairs. A constant window has difference $0$.

We can enumerate all possible $k \times k$ submatrices by their top-left coordinates $(i, j)$. For each submatrix, we extract all its elements into a list $\textit{nums}$. Then, we sort $\textit{nums}$ and compute the absolute differences between adjacent distinct elements to find the minimum absolute difference. Finally, we store the result in a 2D array.

The time complexity is $O((m - k + 1)(n - k + 1)k^2 \log(k))$, and the space complexity is $O(k^2)$, where $m$ and $n$ are the number of rows and columns of the matrix, and $k$ is the size of the submatrix.

#### Java

```java
class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                List<Integer> nums = new ArrayList<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        nums.add(grid[x][y]);
                    }
                }
                Collections.sort(nums);
                int d = Integer.MAX_VALUE;
                for (int t = 1; t < nums.size(); t++) {
                    int a = nums.get(t - 1);
                    int b = nums.get(t);
                    if (a != b) {
                        d = Math.min(d, Math.abs(a - b));
                    }
                }
                ans[i][j] = (d == Integer.MAX_VALUE) ? 0 : d;
            }
        }
        return ans;
    }
}
```
