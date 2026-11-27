# 84. Largest Rectangle in Histogram

**Difficulty:** Hard  
**Category:** Stacks & Queues  
**LeetCode:** https://leetcode.com/problems/largest-rectangle-in-histogram/

---

[中文文档](/solution/0000-0099/0084.Largest%20Rectangle%20in%20Histogram/README.md)

## Description

<p>Given an array of integers <code>heights</code> representing the histogram&#39;s bar height where the width of each bar is <code>1</code>, return <em>the area of the largest rectangle in the histogram</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0084.Largest%20Rectangle%20in%20Histogram/images/histogram.jpg" style="width: 522px; height: 242px;" />
<pre>
<strong>Input:</strong> heights = [2,1,5,6,2,3]
<strong>Output:</strong> 10
<strong>Explanation:</strong> The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0084.Largest%20Rectangle%20in%20Histogram/images/histogram-1.jpg" style="width: 202px; height: 362px;" />
<pre>
<strong>Input:</strong> heights = [2,4]
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= heights.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= heights[i] &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Monotonic Stack

> **Thinking**
>
> The first idea is enumerate every interval $[l, r]$, take the min height, area $(r - l + 1) \times \min$. Correct, but $O(n^2)$. $n \le 10^5$ will time out.
>
> The bottleneck is recomputing the min over every range. Flip the enumeration: let bar $i$ be the shortest bar of the rectangle; the width is the span to the nearest strictly shorter bars on both sides.
>
> “Nearest smaller on left/right” is the monotonic-stack model. Indices in the stack have increasing heights; a shorter bar pops others and becomes their right bound, while the new top is the left bound. Each bar enters and leaves once, so one linear pass.

We can enumerate the height $h$ of each bar as the height of the rectangle. Using a monotonic stack, we find the index $\textit{left}_i$, $\textit{right}_i$ of the first bar with a height less than $h$ to the left and right. The area of the rectangle at this time is $h \times (\textit{right}_i-\textit{left}_i-1)$. We can find the maximum value.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ represents the length of $\textit{heights}$.

Common model of monotonic stack: Find the **nearest** number to the left/right of each number that is **larger/smaller** than it. Template:

```python
stk = []
for i in range(n):
    while stk and check(stk[-1], i):
        stk.pop()
    stk.append(i)
```

#### Java

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0, n = heights.length;
        Deque<Integer> stk = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                right[stk.pop()] = i;
            }
            left[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        for (int i = 0; i < n; ++i) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}
```
