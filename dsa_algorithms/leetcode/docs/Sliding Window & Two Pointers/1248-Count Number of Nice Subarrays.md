# 1248. Count Number of Nice Subarrays

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/count-number-of-nice-subarrays/

---

[中文文档](/solution/1200-1299/1248.Count%20Number%20of%20Nice%20Subarrays/README.md)

## Description

<p>Given an array of integers <code>nums</code> and an integer <code>k</code>. A continuous subarray is called <strong>nice</strong> if there are <code>k</code> odd numbers on it.</p>

<p>Return <em>the number of <strong>nice</strong> sub-arrays</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,2,1,1], k = 3
<strong>Output:</strong> 2
<strong>Explanation:</strong> The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,4,6], k = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no odd numbers in the array.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,2,2,1,2,2,1,2,2,2], k = 2
<strong>Output:</strong> 16
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 50000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10^5</code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>

## Solutions

### Solution 1: Prefix Sum + Array or Hash Table

> **Thinking**
>
> We want subarrays with exactly $k$ odds, $n \le 5\times 10^4$. Treating odds as $1$ and evens as $0$, these are intervals whose prefix sums differ by $k$.
>
> While scanning we keep the odd count $t$, look up how often $t-k$ has appeared, then record $t$. The prefix sum turns “exactly $k$ odds” into one map query.

The problem asks for the number of subarrays that contain exactly $k$ odd numbers. We can calculate the number of odd numbers $t$ in each prefix array and record it in an array or hash table $\textit{cnt}$. For each prefix array, we only need to find the number of prefix arrays with $t-k$ odd numbers, which is the number of subarrays ending with the current prefix array.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v & 1;
            if (t - k >= 0) {
                ans += cnt[t - k];
            }
            cnt[t]++;
        }
        return ans;
    }
}
```
