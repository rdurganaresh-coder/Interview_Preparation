# 718. Maximum Length of Repeated Subarray

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/maximum-length-of-repeated-subarray/

---

[中文文档](/solution/0700-0799/0718.Maximum%20Length%20of%20Repeated%20Subarray/README.md)

## Description

<p>Given two integer arrays <code>nums1</code> and <code>nums2</code>, return <em>the maximum length of a subarray that appears in <strong>both</strong> arrays</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The repeated subarray with maximum length is [3,2,1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
<strong>Output:</strong> 5
<strong>Explanation:</strong> The repeated subarray with maximum length is [0,0,0,0,0].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Find the longest common contiguous subarray. Lengths are $1000$, so matching from every pair of starts is too slow, and LCS DP does not enforce contiguity.
>
> Contiguity means a suffix grows only when the current pair matches: it is one plus the suffix of the prefixes, otherwise zero.
>
> Let $f[i][j]$ be the common suffix ending at $\textit{nums1}[i-1]$ and $\textit{nums2}[j-1]$. Take the global maximum. Time $O(mn)$.

#### Java

```java
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] f = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    ans = Math.max(ans, f[i][j]);
                }
            }
        }
        return ans;
    }
}
```
