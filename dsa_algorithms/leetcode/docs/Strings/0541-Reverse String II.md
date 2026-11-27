# 541. Reverse String II

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/reverse-string-ii/

---

[中文文档](/solution/0500-0599/0541.Reverse%20String%20II/README.md)

## Description

<p>Given a string <code>s</code> and an integer <code>k</code>, reverse the first <code>k</code> characters for every <code>2k</code> characters counting from the start of the string.</p>

<p>If there are fewer than <code>k</code> characters left, reverse all of them. If there are less than <code>2k</code> but greater than or equal to <code>k</code> characters, then reverse the first <code>k</code> characters and leave the other as original.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "abcdefg", k = 2
<strong>Output:</strong> "bacdfeg"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "abcd", k = 2
<strong>Output:</strong> "bacd"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of only lowercase English letters.</li>
	<li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> In every block of $2k$ characters, reverse only the first $k$. A linear pass over blocks is enough.
>
> Convert to a list and, with step $2k$, reverse the slice of length $k$. A short tail reverses only what remains. Join back into a string.

We can traverse the string $s$, iterating over every $\textit{2k}$ characters, and then use the two-pointer technique to reverse the first $k$ characters among these $\textit{2k}$ characters.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i += k * 2) {
            for (int l = i, r = Math.min(i + k - 1, n - 1); l < r; ++l, --r) {
                char t = cs[l];
                cs[l] = cs[r];
                cs[r] = t;
            }
        }
        return new String(cs);
    }
}
```
