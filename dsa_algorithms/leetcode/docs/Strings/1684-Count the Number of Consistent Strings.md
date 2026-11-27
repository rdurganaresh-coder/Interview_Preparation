# 1684. Count the Number of Consistent Strings

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/count-the-number-of-consistent-strings/

---

[中文文档](/solution/1600-1699/1684.Count%20the%20Number%20of%20Consistent%20Strings/README.md)

## Description

<p>You are given a string <code>allowed</code> consisting of <strong>distinct</strong> characters and an array of strings <code>words</code>. A string is <strong>consistent </strong>if all characters in the string appear in the string <code>allowed</code>.</p>

<p>Return<em> the number of <strong>consistent</strong> strings in the array </em><code>words</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> allowed = &quot;ab&quot;, words = [&quot;ad&quot;,&quot;bd&quot;,&quot;aaab&quot;,&quot;baa&quot;,&quot;badab&quot;]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Strings &quot;aaab&quot; and &quot;baa&quot; are consistent since they only contain characters &#39;a&#39; and &#39;b&#39;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> allowed = &quot;abc&quot;, words = [&quot;a&quot;,&quot;b&quot;,&quot;c&quot;,&quot;ab&quot;,&quot;ac&quot;,&quot;bc&quot;,&quot;abc&quot;]
<strong>Output:</strong> 7
<strong>Explanation:</strong> All strings are consistent.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> allowed = &quot;cad&quot;, words = [&quot;cc&quot;,&quot;acd&quot;,&quot;b&quot;,&quot;ba&quot;,&quot;bac&quot;,&quot;bad&quot;,&quot;ac&quot;,&quot;d&quot;]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Strings &quot;cc&quot;, &quot;acd&quot;, &quot;ac&quot;, and &quot;d&quot; are consistent.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= allowed.length &lt;=<sup> </sup>26</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 10</code></li>
	<li>The characters in <code>allowed</code> are <strong>distinct</strong>.</li>
	<li><code>words[i]</code> and <code>allowed</code> contain only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Hash Table or Array

> **Thinking**
>
> A consistent word uses only letters from $\textit{allowed}$. Put $\textit{allowed}$ in a set and test that every character of each word is inside it.

A straightforward approach is to use a hash table or array $s$ to record the characters in $\textit{allowed}$. Then iterate over the `words` array, for each string $w$, determine whether it is composed of characters in $\textit{allowed}$. If so, increment the answer.

The time complexity is $O(m)$, and the space complexity is $O(C)$, where $m$ is the total length of all strings, and $C$ is the size of the character set $\textit{allowed}$. In this problem, $C \leq 26$.

#### Java

```java
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] s = new boolean[26];
        for (char c : allowed.toCharArray()) {
            s[c - 'a'] = true;
        }
        int ans = 0;
        for (String w : words) {
            if (check(w, s)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean check(String w, boolean[] s) {
        for (int i = 0; i < w.length(); ++i) {
            if (!s[w.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}
```

### Solution 2: Bit Manipulation

> **Thinking**
>
> Solution 1 uses a hash set. With $26$ letters a bit mask encodes the alphabet: a word is allowed iff the OR of the two masks equals the $\textit{allowed}$ mask.

We can also use a single integer to represent the occurrence of characters in each string. In this integer, each bit in the binary representation indicates whether a character appears.

We simply define a function $f(w)$ that can convert a string $w$ into an integer. Each bit in the binary representation of the integer indicates whether a character appears. For example, the string `ab` can be converted into the integer $3$, which is represented in binary as $11$. The string `abd` can be converted into the integer $11$, which is represented in binary as $1011$.

Back to the problem, to determine whether a string $w$ is composed of characters in $\textit{allowed}$, we can check whether the result of the bitwise OR operation between $f(\textit{allowed})$ and $f(w)$ is equal to $f(\textit{allowed})$. If so, increment the answer.

The time complexity is $O(m)$, and the space complexity is $O(1)$, where $m$ is the total length of all strings.

#### Java

```java
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = f(allowed);
        int ans = 0;
        for (String w : words) {
            if ((mask | f(w)) == mask) {
                ++ans;
            }
        }
        return ans;
    }

    private int f(String w) {
        int mask = 0;
        for (int i = 0; i < w.length(); ++i) {
            mask |= 1 << (w.charAt(i) - 'a');
        }
        return mask;
    }
}
```
