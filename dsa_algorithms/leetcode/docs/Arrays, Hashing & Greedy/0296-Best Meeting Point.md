# 296. Best Meeting Point

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/best-meeting-point/

---

[中文文档](/solution/0200-0299/0296.Best%20Meeting%20Point/README.md)

## Description

<p>Given an <code>m x n</code> binary grid <code>grid</code> where each <code>1</code> marks the home of one friend, return <em>the minimal <strong>total travel distance</strong></em>.</p>

<p>The <strong>total travel distance</strong> is the sum of the distances between the houses of the friends and the meeting point.</p>

<p>The distance is calculated using <a href="http://en.wikipedia.org/wiki/Taxicab_geometry" target="_blank">Manhattan Distance</a>, where <code>distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0200-0299/0296.Best%20Meeting%20Point/images/meetingpoint-grid.jpg" style="width: 413px; height: 253px;" />
<pre>
<strong>Input:</strong> grid = [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
<strong>Output:</strong> 6
<strong>Explanation:</strong> Given three friends living at (0,0), (0,4), and (2,2).
The point (0,2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6 is minimal.
So return 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,1]]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
	<li>There will be <strong>at least two</strong> friends in the <code>grid</code>.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Manhattan distance splits into a sum of $x$-gaps plus a sum of $y$-gaps. In one dimension the sum of distances is minimized at the median.
>
> Collect row indices of every $1$ (already sorted) and column indices (then sort), meet at those medians, and sum absolute deviations.

#### Java

```java
class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Collections.sort(cols);
        int i = rows.get(rows.size() >> 1);
        int j = cols.get(cols.size() >> 1);
        return f(rows, i) + f(cols, j);
    }

    private int f(List<Integer> arr, int x) {
        int s = 0;
        for (int v : arr) {
            s += Math.abs(v - x);
        }
        return s;
    }
}
```
