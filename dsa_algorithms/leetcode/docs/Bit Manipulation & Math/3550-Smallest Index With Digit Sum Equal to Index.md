# 3550. Smallest Index With Digit Sum Equal to Index

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/

---

[中文文档](/solution/3500-3599/3550.Smallest%20Index%20With%20Digit%20Sum%20Equal%20to%20Index/README.md)

## Description

<p>You are given an integer array <code>nums</code>.</p>

<p>Return the <strong>smallest</strong> index <code>i</code> such that the sum of the digits of <code>nums[i]</code> is equal to <code>i</code>.</p>

<p>If no such index exists, return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,3,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>For <code>nums[2] = 2</code>, the sum of digits is 2, which is equal to index <code>i = 2</code>. Thus, the output is 2.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,10,11]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>For <code>nums[1] = 10</code>, the sum of digits is <code>1 + 0 = 1</code>, which is equal to index <code>i = 1</code>.</li>
	<li>For <code>nums[2] = 11</code>, the sum of digits is <code>1 + 1 = 2</code>, which is equal to index <code>i = 2</code>.</li>
	<li>Since index 1 is the smallest, the output is 1.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Since no index satisfies the condition, the output is -1.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Enumeration + Digit Sum

> **Thinking**
>
> We need the smallest index $i$ whose digit sum equals $i$. Scanning from $0$ yields the minimum.
>
> Sum digits by dividing by $10$; if none match, return $-1$. A linear scan is enough.

We can start from index $i = 0$ and iterate through each element $x$ in the array, calculating the digit sum $s$ of $x$. If $s = i$, return the index $i$. If no such index is found after traversing all elements, return -1.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int s = 0;
            while (nums[i] != 0) {
                s += nums[i] % 10;
                nums[i] /= 10;
            }
            if (s == i) {
                return i;
            }
        }
        return -1;
    }
}
```
