# 227. Basic Calculator II

**Difficulty:** Medium  
**Category:** Stacks & Queues  
**LeetCode:** https://leetcode.com/problems/basic-calculator-ii/

---

[中文文档](/solution/0200-0299/0227.Basic%20Calculator%20II/README.md)

## Description

<p>Given a string <code>s</code> which represents an expression, <em>evaluate this expression and return its value</em>.&nbsp;</p>

<p>The integer division should truncate toward zero.</p>

<p>You may assume that the given expression is always valid. All intermediate results will be in the range of <code>[-2<sup>31</sup>, 2<sup>31</sup> - 1]</code>.</p>

<p><strong>Note:</strong> You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as <code>eval()</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "3+2*2"
<strong>Output:</strong> 7
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = " 3/2 "
<strong>Output:</strong> 1
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> s = " 3+5 / 2 "
<strong>Output:</strong> 5
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists of integers and operators <code>(&#39;+&#39;, &#39;-&#39;, &#39;*&#39;, &#39;/&#39;)</code> separated by some number of spaces.</li>
	<li><code>s</code> represents a valid expression.</li>
	<li>All the integers in the expression are non-negative integers in the range <code>[0, 2<sup>31</sup> - 1]</code>.</li>
	<li>The answer is <strong>guaranteed</strong> to fit in a <strong>32-bit integer</strong>.</li>
</ul>

## Solutions

### Solution 1: Stack

> **Thinking**
>
> Multiplication and division bind tighter than addition, and there are no parentheses, so we cannot add every number immediately. Treat $+$ and $-$ as signed terms on a stack, and fold $*$ and $/$ into the top.
>
> $\textit{sign}$ remembers the previous operator; after a number is complete we push or update the top, then sum the stack.

We traverse the string $s$, and use a variable $\textit{sign}$ to record the operator before each number. For the first number, its previous operator is considered as a plus sign. Each time we traverse to the end of a number, we decide the calculation method based on $\textit{sign}$:

- Plus sign: push the number into the stack;
- Minus sign: push the opposite number into the stack;
- Multiplication and division signs: calculate the number with the top element of the stack, and replace the top element of the stack with the calculation result.

After the traversal ends, the sum of the elements in the stack is the answer.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int calculate(String s) {
        Deque<Integer> stk = new ArrayDeque<>();
        char sign = '+';
        int v = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                v = v * 10 + (c - '0');
            }
            if (i == s.length() - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
                if (sign == '+') {
                    stk.push(v);
                } else if (sign == '-') {
                    stk.push(-v);
                } else if (sign == '*') {
                    stk.push(stk.pop() * v);
                } else {
                    stk.push(stk.pop() / v);
                }
                sign = c;
                v = 0;
            }
        }
        int ans = 0;
        while (!stk.isEmpty()) {
            ans += stk.pop();
        }
        return ans;
    }
}
```
