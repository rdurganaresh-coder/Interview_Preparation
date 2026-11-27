# 1092. Shortest Common Supersequence

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/shortest-common-supersequence/

---

[中文文档](/solution/1000-1099/1092.Shortest%20Common%20Supersequence/README.md)

## Description

<p>Given two strings <code>str1</code> and <code>str2</code>, return <em>the shortest string that has both </em><code>str1</code><em> and </em><code>str2</code><em> as <strong>subsequences</strong></em>. If there are multiple valid strings, return <strong>any</strong> of them.</p>

<p>A string <code>s</code> is a <strong>subsequence</strong> of string <code>t</code> if deleting some number of characters from <code>t</code> (possibly <code>0</code>) results in the string <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> str1 = &quot;abac&quot;, str2 = &quot;cab&quot;
<strong>Output:</strong> &quot;cabac&quot;
<strong>Explanation:</strong> 
str1 = &quot;abac&quot; is a subsequence of &quot;cabac&quot; because we can delete the first &quot;c&quot;.
str2 = &quot;cab&quot; is a subsequence of &quot;cabac&quot; because we can delete the last &quot;ac&quot;.
The answer provided is the shortest such string that satisfies these properties.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> str1 = &quot;aaaaaaaa&quot;, str2 = &quot;aaaaaaaa&quot;
<strong>Output:</strong> &quot;aaaaaaaa&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= str1.length, str2.length &lt;= 1000</code></li>
	<li><code>str1</code> and <code>str2</code> consist of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The SCS length is $|s_1|+|s_2|-\textit{LCS}$. $m,n\le 1000$: build the LCS table, then walk the transitions backward, inserting the characters that are not shared.
>
> $f[i][j]$ is the LCS of the two prefixes. From $(m,n)$, a move from above or the left emits the discarded character; an equal pair emits the common character and steps diagonally.
>
> The walk collects the reverse of the SCS; leftover characters on one side are appended when the other index hits zero.

#### Java

```java
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        int i = m, j = n;
        StringBuilder ans = new StringBuilder();
        while (i > 0 || j > 0) {
            if (i == 0) {
                ans.append(str2.charAt(--j));
            } else if (j == 0) {
                ans.append(str1.charAt(--i));
            } else {
                if (f[i][j] == f[i - 1][j]) {
                    ans.append(str1.charAt(--i));
                } else if (f[i][j] == f[i][j - 1]) {
                    ans.append(str2.charAt(--j));
                } else {
                    ans.append(str1.charAt(--i));
                    --j;
                }
            }
        }
        return ans.reverse().toString();
    }
}
```
