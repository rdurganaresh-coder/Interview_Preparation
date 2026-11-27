# 1763. Longest Nice Substring

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/longest-nice-substring/

---

[中文文档](/solution/1700-1799/1763.Longest%20Nice%20Substring/README.md)

## Description

<p>A string <code>s</code> is <strong>nice</strong> if, for every letter of the alphabet that <code>s</code> contains, it appears <strong>both</strong> in uppercase and lowercase. For example, <code>&quot;abABB&quot;</code> is nice because <code>&#39;A&#39;</code> and <code>&#39;a&#39;</code> appear, and <code>&#39;B&#39;</code> and <code>&#39;b&#39;</code> appear. However, <code>&quot;abA&quot;</code> is not because <code>&#39;b&#39;</code> appears, but <code>&#39;B&#39;</code> does not.</p>

<p>Given a string <code>s</code>, return <em>the longest <strong>substring</strong> of <code>s</code> that is <strong>nice</strong>. If there are multiple, return the substring of the <strong>earliest</strong> occurrence. If there are none, return an empty string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;YazaAay&quot;
<strong>Output:</strong> &quot;aAa&quot;
<strong>Explanation: </strong>&quot;aAa&quot; is a nice string because &#39;A/a&#39; is the only letter of the alphabet in s, and both &#39;A&#39; and &#39;a&#39; appear.
&quot;aAa&quot; is the longest nice substring.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;Bb&quot;
<strong>Output:</strong> &quot;Bb&quot;
<strong>Explanation:</strong> &quot;Bb&quot; is a nice string because both &#39;B&#39; and &#39;b&#39; appear. The whole string is a substring.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;c&quot;
<strong>Output:</strong> &quot;&quot;
<strong>Explanation:</strong> There are no nice substrings.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists of uppercase and lowercase English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A nice substring contains both cases of every letter that appears. $n$ is small enough to try all substrings.
>
> Fix the left end $i$, extend rightward, and store characters in a set. When every letter has both cases and the window is longer, record it. Ties keep the earlier substring.

#### Java

```java
class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int k = -1;
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            Set<Character> ss = new HashSet<>();
            for (int j = i; j < n; ++j) {
                ss.add(s.charAt(j));
                boolean ok = true;
                for (char a : ss) {
                    char b = (char) (a ^ 32);
                    if (!(ss.contains(a) && ss.contains(b))) {
                        ok = false;
                        break;
                    }
                }
                if (ok && mx < j - i + 1) {
                    mx = j - i + 1;
                    k = i;
                }
            }
        }
        return k == -1 ? "" : s.substring(k, k + mx);
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 scans the set for each window, paying an extra $C$ factor. With $26$ letters, two bitmasks for lower and upper case suffice; the window is nice iff the masks are equal.

#### Java

```java
class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int k = -1;
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            int lower = 0, upper = 0;
            for (int j = i; j < n; ++j) {
                char c = s.charAt(j);
                if (Character.isLowerCase(c)) {
                    lower |= 1 << (c - 'a');
                } else {
                    upper |= 1 << (c - 'A');
                }
                if (lower == upper && mx < j - i + 1) {
                    mx = j - i + 1;
                    k = i;
                }
            }
        }
        return k == -1 ? "" : s.substring(k, k + mx);
    }
}
```
