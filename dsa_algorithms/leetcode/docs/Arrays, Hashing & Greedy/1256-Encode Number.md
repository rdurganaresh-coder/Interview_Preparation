# 1256. Encode Number

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/encode-number/

---

[中文文档](/solution/1200-1299/1256.Encode%20Number/README.md)

## Description

<p>Given a non-negative integer <code>num</code>, Return its <em>encoding</em> string.</p>

<p>The encoding is done by converting the integer to a string using a secret function that you should deduce from the following table:</p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1200-1299/1256.Encode%20Number/images/encode_number.png" style="width: 164px; height: 360px;" /></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 23
<strong>Output:</strong> &quot;1000&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = 107
<strong>Output:</strong> &quot;101100&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= num &lt;= 10^9</code></li>
</ul>

## Solutions

### Solution 1: Bit Manipulation

> **Thinking**
>
> The table is $0,1,00,01,\ldots$, i.e. all binary strings in order. The bits of $\textit{num}+1$ without the leading $1$ are exactly the $\textit{num}$-th such string. $\textit{num}$ reaches $10^9$, so we cannot list them; one bit trick suffices.

We add one to $\textit{num}$, then convert it to a binary string and remove the highest bit $1$.

The time complexity is $O(\log n)$, and the space complexity is $O(\log n)$, where $n$ is the size of $\textit{num}$.

#### Java

```java
class Solution {
    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
```
