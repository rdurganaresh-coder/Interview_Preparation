# 1014. Best Sightseeing Pair

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/best-sightseeing-pair/

---

[中文文档](/solution/1000-1099/1014.Best%20Sightseeing%20Pair/README.md)

## Description

<p>You are given an integer array <code>values</code> where values[i] represents the value of the <code>i<sup>th</sup></code> sightseeing spot. Two sightseeing spots <code>i</code> and <code>j</code> have a <strong>distance</strong> <code>j - i</code> between them.</p>

<p>The score of a pair (<code>i &lt; j</code>) of sightseeing spots is <code>values[i] + values[j] + i - j</code>: the sum of the values of the sightseeing spots, minus the distance between them.</p>

<p>Return <em>the maximum score of a pair of sightseeing spots</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> values = [8,1,5,2,6]
<strong>Output:</strong> 11
<strong>Explanation:</strong> i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> values = [1,2]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= values.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= values[i] &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> Evaluating $\textit{values}[i]+\textit{values}[j]+i-j$ for every $i<j$ is quadratic. Rewriting it as $(\textit{values}[i]+i)+(\textit{values}[j]-j)$ shows that a fixed $j$ only needs the best $\textit{values}[i]+i$ to its left.
>
> Scanning $j$ from left to right, one variable stores that prefix maximum, giving the best pair at $j$ in constant time before we fold in $\textit{values}[j]+j$.
>
> Each index is used once as a right endpoint and once as a left candidate, so the scan is linear.

We can enumerate $j$ from left to right while maintaining the maximum value of $\textit{values}[i] + i$ for elements to the left of $j$, denoted as $mx$. For each $j$, the maximum score is $mx + \textit{values}[j] - j$. The answer is the maximum of these maximum scores for all positions.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{values}$.

#### Java

```java
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, mx = 0;
        for (int j = 0; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }
}
```
