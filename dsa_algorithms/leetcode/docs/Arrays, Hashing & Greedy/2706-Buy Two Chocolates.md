# 2706. Buy Two Chocolates

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/buy-two-chocolates/

---

[中文文档](/solution/2700-2799/2706.Buy%20Two%20Chocolates/README.md)

## Description

<p>You are given an integer array <code>prices</code> representing the prices of various chocolates in a store. You are also given a single integer <code>money</code>, which represents your initial amount of money.</p>

<p>You must buy <strong>exactly</strong> two chocolates in such a way that you still have some <strong>non-negative</strong> leftover money. You would like to minimize the sum of the prices of the two chocolates you buy.</p>

<p>Return <em>the amount of money you will have leftover after buying the two chocolates</em>. If there is no way for you to buy two chocolates without ending up in debt, return <code>money</code>. Note that the leftover must be non-negative.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [1,2,2], money = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> Purchase the chocolates priced at 1 and 2 units respectively. You will have 3 - 3 = 0 units of money afterwards. Thus, we return 0.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [3,2,3], money = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> You cannot buy 2 chocolates without going in debt, so we return 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= prices.length &lt;= 50</code></li>
	<li><code>1 &lt;= prices[i] &lt;= 100</code></li>
	<li><code>1 &lt;= money &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1: Sorting

> **Thinking**
>
> We must buy exactly two chocolates without exceeding $\textit{money}$ and maximize the leftover. Enumerating pairs is fine for $n\le 50$, but the answer depends only on the two cheapest prices.
>
> Sort and take the sum $\textit{cost}$ of the first two. If $\textit{cost}>\textit{money}$ we buy nothing; otherwise the leftover is $\textit{money}-\textit{cost}$.

We can sort the prices of the chocolates in ascending order, and then add the first two prices to get the minimum cost $\textit{cost}$ of buying two chocolates. If this cost is greater than the money we have, then we return $\textit{money}$. Otherwise, we return `money - cost`.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the length of the array $\textit{prices}$.

#### Java

```java
class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int cost = prices[0] + prices[1];
        return money < cost ? money : money - cost;
    }
}
```

### Solution 2: One-pass Traversal

> **Thinking**
>
> Sorting costs $O(n \log n)$ when only the two smallest values are needed. A single scan that tracks the current minimum and second minimum yields the same $\textit{cost}$ in linear time.

We can find the two smallest prices in one pass, and then calculate the cost.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{prices}$.

#### Java

```java
class Solution {
    public int buyChoco(int[] prices, int money) {
        int a = 1000, b = 1000;
        for (int x : prices) {
            if (x < a) {
                b = a;
                a = x;
            } else if (x < b) {
                b = x;
            }
        }
        int cost = a + b;
        return money < cost ? money : money - cost;
    }
}
```
