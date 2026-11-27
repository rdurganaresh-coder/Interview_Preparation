# 189. Rotate Array

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/rotate-array/

---

[中文文档](/solution/0100-0199/0189.Rotate%20Array/README.md)

## Description

<p>Given an integer array <code>nums</code>, rotate the array to the right by <code>k</code> steps, where <code>k</code> is non-negative.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4,5,6,7], k = 3
<strong>Output:</strong> [5,6,7,1,2,3,4]
<strong>Explanation:</strong>
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,-100,3,99], k = 2
<strong>Output:</strong> [3,99,-1,-100]
<strong>Explanation:</strong> 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<ul>
	<li>Try to come up with as many solutions as you can. There are at least <strong>three</strong> different ways to solve this problem.</li>
	<li>Could you do it in-place with <code>O(1)</code> extra space?</li>
</ul>

## Solutions

### Solution 1: Reverse three times

> **Thinking**
>
> Rotate right by $k$. A second array is $O(n)$ space; $n\le 10^5$, and the follow-up wants in-place. A right rotate by $k$ moves the last $k$ items to the front. Reverse the whole array, then reverse the first $k$ and the last $n-k$. Three reversals, only swaps.

We can assume the length of the array is $n$ and calculate the actual number of steps needed by taking the module of $k$ and $n$, which is $k \bmod n$.

Next, let us reverse three times to get the final result:

1. Reverse the entire array.
2. Reverse the first $k$ elements.
3. Reverse the last $n - k$ elements.

For example, for the array $[1, 2, 3, 4, 5, 6, 7]$, $k = 3$, $n = 7$, $k \bmod n = 3$.

1. In the first reverse, reverse the entire array. We get $[7, 6, 5, 4, 3, 2, 1]$.
2. In the second reverse, reverse the first $k$ elements. We get $[5, 6, 7, 4, 3, 2, 1]$.
3. In the third reverse, reverse the last $n - k$ elements. We get $[5, 6, 7, 1, 2, 3, 4]$, which is the final result.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    private int[] nums;

    public void rotate(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        k %= n;
        reverse(0, n - 1);
        reverse(0, k - 1);
        reverse(k, n - 1);
    }

    private void reverse(int i, int j) {
        for (; i < j; ++i, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
```
