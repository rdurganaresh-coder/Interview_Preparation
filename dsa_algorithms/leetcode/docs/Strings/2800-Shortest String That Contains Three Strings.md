# 2800. Shortest String That Contains Three Strings

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/shortest-string-that-contains-three-strings/

---

[中文文档](/solution/2800-2899/2800.Shortest%20String%20That%20Contains%20Three%20Strings/README.md)

## Description

Given three strings <code>a</code>, <code>b</code>, and <code>c</code>, your task is to find a string that has the<strong> minimum</strong> length and contains all three strings as <strong>substrings</strong>.
<p>If there are multiple such strings, return the<em> </em><strong>lexicographically<em> </em>smallest </strong>one.</p>

<p>Return <em>a string denoting the answer to the problem.</em></p>

<p><strong>Notes</strong></p>

<ul>
	<li>A string <code>a</code> is <strong>lexicographically smaller</strong> than a string <code>b</code> (of the same length) if in the first position where <code>a</code> and <code>b</code> differ, string <code>a</code> has a letter that appears <strong>earlier </strong>in the alphabet than the corresponding letter in <code>b</code>.</li>
	<li>A <strong>substring</strong> is a contiguous sequence of characters within a string.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> a = &quot;abc&quot;, b = &quot;bca&quot;, c = &quot;aaa&quot;
<strong>Output:</strong> &quot;aaabca&quot;
<strong>Explanation:</strong>  We show that &quot;aaabca&quot; contains all the given strings: a = ans[2...4], b = ans[3..5], c = ans[0..2]. It can be shown that the length of the resulting string would be at least 6 and &quot;aaabca&quot; is the lexicographically smallest one.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> a = &quot;ab&quot;, b = &quot;ba&quot;, c = &quot;aba&quot;
<strong>Output:</strong> &quot;aba&quot;
<strong>Explanation: </strong>We show that the string &quot;aba&quot; contains all the given strings: a = ans[0..1], b = ans[1..2], c = ans[0..2]. Since the length of c is 3, the length of the resulting string would be at least 3. It can be shown that &quot;aba&quot; is the lexicographically smallest one.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= a.length, b.length, c.length &lt;= 100</code></li>
	<li><code>a</code>, <code>b</code>, <code>c</code> consist only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> Each string has length at most $100$, so all six concatenation orders can be tried. The answer must be shortest and then lexicographically smallest, so containment and overlap both matter. If one string already sits inside another, it need not be appended; otherwise an optimal superstring corresponds to some permutation merged in order. Function $f$ handles containment first, then searches the longest suffix–prefix overlap, and we keep the best string by length and order.

We enumerate all permutations of the three strings, and for each permutation, we merge the three strings to find the shortest string with the smallest lexicographical order.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the maximum length of the three strings.

#### Java

```java
class Solution {
    public String minimumString(String a, String b, String c) {
        String[] s = {a, b, c};
        int[][] perm = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 1, 0}, {2, 0, 1}};
        String ans = "";
        for (var p : perm) {
            int i = p[0], j = p[1], k = p[2];
            String t = f(f(s[i], s[j]), s[k]);
            if ("".equals(ans) || t.length() < ans.length()
                || (t.length() == ans.length() && t.compareTo(ans) < 0)) {
                ans = t;
            }
        }
        return ans;
    }

    private String f(String s, String t) {
        if (s.contains(t)) {
            return s;
        }
        if (t.contains(s)) {
            return t;
        }
        int m = s.length(), n = t.length();
        for (int i = Math.min(m, n); i > 0; --i) {
            if (s.substring(m - i).equals(t.substring(0, i))) {
                return s + t.substring(i);
            }
        }
        return s + t;
    }
}
```

### Solution 2: Enumeration + KMP

> **Thinking**
>
> Method 1 scans overlap lengths in $O(n^2)$ per merge. The KMP prefix function of $t\#s$ yields the longest prefix of $t$ that is a suffix of $s$, so each merge is linear while the permutation enumeration stays the same.

We can use the KMP algorithm to optimize the string merging process.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the sum of the lengths of the three strings.

#### Java

```java
class Solution {
    public String minimumString(String a, String b, String c) {
        String[] s = {a, b, c};
        int[][] perm = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 1, 0}, {2, 0, 1}};
        String ans = "";
        for (var p : perm) {
            int i = p[0], j = p[1], k = p[2];
            String t = f(f(s[i], s[j]), s[k]);
            if ("".equals(ans) || t.length() < ans.length()
                || (t.length() == ans.length() && t.compareTo(ans) < 0)) {
                ans = t;
            }
        }
        return ans;
    }

    private String f(String s, String t) {
        if (s.contains(t)) {
            return s;
        }
        if (t.contains(s)) {
            return t;
        }
        char[] p = (t + "#" + s + "$").toCharArray();
        int n = p.length;
        int[] next = new int[n];
        next[0] = -1;
        for (int i = 2, j = 0; i < n;) {
            if (p[i - 1] == p[j]) {
                next[i++] = ++j;
            } else if (j > 0) {
                j = next[j];
            } else {
                next[i++] = 0;
            }
        }
        return s + t.substring(next[n - 1]);
    }
}
```
