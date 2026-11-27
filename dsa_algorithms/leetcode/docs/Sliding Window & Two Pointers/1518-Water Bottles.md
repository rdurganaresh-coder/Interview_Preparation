# 1518. Water Bottles

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/water-bottles/

---

[中文文档](/solution/1500-1599/1518.Water%20Bottles/README.md)

## Description

<p>There are <code>numBottles</code> water bottles that are initially full of water. You can exchange <code>numExchange</code> empty water bottles from the market with one full water bottle.</p>

<p>The operation of drinking a full water bottle turns it into an empty bottle.</p>

<p>Given the two integers <code>numBottles</code> and <code>numExchange</code>, return <em>the <strong>maximum</strong> number of water bottles you can drink</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1500-1599/1518.Water%20Bottles/images/sample_1_1875.png" style="width: 500px; height: 245px;" />
<pre>
<strong>Input:</strong> numBottles = 9, numExchange = 3
<strong>Output:</strong> 13
<strong>Explanation:</strong> You can exchange 3 empty bottles to get 1 full water bottle.
Number of water bottles you can drink: 9 + 3 + 1 = 13.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1500-1599/1518.Water%20Bottles/images/sample_2_1875.png" style="width: 500px; height: 183px;" />
<pre>
<strong>Input:</strong> numBottles = 15, numExchange = 4
<strong>Output:</strong> 19
<strong>Explanation:</strong> You can exchange 4 empty bottles to get 1 full water bottle. 
Number of water bottles you can drink: 15 + 3 + 1 = 19.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= numBottles &lt;= 100</code></li>
	<li><code>2 &lt;= numExchange &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Empty bottles exchange for a full one every $\textit{numExchange}$ empties; we want the total number drunk. The values are small enough to simulate each exchange rather than seek a closed form.
>
> Drink the initial $\textit{numBottles}$ first. Whenever the empty count is at least the rate, spend $\textit{numExchange}$ empties for one full bottle; after drinking it, the empty count falls by $\textit{numExchange}-1$ and the answer grows by one. Stop when a further exchange is impossible.

#### Java

```java
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        for (; numBottles >= numExchange; ++ans) {
            numBottles -= (numExchange - 1);
        }
        return ans;
    }
}
```
