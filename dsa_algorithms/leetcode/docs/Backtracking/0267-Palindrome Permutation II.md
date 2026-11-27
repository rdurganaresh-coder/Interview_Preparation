# 267. Palindrome Permutation II

**Difficulty:** Medium  
**Category:** Backtracking  
**LeetCode:** https://leetcode.com/problems/palindrome-permutation-ii/

---

[中文文档](/solution/0200-0299/0267.Palindrome%20Permutation%20II/README.md)

## Description

<p>Given a string s, return <em>all the palindromic permutations (without duplicates) of it</em>.</p>

<p>You may return the answer in <strong>any order</strong>. If <code>s</code> has no palindromic permutation, return an empty list.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "aabb"
<strong>Output:</strong> ["abba","baab"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "abc"
<strong>Output:</strong> []
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 16</code></li>
	<li><code>s</code> consists of only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> First check that at most one character has an odd count. Keep that character (if any) as the center and grow pairs outward.
>
> $\textit{dfs}(t)$ picks a letter that still has two copies, wraps it around $t$, and stops when the length matches $s$.

#### Java

```java
class Solution {
    private List<String> ans = new ArrayList<>();
    private int[] cnt = new int[26];
    private int n;

    public List<String> generatePalindromes(String s) {
        n = s.length();
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        String mid = "";
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] % 2 == 1) {
                if (!"".equals(mid)) {
                    return ans;
                }
                mid = String.valueOf((char) (i + 'a'));
            }
        }
        dfs(mid);
        return ans;
    }

    private void dfs(String t) {
        if (t.length() == n) {
            ans.add(t);
            return;
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 1) {
                String c = String.valueOf((char) (i + 'a'));
                cnt[i] -= 2;
                dfs(c + t + c);
                cnt[i] += 2;
            }
        }
    }
}
```
