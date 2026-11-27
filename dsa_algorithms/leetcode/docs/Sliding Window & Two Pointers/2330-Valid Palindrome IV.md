# 2330. Valid Palindrome IV

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/valid-palindrome-iv/

---

[中文文档](/solution/2300-2399/2330.Valid%20Palindrome%20IV/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> string <code>s</code> consisting of only lowercase English letters. In one operation, you can change <strong>any</strong> character of <code>s</code> to any <strong>other</strong> character.</p>

<p>Return <code>true</code><em> if you can make </em><code>s</code><em> a palindrome after performing <strong>exactly</strong> one or two operations, or return </em><code>false</code><em> otherwise.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcdba&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> One way to make s a palindrome using 1 operation is:
- Change s[2] to &#39;d&#39;. Now, s = &quot;abddba&quot;.
One operation could be performed to make s a palindrome so return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aa&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> One way to make s a palindrome using 2 operations is:
- Change s[0] to &#39;b&#39;. Now, s = &quot;ba&quot;.
- Change s[1] to &#39;b&#39;. Now, s = &quot;bb&quot;.
Two operations could be performed to make s a palindrome so return true.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcdef&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> It is not possible to make s a palindrome using one or two operations so return false.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> We may change at most two characters to make a palindrome. $n \le 10^5$, so we cannot try edit positions. One edit fixes at most one mirrored pair.
>
> Two pointers count pairs with $s[i] \ne s[j]$. At most two mismatches can be fixed in two operations.

We can use two pointers $i$ and $j$, pointing to the beginning and end of the string, respectively, and then move towards the center, counting the number of different characters. If the number of different characters is greater than $2$, return $\textit{false}$; otherwise, return $\textit{true}$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public boolean makePalindrome(String s) {
        int cnt = 0;
        int i = 0, j = s.length() - 1;
        for (; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                ++cnt;
            }
        }
        return cnt <= 2;
    }
}
```
