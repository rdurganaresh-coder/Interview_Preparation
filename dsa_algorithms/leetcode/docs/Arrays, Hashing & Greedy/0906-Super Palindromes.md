# 906. Super Palindromes

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/super-palindromes/

---

[中文文档](/solution/0900-0999/0906.Super%20Palindromes/README.md)

## Description

<p>Let&#39;s say a positive integer is a <strong>super-palindrome</strong> if it is a palindrome, and it is also the square of a palindrome.</p>

<p>Given two positive integers <code>left</code> and <code>right</code> represented as strings, return <em>the number of <strong>super-palindromes</strong> integers in the inclusive range</em> <code>[left, right]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> left = &quot;4&quot;, right = &quot;1000&quot;
<strong>Output:</strong> 4
<strong>Explanation</strong>: 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> left = &quot;1&quot;, right = &quot;2&quot;
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= left.length, right.length &lt;= 18</code></li>
	<li><code>left</code> and <code>right</code> consist of only digits.</li>
	<li><code>left</code> and <code>right</code> cannot have leading zeros.</li>
	<li><code>left</code> and <code>right</code> represent integers in the range <code>[1, 10<sup>18</sup> - 1]</code>.</li>
	<li><code>left</code> is less than or equal to <code>right</code>.</li>
</ul>

## Solutions

### Solution 1: Preprocessing + Enumeration

> **Thinking**
>
> A super-palindrome is $x=p^2$ inside $[L,R]\subseteq[1,10^{18})$. Testing every square in that range is impossible. $p$ itself must be a palindrome below $10^9$, so its first half has size at most about $10^5$.
>
> Precompute every palindrome obtained by mirroring a prefix (with or without a middle digit), then keep those $p^2$ that lie in $[L,R]$ and are palindromes.

According to the problem description, we assume that the super palindrome number $x = p^2 \in [1, 10^{18})$, where $p$ is a palindrome number, so $p \in [1, 10^9)$. We can enumerate the first half of the palindrome number $p$, then reverse it, and concatenate it to get all palindrome numbers, which are recorded in the array $ps$.

Next, we traverse the array $ps$. For each $p$, we calculate $p^2$, check whether it is in the interval $[L, R]$, and also check whether $p^2$ is a palindrome number. If it is, the answer is incremented by one.

After the traversal, return the answer.

The time complexity is $O(M^{\frac{1}{4}} \log M)$, and the space complexity is $O(M^{\frac{1}{4}})$, where $M$ is the upper bound of $L$ and $R$, and in this problem, $M \leq 10^{18}$.

Similar problems:

- [2967. Minimum Cost to Make Array Equalindromic](https://github.com/doocs/leetcode/blob/main/solution/2900-2999/2967.Minimum%20Cost%20to%20Make%20Array%20Equalindromic/README_EN.md)

#### Java

```java
class Solution {
    private static long[] ps;

    static {
        ps = new long[2 * (int) 1e5];
        for (int i = 1; i <= 1e5; i++) {
            String s = Integer.toString(i);
            String t1 = new StringBuilder(s).reverse().toString();
            String t2 = new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();
            ps[2 * i - 2] = Long.parseLong(s + t1);
            ps[2 * i - 1] = Long.parseLong(s + t2);
        }
    }

    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int ans = 0;
        for (long p : ps) {
            long x = p * p;
            if (x >= l && x <= r && isPalindrome(x)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean isPalindrome(long x) {
        long y = 0;
        for (long t = x; t > 0; t /= 10) {
            y = y * 10 + t % 10;
        }
        return x == y;
    }
}
```
