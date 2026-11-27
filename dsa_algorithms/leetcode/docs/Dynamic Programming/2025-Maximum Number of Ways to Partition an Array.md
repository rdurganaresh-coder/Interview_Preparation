# 2025. Maximum Number of Ways to Partition an Array

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/

---

[中文文档](/solution/2000-2099/2025.Maximum%20Number%20of%20Ways%20to%20Partition%20an%20Array/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> of length <code>n</code>. The number of ways to <strong>partition</strong> <code>nums</code> is the number of <code>pivot</code> indices that satisfy both conditions:</p>

<ul>
	<li><code>1 &lt;= pivot &lt; n</code></li>
	<li><code>nums[0] + nums[1] + ... + nums[pivot - 1] == nums[pivot] + nums[pivot + 1] + ... + nums[n - 1]</code></li>
</ul>

<p>You are also given an integer <code>k</code>. You can choose to change the value of <strong>one</strong> element of <code>nums</code> to <code>k</code>, or to leave the array <strong>unchanged</strong>.</p>

<p>Return <em>the <strong>maximum</strong> possible number of ways to <strong>partition</strong> </em><code>nums</code><em> to satisfy both conditions after changing <strong>at most</strong> one element</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,-1,2], k = 3
<strong>Output:</strong> 1
<strong>Explanation:</strong> One optimal approach is to change nums[0] to k. The array becomes [<strong><u>3</u></strong>,-1,2].
There is one way to partition the array:
- For pivot = 2, we have the partition [3,-1 | 2]: 3 + -1 == 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,0], k = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> The optimal approach is to leave the array unchanged.
There are two ways to partition the array:
- For pivot = 1, we have the partition [0 | 0,0]: 0 == 0 + 0.
- For pivot = 2, we have the partition [0,0 | 0]: 0 + 0 == 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14], k = -33
<strong>Output:</strong> 4
<strong>Explanation:</strong> One optimal approach is to change nums[2] to k. The array becomes [22,4,<u><strong>-33</strong></u>,-20,-15,15,-16,7,19,-10,0,-13,-14].
There are four ways to partition the array.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= k, nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Prefix Sum + Hash Table

> **Thinking**
>
> A valid cut has equal halves, i.e. a prefix equal to half the total. With $n \le 10^5$ and one optional replacement by $k$, rescanning prefixes per edit is too slow.
>
> Without edit, if the sum is even, count prefixes equal to the half-sum (excluding the end). Replacing $\textit{nums}[i]$ by $k$ leaves left prefixes unchanged and shifts right ones by $d=k-\textit{nums}[i]$, giving two target keys.
>
> Maps $\textit{left}$ and $\textit{right}$ track those frequencies as the cut pointer moves, so the maximum is obtained in linear time.

We can preprocess to get the prefix sum array $s$ corresponding to the array $\textit{nums}$, where $s[i]$ represents the sum of the array $\textit{nums}[0,...i-1]$. Therefore, the sum of all elements in the array is $s[n - 1]$.

If we do not modify the array $\textit{nums}$, the condition for the sums of the two subarrays to be equal is that $s[n - 1]$ must be even. If $s[n - 1]$ is even, then we calculate $\textit{ans} = \frac{\textit{right}[s[n - 1] / 2]}{2}$.

If we modify the array $\textit{nums}$, we can enumerate each modification position $i$, change $\textit{nums}[i]$ to $k$, then the change in the total sum of the array is $d = k - \textit{nums}[i]$. At this time, the sum of the left part of $i$ remains unchanged, so the legal split must satisfy $s[i] = s[n - 1] + d - s[i]$, that is, $s[i] = \frac{s[n - 1] + d}{2}$. Each prefix sum of the right part has increased by $d$, so the legal split must satisfy $s[i] + d = s[n - 1] + d - (s[i] + d)$, that is, $s[i] = \frac{s[n - 1] - d}{2}$. We use hash tables $\textit{left}$ and $\textit{right}$ to record the number of times each prefix sum appears in the left and right parts, respectively. Then we can calculate $\textit{ans} = \max(\textit{ans}, \textit{left}[\frac{s[n - 1] + d}{2}]) + \textit{right}[\frac{s[n - 1] - d}{2}]$.

Finally, we return $\textit{ans}$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        long[] s = new long[n];
        s[0] = nums[0];
        Map<Long, Integer> right = new HashMap<>();
        for (int i = 0; i < n - 1; ++i) {
            right.merge(s[i], 1, Integer::sum);
            s[i + 1] = s[i] + nums[i + 1];
        }
        int ans = 0;
        if (s[n - 1] % 2 == 0) {
            ans = right.getOrDefault(s[n - 1] / 2, 0);
        }
        Map<Long, Integer> left = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int d = k - nums[i];
            if ((s[n - 1] + d) % 2 == 0) {
                int t = left.getOrDefault((s[n - 1] + d) / 2, 0)
                    + right.getOrDefault((s[n - 1] - d) / 2, 0);
                ans = Math.max(ans, t);
            }
            left.merge(s[i], 1, Integer::sum);
            right.merge(s[i], -1, Integer::sum);
        }
        return ans;
    }
}
```
