# 2176. Count Equal and Divisible Pairs in an Array

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/

---

[中文文档](/solution/2100-2199/2176.Count%20Equal%20and%20Divisible%20Pairs%20in%20an%20Array/README.md)

## Description

Given a <strong>0-indexed</strong> integer array <code>nums</code> of length <code>n</code> and an integer <code>k</code>, return <em>the <strong>number of pairs</strong></em> <code>(i, j)</code> <em>where</em> <code>0 &lt;= i &lt; j &lt; n</code>, <em>such that</em> <code>nums[i] == nums[j]</code> <em>and</em> <code>(i * j)</code> <em>is divisible by</em> <code>k</code>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,1,2,2,2,1,3], k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong>
There are 4 pairs that meet all the requirements:
- nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
- nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
- nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
- nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4], k = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> Since no value in nums is repeated, there are no pairs (i,j) that meet all the requirements.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i], k &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> Count pairs $i<j$ with equal values and $i\cdot j$ divisible by $k$. $n\le 100$ allows a double loop.
>
> Fix $j$ and scan earlier $i$, testing equality and the modular product.
>
> No extra index structure is required.

We first enumerate the index $j$ in the range $[0, n)$, and then enumerate the index $i$ in the range $[0, j)$. We count the number of pairs that satisfy $\textit{nums}[i] = \textit{nums}[j]$ and $(i \times j) \bmod k = 0$.

The time complexity is $O(n^2)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int countPairs(int[] nums, int k) {
        int ans = 0;
        for (int j = 1; j < nums.length; ++j) {
            for (int i = 0; i < j; ++i) {
                ans += nums[i] == nums[j] && (i * j % k) == 0 ? 1 : 0;
            }
        }
        return ans;
    }
}
```
