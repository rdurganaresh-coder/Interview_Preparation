# 3233. Find the Count of Numbers Which Are Not Special

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-the-count-of-numbers-which-are-not-special/

---

[中文文档](/solution/3200-3299/3233.Find%20the%20Count%20of%20Numbers%20Which%20Are%20Not%20Special/README.md)

## Description

<p>You are given 2 <strong>positive</strong> integers <code>l</code> and <code>r</code>. For any number <code>x</code>, all positive divisors of <code>x</code> <em>except</em> <code>x</code> are called the <strong>proper divisors</strong> of <code>x</code>.</p>

<p>A number is called <strong>special</strong> if it has exactly 2 <strong>proper divisors</strong>. For example:</p>

<ul>
	<li>The number 4 is <em>special</em> because it has proper divisors 1 and 2.</li>
	<li>The number 6 is <em>not special</em> because it has proper divisors 1, 2, and 3.</li>
</ul>

<p>Return the count of numbers in the range <code>[l, r]</code> that are <strong>not</strong> <strong>special</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">l = 5, r = 7</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>There are no special numbers in the range <code>[5, 7]</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">l = 4, r = 16</span></p>

<p><strong>Output:</strong> <span class="example-io">11</span></p>

<p><strong>Explanation:</strong></p>

<p>The special numbers in the range <code>[4, 16]</code> are 4 and 9.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= l &lt;= r &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Mathematics

> **Thinking**
>
> A special number has exactly three positive divisors, i.e. it is the square of a prime. $l,r\le 10^9$, so trial-dividing every integer in the range is impossible.
>
> Special numbers in $[l,r]$ correspond to primes in $[\lceil\sqrt{l}\rceil,\lfloor\sqrt{r}\rfloor]$. After a sieve up to $\sqrt{10^9}$, count those primes and subtract from the interval length.

According to the problem description, we can observe that only the squares of prime numbers are special numbers. Therefore, we can first preprocess all prime numbers less than or equal to $\sqrt{10^9}$, and then iterate through the interval $[\lceil\sqrt{l}\rceil, \lfloor\sqrt{r}\rfloor]$, counting the number of primes $\textit{cnt}$ in the interval. Finally, we return $r - l + 1 - \textit{cnt}$.

The time complexity is $O(\sqrt{m})$, and the space complexity is $O(\sqrt{m})$, where $m = 10^9$.

#### Java

```java
class Solution {
    static int m = 31623;
    static boolean[] primes = new boolean[m + 1];

    static {
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i <= m; i++) {
            if (primes[i]) {
                for (int j = i + i; j <= m; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    public int nonSpecialCount(int l, int r) {
        int lo = (int) Math.ceil(Math.sqrt(l));
        int hi = (int) Math.floor(Math.sqrt(r));
        int cnt = 0;
        for (int i = lo; i <= hi; i++) {
            if (primes[i]) {
                cnt++;
            }
        }
        return r - l + 1 - cnt;
    }
}
```
