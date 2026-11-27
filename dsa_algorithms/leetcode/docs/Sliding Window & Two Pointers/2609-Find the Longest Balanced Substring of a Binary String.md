# 2609. Find the Longest Balanced Substring of a Binary String

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/

---

[中文文档](/solution/2600-2699/2609.Find%20the%20Longest%20Balanced%20Substring%20of%20a%20Binary%20String/README.md)

## Description

<p>You are given a binary string <code>s</code> consisting only of zeroes and ones.</p>

<p>A substring of <code>s</code> is considered balanced if<strong> all zeroes are before ones</strong> and the number of zeroes is equal to the number of ones inside the substring. Notice that the empty substring is considered a balanced substring.</p>

<p>Return <em>the length of the longest balanced substring of </em><code>s</code>.</p>

<p>A <b>substring</b> is a contiguous sequence of characters within a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;01000111&quot;
<strong>Output:</strong> 6
<strong>Explanation:</strong> The longest balanced substring is &quot;000111&quot;, which has length 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;00111&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest balanced substring is &quot;0011&quot;, which has length 4.&nbsp;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;111&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no balanced substring except the empty substring, so the answer is 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 50</code></li>
	<li><code>&#39;0&#39; &lt;= s[i] &lt;= &#39;1&#39;</code></li>
</ul>

## Solutions

### Solution 1: Brute force

> **Thinking**
>
> A balanced substring is zeros followed by the same number of ones. $n \le 50$ allows enumerating $O(n^2)$ substrings and scanning each in $O(n)$.
>
> For every interval we count ones, require every zero to precede the first one, and require the one-count to be exactly half the length.

Since the range of $n$ is small, we can enumerate all substrings $s[i..j]$ to check if it is a balanced string. If so, update the answer.

The time complexity is $O(n^3)$, and the space complexity is $O(1)$, where $n$ is the length of string $s$.

#### Java

```java
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (check(s, i, j)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    private boolean check(String s, int i, int j) {
        int cnt = 0;
        for (int k = i; k <= j; ++k) {
            if (s.charAt(k) == '1') {
                ++cnt;
            } else if (cnt > 0) {
                return false;
            }
        }
        return cnt * 2 == j - i + 1;
    }
}
```

### Solution 2: Enumeration optimization

> **Thinking**
>
> Solution 1 scans every interval in cubic time. A valid string is only a run of zeros followed by a run of ones, so we keep those two run lengths.
>
> A zero after ones starts a new pair of runs; a one updates the answer with $2\times\min(\textit{zero},\textit{one})$. One pass suffices.

We use variables $\textit{zero}$ and $\textit{one}$ to record the number of continuous $0$ and $1$.

Traverse the string $s$, for the current character $c$:

- If the current character is `'0'`, we check if $\textit{one}$ is greater than $0$, if so, we reset $\textit{zero}$ and $\textit{one}$ to $0$, and then add $1$ to $\textit{zero}$.
- If the current character is `'1'`, we add $1$ to $\textit{one}$, and update the answer to $\textit{ans} = \max(\textit{ans}, 2 \times \min(\textit{one}, \textit{zero}))$.

After the traversal is complete, we can get the length of the longest balanced substring.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of string $s$.

#### Java

```java
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int zero = 0, one = 0;
        int ans = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '0') {
                if (one > 0) {
                    zero = 0;
                    one = 0;
                }
                ++zero;
            } else {
                ans = Math.max(ans, 2 * Math.min(zero, ++one));
            }
        }
        return ans;
    }
}
```
