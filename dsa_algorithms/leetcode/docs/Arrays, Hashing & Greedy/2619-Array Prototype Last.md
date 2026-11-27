# 2619. Array Prototype Last

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/array-prototype-last/

---

[中文文档](/solution/2600-2699/2619.Array%20Prototype%20Last/README.md)

## Description

<p>Write code that enhances all arrays such that you can call the&nbsp;<code>array.last()</code>&nbsp;method on any array and it will return the last element. If there are no elements in the array, it should return&nbsp;<code>-1</code>.</p>

<p>You may assume the array is the output of&nbsp;<code>JSON.parse</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [null, {}, 3]
<strong>Output:</strong> 3
<strong>Explanation:</strong> Calling nums.last() should return the last element: 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = []
<strong>Output:</strong> -1
<strong>Explanation:</strong> Because there are no elements, return -1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>arr</code> is a valid JSON array</li>
	<li><code>0 &lt;= arr.length &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Arrays need a last-element accessor; the empty case returns $-1$. Copying and popping is wasteful and mutates.
>
> The last index is $n-1$, so `at(-1)` reads it; the empty array uses the sentinel.
>
> Attaching the method to `Array.prototype` makes it available on every instance.
