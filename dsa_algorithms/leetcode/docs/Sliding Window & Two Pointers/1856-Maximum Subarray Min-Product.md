# 1856. Maximum Subarray Min-Product

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/maximum-subarray-min-product/

---

[中文文档](/solution/1800-1899/1856.Maximum%20Subarray%20Min-Product/README.md)

## Description

<p>The <strong>min-product</strong> of an array is equal to the <strong>minimum value</strong> in the array <strong>multiplied by</strong> the array&#39;s <strong>sum</strong>.</p>

<ul>
	<li>For example, the array <code>[3,2,5]</code> (minimum value is <code>2</code>) has a min-product of <code>2 * (3+2+5) = 2 * 10 = 20</code>.</li>
</ul>

<p>Given an array of integers <code>nums</code>, return <em>the <strong>maximum min-product</strong> of any <strong>non-empty subarray</strong> of </em><code>nums</code>. Since the answer may be large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>Note that the min-product should be maximized <strong>before</strong> performing the modulo operation. Testcases are generated such that the maximum min-product <strong>without</strong> modulo will fit in a <strong>64-bit signed integer</strong>.</p>

<p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,<u>2,3,2</u>]
<strong>Output:</strong> 14
<strong>Explanation:</strong> The maximum min-product is achieved with the subarray [2,3,2] (minimum value is 2).
2 * (2+3+2) = 2 * 7 = 14.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,<u>3,3</u>,1,2]
<strong>Output:</strong> 18
<strong>Explanation:</strong> The maximum min-product is achieved with the subarray [3,3] (minimum value is 3).
3 * (3+3) = 3 * 6 = 18.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,1,<u>5,6,4</u>,2]
<strong>Output:</strong> 60
<strong>Explanation:</strong> The maximum min-product is achieved with the subarray [5,6,4] (minimum value is 4).
4 * (5+6+4) = 4 * 15 = 60.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>7</sup></code></li>
</ul>

## Solutions

### Solution 1: Monotonic Stack + Prefix Sum

> **Thinking**
>
> The min-product of a subarray is its minimum times its sum. Enumerating intervals is $O(n^2)$ and too slow for $n\le 10^5$.
>
> When $\textit{nums}[i]$ is the minimum, the interval runs to the previous strictly smaller value on the left and the next smaller-or-equal value on the right. A monotonic stack finds those bounds; prefix sums give the range sum in $O(1)$. Maximize over every such candidate.

We can enumerate each element $\textit{nums}[i]$ as the minimum value of the subarray, and find the left and right boundaries $\textit{left}[i]$ and $\textit{right}[i]$ of the subarray. Where $\textit{left}[i]$ represents the first position strictly less than $\textit{nums}[i]$ on the left side of $i$, and $\textit{right}[i]$ represents the first position less than or equal to $\textit{nums}[i]$ on the right side of $i$.

To conveniently calculate the sum of the subarray, we can preprocess the prefix sum array $s$, where $s[i]$ represents the sum of the first $i$ elements of $\textit{nums}$.

Then the minimum product with $\textit{nums}[i]$ as the minimum value of the subarray is $\textit{nums}[i] \times (s[\textit{right}[i]] - s[\textit{left}[i] + 1])$. We can enumerate each element $\textit{nums}[i]$, find the minimum product with $\textit{nums}[i]$ as the minimum value of the subarray, and then take the maximum value.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        long[] s = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, nums[i] * (s[right[i]] - s[left[i] + 1]));
        }
        final int mod = (int) 1e9 + 7;
        return (int) (ans % mod);
    }
}
```
