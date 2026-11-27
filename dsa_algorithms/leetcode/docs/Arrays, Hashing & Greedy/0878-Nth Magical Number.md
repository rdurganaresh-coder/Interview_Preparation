# 878. Nth Magical Number

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/nth-magical-number/

---

[中文文档](/solution/0800-0899/0878.Nth%20Magical%20Number/README.md)

## Description

<p>A positive integer is <em>magical</em> if it is divisible by either <code>a</code> or <code>b</code>.</p>

<p>Given the three integers <code>n</code>, <code>a</code>, and <code>b</code>, return the <code>n<sup>th</sup></code> magical number. Since the answer may be very large, <strong>return it modulo </strong><code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1, a = 2, b = 3
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 4, a = 2, b = 3
<strong>Output:</strong> 6
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
	<li><code>2 &lt;= a, b &lt;= 4 * 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The $n$-th positive integer divisible by $a$ or $b$, with $n$ up to $10^9$. Listing multiples is too slow. The count of magical numbers $\le x$ is $x/a+x/b-x/\textit{lcm}(a,b)$, monotone in $x$.
>
> Binary-search the least $x$ whose count is $n$, then reduce modulo $10^9+7$. The bound $(a+b)\cdot n$ is sufficient.

#### Java

```java
class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int nthMagicalNumber(int n, int a, int b) {
        int c = a * b / gcd(a, b);
        long l = 0, r = (long) (a + b) * n;
        while (l < r) {
            long mid = l + r >>> 1;
            if (mid / a + mid / b - mid / c >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) (l % MOD);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```
