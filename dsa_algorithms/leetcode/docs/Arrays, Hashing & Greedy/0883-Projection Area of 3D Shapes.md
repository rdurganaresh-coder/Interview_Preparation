# 883. Projection Area of 3D Shapes

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/projection-area-of-3d-shapes/

---

[中文文档](/solution/0800-0899/0883.Projection%20Area%20of%203D%20Shapes/README.md)

## Description

<p>You are given an <code>n x n</code> <code>grid</code> where we place some <code>1 x 1 x 1</code> cubes that are axis-aligned with the <code>x</code>, <code>y</code>, and <code>z</code> axes.</p>

<p>Each value <code>v = grid[i][j]</code> represents a tower of <code>v</code> cubes placed on top of the cell <code>(i, j)</code>.</p>

<p>We view the projection of these cubes onto the <code>xy</code>, <code>yz</code>, and <code>zx</code> planes.</p>

<p>A <strong>projection</strong> is like a shadow, that maps our <strong>3-dimensional</strong> figure to a <strong>2-dimensional</strong> plane. We are viewing the &quot;shadow&quot; when looking at the cubes from the top, the front, and the side.</p>

<p>Return <em>the total area of all three projections</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0800-0899/0883.Projection%20Area%20of%203D%20Shapes/images/shadow.png" style="width: 800px; height: 214px;" />
<pre>
<strong>Input:</strong> grid = [[1,2],[3,4]]
<strong>Output:</strong> 17
<strong>Explanation:</strong> Here are the three projections (&quot;shadows&quot;) of the shape made with each axis-aligned plane.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[2]]
<strong>Output:</strong> 5
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,0],[0,2]]
<strong>Output:</strong> 8
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == grid.length == grid[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 50</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 50</code></li>
</ul>

## Solutions

### Solution 1: Mathematics

> **Thinking**
>
> The three projections are the number of nonzero cells, the sum of row maxima, and the sum of column maxima. $n\le 50$, so one pass computes all three.
>
> Count $v>0$ for the top view, take $\max$ per row and per column for the other two views, and add them.

We can calculate the area of the three projections separately.

- Projection area on the xy plane: Each non-zero value will be projected onto the xy plane, so the projection area on the xy plane is the count of non-zero values.
- Projection area on the yz plane: The maximum value in each row.
- Projection area on the zx plane: The maximum value in each column.

Finally, add up the three areas.

The time complexity is $O(n^2)$, and the space complexity is $O(1)$, where $n$ is the side length of the grid $\textit{grid}$.

#### Java

```java
class Solution {
    public int projectionArea(int[][] grid) {
        int xy = 0, yz = 0, zx = 0;
        for (int i = 0, n = grid.length; i < n; ++i) {
            int maxYz = 0;
            int maxZx = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    ++xy;
                }
                maxYz = Math.max(maxYz, grid[i][j]);
                maxZx = Math.max(maxZx, grid[j][i]);
            }
            yz += maxYz;
            zx += maxZx;
        }
        return xy + yz + zx;
    }
}
```
