# 479. Largest Palindrome Product

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/largest-palindrome-product/

---

[中文文档](/solution/0400-0499/0479.Largest%20Palindrome%20Product/README.md)

## Description

<p>Given an integer n, return <em>the <strong>largest palindromic integer</strong> that can be represented as the product of two <code>n</code>-digits integers</em>. Since the answer can be very large, return it <strong>modulo</strong> <code>1337</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> 987
Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 9
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The largest palindrome that is a product of two $n$-digit integers, modulo $1337$. $n\le 8$, so listing every product is heavy.
>
> Enumerate the first half $a$ downward, mirror it to a palindrome $x$, and test for an $n$-digit factor $t$ (from $10^n-1$ down while $t^2\ge x$). The first hit is the maximum.
>
> Building palindromes first meets the largest candidates sooner than enumerating products. $n=1$ falls through to $9$.

#### Java

```java
class Solution {
    public int largestPalindrome(int n) {
        int mx = (int) Math.pow(10, n) - 1;
        for (int a = mx; a > mx / 10; --a) {
            int b = a;
            long x = a;
            while (b != 0) {
                x = x * 10 + b % 10;
                b /= 10;
            }
            for (long t = mx; t * t >= x; --t) {
                if (x % t == 0) {
                    return (int) (x % 1337);
                }
            }
        }
        return 9;
    }
}
```
