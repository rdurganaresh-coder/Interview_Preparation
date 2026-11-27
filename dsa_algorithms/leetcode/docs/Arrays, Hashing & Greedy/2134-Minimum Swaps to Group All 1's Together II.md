# 2134. Minimum Swaps to Group All 1's Together II

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/

---

[中文文档](/solution/2100-2199/2134.Minimum%20Swaps%20to%20Group%20All%201%27s%20Together%20II/README.md)

## Description

<p>A <strong>swap</strong> is defined as taking two <strong>distinct</strong> positions in an array and swapping the values in them.</p>

<p>A <strong>circular</strong> array is defined as an array where we consider the <strong>first</strong> element and the <strong>last</strong> element to be <strong>adjacent</strong>.</p>

<p>Given a <strong>binary</strong> <strong>circular</strong> array <code>nums</code>, return <em>the minimum number of swaps required to group all </em><code>1</code><em>&#39;s present in the array together at <strong>any location</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,0,1,1,0,0]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Here are a few of the ways to group all the 1&#39;s together:
[0,<u>0</u>,<u>1</u>,1,1,0,0] using 1 swap.
[0,1,<u>1</u>,1,<u>0</u>,0,0] using 1 swap.
[1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
There is no way to group all 1&#39;s together with 0 swaps.
Thus, the minimum number of swaps required is 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,1,1,0,0,1,1,0]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Here are a few of the ways to group all the 1&#39;s together:
[1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
[1,1,1,1,1,0,0,0,0] using 2 swaps.
There is no way to group all 1&#39;s together with 0 or 1 swaps.
Thus, the minimum number of swaps required is 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,0,0,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> All the 1&#39;s are already grouped together due to the circular property of the array.
Thus, the minimum number of swaps required is 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>

## Solutions

### Solution 1: Sliding Window

> **Thinking**
>
> Grouping all $1$s on a circle is equivalent to a window of length $k=\textit{count}(1)$ that contains as many $1$s as possible; the answer is $k$ minus that maximum. Recounting every window is quadratic.
>
> A fixed-length circular window is a modular slide of $k$ extra steps. Count $1$s in the first $k$ cells, then add the entering index and drop the leaving one.
>
> After a full pass return $k-mx$.

First, we count the number of $1$s in the array, denoted as $k$. The problem is actually asking for a circular subarray of length $k$ that contains the maximum number of $1$s. Therefore, the minimum number of swaps is $k$ minus the maximum number of $1$s in that subarray.

We can solve this problem using a sliding window. First, we count the number of $1$s in the first $k$ elements of the array, denoted as $\textit{cnt}$. Then, we maintain a sliding window of length $k$. Each time we move the window one position to the right, we update $\textit{cnt}$ and simultaneously update the maximum $\textit{cnt}$ value, i.e., $mx = \max(mx, \textit{cnt})$. Finally, the answer is $k - mx$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int minSwaps(int[] nums) {
        int k = Arrays.stream(nums).sum();
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < k; ++i) {
            cnt += nums[i];
        }
        int mx = cnt;
        for (int i = k; i < n + k; ++i) {
            cnt += nums[i % n] - nums[(i - k + n) % n];
            mx = Math.max(mx, cnt);
        }
        return k - mx;
    }
}
```

### Solution 2: Prefix Sum

> **Thinking**
>
> Solution 1 wraps indices with modulo. Prefix sums on the linear array also count a value $x$ in every window whose length equals the global number of $x$; swaps equal that length minus the window count.
>
> Gathering all $1$s on a circle is the complement view of gathering all $0$s, so the implementation takes the minimum of the two prefix-sum answers.
>
> This records the prefix-sum formulation of the same window problem.
