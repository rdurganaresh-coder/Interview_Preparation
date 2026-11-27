# 405. Convert a Number to Hexadecimal

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/convert-a-number-to-hexadecimal/

---

[中文文档](/solution/0400-0499/0405.Convert%20a%20Number%20to%20Hexadecimal/README.md)

## Description

<p>Given a 32-bit integer <code>num</code>, return <em>a string representing its hexadecimal representation</em>. For negative integers, <a href="https://en.wikipedia.org/wiki/Two%27s_complement" target="_blank">two&rsquo;s complement</a> method is used.</p>

<p>All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.</p>

<p><strong>Note:&nbsp;</strong>You are not allowed to use any built-in library method to directly solve this problem.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> num = 26
<strong>Output:</strong> "1a"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> num = -1
<strong>Output:</strong> "ffffffff"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= num &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A $32$-bit two's-complement integer must be printed in hex, including negatives. Digit-by-digit decimal conversion fights the sign; grouping $4$ bits does not.
>
> Eight groups from high to low, each masked with `0xF`, map through a digit table. Skip leading zeros until a nonzero nibble appears; treat $0$ as a special case.
>
> Scanning from the high end lets us drop leading zeros without reversing a buffer.

#### Java

```java
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int x = num & 15;
            if (x < 10) {
                sb.append(x);
            } else {
                sb.append((char) (x - 10 + 'a'));
            }
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 already walks $4$-bit groups. Solution 2 builds the same digits with arithmetic instead of a lookup table.

#### Java

```java
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; --i) {
            int x = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || x != 0) {
                char c = x < 10 ? (char) (x + '0') : (char) (x - 10 + 'a');
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```
