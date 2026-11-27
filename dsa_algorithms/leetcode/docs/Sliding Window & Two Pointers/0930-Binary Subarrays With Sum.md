# 930. Binary Subarrays With Sum

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/binary-subarrays-with-sum/

---

[中文文档](/solution/0900-0999/0930.Binary%20Subarrays%20With%20Sum/README.md)

## Description

<p>Given a binary array <code>nums</code> and an integer <code>goal</code>, return <em>the number of non-empty <strong>subarrays</strong> with a sum</em> <code>goal</code>.</p>

<p>A <strong>subarray</strong> is a contiguous part of the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,0,1,0,1], goal = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> The 4 subarrays are bolded and underlined below:
[<u><strong>1,0,1</strong></u>,0,1]
[<u><strong>1,0,1,0</strong></u>,1]
[1,<u><strong>0,1,0,1</strong></u>]
[1,0,<u><strong>1,0,1</strong></u>]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,0,0,0], goal = 0
<strong>Output:</strong> 15
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
	<li><code>0 &lt;= goal &lt;= nums.length</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Count subarrays of a $0/1$ array whose sum is $\textit{goal}$. $n$ is large, so enumerating intervals is too slow. When the prefix sum is $s$, the number of earlier prefixes equal to $s-\textit{goal}$ is the number of good subarrays ending here. A counter of prefix frequencies, starting at $\textit{cnt}[0]=1$, answers each step in $O(1)$.

#### Java

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] cnt = new int[nums.length + 1];
        cnt[0] = 1;
        int ans = 0, s = 0;
        for (int v : nums) {
            s += v;
            if (s - goal >= 0) {
                ans += cnt[s - goal];
            }
            ++cnt[s];
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Method 1 uses linear extra space. Because the array is non-negative, the window sum is monotone in the left end. Two left pointers keep the first index whose sum exceeds $\textit{goal}$ and the first whose sum is at least $\textit{goal}$; their difference is the number of windows with sum exactly $\textit{goal}$.

#### Java

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i1 = 0, i2 = 0, s1 = 0, s2 = 0, j = 0, ans = 0;
        int n = nums.length;
        while (j < n) {
            s1 += nums[j];
            s2 += nums[j];
            while (i1 <= j && s1 > goal) {
                s1 -= nums[i1++];
            }
            while (i2 <= j && s2 >= goal) {
                s2 -= nums[i2++];
            }
            ans += i2 - i1;
            ++j;
        }
        return ans;
    }
}
```
