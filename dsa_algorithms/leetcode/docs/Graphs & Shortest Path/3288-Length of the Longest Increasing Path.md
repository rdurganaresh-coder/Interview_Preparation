# 3288. Length of the Longest Increasing Path

**Difficulty:** Hard  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/length-of-the-longest-increasing-path/

---

[中文文档](/solution/3200-3299/3288.Length%20of%20the%20Longest%20Increasing%20Path/README.md)

## Description

<p>You are given a 2D array of integers <code>coordinates</code> of length <code>n</code> and an integer <code>k</code>, where <code>0 &lt;= k &lt; n</code>.</p>

<p><code>coordinates[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> indicates the point <code>(x<sub>i</sub>, y<sub>i</sub>)</code> in a 2D plane.</p>

<p>An <strong>increasing path</strong> of length <code>m</code> is defined as a list of points <code>(x<sub>1</sub>, y<sub>1</sub>)</code>, <code>(x<sub>2</sub>, y<sub>2</sub>)</code>, <code>(x<sub>3</sub>, y<sub>3</sub>)</code>, ..., <code>(x<sub>m</sub>, y<sub>m</sub>)</code> such that:</p>

<ul>
	<li><code>x<sub>i</sub> &lt; x<sub>i + 1</sub></code> and <code>y<sub>i</sub> &lt; y<sub>i + 1</sub></code> for all <code>i</code> where <code>1 &lt;= i &lt; m</code>.</li>
	<li><code>(x<sub>i</sub>, y<sub>i</sub>)</code> is in the given coordinates for all <code>i</code> where <code>1 &lt;= i &lt;= m</code>.</li>
</ul>

<p>Return the <strong>maximum</strong> length of an <strong>increasing path</strong> that contains <code>coordinates[k]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">coordinates = [[3,1],[2,2],[4,1],[0,0],[5,3]], k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p><code>(0, 0)</code>, <code>(2, 2)</code>, <code>(5, 3)</code> is the longest increasing path that contains <code>(2, 2)</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">coordinates = [[2,1],[7,0],[5,6]], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p><code>(2, 1)</code>, <code>(5, 6)</code> is the longest increasing path that contains <code>(5, 6)</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == coordinates.length &lt;= 10<sup>5</sup></code></li>
	<li><code>coordinates[i].length == 2</code></li>
	<li><code>0 &lt;= coordinates[i][0], coordinates[i][1] &lt;= 10<sup>9</sup></code></li>
	<li>All elements in <code>coordinates</code> are <strong>distinct</strong>.</li>
	<li><code>0 &lt;= k &lt;= n - 1</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Points must increase in both $x$ and $y$ and the path must contain $\textit{coordinates}[k]$. $n\le 10^5$ forbids an $O(n^2)$ LIS. The answer is the LIS to the left of $k$ plus the LIS to the right, minus one.
>
> Sort by $x$ and maintain LIS on $y$ with a Fenwick tree or binary search; the left side only uses points strictly below $k$, the right side strictly above. There is no implementation in the tree yet; the reasoning is this split two-dimensional LIS.

#### Java

```java

```
