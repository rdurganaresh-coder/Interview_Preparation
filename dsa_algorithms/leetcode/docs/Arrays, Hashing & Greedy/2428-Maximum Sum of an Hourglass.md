# 2428. Maximum Sum of an Hourglass

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-sum-of-an-hourglass/

---

[中文文档](/solution/2400-2499/2428.Maximum%20Sum%20of%20an%20Hourglass/README.md)

## Description

<p>You are given an <code>m x n</code> integer matrix <code>grid</code>.</p>

<p>We define an <strong>hourglass</strong> as a part of the matrix with the following form:</p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2428.Maximum%20Sum%20of%20an%20Hourglass/images/img.jpg" style="width: 243px; height: 243px;" />
<p>Return <em>the <strong>maximum</strong> sum of the elements of an hourglass</em>.</p>

<p><strong>Note</strong> that an hourglass cannot be rotated and must be entirely contained within the matrix.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2428.Maximum%20Sum%20of%20an%20Hourglass/images/1.jpg" style="width: 323px; height: 323px;" />
<pre>
<strong>Input:</strong> grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
<strong>Output:</strong> 30
<strong>Explanation:</strong> The cells shown above represent the hourglass with the maximum sum: 6 + 2 + 1 + 2 + 9 + 2 + 8 = 30.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2428.Maximum%20Sum%20of%20an%20Hourglass/images/2.jpg" style="width: 243px; height: 243px;" />
<pre>
<strong>Input:</strong> grid = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> 35
<strong>Explanation:</strong> There is only one hourglass in the matrix, with the sum: 1 + 2 + 3 + 5 + 7 + 8 + 9 = 35.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>3 &lt;= m, n &lt;= 150</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> An hourglass is a $3\times 3$ block minus the two side cells of the middle row. The grid is at most $150\times 150$, so enumerate every center $(i,j)$ and sum the seven cells in $O(mn)$.

We observe from the problem statement that each hourglass is a $3 \times 3$ matrix with the first and last elements of the middle row removed. Therefore, we can start from the top left corner, enumerate the middle coordinate $(i, j)$ of each hourglass, then calculate the sum of the elements in the hourglass, and take the maximum value.

The time complexity is $O(mn)$, and the space complexity is $O(1)$, where $m$ and $n$ are the number of rows and columns of the matrix, respectively.

#### Java

```java
class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                int s = -grid[i][j - 1] - grid[i][j + 1];
                for (int x = i - 1; x <= i + 1; ++x) {
                    for (int y = j - 1; y <= j + 1; ++y) {
                        s += grid[x][y];
                    }
                }
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }
}
```
