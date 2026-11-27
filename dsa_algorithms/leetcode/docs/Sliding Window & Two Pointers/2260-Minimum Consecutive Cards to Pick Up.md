# 2260. Minimum Consecutive Cards to Pick Up

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/

---

[中文文档](/solution/2200-2299/2260.Minimum%20Consecutive%20Cards%20to%20Pick%20Up/README.md)

## Description

<p>You are given an integer array <code>cards</code> where <code>cards[i]</code> represents the <strong>value</strong> of the <code>i<sup>th</sup></code> card. A pair of cards are <strong>matching</strong> if the cards have the <strong>same</strong> value.</p>

<p>Return<em> the <strong>minimum</strong> number of <strong>consecutive</strong> cards you have to pick up to have a pair of <strong>matching</strong> cards among the picked cards.</em> If it is impossible to have matching cards, return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> cards = [3,4,2,3,4,7]
<strong>Output:</strong> 4
<strong>Explanation:</strong> We can pick up the cards [3,4,2,3] which contain a matching pair of cards with value 3. Note that picking up the cards [4,2,3,4] is also optimal.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> cards = [1,0,5,3]
<strong>Output:</strong> -1
<strong>Explanation:</strong> There is no way to pick up a set of consecutive cards that contain a pair of matching cards.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= cards.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= cards[i] &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Hash Table

> **Thinking**
>
> We want the shortest subarray that contains some value twice. $n \le 10^5$ rules out checking every interval. The shortest such subarray is always the gap between two consecutive occurrences of the same value.
>
> A map stores the last index of each value; a repeat updates the answer by $i-\textit{last}[x]+1$. If none exists, return $-1$.

We initialize the answer as $+\infty$. We traverse the array, and for each number $x$, if $\textit{last}[x]$ exists, it means $x$ has a matching pair of cards. In this case, we update the answer to $\textit{ans} = \min(\textit{ans}, i - \textit{last}[x] + 1)$. Finally, if the answer is $+\infty$, we return $-1$; otherwise, we return the answer.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> last = new HashMap<>();
        int n = cards.length;
        int ans = n + 1;
        for (int i = 0; i < n; ++i) {
            if (last.containsKey(cards[i])) {
                ans = Math.min(ans, i - last.get(cards[i]) + 1);
            }
            last.put(cards[i], i);
        }
        return ans > n ? -1 : ans;
    }
}
```
