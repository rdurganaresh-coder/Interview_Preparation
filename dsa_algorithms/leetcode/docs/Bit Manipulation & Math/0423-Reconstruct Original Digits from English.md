# 423. Reconstruct Original Digits from English

**Difficulty:** Medium  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/reconstruct-original-digits-from-english/

---

[中文文档](/solution/0400-0499/0423.Reconstruct%20Original%20Digits%20from%20English/README.md)

## Description

<p>Given a string <code>s</code> containing an out-of-order English representation of digits <code>0-9</code>, return <em>the digits in <strong>ascending</strong> order</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "owoztneoer"
<strong>Output:</strong> "012"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "fviefuro"
<strong>Output:</strong> "45"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is one of the characters <code>[&quot;e&quot;,&quot;g&quot;,&quot;f&quot;,&quot;i&quot;,&quot;h&quot;,&quot;o&quot;,&quot;n&quot;,&quot;s&quot;,&quot;r&quot;,&quot;u&quot;,&quot;t&quot;,&quot;w&quot;,&quot;v&quot;,&quot;x&quot;,&quot;z&quot;]</code>.</li>
	<li><code>s</code> is <strong>guaranteed</strong> to be valid.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> English digit words overlap, so matching words in order is unsafe. A few letters belong to only one digit.
>
> $\texttt{z}$ is unique to zero, $\texttt{w}$ to two, $\texttt{u}$ to four, $\texttt{x}$ to six, $\texttt{g}$ to eight. After subtracting those, $\texttt{h}$, $\texttt{f}$, $\texttt{s}$ give three, five, seven, and finally $\texttt{o}$ and $i$ give one and nine.
>
> Counting along that unique-letter order solves a triangular system; concatenate digits from $0$ to $9$.

#### Java

```java
class Solution {
    public String originalDigits(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            ++counter[c - 'a'];
        }
        int[] cnt = new int[10];
        cnt[0] = counter['z' - 'a'];
        cnt[2] = counter['w' - 'a'];
        cnt[4] = counter['u' - 'a'];
        cnt[6] = counter['x' - 'a'];
        cnt[8] = counter['g' - 'a'];

        cnt[3] = counter['h' - 'a'] - cnt[8];
        cnt[5] = counter['f' - 'a'] - cnt[4];
        cnt[7] = counter['s' - 'a'] - cnt[6];

        cnt[1] = counter['o' - 'a'] - cnt[0] - cnt[2] - cnt[4];
        cnt[9] = counter['i' - 'a'] - cnt[5] - cnt[6] - cnt[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
```
