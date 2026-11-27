# 409. Longest Palindrome

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/longest-palindrome/

---

[中文文档](/solution/0400-0499/0409.Longest%20Palindrome/README.md)

## Description

<p>Given a string <code>s</code> which consists of lowercase or uppercase letters, return the length of the <strong>longest <span data-keyword="palindrome-string">palindrome</span></strong>&nbsp;that can be built with those letters.</p>

<p>Letters are <strong>case sensitive</strong>, for example, <code>&quot;Aa&quot;</code> is not considered a palindrome.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abccccdd&quot;
<strong>Output:</strong> 7
<strong>Explanation:</strong> One longest palindrome that can be built is &quot;dccaccd&quot;, whose length is 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;a&quot;
<strong>Output:</strong> 1
<strong>Explanation:</strong> The longest palindrome that can be built is &quot;a&quot;, whose length is 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2000</code></li>
	<li><code>s</code> consists of lowercase <strong>and/or</strong> uppercase English&nbsp;letters only.</li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> A palindrome allows at most one odd-count character; the rest must pair. We do not need to try permutations, only how many pairs each character can give.
>
> After counting, add $v//2\times 2$ for every frequency $v$. If the total is still shorter than $|s|$, one leftover character can sit in the center.
>
> Taking pairs first, then the optional center, yields a maximum feasible length.

A valid palindrome string can have at most one character that appears an odd number of times, and the rest of the characters appear an even number of times.

Therefore, we can first traverse the string $s$, count the number of occurrences of each character, and record it in an array or hash table $\textit{cnt}$.

Then, we traverse $\textit{cnt}$, for each count $v$, we divide $v$ by 2, take the integer part, multiply by 2, and add it to the answer $\textit{ans}$.

Finally, if the answer is less than the length of the string $s$, we increment the answer by one and return $\textit{ans}$.

The time complexity is $O(n + |\Sigma|)$, and the space complexity is $O(|\Sigma|)$, where $n$ is the length of the string $s$, and $|\Sigma|$ is the size of the character set. In this problem, $|\Sigma| = 128$.

#### Java

```java
class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            ++cnt[s.charAt(i)];
        }
        int ans = 0;
        for (int v : cnt) {
            ans += v / 2 * 2;
        }
        ans += ans < n ? 1 : 0;
        return ans;
    }
}
```

### Solution 2: Bit Manipulation + Counting

> **Thinking**
>
> Solution 1 counts, then sums. XORing a parity flag while scanning and tracking the number of odd characters $\textit{cnt}$ gives $n-\textit{cnt}+1$ (keep one center) or $n$.
>
> The second pass over the frequency table disappears; space is still the alphabet size.

We can use an array or hash table $\textit{odd}$ to record whether each character in string $s$ appears an odd number of times, and an integer variable $\textit{cnt}$ to record the number of characters that appear an odd number of times.

We iterate through the string $s$. For each character $c$, we flip $\textit{odd}[c]$, i.e., $0 \rightarrow 1$, $1 \rightarrow 0$. If $\textit{odd}[c]$ changes from $0$ to $1$, then we increment $\textit{cnt}$ by one; if $\textit{odd}[c]$ changes from $1$ to $0$, then we decrement $\textit{cnt}$ by one.

Finally, if $\textit{cnt}$ is greater than $0$, the answer is $n - \textit{cnt} + 1$, otherwise, the answer is $n$.

The time complexity is $O(n)$, and the space complexity is $O(|\Sigma|)$, where $n$ is the length of the string $s$, and $|\Sigma|$ is the size of the character set. In this problem, $|\Sigma| = 128$.

#### Java

```java
class Solution {
    public int longestPalindrome(String s) {
        int[] odd = new int[128];
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            odd[s.charAt(i)] ^= 1;
            cnt += odd[s.charAt(i)] == 1 ? 1 : -1;
        }
        return cnt > 0 ? n - cnt + 1 : n;
    }
}
```
