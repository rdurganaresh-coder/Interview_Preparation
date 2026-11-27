# 2762. Continuous Subarrays

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/continuous-subarrays/

---

[中文文档](/solution/2700-2799/2762.Continuous%20Subarrays/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>. A subarray of <code>nums</code> is called <strong>continuous</strong> if:</p>

<ul>
	<li>Let <code>i</code>, <code>i + 1</code>, ..., <code>j</code><sub> </sub>be the indices in the subarray. Then, for each pair of indices <code>i &lt;= i<sub>1</sub>, i<sub>2</sub> &lt;= j</code>, <code><font face="monospace">0 &lt;=</font> |nums[i<sub>1</sub>] - nums[i<sub>2</sub>]| &lt;= 2</code>.</li>
</ul>

<p>Return <em>the total number of <strong>continuous</strong> subarrays.</em></p>

<p>A subarray is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,4,2,4]
<strong>Output:</strong> 8
<strong>Explanation:</strong> 
Continuous subarray of size 1: [5], [4], [2], [4].
Continuous subarray of size 2: [5,4], [4,2], [2,4].
Continuous subarray of size 3: [4,2,4].
There are no subarrys of size 4.
Total continuous subarrays = 4 + 3 + 1 = 8.
It can be shown that there are no more continuous subarrays.
</pre>

<p>&nbsp;</p>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 6
<strong>Explanation:</strong> 
Continuous subarray of size 1: [1], [2], [3].
Continuous subarray of size 2: [1,2], [2,3].
Continuous subarray of size 3: [1,2,3].
Total continuous subarrays = 3 + 2 + 1 = 6.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Ordered List + Two Pointers

> **Thinking**
>
> A subarray is continuous iff its maximum and minimum differ by at most $2$. Checking every pair of ends is quadratic and too slow at length $10^5$.
>
> After the right end inserts a value, drop left-end elements from a sorted list until the max–min gap is at most $2$. The number of legal subarrays that end here equals the list size.

We can use two pointers, $i$ and $j$, to maintain the left and right endpoints of the current subarray, and use an ordered list to maintain all elements in the current subarray.

Iterate through the array $\textit{nums}$. For the current number $\textit{nums}[i]$ we're iterating over, we add it to the ordered list. If the difference between the maximum and minimum values in the ordered list is greater than $2$, we then loop to move the pointer $i$ to the right, continuously removing $\textit{nums}[i]$ from the ordered list, until the list is empty or the maximum difference between elements in the ordered list is not greater than $2$. At this point, the number of uninterrupted subarrays is $j - i + 1$, which we add to the answer.

After the iteration, return the answer.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int i = 0, n = nums.length;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int j = 0; j < n; ++j) {
            tm.merge(nums[j], 1, Integer::sum);
            while (tm.lastEntry().getKey() - tm.firstEntry().getKey() > 2) {
                tm.merge(nums[i], -1, Integer::sum);
                if (tm.get(nums[i]) == 0) {
                    tm.remove(nums[i]);
                }
                ++i;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}
```

### Solution 2: Monotonic queue + Two Pointers

> **Thinking**
>
> A sorted list pays a logarithm per update. Only the extrema matter, so two monotonic deques of indices suffice. When the gap exceeds $2$, pop the older extremum and advance the left end. The counting is unchanged, and each index enters and leaves a deque once.
