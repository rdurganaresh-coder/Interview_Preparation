# 2099. Find Subsequence of Length K With the Largest Sum

**Difficulty:** Easy  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/

---

[中文文档](/solution/2000-2099/2099.Find%20Subsequence%20of%20Length%20K%20With%20the%20Largest%20Sum/README.md)

## Description

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>. You want to find a <strong>subsequence </strong>of <code>nums</code> of length <code>k</code> that has the <strong>largest</strong> sum.</p>

<p>Return<em> </em><em><strong>any</strong> such subsequence as an integer array of length </em><code>k</code>.</p>

<p>A <strong>subsequence</strong> is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,1,3,3], k = 2
<strong>Output:</strong> [3,3]
<strong>Explanation:</strong>
The subsequence has the largest sum of 3 + 3 = 6.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [-1,-2,3,4], k = 3
<strong>Output:</strong> [-1,3,4]
<strong>Explanation:</strong> 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,4,3,3], k = 2
<strong>Output:</strong> [3,4]
<strong>Explanation:</strong>
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>

## Solutions

### Solution 1: Sorting

> **Thinking**
>
> Maximum sum with original order means the $k$ largest values, then sorted by index. $n \le 1000$, so sort indices by value.
>
> Keep the last $k$ indices and emit $\textit{nums}$ in increasing index order.

First, we create an index array $\textit{idx}$, where each element is an index of the array $\textit{nums}$. Then, we sort the index array $\textit{idx}$ based on the values in $\textit{nums}$, with the sorting rule being $\textit{nums}[i] < \textit{nums}[j]$, where $i$ and $j$ are two indices in the index array $\textit{idx}$.

After sorting, we take the last $k$ elements of the index array $\textit{idx}$. These $k$ elements correspond to the largest $k$ elements in the array $\textit{nums}$. Then, we sort these $k$ indices to get the order of the largest $k$ elements in the array $\textit{nums}$.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> nums[i] - nums[j]);
        Arrays.sort(idx, n - k, n);
        int[] ans = new int[k];
        for (int i = n - k; i < n; ++i) {
            ans[i - (n - k)] = nums[idx[i]];
        }
        return ans;
    }
}
```
