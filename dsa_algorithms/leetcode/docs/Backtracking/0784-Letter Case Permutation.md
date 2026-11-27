# 784. Letter Case Permutation

**Difficulty:** Medium  
**Category:** Backtracking  
**LeetCode:** https://leetcode.com/problems/letter-case-permutation/

---

[中文文档](/solution/0700-0799/0784.Letter%20Case%20Permutation/README.md)

## Description

<p>Given a string <code>s</code>, you&nbsp;can transform every letter individually to be lowercase or uppercase to create another string.</p>

<p>Return <em>a list of all possible strings we could create</em>. Return the output in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;a1b2&quot;
<strong>Output:</strong> [&quot;a1b2&quot;,&quot;a1B2&quot;,&quot;A1b2&quot;,&quot;A1B2&quot;]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;3z4&quot;
<strong>Output:</strong> [&quot;3z4&quot;,&quot;3Z4&quot;]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 12</code></li>
	<li><code>s</code> consists of lowercase English letters, uppercase English letters, and digits.</li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> Each letter may flip case. The string is short, so DFS enumerates.
>
> At a letter, first continue unchanged, then xor $32$ and continue; digits have one branch. Collect at the end.

Since each letter in $s$ can be converted to uppercase or lowercase, we can use the DFS (Depth-First Search) method to enumerate all possible cases.

Specifically, traverse the string $s$ from left to right. For each letter encountered, you can choose to convert it to uppercase or lowercase, and then continue to traverse the subsequent letters. When you reach the end of the string, you get a conversion scheme and add it to the answer.

The method of converting case can be implemented using bitwise operations. For a letter, the difference between the ASCII codes of its lowercase and uppercase forms is $32$, so we can achieve case conversion by XORing the ASCII code of the letter with $32$.

The time complexity is $O(n 2^n)$, where $n$ is the length of the string $s$. For each letter, we can choose to convert it to uppercase or lowercase, so there are $2^n$ conversion schemes in total. For each conversion scheme, we need $O(n)$ time to generate a new string.

#### Java

```java
class Solution {
    private List<String> ans = new ArrayList<>();
    private char[] t;

    public List<String> letterCasePermutation(String s) {
        t = s.toCharArray();
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i >= t.length) {
            ans.add(new String(t));
            return;
        }
        dfs(i + 1);
        if (Character.isLetter(t[i])) {
            t[i] ^= 32;
            dfs(i + 1);
        }
    }
}
```

### Solution 2: Binary Enumeration

> **Thinking**
>
> There are exactly $2^n$ strings if $n$ letters appear. A bitmask can pick lower/upper for the $j$-th letter.
>
> For each mask, rewrite letters by that bit and copy digits.

For a letter, we can convert it to uppercase or lowercase. Therefore, for each letter, we can use a binary bit to represent its conversion scheme, where $1$ represents lowercase and $0$ represents uppercase.

First, we count the number of letters in the string $s$, denoted as $n$. Then, there are $2^n$ conversion schemes in total. We can use each bit of a binary number to represent the conversion scheme of each letter, enumerating from $0$ to $2^n-1$.

Specifically, we can use a variable $i$ to represent the current binary number being enumerated, where the $j$-th bit of $i$ represents the conversion scheme of the $j$-th letter. That is, the $j$-th bit of $i$ being $1$ means the $j$-th letter is converted to lowercase, and $0$ means the $j$-th letter is converted to uppercase.

The time complexity is $O(n 2^n)$, where $n$ is the length of the string $s$. For each letter, we can choose to convert it to uppercase or lowercase, so there are $2^n$ conversion schemes in total. For each conversion scheme, we need $O(n)$ time to generate a new string.

#### Java

```java
class Solution {
    public List<String> letterCasePermutation(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= 'A') {
                ++n;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            int j = 0;
            StringBuilder t = new StringBuilder();
            for (int k = 0; k < s.length(); ++k) {
                char x = s.charAt(k);
                if (x >= 'A') {
                    x = ((i >> j) & 1) == 1 ? Character.toLowerCase(x) : Character.toUpperCase(x);
                    ++j;
                }
                t.append(x);
            }
            ans.add(t.toString());
        }
        return ans;
    }
}
```
