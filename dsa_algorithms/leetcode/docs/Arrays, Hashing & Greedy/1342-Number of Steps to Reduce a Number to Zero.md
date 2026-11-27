# 1342. Number of Steps to Reduce a Number to Zero

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

---

[中文文档](/solution/1300-1399/1342.Number%20of%20Steps%20to%20Reduce%20a%20Number%20to%20Zero/README.md)

## Description

<p>Given an integer <code>num</code>, return <em>the number of steps to reduce it to zero</em>.</p>

<p>In one step, if the current number is even, you have to divide it by <code>2</code>, otherwise, you have to subtract <code>1</code> from it.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 14
<strong>Output:</strong> 6
<strong>Explanation:</strong>&nbsp;
Step 1) 14 is even; divide by 2 and obtain 7.&nbsp;
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3.&nbsp;
Step 4) 3 is odd; subtract 1 and obtain 2.&nbsp;
Step 5) 2 is even; divide by 2 and obtain 1.&nbsp;
Step 6) 1 is odd; subtract 1 and obtain 0.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = 8
<strong>Output:</strong> 4
<strong>Explanation:</strong>&nbsp;
Step 1) 8 is even; divide by 2 and obtain 4.&nbsp;
Step 2) 4 is even; divide by 2 and obtain 2.&nbsp;
Step 3) 2 is even; divide by 2 and obtain 1.&nbsp;
Step 4) 1 is odd; subtract 1 and obtain 0.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> num = 123
<strong>Output:</strong> 12
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= num &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Halve an even number, decrement an odd one, and count steps to $0$. $\textit{num} \le 10^6$ is small enough to simulate: subtract one when the bit is set, otherwise shift right, until the value vanishes.

#### Java

```java
class Solution {

    public int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0) {
            num = (num & 1) == 1 ? num - 1 : num >> 1;
            ++ans;
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> The same rule is a recursion: even goes to $n/2$, odd to $n-1$, each call adding one, stopping at $0$. The meaning matches the loop; only the call stack changes.

#### Java

```java
class Solution {

    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + numberOfSteps((num & 1) == 0 ? num >> 1 : num - 1);
    }
}
```
