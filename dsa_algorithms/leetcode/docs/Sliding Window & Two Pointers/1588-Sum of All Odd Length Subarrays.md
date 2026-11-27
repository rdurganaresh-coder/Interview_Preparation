# 1588. Sum of All Odd Length Subarrays

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

---

[中文文档](/solution/1500-1599/1588.Sum%20of%20All%20Odd%20Length%20Subarrays/README.md)

## Description

<p>Given an array of positive integers <code>arr</code>, return <em>the sum of all possible <strong>odd-length subarrays</strong> of </em><code>arr</code>.</p>

<p>A <strong>subarray</strong> is a contiguous subsequence of the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,4,2,5,3]
<strong>Output:</strong> 58
<strong>Explanation: </strong>The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2]
<strong>Output:</strong> 3
<b>Explanation: </b>There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [10,11,12]
<strong>Output:</strong> 66
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 100</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<p>Could you solve this problem in O(n) time complexity?</p>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> Sum every odd-length subarray. $n$ is typically at most $100$, so a triple loop would pass, yet it re-adds the same entries. The numbers of odd- and even-length subarrays ending at $i$ have closed forms.
>
> Let $f[i]$ and $g[i]$ be those two sums. An odd segment is an even segment ending at $i-1$ plus $\textit{arr}[i]$, and there are $i/2+1$ of them; even segments are symmetric. The answer is the sum of all $f[i]$.

We define two arrays $f$ and $g$ of length $n$, where $f[i]$ represents the sum of subarrays ending at $\textit{arr}[i]$ with odd lengths, and $g[i]$ represents the sum of subarrays ending at $\textit{arr}[i]$ with even lengths. Initially, $f[0] = \textit{arr}[0]$, and $g[0] = 0$. The answer is $\sum_{i=0}^{n-1} f[i]$.

When $i > 0$, consider how $f[i]$ and $g[i]$ transition:

For the state $f[i]$, the element $\textit{arr}[i]$ can form an odd-length subarray with the previous $g[i-1]$. The number of such subarrays is $(i / 2) + 1$, so $f[i] = g[i-1] + \textit{arr}[i] \times ((i / 2) + 1)$.

For the state $g[i]$, when $i = 0$, there are no even-length subarrays, so $g[0] = 0$. When $i > 0$, the element $\textit{arr}[i]$ can form an even-length subarray with the previous $f[i-1]$. The number of such subarrays is $(i + 1) / 2$, so $g[i] = f[i-1] + \textit{arr}[i] \times ((i + 1) / 2)$.

The final answer is $\sum_{i=0}^{n-1} f[i]$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{arr}$.

#### Java

```java
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] f = new int[n];
        int[] g = new int[n];
        int ans = f[0] = arr[0];
        for (int i = 1; i < n; ++i) {
            f[i] = g[i - 1] + arr[i] * (i / 2 + 1);
            g[i] = f[i - 1] + arr[i] * ((i + 1) / 2);
            ans += f[i];
        }
        return ans;
    }
}
```

### Solution 2: Dynamic Programming (Space Optimization)

> **Thinking**
>
> Each state reads only the previous $f$ and $g$, so two rolling scalars suffice. Time stays linear and the extra arrays disappear.

We notice that the values of $f[i]$ and $g[i]$ only depend on $f[i - 1]$ and $g[i - 1]$. Therefore, we can use two variables $f$ and $g$ to record the values of $f[i - 1]$ and $g[i - 1]$, respectively, thus optimizing the space complexity.

The time complexity is $O(n)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = arr[0], f = arr[0], g = 0;
        for (int i = 1; i < arr.length; ++i) {
            int ff = g + arr[i] * (i / 2 + 1);
            int gg = f + arr[i] * ((i + 1) / 2);
            f = ff;
            g = gg;
            ans += f;
        }
        return ans;
    }
}
```
