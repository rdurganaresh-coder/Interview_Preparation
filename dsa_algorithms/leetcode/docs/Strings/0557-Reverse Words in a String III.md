# 557. Reverse Words in a String III

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/reverse-words-in-a-string-iii/

---

[中文文档](/solution/0500-0599/0557.Reverse%20Words%20in%20a%20String%20III/README.md)

## Description

<p>Given a string <code>s</code>, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;Let&#39;s take LeetCode contest&quot;
<strong>Output:</strong> &quot;s&#39;teL ekat edoCteeL tsetnoc&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;Mr Ding&quot;
<strong>Output:</strong> &quot;rM gniD&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> contains printable <strong>ASCII</strong> characters.</li>
	<li><code>s</code> does not contain any leading or trailing spaces.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
	<li>All the words in <code>s</code> are separated by a single space.</li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> Reverse each word and keep the spaces. Split, reverse, and join.
>
> `split` yields the words; reverse each and join with spaces. Manual two-pointers are unnecessary unless library helpers are forbidden.

We can split the string $s$ into an array of words $\textit{words}$ by spaces, then reverse each word and concatenate them back into a string.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; ++i) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        return String.join(" ", words);
    }
}
```
