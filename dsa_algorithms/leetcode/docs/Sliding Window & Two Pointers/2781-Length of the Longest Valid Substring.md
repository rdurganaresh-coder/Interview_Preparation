# 2781. Length of the Longest Valid Substring

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/length-of-the-longest-valid-substring/

---

[中文文档](/solution/2700-2799/2781.Length%20of%20the%20Longest%20Valid%20Substring/README.md)

## Description

<p>You are given a string <code>word</code> and an array of strings <code>forbidden</code>.</p>

<p>A string is called <strong>valid</strong> if none of its substrings are present in <code>forbidden</code>.</p>

<p>Return <em>the length of the <strong>longest valid substring</strong> of the string </em><code>word</code>.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters in a string, possibly empty.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> word = &quot;cbaaaabc&quot;, forbidden = [&quot;aaa&quot;,&quot;cb&quot;]
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 11 valid substrings in word: &quot;c&quot;, &quot;b&quot;, &quot;a&quot;, &quot;ba&quot;, &quot;aa&quot;, &quot;bc&quot;, &quot;baa&quot;, &quot;aab&quot;, &quot;ab&quot;, &quot;abc&quot; and &quot;aabc&quot;. The length of the longest valid substring is 4. 
It can be shown that all other substrings contain either &quot;aaa&quot; or &quot;cb&quot; as a substring. </pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> word = &quot;leetcode&quot;, forbidden = [&quot;de&quot;,&quot;le&quot;,&quot;e&quot;]
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 11 valid substrings in word: &quot;l&quot;, &quot;t&quot;, &quot;c&quot;, &quot;o&quot;, &quot;d&quot;, &quot;tc&quot;, &quot;co&quot;, &quot;od&quot;, &quot;tco&quot;, &quot;cod&quot;, and &quot;tcod&quot;. The length of the longest valid substring is 4.
It can be shown that all other substrings contain either &quot;de&quot;, &quot;le&quot;, or &quot;e&quot; as a substring. 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 10<sup>5</sup></code></li>
	<li><code>word</code> consists only of lowercase English letters.</li>
	<li><code>1 &lt;= forbidden.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= forbidden[i].length &lt;= 10</code></li>
	<li><code>forbidden[i]</code> consists only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A valid substring contains no forbidden string as a contiguous piece; we want the maximum length. Forbidden strings have length at most $10$, but $\textit{word}$ can be $10^5$, so every substring cannot be tested.
>
> As the right end $j$ advances, only suffixes that end at $j$, have length at most $10$, and still start to the right of the current left end need a set lookup. A hit moves the left end just past that forbidden piece. The longest window is the answer.

#### Java

```java
class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        var s = new HashSet<>(forbidden);
        int ans = 0, n = word.length();
        for (int i = 0, j = 0; j < n; ++j) {
            for (int k = j; k > Math.max(j - 10, i - 1); --k) {
                if (s.contains(word.substring(k, j + 1))) {
                    i = k + 1;
                    break;
                }
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
```
