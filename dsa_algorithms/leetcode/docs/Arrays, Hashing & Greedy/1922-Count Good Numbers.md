# 1922. Count Good Numbers

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-good-numbers/

---

[中文文档](/solution/1900-1999/1922.Count%20Good%20Numbers/README.md)

## Description

<p>A digit string is <strong>good</strong> if the digits <strong>(0-indexed)</strong> at <strong>even</strong> indices are <strong>even</strong> and the digits at <strong>odd</strong> indices are <strong>prime</strong> (<code>2</code>, <code>3</code>, <code>5</code>, or <code>7</code>).</p>

<ul>
	<li>For example, <code>&quot;2582&quot;</code> is good because the digits (<code>2</code> and <code>8</code>) at even positions are even and the digits (<code>5</code> and <code>2</code>) at odd positions are prime. However, <code>&quot;3245&quot;</code> is <strong>not</strong> good because <code>3</code> is at an even index but is not even.</li>
</ul>

<p>Given an integer <code>n</code>, return <em>the <strong>total</strong> number of good digit strings of length </em><code>n</code>. Since the answer may be large, <strong>return it modulo </strong><code>10<sup>9</sup> + 7</code>.</p>

<p>A <strong>digit string</strong> is a string consisting of digits <code>0</code> through <code>9</code> that may contain leading zeros.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 5
<strong>Explanation:</strong> The good numbers of length 1 are &quot;0&quot;, &quot;2&quot;, &quot;4&quot;, &quot;6&quot;, &quot;8&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 4
<strong>Output:</strong> 400
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 50
<strong>Output:</strong> 564908303
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>15</sup></code></li>
</ul>

## Solutions

### Solution 1: Fast Exponentiation

> **Thinking**
>
> Even indices have $5$ choices and odd indices have $4$, independently. Looping $n\le 10^{15}$ times is impossible.
>
> The count is $5^{\lceil n/2\rceil}\cdot 4^{\lfloor n/2\rfloor}$, evaluated with modular fast exponentiation in $O(\log n)$.

For a "good number" of length $n$, the even-indexed positions have $\lceil \frac{n}{2} \rceil = \lfloor \frac{n + 1}{2} \rfloor$ digits, and these positions can be filled with $5$ different digits ($0, 2, 4, 6, 8$). The odd-indexed positions have $\lfloor \frac{n}{2} \rfloor$ digits, and these positions can be filled with $4$ different digits ($2, 3, 5, 7$). Therefore, the total number of "good numbers" of length $n$ is:

$$
\textit{ans} = 5^{\lceil \frac{n}{2} \rceil} \times 4^{\lfloor \frac{n}{2} \rfloor}
$$

We can use fast exponentiation to compute $5^{\lceil \frac{n}{2} \rceil}$ and $4^{\lfloor \frac{n}{2} \rfloor}$. The time complexity is $O(\log n)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    private final int mod = (int) 1e9 + 7;

    public int countGoodNumbers(long n) {
        return (int) (qpow(5, (n + 1) >> 1) * qpow(4, n >> 1) % mod);
    }

    private long qpow(long x, long n) {
        long res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return res;
    }
}
```
