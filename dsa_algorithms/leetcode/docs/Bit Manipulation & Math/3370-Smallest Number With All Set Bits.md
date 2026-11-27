# 3370. Smallest Number With All Set Bits

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/smallest-number-with-all-set-bits/

---

[中文文档](/solution/3300-3399/3370.Smallest%20Number%20With%20All%20Set%20Bits/README.md)

## Description

<p>You are given a <em>positive</em> number <code>n</code>.</p>

<p>Return the <strong>smallest</strong> number <code>x</code> <strong>greater than</strong> or <strong>equal to</strong> <code>n</code>, such that the binary representation of <code>x</code> contains only <span data-keyword="set-bit">set bits</span></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 5</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>

<p><strong>Explanation:</strong></p>

<p>The binary representation of 7 is <code>&quot;111&quot;</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 10</span></p>

<p><strong>Output:</strong> <span class="example-io">15</span></p>

<p><strong>Explanation:</strong></p>

<p>The binary representation of 15 is <code>&quot;1111&quot;</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The binary representation of 3 is <code>&quot;11&quot;</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Bit Manipulation

> **Thinking**
>
> We want the smallest number of the form $2^p-1$ that is at least $n$. With $n \le 1000$ we shift until $2^p>n$.
>
> Start from $x=1$ and left-shift while $x-1<n$; then $x-1$ is all ones.

We start with $x = 1$ and continuously left shift $x$ until $x - 1 \geq n$. At this point, $x - 1$ is the answer we are looking for.

The time complexity is $O(\log n)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public int smallestNumber(int n) {
        int x = 1;
        while (x - 1 < n) {
            x <<= 1;
        }
        return x - 1;
    }
}
```
