# 1044. Longest Duplicate Substring

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/longest-duplicate-substring/

---

[中文文档](/solution/1000-1099/1044.Longest%20Duplicate%20Substring/README.md)

## Description

<p>Given a string <code>s</code>, consider all <em>duplicated substrings</em>: (contiguous) substrings of s that occur 2 or more times.&nbsp;The occurrences&nbsp;may overlap.</p>

<p>Return <strong>any</strong> duplicated&nbsp;substring that has the longest possible length.&nbsp;If <code>s</code> does not have a duplicated substring, the answer is <code>&quot;&quot;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "banana"
<strong>Output:</strong> "ana"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "abcd"
<strong>Output:</strong> ""
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Inserting every substring into a set is quadratic and fails for $n\le 3\times 10^4$. If a duplicate of length $L$ exists, shorter duplicates exist as well, so length is monotonic.
>
> Binary search the length. The check inserts every slice of length $\textit{mid}$ into a set and returns on the first collision. A hit tries a longer length; a miss shortens it.
>
> The implementation uses ordinary Python slices and a hash set, remembering the last hit as the answer.

#### Java

```java
class Solution {
    private long[] p;
    private long[] h;

    public String longestDupSubstring(String s) {
        int base = 131;
        int n = s.length();
        p = new long[n + 10];
        h = new long[n + 10];
        p[0] = 1;
        for (int i = 0; i < n; ++i) {
            p[i + 1] = p[i] * base;
            h[i + 1] = h[i] * base + s.charAt(i);
        }
        String ans = "";
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            String t = check(s, mid);
            if (t.length() > 0) {
                left = mid;
                ans = t;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private String check(String s, int len) {
        int n = s.length();
        Set<Long> vis = new HashSet<>();
        for (int i = 1; i + len - 1 <= n; ++i) {
            int j = i + len - 1;
            long t = h[j] - h[i - 1] * p[j - i + 1];
            if (vis.contains(t)) {
                return s.substring(i - 1, j);
            }
            vis.add(t);
        }
        return "";
    }
}
```
