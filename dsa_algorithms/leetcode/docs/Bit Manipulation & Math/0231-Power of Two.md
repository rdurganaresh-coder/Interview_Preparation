# 231. Power of Two

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/power-of-two/

---

[中文文档](/solution/0200-0299/0231.Power%20of%20Two/README.md)

## Description

<p>Given an integer <code>n</code>, return <em><code>true</code> if it is a power of two. Otherwise, return <code>false</code></em>.</p>

<p>An integer <code>n</code> is a power of two, if there exists an integer <code>x</code> such that <code>n == 2<sup>x</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> true
<strong>Explanation: </strong>2<sup>0</sup> = 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 16
<strong>Output:</strong> true
<strong>Explanation: </strong>2<sup>4</sup> = 16
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you solve it without loops/recursion?

## Solutions

### Solution 1: Bit Manipulation

> **Thinking**
>
> Repeated division by $2$ works, but one bit test is enough. A power of two has a single $1$ bit, i.e. $n>0$ and $n\mathrel{\&}(n-1)=0$.

According to the properties of bit manipulation, executing $\texttt{n\&(n-1)}$ can eliminate the last bit $1$ in the binary form of $n$. Therefore, if $n > 0$ and $\texttt{n\&(n-1)}$ results in $0$, then $n$ is a power of $2$.

The time complexity is $O(1)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
```

### Solution 2: Lowbit

> **Thinking**
>
> Clearing the lowest set bit is equivalent to taking $\textit{lowbit}$. If $n>0$ and $n=n\mathrel{\&}(-n)$, that single bit is the whole number.

According to the definition of $\textit{lowbit}$, we know that $\textit{lowbit}(x) = x \& (-x)$, which can get the decimal number represented by the last bit $1$ of $n$. Therefore, if $n > 0$ and $\textit{lowbit}(n)$ equals $n$, then $n$ is a power of $2$.

The time complexity is $O(1)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && n == (n & (-n));
    }
}
```
