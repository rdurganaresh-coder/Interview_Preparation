# 1524. Number of Sub-arrays With Odd Sum

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/

---

[中文文档](/solution/1500-1599/1524.Number%20of%20Sub-arrays%20With%20Odd%20Sum/README.md)

## Description

<p>Given an array of integers <code>arr</code>, return <em>the number of subarrays with an <strong>odd</strong> sum</em>.</p>

<p>Since the answer can be very large, return it modulo <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,3,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [2,4,6]
<strong>Output:</strong> 0
<strong>Explanation:</strong> All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2,3,4,5,6,7]
<strong>Output:</strong> 16
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arr[i] &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1: Prefix Sum + Counter

> **Thinking**
>
> Count subarrays whose sum is odd. There are $O(n^2)$ of them and $n\le 10^5$, so explicit sums fail. The parity of a subarray sum is the parity of the difference of two prefix sums.
>
> An odd prefix pairs with every previous even prefix; an even prefix pairs with every previous odd one. While scanning we keep those two counters, add the matching count for the current prefix, then update. Reduce the answer modulo $10^9+7$.

We define an array $\textit{cnt}$ of length 2 as a counter, where $\textit{cnt}[0]$ and $\textit{cnt}[1]$ represent the number of subarrays with even and odd prefix sums, respectively. Initially, $\textit{cnt}[0] = 1$ and $\textit{cnt}[1] = 0$.

Next, we maintain the parity $s$ of the current prefix sum, initially $s = 0$.

Traverse the array $\textit{arr}$. For each element $x$, update $s$ to $(s + x) \mod 2$, add $\textit{cnt}[s \oplus 1]$ to the answer, and then increment $\textit{cnt}[s]$ by $1$.

After the traversal, we get the answer. Note the modulo operation for the answer.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{arr}$.

#### Java

```java
class Solution {
    public int numOfSubarrays(int[] arr) {
        int[] cnt = {1, 0};
        int ans = 0, s = 0;
        final int mod = (int) 1e9 + 7;
        for (int x : arr) {
            s = (s + x) % 2;
            ans = (ans + cnt[s ^ 1]) % mod;
            ++cnt[s];
        }
        return ans;
    }
}
```
