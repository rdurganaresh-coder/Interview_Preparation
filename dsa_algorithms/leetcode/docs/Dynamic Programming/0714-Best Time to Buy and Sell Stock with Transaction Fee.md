# 714. Best Time to Buy and Sell Stock with Transaction Fee

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

---

[中文文档](/solution/0700-0799/0714.Best%20Time%20to%20Buy%20and%20Sell%20Stock%20with%20Transaction%20Fee/README.md)

## Description

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day, and an integer <code>fee</code> representing a transaction fee.</p>

<p>Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.</p>

<p><strong>Note:</strong></p>

<ul>
	<li>You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</li>
	<li>The transaction fee is only charged once for each stock purchase and sale.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,3,2,8,4,9], fee = 2
<strong>Output:</strong> 8
<strong>Explanation:</strong> The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,3,7,5,10,3], fee = 3
<strong>Output:</strong> 6
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= prices[i] &lt; 5 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= fee &lt; 5 * 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Memoization

> **Thinking**
>
> We may trade many times and pay $\textit{fee}$ on each completed sale. $n \le 5\times 10^4$, so an unmemoized search over days repeats states.
>
> A day has two modes: flat or holding. From flat we buy or skip; from holding we sell (minus $\textit{fee}$) or hold. The optimum from day $i$ in mode $j$ depends only on those two successors.
>
> Memoize $\textit{dfs}(i,j)$; past the last day the profit is $0$. The answer is $\textit{dfs}(0,0)$. There are $O(n)$ states.

We design a function $\textit{dfs}(i, j)$, which represents the maximum profit that can be obtained starting from day $i$ with state $j$. Here, $j$ can take the values $0$ and $1$, representing not holding and holding a stock, respectively. The answer is $\textit{dfs}(0, 0)$.

The execution logic of the function $\textit{dfs}(i, j)$ is as follows:

If $i \geq n$, there are no more stocks to trade, so we return $0$.

Otherwise, we can choose not to trade, in which case $\textit{dfs}(i, j) = \textit{dfs}(i + 1, j)$. We can also choose to trade stocks. If $j \gt 0$, it means that we currently hold a stock and can sell it. In this case, $\textit{dfs}(i, j) = \textit{prices}[i] + \textit{dfs}(i + 1, 0) - \textit{fee}$. If $j = 0$, it means that we currently do not hold a stock and can buy one. In this case, $\textit{dfs}(i, j) = -\textit{prices}[i] + \textit{dfs}(i + 1, 1)$. We take the maximum value as the return value of the function $\textit{dfs}(i, j)$.

The answer is $\textit{dfs}(0, 0)$.

To avoid redundant calculations, we use memoization to record the return value of $\textit{dfs}(i, j)$ in an array $f$. If $f[i][j]$ is not equal to $-1$, it means that we have already calculated it, so we can directly return $f[i][j]$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{prices}$.

#### Java

```java
class Solution {
    private Integer[][] f;
    private int[] prices;
    private int fee;

    public int maxProfit(int[] prices, int fee) {
        f = new Integer[prices.length][2];
        this.prices = prices;
        this.fee = fee;
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= prices.length) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = dfs(i + 1, j);
        if (j > 0) {
            ans = Math.max(ans, prices[i] + dfs(i + 1, 0) - fee);
        } else {
            ans = Math.max(ans, -prices[i] + dfs(i + 1, 1));
        }
        return f[i][j] = ans;
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> Solution 1 fills a suffix table from the end. The same choices can be written forward: $f[i][0/1]$ is the best profit after day $i$, flat or holding. Flat comes from staying flat or selling today and paying $\textit{fee}$; holding comes from staying put or buying today.
>
> Fill left to right; the answer is flat on the last day. Time stays $O(n)$.

We define $f[i][j]$ as the maximum profit that can be obtained up to day $i$ with state $j$. Here, $j$ can take the values $0$ and $1$, representing not holding and holding a stock, respectively. We initialize $f[0][0] = 0$ and $f[0][1] = -\textit{prices}[0]$.

When $i \geq 1$, if we do not hold a stock at the current day, then $f[i][0]$ can be obtained by transitioning from $f[i - 1][0]$ and $f[i - 1][1] + \textit{prices}[i] - \textit{fee}$, i.e., $f[i][0] = \max(f[i - 1][0], f[i - 1][1] + \textit{prices}[i] - \textit{fee})$. If we hold a stock at the current day, then $f[i][1]$ can be obtained by transitioning from $f[i - 1][1]$ and $f[i - 1][0] - \textit{prices}[i]$, i.e., $f[i][1] = \max(f[i - 1][1], f[i - 1][0] - \textit{prices}[i])$. The final answer is $f[n - 1][0]$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{prices}$.

#### Java

```java
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i] - fee);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]);
        }
        return f[n - 1][0];
    }
}
```

### Solution 3: Dynamic Programming (Space Optimization)

> **Thinking**
>
> Day $i$ in Solution 2 reads only day $i-1$, so the full table is unnecessary.
>
> Roll two scalars $f_0,f_1$. Parallel assignment keeps the previous pair while both updates run, so the new holding state still sees the old flat profit. Space is $O(1)$.

The transition only needs the previous day, so two variables are enough and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int f0 = 0, f1 = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            int g0 = Math.max(f0, f1 + prices[i] - fee);
            f1 = Math.max(f1, f0 - prices[i]);
            f0 = g0;
        }
        return f0;
    }
}
```

### Solution 4: Dynamic Programming

> **Thinking**
>
> We may trade many times and pay $\textit{fee}$ on each completed sale. $n \le 5\times 10^4$, so a raw decision tree over days is far too large.
>
> The state is the day and whether we hold. Skipping always calls the next day before it returns, so the chain has length $n$ and overflows the stack.
>
> Later days are known if we walk backward. Let $f[i][j]$ be the best profit from day $i$ with holding flag $j$, and fill $i$ from $n-1$ down to $0$. Selling subtracts $\textit{fee}$; buying enters the holding state.

Let $f[i][j]$ be the maximum profit starting from day $i$ in state $j$. The values of $j$ are $0$ and $1$, meaning we do not hold a stock and we hold a stock. The answer is $f[0][0]$. Days past the end contribute $0$, so $f[n][j] = 0$.

Fill $i$ from $n - 1$ down to $0$. Doing nothing keeps $f[i + 1][j]$. If $j > 0$, we hold a stock and may sell it, earning $\textit{prices}[i] + f[i + 1][0] - \textit{fee}$. If $j = 0$, we may buy, earning $-\textit{prices}[i] + f[i + 1][1]$. Take the larger value:

$$
f[i][j] = \max(f[i + 1][j],\ \textit{prices}[i] + f[i + 1][0] - \textit{fee})
$$

when $j > 0$, and

$$
f[i][j] = \max(f[i + 1][j],\ -\textit{prices}[i] + f[i + 1][1])
$$

when $j = 0$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{prices}$.

#### Java

```java
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] f = new int[n + 1][2];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < 2; ++j) {
                int ans = f[i + 1][j];
                if (j > 0) {
                    ans = Math.max(ans, prices[i] + f[i + 1][0] - fee);
                } else {
                    ans = Math.max(ans, -prices[i] + f[i + 1][1]);
                }
                f[i][j] = ans;
            }
        }
        return f[0][0];
    }
}
```
