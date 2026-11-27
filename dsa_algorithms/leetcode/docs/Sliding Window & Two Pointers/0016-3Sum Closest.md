# 16. 3Sum Closest

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/3sum-closest/

---

[中文文档](/solution/0000-0099/0016.3Sum%20Closest/README.md)

## Description

<p>You are given an integer array <code>nums</code> of length <code>n</code> and an integer <code>target</code>.</p>

<p>Find three integers at <strong>distinct indices</strong> in <code>nums</code> such that the sum is <strong>closest</strong> to <code>target</code>.</p>

<p>Return the sum of the three integers.</p>

<p>You may assume that each input would have <strong>exactly</strong> one solution.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,2,1,-4], target = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,0], target = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 500</code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Sorting + Two Pointers

> **Thinking**
>
> The first idea is to try every triplet and keep the sum closest to $\textit{target}$. That is $O(n^3)$. $n\le 1000$ is about $10^9$ operations and will not pass.
>
> The bottleneck is still brute-forcing the other two numbers after fixing one. We do not need every triplet, only the sum nearest $\textit{target}$. After sorting, a sum that is too large can only get closer by moving the right end left; one that is too small must move the left end right. An exact hit is already optimal.
>
> So we enumerate the first number and squeeze the rest with two pointers, tracking the smallest deviation. The answer is unique, so we need not skip duplicates.

We sort the array first, then traverse the array. For each element $\textit{nums}[i]$, we use pointers $j$ and $k$ to point to $i+1$ and $n-1$ respectively, calculate the sum of the three numbers. If the sum of the three numbers equals $\textit{target}$, we directly return $\textit{target}$. Otherwise, we update the answer based on the difference from $\textit{target}$. If the sum of the three numbers is greater than $\textit{target}$, we move $k$ one place to the left, otherwise, we move $j$ one place to the right.

The time complexity is $O(n^2)$, and the space complexity is $O(\log n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 1 << 30;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int t = nums[i] + nums[j] + nums[k];
                if (t == target) {
                    return t;
                }
                if (Math.abs(t - target) < Math.abs(ans - target)) {
                    ans = t;
                }
                if (t > target) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
        return ans;
    }
}
```
