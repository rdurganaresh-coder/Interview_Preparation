# 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers

**Difficulty:** Medium  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

---

[中文文档](/solution/1600-1699/1689.Partitioning%20Into%20Minimum%20Number%20Of%20Deci-Binary%20Numbers/README.md)

## Description

<p>A decimal number is called <strong>deci-binary</strong> if each of its digits is either <code>0</code> or <code>1</code> without any leading zeros. For example, <code>101</code> and <code>1100</code> are <strong>deci-binary</strong>, while <code>112</code> and <code>3001</code> are not.</p>

<p>Given a string <code>n</code> that represents a positive decimal integer, return <em>the <strong>minimum</strong> number of positive <strong>deci-binary</strong> numbers needed so that they sum up to </em><code>n</code><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = &quot;32&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> 10 + 11 + 11 = 32
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = &quot;82734&quot;
<strong>Output:</strong> 8
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = &quot;27346209830709182346&quot;
<strong>Output:</strong> 9
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n.length &lt;= 10<sup>5</sup></code></li>
	<li><code>n</code> consists of only digits.</li>
	<li><code>n</code> does not contain any leading zeros and represents a positive integer.</li>
</ul>

## Solutions

### Solution 1: Quick Thinking

> **Thinking**
>
> A deci-binary digit is only $0$ or $1$. Summing them to $n$ requires at least $d$ ones in a position whose digit is $d$. The answer is therefore the maximum digit of $n$.

The problem is equivalent to finding the maximum number in the string.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string.

#### Java

```java
class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for (int i = 0; i < n.length(); ++i) {
            ans = Math.max(ans, n.charAt(i) - '0');
        }
        return ans;
    }
}
```
