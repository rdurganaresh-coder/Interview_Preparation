# 2962. Count Subarrays Where Max Element Appears at Least K Times

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/

---

[中文文档](/solution/2900-2999/2962.Count%20Subarrays%20Where%20Max%20Element%20Appears%20at%20Least%20K%20Times/README.md)

## Description

<p>You are given an integer array <code>nums</code> and a <strong>positive</strong> integer <code>k</code>.</p>

<p>Return <em>the number of subarrays where the <strong>maximum</strong> element of </em><code>nums</code><em> appears <strong>at least</strong> </em><code>k</code><em> times in that subarray.</em></p>

<p>A <strong>subarray</strong> is a contiguous sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,2,3,3], k = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong> The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,4,2,1], k = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> No subarray contains the element 4 at least 3 times.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> A subarray must contain the global maximum at least $k$ times. $n \le 10^5$ forbids enumeration. For a fixed left end, the earliest right end that gathers $k$ copies of $mx$ is monotone, and every later right end stays valid.
>
> Two pointers maintain $\textit{cnt}$. After each left step, advance $j$ as needed, add $n-j+1$, then drop the leaving $mx$.

Let's denote the maximum value in the array as $mx$.

We use two pointers $i$ and $j$ to maintain a sliding window, such that in the subarray between $[i, j)$, there are $k$ elements equal to $mx$. If we fix the left endpoint $i$, then all right endpoints greater than or equal to $j-1$ meet the condition, totaling $n - (j - 1)$.

Therefore, we enumerate the left endpoint $i$, use the pointer $j$ to maintain the right endpoint, use a variable $\textit{cnt}$ to record the number of elements equal to $mx$ in the current window. When $\textit{cnt}$ is greater than or equal to $k$, we have found a subarray that meets the condition, and we increase the answer by $n - (j - 1)$. Then we update $\textit{cnt}$ and continue to enumerate the next left endpoint.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        long ans = 0;
        int cnt = 0, j = 0;
        for (int x : nums) {
            while (j < n && cnt < k) {
                cnt += nums[j++] == mx ? 1 : 0;
            }
            if (cnt < k) {
                break;
            }
            ans += n - j + 1;
            cnt -= x == mx ? 1 : 0;
        }
        return ans;
    }
}
```
