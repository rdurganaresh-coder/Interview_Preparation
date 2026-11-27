# 1134. Armstrong Number

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/armstrong-number/

---

[中文文档](/solution/1100-1199/1134.Armstrong%20Number/README.md)

## Description

<p>Given an integer <code>n</code>, return <code>true</code> <em>if and only if it is an <strong>Armstrong number</strong></em>.</p>

<p>The <code>k</code>-digit number <code>n</code> is an Armstrong number if and only if the <code>k<sup>th</sup></code> power of each digit sums to <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 153
<strong>Output:</strong> true
<strong>Explanation:</strong> 153 is a 3-digit number, and 153 = 1<sup>3</sup> + 5<sup>3</sup> + 3<sup>3</sup>.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 123
<strong>Output:</strong> false
<strong>Explanation:</strong> 123 is a 3-digit number, and 123 != 1<sup>3</sup> + 2<sup>3</sup> + 3<sup>3</sup> = 36.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>8</sup></code></li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> An Armstrong number equals the sum of its digits each raised to $k$, the number of digits. Read $k$ from the decimal length, peel digits by modulo and integer division, and compare the power sum with $n$. The digit count is tiny, so a direct loop suffices.

We can first calculate the number of digits $k$, then calculate the sum $s$ of the $k$th power of each digit, and finally check whether $s$ equals $n$.

The time complexity is $O(\log n)$, and the space complexity is $O(\log n)$, where $n$ is the given number.

#### Java

```java
class Solution {
    public boolean isArmstrong(int n) {
        int k = (n + "").length();
        int s = 0;
        for (int x = n; x > 0; x /= 10) {
            s += Math.pow(x % 10, k);
        }
        return s == n;
    }
}
```
