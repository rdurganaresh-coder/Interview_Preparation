# 1446. Consecutive Characters

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/consecutive-characters/

---

[中文文档](/solution/1400-1499/1446.Consecutive%20Characters/README.md)

## Description

<p>The <strong>power</strong> of the string is the maximum length of a non-empty substring that contains only one unique character.</p>

<p>Given a string <code>s</code>, return <em>the <strong>power</strong> of</em> <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;leetcode&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> The substring &quot;ee&quot; is of length 2 with the character &#39;e&#39; only.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abbcccddddeeeeedcba&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> The substring &quot;eeeee&quot; is of length 5 with the character &#39;e&#39; only.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 500</code></li>
	<li><code>s</code> consists of only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Traversal and Counting

> **Thinking**
>
> $n\le 500$. Scan once, grow $t$ while adjacent characters match, reset on a change, and keep the maximum.

We define a variable $t$ to represent the length of the current consecutive characters, initially $t=1$.

Next, we traverse the string $s$ starting from the second character. If the current character is the same as the previous character, then $t = t + 1$, and update the answer $\textit{ans} = \max(\textit{ans}, t)$; otherwise, set $t = 1$.

Finally, return the answer $\textit{ans}$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int maxPower(String s) {
        int ans = 1, t = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ans = Math.max(ans, ++t);
            } else {
                t = 1;
            }
        }
        return ans;
    }
}
```
