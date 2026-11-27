# 356. Line Reflection

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/line-reflection/

---

[中文文档](/solution/0300-0399/0356.Line%20Reflection/README.md)

## Description

<p>Given <code>n</code> points on a 2D plane, find if there is such a line parallel to the y-axis that reflects the given points symmetrically.</p>

<p>In other words, answer whether or not if there exists a line that after reflecting all points over the given line, the original points&#39; set is the same as the reflected ones.</p>

<p><strong>Note</strong> that there can be repeated points.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0300-0399/0356.Line%20Reflection/images/356_example_1.png" style="width: 389px; height: 340px;" />
<pre>
<strong>Input:</strong> points = [[1,1],[-1,1]]
<strong>Output:</strong> true
<strong>Explanation:</strong> We can choose the line x = 0.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0300-0399/0356.Line%20Reflection/images/356_example_2.png" style="width: 300px; height: 294px;" />
<pre>
<strong>Input:</strong> points = [[1,1],[-1,-1]]
<strong>Output:</strong> false
<strong>Explanation:</strong> We can&#39;t choose a line.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == points.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>8</sup> &lt;= points[i][j] &lt;= 10<sup>8</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do better than <code>O(n<sup>2</sup>)</code>?</p>

## Solutions

### Solution 1

> **Thinking**
>
> Decide whether the points are symmetric about some vertical line. Trying every candidate axis is unnecessary: if one exists, it is the midpoint of the extreme $x$-coordinates.
>
> Let $s=\min x+\max x$. Every $(x,y)$ must have $(s-x,y)$ in the set. Load the points, then test once.

#### Java

```java
class Solution {
    public boolean isReflected(int[][] points) {
        final int inf = 1 << 30;
        int minX = inf, maxX = -inf;
        Set<List<Integer>> pointSet = new HashSet<>();
        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            pointSet.add(List.of(p[0], p[1]));
        }
        int s = minX + maxX;
        for (int[] p : points) {
            if (!pointSet.contains(List.of(s - p[0], p[1]))) {
                return false;
            }
        }
        return true;
    }
}
```
