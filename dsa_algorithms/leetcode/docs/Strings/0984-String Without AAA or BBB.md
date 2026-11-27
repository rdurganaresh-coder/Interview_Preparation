# 984. String Without AAA or BBB

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/string-without-aaa-or-bbb/

---

[中文文档](/solution/0900-0999/0984.String%20Without%20AAA%20or%20BBB/README.md)

## Description

<p>Given two integers <code>a</code> and <code>b</code>, return <strong>any</strong> string <code>s</code> such that:</p>

<ul>
	<li><code>s</code> has length <code>a + b</code> and contains exactly <code>a</code> <code>&#39;a&#39;</code> letters, and exactly <code>b</code> <code>&#39;b&#39;</code> letters,</li>
	<li>The substring <code>&#39;aaa&#39;</code> does not occur in <code>s</code>, and</li>
	<li>The substring <code>&#39;bbb&#39;</code> does not occur in <code>s</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> a = 1, b = 2
<strong>Output:</strong> &quot;abb&quot;
<strong>Explanation:</strong> &quot;abb&quot;, &quot;bab&quot; and &quot;bba&quot; are all correct answers.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> a = 4, b = 1
<strong>Output:</strong> &quot;aabaa&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= a, b &lt;= 100</code></li>
	<li>It is guaranteed such an <code>s</code> exists for the given <code>a</code> and <code>b</code>.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Build a string with $a$ `'a'`s and $b$ `'b'`s that avoids `aaa`/`bbb`. The more frequent letter should be emitted in pairs, separated by the rarer one, so it does not clump. Append `aab` when $a>b$, `bba` when $b>a$, `ab` when equal, then the leftover singles.

#### Java

```java
class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder ans = new StringBuilder();
        while (a > 0 && b > 0) {
            if (a > b) {
                ans.append("aab");
                a -= 2;
                b -= 1;
            } else if (a < b) {
                ans.append("bba");
                a -= 1;
                b -= 2;
            } else {
                ans.append("ab");
                --a;
                --b;
            }
        }
        if (a > 0) {
            ans.append("a".repeat(a));
        }
        if (b > 0) {
            ans.append("b".repeat(b));
        }
        return ans.toString();
    }
}
```
