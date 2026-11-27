# 2520. Count the Digits That Divide a Number

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/count-the-digits-that-divide-a-number/

---

[中文文档](/solution/2500-2599/2520.Count%20the%20Digits%20That%20Divide%20a%20Number/README.md)

## Description

<p>Given an integer <code>num</code>, return <em>the number of digits in <code>num</code> that divide </em><code>num</code>.</p>

<p>An integer <code>val</code> divides <code>nums</code> if <code>nums % val == 0</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 7
<strong>Output:</strong> 1
<strong>Explanation:</strong> 7 divides itself, hence the answer is 1.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = 121
<strong>Output:</strong> 2
<strong>Explanation:</strong> 121 is divisible by 1, but not 2. Since 1 occurs twice as a digit, we return 2.
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> num = 1248
<strong>Output:</strong> 4
<strong>Explanation:</strong> 1248 is divisible by all of its digits, hence the answer is 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 10<sup>9</sup></code></li>
	<li><code>num</code> does not contain <code>0</code> as one of its digits.</li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> Count how many digits of $\textit{num}$ divide $\textit{num}$. There are at most ten digits, so enumerating them is enough.
>
> Repeatedly take $\textit{val} = \textit{num} \bmod 10$ and test $\textit{num} \bmod \textit{val} = 0$. The input contains no zero, so division by zero does not arise.

We directly enumerate each digit $\textit{val}$ of the integer $\textit{num}$, and if $\textit{val}$ can divide $\textit{num}$, we add one to the answer.

After the enumeration, we return the answer.

The time complexity is $O(\log \textit{num})$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public int countDigits(int num) {
        int ans = 0;
        for (int x = num; x > 0; x /= 10) {
            if (num % (x % 10) == 0) {
                ++ans;
            }
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 extracts digits arithmetically. Converting $\textit{num}$ to a decimal string and testing each character yields the same check; only the way digits are obtained changes.
