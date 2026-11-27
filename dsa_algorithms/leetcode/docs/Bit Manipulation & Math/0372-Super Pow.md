# 372. Super Pow

**Difficulty:** Medium  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/super-pow/

---

[中文文档](/solution/0300-0399/0372.Super%20Pow/README.md)

## Description

<p>Your task is to calculate <code>a<sup>b</sup></code> mod <code>1337</code> where <code>a</code> is a positive integer and <code>b</code> is an extremely large positive integer given in the form of an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">a = 2, b = [3]</span></p>

<p><strong>Output:</strong> <span class="example-io">8</span></p>

<p><strong>Explanation:</strong></p>

<p>The array <code>b = [3]</code> represents the exponent 3. Therefore, <code>a<sup>3</sup> = 2<sup>3</sup> = 8</code>, so the result is 8.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">a = 2, b = [1,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">1024</span></p>

<p><strong>Explanation:</strong></p>

<p>The array <code>b = [1, 0]</code> represents the exponent 10. Therefore, <code>a<sup>10</sup> = 2<sup>10</sup> = 1024</code>, so the result is 1024.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">a = 1, b = [4,3,3,8,5,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The array <code>b = [4, 3, 3, 8, 5, 2]</code> represents a positive exponent. Since <code>a = 1</code>, any positive power of 1 is 1. Therefore, the result is 1.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= a &lt;= 2<sup>31</sup> - 1</code></li>
	<li><code>1 &lt;= b.length &lt;= 2000</code></li>
	<li><code>0 &lt;= b[i] &lt;= 9</code></li>
	<li><code>b</code> does not contain leading zeros.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> $a$ is raised to a huge decimal $b$ given as digits; return $a^b\bmod 1337$. Building $b$ as one integer is awkward. Write $b=\cdots+e_i\cdot 10^i$.
>
> From low digit to high: multiply by $a^{e}$, then replace the base with $a^{10}$. Modular fast pow keeps each step $O(\log e)$.

#### Java

```java
class Solution {
    private final int mod = 1337;

    public int superPow(int a, int[] b) {
        long ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = ans * qpow(a, b[i]) % mod;
            a = (int) qpow(a, 10);
        }
        return (int) ans;
    }

    private long qpow(long a, int n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return ans;
    }
}
```
