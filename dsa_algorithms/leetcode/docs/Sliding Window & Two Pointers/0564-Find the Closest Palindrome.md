# 564. Find the Closest Palindrome

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/find-the-closest-palindrome/

---

[中文文档](/solution/0500-0599/0564.Find%20the%20Closest%20Palindrome/README.md)

## Description

<p>Given a string <code>n</code> representing an integer, return <em>the closest integer (not including itself), which is a palindrome</em>. If there is a tie, return <em><strong>the smaller one</strong></em>.</p>

<p>The closest is defined as the absolute difference minimized between two integers.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = &quot;123&quot;
<strong>Output:</strong> &quot;121&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = &quot;1&quot;
<strong>Output:</strong> &quot;0&quot;
<strong>Explanation:</strong> 0 and 2 are the closest palindromes but we return the smallest which is 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n.length &lt;= 18</code></li>
	<li><code>n</code> consists of only digits.</li>
	<li><code>n</code> does not have leading zeros.</li>
	<li><code>n</code> is representing an integer in the range <code>[1, 10<sup>18</sup> - 1]</code>.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Find the closest palindrome, not equal to $n$. Scanning nearby integers has no clear bound.
>
> The nearest palindromes come from mirroring the prefix and that prefix $\pm 1$, plus the length-change sentinels $99\ldots9$ and $100\ldots001$. Mirror each candidate, drop $n$ itself, and pick by distance then by value. Only a constant number of candidates exist.

#### Java

```java
import java.math.BigInteger;

class Solution {
    public String nearestPalindromic(String n) {
        BigInteger x = new BigInteger(n);
        int l = n.length();
        Set<BigInteger> res = new HashSet<>();
        res.add(BigInteger.TEN.pow(l - 1).subtract(BigInteger.ONE));
        res.add(BigInteger.TEN.pow(l).add(BigInteger.ONE));
        BigInteger left = new BigInteger(n.substring(0, (l + 1) / 2));
        for (int d = -1; d <= 1; ++d) {
            BigInteger i = left.add(BigInteger.valueOf(d));
            BigInteger j = l % 2 == 0 ? i : i.divide(BigInteger.TEN);
            while (j.signum() > 0) {
                i = i.multiply(BigInteger.TEN).add(j.mod(BigInteger.TEN));
                j = j.divide(BigInteger.TEN);
            }
            res.add(i);
        }
        res.remove(x);
        BigInteger ans = null;
        for (BigInteger t : res) {
            BigInteger dist = t.subtract(x).abs();
            if (ans == null || dist.compareTo(ans.subtract(x).abs()) < 0
                || (dist.compareTo(ans.subtract(x).abs()) == 0 && t.compareTo(ans) < 0)) {
                ans = t;
            }
        }
        return ans.toString();
    }
}
```
