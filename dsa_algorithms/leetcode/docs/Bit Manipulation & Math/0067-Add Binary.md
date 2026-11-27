# 67. Add Binary

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/add-binary/

---

[中文文档](/solution/0000-0099/0067.Add%20Binary/README.md)

## Description

<p>Given two binary strings <code>a</code> and <code>b</code>, return <em>their sum as a binary string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> a = "11", b = "1"
<strong>Output:</strong> "100"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> a = "1010", b = "1011"
<strong>Output:</strong> "10101"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= a.length, b.length &lt;= 10<sup>4</sup></code></li>
	<li><code>a</code> and <code>b</code> consist&nbsp;only of <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code> characters.</li>
	<li>Each string does not contain leading zeros except for the zero itself.</li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> The first idea is to convert both binary strings to integers, add, and convert back. Lengths go up to $10^4$, which overflows ordinary integer types.
>
> The bottleneck is unequal lengths and a possible extra high carry. This is the same grade-school addition as in decimal: align from the low end and keep a $\textit{carry}$.
>
> Two pointers walk from the tails; a missing bit is $0$. The loop must continue while $\textit{carry}$ remains, or a final $1$ such as `"1"+"1"` would be dropped.

We use a variable $\textit{carry}$ to record the current carry, and two pointers $i$ and $j$ to point to the end of $a$ and $b$ respectively, and add them bit by bit from the end to the beginning.

The time complexity is $O(\max(m, n))$, and the space complexity is $O(1)$, where $m$ and $n$ are the lengths of strings $a$ and $b$ respectively.

#### Java

```java
class Solution {
    public String addBinary(String a, String b) {
        var sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        for (int carry = 0; i >= 0 || j >= 0 || carry > 0; --i, --j) {
            carry += (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0);
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
```
