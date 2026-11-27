# 1461. Check If a String Contains All Binary Codes of Size K

**Difficulty:** Medium  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

---

[中文文档](/solution/1400-1499/1461.Check%20If%20a%20String%20Contains%20All%20Binary%20Codes%20of%20Size%20K/README.md)

## Description

<p>Given a binary string <code>s</code> and an integer <code>k</code>, return <code>true</code> <em>if every binary code of length</em> <code>k</code> <em>is a substring of</em> <code>s</code>. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;00110110&quot;, k = 2
<strong>Output:</strong> true
<strong>Explanation:</strong> The binary codes of length 2 are &quot;00&quot;, &quot;01&quot;, &quot;10&quot; and &quot;11&quot;. They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;0110&quot;, k = 1
<strong>Output:</strong> true
<strong>Explanation:</strong> The binary codes of length 1 are &quot;0&quot; and &quot;1&quot;, it is clear that both exist as a substring. 
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;0110&quot;, k = 2
<strong>Output:</strong> false
<strong>Explanation:</strong> The binary code &quot;00&quot; is of length 2 and does not exist in the array.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
	<li><code>1 &lt;= k &lt;= 20</code></li>
</ul>

## Solutions

### Solution 1: Hash Table

> **Thinking**
>
> There are $2^k$ binary strings of length $k$, and $k\le 20$. If $s$ has fewer than $2^k$ windows, fail; otherwise collect every length-$k$ substring and test the set size.

First, for a string $s$ of length $n$, the number of substrings of length $k$ is $n - k + 1$. If $n - k + 1 < 2^k$, then there must exist a binary string of length $k$ that is not a substring of $s$, so we return `false`.

Next, we traverse the string $s$ and store all substrings of length $k$ in a set $ss$. Finally, we check if the size of the set $ss$ is equal to $2^k$.

The time complexity is $O(nk)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int m = 1 << k;
        if (n - k + 1 < m) {
            return false;
        }
        Set<String> ss = new HashSet<>();
        for (int i = 0; i < n - k + 1; ++i) {
            ss.add(s.substring(i, i + k));
        }
        return ss.size() == m;
    }
}
```

### Solution 2: Sliding Window

> **Thinking**
>
> Method 1 copies $k$ characters per window. Treat the window as an integer, shift in the new bit and drop the high bit, and insert in $O(1)$.

In Solution 1, we stored all distinct substrings of length $k$, and processing each substring requires $O(k)$ time. We can instead use a sliding window, where each time we add the latest character, we remove the leftmost character from the window. During this process, we use an integer $x$ to store the substring.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int m = 1 << k;
        if (n - k + 1 < m) {
            return false;
        }
        boolean[] ss = new boolean[m];
        int x = Integer.parseInt(s.substring(0, k), 2);
        ss[x] = true;
        for (int i = k; i < n; ++i) {
            int a = (s.charAt(i - k) - '0') << (k - 1);
            int b = s.charAt(i) - '0';
            x = (x - a) << 1 | b;
            ss[x] = true;
        }
        for (boolean v : ss) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
```
