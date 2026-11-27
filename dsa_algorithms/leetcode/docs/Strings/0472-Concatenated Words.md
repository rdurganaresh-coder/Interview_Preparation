# 472. Concatenated Words

**Difficulty:** Hard  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/concatenated-words/

---

[中文文档](/solution/0400-0499/0472.Concatenated%20Words/README.md)

## Description

<p>Given an array of strings <code>words</code> (<strong>without duplicates</strong>), return <em>all the <strong>concatenated words</strong> in the given list of</em> <code>words</code>.</p>

<p>A <strong>concatenated word</strong> is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct)&nbsp;in the given array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;cat&quot;,&quot;cats&quot;,&quot;catsdogcats&quot;,&quot;dog&quot;,&quot;dogcatsdog&quot;,&quot;hippopotamuses&quot;,&quot;rat&quot;,&quot;ratcatdogcat&quot;]
<strong>Output:</strong> [&quot;catsdogcats&quot;,&quot;dogcatsdog&quot;,&quot;ratcatdogcat&quot;]
<strong>Explanation:</strong> &quot;catsdogcats&quot; can be concatenated by &quot;cats&quot;, &quot;dog&quot; and &quot;cats&quot;; 
&quot;dogcatsdog&quot; can be concatenated by &quot;dog&quot;, &quot;cats&quot; and &quot;dog&quot;; 
&quot;ratcatdogcat&quot; can be concatenated by &quot;rat&quot;, &quot;cat&quot;, &quot;dog&quot; and &quot;cat&quot;.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;cat&quot;,&quot;dog&quot;,&quot;catdog&quot;]
<strong>Output:</strong> [&quot;catdog&quot;]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= words[i].length &lt;= 30</code></li>
	<li><code>words[i]</code> consists of only lowercase English letters.</li>
	<li>All the strings of <code>words</code> are <strong>unique</strong>.</li>
	<li><code>1 &lt;= sum(words[i].length) &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A concatenated word is at least two shorter dictionary words. Trying every split and a set lookup grows with both $n$ and length.
>
> Sort by length and insert shorter words into a trie first. DFS the current word on the trie: at an end-of-word node recurse on the suffix; if the whole word splits, it is concatenated, otherwise insert it.
>
> Concatenated words stay out of the trie, since a longer word can always fall back to atomic pieces. The empty suffix is the success base case.

#### Java

```java
class Trie {
    Trie[] children = new Trie[26];
    boolean isEnd;

    void insert(String w) {
        Trie node = this;
        for (char c : w.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new Trie();
            }
            node = node.children[c];
        }
        node.isEnd = true;
    }
}

class Solution {
    private Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for (String w : words) {
            if (dfs(w)) {
                ans.add(w);
            } else {
                trie.insert(w);
            }
        }
        return ans;
    }

    private boolean dfs(String w) {
        if ("".equals(w)) {
            return true;
        }
        Trie node = trie;
        for (int i = 0; i < w.length(); ++i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
            if (node.isEnd && dfs(w.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
}
```
