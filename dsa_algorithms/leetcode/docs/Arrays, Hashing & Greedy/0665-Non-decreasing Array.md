# 665. Non-decreasing Array

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/non-decreasing-array/

---

[中文文档](/solution/0600-0699/0665.Non-decreasing%20Array/README.md)

## Description

<p>Given an array <code>nums</code> with <code>n</code> integers, your task is to check if it could become non-decreasing by modifying <strong>at most one element</strong>.</p>

<p>We define an array is non-decreasing if <code>nums[i] &lt;= nums[i + 1]</code> holds for every <code>i</code> (<strong>0-based</strong>) such that (<code>0 &lt;= i &lt;= n - 2</code>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,2,3]
<strong>Output:</strong> true
<strong>Explanation:</strong> You could modify the first 4 to 1 to get a non-decreasing array.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,2,1]
<strong>Output:</strong> false
<strong>Explanation:</strong> You cannot get a non-decreasing array by modifying at most one element.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Change at most one value to make the array non-decreasing. Two descents fail; one descent can be fixed on either side.
>
> At the first $a>b$, try setting $a$ to $b$ and $b$ to $a$, then test sortedness. No descent means it already works.

#### Java

```java
class Solution {
    public boolean checkPossibility(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            int a = nums[i], b = nums[i + 1];
            if (a > b) {
                nums[i] = b;
                if (isSorted(nums)) {
                    return true;
                }
                nums[i] = a;
                nums[i + 1] = a;
                return isSorted(nums);
            }
        }
        return true;
    }

    private boolean isSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
```
