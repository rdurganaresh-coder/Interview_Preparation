# 2278. Percentage of Letter in String

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/percentage-of-letter-in-string/

---

[中文文档](/solution/2200-2299/2278.Percentage%20of%20Letter%20in%20String/README.md)

## Description

<p>Given a string <code>s</code> and a character <code>letter</code>, return<em> the <strong>percentage</strong> of characters in </em><code>s</code><em> that equal </em><code>letter</code><em> <strong>rounded down</strong> to the nearest whole percent.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;foobar&quot;, letter = &quot;o&quot;
<strong>Output:</strong> 33
<strong>Explanation:</strong>
The percentage of characters in s that equal the letter &#39;o&#39; is 2 / 6 * 100% = 33% when rounded down, so we return 33.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;jjjj&quot;, letter = &quot;k&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong>
The percentage of characters in s that equal the letter &#39;k&#39; is 0%, so we return 0.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
	<li><code>letter</code> is a lowercase English letter.</li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> We want the floor percentage of a letter in $s$. The length is at most $100$, so a count plus integer division is enough.
>
> $s.\textit{count}(\textit{letter})\times 100 // |s|$ avoids floating point.

We can traverse the string $s$ and count the number of characters that are equal to $\textit{letter}$. Then, we calculate the percentage using the formula $\textit{count} \times 100 \, / \, \textit{len}(s)$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                ++cnt;
            }
        }
        return cnt * 100 / s.length();
    }
}
```
