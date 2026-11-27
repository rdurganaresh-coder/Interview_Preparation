# 2431. Maximize Total Tastiness of Purchased Fruits

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximize-total-tastiness-of-purchased-fruits/

---

[中文文档](/solution/2400-2499/2431.Maximize%20Total%20Tastiness%20of%20Purchased%20Fruits/README.md)

## Description

<p>You are given two non-negative integer arrays <code>price</code> and <code>tastiness</code>, both arrays have the same length <code>n</code>. You are also given two non-negative integers <code>maxAmount</code> and <code>maxCoupons</code>.</p>

<p>For every integer <code>i</code> in range <code>[0, n - 1]</code>:</p>

<ul>
	<li><code>price[i]</code> describes the price of <code>i<sup>th</sup></code> fruit.</li>
	<li><code>tastiness[i]</code> describes the tastiness of <code>i<sup>th</sup></code> fruit.</li>
</ul>

<p>You want to purchase some fruits such that total tastiness is maximized and the total price does not exceed <code>maxAmount</code>.</p>

<p>Additionally, you can use a coupon to purchase fruit for <strong>half of its price</strong> (rounded down to the closest integer). You can use at most <code>maxCoupons</code> of such coupons.</p>

<p>Return <em>the maximum total tastiness that can be purchased</em>.</p>

<p><strong>Note that:</strong></p>

<ul>
	<li>You can purchase each fruit at most once.</li>
	<li>You can use coupons on some fruit at most once.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> price = [10,20,20], tastiness = [5,8,8], maxAmount = 20, maxCoupons = 1
<strong>Output:</strong> 13
<strong>Explanation:</strong> It is possible to make total tastiness 13 in following way:
- Buy first fruit without coupon, so that total price = 0 + 10 and total tastiness = 0 + 5.
- Buy second fruit with coupon, so that total price = 10 + 10 and total tastiness = 5 + 8.
- Do not buy third fruit, so that total price = 20 and total tastiness = 13.
It can be proven that 13 is the maximum total tastiness that can be obtained.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> price = [10,15,7], tastiness = [5,8,20], maxAmount = 10, maxCoupons = 2
<strong>Output:</strong> 28
<strong>Explanation:</strong> It is possible to make total tastiness 20 in following way:
- Do not buy first fruit, so that total price = 0 and total tastiness = 0.
- Buy second fruit with coupon, so that total price = 0 + 7 and total tastiness = 0 + 8.
- Buy third fruit with coupon, so that total price = 7 + 3 and total tastiness = 8 + 20.
It can be proven that 28 is the maximum total tastiness that can be obtained.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == price.length == tastiness.length</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>0 &lt;= price[i], tastiness[i], maxAmount &lt;= 1000</code></li>
	<li><code>0 &lt;= maxCoupons &lt;= 5</code></li>
</ul>

## Solutions

### Solution 1: Memoization Search

> **Thinking**
>
> Each fruit may be skipped, bought, or bought at half price with a coupon. State $(i,j,k)$ is the index, remaining money, and remaining coupons. The product $n\times\textit{maxAmount}\times\textit{maxCoupons}$ is small enough to memoize.
>
> Transitions are skip, pay full price if $j$ allows, or spend one coupon at $\lfloor \textit{price}/2\rfloor$. Take the maximum tastiness.

We design a function $\textit{dfs}(i, j, k)$ to represent the maximum total tastiness starting from the $i$th fruit, with $j$ money left, and $k$ coupons left.

For the $i$th fruit, we can choose to buy or not to buy. If we choose to buy, we can decide whether to use a coupon or not.

If we don't buy, the maximum total tastiness is $\textit{dfs}(i + 1, j, k)$;

If we buy, and choose not to use a coupon (requires $j\ge \textit{price}[i]$), the maximum total tastiness is $\textit{dfs}(i + 1, j - \textit{price}[i], k) + \textit{tastiness}[i]$; if we use a coupon (requires $k\gt 0$ and $j\ge \lfloor \frac{\textit{price}[i]}{2} \rfloor$), the maximum total tastiness is $\textit{dfs}(i + 1, j - \lfloor \frac{\textit{price}[i]}{2} \rfloor, k - 1) + \textit{tastiness}[i]$.

The final answer is $\textit{dfs}(0, \textit{maxAmount}, \textit{maxCoupons})$.

The time complexity is $O(n \textit{maxAmount} \textit{maxCoupons})$, where $n$ is the number of fruits.

#### Java

```java
class Solution {
    private int[][][] f;
    private int[] price;
    private int[] tastiness;
    private int n;

    public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
        n = price.length;
        this.price = price;
        this.tastiness = tastiness;
        f = new int[n][maxAmount + 1][maxCoupons + 1];
        return dfs(0, maxAmount, maxCoupons);
    }

    private int dfs(int i, int j, int k) {
        if (i == n) {
            return 0;
        }
        if (f[i][j][k] != 0) {
            return f[i][j][k];
        }
        int ans = dfs(i + 1, j, k);
        if (j >= price[i]) {
            ans = Math.max(ans, dfs(i + 1, j - price[i], k) + tastiness[i]);
        }
        if (j >= price[i] / 2 && k > 0) {
            ans = Math.max(ans, dfs(i + 1, j - price[i] / 2, k - 1) + tastiness[i]);
        }
        f[i][j][k] = ans;
        return ans;
    }
}
```
