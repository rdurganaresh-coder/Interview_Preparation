# 896. Monotonic Array

**Difficulty:** Easy  
**Category:** Stacks & Queues  
**LeetCode:** https://leetcode.com/problems/monotonic-array/

---

[中文文档](/solution/0800-0899/0896.Monotonic%20Array/README.md)

## Description

<p>An array is <strong>monotonic</strong> if it is either monotone increasing or monotone decreasing.</p>

<p>An array <code>nums</code> is monotone increasing if for all <code>i &lt;= j</code>, <code>nums[i] &lt;= nums[j]</code>. An array <code>nums</code> is monotone decreasing if for all <code>i &lt;= j</code>, <code>nums[i] &gt;= nums[j]</code>.</p>

<p>Given an integer array <code>nums</code>, return <code>true</code><em> if the given array is monotonic, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,2,3]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [6,5,4,4]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,2]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Single Traversal

> **Thinking**
>
> Decide whether the array is monotone non-decreasing or non-increasing. $n\le 10^5$, so one pass can test both directions.
>
> Compare adjacent pairs for all $\le$ and all $\ge$; either holds iff the array is monotonic.

We traverse the array, and if an increasing or decreasing situation occurs, we record it. We then check whether both increasing and decreasing situations have occurred. If both have occurred, it means that the array is not monotonic, and we return `false`.

Otherwise, if we reach the end of the traversal, it means that the array is monotonic, and we return `true`.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean asc = false, desc = false;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] < nums[i]) {
                asc = true;
            } else if (nums[i - 1] > nums[i]) {
                desc = true;
            }
            if (asc && desc) {
                return false;
            }
        }
        return true;
    }
}
```
