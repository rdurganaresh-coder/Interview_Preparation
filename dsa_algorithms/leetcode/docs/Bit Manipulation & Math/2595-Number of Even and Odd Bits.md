# 2595. Number of Even and Odd Bits

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/number-of-even-and-odd-bits/

---

[中文文档](/solution/2500-2599/2595.Number%20of%20Even%20and%20Odd%20Bits/README.md)

## Description

<p>You are given a <strong>positive</strong> integer <code>n</code>.</p>

<p>Let <code>even</code> denote the number of even indices in the binary representation of <code>n</code> with value 1.</p>

<p>Let <code>odd</code> denote the number of odd indices in the binary representation of <code>n</code> with value 1.</p>

<p>Note that bits are indexed from <strong>right to left</strong> in the binary representation of a number.</p>

<p>Return the array <code>[even, odd]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 50</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2]</span></p>

<p><strong>Explanation:</strong></p>

<p>The binary representation of 50 is <code>110010</code>.</p>

<p>It contains 1 on indices 1, 4, and 5.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[0,1]</span></p>

<p><strong>Explanation:</strong></p>

<p>The binary representation of 2 is <code>10</code>.</p>

<p>It contains 1 only on index 1.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Enumerate

> **Thinking**
>
> $n$ is at most $10^3$, so walking bits from low to high is enough. Flip the index with $i\oplus 1$ and increment the matching counter when the bit is set.

According to the problem description, enumerate the binary representation of $n$ from the low bit to the high bit. If the bit is $1$, add $1$ to the corresponding counter according to whether the index of the bit is odd or even.

The time complexity is $O(\log n)$, and the space complexity is $O(1)$, where $n$ is the given integer.

#### Java

```java
class Solution {
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        for (int i = 0; n > 0; n >>= 1, i ^= 1) {
            ans[i] += n & 1;
        }
        return ans;
    }
}
```

### Solution 2: Bit Manipulation

> **Thinking**
>
> Solution 1 is linear in the bit length. Even indices are exactly the mask `0x5555`; $\textit{bit\_count}(n\&\textit{mask})$ is the even tally, and the complement mask yields the odd tally in constant time.

We can define a mask $\textit{mask} = \texttt{0x5555}$, which is represented in binary as $\text{0101 0101 0101 0101}_2$. Then, performing a bitwise AND operation between $n$ and $\textit{mask}$ will give us the bits at even indices in the binary representation of $n$. Performing a bitwise AND operation between $n$ and the complement of $\textit{mask}$ will give us the bits at odd indices in the binary representation of $n$. We can count the number of 1s in these two results.

The time complexity is $O(1)$, and the space complexity is $O(1)$, where $n$ is the given integer.

#### Java

```java
class Solution {
    public int[] evenOddBit(int n) {
        int mask = 0x5555;
        int even = Integer.bitCount(n & mask);
        int odd = Integer.bitCount(n & ~mask);
        return new int[] {even, odd};
    }
}
```
