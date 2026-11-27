# 322. Coin Change

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/coin-change/

---

[中文文档](/solution/0300-0399/0322.Coin%20Change/README.md)

## Description

<p>You are given an integer array <code>coins</code> representing coins of different denominations and an integer <code>amount</code> representing a total amount of money.</p>

<p>Return the <strong>fewest</strong> number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.</p>

<p>You may assume that you have an infinite number of each kind of coin.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> coins = [1,2,5], amount = 11
<strong>Output:</strong> 3
<strong>Explanation:</strong> 11 = 5 + 5 + 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> coins = [2], amount = 3
<strong>Output:</strong> -1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> coins = [1], amount = 0
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= coins.length &lt;= 12</code></li>
	<li><code>1 &lt;= coins[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>0 &lt;= amount &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming (Complete Knapsack)

> **Thinking**
>
> Each coin may be used any number of times; we want the fewest coins summing to $\textit{amount}$. This is unbounded knapsack. A raw DFS repeats sub-amounts.
>
> Let $f[i][j]$ be the fewest coins using the first $i$ types to make $j$. Skip type $i$ via $f[i-1][j]$; if $j\ge x$, take $f[i][j-x]+1$. $f[0][0]=0$, the rest are $\infty$; return $-1$ if impossible.

We define $f[i][j]$ as the minimum number of coins needed to make up the amount $j$ using the first $i$ types of coins. Initially, $f[0][0] = 0$, and the values of other positions are all positive infinity.

We can enumerate the quantity $k$ of the last coin used, then we have:

$$
f[i][j] = \min(f[i - 1][j], f[i - 1][j - x] + 1, \cdots, f[i - 1][j - k \times x] + k)
$$

where $x$ represents the face value of the $i$-th type of coin.

Let $j = j - x$, then we have:

$$
f[i][j - x] = \min(f[i - 1][j - x], f[i - 1][j - 2 \times x] + 1, \cdots, f[i - 1][j - k \times x] + k - 1)
$$

Substituting the second equation into the first one, we can get the following state transition equation:

$$
f[i][j] = \min(f[i - 1][j], f[i][j - x] + 1)
$$

The final answer is $f[m][n]$.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of types of coins and the total amount, respectively.

#### Java

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        final int inf = 1 << 30;
        int m = coins.length;
        int n = amount;
        int[][] f = new int[m + 1][n + 1];
        for (var g : f) {
            Arrays.fill(g, inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= coins[i - 1]) {
                    f[i][j] = Math.min(f[i][j], f[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return f[m][n] >= inf ? -1 : f[m][n];
    }
}
```

### Solution 2: Optimized Dynamic Programming

> **Thinking**
>
> Method 1 only reads $f[i-1][j]$ and $f[i][j-x]$. Collapse to one array and iterate amounts upward so $f[j-x]$ already includes the current coin. Space becomes $O(\textit{amount})$ with the same recurrence.

We notice that $f[i][j]$ is only related to $f[i - 1][j]$ and $f[i][j - x]$. Therefore, we can optimize the two-dimensional array into a one-dimensional array, reducing the space complexity to $O(n)$. The time complexity remains $O(mn)$.

Similar problems:

- [279. Perfect Squares](https://github.com/doocs/leetcode/blob/main/solution/0200-0299/0279.Perfect%20Squares/README_EN.md)

#### Java

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        final int inf = 1 << 30;
        int n = amount;
        int[] f = new int[n + 1];
        Arrays.fill(f, inf);
        f[0] = 0;
        for (int x : coins) {
            for (int j = x; j <= n; ++j) {
                f[j] = Math.min(f[j], f[j - x] + 1);
            }
        }
        return f[n] >= inf ? -1 : f[n];
    }
}
```
