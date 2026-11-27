# 1362. Closest Divisors

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/closest-divisors/

---

[中文文档](/solution/1300-1399/1362.Closest%20Divisors/README.md)

## Description

<p>Given an integer <code>num</code>, find the closest two integers in absolute difference whose product equals&nbsp;<code>num + 1</code>&nbsp;or <code>num + 2</code>.</p>

<p>Return the two integers in any order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 8
<strong>Output:</strong> [3,3]
<strong>Explanation:</strong> For num + 1 = 9, the closest divisors are 3 &amp; 3, for num + 2 = 10, the closest divisors are 2 &amp; 5, hence 3 &amp; 3 is chosen.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = 123
<strong>Output:</strong> [5,25]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> num = 999
<strong>Output:</strong> [40,25]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 10^9</code></li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> Find a factor pair of $\textit{num}+1$ or $\textit{num}+2$ with the smallest gap. $\textit{num} \le 10^9$ forbids scanning up to $x$. The closest pair sits near $\sqrt{x}$, so we walk downward from $\lfloor\sqrt{x}\rfloor$ until a divisor appears. Do this for both $\textit{num}+1$ and $\textit{num}+2$ and keep the tighter pair.

We design a function $f(x)$ that returns two numbers whose product equals $x$ and the absolute difference between these two numbers is the smallest. We can start enumerating $i$ from $\sqrt{x}$. If $x$ can be divided by $i$, then $\frac{x}{i}$ is another factor. At this point, we have found two factors whose product equals $x$. We can return them directly. Otherwise, we decrease the value of $i$ and continue to enumerate.

Next, we only need to calculate $f(\textit{num} + 1)$ and $f(\textit{num} + 2)$ respectively, and then compare the return values of the two functions. We return the one with the smaller absolute difference.

The time complexity is $O(\sqrt{\textit{num}})$, and the space complexity is $O(1)$, where $\textit{num}$ is the given integer.

#### Java

```java
class Solution {
    public int[] closestDivisors(int num) {
        int[] a = f(num + 1);
        int[] b = f(num + 2);
        return Math.abs(a[0] - a[1]) < Math.abs(b[0] - b[1]) ? a : b;
    }

    private int[] f(int x) {
        for (int i = (int) Math.sqrt(x);; --i) {
            if (x % i == 0) {
                return new int[] {i, x / i};
            }
        }
    }
}
```
