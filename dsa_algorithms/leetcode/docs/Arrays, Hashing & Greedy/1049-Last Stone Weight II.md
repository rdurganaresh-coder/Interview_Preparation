# 1049. Last Stone Weight II

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/last-stone-weight-ii/

---

[中文文档](/solution/1000-1099/1049.Last%20Stone%20Weight%20II/README.md)

## Description

<p>You are given an array of integers <code>stones</code> where <code>stones[i]</code> is the weight of the <code>i<sup>th</sup></code> stone.</p>

<p>We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights <code>x</code> and <code>y</code> with <code>x &lt;= y</code>. The result of this smash is:</p>

<ul>
	<li>If <code>x == y</code>, both stones are destroyed, and</li>
	<li>If <code>x != y</code>, the stone of weight <code>x</code> is destroyed, and the stone of weight <code>y</code> has new weight <code>y - x</code>.</li>
</ul>

<p>At the end of the game, there is <strong>at most one</strong> stone left.</p>

<p>Return <em>the smallest possible weight of the left stone</em>. If there are no stones left, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> stones = [2,7,4,1,8,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
we can combine 1 and 1 to get 0, so the array converts to [1], then that&#39;s the optimal value.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> stones = [31,26,33,21,40]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= stones.length &lt;= 30</code></li>
	<li><code>1 &lt;= stones[i] &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Each smash assigns opposite signs to two stones, so the remainder is the absolute difference of two subset sums. $n\le 30$ but the total is only a few thousand, which is a $0$-$1$ knapsack of capacity $\lfloor s/2\rfloor$: pack as close to half as possible.
>
> $dp[i][j]$ is the best weight of the first $i$ stones that does not exceed $j$, taking or skipping stone $i$.
>
> The answer is $s-2\cdotdp[n][\lfloor s/2\rfloor]$.

#### Java

```java
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int s = 0;
        for (int v : stones) {
            s += v;
        }
        int m = stones.length;
        int n = s >> 1;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return s - dp[m][n] * 2;
    }
}
```

### Solution 2: Optimized Dynamic Programming

> **Thinking**
>
> Row $i$ depends only on row $i-1$. A one-dimensional array updated from high capacity to low reuses the same transition without packing a stone twice, and the space becomes $O(s)$.

$dp[i][j]$ only depends on the previous row $dp[i - 1][\cdot]$, so we can drop the first dimension and enumerate the capacity from large to small, reducing the space complexity to $O(\textit{sum})$.

#### Java

```java
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int s = 0;
        for (int v : stones) {
            s += v;
        }
        int m = stones.length;
        int n = s >> 1;
        int[] dp = new int[n + 1];
        for (int v : stones) {
            for (int j = n; j >= v; --j) {
                dp[j] = Math.max(dp[j], dp[j - v] + v);
            }
        }
        return s - dp[n] * 2;
    }
}
```
