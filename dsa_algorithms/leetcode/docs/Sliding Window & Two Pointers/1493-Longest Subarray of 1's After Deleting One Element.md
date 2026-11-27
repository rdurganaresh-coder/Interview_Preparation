# 1493. Longest Subarray of 1's After Deleting One Element

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

---

[中文文档](/solution/1400-1499/1493.Longest%20Subarray%20of%201%27s%20After%20Deleting%20One%20Element/README.md)

## Description

<p>You are given a binary array <code>nums</code>, you should delete <strong>one</strong> element from it.</p>

<p>Return the size of the <strong>longest non-empty subarray</strong> containing only 1&#39;s in the resulting array. Return 0 if there is no such <strong>subarray</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,0,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1&#39;s.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,1,1,1,0,1,1,0,1]
<strong>Output:</strong> 5
<strong>Explanation:</strong> After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1&#39;s is [1,1,1,1,1].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> You must delete one element.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either 0 or 1.</li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> Exactly one element is deleted, so the answer is the ones immediately left of $i$ plus those immediately right. $n\le 10^5$. Precompute longest ones ending before $i$ and starting after $i$, then maximize over the deleted index.

We can enumerate each position $i$ to be deleted, then calculate the number of consecutive 1s on the left and right, and finally take the maximum value.

Specifically, we use two arrays $\textit{left}$ and $\textit{right}$ of length $n+1$, where $\textit{left}[i]$ represents the number of consecutive 1s ending with $\textit{nums}[i-1]$, and $\textit{right}[i]$ represents the number of consecutive 1s starting with $\textit{nums}[i]$.

The final answer is $\max_{0 \leq i < n} \{\textit{left}[i] + \textit{right}[i+1]\}$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (nums[i - 1] == 1) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] == 1) {
                right[i] = right[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, left[i] + right[i + 1]);
        }
        return ans;
    }
}
```

### Solution 2: Two Pointers

> **Thinking**
>
> Method 1 stores two arrays. Equivalently, find the longest window with at most one $0$; after deleting that $0$ (or one $1$) the length is $i-j$. Expand the right end and shrink while the zero count exceeds $1$.

The problem is actually asking us to find the longest subarray that contains at most one $0$. The remaining length after deleting one element from this subarray is the answer.

Therefore, we can use two pointers $j$ and $i$ to point to the left and right boundaries of the subarray, initially $j = 0$, $i = 0$. In addition, we use a variable $\textit{cnt}$ to record the number of $0$s in the subarray.

Next, we move the right pointer $i$. If $\textit{nums}[i] = 0$, then $\textit{cnt}$ is incremented by $1$. When $\textit{cnt} > 1$, we need to move the left pointer $j$ until $\textit{cnt} \leq 1$. Then, we update the answer, i.e., $\textit{ans} = \max(\textit{ans}, i - j)$. Continue to move the right pointer $i$ until $i$ reaches the end of the array.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0, j = 0, cnt = 0; i < n; ++i) {
            cnt += nums[i] ^ 1;
            while (cnt > 1) {
                cnt -= nums[j++] ^ 1;
            }
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
}
```

### Solution 3: Two Pointers (Optimization)

> **Thinking**
>
> Method 2 may shrink the window when zeros exceed one. We only need the maximum length, so move the left end once whenever the count is too large and keep the window non-decreasing. The answer is $n-l-1$.

In Solution 2, we move the left pointer in a loop until $\textit{cnt} \leq 1$. Since the problem asks for the longest subarray, it means we don't need to reduce the length of the subarray. Therefore, if $\textit{cnt} \gt 1$, we only move the left pointer once, and the right pointer continues to move to the right. This ensures that the length of the subarray does not decrease.

Finally, the answer we return is $n - l - 1$, where $l$ is the position of the left pointer.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int longestSubarray(int[] nums) {
        int cnt = 0, l = 0;
        for (int x : nums) {
            cnt += x ^ 1;
            if (cnt > 1) {
                cnt -= nums[l++] ^ 1;
            }
        }
        return nums.length - l - 1;
    }
}
```
