# 291. Word Pattern II

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/word-pattern-ii/

---

[中文文档](/solution/0200-0299/0291.Word%20Pattern%20II/README.md)

## Description

<p>Given a <code>pattern</code> and a string <code>s</code>, return <code>true</code><em> if </em><code>s</code><em> <strong>matches</strong> the </em><code>pattern</code><em>.</em></p>

<p>A string <code>s</code> <b>matches</b> a <code>pattern</code> if there is some <strong>bijective mapping</strong> of single characters to <strong>non-empty</strong> strings such that if each character in <code>pattern</code> is replaced by the string it maps to, then the resulting string is <code>s</code>. A <strong>bijective mapping</strong> means that no two characters map to the same string, and no character maps to two different strings.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> pattern = &quot;abab&quot;, s = &quot;redblueredblue&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> One possible mapping is as follows:
&#39;a&#39; -&gt; &quot;red&quot;
&#39;b&#39; -&gt; &quot;blue&quot;</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> pattern = &quot;aaaa&quot;, s = &quot;asdasdasdasd&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> One possible mapping is as follows:
&#39;a&#39; -&gt; &quot;asd&quot;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> pattern = &quot;aabb&quot;, s = &quot;xyzabcxzyabc&quot;
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= pattern.length, s.length &lt;= 20</code></li>
	<li><code>pattern</code> and <code>s</code> consist of only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A pattern character may match a substring of any length, so we cannot split on spaces. We enumerate those substrings under a bijection.
>
> $\textit{dfs}(i,j)$ tries $s[j..k]$ for $\textit{pattern}[i]$: reuse an existing mapping if it matches, otherwise bind an unused substring and backtrack on failure.

#### Java

```java
class Solution {
    private Set<String> vis;
    private Map<Character, String> d;
    private String p;
    private String s;
    private int m;
    private int n;

    public boolean wordPatternMatch(String pattern, String s) {
        vis = new HashSet<>();
        d = new HashMap<>();
        this.p = pattern;
        this.s = s;
        m = p.length();
        n = s.length();
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i == m && j == n) {
            return true;
        }
        if (i == m || j == n || m - i > n - j) {
            return false;
        }
        char c = p.charAt(i);
        for (int k = j + 1; k <= n; ++k) {
            String t = s.substring(j, k);
            if (d.getOrDefault(c, "").equals(t)) {
                if (dfs(i + 1, k)) {
                    return true;
                }
            }
            if (!d.containsKey(c) && !vis.contains(t)) {
                d.put(c, t);
                vis.add(t);
                if (dfs(i + 1, k)) {
                    return true;
                }
                vis.remove(t);
                d.remove(c);
            }
        }
        return false;
    }
}
```
