# 3397. Maximum Number of Distinct Elements After Operations

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/

---

[中文文档](/solution/3300-3399/3397.Maximum%20Number%20of%20Distinct%20Elements%20After%20Operations/README.md)

## Description

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>.</p>

<p>You are allowed to perform the following <strong>operation</strong> on each element of the array <strong>at most</strong> <em>once</em>:</p>

<ul>
	<li>Add an integer in the range <code>[-k, k]</code> to the element.</li>
</ul>

<p>Return the <strong>maximum</strong> possible number of <strong>distinct</strong> elements in <code>nums</code> after performing the <strong>operations</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,2,3,3,4], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>

<p><code>nums</code> changes to <code>[-1, 0, 1, 2, 3, 4]</code> after performing operations on the first four elements.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,4,4,4], k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>By adding -1 to <code>nums[0]</code> and 1 to <code>nums[1]</code>, <code>nums</code> changes to <code>[3, 5, 4, 4]</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Greedy + Sorting

> **Thinking**
>
> Each $x$ may become any integer in $[x-k,x+k]$; we want as many distinct results as possible. With $n \le 10^5$ we sort and greedily take the smallest still-available integer.
>
> $\textit{pre}$ is the last used value. $x$ becomes $\min(x+k,\max(x-k,\textit{pre}+1))$ and counts if that is still above $\textit{pre}$.
>
> Using smaller integers first leaves room for later, larger intervals, which is why we sort.

We can sort the array $\textit{nums}$ and then consider each element $x$ from left to right.

For the first element, we can greedily change it to $x - k$, making $x$ as small as possible to leave more space for subsequent elements. We use the variable $\textit{pre}$ to track the maximum value of the elements used so far, initialized to negative infinity.

For subsequent elements $x$, we can greedily change it to $\min(x + k, \max(x - k, \textit{pre} + 1))$. Here, $\max(x - k, \textit{pre} + 1)$ means we try to make $x$ as small as possible but not smaller than $\textit{pre} + 1$. If this value exists and is less than $x + k$, we can change $x$ to this value, increment the count of distinct elements, and update $\textit{pre}$ to this value.

After traversing the array, we obtain the maximum number of distinct elements.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0, pre = Integer.MIN_VALUE;
        for (int x : nums) {
            int cur = Math.min(x + k, Math.max(x - k, pre + 1));
            if (cur > pre) {
                ++ans;
                pre = cur;
            }
        }
        return ans;
    }
}
```
