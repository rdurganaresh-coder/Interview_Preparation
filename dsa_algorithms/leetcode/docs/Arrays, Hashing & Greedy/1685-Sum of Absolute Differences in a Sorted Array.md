# 1685. Sum of Absolute Differences in a Sorted Array

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

---

[中文文档](/solution/1600-1699/1685.Sum%20of%20Absolute%20Differences%20in%20a%20Sorted%20Array/README.md)

## Description

<p>You are given an integer array <code>nums</code> sorted in <strong>non-decreasing</strong> order.</p>

<p>Build and return <em>an integer array </em><code>result</code><em> with the same length as </em><code>nums</code><em> such that </em><code>result[i]</code><em> is equal to the <strong>summation of absolute differences</strong> between </em><code>nums[i]</code><em> and all the other elements in the array.</em></p>

<p>In other words, <code>result[i]</code> is equal to <code>sum(|nums[i]-nums[j]|)</code> where <code>0 &lt;= j &lt; nums.length</code> and <code>j != i</code> (<strong>0-indexed</strong>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,5]
<strong>Output:</strong> [4,3,5]
<strong>Explanation:</strong> Assuming the arrays are 0-indexed, then
result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,4,6,8,10]
<strong>Output:</strong> [24,15,13,15,21]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= nums[i + 1] &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Summation + Enumeration

> **Thinking**
>
> The array is sorted, so $\lvert x-y \rvert$ is $x-y$ on the left and $y-x$ on the right. Each $i$'s sum of absolute differences is $O(1)$ from the left and right sums.
>
> With total sum $s$ and scanned sum $t$, $\textit{ans}[i]=x\cdot i-t+(s-t)-x\cdot(n-i)$, then add $x$ into $t$.

First, we calculate the sum of all elements in the array $\textit{nums}$, denoted as $s$. We use a variable $t$ to record the sum of the elements that have been enumerated so far.

Next, we enumerate $\textit{nums}[i]$. Then $\textit{ans}[i] = \textit{nums}[i] \times i - t + s - t - \textit{nums}[i] \times (n - i)$. After that, we update $t$, i.e., $t = t + \textit{nums}[i]$. We continue to enumerate the next element until all elements are enumerated.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        // int s = Arrays.stream(nums).sum();
        int s = 0, t = 0;
        for (int x : nums) {
            s += x;
        }
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int v = nums[i] * i - t + s - t - nums[i] * (n - i);
            ans[i] = v;
            t += nums[i];
        }
        return ans;
    }
}
```
