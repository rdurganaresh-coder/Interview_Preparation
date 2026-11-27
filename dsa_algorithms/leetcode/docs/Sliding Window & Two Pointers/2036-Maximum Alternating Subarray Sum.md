# 2036. Maximum Alternating Subarray Sum

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/maximum-alternating-subarray-sum/

---

[中文文档](/solution/2000-2099/2036.Maximum%20Alternating%20Subarray%20Sum/README.md)

## Description

<p>A <strong>subarray</strong> of a <strong>0-indexed</strong> integer array is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>

<p>The <strong>alternating subarray sum</strong> of a subarray that ranges from index <code>i</code> to <code>j</code> (<strong>inclusive</strong>, <code>0 &lt;= i &lt;= j &lt; nums.length</code>) is <code>nums[i] - nums[i+1] + nums[i+2] - ... +/- nums[j]</code>.</p>

<p>Given a <strong>0-indexed</strong> integer array <code>nums</code>, return <em>the <strong>maximum alternating subarray sum</strong> of any subarray of </em><code>nums</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,-1,1,2]
<strong>Output:</strong> 5
<strong>Explanation:</strong>
The subarray [3,-1,1] has the largest alternating subarray sum.
The alternating subarray sum is 3 - (-1) + 1 = 5.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,2,2,2,2]
<strong>Output:</strong> 2
<strong>Explanation:</strong>
The subarrays [2], [2,2,2], and [2,2,2,2,2] have the largest alternating subarray sum.
The alternating subarray sum of [2] is 2.
The alternating subarray sum of [2,2,2] is 2 - 2 + 2 = 2.
The alternating subarray sum of [2,2,2,2,2] is 2 - 2 + 2 - 2 + 2 = 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
There is only one non-empty subarray, which is [1].
The alternating subarray sum is 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> We want the maximum alternating subarray sum; $n \le 10^5$ forbids interval enumeration. Classify by the last sign: the new state depends only on the opposite state of the previous index.
>
> $f$ ends with $+\textit{nums}[i]$, $g$ with $-\textit{nums}[i]$. New $f$ continues $g$ or starts fresh; $g$ continues the just-updated $f$.
>
> Roll both in $O(1)$ space and take the global max.

We define $f$ as the maximum sum of the alternating subarray ending with $\textit{nums}[i]$, and define $g$ as the maximum sum of the alternating subarray ending with $-\textit{nums}[i]$. Initially, both $f$ and $g$ are $-\infty$.

Next, we traverse the array $\textit{nums}$. For position $i$, we need to maintain the values of $f$ and $g$, i.e., $f = \max(g, 0) + \textit{nums}[i]$, and $g = f - \textit{nums}[i]$. The answer is the maximum value among all $f$ and $g$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        final long inf = 1L << 60;
        long ans = -inf, f = -inf, g = -inf;
        for (int x : nums) {
            long ff = Math.max(g, 0) + x;
            g = f - x;
            f = ff;
            ans = Math.max(ans, Math.max(f, g));
        }
        return ans;
    }
}
```
