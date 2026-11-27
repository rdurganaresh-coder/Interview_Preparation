# 820. Short Encoding of Words

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/short-encoding-of-words/

---

[中文文档](/solution/0800-0899/0820.Short%20Encoding%20of%20Words/README.md)

## Description

<p>A <strong>valid encoding</strong> of an array of <code>words</code> is any reference string <code>s</code> and array of indices <code>indices</code> such that:</p>

<ul>
	<li><code>words.length == indices.length</code></li>
	<li>The reference string <code>s</code> ends with the <code>&#39;#&#39;</code> character.</li>
	<li>For each index <code>indices[i]</code>, the <strong>substring</strong> of <code>s</code> starting from <code>indices[i]</code> and up to (but not including) the next <code>&#39;#&#39;</code> character is equal to <code>words[i]</code>.</li>
</ul>

<p>Given an array of <code>words</code>, return <em>the <strong>length of the shortest reference string</strong> </em><code>s</code><em> possible of any <strong>valid encoding</strong> of </em><code>words</code><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;time&quot;, &quot;me&quot;, &quot;bell&quot;]
<strong>Output:</strong> 10
<strong>Explanation:</strong> A valid encoding would be s = <code>&quot;time#bell#&quot; and indices = [0, 2, 5</code>].
words[0] = &quot;time&quot;, the substring of s starting from indices[0] = 0 to the next &#39;#&#39; is underlined in &quot;<u>time</u>#bell#&quot;
words[1] = &quot;me&quot;, the substring of s starting from indices[1] = 2 to the next &#39;#&#39; is underlined in &quot;ti<u>me</u>#bell#&quot;
words[2] = &quot;bell&quot;, the substring of s starting from indices[2] = 5 to the next &#39;#&#39; is underlined in &quot;time#<u>bell</u>#&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;t&quot;]
<strong>Output:</strong> 2
<strong>Explanation:</strong> A valid encoding would be s = &quot;t#&quot; and indices = [0].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 2000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 7</code></li>
	<li><code>words[i]</code> consists of only lowercase letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The encoding concatenates words with `#`. A shorter word that is a suffix of a longer one is already covered. Pairwise suffix checks waste work.
>
> Insert the reversed words into a trie so shared suffixes share a path. Only leaves need their own encoding (length plus one); internal nodes are covered by a longer word.

#### Java

```java
class Trie {
    Trie[] children = new Trie[26];
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        for (String w : words) {
            Trie cur = root;
            for (int i = w.length() - 1; i >= 0; i--) {
                int idx = w.charAt(i) - 'a';
                if (cur.children[idx] == null) {
                    cur.children[idx] = new Trie();
                }
                cur = cur.children[idx];
            }
        }
        return dfs(root, 1);
    }

    private int dfs(Trie cur, int l) {
        boolean isLeaf = true;
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cur.children[i] != null) {
                isLeaf = false;
                ans += dfs(cur.children[i], l + 1);
            }
        }
        if (isLeaf) {
            ans += l;
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Method 1 builds the full trie, then DFS-counts leaves. Inserting reversed words from long to short lets longer words occupy paths first. If a later word’s path already exists, it is a suffix of a longer word and contributes $0$; otherwise it contributes length plus one.
>
> The answer is accumulated during insertion, so the second DFS is dropped.

#### Java

```java
class Trie {
    Trie[] children = new Trie[26];

    int insert(String w) {
        Trie node = this;
        boolean pref = true;
        for (int i = w.length() - 1; i >= 0; --i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                pref = false;
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        return pref ? 0 : w.length() + 1;
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        int ans = 0;
        Trie trie = new Trie();
        for (String w : words) {
            ans += trie.insert(w);
        }
        return ans;
    }
}
```
