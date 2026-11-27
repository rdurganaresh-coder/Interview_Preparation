# 2104. Sum of Subarray Ranges

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/sum-of-subarray-ranges/

---

[中文文档](/solution/2100-2199/2104.Sum%20of%20Subarray%20Ranges/README.md)

## Description

<p>You are given an integer array <code>nums</code>. The <strong>range</strong> of a subarray of <code>nums</code> is the difference between the largest and smallest element in the subarray.</p>

<p>Return <em>the <strong>sum of all</strong> subarray ranges of </em><code>nums</code><em>.</em></p>

<p>A subarray is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,3]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,-2,-3,4,1]
<strong>Output:</strong> 59
<strong>Explanation:</strong> The sum of all subarray ranges of nums is 59.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow-up:</strong> Could you find a solution with <code>O(n)</code> time complexity?</p>

## Solutions

### Solution 1

> **Thinking**
>
> The sum of ranges is the sum of $\max-\min$ over every subarray. With $n\le 1000$, enumerating endpoints while maintaining the current max and min is $O(n^2)$ and acceptable.
>
> The inner scan need not restart: after fixing left index $i$, extending $j$ only updates $mi$ and $mx$ and adds their difference.
>
> A double loop therefore accumulates every range.

#### Java

```java
class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            int mi = nums[i], mx = nums[i];
            for (int j = i + 1; j < n; ++j) {
                mi = Math.min(mi, nums[j]);
                mx = Math.max(mx, nums[j]);
                ans += (mx - mi);
            }
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 becomes heavy for larger $n$. Each value’s contribution as a subarray maximum (or minimum) is its value times the number of subarrays where it attains that extremum, so the range sum is “max contributions minus min contributions”.
>
> A monotonic stack finds, for each index, the previous greater-or-equal and the next strictly greater positions, counting those subarrays in linear time. Negating the array and repeating yields the minimum side.
>
> We therefore implement $f$ and return $f(\textit{nums})+f([-v])$.

#### Java

```java
class Solution {
    public long subArrayRanges(int[] nums) {
        long mx = f(nums);
        for (int i = 0; i < nums.length; ++i) {
            nums[i] *= -1;
        }
        long mi = f(nums);
        return mx + mi;
    }

    private long f(int[] nums) {
        Deque<Integer> stk = new ArrayDeque<>();
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        long s = 0;
        for (int i = 0; i < n; ++i) {
            s += (long) (i - left[i]) * (right[i] - i) * nums[i];
        }
        return s;
    }
}
```
