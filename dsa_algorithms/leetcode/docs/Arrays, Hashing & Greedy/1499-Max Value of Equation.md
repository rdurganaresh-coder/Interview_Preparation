# 1499. Max Value of Equation

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/max-value-of-equation/

---

[中文文档](/solution/1400-1499/1499.Max%20Value%20of%20Equation/README.md)

## Description

<p>You are given an array <code>points</code> containing the coordinates of points on a 2D plane, sorted by the x-values, where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> such that <code>x<sub>i</sub> &lt; x<sub>j</sub></code> for all <code>1 &lt;= i &lt; j &lt;= points.length</code>. You are also given an integer <code>k</code>.</p>

<p>Return <em>the maximum value of the equation </em><code>y<sub>i</sub> + y<sub>j</sub> + |x<sub>i</sub> - x<sub>j</sub>|</code> where <code>|x<sub>i</sub> - x<sub>j</sub>| &lt;= k</code> and <code>1 &lt;= i &lt; j &lt;= points.length</code>.</p>

<p>It is guaranteed that there exists at least one pair of points that satisfy the constraint <code>|x<sub>i</sub> - x<sub>j</sub>| &lt;= k</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
<strong>Output:</strong> 4
<strong>Explanation:</strong> The first two points satisfy the condition |x<sub>i</sub> - x<sub>j</sub>| &lt;= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
No other pairs satisfy the condition, so we return the max of 4 and 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> points = [[0,0],[3,0],[9,2]], k = 3
<strong>Output:</strong> 3
<strong>Explanation: </strong>Only the first two points have an absolute difference of 3 or less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= points.length &lt;= 10<sup>5</sup></code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>-10<sup>8</sup> &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>8</sup></code></li>
	<li><code>0 &lt;= k &lt;= 2 * 10<sup>8</sup></code></li>
	<li><code>x<sub>i</sub> &lt; x<sub>j</sub></code> for all <code>1 &lt;= i &lt; j &lt;= points.length</code></li>
	<li><code>x<sub>i</sub></code> form a strictly increasing sequence.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> $x$ is strictly increasing and $n\le 10^5$. Rewrite $y_i+y_j+|x_i-x_j|=(y_i-x_i)+(x_j+y_j)$. For each $j$ we need the max $y_i-x_i$ among $x_j-x_i\le k$.
>
> A heap of $(x_i-y_i,x_i)$ pops expired points (min-heap on $x-y$ is max $y-x$) and adds the current $x+y$.

#### Java

```java
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = -(1 << 30);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (var p : points) {
            int x = p[0], y = p[1];
            while (!pq.isEmpty() && x - pq.peek()[1] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans = Math.max(ans, x + y + pq.peek()[0]);
            }
            pq.offer(new int[] {y - x, x});
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Method 1 is $O(\log n)$ per point. A decreasing deque maintains the window max of $y-x$ in amortized $O(1)$: drop expired heads and dominated tails before pushing.

#### Java

```java
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = -(1 << 30);
        Deque<int[]> q = new ArrayDeque<>();
        for (var p : points) {
            int x = p[0], y = p[1];
            while (!q.isEmpty() && x - q.peekFirst()[0] > k) {
                q.pollFirst();
            }
            if (!q.isEmpty()) {
                ans = Math.max(ans, x + y + q.peekFirst()[1] - q.peekFirst()[0]);
            }
            while (!q.isEmpty() && y - x >= q.peekLast()[1] - q.peekLast()[0]) {
                q.pollLast();
            }
            q.offerLast(p);
        }
        return ans;
    }
}
```
