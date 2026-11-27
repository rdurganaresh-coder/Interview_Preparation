# 42. Trapping Rain Water

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/trapping-rain-water/

---

[中文文档](/solution/0000-0099/0042.Trapping%20Rain%20Water/README.md)

## Description

<p>Given <code>n</code> non-negative integers representing an elevation map where the width of each bar is <code>1</code>, compute how much water it can trap after raining.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0042.Trapping%20Rain%20Water/images/rainwatertrap.png" style="width: 412px; height: 161px;" />
<pre>
<strong>Input:</strong> height = [0,1,0,2,1,0,1,3,2,1,2,1]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> height = [4,2,0,3,2,5]
<strong>Output:</strong> 9
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> The first idea is, for each $i$, scan left and right for the tallest bars; water is $\min(\textit{leftMax}, \textit{rightMax}) - \textit{height}[i]$. Correct, but $O(n^2)$. $n \le 2 \times 10^4$ can time out.
>
> The bottleneck is recomputing left/right maxima at every $i$. Those maxima only depend on one side and can be precomputed in linear time.
>
> Store, at each index, the highest bar to the left (inclusive) and to the right (inclusive), then sum. The water level is the shorter of the two walls — that is the DP state.

We define $\textit{left}[i]$ as the height of the highest bar to the left of and including the position at index $i$, and $\textit{right}[i]$ as the height of the highest bar to the right of and including the position at index $i$. Therefore, the amount of rainwater that can be trapped at index $i$ is $\min(\textit{left}[i], \textit{right}[i]) - \textit{height}[i]$. We traverse the array to calculate $\textit{left}[i]$ and $\textit{right}[i]$, and the final answer is $\sum_{i=0}^{n-1} \min(\textit{left}[i], \textit{right}[i]) - \textit{height}[i]$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1; i < n; ++i) {
            left[i] = Math.max(left[i - 1], height[i]);
            right[n - i - 1] = Math.max(right[n - i], height[n - i - 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }
}
```
