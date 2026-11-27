# 159. Longest Substring with At Most Two Distinct Characters

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

---

[中文文档](/solution/0100-0199/0159.Longest%20Substring%20with%20At%20Most%20Two%20Distinct%20Characters/README.md)

## Description

<p>Given a string <code>s</code>, return <em>the length of the longest </em><span data-keyword="substring-nonempty"><em>substring</em></span><em> that contains at most <strong>two distinct characters</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;eceba&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The substring is &quot;ece&quot; which its length is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ccaabbb&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> The substring is &quot;aabbb&quot; which its length is 5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Longest substring with at most two distinct characters. $n\le 10^5$, so enumerating endpoints is $O(n^2)$. The distinct count grows with the right end and shrinks with the left. Extend right while counting; when there are more than two kinds, move left. Update the answer on a valid window.

#### Java

```java
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        int n = s.length();
        int ans = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            char c = s.charAt(i);
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            while (cnt.size() > 2) {
                char t = s.charAt(j++);
                cnt.put(t, cnt.get(t) - 1);
                if (cnt.get(t) == 0) {
                    cnt.remove(t);
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
```
