# 190. Reverse Bits

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/reverse-bits/

---

[中文文档](/solution/0100-0199/0190.Reverse%20Bits/README.md)

## Description

<p>Reverse bits of a given 32 bits signed integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 43261596</span></p>

<p><strong>Output:</strong> <span class="example-io">964176192</span></p>

<p><strong>Explanation:</strong></p>

<table>
	<tbody>
		<tr>
			<th>Integer</th>
			<th>Binary</th>
		</tr>
		<tr>
			<td>43261596</td>
			<td>00000010100101000001111010011100</td>
		</tr>
		<tr>
			<td>964176192</td>
			<td>00111001011110000010100101000000</td>
		</tr>
	</tbody>
</table>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 2147483644</span></p>

<p><strong>Output:</strong> <span class="example-io">1073741822</span></p>

<p><strong>Explanation:</strong></p>

<table>
	<tbody>
		<tr>
			<th>Integer</th>
			<th>Binary</th>
		</tr>
		<tr>
			<td>2147483644</td>
			<td>01111111111111111111111111111100</td>
		</tr>
		<tr>
			<td>1073741822</td>
			<td>00111111111111111111111111111110</td>
		</tr>
	</tbody>
</table>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 2<sup>31</sup> - 2</code></li>
	<li><code>n</code> is even.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> If this function is called many times, how would you optimize it?</p>

## Solutions

### Solution 1: Bit Manipulation

> **Thinking**
>
> Reverse the $32$ bits of an unsigned integer. Pull each bit and write it to the mirrored index. Scan $32$ times from the low end: take $n$'s lowest bit, write it at position $31-i$, then shift $n$ right. The width is fixed.

We can extract each bit of $n$ from the lowest bit to the highest bit, and then place it at the corresponding position of $\textit{ans}$.

For example, for the $i$-th bit, we can extract the $i$-th bit of $n$ and place it at the $(31 - i)$-th bit of $\textit{ans}$ by $(n \& 1) \ll (31 - i)$, and then right shift $n$ by one bit.

The time complexity is $O(\log n)$, and the space complexity is $O(1)$.

#### Java

```java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            ans |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return ans;
    }
}
```
