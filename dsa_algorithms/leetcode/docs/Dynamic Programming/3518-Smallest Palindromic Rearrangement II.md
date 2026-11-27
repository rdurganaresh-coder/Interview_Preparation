# 3518. Smallest Palindromic Rearrangement II

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/

---

[中文文档](/solution/3500-3599/3518.Smallest%20Palindromic%20Rearrangement%20II/README.md)

## Description

<p data-end="332" data-start="99">You are given a <strong><span data-keyword="palindrome-string">palindromic</span></strong> string <code>s</code> and an integer <code>k</code>.</p>

<p>Return the <strong>k-th</strong> <strong><span data-keyword="lexicographically-smaller-string">lexicographically smallest</span></strong> palindromic <span data-keyword="permutation-string">permutation</span> of <code>s</code>. If there are fewer than <code>k</code> distinct palindromic permutations, return an empty string.</p>

<p><strong>Note:</strong> Different rearrangements that yield the same palindromic string are considered identical and are counted once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abba&quot;, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;baab&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The two distinct palindromic rearrangements of <code>&quot;abba&quot;</code> are <code>&quot;abba&quot;</code> and <code>&quot;baab&quot;</code>.</li>
	<li>Lexicographically, <code>&quot;abba&quot;</code> comes before <code>&quot;baab&quot;</code>. Since <code>k = 2</code>, the output is <code>&quot;baab&quot;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aa&quot;, k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There is only one palindromic rearrangement: <code data-end="1112" data-start="1106">&quot;aa&quot;</code>.</li>
	<li>The output is an empty string since <code>k = 2</code> exceeds the number of possible rearrangements.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;bacab&quot;, k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;abcba&quot;</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>The two distinct palindromic rearrangements of <code>&quot;bacab&quot;</code> are <code>&quot;abcba&quot;</code> and <code>&quot;bacab&quot;</code>.</li>
	<li>Lexicographically, <code>&quot;abcba&quot;</code> comes before <code>&quot;bacab&quot;</code>. Since <code>k = 1</code>, the output is <code>&quot;abcba&quot;</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
	<li><code>s</code> is guaranteed to be palindromic.</li>
	<li><code>1 &lt;= k &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The previous problem asked only for the smallest palindrome. Here we need the $k$-th distinct one, with $|s| \le 10^4$ and $k \le 10^6$, so listing every first-half permutation is impossible.
>
> The number of permutations of the remaining half-multiset is a product of binomial coefficients, capped above $k$. Try letters from left to right: keep a letter if the suffix still contains at least the remaining rank, otherwise subtract that count and try the next. Mirror the half and insert the middle character.

#### Java

```java
class Solution {
    private static final int LIMIT = 1_000_001;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            ++freq[s.charAt(i) - 'a'];
        }
        int odd = 0;
        int mid = 26;
        for (int i = 0; i < 26; ++i) {
            if ((freq[i] & 1) == 1) {
                ++odd;
                mid = i;
            }
        }
        if (odd > 1) {
            return "";
        }
        int[] half = new int[26];
        int halfLen = 0;
        for (int i = 0; i < 26; ++i) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
        }
        if (k > countPermutations(half)) {
            return "";
        }
        char[] pal = new char[n];
        int rank = k;
        int pos = 0;
        for (int t = 0; t < halfLen; ++t) {
            for (int i = 0; i < 26; ++i) {
                if (half[i] == 0) {
                    continue;
                }
                --half[i];
                int suffix = countPermutations(half);
                if (suffix >= rank) {
                    pal[pos++] = (char) ('a' + i);
                    break;
                }
                rank -= suffix;
                ++half[i];
            }
        }
        if (mid < 26) {
            pal[halfLen] = (char) ('a' + mid);
        }
        for (int i = 0; i < halfLen; ++i) {
            pal[n - 1 - i] = pal[i];
        }
        return new String(pal);
    }

    private int countPermutations(int[] counts) {
        int remaining = 0;
        for (int c : counts) {
            remaining += c;
        }
        long perms = 1;
        for (int count : counts) {
            if (count == 0) {
                continue;
            }
            int selected = Math.min(count, remaining - count);
            long combos = 1;
            for (int step = 1; step <= selected; ++step) {
                combos = combos * (remaining - step + 1) / step;
                if (combos >= LIMIT) {
                    combos = LIMIT;
                    break;
                }
            }
            perms *= combos;
            if (perms >= LIMIT) {
                return LIMIT;
            }
            remaining -= count;
        }
        return (int) perms;
    }
}
```
