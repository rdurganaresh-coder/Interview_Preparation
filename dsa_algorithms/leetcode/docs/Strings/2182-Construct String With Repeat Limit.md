# 2182. Construct String With Repeat Limit

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/construct-string-with-repeat-limit/

---

[中文文档](/solution/2100-2199/2182.Construct%20String%20With%20Repeat%20Limit/README.md)

## Description

<p>You are given a string <code>s</code> and an integer <code>repeatLimit</code>. Construct a new string <code>repeatLimitedString</code> using the characters of <code>s</code> such that no letter appears <strong>more than</strong> <code>repeatLimit</code> times <strong>in a row</strong>. You do <strong>not</strong> have to use all characters from <code>s</code>.</p>

<p>Return <em>the <strong>lexicographically largest</strong> </em><code>repeatLimitedString</code> <em>possible</em>.</p>

<p>A string <code>a</code> is <strong>lexicographically larger</strong> than a string <code>b</code> if in the first position where <code>a</code> and <code>b</code> differ, string <code>a</code> has a letter that appears later in the alphabet than the corresponding letter in <code>b</code>. If the first <code>min(a.length, b.length)</code> characters do not differ, then the longer string is the lexicographically larger one.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cczazcc&quot;, repeatLimit = 3
<strong>Output:</strong> &quot;zzcccac&quot;
<strong>Explanation:</strong> We use all of the characters from s to construct the repeatLimitedString &quot;zzcccac&quot;.
The letter &#39;a&#39; appears at most 1 time in a row.
The letter &#39;c&#39; appears at most 3 times in a row.
The letter &#39;z&#39; appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return &quot;zzcccac&quot;.
Note that the string &quot;zzcccca&quot; is lexicographically larger but the letter &#39;c&#39; appears more than 3 times in a row, so it is not a valid repeatLimitedString.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aababab&quot;, repeatLimit = 2
<strong>Output:</strong> &quot;bbabaa&quot;
<strong>Explanation:</strong> We use only some of the characters from s to construct the repeatLimitedString &quot;bbabaa&quot;. 
The letter &#39;a&#39; appears at most 2 times in a row.
The letter &#39;b&#39; appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return &quot;bbabaa&quot;.
Note that the string &quot;bbabaaa&quot; is lexicographically larger but the letter &#39;a&#39; appears more than 2 times in a row, so it is not a valid repeatLimitedString.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= repeatLimit &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Greedy Algorithm

> **Thinking**
>
> Use as many characters as possible, greedily large in lexicographic order, without more than $\textit{repeatLimit}$ identical letters in a row. Always emit the current largest remaining letter, and when the cap is hit insert one strictly smaller letter.
>
> Count the $26$ letters and scan from `z` to `a`. Pointer $j$ tracks a smaller letter that still remains. Emit up to $\textit{repeatLimit}$ copies of $i$, then one $j$ if $i$ is leftover.
>
> $j$ only moves left, so the cost is linear in the length and the alphabet.

First, we use an array $\textit{cnt}$ of length $26$ to count the number of occurrences of each character in string $s$. Then, we enumerate the $i$th letter of the alphabet in descending order, each time taking out at most $\min(\textit{cnt}[i], \textit{repeatLimit})$ of letter $i$. If after taking them out $\textit{cnt}[i]$ is still greater than $0$, we continue to take the $j$th letter of the alphabet, where $j$ is the largest index satisfying $j < i$ and $\textit{cnt}[j] > 0$, until all letters are taken.

The time complexity is $O(n + |\Sigma|)$, and the space complexity is $O(|\Sigma|)$, where $n$ is the length of string $s$, and $\Sigma$ is the character set. In this problem, $|\Sigma| = 26$.

#### Java

```java
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 25, j = 24; i >= 0; --i) {
            j = Math.min(j, i - 1);
            while (true) {
                for (int k = Math.min(cnt[i], repeatLimit); k > 0; --k) {
                    ans.append((char) ('a' + i));
                    --cnt[i];
                }
                if (cnt[i] == 0) {
                    break;
                }
                while (j >= 0 && cnt[j] == 0) {
                    --j;
                }
                if (j < 0) {
                    break;
                }
                ans.append((char) ('a' + j));
                --cnt[j];
            }
        }
        return ans.toString();
    }
}
```
