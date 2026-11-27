# 795. Number of Subarrays with Bounded Maximum

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

---

[中文文档](/solution/0700-0799/0795.Number%20of%20Subarrays%20with%20Bounded%20Maximum/README.md)

## Description

<p>Given an integer array <code>nums</code> and two integers <code>left</code> and <code>right</code>, return <em>the number of contiguous non-empty <strong>subarrays</strong> such that the value of the maximum array element in that subarray is in the range </em><code>[left, right]</code>.</p>

<p>The test cases are generated so that the answer will fit in a <strong>32-bit</strong> integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,1,4,3], left = 2, right = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are three subarrays that meet the requirements: [2], [2, 1], [3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,9,2,5,6], left = 2, right = 8
<strong>Output:</strong> 7
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= left &lt;= right &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Count subarrays whose maximum lies in $[\textit{left},\textit{right}]$. $n\le 10^5$. That is (max $\le \textit{right}$) minus (max $\le \textit{left}-1$).
>
> $f(x)$ walks once: grow a valid suffix while $v\le x$ and add its length, else reset.

#### Java

```java
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return f(nums, right) - f(nums, left - 1);
    }

    private int f(int[] nums, int x) {
        int cnt = 0, t = 0;
        for (int v : nums) {
            t = v > x ? 0 : t + 1;
            cnt += t;
        }
        return cnt;
    }
}
```

### Solution 2

> **Thinking**
>
> The difference of $f$ hides who the maximum is. A monotonic stack finds the nearest stricter left greater and non-stricter right greater; the span $(i-l)(r-i)$ counts if $\textit{nums}[i]$ is in range.
>
> Asymmetric bounds assign a unique maximum when values tie.

#### Java

```java
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            int v = nums[i];
            while (!stk.isEmpty() && nums[stk.peek()] <= v) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                l[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            int v = nums[i];
            while (!stk.isEmpty() && nums[stk.peek()] < v) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                r[i] = stk.peek();
            }
            stk.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left <= nums[i] && nums[i] <= right) {
                ans += (i - l[i]) * (r[i] - i);
            }
        }
        return ans;
    }
}
```
