# 20. Valid Parentheses

**Difficulty:** Easy  
**Category:** Stacks & Queues  
**LeetCode:** https://leetcode.com/problems/valid-parentheses/

---

[中文文档](/solution/0000-0099/0020.Valid%20Parentheses/README.md)

## Description

<p>Given a string <code>s</code> containing just the characters <code>&#39;(&#39;</code>, <code>&#39;)&#39;</code>, <code>&#39;{&#39;</code>, <code>&#39;}&#39;</code>, <code>&#39;[&#39;</code> and <code>&#39;]&#39;</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol>
	<li>Open brackets must be closed by the same type of brackets.</li>
	<li>Open brackets must be closed in the correct order.</li>
	<li>Every close bracket has a corresponding open bracket of the same type.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;()&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;()[]{}&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;(]&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;([])&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 5:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;([)]&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of parentheses only <code>&#39;()[]{}&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Stack

> **Thinking**
>
> Repeatedly deleting adjacent pairs $()$, $[]$, and $\{\}$ until nothing is left is correct, but each pass rescans the string. With $n \le 10^4$, deeply nested input falls to $O(n^2)$ and can easily time out.
>
> The bottleneck is that a match is more than two neighboring characters. A later opener must close first, while an earlier one stays open. Once the brackets cross, as in $([)]$, deleting neighbors cannot reduce the string to empty.
>
> Matching is therefore last-in, first-out: the only legal partner of the current closer is the most recent unmatched opener. A stack keeps those unfinished matches. An opener pushes its closer, so the closer allowed next sits on top, and a closer is compared only with that top. A mismatch means the type or the order is already wrong, and a non-empty stack at the end means some opener never closed.

We use a hash table $d$ to map each opening bracket to its closing bracket, and a stack $\textit{stk}$ to store closers that have not been matched yet. Scan $s$ from left to right. When the current character is an opening bracket, push the corresponding closer from $d$ onto $\textit{stk}$. When it is a closing bracket, return `false` if $\textit{stk}$ is empty or the popped top is different from that character.

After the scan, return `true` if $\textit{stk}$ is empty: every pair has been closed in the right type and order. If the stack still holds a closer, some opening bracket was never matched, so return `false`.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of $s$.

#### Java

```java
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        Map<Character, Character> d = new HashMap<>(3);
        d.put('(', ')');
        d.put('[', ']');
        d.put('{', '}');
        for (char c : s.toCharArray()) {
            if (d.containsKey(c)) {
                stk.push(d.get(c));
            } else if (stk.isEmpty() || stk.pop() != c) {
                return false;
            }
        }
        return stk.isEmpty();
    }
}
```
