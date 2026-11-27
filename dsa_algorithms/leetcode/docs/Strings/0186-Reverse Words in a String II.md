# 186. Reverse Words in a String II

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/reverse-words-in-a-string-ii/

---

[中文文档](/solution/0100-0199/0186.Reverse%20Words%20in%20a%20String%20II/README.md)

## Description

<p>Given a character array <code>s</code>, reverse the order of the <strong>words</strong>.</p>

<p>A <strong>word</strong> is defined as a sequence of non-space characters. The <strong>words</strong> in <code>s</code> will be separated by a single space.</p>

<p>Your code must solve the problem&nbsp;<strong>in-place,</strong> i.e. without allocating extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
<strong>Output:</strong> ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = ["a"]
<strong>Output:</strong> ["a"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is an English letter (uppercase or lowercase), digit, or space <code>&#39; &#39;</code>.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
	<li><code>s</code> does not contain leading or trailing spaces.</li>
	<li>All the words in <code>s</code> are guaranteed to be separated by a single space.</li>
</ul>

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> Reverse the word order in a character array in place; words are separated by a single space. $n\le 10^5$, $O(1)$ extra space. Reverse each word, then reverse the whole array: word order flips and letters inside a word return to normal. Two pointers mark each word.

We can iterate through the character array $s$, using two pointers $i$ and $j$ to find the start and end positions of each word, then reverse each word, and finally reverse the entire character array.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the character array $s$.

#### Java

```java
class Solution {
    public void reverseWords(char[] s) {
        int n = s.length;
        for (int i = 0, j = 0; j < n; ++j) {
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            } else if (j == n - 1) {
                reverse(s, i, j);
            }
        }
        reverse(s, 0, n - 1);
    }

    private void reverse(char[] s, int i, int j) {
        for (; i < j; ++i, --j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
```
