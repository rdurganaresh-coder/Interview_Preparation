# 761. Special Binary String

**Difficulty:** Hard  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/special-binary-string/

---

[中文文档](/solution/0700-0799/0761.Special%20Binary%20String/README.md)

## Description

<p><strong>Special binary strings</strong> are binary strings with the following two properties:</p>

<ul>
	<li>The number of <code>0</code>&#39;s is equal to the number of <code>1</code>&#39;s.</li>
	<li>Every prefix of the binary string has at least as many <code>1</code>&#39;s as <code>0</code>&#39;s.</li>
</ul>

<p>You are given a <strong>special binary</strong> string <code>s</code>.</p>

<p>A move consists of choosing two consecutive, non-empty, special substrings of <code>s</code>, and swapping them. Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.</p>

<p>Return <em>the lexicographically largest resulting string possible after applying the mentioned operations on the string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;11011000&quot;
<strong>Output:</strong> &quot;11100100&quot;
<strong>Explanation:</strong> The strings &quot;10&quot; [occuring at s[1]] and &quot;1100&quot; [at s[3]] are swapped.
This is the lexicographically largest string possible after some number of swaps.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;10&quot;
<strong>Output:</strong> &quot;10&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 50</code></li>
	<li><code>s[i]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
	<li><code>s</code> is a special binary string.</li>
</ul>

## Solutions

### Solution 1: Recursion + Sorting

> **Thinking**
>
> A special binary string is a valid parentheses string with $1$/$0$. Swapping adjacent special pieces increases the lexicographic order. $n\le 50$, but the recursive shape is the real lever.
>
> The string is a concatenation of $1+\textit{special}+0$ blocks. Maximize each interior, then sort those blocks descending.
>
> A balance counter isolates blocks; recurse on the inside, sort, and join.

We can treat the special binary sequence as "valid parentheses", where $1$ represents an opening parenthesis and $0$ represents a closing parenthesis. For example, "11011000" can be viewed as "(()(()))".

Swapping two consecutive non-empty special substrings is equivalent to swapping two adjacent valid parentheses. We can use recursion to solve this problem.

We treat each "valid parenthesis" in string $s$ as a part, process it recursively, and finally sort them to get the final answer.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the length of string $s$.

#### Java

```java
class Solution {
    public String makeLargestSpecial(String s) {
        if ("".equals(s)) {
            return "";
        }
        List<String> ans = new ArrayList<>();
        int cnt = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == '1' ? 1 : -1;
            if (cnt == 0) {
                String t = "1" + makeLargestSpecial(s.substring(j + 1, i)) + "0";
                ans.add(t);
                j = i + 1;
            }
        }
        ans.sort(Comparator.reverseOrder());
        return String.join("", ans);
    }
}
```
