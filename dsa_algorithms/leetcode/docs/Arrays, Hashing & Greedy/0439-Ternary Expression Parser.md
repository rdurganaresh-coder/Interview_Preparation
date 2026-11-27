# 439. Ternary Expression Parser

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/ternary-expression-parser/

---

[中文文档](/solution/0400-0499/0439.Ternary%20Expression%20Parser/README.md)

## Description

<p>Given a string <code>expression</code> representing arbitrarily nested ternary expressions, evaluate the expression, and return <em>the result of it</em>.</p>

<p>You can always assume that the given expression is valid and only contains digits, <code>&#39;?&#39;</code>, <code>&#39;:&#39;</code>, <code>&#39;T&#39;</code>, and <code>&#39;F&#39;</code> where <code>&#39;T&#39;</code> is true and <code>&#39;F&#39;</code> is false. All the numbers in the expression are <strong>one-digit</strong> numbers (i.e., in the range <code>[0, 9]</code>).</p>

<p>The conditional expressions group right-to-left (as usual in most languages), and the result of the expression will always evaluate to either a digit, <code>&#39;T&#39;</code> or <code>&#39;F&#39;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> expression = &quot;T?2:3&quot;
<strong>Output:</strong> &quot;2&quot;
<strong>Explanation:</strong> If true, then result is 2; otherwise result is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> expression = &quot;F?1:T?4:5&quot;
<strong>Output:</strong> &quot;4&quot;
<strong>Explanation:</strong> The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
&quot;(F ? 1 : (T ? 4 : 5))&quot; --&gt; &quot;(F ? 1 : 4)&quot; --&gt; &quot;4&quot;
or &quot;(F ? 1 : (T ? 4 : 5))&quot; --&gt; &quot;(T ? 4 : 5)&quot; --&gt; &quot;4&quot;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> expression = &quot;T?T?F:5:3&quot;
<strong>Output:</strong> &quot;F&quot;
<strong>Explanation:</strong> The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
&quot;(T ? (T ? F : 5) : 3)&quot; --&gt; &quot;(T ? F : 3)&quot; --&gt; &quot;F&quot;
&quot;(T ? (T ? F : 5) : 3)&quot; --&gt; &quot;(T ? F : 5)&quot; --&gt; &quot;F&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>5 &lt;= expression.length &lt;= 10<sup>4</sup></code></li>
	<li><code>expression</code> consists of digits, <code>&#39;T&#39;</code>, <code>&#39;F&#39;</code>, <code>&#39;?&#39;</code>, and <code>&#39;:&#39;</code>.</li>
	<li>It is <strong>guaranteed</strong> that <code>expression</code> is a valid ternary expression and that each number is a <strong>one-digit number</strong>.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A ternary expression is right-associative: $T?T?1:2:3$ evaluates the inner choice first. A left-to-right scan must read both branches ahead; a recursive descent is heavier than needed.
>
> Walk right to left: push ordinary characters, skip colons, and when a question mark appears the next character is the condition—keep one of the two stacked results according to $T/F$.
>
> Right-to-left evaluates inner expressions first, so the stack always holds already-reduced leaves and finishes with one character.

#### Java

```java
class Solution {
    public String parseTernary(String expression) {
        Deque<Character> stk = new ArrayDeque<>();
        boolean cond = false;
        for (int i = expression.length() - 1; i >= 0; --i) {
            char c = expression.charAt(i);
            if (c == ':') {
                continue;
            }
            if (c == '?') {
                cond = true;
            } else {
                if (cond) {
                    if (c == 'T') {
                        char x = stk.pop();
                        stk.pop();
                        stk.push(x);
                    } else {
                        stk.pop();
                    }
                    cond = false;
                } else {
                    stk.push(c);
                }
            }
        }
        return String.valueOf(stk.peek());
    }
}
```
