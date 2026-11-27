# 1749. Maximum Absolute Sum of Any Subarray

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/

---

[中文文档](/solution/1700-1799/1749.Maximum%20Absolute%20Sum%20of%20Any%20Subarray/README.md)

## Description

<p>You are given an integer array <code>nums</code>. The <strong>absolute sum</strong> of a subarray <code>[nums<sub>l</sub>, nums<sub>l+1</sub>, ..., nums<sub>r-1</sub>, nums<sub>r</sub>]</code> is <code>abs(nums<sub>l</sub> + nums<sub>l+1</sub> + ... + nums<sub>r-1</sub> + nums<sub>r</sub>)</code>.</p>

<p>Return <em>the <strong>maximum</strong> absolute sum of any <strong>(possibly empty)</strong> subarray of </em><code>nums</code>.</p>

<p>Note that <code>abs(x)</code> is defined as follows:</p>

<ul>
	<li>If <code>x</code> is a negative integer, then <code>abs(x) = -x</code>.</li>
	<li>If <code>x</code> is a non-negative integer, then <code>abs(x) = x</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,-3,2,3,-4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,-5,1,-4,3,-2]
<strong>Output:</strong> 8
<strong>Explanation:</strong> The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> The maximum absolute subarray sum is the larger of the maximum subarray sum and the absolute minimum subarray sum.
>
> Kadane tracks the best and worst sums $f,g$ ending here; the answer is the global max of $f$ and $|g|$.

We define $f[i]$ to represent the maximum value of the subarray ending with $\textit{nums}[i]$, and define $g[i]$ to represent the minimum value of the subarray ending with $\textit{nums}[i]$. Then the state transition equation of $f[i]$ and $g[i]$ is as follows:

$$
\begin{aligned}
f[i] &= \max(f[i - 1], 0) + \textit{nums}[i] \\
g[i] &= \min(g[i - 1], 0) + \textit{nums}[i]
\end{aligned}
$$

The final answer is the maximum value of $\max(f[i], |g[i]|)$.

Since $f[i]$ and $g[i]$ are only related to $f[i - 1]$ and $g[i - 1]$, we can use two variables to replace the array, reducing the space complexity to $O(1)$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int f = 0, g = 0;
        int ans = 0;
        for (int x : nums) {
            f = Math.max(f, 0) + x;
            g = Math.min(g, 0) + x;
            ans = Math.max(ans, Math.max(f, Math.abs(g)));
        }
        return ans;
    }
}
```
