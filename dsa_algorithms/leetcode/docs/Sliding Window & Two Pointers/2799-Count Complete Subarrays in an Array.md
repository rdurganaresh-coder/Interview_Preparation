# 2799. Count Complete Subarrays in an Array

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/count-complete-subarrays-in-an-array/

---

[中文文档](/solution/2700-2799/2799.Count%20Complete%20Subarrays%20in%20an%20Array/README.md)

## Description

<p>You are given an array <code>nums</code> consisting of <strong>positive</strong> integers.</p>

<p>We call a subarray of an array <strong>complete</strong> if the following condition is satisfied:</p>

<ul>
	<li>The number of <strong>distinct</strong> elements in the subarray is equal to the number of distinct elements in the whole array.</li>
</ul>

<p>Return <em>the number of <strong>complete</strong> subarrays</em>.</p>

<p>A <strong>subarray</strong> is a contiguous non-empty part of an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,1,2,2]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,5,5,5]
<strong>Output:</strong> 10
<strong>Explanation:</strong> The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 2000</code></li>
</ul>

## Solutions

### Solution 1: Hash Table + Enumeration

> **Thinking**
>
> A complete subarray contains every distinct value of the original array. Building a set for every pair of ends is acceptable at $n\le 1000$.
>
> Compute the global number of distinct values $\textit{cnt}$, then for each left end grow a set rightward and count a complete subarray whenever the set size reaches $\textit{cnt}$.

First, we use a hash table to count the number of distinct elements in the array, denoted as $\textit{cnt}$.

Next, we enumerate the left endpoint index $i$ of the subarray and maintain a set $s$ to store the elements in the subarray. Each time we move the right endpoint index $j$ to the right, we add $\textit{nums}[j]$ to the set $s$ and check whether the size of the set $s$ equals $\textit{cnt}$. If it equals $\textit{cnt}$, it means the current subarray is a complete subarray, and we increment the answer by $1$.

After the enumeration ends, we return the answer.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        int cnt = s.size();
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            s.clear();
            for (int j = i; j < n; ++j) {
                s.add(nums[j]);
                if (s.size() == cnt) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
```

### Solution 2: Hash Table + Two Pointers

> **Thinking**
>
> Solution 1 rebuilds a set from each left end. The number of distinct values is monotone in the right end: once the window is complete, every subarray that keeps this right end and a left end at most $i$ is complete, which adds $n-j$. Then advance the left end while updating the counts.

Similar to Solution 1, we can use a hash table to count the number of distinct elements in the array, denoted as $\textit{cnt}$.

Next, we use two pointers to maintain a sliding window, where the right endpoint index is $j$ and the left endpoint index is $i$.

Each time we fix the left endpoint index $i$, we move the right endpoint index $j$ to the right. When the number of distinct elements in the sliding window equals $\textit{cnt}$, it means that all subarrays from the left endpoint index $i$ to the right endpoint index $j$ and beyond are complete subarrays. We then increment the answer by $n - j$, where $n$ is the length of the array. Afterward, we move the left endpoint index $i$ one step to the right and repeat the process.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int x : nums) {
            d.put(x, 1);
        }
        int cnt = d.size();
        int ans = 0, n = nums.length;
        d.clear();
        for (int i = 0, j = 0; j < n; ++j) {
            d.merge(nums[j], 1, Integer::sum);
            while (d.size() == cnt) {
                ans += n - j;
                if (d.merge(nums[i], -1, Integer::sum) == 0) {
                    d.remove(nums[i]);
                }
                ++i;
            }
        }
        return ans;
    }
}
```
