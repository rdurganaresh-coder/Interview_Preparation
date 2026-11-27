# 1060. Missing Element in Sorted Array

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/missing-element-in-sorted-array/

---

[中文文档](/solution/1000-1099/1060.Missing%20Element%20in%20Sorted%20Array/README.md)

## Description

<p>Given an integer array <code>nums</code> which is sorted in <strong>ascending order</strong> and all of its elements are <strong>unique</strong> and given also an integer <code>k</code>, return the <code>k<sup>th</sup></code> missing number starting from the leftmost number of the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,7,9,10], k = 1
<strong>Output:</strong> 5
<strong>Explanation:</strong> The first missing number is 5.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,7,9,10], k = 3
<strong>Output:</strong> 8
<strong>Explanation:</strong> The missing numbers are [5,6,8,...], hence the third missing number is 8.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,4], k = 3
<strong>Output:</strong> 6
<strong>Explanation:</strong> The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>7</sup></code></li>
	<li><code>nums</code> is sorted in <strong>ascending order,</strong> and all the elements are <strong>unique</strong>.</li>
	<li><code>1 &lt;= k &lt;= 10<sup>8</sup></code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Can you find a logarithmic time complexity (i.e., <code>O(log(n))</code>) solution?

## Solutions

### Solution 1

> **Thinking**
>
> The array is sorted and distinct, so the number of missing values before index $i$ is $\textit{nums}[i]-\textit{nums}[0]-i$. A linear walk finds the $k$-th missing, but the follow-up asks for logarithmic time.
>
> $\textit{missing}(i)$ is increasing. If $k$ exceeds the missing count at the end, the answer lies past the array; otherwise we bisect the least $i$ with $\textit{missing}(i)\ge k$ and add the leftover gap to $\textit{nums}[i-1]$.
>
> The search range is $[0,n-1]$.

#### Java

```java
class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if (k > missing(nums, n - 1)) {
            return nums[n - 1] + k - missing(nums, n - 1);
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (missing(nums, mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l - 1] + k - missing(nums, l - 1);
    }

    private int missing(int[] nums, int i) {
        return nums[i] - nums[0] - i;
    }
}
```
