# 917. Reverse Only Letters

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/reverse-only-letters/

---

[中文文档](/solution/0900-0999/0917.Reverse%20Only%20Letters/README.md)

## Description

<p>Given a string <code>s</code>, reverse the string according to the following rules:</p>

<ul>
	<li>All the characters that are not English letters remain in the same position.</li>
	<li>All the English letters (lowercase or uppercase) should be reversed.</li>
</ul>

<p>Return <code>s</code><em> after reversing it</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "ab-cd"
<strong>Output:</strong> "dc-ba"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "a-bC-dEf-ghIj"
<strong>Output:</strong> "j-Ih-gfE-dCba"
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> s = "Test1ng-Leet=code-Q!"
<strong>Output:</strong> "Qedo1ct-eeLg=ntse-T!"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists of characters with ASCII values in the range <code>[33, 122]</code>.</li>
	<li><code>s</code> does not contain <code>&#39;\&quot;&#39;</code> or <code>&#39;\\&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> Only letters reverse; other characters stay. Collecting letters and writing them back works, but two pointers finish it in one pass. Skip non-letters from both ends and swap. The string is immutable, so convert to a list first.

We use two pointers $i$ and $j$ to point to the head and tail of the string respectively. When $i < j$, we continuously move $i$ and $j$ until $i$ points to an English letter and $j$ points to an English letter, then we swap $s[i]$ and $s[j]$. Finally, we return the string.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string.

#### Java

```java
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(cs[i])) {
                ++i;
            }
            while (i < j && !Character.isLetter(cs[j])) {
                --j;
            }
            if (i < j) {
                char t = cs[i];
                cs[i] = cs[j];
                cs[j] = t;
                ++i;
                --j;
            }
        }
        return new String(cs);
    }
}
```
