# 123. Best Time to Buy and Sell Stock III

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

---

[中文文档](/solution/0100-0199/0123.Best%20Time%20to%20Buy%20and%20Sell%20Stock%20III/README.md)

## Description

<p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>Find the maximum profit you can achieve. You may complete <strong>at most two transactions</strong>.</p>

<p><strong>Note:</strong> You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [3,3,5,0,0,3,1,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,2,3,4,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transaction is done, i.e. max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> At most two transactions, so the unlimited-trade state of the previous problem is not enough. A 3D DP over day, trades finished, and hold is heavier than we need. The legal order is buy1, sell1, buy2, sell2. Four variables update in that order, each day using the previous stage. Buying and selling on the same day yields $0$ and does not hurt the optimum.

We define the following variables:

- `f1` represents the maximum profit after the first purchase of the stock;
- `f2` represents the maximum profit after the first sale of the stock;
- `f3` represents the maximum profit after the second purchase of the stock;
- `f4` represents the maximum profit after the second sale of the stock.

During the traversal, we directly calculate `f1`, `f2`, `f3`, `f4`. We consider that buying and selling on the same day will result in a profit of $0$, which will not affect the answer.

Finally, return `f4`.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the $\textit{prices}$ array.

#### Java

```java
class Solution {
    public int maxProfit(int[] prices) {
        int f1 = -prices[0], f2 = 0, f3 = -prices[0], f4 = 0;
        for (int i = 1; i < prices.length; ++i) {
            f1 = Math.max(f1, -prices[i]);
            f2 = Math.max(f2, f1 + prices[i]);
            f3 = Math.max(f3, f2 - prices[i]);
            f4 = Math.max(f4, f3 + prices[i]);
        }
        return f4;
    }
}
```
