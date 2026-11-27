# 35. Search Insert Position

**Difficulty:** Easy  
**Category:** Binary Search  
**LeetCode:** https://leetcode.com/problems/search-insert-position/

---

[中文文档](/solution/0000-0099/0035.Search%20Insert%20Position/README.md)

## Description

<p>Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.</p>

<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,5,6], target = 5
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,5,6], target = 2
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,5,6], target = 7
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>nums</code> contains <strong>distinct</strong> values sorted in <strong>ascending</strong> order.</li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Binary Search

> **Thinking**
>
> The first idea is to scan left to right until the first index $\ge \textit{target}$. Correct, and $n \le 10^4$ would pass, but the array is strictly increasing, so a linear scan wastes the order.
>
> The insertion point is exactly the first index not smaller than $\textit{target}$ — a standard lower bound.
>
> Keep a half-open interval $[l,r)$: if $\textit{nums}[\textit{mid}] \ge \textit{target}$ the answer lies in the left half (including $\textit{mid}$), otherwise it lies to the right of $\textit{mid}$. When $l=r$, $l$ is the insertion index.

Since the array $\textit{nums}$ is already sorted, we can use the binary search method to find the insertion position of the target value $\textit{target}$.

The time complexity is $O(\log n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```

### Solution 2: Binary Search (Built-in Function)

> **Thinking**
>
> Method 1 is already $O(\log n)$; what it still lacks is only that we need not write the binary search by hand. Languages already expose a lower bound: Python's `bisect_left`, C++'s `lower_bound`, Java's `Arrays.binarySearch` (returning $-i-1$ when absent). The meaning matches Method 1; we just call the builtin.

We can also directly use the built-in function for binary search.

The time complexity is $O(\log n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        return i < 0 ? -i - 1 : i;
    }
}
```
