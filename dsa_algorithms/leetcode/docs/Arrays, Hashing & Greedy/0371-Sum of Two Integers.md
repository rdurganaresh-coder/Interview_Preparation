# 371. Sum of Two Integers

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/sum-of-two-integers/

---

[中文文档](/solution/0300-0399/0371.Sum%20of%20Two%20Integers/README.md)

## Description

<p>Given two integers <code>a</code> and <code>b</code>, return <em>the sum of the two integers without using the operators</em> <code>+</code> <em>and</em> <code>-</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> a = 1, b = 2
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> a = 2, b = 3
<strong>Output:</strong> 5
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-1000 &lt;= a, b &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Add without `+`/`-`. Bitwise: the sum without carry is XOR, the carry is AND shifted left. Repeat until the carry vanishes.
>
> Python ints are unbounded, so mask with `0xFFFFFFFF` to $32$ bits. If the sign bit is set, convert two’s complement back to a negative.

#### Java

```java
class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
```
