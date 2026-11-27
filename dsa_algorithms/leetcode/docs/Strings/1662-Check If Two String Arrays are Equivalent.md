# 1662. Check If Two String Arrays are Equivalent

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

---

[中文文档](/solution/1600-1699/1662.Check%20If%20Two%20String%20Arrays%20are%20Equivalent/README.md)

## Description

<p>Given two string arrays <code>word1</code> and <code>word2</code>, return<em> </em><code>true</code><em> if the two arrays <strong>represent</strong> the same string, and </em><code>false</code><em> otherwise.</em></p>

<p>A string is <strong>represented</strong> by an array if the array elements concatenated <strong>in order</strong> forms the string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> word1 = [&quot;ab&quot;, &quot;c&quot;], word2 = [&quot;a&quot;, &quot;bc&quot;]
<strong>Output:</strong> true
<strong>Explanation:</strong>
word1 represents string &quot;ab&quot; + &quot;c&quot; -&gt; &quot;abc&quot;
word2 represents string &quot;a&quot; + &quot;bc&quot; -&gt; &quot;abc&quot;
The strings are the same, so return true.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> word1 = [&quot;a&quot;, &quot;cb&quot;], word2 = [&quot;ab&quot;, &quot;c&quot;]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> word1  = [&quot;abc&quot;, &quot;d&quot;, &quot;defg&quot;], word2 = [&quot;abcddefg&quot;]
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word1.length, word2.length &lt;= 10<sup>3</sup></code></li>
	<li><code>1 &lt;= word1[i].length, word2[i].length &lt;= 10<sup>3</sup></code></li>
	<li><code>1 &lt;= sum(word1[i].length), sum(word2[i].length) &lt;= 10<sup>3</sup></code></li>
	<li><code>word1[i]</code> and <code>word2[i]</code> consist of lowercase letters.</li>
</ul>

## Solutions

### Solution 1: String Concatenation

> **Thinking**
>
> We ask whether concatenating the two arrays yields the same string. The total length is tiny, so $\texttt{join}$ and compare.

Concatenate the strings in the two arrays into two strings, then compare whether the two strings are equal.

The time complexity is $O(m)$, and the space complexity is $O(m)$, where $m$ is the total length of the strings in the arrays.

#### Java

```java
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}
```

### Solution 2: Direct Traversal

> **Thinking**
>
> Solution 1 builds two new strings. Four pointers walk the original arrays character by character in $O(1)$ extra space: mismatch fails, and finishing a word advances to the next piece.

In Solution 1, we concatenated the strings in the two arrays into two new strings, which has additional space overhead. We can also directly traverse the two arrays and compare the characters one by one.

Use $\textit{i1}$ and $\textit{j1}$ for the current word and character of $\textit{word1}$, and $\textit{i2}$ and $\textit{j2}$ for the corresponding position in $\textit{word2}$. Initially, $\textit{i1}=\textit{j1}=\textit{i2}=\textit{j2}=0$.

Compare $\textit{word1}[\textit{i1}][\textit{j1}]$ with $\textit{word2}[\textit{i2}][\textit{j2}]$. If they differ, return `false`. Otherwise increment $\textit{j1}$. When it reaches the end of the current word, increment $\textit{i1}$ and set $\textit{j1}$ to $0$. Advance $\textit{j2}$ and $\textit{i2}$ in the same way.

Return `true` when both arrays have been fully traversed, and `false` otherwise.

The time complexity is $O(m)$, and the space complexity is $O(1)$, where $m$ is the total length of the strings in the arrays.

#### Java

```java
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
        while (i1 < word1.length && i2 < word2.length) {
            if (word1[i1].charAt(j1) != word2[i2].charAt(j2)) {
                return false;
            }
            ++j1;
            if (j1 == word1[i1].length()) {
                ++i1;
                j1 = 0;
            }
            ++j2;
            if (j2 == word2[i2].length()) {
                ++i2;
                j2 = 0;
            }
        }
        return i1 == word1.length && i2 == word2.length;
    }
}
```
