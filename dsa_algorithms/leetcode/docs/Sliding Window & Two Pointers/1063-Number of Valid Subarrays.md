# 1063. Number of Valid Subarrays

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/number-of-valid-subarrays/

---

[中文文档](/solution/1000-1099/1063.Number%20of%20Valid%20Subarrays/README.md)

## Description

<p>Given an integer array <code>nums</code>, return <em>the number of non-empty <strong>subarrays</strong> with the leftmost element of the subarray&nbsp;not larger than other elements in the subarray</em>.</p>

<p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,4,2,5,3]
<strong>Output:</strong> 11
<strong>Explanation:</strong> There are 11 valid subarrays: [1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The 3 valid subarrays are: [3],[2],[1].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,2,2]
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 valid subarrays: [2],[2],[2],[2,2],[2,2],[2,2,2].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A subarray is valid iff its left end is the minimum. For each $i$ the right end may extend up to the next strictly smaller value. $n\le 5\times 10^4$ needs a linear next-smaller scan.
>
> A decreasing index stack from the right pops every top that is not smaller than $\textit{nums}[i]$; the new top (or $n$) is the boundary and contributes that index minus $i$.
>
> Storing $\textit{right}[i]$ and summing matches the definition.

#### Java

```java
class Solution {
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        Arrays.fill(right, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += right[i] - i;
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 stores the whole $\textit{right}$ array. The boundary is known immediately while scanning backward.
>
> The same stack adds $(\textit{stk}[-1]\text{ or }n)-i$ to the answer on the fly.

#### Java

```java
class Solution {
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        Deque<Integer> stk = new ArrayDeque<>();
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            ans += (stk.isEmpty() ? n : stk.peek()) - i;

            stk.push(i);
        }
        return ans;
    }
}
```
