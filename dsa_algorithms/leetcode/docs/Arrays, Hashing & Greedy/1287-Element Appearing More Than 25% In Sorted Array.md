# 1287. Element Appearing More Than 25% In Sorted Array

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

---

[中文文档](/solution/1200-1299/1287.Element%20Appearing%20More%20Than%2025%25%20In%20Sorted%20Array/README.md)

## Description

<p>Given an integer array <strong>sorted</strong> in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2,2,6,6,6,6,7,10]
<strong>Output:</strong> 6
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Traversal

> **Thinking**
>
> In a sorted array some value occurs more than $25\%$, i.e. spans at least $\lfloor n/4 \rfloor$. If $\textit{arr}[i]=\textit{arr}[i+\lfloor n/4 \rfloor]$, that value already covers enough length. The first hit from the left is the answer; sorted order turns counting into an index comparison.

We traverse the array $\textit{arr}$ from the beginning. For each element $\textit{arr}[i]$, we check if $\textit{arr}[i]$ is equal to $\textit{arr}[i + \left\lfloor \frac{n}{4} \right\rfloor]$, where $n$ is the length of the array. If they are equal, then $\textit{arr}[i]$ is the element we are looking for, and we return it directly.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{arr}$.

#### Java

```java
class Solution {
    public int findSpecialInteger(int[] arr) {
        for (int i = 0;; ++i) {
            if (arr[i] == (arr[i + (arr.length >> 2)])) {
                return arr[i];
            }
        }
    }
}
```
