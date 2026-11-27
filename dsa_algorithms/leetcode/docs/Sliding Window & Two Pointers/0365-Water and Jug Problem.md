# 365. Water and Jug Problem

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/water-and-jug-problem/

---

[中文文档](/solution/0300-0399/0365.Water%20and%20Jug%20Problem/README.md)

## Description

<p>You are given two jugs with capacities <code>x</code> liters and <code>y</code> liters. You have an infinite water supply. Return whether the total amount of water in both jugs may reach <code>target</code> using the following operations:</p>

<ul>
	<li>Fill either jug completely with water.</li>
	<li>Completely empty either jug.</li>
	<li>Pour water from one jug into another until the receiving jug is full, or the transferring jug is empty.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1: </strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: .875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong> <span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;"> x = 3, y = 5, target = 4 </span></p>

<p><strong>Output: </strong> <span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;"> true </span></p>

<p><strong>Explanation:</strong></p>

<p>Follow these steps to reach a total of 4 liters:</p>

<ol>
	<li>Fill the 5-liter jug (0, 5).</li>
	<li>Pour from the 5-liter jug into the 3-liter jug, leaving 2 liters (3, 2).</li>
	<li>Empty the 3-liter jug (0, 2).</li>
	<li>Transfer the 2 liters from the 5-liter jug to the 3-liter jug (2, 0).</li>
	<li>Fill the 5-liter jug again (2, 5).</li>
	<li>Pour from the 5-liter jug into the 3-liter jug until the 3-liter jug is full. This leaves 4 liters in the 5-liter jug (3, 4).</li>
	<li>Empty the 3-liter jug. Now, you have exactly 4 liters in the 5-liter jug (0, 4).</li>
</ol>

<p>Reference: The <a href="https://www.youtube.com/watch?v=BVtQNK_ZUJg&amp;ab_channel=notnek01" target="_blank">Die Hard</a> example.</p>
</div>

<p><strong class="example">Example 2: </strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: .875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong> <span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;"> x = 2, y = 6, target = 5 </span></p>

<p><strong>Output: </strong> <span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;"> false </span></p>
</div>

<p><strong class="example">Example 3: </strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: .875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input: </strong> <span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;"> x = 1, y = 2, target = 3 </span></p>

<p><strong>Output: </strong> <span class="example-io" style="font-family: Menlo,sans-serif; font-size: 0.85rem;"> true </span></p>

<p><strong>Explanation:</strong> Fill both jugs. The total amount of water in both jugs is equal to 3 now.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= x, y, target&nbsp;&lt;= 10<sup>3</sup></code></li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> Two jugs of capacities $x,y$; can we measure $z$? Bézout’s identity says $z$ must be a multiple of $\gcd(x,y)$. A state search also decides it. There are $O(xy)$ states.
>
> $\textit{dfs}(i,j)$ is the current pair. A seen state fails; a jug or their sum equal to $z$ succeeds. Otherwise fill, empty, or pour. Start from $(0,0)$.

Let's denote $\textit{jug1Capacity}$ as $x$, $\textit{jug2Capacity}$ as $y$, and $\textit{targetCapacity}$ as $z$.

Next, we design a function $\textit{dfs}(i, j)$, which represents whether we can get $z$ liters of water when there are $i$ liters of water in $\textit{jug1}$ and $j$ liters of water in $\textit{jug2}$.

The execution process of the function $\textit{dfs}(i, j)$ is as follows:

- If $(i, j)$ has been visited, return $\textit{false}$.
- If $i = z$ or $j = z$ or $i + j = z$, return $\textit{true}$.
- If we can get $z$ liters of water by filling $\textit{jug1}$ or $\textit{jug2}$, or emptying $\textit{jug1}$ or $\textit{jug2}$, return $\textit{true}$.
- If we can get $z$ liters of water by pouring water from $\textit{jug1}$ into $\textit{jug2}$, or pouring water from $\textit{jug2}$ into $\textit{jug1}$, return $\textit{true}$.

The answer is $\textit{dfs}(0, 0)$.

The time complexity is $O(x + y)$, and the space complexity is $O(x + y)$, where $x$ and $y$ are the sizes of $\textit{jug1Capacity}$ and $\textit{jug2Capacity}$ respectively.

#### Java

```java
class Solution {
    private Set<Long> vis = new HashSet<>();
    private int x, y, z;

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        x = jug1Capacity;
        y = jug2Capacity;
        z = targetCapacity;
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        long st = f(i, j);
        if (!vis.add(st)) {
            return false;
        }
        if (i == z || j == z || i + j == z) {
            return true;
        }
        if (dfs(x, j) || dfs(i, y) || dfs(0, j) || dfs(i, 0)) {
            return true;
        }
        int a = Math.min(i, y - j);
        int b = Math.min(j, x - i);
        return dfs(i - a, j + a) || dfs(i + b, j - b);
    }

    private long f(int i, int j) {
        return i * 1000000L + j;
    }
}
```
