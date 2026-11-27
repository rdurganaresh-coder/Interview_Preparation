# 738. Monotone Increasing Digits

**Difficulty:** Medium  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/monotone-increasing-digits/

---

[中文文档](/solution/0700-0799/0738.Monotone%20Increasing%20Digits/README.md)

## Description

<p>An integer has <strong>monotone increasing digits</strong> if and only if each pair of adjacent digits <code>x</code> and <code>y</code> satisfy <code>x &lt;= y</code>.</p>

<p>Given an integer <code>n</code>, return <em>the largest number that is less than or equal to </em><code>n</code><em> with <strong>monotone increasing digits</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 10
<strong>Output:</strong> 9
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1234
<strong>Output:</strong> 1234
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 332
<strong>Output:</strong> 299
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Find the largest number $\le n$ whose digits are non-decreasing. Checking $n, n-1, \ldots$ is too slow; we should rewrite the digits.
>
> After the first descent, turning the tail into nines may still leave a prefix larger than $n$. Decrement the left run until the digits are non-decreasing again, then set the suffix to nines.
>
> Walk to the first drop, step back while decrementing, then fill nines. $O(\log n)$ digits.

#### Java

```java
class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int i = 1;
        for (; i < s.length && s[i - 1] <= s[i]; ++i)
            ;
        if (i < s.length) {
            for (; i > 0 && s[i - 1] > s[i]; --i) {
                --s[i - 1];
            }
            ++i;
            for (; i < s.length; ++i) {
                s[i] = '9';
            }
        }
        return Integer.parseInt(String.valueOf(s));
    }
}
```
