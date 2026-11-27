# 3492. Maximum Containers on a Ship

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-containers-on-a-ship/

---

[中文文档](/solution/3400-3499/3492.Maximum%20Containers%20on%20a%20Ship/README.md)

## Description

<p>You are given a positive integer <code>n</code> representing an <code>n x n</code> cargo deck on a ship. Each cell on the deck can hold one container with a weight of <strong>exactly</strong> <code>w</code>.</p>

<p>However, the total weight of all containers, if loaded onto the deck, must not exceed the ship&#39;s maximum weight capacity, <code>maxWeight</code>.</p>

<p>Return the <strong>maximum</strong> number of containers that can be loaded onto the ship.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 2, w = 3, maxWeight = 15</span></p>

<p><strong>Output:</strong> 4</p>

<p><strong>Explanation: </strong></p>

<p>The deck has 4 cells, and each container weighs 3. The total weight of loading all containers is 12, which does not exceed <code>maxWeight</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3, w = 5, maxWeight = 20</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation: </strong></p>

<p>The deck has 9 cells, and each container weighs 5. The maximum number of containers that can be loaded without exceeding <code>maxWeight</code> is 4.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= w &lt;= 1000</code></li>
	<li><code>1 &lt;= maxWeight &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Mathematics

> **Thinking**
>
> The deck has $n^2$ cells, one box per cell, each of weight $w$, under a total cap $\textit{maxWeight}$.
>
> The count is limited by both cells and weight, hence $\min(n^2,\lfloor \textit{maxWeight}/w\rfloor)=\lfloor\min(n^2 w,\textit{maxWeight})/w\rfloor$.
>
> A constant-time min and integer division suffice; no loading simulation is required.

First, we calculate the maximum weight the boat can carry, which is $n \times n \times w$. Then, we take the minimum of this value and $\textit{maxWeight}$, and divide it by $w$.

The time complexity is $O(1)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n * w, maxWeight) / w;
    }
}
```
