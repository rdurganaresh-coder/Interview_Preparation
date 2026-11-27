# 187. Repeated DNA Sequences

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/repeated-dna-sequences/

---

[中文文档](/solution/0100-0199/0187.Repeated%20DNA%20Sequences/README.md)

## Description

<p>The <strong>DNA sequence</strong> is composed of a series of nucleotides abbreviated as <code>&#39;A&#39;</code>, <code>&#39;C&#39;</code>, <code>&#39;G&#39;</code>, and <code>&#39;T&#39;</code>.</p>

<ul>
	<li>For example, <code>&quot;ACGAATTCCG&quot;</code> is a <strong>DNA sequence</strong>.</li>
</ul>

<p>When studying <strong>DNA</strong>, it is useful to identify repeated sequences within the DNA.</p>

<p>Given a string <code>s</code> that represents a <strong>DNA sequence</strong>, return all the <strong><code>10</code>-letter-long</strong> sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
<strong>Output:</strong> ["AAAAACCCCC","CCCCCAAAAA"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "AAAAAAAAAAAAA"
<strong>Output:</strong> ["AAAAAAAAAA"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either <code>&#39;A&#39;</code>, <code>&#39;C&#39;</code>, <code>&#39;G&#39;</code>, or <code>&#39;T&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Hash Table

> **Thinking**
>
> Length-$10$ substrings that appear at least twice. $n\le 10^5$, so pairwise comparison of all windows is impossible. Slide $s[i..i+9]$, count in a hash map, and append a string the second time it appears.

We define a hash table $\textit{cnt}$ to store the occurrence count of all substrings of length $10$.

We iterate through all substrings of length $10$ in the string $s$. For the current substring $t$, we update its count in the hash table. If the count of $t$ is $2$, we add it to the answer.

After the iteration, we return the answer array.

The time complexity is $O(10n)$, and the space complexity is $O(10n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> cnt = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - 10 + 1; ++i) {
            String t = s.substring(i, i + 10);
            if (cnt.merge(t, 1, Integer::sum) == 2) {
                ans.add(t);
            }
        }
        return ans;
    }
}
```

### Solution 2: Rabin-Karp String Matching Algorithm

> **Thinking**
>
> Solution 1 hashes a length-$10$ slice every step. The alphabet has four letters, so the window is an integer; rolling it in and out is $O(1)$ per step and the total time is $O(n)$.

This method essentially combines sliding window and hash. Similar to 0028. Find the Index of the First Occurrence in a String, this problem can use a hash function to reduce the time complexity of counting subsequences to $O(1)$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.
