# 2574. Left and Right Sum Differences

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/left-and-right-sum-differences/

---

[中文文档](/solution/2500-2599/2574.Left%20and%20Right%20Sum%20Differences/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> of size <code>n</code>.</p>

<p>Define two arrays <code>leftSum</code> and <code>rightSum</code> where:</p>

<ul>
	<li><code>leftSum[i]</code> is the sum of elements to the left of the index <code>i</code> in the array <code>nums</code>. If there is no such element, <code>leftSum[i] = 0</code>.</li>
	<li><code>rightSum[i]</code> is the sum of elements to the right of the index <code>i</code> in the array <code>nums</code>. If there is no such element, <code>rightSum[i] = 0</code>.</li>
</ul>

<p>Return an integer array <code>answer</code> of size <code>n</code> where <code>answer[i] = |leftSum[i] - rightSum[i]|</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [10,4,8,3]
<strong>Output:</strong> [15,1,11,22]
<strong>Explanation:</strong> The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1]
<strong>Output:</strong> [0]
<strong>Explanation:</strong> The array leftSum is [0] and the array rightSum is [0].
The array answer is [|0 - 0|] = [0].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Prefix Sum

> **Thinking**
>
> Each index wants the absolute difference of the left sum and the right sum. Two prefix arrays work, but one pass is enough: start with the total on the right, subtract $x$ before recording $|l-r|$, then add $x$ to the left.

We define a variable $l$ to represent the sum of elements to the left of index $i$ in the array $\textit{nums}$, and a variable $r$ to represent the sum of elements to the right of index $i$ in the array $\textit{nums}$. Initially, $l = 0$, $r = \sum_{i = 0}^{n - 1} \textit{nums}[i]$.

We traverse the array $\textit{nums}$. For the current number $x$, we update $r = r - x$. At this point, $l$ and $r$ represent the sum of elements to the left and right of index $i$ in the array $\textit{nums}$, respectively. We add the absolute difference of $l$ and $r$ to the answer array $\textit{ans}$, then update $l = l + x$.

After the traversal, we return the answer array $\textit{ans}$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

Similar problems:

- [0724. Find Pivot Index](https://github.com/doocs/leetcode/blob/main/solution/0700-0799/0724.Find%20Pivot%20Index/README_EN.md)
- [1991. Find the Middle Index in Array](https://github.com/doocs/leetcode/blob/main/solution/1900-1999/1991.Find%20the%20Middle%20Index%20in%20Array/README_EN.md)

#### Java

```java
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int l = 0, r = 0;
        for (int x : nums) {
            r += x;
        }
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            r -= nums[i];
            ans[i] = Math.abs(l - r);
            l += nums[i];
        }
        return ans;
    }
}
```
