# 3566. Partition Array into Two Equal Product Subsets

**Difficulty:** Medium  
**Category:** Backtracking  
**LeetCode:** https://leetcode.com/problems/partition-array-into-two-equal-product-subsets/

---

[中文文档](/solution/3500-3599/3566.Partition%20Array%20into%20Two%20Equal%20Product%20Subsets/README.md)

## Description

<p>You are given an integer array <code>nums</code> containing <strong>distinct</strong> positive integers and an integer <code>target</code>.</p>

<p>Determine if you can partition <code>nums</code> into two <strong>non-empty</strong> <strong>disjoint</strong> <strong>subsets</strong>, with each element belonging to <strong>exactly one</strong> subset, such that the product of the elements in each subset is equal to <code>target</code>.</p>

<p>Return <code>true</code> if such a partition exists and <code>false</code> otherwise.</p>
A <strong>subset</strong> of an array is a selection of elements of the array.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,1,6,8,4], target = 24</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong> The subsets <code>[3, 8]</code> and <code>[1, 6, 4]</code> each have a product of 24. Hence, the output is true.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,5,3,7], target = 15</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong> There is no way to partition <code>nums</code> into two non-empty disjoint subsets such that both subsets have a product of 15. Hence, the output is false.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 12</code></li>
	<li><code>1 &lt;= target &lt;= 10<sup>15</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
	<li>All elements of <code>nums</code> are <strong>distinct</strong>.</li>
</ul>

## Solutions

### Solution 1: Binary Enumeration

> **Thinking**
>
> $n$ is tiny. We partition into two subsets whose products both equal $\textit{target}$, so $2^n$ assignments suffice.
>
> For each mask multiply the two sides; both equaling $\textit{target}$ is success. The empty and full sets fail unless the products happen to match, which the same check covers.

We can use binary enumeration to check all possible subset partitions. For each subset partition, we can calculate the product of the two subsets and check whether both are equal to the target value.

Specifically, we can use an integer $i$ to represent the state of the subset partition, where the binary bits of $i$ indicate whether each element belongs to the first subset. For each possible $i$, we calculate the product of the two subsets and check whether both are equal to the target value.

The time complexity is $O(2^n n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        int n = nums.length;
        for (int i = 0; i < 1 << n; ++i) {
            long x = 1, y = 1;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    x *= nums[j];
                } else {
                    y *= nums[j];
                }
            }
            if (x == target && y == target) {
                return true;
            }
        }
        return false;
    }
}
```
