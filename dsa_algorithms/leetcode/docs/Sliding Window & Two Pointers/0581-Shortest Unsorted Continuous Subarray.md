# 581. Shortest Unsorted Continuous Subarray

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

---

[中文文档](/solution/0500-0599/0581.Shortest%20Unsorted%20Continuous%20Subarray/README.md)

## Description

<p>Given an integer array <code>nums</code>, you need to find one <b>continuous subarray</b> such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.</p>

<p>Return <em>the shortest such subarray and output its length</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,6,4,8,10,9,15]
<strong>Output:</strong> 5
<strong>Explanation:</strong> You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Can you solve it in <code>O(n)</code> time complexity?

## Solutions

### Solution 1: Sorting

> **Thinking**
>
> The shortest unsorted subarray is the one that, once sorted, makes the whole array sorted. Sort a copy and compare: the first and last mismatches bound that interval.
>
> $n \le 10^4$ allows a sort. If nothing mismatches, the array is already sorted and the length is $0$.

We can first sort the array, and then compare the sorted array with the original array to find the leftmost and rightmost positions where they differ. The length between them is the length of the shortest unsorted continuous subarray.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l <= r && nums[l] == arr[l]) {
            l++;
        }
        while (l <= r && nums[r] == arr[r]) {
            r--;
        }
        return r - l + 1;
    }
}
```

### Solution 2: Maintaining the Maximum Value on the Left and the Minimum Value on the Right

> **Thinking**
>
> Sorting adds a log factor. A left-to-right scan: whenever a value is below the prefix maximum it belongs in the unsorted interval, so the right end grows. A right-to-left scan uses the suffix minimum for the left end.
>
> Both ends start at $-1$; if the right end never moves, return $0$. Two linear passes, constant space.

We can traverse the array from left to right and maintain a maximum value $mx$. If the current value is less than $mx$, it means that the current value is not in the correct position, and we update the right boundary $r$ to the current position. Similarly, we can traverse the array from right to left and maintain a minimum value $mi$. If the current value is greater than $mi$, it means that the current value is not in the correct position, and we update the left boundary $l$ to the current position. At initialization, we set $l$ and $r$ to $-1$. If $l$ and $r$ are not updated, it means that the array is already sorted, and we return $0$. Otherwise, we return $r - l + 1$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        final int inf = 1 << 30;
        int n = nums.length;
        int l = -1, r = -1;
        int mi = inf, mx = -inf;
        for (int i = 0; i < n; ++i) {
            if (mx > nums[i]) {
                r = i;
            } else {
                mx = nums[i];
            }
            if (mi < nums[n - i - 1]) {
                l = n - i - 1;
            } else {
                mi = nums[n - i - 1];
            }
        }
        return r == -1 ? 0 : r - l + 1;
    }
}
```
