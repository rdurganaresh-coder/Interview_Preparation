# 3471. Find the Largest Almost Missing Integer

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/find-the-largest-almost-missing-integer/

---

[中文文档](/solution/3400-3499/3471.Find%20the%20Largest%20Almost%20Missing%20Integer/README.md)

## Description

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>.</p>

<p>An integer <code>x</code> is <strong>almost missing</strong> from <code>nums</code> if <code>x</code> appears in <em>exactly</em> one subarray of size <code>k</code> within <code>nums</code>.</p>

<p>Return the <b>largest</b> <strong>almost missing</strong> integer from <code>nums</code>. If no such integer exists, return <code>-1</code>.</p>
A <strong>subarray</strong> is a contiguous sequence of elements within an array.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,9,2,1,7], k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>1 appears in 2 subarrays of size 3: <code>[9, 2, 1]</code> and <code>[2, 1, 7]</code>.</li>
	<li>2 appears in 3 subarrays of size 3: <code>[3, 9, 2]</code>, <code>[9, 2, 1]</code>, <code>[2, 1, 7]</code>.</li>
	<li index="2">3 appears in 1 subarray of size 3: <code>[3, 9, 2]</code>.</li>
	<li index="3">7 appears in 1 subarray of size 3: <code>[2, 1, 7]</code>.</li>
	<li index="4">9 appears in 2 subarrays of size 3: <code>[3, 9, 2]</code>, and <code>[9, 2, 1]</code>.</li>
</ul>

<p>We return 7 since it is the largest integer that appears in exactly one subarray of size <code>k</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,9,7,2,1,7], k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>1 appears in 2 subarrays of size 4: <code>[9, 7, 2, 1]</code>, <code>[7, 2, 1, 7]</code>.</li>
	<li>2 appears in 3 subarrays of size 4: <code>[3, 9, 7, 2]</code>, <code>[9, 7, 2, 1]</code>, <code>[7, 2, 1, 7]</code>.</li>
	<li>3 appears in 1 subarray of size 4: <code>[3, 9, 7, 2]</code>.</li>
	<li>7 appears in 3 subarrays of size 4: <code>[3, 9, 7, 2]</code>, <code>[9, 7, 2, 1]</code>, <code>[7, 2, 1, 7]</code>.</li>
	<li>9 appears in 2 subarrays of size 4: <code>[3, 9, 7, 2]</code>, <code>[9, 7, 2, 1]</code>.</li>
</ul>

<p>We return 3 since it is the largest and only integer that appears in exactly one subarray of size <code>k</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [0,0], k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<p>There is no integer that appears in only one subarray of size 1.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 50</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 50</code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>

## Solutions

### Solution 1: Case Analysis

> **Thinking**
>
> An almost-missing integer occurs in exactly one window of length $k$. Counting global frequencies ignores how windows overlap.
>
> When $k=1$ every element is a window, so we take the maximum unique value. When $k=n$ there is one window, so we take the global maximum.
>
> When $1<k<n$, interior values sit in at least two windows; only the two ends can occur once. We check that $\textit{nums}[0]$ and $\textit{nums}[n-1]$ do not reappear, and return the larger, or $-1$.

If $k = 1$, then each element in the array forms a subarray of size $1$. In this case, we only need to find the maximum value among the elements that appear exactly once in the array.

If $k = n$, then the entire array forms a subarray of size $n$. In this case, we only need to return the maximum value in the array.

If $1 < k < n$, only $\textit{nums}[0]$ and $\textit{nums}[n-1]$ can be the almost missing integers. If they appear elsewhere in the array, they are not almost missing integers. Therefore, we only need to check if $\textit{nums}[0]$ and $\textit{nums}[n-1]$ appear elsewhere in the array and return the maximum value among them.

If no almost missing integer exists, return $-1$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    private int[] nums;

    public int largestInteger(int[] nums, int k) {
        this.nums = nums;
        if (k == 1) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : nums) {
                cnt.merge(x, 1, Integer::sum);
            }
            int ans = -1;
            for (var e : cnt.entrySet()) {
                if (e.getValue() == 1) {
                    ans = Math.max(ans, e.getKey());
                }
            }
            return ans;
        }
        if (k == nums.length) {
            return Arrays.stream(nums).max().getAsInt();
        }
        return Math.max(f(0), f(nums.length - 1));
    }

    private int f(int k) {
        for (int i = 0; i < nums.length; ++i) {
            if (i != k && nums[i] == nums[k]) {
                return -1;
            }
        }
        return nums[k];
    }
}
```
