# 1423. Maximum Points You Can Obtain from Cards

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

---

[中文文档](/solution/1400-1499/1423.Maximum%20Points%20You%20Can%20Obtain%20from%20Cards/README.md)

## Description

<p>There are several cards <strong>arranged in a row</strong>, and each card has an associated number of points. The points are given in the integer array <code>cardPoints</code>.</p>

<p>In one step, you can take one card from the beginning or from the end of the row. You have to take exactly <code>k</code> cards.</p>

<p>Your score is the sum of the points of the cards you have taken.</p>

<p>Given the integer array <code>cardPoints</code> and the integer <code>k</code>, return the <em>maximum score</em> you can obtain.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> cardPoints = [1,2,3,4,5,6,1], k = 3
<strong>Output:</strong> 12
<strong>Explanation:</strong> After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> cardPoints = [2,2,2], k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> Regardless of which two cards you take, your score will always be 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> cardPoints = [9,7,7,9,7,7,9], k = 7
<strong>Output:</strong> 55
<strong>Explanation:</strong> You have to take all the cards. Your score is the sum of points of all cards.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= cardPoints.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= cardPoints[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= k &lt;= cardPoints.length</code></li>
</ul>

## Solutions

### Solution 1: Sliding Window

> **Thinking**
>
> Taking $k$ cards from the two ends means $i$ from the left and $k-i$ from the right. $n\le 10^5$, so we cannot resumm each $i$.
>
> Start with the rightmost $k$ cards, then replace the leftmost of those with the next left-end card, updating the sum in $O(1)$ and keeping the maximum.

We can use a sliding window of length $k$ to simulate this process.

Initially, we place the window at the end of the array, i.e., the $k$ positions from index $n-k$ to index $n-1$. The sum of the points of the cards in the window is denoted as $s$, and the initial value of the answer $\textit{ans}$ is also $s$.

Next, we consider the situation where we take $1, 2, ..., k$ cards from the beginning of the array in turn. Suppose the card taken is $\textit{cardPoints}[i]$. Then we add it to $s$. Due to the length limit of the window is $k$, we need to subtract $\textit{cardPoints}[n-k+i]$ from $s$. In this way, we can calculate the sum of the points of the $k$ cards taken and update the answer $\textit{ans}$.

The time complexity is $O(k)$, and the space complexity is $O(1)$, where $k$ is the integer given in the problem.

#### Java

```java
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int s = 0, n = cardPoints.length;
        for (int i = n - k; i < n; ++i) {
            s += cardPoints[i];
        }
        int ans = s;
        for (int i = 0; i < k; ++i) {
            s += cardPoints[i] - cardPoints[n - k + i];
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
```
