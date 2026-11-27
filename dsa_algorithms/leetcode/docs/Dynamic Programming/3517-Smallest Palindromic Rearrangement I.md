# 3517. Smallest Palindromic Rearrangement I

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/smallest-palindromic-rearrangement-i/

---

[中文文档](/solution/3500-3599/3517.Smallest%20Palindromic%20Rearrangement%20I/README.md)

## Description

<p>You are given a <strong><span data-keyword="palindrome-string">palindromic</span></strong> string <code>s</code>.</p>

<p>Return the <strong><span data-keyword="lexicographically-smaller-string">lexicographically smallest</span></strong> palindromic <span data-keyword="permutation-string">permutation</span> of <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;z&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;z&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>A string of only one character is already the lexicographically smallest palindrome.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;babab&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;abbba&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Rearranging <code>&quot;babab&quot;</code> &rarr; <code>&quot;abbba&quot;</code> gives the smallest lexicographic palindrome.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;daccad&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;acddca&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Rearranging <code>&quot;daccad&quot;</code> &rarr; <code>&quot;acddca&quot;</code> gives the smallest lexicographic palindrome.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
	<li><code>s</code> is guaranteed to be palindromic.</li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> $s$ is already a palindrome, and any rearrangement that stays a palindrome is determined by the multiset of the first half. Put half of each character on the left, at most one odd character in the middle, and mirror the right.
>
> The left half should be filled from `a` to `z` to obtain the lexicographically smallest string.

We first count the occurrence of each character in the string and record it in a hash table or array $\textit{cnt}$. Since the string is a palindrome, the count of each character is either even, or there is exactly one character with an odd count.

Next, starting from the lexicographically smallest character, we sequentially add half of each character's count to the first half of the result string $t$. If a character appears an odd number of times, we record it as the middle character $ch$. Finally, we concatenate $t$, $ch$, and the reverse of $t$ to obtain the final lexicographically smallest palindromic rearrangement.

The time complexity is $O(n)$, and the space complexity is $O(|\Sigma|)$, where $n$ is the length of the string, and $|\Sigma|$ is the size of the character set, which is $26$ in this problem.

#### Java

```java
class Solution {
    public String smallestPalindrome(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder t = new StringBuilder();
        String ch = "";

        for (char c = 'a'; c <= 'z'; c++) {
            int idx = c - 'a';
            int v = cnt[idx] / 2;
            if (v > 0) {
                t.append(String.valueOf(c).repeat(v));
            }
            cnt[idx] -= v * 2;
            if (cnt[idx] == 1) {
                ch = String.valueOf(c);
            }
        }

        String ans = t.toString();
        ans = ans + ch + new StringBuilder(ans).reverse();
        return ans;
    }
}
```
