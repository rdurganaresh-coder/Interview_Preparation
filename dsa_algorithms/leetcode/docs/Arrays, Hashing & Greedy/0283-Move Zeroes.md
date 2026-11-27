# 283. Move Zeroes

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/move-zeroes/

---

[中文文档](/solution/0200-0299/0283.Move%20Zeroes/README.md)

## Description

<p>Given an integer array <code>nums</code>, move all <code>0</code>&#39;s to the end of it while maintaining the relative order of the non-zero elements.</p>

<p><strong>Note</strong> that you must do this in-place without making a copy of the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [0,1,0,3,12]
<strong>Output:</strong> [1,3,12,0,0]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you minimize the total number of operations done?

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> Zeros must go to the end while nonzeros keep their order. Let $k$ be the next slot for a nonzero.
>
> Each nonzero is swapped with $\textit{nums}[k]$ and $k$ advances, so the prefix of length $k$ is the original nonzero sequence.

We use a pointer $k$ to record the current position to insert, initially $k = 0$.

Then we iterate through the array $\textit{nums}$, and each time we encounter a non-zero number, we swap it with $\textit{nums}[k]$ and increment $k$ by 1.

This way, we can ensure that the first $k$ elements of $\textit{nums}$ are non-zero, and their relative order is the same as in the original array.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[k];
                nums[k++] = t;
            }
        }
    }
}
```
