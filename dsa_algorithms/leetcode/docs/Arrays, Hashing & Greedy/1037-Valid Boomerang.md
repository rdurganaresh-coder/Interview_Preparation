# 1037. Valid Boomerang

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/valid-boomerang/

---

[中文文档](/solution/1000-1099/1037.Valid%20Boomerang/README.md)

## Description

<p>Given an array <code>points</code> where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> represents a point on the <strong>X-Y</strong> plane, return <code>true</code> <em>if these points are a <strong>boomerang</strong></em>.</p>

<p>A <strong>boomerang</strong> is a set of three points that are <strong>all distinct</strong> and <strong>not in a straight line</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> points = [[1,1],[2,3],[3,2]]
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> points = [[1,1],[2,2],[3,3]]
<strong>Output:</strong> false
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>points.length == 3</code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>0 &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1: Slope Comparison

> **Thinking**
>
> Three points form a boomerang iff they are distinct and not collinear. Subtracting slopes hits vertical edges and floating-point noise.
>
> Unequal slopes become the cross product $(y_2-y_1)(x_3-x_2)\neq(y_3-y_2)(x_2-x_1)$, which also covers vertical sides and coincident points.
>
> One multiplication check on the three coordinates is enough.

Let the three points be $(x_1, y_1)$, $(x_2, y_2)$, and $(x_3, y_3)$. The formula for calculating the slope between two points is $\frac{y_2 - y_1}{x_2 - x_1}$.

To ensure that the three points are not collinear, the condition $\frac{y_2 - y_1}{x_2 - x_1} \neq \frac{y_3 - y_2}{x_3 - x_2}$ must be satisfied. By transforming the equation, we get $(y_2 - y_1) \cdot (x_3 - x_2) \neq (y_3 - y_2) \cdot (x_2 - x_1)$.

Note:

1. When the slope between two points does not exist, i.e., $x_1 = x_2$, the transformed equation still holds.
2. If there are precision issues with division in slope comparison, it can be converted to multiplication.

The time complexity is $O(1)$.

#### Java

```java
class Solution {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];
        return (y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1);
    }
}
```
