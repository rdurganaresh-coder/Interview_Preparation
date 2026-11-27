# 188. Best Time to Buy and Sell Stock IV

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

---

[中文文档](/solution/0100-0199/0188.Best%20Time%20to%20Buy%20and%20Sell%20Stock%20IV/README.md)

## Description

<p>You are given an integer array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day, and an integer <code>k</code>.</p>

<p>Find the maximum profit you can achieve. You may complete at most <code>k</code> transactions: i.e. you may buy at most <code>k</code> times and sell at most <code>k</code> times.</p>

<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> k = 2, prices = [2,4,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> k = 2, prices = [3,2,6,5,0,3]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 100</code></li>
	<li><code>1 &lt;= prices.length &lt;= 1000</code></li>
	<li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Memoization Search

> **Thinking**
>
> At most $k$ transactions generalizes the two-trade problem. $n\le 1000$, $k\le 100$, so a 3D state is fine. $\textit{dfs}(i,j,\textit{hold})$ starts on day $i$ with $j$ buys left. Skipping is always legal; holding may sell (buy count unchanged); a flat position with remaining buys may buy and consume one. Memoize $(i,j,\textit{hold})$.

We design a function $\textit{dfs}(i, j, k)$ to represent the maximum profit that can be obtained when starting from day $i$, completing at most $j$ transactions, and holding the stock with the current state $k$ (not holding the stock is represented by $0$, and holding the stock is represented by $1$). The answer is $\textit{dfs}(0, k, 0)$.

The execution logic of the function $\textit{dfs}(i, j, k)$ is as follows:

- If $i$ is greater than or equal to $n$, return $0$ directly.
- The i-th day can choose not to do anything, then $\textit{dfs}(i, j, k) = \textit{dfs}(i + 1, j, k)$.
- If $k > 0$, the i-th day can choose to sell the stock, then $\textit{dfs}(i, j, k) = \max(\textit{dfs}(i + 1, j - 1, 0) + \textit{prices}[i], \textit{dfs}(i + 1, j, k))$.
- Otherwise, if $j > 0$, the i-th day can choose to buy the stock, then $\textit{dfs}(i, j, k) = \max(\textit{dfs}(i + 1, j - 1, 1) - \textit{prices}[i], \textit{dfs}(i + 1, j, k))$.

The value of $\textit{dfs}(i, j, k)$ is the maximum value of the above three cases.

During the process, we can use memoization search to save the results of each calculation to avoid repeated calculations.

The time complexity is $O(nk)$, and the space complexity is $O(nk)$, where $n$ and $k$ are the length of the prices array and the value of $k$, respectively.

#### Java

```java
class Solution {
    private Integer[][][] f;
    private int[] prices;
    private int n;

    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        this.prices = prices;
        f = new Integer[n][k + 1][2];
        return dfs(0, k, 0);
    }

    private int dfs(int i, int j, int k) {
        if (i >= n) {
            return 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        int ans = dfs(i + 1, j, k);
        if (k > 0) {
            ans = Math.max(ans, prices[i] + dfs(i + 1, j, 0));
        } else if (j > 0) {
            ans = Math.max(ans, -prices[i] + dfs(i + 1, j - 1, 1));
        }
        return f[i][j][k] = ans;
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> Solution 1 is memoized recursion. Bottom-up, $f[i][j][0/1]$ is the best profit after day $i$ with $j$ buys used. Day $0$ buy is $-\textit{prices}[0]$; later transitions are sell, stay flat, buy, or keep holding — the same state space.

We can also use dynamic programming to define $f[i][j][k]$ as the maximum profit that can be obtained when completing at most j transactions (here we define the number of transactions as the number of purchases), and holding the stock with the current state k on the i-th day. The initial value of $f[i][j][k]$ is 0. The answer is $f[n - 1][k][0]$.

When $i = 0$, the stock price is $\textit{prices}[0]$. For any $j \in [1, k]$, we have $f[0][j][1] = -\textit{prices}[0]$, which means buying the stock on the 0-th day with a profit of $-\textit{prices}[0]$.

When $i > 0$:

- If the i-th day does not hold the stock, it may be that the stock was held on the i-1-th day and sold on the i-th day, or the stock was not held on the i-1-th day and no operation was performed on the i-th day. Therefore, $f[i][j][0] = \max(f[i - 1][j][1] + \textit{prices}[i], f[i - 1][j][0])$.
- If the i-th day holds the stock, it may be that the stock was not held on the i-1-th day and bought on the i-th day, or the stock was held on the i-1-th day and no operation was performed on the i-th day. Therefore, $f[i][j][1] = \max(f[i - 1][j - 1][0] - \textit{prices}[i], f[i - 1][j][1])$.

Therefore, when $i > 0$, we can get the state transition equation:

$$
\begin{aligned}
f[i][j][0] &= \max(f[i - 1][j][1] + \textit{prices}[i], f[i - 1][j][0]) \\
f[i][j][1] &= \max(f[i - 1][j - 1][0] - \textit{prices}[i], f[i - 1][j][1])
\end{aligned}
$$

The final answer is $f[n - 1][k][0]$.

The time complexity is $O(nk)$, and the space complexity is $O(nk)$, where $n$ and $k$ are the length of the prices array and the value of $k$, respectively.

#### Java

```java
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n][k + 1][2];
        for (int j = 1; j <= k; ++j) {
            f[0][j][1] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                f[i][j][0] = Math.max(f[i - 1][j][1] + prices[i], f[i - 1][j][0]);
                f[i][j][1] = Math.max(f[i - 1][j - 1][0] - prices[i], f[i - 1][j][1]);
            }
        }
        return f[n - 1][k][0];
    }
}
```

### Solution 3: Dynamic Programming (Space Optimization)

> **Thinking**
>
> Day $i$ in Solution 2 depends only on day $i-1$. Drop the day dimension and roll $f[j][2]$ in $O(k)$ space.

$f[i][j][k]$ depends only on the previous day, so a table of size $(k+1) \times 2$ is enough. The space complexity is $O(k)$.

#### Java

```java
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] f = new int[k + 1][2];
        for (int j = 1; j <= k; ++j) {
            f[j][1] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = k; j > 0; --j) {
                f[j][0] = Math.max(f[j][1] + prices[i], f[j][0]);
                f[j][1] = Math.max(f[j - 1][0] - prices[i], f[j][1]);
            }
        }
        return f[k][0];
    }
}
```
