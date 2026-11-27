# 2697. Lexicographically Smallest Palindrome

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/lexicographically-smallest-palindrome/

---

[中文文档](/solution/2600-2699/2697.Lexicographically%20Smallest%20Palindrome/README.md)

## Description

<p>You are given a string <code node="[object Object]">s</code> consisting of <strong>lowercase English letters</strong>, and you are allowed to perform operations on it. In one operation, you can <strong>replace</strong> a character in <code node="[object Object]">s</code> with another lowercase English letter.</p>

<p>Your task is to make <code node="[object Object]">s</code> a <strong>palindrome</strong> with the <strong>minimum</strong> <strong>number</strong> <strong>of operations</strong> possible. If there are <strong>multiple palindromes</strong> that can be <meta charset="utf-8" />made using the <strong>minimum</strong> number of operations, <meta charset="utf-8" />make the <strong>lexicographically smallest</strong> one.</p>

<p>A string <code>a</code> is lexicographically smaller than a string <code>b</code> (of the same length) if in the first position where <code>a</code> and <code>b</code> differ, string <code>a</code> has a letter that appears earlier in the alphabet than the corresponding letter in <code>b</code>.</p>

<p>Return <em>the resulting palindrome string.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;egcfe&quot;
<strong>Output:</strong> &quot;efcfe&quot;
<strong>Explanation:</strong> The minimum number of operations to make &quot;egcfe&quot; a palindrome is 1, and the lexicographically smallest palindrome string we can get by modifying one character is &quot;efcfe&quot;, by changing &#39;g&#39;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcd&quot;
<strong>Output:</strong> &quot;abba&quot;
<strong>Explanation:</strong> The minimum number of operations to make &quot;abcd&quot; a palindrome is 2, and the lexicographically smallest palindrome string we can get by modifying two characters is &quot;abba&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;seven&quot;
<strong>Output:</strong> &quot;neven&quot;
<strong>Explanation:</strong> The minimum number of operations to make &quot;seven&quot; a palindrome is 1, and the lexicographically smallest palindrome string we can get by modifying one character is &quot;neven&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code>&nbsp;consists of only lowercase English letters<b>.</b></li>
</ul>

## Solutions

### Solution 1: Greedy + Two Pointers

> **Thinking**
>
> We may only decrease letters, and the result must be a palindrome. Symmetric ends should both become the smaller of the two characters. $n \le 10^5$ allows one two-pointer pass; we need not search which indices to change.

We use two pointers $i$ and $j$ to point to the beginning and end of the string, initially $i = 0$, $j = n - 1$.

Next, each time we greedily modify $s[i]$ and $s[j]$ to their smaller value to make them equal. Then we move $i$ one step forward and $j$ one step backward, and continue this process until $i \ge j$. At this point, we have obtained the smallest palindrome string.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string.

#### Java

```java
class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0, j = cs.length - 1; i < j; ++i, --j) {
            cs[i] = cs[j] = (char) Math.min(cs[i], cs[j]);
        }
        return new String(cs);
    }
}
```
