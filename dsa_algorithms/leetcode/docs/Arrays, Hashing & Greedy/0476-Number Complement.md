# 476. Number Complement

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/number-complement/

---

[中文文档](/solution/0400-0499/0476.Number%20Complement/README.md)

## Description

<p>The <strong>complement</strong> of an integer is the integer you get when you flip all the <code>0</code>&#39;s to <code>1</code>&#39;s and all the <code>1</code>&#39;s to <code>0</code>&#39;s in its binary representation.</p>

<ul>
	<li>For example, The integer <code>5</code> is <code>&quot;101&quot;</code> in binary and its <strong>complement</strong> is <code>&quot;010&quot;</code> which is the integer <code>2</code>.</li>
</ul>

<p>Given an integer <code>num</code>, return <em>its complement</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 5
<strong>Output:</strong> 2
<strong>Explanation:</strong> The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num &lt; 2<sup>31</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as 1009: <a href="https://leetcode.com/problems/complement-of-base-10-integer/" target="_blank">https://leetcode.com/problems/complement-of-base-10-integer/</a></p>

## Solutions

### Solution 1: Bit Manipulation

> **Thinking**
>
> The complement flips bits inside the binary representation without leading zeros. A raw bitwise not would turn those high zeros into ones.
>
> XOR with the mask $2^{\textit{bit\_length}}-1$ flips only the significant bits.
>
> The mask is exactly as wide as the highest $1$, so leading zeros never appear.

According to the problem description, we can use XOR operation to implement the flipping operation, the steps are as follows:

First, we find the highest bit of $1$ in the binary representation of $\textit{num}$, and the position is denoted as $k$.

Then, we construct a binary number, where the $k$-th bit is $0$ and the rest of the lower bits are $1$, which is $2^k - 1$;

Finally, we perform XOR operation on $\textit{num}$ and the constructed binary number to get the answer.

The time complexity is $O(\log \textit{num})$, and the space complexity is $O(1)$, where $\textit{num}$ is the input integer.

#### Java

```java
class Solution {
    public int findComplement(int num) {
        return num ^ ((1 << (32 - Integer.numberOfLeadingZeros(num))) - 1);
    }
}
```

### Solution 2: Bit Manipulation. Inversion + AND

> **Thinking**
>
> Solution 1 uses XOR. Bitwise not followed by AND with the same low-ones mask keeps the same width. Different surface syntax, same meaning.
