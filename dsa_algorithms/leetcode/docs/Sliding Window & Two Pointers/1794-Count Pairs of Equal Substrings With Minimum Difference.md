# 1794. Count Pairs of Equal Substrings With Minimum Difference

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/count-pairs-of-equal-substrings-with-minimum-difference/

---

[中文文档](/solution/1700-1799/1794.Count%20Pairs%20of%20Equal%20Substrings%20With%20Minimum%20Difference/README.md)

## Description

<p>You are given two strings <code>firstString</code> and <code>secondString</code> that are <strong>0-indexed</strong> and consist only of lowercase English letters. Count the number of index quadruples <code>(i,j,a,b)</code> that satisfy the following conditions:</p>

<ul>
	<li><code>0 &lt;= i &lt;= j &lt; firstString.length</code></li>
	<li><code>0 &lt;= a &lt;= b &lt; secondString.length</code></li>
	<li>The substring of <code>firstString</code> that starts at the <code>i<sup>th</sup></code> character and ends at the <code>j<sup>th</sup></code> character (inclusive) is <strong>equal</strong> to the substring of <code>secondString</code> that starts at the <code>a<sup>th</sup></code> character and ends at the <code>b<sup>th</sup></code> character (inclusive).</li>
	<li><code>j - a</code> is the <strong>minimum</strong> possible value among all quadruples that satisfy the previous conditions.</li>
</ul>

<p>Return <em>the <strong>number</strong> of such quadruples</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> firstString = &quot;abcd&quot;, secondString = &quot;bccda&quot;
<strong>Output:</strong> 1
<strong>Explanation:</strong> The quadruple (0,0,4,4) is the only one that satisfies all the conditions and minimizes j - a.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> firstString = &quot;ab&quot;, secondString = &quot;cd&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no quadruples satisfying all the conditions.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= firstString.length, secondString.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li>Both strings consist only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Greedy + Hash Table

> **Thinking**
>
> A valid quadruple needs equal substrings and minimal $j-a$. Equality collapses to a single character: the leftmost occurrence in $\textit{firstString}$ paired with the rightmost same character in $\textit{secondString}$.
>
> Map each character of $\textit{secondString}$ to its last index. Walk $\textit{firstString}$ and update the global minimum of $i-\textit{last}[c]$ together with its multiplicity.

The problem actually asks us to find a smallest index $i$ and a largest index $j$ such that $\textit{firstString}[i]$ equals $\textit{secondString}[j]$, and the value of $i - j$ is the smallest among all index pairs that meet the conditions.

Therefore, we first use a hash table $\textit{last}$ to record the index of the last occurrence of each character in $\textit{secondString}$. Then we traverse $\textit{firstString}$. For each character $c$, if $c$ has appeared in $\textit{secondString}$, we calculate $i - \textit{last}[c]$. If the value of $i - \textit{last}[c]$ is less than the current minimum value, we update the minimum value and set the answer to 1. If the value of $i - \textit{last}[c]$ equals the current minimum value, we increment the answer by 1.

The time complexity is $O(m + n)$, and the space complexity is $O(C)$, where $m$ and $n$ are the lengths of $\textit{firstString}$ and $\textit{secondString}$ respectively, and $C$ is the size of the character set. In this problem, $C = 26$.

#### Java

```java
class Solution {
    public int countQuadruples(String firstString, String secondString) {
        int[] last = new int[26];
        for (int i = 0; i < secondString.length(); ++i) {
            last[secondString.charAt(i) - 'a'] = i + 1;
        }
        int ans = 0, mi = 1 << 30;
        for (int i = 0; i < firstString.length(); ++i) {
            int j = last[firstString.charAt(i) - 'a'];
            if (j > 0) {
                int t = i - j;
                if (mi > t) {
                    mi = t;
                    ans = 1;
                } else if (mi == t) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
```
