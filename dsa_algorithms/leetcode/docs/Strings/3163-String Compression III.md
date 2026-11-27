# 3163. String Compression III

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/string-compression-iii/

---

[中文文档](/solution/3100-3199/3163.String%20Compression%20III/README.md)

## Description

<p>Given a string <code>word</code>, compress it using the following algorithm:</p>

<ul>
	<li>Begin with an empty string <code>comp</code>. While <code>word</code> is <strong>not</strong> empty, use the following operation:
    <ul>
    	<li>Remove a maximum length prefix of <code>word</code> made of a <em>single character</em> <code>c</code> repeating <strong>at most</strong> 9 times.</li>
    	<li>Append the length of the prefix followed by <code>c</code> to <code>comp</code>.</li>
    </ul>
    </li>
</ul>

<p>Return the string <code>comp</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;abcde&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;1a1b1c1d1e&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Initially, <code>comp = &quot;&quot;</code>. Apply the operation 5 times, choosing <code>&quot;a&quot;</code>, <code>&quot;b&quot;</code>, <code>&quot;c&quot;</code>, <code>&quot;d&quot;</code>, and <code>&quot;e&quot;</code> as the prefix in each operation.</p>

<p>For each prefix, append <code>&quot;1&quot;</code> followed by the character to <code>comp</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word = &quot;aaaaaaaaaaaaaabb&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;9a5a2b&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Initially, <code>comp = &quot;&quot;</code>. Apply the operation 3 times, choosing <code>&quot;aaaaaaaaa&quot;</code>, <code>&quot;aaaaa&quot;</code>, and <code>&quot;bb&quot;</code> as the prefix in each operation.</p>

<ul>
	<li>For prefix <code>&quot;aaaaaaaaa&quot;</code>, append <code>&quot;9&quot;</code> followed by <code>&quot;a&quot;</code> to <code>comp</code>.</li>
	<li>For prefix <code>&quot;aaaaa&quot;</code>, append <code>&quot;5&quot;</code> followed by <code>&quot;a&quot;</code> to <code>comp</code>.</li>
	<li>For prefix <code>&quot;bb&quot;</code>, append <code>&quot;2&quot;</code> followed by <code>&quot;b&quot;</code> to <code>comp</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>word</code> consists only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> Compression writes a count (at most $9$) plus the character for each run. Manual indices often mishandle splits at $9$.
>
> `groupby` already yields runs; each run is then cut into chunks of size at most $9$.
>
> For a run of length $k$ append `str(x)+c` with $x=\min(9,k)$ until $k$ is exhausted.

We can use two pointers to count the consecutive occurrences of each character. Suppose the current character $c$ appears consecutively $k$ times, then we divide $k$ into several $x$, each $x$ is at most $9$, then we concatenate $x$ and $c$, and append each $x$ and $c$ to the result.

Finally, return the result.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $\textit{word}$.

#### Java

```java
class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();
        int n = word.length();
        for (int i = 0; i < n;) {
            int j = i + 1;
            while (j < n && word.charAt(j) == word.charAt(i)) {
                ++j;
            }
            int k = j - i;
            while (k > 0) {
                int x = Math.min(9, k);
                ans.append(x).append(word.charAt(i));
                k -= x;
            }
            i = j;
        }
        return ans.toString();
    }
}
```

### Solution 2: Two Pointers

> **Thinking**
>
> Method 1 uses a grouping helper. Two pointers can cut on a letter change or when the run reaches $9$, without intermediate lists.
>
> Keep the run start $j$. When $i$ hits the end, a new letter, or length $9$, emit $i-j$ and $\textit{word}[j]$ and set $j=i$.
>
> The scan ends at $n$. Same linear bound, closer to the “at most nine” wording.

### Solution 3: RegExp

> **Thinking**
>
> Two pointers still encode the split by hand. The pattern `(.)\1{0,8}` matches one to nine equal characters.
>
> A global search swallows each such run; the count is the match length.
>
> Append `len(m[0])` and the captured letter. The result matches the previous methods with less arithmetic.
