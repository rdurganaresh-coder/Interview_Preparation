# 3420. Count Non-Decreasing Subarrays After K Operations

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/

---

[中文文档](/solution/3400-3499/3420.Count%20Non-Decreasing%20Subarrays%20After%20K%20Operations/README.md)

## Description

<p>You are given an array <code>nums</code> of <code>n</code> integers and an integer <code>k</code>.</p>

<p>For each subarray of <code>nums</code>, you can apply <strong>up to</strong> <code>k</code> operations on it. In each operation, you increment any element of the subarray by 1.</p>

<p><strong>Note</strong> that each subarray is considered independently, meaning changes made to one subarray do not persist to another.</p>

<p>Return the number of subarrays that you can make <strong>non-decreasing</strong> ​​​​​after performing at most <code>k</code> operations.</p>

<p>An array is said to be <strong>non-decreasing</strong> if each element is greater than or equal to its previous element, if it exists.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [6,3,1,2,4,4], k = 7</span></p>

<p><strong>Output:</strong> <span class="example-io">17</span></p>

<p><strong>Explanation:</strong></p>

<p>Out of all 21 possible subarrays of <code>nums</code>, only the subarrays <code>[6, 3, 1]</code>, <code>[6, 3, 1, 2]</code>, <code>[6, 3, 1, 2, 4]</code> and <code>[6, 3, 1, 2, 4, 4]</code> cannot be made non-decreasing after applying up to k = 7 operations. Thus, the number of non-decreasing subarrays is <code>21 - 4 = 17</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [6,3,1,3,6], k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">12</span></p>

<p><strong>Explanation:</strong></p>

<p>The subarray <code>[3, 1, 3, 6]</code> along with all subarrays of <code>nums</code> with three or fewer elements, except <code>[6, 3, 1]</code>, can be made non-decreasing after <code>k</code> operations. There are 5 subarrays of a single element, 4 subarrays of two elements, and 2 subarrays of three elements except <code>[6, 3, 1]</code>, so there are <code>1 + 5 + 4 + 2 = 12</code> subarrays that can be made non-decreasing.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> An operation increments one element. Making a subarray non-decreasing means raising every position to the prefix maximum on its left; the cost is the total raise. $n\le 10^5$ forbids recomputing every subarray.
>
> Longer subarrays never cost less, so each right end has a farthest left end whose cost is still $\le k$.
>
> A monotonic stack stores segments that act as prefix maxima. The left pointer evicts expired segments and refunds their cost. Summing the number of valid left ends for every right end is the answer.

#### Java

```java
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        long ans = 0;
        long cost = 0;
        int r = n - 1;
        for (int l = n - 1; l >= 0; --l) {
            int x = nums[l];
            while (!q.isEmpty() && nums[q.peekLast()] <= x) {
                int s = q.pollLast();
                int end = q.isEmpty() ? r + 1 : q.peekLast();
                cost += (long) (end - s) * (x - nums[s]);
            }
            q.offerLast(l);
            while (cost > k) {
                cost -= nums[q.peekFirst()] - nums[r];
                if (q.peekFirst() == r) {
                    q.pollFirst();
                }
                --r;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
```
