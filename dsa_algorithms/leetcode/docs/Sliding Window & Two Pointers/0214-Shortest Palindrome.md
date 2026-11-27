# 214. Shortest Palindrome

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/shortest-palindrome/

---

[中文文档](/solution/0200-0299/0214.Shortest%20Palindrome/README.md)

## Description

<p>You are given a string <code>s</code>. You can convert <code>s</code> to a <span data-keyword="palindrome-string">palindrome</span> by adding characters in front of it.</p>

<p>Return <em>the shortest palindrome you can find by performing this transformation</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "aacecaaa"
<strong>Output:</strong> "aaacecaaa"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "abcd"
<strong>Output:</strong> "dcbabcd"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters only.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The fewest characters to prepend so that $s$ becomes a palindrome are the reverse of the suffix after the longest palindromic prefix. Testing every prefix is slow.
>
> We roll a prefix hash and its reverse; equality updates the longest palindromic prefix. The leftover suffix is reversed and prepended.

#### Java

```java
class Solution {
    public String shortestPalindrome(String s) {
        int base = 131;
        int mul = 1;
        int mod = (int) 1e9 + 7;
        int prefix = 0, suffix = 0;
        int idx = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int t = s.charAt(i) - 'a' + 1;
            prefix = (int) (((long) prefix * base + t) % mod);
            suffix = (int) ((suffix + (long) t * mul) % mod);
            mul = (int) (((long) mul * base) % mod);
            if (prefix == suffix) {
                idx = i + 1;
            }
        }
        if (idx == n) {
            return s;
        }
        return new StringBuilder(s.substring(idx)).reverse().toString() + s;
    }
}
```

### Solution 2: KMP Algorithm

> **Thinking**
>
> Polynomial hashes may collide. Concatenating $s$ with its reverse and computing KMP $\textit{next}$ makes the last $\textit{next}$ value the longest palindromic prefix length.
>
> The same construction then runs in linear time without modular hashing.

According to the problem description, we need to reverse the string $s$ to obtain the string $\textit{rev}$, and then find the longest common part of the suffix of the string $\textit{rev}$ and the prefix of the string $s$. We can use the KMP algorithm to concatenate the string $s$ and the string $\textit{rev}$ and find the longest common part of the longest prefix and the longest suffix.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        char[] t = (s + "#" + rev + "$").toCharArray();
        int n = t.length;
        int[] next = new int[n];
        next[0] = -1;
        for (int i = 2, j = 0; i < n;) {
            if (t[i - 1] == t[j]) {
                next[i++] = ++j;
            } else if (j > 0) {
                j = next[j];
            } else {
                next[i++] = 0;
            }
        }
        return rev.substring(0, s.length() - next[n - 1]) + s;
    }
}
```
