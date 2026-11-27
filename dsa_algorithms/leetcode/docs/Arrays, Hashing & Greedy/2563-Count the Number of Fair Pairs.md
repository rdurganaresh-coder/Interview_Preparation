# 2563. Count the Number of Fair Pairs

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-the-number-of-fair-pairs/

---

[中文文档](/solution/2500-2599/2563.Count%20the%20Number%20of%20Fair%20Pairs/README.md)

## Description

<p>Given a <strong>0-indexed</strong> integer array <code>nums</code> of size <code>n</code> and two integers <code>lower</code> and <code>upper</code>, return <em>the number of fair pairs</em>.</p>

<p>A pair <code>(i, j)</code> is <b>fair </b>if:</p>

<ul>
	<li><code>0 &lt;= i &lt; j &lt; n</code>, and</li>
	<li><code>lower &lt;= nums[i] + nums[j] &lt;= upper</code></li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,7,4,4,5], lower = 3, upper = 6
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,7,9,2,5], lower = 11, upper = 11
<strong>Output:</strong> 1
<strong>Explanation:</strong> There is a single fair pair: (2,3).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums.length == n</code></li>
	<li><code><font face="monospace">-10<sup>9</sup></font>&nbsp;&lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code><font face="monospace">-10<sup>9</sup>&nbsp;&lt;= lower &lt;= upper &lt;= 10<sup>9</sup></font></code></li>
</ul>

## Solutions

### Solution 1: Sorting + Binary Search

> **Thinking**
>
> Count unordered pairs whose sum lies in $[\textit{lower},\textit{upper}]$. A double loop fails at $n\le 10^5$.
>
> Only values matter, so sorting is safe. For a fixed $x=\textit{nums}[i]$ the partner must lie in $[\textit{lower}-x,\textit{upper}-x]$; the gap between two lower bounds is the count, starting at $i+1$ to avoid double-counting.

First, we sort the array $\textit{nums}$ in ascending order. Then, for each `nums[i]`, we use binary search to find the lower bound `j` of `nums[j]`, i.e., the first index that satisfies `nums[j] >= lower - nums[i]`. Then, we use binary search again to find the lower bound `k` of `nums[k]`, i.e., the first index that satisfies `nums[k] >= upper - nums[i] + 1`. Therefore, `[j, k)` is the index range for `nums[j]` that satisfies `lower <= nums[i] + nums[j] <= upper`. The count of these indices corresponding to `nums[j]` is `k - j`, and we can add this to the answer. Note that $j > i$.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = search(nums, lower - nums[i], i + 1);
            int k = search(nums, upper - nums[i] + 1, i + 1);
            ans += k - j;
        }
        return ans;
    }

    private int search(int[] nums, int x, int left) {
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
```
