# 2012. Sum of Beauty in the Array

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/sum-of-beauty-in-the-array/

---

[中文文档](/solution/2000-2099/2012.Sum%20of%20Beauty%20in%20the%20Array/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>. For each index <code>i</code> (<code>1 &lt;= i &lt;= nums.length - 2</code>) the <strong>beauty</strong> of <code>nums[i]</code> equals:</p>

<ul>
	<li><code>2</code>, if <code>nums[j] &lt; nums[i] &lt; nums[k]</code>, for <strong>all</strong> <code>0 &lt;= j &lt; i</code> and for <strong>all</strong> <code>i &lt; k &lt;= nums.length - 1</code>.</li>
	<li><code>1</code>, if <code>nums[i - 1] &lt; nums[i] &lt; nums[i + 1]</code>, and the previous condition is not satisfied.</li>
	<li><code>0</code>, if none of the previous conditions holds.</li>
</ul>

<p>Return<em> the <strong>sum of beauty</strong> of all </em><code>nums[i]</code><em> where </em><code>1 &lt;= i &lt;= nums.length - 2</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 2
<strong>Explanation:</strong> For each index i in the range 1 &lt;= i &lt;= 1:
- The beauty of nums[1] equals 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,4,6,4]
<strong>Output:</strong> 1
<strong>Explanation:</strong> For each index i in the range 1 &lt;= i &lt;= 2:
- The beauty of nums[1] equals 1.
- The beauty of nums[2] equals 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> For each index i in the range 1 &lt;= i &lt;= 1:
- The beauty of nums[1] equals 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Preprocessing Right Minimum + Traversing to Maintain Left Maximum

> **Thinking**
>
> With $n \le 10^5$, rescanning left/right extrema per $i$ is quadratic. Beauty $2$ needs $\textit{nums}[i]$ strictly above every left value and below every right value; beauty $1$ only looks at neighbors.
>
> Suffix minima $\textit{right}[i]$ are precomputed; a running $l$ tracks the left maximum.
>
> Each middle index first tests $l < \textit{nums}[i] < \textit{right}[i+1]$ for $2$, else the adjacent triple for $1$.

We can preprocess the right minimum array $\textit{right}$, where $\textit{right}[i]$ represents the minimum value in $\textit{nums}[i..n-1]$.

Then we traverse the array $\textit{nums}$ from left to right, while maintaining the maximum value $l$ on the left. For each position $i$, we judge whether $l < \textit{nums}[i] < \textit{right}[i + 1]$ holds. If it does, we add $2$ to the answer. Otherwise, we judge whether $\textit{nums}[i - 1] < \textit{nums}[i] < \textit{nums}[i + 1]$ holds. If it does, we add $1$ to the answer.

After the traversal, we can get the answer.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i > 0; --i) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
        int ans = 0;
        int l = nums[0];
        for (int i = 1; i < n - 1; ++i) {
            int r = right[i + 1];
            if (l < nums[i] && nums[i] < r) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans += 1;
            }
            l = Math.max(l, nums[i]);
        }
        return ans;
    }
}
```
