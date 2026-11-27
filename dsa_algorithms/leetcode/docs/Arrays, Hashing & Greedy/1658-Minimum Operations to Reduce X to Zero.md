# 1658. Minimum Operations to Reduce X to Zero

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

---

[中文文档](/solution/1600-1699/1658.Minimum%20Operations%20to%20Reduce%20X%20to%20Zero/README.md)

## Description

<p>You are given an integer array <code>nums</code> and an integer <code>x</code>. In one operation, you can either remove the leftmost or the rightmost element from the array <code>nums</code> and subtract its value from <code>x</code>. Note that this <strong>modifies</strong> the array for future operations.</p>

<p>Return <em>the <strong>minimum number</strong> of operations to reduce </em><code>x</code> <em>to <strong>exactly</strong></em> <code>0</code> <em>if it is possible</em><em>, otherwise, return </em><code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,4,2,3], x = 5
<strong>Output:</strong> 2
<strong>Explanation:</strong> The optimal solution is to remove the last two elements to reduce x to zero.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,6,7,8,9], x = 4
<strong>Output:</strong> -1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,20,1,1,3], x = 10
<strong>Output:</strong> 5
<strong>Explanation:</strong> The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= x &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Hash Table + Prefix Sum

> **Thinking**
>
> We may only drop endpoints so the removed sum equals $x$ in as few moves as possible — equivalently, keep the longest subarray whose sum is $\sum \textit{nums}-x$. $n$ is $10^5$, so that subarray must be found in linear time.
>
> A prefix-sum map stores the first index of each sum; when $t-s$ has been seen, update the longest length. The answer is $n$ minus that length.

According to the problem description, we need to remove elements from both ends of the array $\textit{nums}$ so that the sum of the removed elements equals $x$, and the number of removed elements is minimized. We can transform the problem into: find the longest consecutive subarray in the array $\textit{nums}$ such that the sum of the subarray $s = \sum_{i=0}^{n} \textit{nums}[i] - x$. In this way, we can transform the problem into finding the length $mx$ of the longest consecutive subarray in the array $\textit{nums}$ with a sum of $s$, and the answer is $n - mx$.

We initialize $mx = -1$, and then use a hash table $\textit{vis}$ to store the prefix sum, where the key is the prefix sum and the value is the index corresponding to the prefix sum.

Traverse the array $\textit{nums}$, for the current element $\textit{nums}[i]$, calculate the prefix sum $t$, if $t$ is not in the hash table, add $t$ to the hash table; if $t - s$ is in the hash table, update $mx = \max(mx, i - \textit{vis}[t - s])$.

Finally, if $mx = -1$, return $-1$, otherwise return $n - mx$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int minOperations(int[] nums, int x) {
        int s = -x;
        for (int v : nums) {
            s += v;
        }
        Map<Integer, Integer> vis = new HashMap<>();
        vis.put(0, -1);
        int mx = -1, t = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            t += nums[i];
            vis.putIfAbsent(t, i);
            if (vis.containsKey(t - s)) {
                mx = Math.max(mx, i - vis.get(t - s));
            }
        }
        return mx == -1 ? -1 : n - mx;
    }
}
```

### Solution 2: Two Pointers

> **Thinking**
>
> Solution 1 uses a hash map. All values are positive, so prefix sums increase and two pointers can shrink the window down to sum $s$ without extra memory.

Based on the analysis of Solution 1, we need to find the length $mx$ of the longest consecutive subarray in the array $\textit{nums}$ with a sum of $s$. Since all elements in the array $\textit{nums}$ are positive integers, the prefix sum of the array will only increase monotonically, so we can use two pointers to solve this problem.

We initialize pointer $j = 0$, prefix sum $t = 0$, and the length of the longest consecutive subarray $mx = -1$.

Traverse the array $\textit{nums}$, for the current element $\textit{nums}[i]$, calculate the prefix sum $t += \textit{nums}[i]$. If $t > s$, then move the pointer $j$ until $t \leq s$. If $t = s$, then update $mx = \max(mx, i - j + 1)$.

Finally, if $mx = -1$, return $-1$, otherwise return $n - mx$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int minOperations(int[] nums, int x) {
        int s = -x;
        for (int v : nums) {
            s += v;
        }
        int mx = -1, t = 0;
        int n = nums.length;
        for (int i = 0, j = 0; i < n; ++i) {
            t += nums[i];
            while (j <= i && t > s) {
                t -= nums[j++];
            }
            if (t == s) {
                mx = Math.max(mx, i - j + 1);
            }
        }
        return mx == -1 ? -1 : n - mx;
    }
}
```
