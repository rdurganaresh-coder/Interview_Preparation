# 32. Longest Valid Parentheses

**Difficulty:** Hard  
**Category:** Stacks & Queues  
**LeetCode:** https://leetcode.com/problems/longest-valid-parentheses/

---

[中文文档](/solution/0000-0099/0032.Longest%20Valid%20Parentheses/README.md)

## Description

<p>Given a string containing just the characters <code>&#39;(&#39;</code> and <code>&#39;)&#39;</code>, return <em>the length of the longest valid (well-formed) parentheses </em><span data-keyword="substring-nonempty"><em>substring</em></span>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;(()&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> The longest valid parentheses substring is &quot;()&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;)()())&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest valid parentheses substring is &quot;()()&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;&quot;
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s[i]</code> is <code>&#39;(&#39;</code>, or <code>&#39;)&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> The first idea is to test every substring with a stack. Correct, but $n \le 3 \times 10^4$ makes $O(n^2)$ or $O(n^3)$ too slow.
>
> The bottleneck is overlap: the longest valid run ending at a position can be built from shorter valid runs.
>
> A valid substring can only end with `)`. If it pairs with the previous character, the length is that of the prefix before this pair plus $2$. If the previous character is also `)`, we skip the already-valid chunk ending there and check whether a `(` sits just before that chunk.
>
> So we let $f[i]$ be the longest valid length ending at $s[i-1]$, transfer on those two pairing cases, and take $\max f[i]$.

We define $f[i]$ to be the length of the longest valid parentheses that ends with $s[i-1]$, and the answer is $\max(f[i])$.

When $i \lt 2$, the length of the string is less than $2$, and there is no valid parentheses, so $f[i] = 0$.

When $i \ge 2$, we consider the length of the longest valid parentheses that ends with $s[i-1]$, that is, $f[i]$:

- If $s[i-1]$ is a left parenthesis, then the length of the longest valid parentheses that ends with $s[i-1]$ must be $0$, so $f[i] = 0$.
- If $s[i-1]$ is a right parenthesis, there are the following two cases:
    - If $s[i-2]$ is a left parenthesis, then the length of the longest valid parentheses that ends with $s[i-1]$ is $f[i-2] + 2$.
    - If $s[i-2]$ is a right parenthesis, then the length of the longest valid parentheses that ends with $s[i-1]$ is $f[i-1] + 2$, but we also need to consider whether $s[i-f[i-1]-2]$ is a left parenthesis. If it is a left parenthesis, then the length of the longest valid parentheses that ends with $s[i-1]$ is $f[i-1] + 2 + f[i-f[i-1]-2]$.

Therefore, we can get the state transition equation:

$$
\begin{cases}
f[i] = 0, & \text{if } s[i-1] = '(',\\
f[i] = f[i-2] + 2, & \text{if } s[i-1] = ')' \text{ and } s[i-2] = '(',\\
f[i] = f[i-1] + 2 + f[i-f[i-1]-2], & \text{if } s[i-1] = ')' \text{ and } s[i-2] = ')' \text{ and } s[i-f[i-1]-2] = '(',\\
\end{cases}
$$

Finally, we only need to return $\max(f)$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string.

#### Java

```java
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        int ans = 0;
        for (int i = 2; i <= n; ++i) {
            if (s.charAt(i - 1) == ')') {
                if (s.charAt(i - 2) == '(') {
                    f[i] = f[i - 2] + 2;
                } else {
                    int j = i - f[i - 1] - 1;
                    if (j > 0 && s.charAt(j - 1) == '(') {
                        f[i] = f[i - 1] + 2 + f[j - 1];
                    }
                }
                ans = Math.max(ans, f[i]);
            }
        }
        return ans;
    }
}
```

### Solution 2: Using Stack

> **Thinking**
>
> Method 1 is already $O(n)$, but the recurrence splits on whether the previous character is `(` and on pairing across an already-valid chunk, so the boundaries are easy to miss.
>
> What we still lack is not a better complexity, but a record that matches pairing more directly: indices of unmatched `(`, and where the last broken prefix starts.
>
> Seed the stack with $-1$ as a baseline, push on `(`, pop on `)`. An empty stack means the current `)` is a new baseline; otherwise the top of the stack updates the length. Time and space stay $O(n)$; the matching process is just easier to see.

- Maintain a stack to store the indices of left parentheses. Initialize the bottom element of the stack with the value -1 to facilitate the calculation of the length of valid parentheses.
- Iterate through each element of the string:
    - If the character is a left parenthesis, push the index of the character onto the stack.
    - If the character is a right parenthesis, pop an element from the stack to represent that we have found a valid pair of parentheses.
        - If the stack is empty, it means we couldn't find a left parenthesis to match the right parenthesis. In this case, push the index of the character as a new starting point.
        - If the stack is not empty, calculate the length of the valid parentheses and update it.

Summary:

The key to this algorithm is to maintain a stack to store the indices of left parentheses and then update the length of the valid substring of parentheses by pushing and popping elements.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string.
