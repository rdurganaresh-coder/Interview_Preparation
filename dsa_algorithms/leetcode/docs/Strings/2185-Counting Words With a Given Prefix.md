# 2185. Counting Words With a Given Prefix

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/counting-words-with-a-given-prefix/

---

[中文文档](/solution/2100-2199/2185.Counting%20Words%20With%20a%20Given%20Prefix/README.md)

## Description

<p>You are given an array of strings <code>words</code> and a string <code>pref</code>.</p>

<p>Return <em>the number of strings in </em><code>words</code><em> that contain </em><code>pref</code><em> as a <strong>prefix</strong></em>.</p>

<p>A <strong>prefix</strong> of a string <code>s</code> is any leading contiguous substring of <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;pay&quot;,&quot;<strong><u>at</u></strong>tention&quot;,&quot;practice&quot;,&quot;<u><strong>at</strong></u>tend&quot;], <code>pref </code>= &quot;at&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> The 2 strings that contain &quot;at&quot; as a prefix are: &quot;<u><strong>at</strong></u>tention&quot; and &quot;<u><strong>at</strong></u>tend&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;leetcode&quot;,&quot;win&quot;,&quot;loops&quot;,&quot;success&quot;], <code>pref </code>= &quot;code&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no strings that contain &quot;code&quot; as a prefix.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 100</code></li>
	<li><code>1 &lt;= words[i].length, pref.length &lt;= 100</code></li>
	<li><code>words[i]</code> and <code>pref</code> consist of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Count words that start with $\textit{pref}$. Both the list and the lengths are small, so a direct prefix test per word is enough.
>
> $\texttt{startswith}$ compares at most $|\textit{pref}|$ characters.
>
> The answer is the number of true tests.

#### Java

```java
class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String w : words) {
            if (w.startsWith(pref)) {
                ++ans;
            }
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 already reads every character. If the same vocabulary were queried many times, a trie could store prefix frequencies on the nodes.
>
> Insertion increments $\textit{cnt}$ along the path; a query walks $\textit{pref}$ and reads $\textit{cnt}$, or returns $0$ on a missing edge.
>
> This problem has a single query; the trie is the extensible alternative.

#### Java

```java
class Trie {
    private Trie[] children = new Trie[26];
    private int cnt;

    public void insert(String w) {
        Trie node = this;
        for (int i = 0; i < w.length(); ++i) {
            int j = w.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new Trie();
            }
            node = node.children[j];
            ++node.cnt;
        }
    }

    public int search(String pref) {
        Trie node = this;
        for (int i = 0; i < pref.length(); ++i) {
            int j = pref.charAt(i) - 'a';
            if (node.children[j] == null) {
                return 0;
            }
            node = node.children[j];
        }
        return node.cnt;
    }
}

class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie tree = new Trie();
        for (String w : words) {
            tree.insert(w);
        }
        return tree.search(pref);
    }
}
```
