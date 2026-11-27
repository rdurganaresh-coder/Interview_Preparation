# 704. Binary Search

**Difficulty:** Easy  
**Category:** Binary Search  
**LeetCode:** https://leetcode.com/problems/binary-search/

---

[中文文档](/solution/0700-0799/0704.Binary%20Search/README.md)

## Description

<p>Given an array of integers <code>nums</code> which is sorted in ascending order, and an integer <code>target</code>, write a function to search <code>target</code> in <code>nums</code>. If <code>target</code> exists, then return its index. Otherwise, return <code>-1</code>.</p>

<p>You must write an algorithm with <code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,0,3,5,9,12], target = 9
<strong>Output:</strong> 4
<strong>Explanation:</strong> 9 exists in nums and its index is 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,0,3,5,9,12], target = 2
<strong>Output:</strong> -1
<strong>Explanation:</strong> 2 does not exist in nums so return -1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt; nums[i], target &lt; 10<sup>4</sup></code></li>
	<li>All the integers in <code>nums</code> are <strong>unique</strong>.</li>
	<li><code>nums</code> is sorted in ascending order.</li>
</ul>

## Solutions

### Solution 1: Binary Search

> **Thinking**
>
> Search $\textit{target}$ in a strictly increasing array. $n \le 10^4$ would allow a scan, but each comparison can discard half of a sorted range.
>
> If $\textit{nums}[\textit{mid}] \ge \textit{target}$, the answer is not to the right, so $r$ moves to $\textit{mid}$; otherwise it lies past $\textit{mid}$, so $l$ becomes $\textit{mid}+1$.
>
> When $l=r$ we sit on the first value that is not smaller than the target, then compare once. Time $O(\log n)$, extra space $O(1)$.

We define the left boundary $l=0$ and the right boundary $r=n-1$ for binary search.

In each iteration, we calculate the middle position $\textit{mid}=(l+r)/2$, then compare the size of $\textit{nums}[\textit{mid}]$ and $\textit{target}$.

- If $\textit{nums}[\textit{mid}] \geq \textit{target}$, it means $\textit{target}$ is in the left half, so we move the right boundary $r$ to $\textit{mid}$;
- Otherwise, it means $\textit{target}$ is in the right half, so we move the left boundary $l$ to $\textit{mid}+1$.

The loop ends when $l<r$, at this point $\textit{nums}[l]$ is the target value we are looking for. If $\textit{nums}[l]=\textit{target}$, return $l$; otherwise, return $-1$.

The time complexity is $O(\log n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
```
