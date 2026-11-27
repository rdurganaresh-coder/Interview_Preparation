# 1520. Maximum Number of Non-Overlapping Substrings

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/

---

[中文文档](/solution/1500-1599/1520.Maximum%20Number%20of%20Non-Overlapping%20Substrings/README.md)

## Description

<p>Given a string <code>s</code> of lowercase letters, you need to find the maximum number of <strong>non-empty</strong> substrings of <code>s</code> that meet the following conditions:</p>

<ol>
	<li>The substrings do not overlap, that is for any two substrings <code>s[i..j]</code> and <code>s[x..y]</code>, either <code>j &lt; x</code> or <code>i &gt; y</code> is true.</li>
	<li>A substring that contains a certain character <code>c</code> must also contain all occurrences of <code>c</code>.</li>
</ol>

<p>Find <em>the maximum number of substrings that meet the above conditions</em>. If there are multiple solutions with the same number of substrings, <em>return the one with minimum total length. </em>It can be shown that there exists a unique solution of minimum total length.</p>

<p>Notice that you can return the substrings in <strong>any</strong> order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;adefaddaccc&quot;
<strong>Output:</strong> [&quot;e&quot;,&quot;f&quot;,&quot;ccc&quot;]
<b>Explanation:</b>&nbsp;The following are all the possible substrings that meet the conditions:
[
&nbsp; &quot;adefaddaccc&quot;
&nbsp; &quot;adefadda&quot;,
&nbsp; &quot;ef&quot;,
&nbsp; &quot;e&quot;,
  &quot;f&quot;,
&nbsp; &quot;ccc&quot;,
]
If we choose the first string, we cannot choose anything else and we&#39;d get only 1. If we choose &quot;adefadda&quot;, we are left with &quot;ccc&quot; which is the only one that doesn&#39;t overlap, thus obtaining 2 substrings. Notice also, that it&#39;s not optimal to choose &quot;ef&quot; since it can be split into two. Therefore, the optimal way is to choose [&quot;e&quot;,&quot;f&quot;,&quot;ccc&quot;] which gives us 3 substrings. No other solution of the same number of substrings exist.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abbaccd&quot;
<strong>Output:</strong> [&quot;d&quot;,&quot;bb&quot;,&quot;cc&quot;]
<b>Explanation: </b>Notice that while the set of substrings [&quot;d&quot;,&quot;abba&quot;,&quot;cc&quot;] also has length 3, it&#39;s considered incorrect since it has larger total length.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Greedy

> **Thinking**
>
> We want as many non-overlapping substrings as possible, each containing every occurrence of the characters it uses. $n\le 10^5$, so we cannot test every substring.
>
> Each character has a first and last index. Starting from a left boundary, expand the interval to the rightmost occurrence of every character inside it, producing a minimal legal segment. These segments form an interval graph; picking them greedily by right endpoint maximizes the count and minimizes the total length.

We first use arrays or hash tables $\textit{first}$ and $\textit{last}$ to record the first and last occurrence of each letter in $s$.

Next, enumerate every letter $c$ that appears, taking $\textit{first}[c]$ as a candidate left bound $l$ and $\textit{last}[c]$ as the initial right bound $r$. Scan from $l$ to $r$. For each letter $ch$ encountered:

- If $\textit{first}[ch] < l$, this letter also occurs before $l$, so the current interval cannot cover all of its occurrences and is invalid;
- Otherwise update $r = \max(r, \textit{last}[ch])$ to include every occurrence of $ch$.

If the scan finishes successfully, we obtain a valid substring interval $[l, r]$.

These valid intervals can only be disjoint or nested; they never partially overlap. Therefore we sort them by right endpoint in ascending order and pick greedily: let $\textit{end}$ be the right endpoint of the last chosen interval, initially $-1$. Traverse the sorted intervals from left to right; if the current left endpoint is greater than $\textit{end}$, append the corresponding substring to the answer and update $\textit{end}$.

Sorting by right endpoint always chooses the interval that finishes earliest, so we obtain the maximum number of non-overlapping substrings. Nested shorter intervals have smaller right endpoints and are chosen first, so the total length is also minimized.

The time complexity is $O(n|\Sigma|)$, and the space complexity is $O(|\Sigma|)$, where $n$ is the length of $s$, and $|\Sigma|$ is the size of the character set. In this problem, $|\Sigma| = 26$.

#### Java

```java
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < n; ++i) {
            int x = s.charAt(i) - 'a';
            if (first[x] == -1) {
                first[x] = i;
            }
            last[x] = i;
        }
        List<int[]> segs = new ArrayList<>();
        for (int x = 0; x < 26; ++x) {
            if (first[x] == -1) {
                continue;
            }
            int l = first[x], r = last[x];
            int i = l;
            for (; i <= r; ++i) {
                int y = s.charAt(i) - 'a';
                if (first[y] < l) {
                    break;
                }
                r = Math.max(r, last[y]);
            }
            if (i > r) {
                segs.add(new int[] {l, r});
            }
        }
        segs.sort((a, b) -> a[1] - b[1]);
        List<String> ans = new ArrayList<>();
        int end = -1;
        for (int[] e : segs) {
            int l = e[0], r = e[1];
            if (l > end) {
                ans.add(s.substring(l, r + 1));
                end = r;
            }
        }
        return ans;
    }
}
```
