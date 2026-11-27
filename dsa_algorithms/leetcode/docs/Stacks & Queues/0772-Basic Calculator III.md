# 772. Basic Calculator III

**Difficulty:** Hard  
**Category:** Stacks & Queues  
**LeetCode:** https://leetcode.com/problems/basic-calculator-iii/

---

[中文文档](/solution/0700-0799/0772.Basic%20Calculator%20III/README.md)

## Description

<p>Implement a basic calculator to evaluate a simple expression string.</p>

<p>The expression string contains only non-negative integers, <code>&#39;+&#39;</code>, <code>&#39;-&#39;</code>, <code>&#39;*&#39;</code>, <code>&#39;/&#39;</code> operators, and open <code>&#39;(&#39;</code> and closing parentheses <code>&#39;)&#39;</code>. The integer division should <strong>truncate toward zero</strong>.</p>

<p>You may assume that the given expression is always valid. All intermediate results will be in the range of <code>[-2<sup>31</sup>, 2<sup>31</sup> - 1]</code>.</p>

<p><strong>Note:</strong> You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as <code>eval()</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;1+1&quot;
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;6-4/2&quot;
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;2*(5+5*2)/3+(6/2+8)&quot;
<strong>Output:</strong> 21
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of digits, <code>&#39;+&#39;</code>, <code>&#39;-&#39;</code>, <code>&#39;*&#39;</code>, <code>&#39;/&#39;</code>, <code>&#39;(&#39;</code>,&nbsp;and&nbsp;<code>&#39;)&#39;</code>.</li>
	<li><code>s</code> is a <strong>valid</strong> expression.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Evaluate $+,-,*,/$ and parentheses. $n\le 10^4$. Multiplication and division bind immediately to the stack top; addition pushes a signed term and we sum at the end.
>
> A `(` starts a recursive evaluation until `)`; the result is the current number. A deque consumes the string once.
>
> $\textit{sign}$ is the previous operator; at each new operator we apply it to $\textit{num}$. Division truncates toward zero.

#### Java

```java
class Solution {
    public int calculate(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        return dfs(q);
    }

    private int dfs(Deque<Character> q) {
        long num = 0;
        char sign = '+';
        List<Long> stk = new ArrayList<>();
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = dfs(q);
            }
            if ("+-*/)".indexOf(c) >= 0 || q.isEmpty()) {
                if (sign == '+') {
                    stk.add(num);
                } else if (sign == '-') {
                    stk.add(-num);
                } else if (sign == '*') {
                    stk.set(stk.size() - 1, stk.get(stk.size() - 1) * num);
                } else {
                    stk.set(stk.size() - 1, stk.get(stk.size() - 1) / num);
                }
                num = 0;
                sign = c;
            }
            if (c == ')') {
                break;
            }
        }
        long ans = 0;
        for (long x : stk) {
            ans += x;
        }
        return (int) ans;
    }
}
```
