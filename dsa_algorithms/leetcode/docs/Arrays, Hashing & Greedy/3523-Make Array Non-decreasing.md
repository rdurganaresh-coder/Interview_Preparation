# 3523. Make Array Non-decreasing

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/make-array-non-decreasing/

---

[中文文档](/solution/3500-3599/3523.Make%20Array%20Non-decreasing/README.md)

## Description

<p>You are given an integer array <code>nums</code>. In one operation, you can select a <span data-keyword="subarray-nonempty">subarray</span> and replace it with a single element equal to its <strong>maximum</strong> value.</p>

<p>Return the <strong>maximum possible size</strong> of the array after performing zero or more operations such that the resulting array is <strong>non-decreasing</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,2,5,3,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>One way to achieve the maximum size is:</p>

<ol>
	<li>Replace subarray <code>nums[1..2] = [2, 5]</code> with <code>5</code> &rarr; <code>[4, 5, 3, 5]</code>.</li>
	<li>Replace subarray <code>nums[2..3] = [3, 5]</code> with <code>5</code> &rarr; <code>[4, 5, 5]</code>.</li>
</ol>

<p>The final array <code>[4, 5, 5]</code> is non-decreasing with size <font face="monospace">3.</font></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>No operation is needed as the array <code>[1,2,3]</code> is already non-decreasing.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 2 * 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> An operation collapses a subarray to its maximum, so the final sequence is a non-decreasing chain taken from left to right. $n \le 2 \cdot 10^5$ forbids searching every collapse.
>
> Keep every value that is at least the running maximum and update that maximum. Skipped values can merge into a later larger (or equal) segment, so the number kept is optimal.

#### Java

```java
class Solution {
    public int maximumPossibleSize(int[] nums) {
        int ans = 0, mx = 0;
        for (int x : nums) {
            if (mx <= x) {
                ++ans;
                mx = x;
            }
        }
        return ans;
    }
}
```
