# 921. Minimum Add to Make Parentheses Valid

**Difficulty:** Medium  
**Category:** Stacks & Queues  
**LeetCode:** https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

---

[中文文档](/solution/0900-0999/0921.Minimum%20Add%20to%20Make%20Parentheses%20Valid/README.md)

## Description

<p>A parentheses string is valid if and only if:</p>

<ul>
	<li>It is the empty string,</li>
	<li>It can be written as <code>AB</code> (<code>A</code> concatenated with <code>B</code>), where <code>A</code> and <code>B</code> are valid strings, or</li>
	<li>It can be written as <code>(A)</code>, where <code>A</code> is a valid string.</li>
</ul>

<p>You are given a parentheses string <code>s</code>. In one move, you can insert a parenthesis at any position of the string.</p>

<ul>
	<li>For example, if <code>s = &quot;()))&quot;</code>, you can insert an opening parenthesis to be <code>&quot;(<strong>(</strong>)))&quot;</code> or a closing parenthesis to be <code>&quot;())<strong>)</strong>)&quot;</code>.</li>
</ul>

<p>Return <em>the minimum number of moves required to make </em><code>s</code><em> valid</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;())&quot;
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;(((&quot;
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s[i]</code> is either <code>&#39;(&#39;</code> or <code>&#39;)&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Greedy + Stack

> **Thinking**
>
> We must add the fewest parentheses to make the string valid. Whatever remains on a matching stack needs one counterpart each. Push a left parenthesis; a right one pops a matching left if possible, otherwise it stays. The final stack size is the answer.

This problem is a classic parenthesis matching problem, which can be solved using "Greedy + Stack".

Iterate through each character $c$ in the string $s$:

- If $c$ is a left parenthesis, directly push $c$ into the stack;
- If $c$ is a right parenthesis, at this point if the stack is not empty, and the top element of the stack is a left parenthesis, then pop the top element of the stack, indicating a successful match; otherwise, push $c$ into the stack.

After the iteration ends, the number of remaining elements in the stack is the number of parentheses that need to be added.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')' && !stk.isEmpty() && stk.peek() == '(') {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.size();
    }
}
```

### Solution 2: Greedy + Counting

> **Thinking**
>
> The stack only needs the count of unmatched left parentheses, not the characters. $\textit{cnt}$ tracks those lefts, unmatched rights go into $\textit{ans}$, and the leftover $\textit{cnt}$ is added at the end, using constant extra space.

Solution 1 uses a stack to implement parenthesis matching, but we can also directly implement it through counting.

Define a variable $\textit{cnt}$ to represent the current number of left parentheses to be matched, and a variable $\textit{ans}$ to record the answer. Initially, both variables are set to $0$.

Iterate through each character $c$ in the string $s$:

- If $c$ is a left parenthesis, increase the value of $\textit{cnt}$ by $1$;
- If $c$ is a right parenthesis, at this point if $\textit{cnt} > 0$, it means that there are left parentheses that can be matched, so decrease the value of $\textit{cnt}$ by $1$; otherwise, it means that the current right parenthesis cannot be matched, so increase the value of $\textit{ans}$ by $1$.

After the iteration ends, add the value of $\textit{cnt}$ to $\textit{ans}$, which is the answer.

The Rust version uses `fold` over the bytes with $(\textit{ans}, \textit{cnt})$ as the state, so no explicit loop is needed; the greedy counting strategy is the same as above.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++cnt;
            } else if (cnt > 0) {
                --cnt;
            } else {
                ++ans;
            }
        }
        ans += cnt;
        return ans;
    }
}
```

### Solution 3: Replace + recursion

> **Thinking**
>
> A matched `()` pair does not affect the answer and can be deleted. Repeatedly replace one `()`; if the length does not change, nothing remains to pair and the length is the number of additions; otherwise recurse. $n\le 1000$, so the replacements are affordable.
