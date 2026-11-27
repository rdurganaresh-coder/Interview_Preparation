# 266. Palindrome Permutation

**Difficulty:** Easy  
**Category:** Backtracking  
**LeetCode:** https://leetcode.com/problems/palindrome-permutation/

---

[中文文档](/solution/0200-0299/0266.Palindrome%20Permutation/README.md)

## Description

<p>Given a string <code>s</code>, return <code>true</code> <em>if a permutation of the string could form a </em><span data-keyword="palindrome-string"><em><strong>palindrome</strong></em></span><em> and </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;code&quot;
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aab&quot;
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;carerac&quot;
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5000</code></li>
	<li><code>s</code> consists of only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> A permutation is a palindrome iff at most one character has an odd count. Tally frequencies and test that the number of odd counts is less than $2$.

If a string is a palindrome, at most one character can appear an odd number of times, while all other characters must appear an even number of times. Therefore, we only need to count the occurrences of each character and then check if this condition is satisfied.

The time complexity is $O(n)$, and the space complexity is $O(|\Sigma|)$, where $n$ is the length of the string, and $|\Sigma|$ is the size of the character set. In this problem, the character set consists of lowercase letters, so $|\Sigma|=26$.

#### Java

```java
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        int odd = 0;
        for (int x : cnt) {
            odd += x & 1;
        }
        return odd < 2;
    }
}
```
