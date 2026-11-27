# 3121. Count the Number of Special Characters II

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/count-the-number-of-special-characters-ii/

---

[中文文档](/solution/3100-3199/3121.Count%20the%20Number%20of%20Special%20Characters%20II/README.md)

## Description

<p>You are given a string <code>word</code>. A letter&nbsp;<code>c</code> is called <strong>special</strong> if it appears <strong>both</strong> in lowercase and uppercase in <code>word</code>, and <strong>every</strong> lowercase occurrence of <code>c</code> appears before the <strong>first</strong> uppercase occurrence of <code>c</code>.</p>

<p>Return the number of<em> </em><strong>special</strong> letters<em> </em>in<em> </em><code>word</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;aaAbcBC&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The special characters are <code>&#39;a&#39;</code>, <code>&#39;b&#39;</code>, and <code>&#39;c&#39;</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;abc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>There are no special characters in <code>word</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;AbBCab&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>There are no special characters in <code>word</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>word</code> consists of only lowercase and uppercase English letters.</li>
</ul>

## Solutions

### Solution 1: Hash Table or Array

> **Thinking**
>
> Here every lowercase occurrence must also precede the first uppercase of that letter. Existence alone would accept a late lowercase.
>
> It suffices to compare the last lowercase index with the first uppercase index, both obtainable in one scan.
>
> Record $\textit{first}$ and $\textit{last}$ while walking $\textit{word}$, then count letters whose last lower index is strictly left of the first upper index.

We define two hash tables or arrays $\textit{first}$ and $\textit{last}$ to store the positions where each letter first appears and last appears respectively.

Then we traverse the string $\textit{word}$, updating $\textit{first}$ and $\textit{last}$.

Finally, we traverse all lowercase and uppercase letters. If `last[a]` exists and `first[b]` exists and `last[a] < first[b]`, it means that the letter `a` is a special letter, and we increment the answer by one.

The time complexity is $O(n + |\Sigma|)$, and the space complexity is $O(|\Sigma|)$, where $n$ is the length of the string $\textit{word}$, and $|\Sigma|$ is the size of the character set. In this problem, $|\Sigma| \leq 128$.

#### Java

```java
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] first = new int['z' + 1];
        int[] last = new int['z' + 1];
        for (int i = 1; i <= word.length(); ++i) {
            int j = word.charAt(i - 1);
            if (first[j] == 0) {
                first[j] = i;
            }
            last[j] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            int a = 'a' + i;
            int b = 'A' + i;
            if (last[a] > 0 && last[a] < first[b]) {
                ++ans;
            }
        }
        return ans;
    }
}
```
