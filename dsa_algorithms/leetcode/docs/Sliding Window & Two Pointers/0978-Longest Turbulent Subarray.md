# 978. Longest Turbulent Subarray

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/longest-turbulent-subarray/

---

[中文文档](/solution/0900-0999/0978.Longest%20Turbulent%20Subarray/README.md)

## Description

<p>Given an integer array <code>arr</code>, return <em>the length of a maximum size turbulent subarray of</em> <code>arr</code>.</p>

<p>A subarray is <strong>turbulent</strong> if the comparison sign flips between each adjacent pair of elements in the subarray.</p>

<p>More formally, a subarray <code>[arr[i], arr[i + 1], ..., arr[j]]</code> of <code>arr</code> is said to be turbulent if and only if:</p>

<ul>
	<li>For <code>i &lt;= k &lt; j</code>:
    <ul>
    	<li><code>arr[k] &gt; arr[k + 1]</code> when <code>k</code> is odd, and</li>
    	<li><code>arr[k] &lt; arr[k + 1]</code> when <code>k</code> is even.</li>
    </ul>
    </li>
    <li>Or, for <code>i &lt;= k &lt; j</code>:
    <ul>
    	<li><code>arr[k] &gt; arr[k + 1]</code> when <code>k</code> is even, and</li>
    	<li><code>arr[k] &lt; arr[k + 1]</code> when <code>k</code> is odd.</li>
    </ul>
    </li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [9,4,2,10,7,8,8,1,9]
<strong>Output:</strong> 5
<strong>Explanation:</strong> arr[1] &gt; arr[2] &lt; arr[3] &gt; arr[4] &lt; arr[5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [4,8,12,16]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [100]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 4 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> A turbulent subarray alternates strict comparisons. Checking every subarray is quadratic. Ending at $i$, we only need the longest rise-ending and fall-ending lengths, each extending the opposite state of $i-1$, or resetting to $1$ on a tie. Two rolling variables suffice.

We define $f[i]$ as the length of the longest turbulent subarray ending at $\textit{nums}[i]$ with an increasing state, and $g[i]$ as the length of the longest turbulent subarray ending at $\textit{nums}[i]$ with a decreasing state. Initially, $f[0] = 1$, $g[0] = 1$. The answer is $\max(f[i], g[i])$.

For $i \gt 0$, if $\textit{nums}[i] \gt \textit{nums}[i - 1]$, then $f[i] = g[i - 1] + 1$, otherwise $f[i] = 1$; if $\textit{nums}[i] \lt \textit{nums}[i - 1]$, then $g[i] = f[i - 1] + 1$, otherwise $g[i] = 1$.

Since $f[i]$ and $g[i]$ are only related to $f[i - 1]$ and $g[i - 1]$, two variables can be used instead of arrays.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1, f = 1, g = 1;
        for (int i = 1; i < arr.length; ++i) {
            int ff = arr[i - 1] < arr[i] ? g + 1 : 1;
            int gg = arr[i - 1] > arr[i] ? f + 1 : 1;
            f = ff;
            g = gg;
            ans = Math.max(ans, Math.max(f, g));
        }
        return ans;
    }
}
```
