# 1624. Largest Substring Between Two Equal Characters

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/largest-substring-between-two-equal-characters/

---

[中文文档](/solution/1600-1699/1624.Largest%20Substring%20Between%20Two%20Equal%20Characters/README.md)

## Description

<p>Given a string <code>s</code>, return <em>the length of the longest substring between two equal characters, excluding the two characters.</em> If there is no such substring return <code>-1</code>.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters within a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aa&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> The optimal substring here is an empty substring between the two <code>&#39;a&#39;s</code>.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abca&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> The optimal substring here is &quot;bc&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cbzxy&quot;
<strong>Output:</strong> -1
<strong>Explanation:</strong> There are no characters that appear twice in s.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 300</code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Array

> **Thinking**
>
> The length between two equal letters is the gap between that letter's first occurrence and a later one. The string is short, but keeping only the first index of each letter already yields a linear solution.
>
> On seeing a character again, update the answer with $i - d[j] - 1$ and do not overwrite the first index, so the span stays maximal.
>
> Because $s$ contains only lowercase letters, a length-$26$ array is enough; if nothing appears twice, the answer stays $-1$.

Since $s$ contains only lowercase English letters, we can use an array $d$ of length $26$ to store the first index of each character, initially filled with $-1$.

Traverse $s$. For the character $c$ at index $i$, let $j$ be the offset of $c$ from `a`. If $d[j] = -1$, this is the first time we see $c$, so set $d[j] = i$; otherwise update the answer with $i - d[j] - 1$, i.e. $\textit{ans} = \max(\textit{ans}, i - d[j] - 1)$.

The time complexity is $O(n)$, and the space complexity is $O(C)$, where $n$ is the length of $s$ and $C = 26$ is the size of the alphabet.

#### Java

```java
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] d = new int[26];
        Arrays.fill(d, -1);
        int ans = -1;
        for (int i = 0; i < s.length(); ++i) {
            int j = s.charAt(i) - 'a';
            if (d[j] == -1) {
                d[j] = i;
            } else {
                ans = Math.max(ans, i - d[j] - 1);
            }
        }
        return ans;
    }
}
```
