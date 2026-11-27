# 852. Peak Index in a Mountain Array

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/peak-index-in-a-mountain-array/

---

[中文文档](/solution/0800-0899/0852.Peak%20Index%20in%20a%20Mountain%20Array/README.md)

## Description

<p>You are given an integer <strong>mountain</strong> array <code>arr</code> of length <code>n</code> where the values increase to a <strong>peak element</strong> and then decrease.</p>

<p>Return the index of the peak element.</p>

<p>Your task is to solve it in <code>O(log(n))</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [0,1,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [0,2,1,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [0,10,5,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>arr</code> is <strong>guaranteed</strong> to be a mountain array.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The array rises strictly then falls strictly; we need the peak index. A linear scan works, but $n\le 10^5$ and the peak test is monotone: left of the peak $\textit{arr}[i]<\textit{arr}[i+1]$, right of it the opposite.
>
> Binary search $[1,n-2]$: if $\textit{arr}[\textit{mid}]>\textit{arr}[\textit{mid}+1]$ the peak is in the left half (including $\textit{mid}$), otherwise in the right. The left endpoint is the peak.

#### Java

```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
```
