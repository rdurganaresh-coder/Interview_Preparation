# 1180. Count Substrings with Only One Distinct Letter

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/

---

[中文文档](/solution/1100-1199/1180.Count%20Substrings%20with%20Only%20One%20Distinct%20Letter/README.md)

## Description

<p>Given a string <code>s</code>, return <em>the number of substrings that have only <strong>one distinct</strong> letter</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aaaba&quot;
<strong>Output:</strong> 8
<strong>Explanation: </strong>The substrings with one distinct letter are &quot;aaa&quot;, &quot;aa&quot;, &quot;a&quot;, &quot;b&quot;.
&quot;aaa&quot; occurs 1 time.
&quot;aa&quot; occurs 2 times.
&quot;a&quot; occurs 4 times.
&quot;b&quot; occurs 1 time.
So the answer is 1 + 2 + 4 + 1 = 8.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aaaaaaaaaa&quot;
<strong>Output:</strong> 55
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s[i]</code> consists of only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> A one-letter substring lies inside a run of equal characters. A run of length $L$ contributes $L(L+1)/2$ substrings. Two pointers measure each run and add the triangular number, instead of listing $O(n^2)$ substrings.

We can use two pointers, where pointer $i$ points to the start of the current substring, and pointer $j$ moves to the right to the first position that is different from $s[i]$. Then, $[i,..j-1]$ is a substring with $s[i]$ as the only character, and its length is $j-i$. Therefore, the number of substrings with $s[i]$ as the only character is $\frac{(j-i+1)(j-i)}{2}$, which is added to the answer. Then, we set $i=j$ and continue to traverse until $i$ exceeds the range of string $s$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int countLetters(String s) {
        int ans = 0;
        for (int i = 0, n = s.length(); i < n;) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                ++j;
            }
            ans += (1 + j - i) * (j - i) / 2;
            i = j;
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Method 1 adds a closed triangular number per run. Method 2 adds $1,2,\ldots,L$ while the run grows; the sum is the same triangle and reads as the number of one-letter substrings ending at the current index.

#### Java

```java
class Solution {
    public int countLetters(String s) {
        int ans = 0;
        int i = 0, n = s.length();
        while (i < n) {
            int j = i;
            int cnt = 0;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                ++j;
                ans += ++cnt;
            }
            i = j;
        }
        return ans;
    }
}
```
