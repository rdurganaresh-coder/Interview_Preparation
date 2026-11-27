# 2443. Sum of Number and Its Reverse

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/sum-of-number-and-its-reverse/

---

[中文文档](/solution/2400-2499/2443.Sum%20of%20Number%20and%20Its%20Reverse/README.md)

## Description

<p>Given a <strong>non-negative</strong> integer <code>num</code>, return <code>true</code><em> if </em><code>num</code><em> can be expressed as the sum of any <strong>non-negative</strong> integer and its reverse, or </em><code>false</code><em> otherwise.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">num = 443</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>172 + 271 = 443, where 271 is the reverse of 172. Therefore, we return true.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">num = 63</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>63 cannot be expressed as the sum of a non-negative integer and its reverse. Therefore, we return false.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">num = 181</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>140 + 041 = 181, where 041 represents 41, the reverse of 140. Reversed numbers may contain leading zeros. Therefore, we return true.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= num &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Brute Force Enumeration

> **Thinking**
>
> With $\textit{num}\le 10^5$, try every $k\in[0,\textit{num}]$ and test $k+\textit{reverse}(k)=\textit{num}$. The range is small enough; reverse via the decimal string.

Enumerate $k$ in the range $[0,.., \textit{num}]$, and check whether $k + \textit{reverse}(k)$ equals $\textit{num}$.

The time complexity is $O(n \log n)$, where $n$ is the size of $\textit{num}$.

#### Java

```java
class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int x = 0; x <= num; ++x) {
            int k = x;
            int y = 0;
            while (k > 0) {
                y = y * 10 + k % 10;
                k /= 10;
            }
            if (x + y == num) {
                return true;
            }
        }
        return false;
    }
}
```
