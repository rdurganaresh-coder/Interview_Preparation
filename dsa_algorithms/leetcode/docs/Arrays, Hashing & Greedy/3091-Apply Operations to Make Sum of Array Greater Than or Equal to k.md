# 3091. Apply Operations to Make Sum of Array Greater Than or Equal to k

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/

---

[中文文档](/solution/3000-3099/3091.Apply%20Operations%20to%20Make%20Sum%20of%20Array%20Greater%20Than%20or%20Equal%20to%20k/README.md)

## Description

<p>You are given a <strong>positive</strong> integer <code>k</code>. Initially, you have an array <code>nums = [1]</code>.</p>

<p>You can perform <strong>any</strong> of the following operations on the array <strong>any</strong> number of times (<strong>possibly zero</strong>):</p>

<ul>
	<li>Choose any element in the array and <strong>increase</strong> its value by <code>1</code>.</li>
	<li>Duplicate any element in the array and add it to the end of the array.</li>
</ul>

<p>Return <em>the <strong>minimum</strong> number of operations required to make the <strong>sum</strong> of elements of the final array greater than or equal to </em><code>k</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">k = 11</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<p>We can do the following operations on the array <code>nums = [1]</code>:</p>

<ul>
	<li>Increase the element by <code>1</code> three times. The resulting array is <code>nums = [4]</code>.</li>
	<li>Duplicate the element two times. The resulting array is <code>nums = [4,4,4]</code>.</li>
</ul>

<p>The sum of the final array is <code>4 + 4 + 4 = 12</code> which is greater than or equal to <code>k = 11</code>.<br />
The total number of operations performed is <code>3 + 2 = 5</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>The sum of the original array is already greater than or equal to <code>1</code>, so no operations are needed.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> The array starts as $[1]$. We may increment an element or append a copy of one, aiming for a sum of at least $k \le 10^5$.
>
> Appending copies the current value, so we should increment one element to $x$ and then copy $x$. The cost is $(x-1)+(\lceil k/x \rceil-1)$.
>
> Enumerate the number of increments $a$ (so $x=a+1$), compute the matching number of copies, and minimize $a+b$.

We should put the copy operation (i.e., operation $2$) at the end to reduce the number of operations.

Therefore, we enumerate the number of times $a$ for operation $1$ in the range $[0, k]$, then the number of times $b$ for operation $2$ is $\left\lceil \frac{k}{a+1} \right\rceil - 1$. We take the minimum of $a+b$.

The time complexity is $O(k)$, and the space complexity is $O(1)$, where $k$ is the input positive integer $k$.

#### Java

```java
class Solution {
    public int minOperations(int k) {
        int ans = k;
        for (int a = 0; a < k; ++a) {
            int x = a + 1;
            int b = (k + x - 1) / x - 1;
            ans = Math.min(ans, a + b);
        }
        return ans;
    }
}
```
