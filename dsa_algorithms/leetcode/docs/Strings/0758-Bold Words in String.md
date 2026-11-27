# 758. Bold Words in String

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/bold-words-in-string/

---

[中文文档](/solution/0700-0799/0758.Bold%20Words%20in%20String/README.md)

## Description

<p>Given an array of keywords <code>words</code> and a string <code>s</code>, make all appearances of all keywords <code>words[i]</code> in <code>s</code> bold. Any letters between <code>&lt;b&gt;</code> and <code>&lt;/b&gt;</code> tags become bold.</p>

<p>Return <code>s</code> <em>after adding the bold tags</em>. The returned string should use the least number of tags possible, and the tags should form a valid combination.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;ab&quot;,&quot;bc&quot;], s = &quot;aabcd&quot;
<strong>Output:</strong> &quot;a&lt;b&gt;abc&lt;/b&gt;d&quot;
<strong>Explanation:</strong> Note that returning <code>&quot;a&lt;b&gt;a&lt;b&gt;b&lt;/b&gt;c&lt;/b&gt;d&quot;</code> would use more tags, so it is incorrect.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;ab&quot;,&quot;cb&quot;], s = &quot;aabcd&quot;
<strong>Output:</strong> &quot;a&lt;b&gt;ab&lt;/b&gt;cd&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 500</code></li>
	<li><code>0 &lt;= words.length &lt;= 50</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 10</code></li>
	<li><code>s</code> and <code>words[i]</code> consist of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as <a href="https://leetcode.com/problems/add-bold-tag-in-string/description/" target="_blank">616. Add Bold Tag in String</a>.</p>

## Solutions

### Solution 1

> **Thinking**
>
> Wrap every occurrence of a dictionary word in bold tags, merging overlaps and adjacent runs. A trie finds all hits in one sweep.
>
> From each start, walk the trie and record $[i,j]$ at each word-end. Then merge intervals that touch or overlap.
>
> Emit `<b>`/`</b>` around the merged spans while copying $s$.

#### Java

```java
class Trie {
    Trie[] children = new Trie[128];
    boolean isEnd;

    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.children[c] == null) {
                node.children[c] = new Trie();
            }
            node = node.children[c];
        }
        node.isEnd = true;
    }
}

class Solution {
    public String boldWords(String[] words, String s) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        List<int[]> pairs = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            Trie node = trie;
            for (int j = i; j < n; ++j) {
                int idx = s.charAt(j);
                if (node.children[idx] == null) {
                    break;
                }
                node = node.children[idx];
                if (node.isEnd) {
                    pairs.add(new int[] {i, j});
                }
            }
        }
        if (pairs.isEmpty()) {
            return s;
        }
        List<int[]> t = new ArrayList<>();
        int st = pairs.get(0)[0], ed = pairs.get(0)[1];
        for (int j = 1; j < pairs.size(); ++j) {
            int a = pairs.get(j)[0], b = pairs.get(j)[1];
            if (ed + 1 < a) {
                t.add(new int[] {st, ed});
                st = a;
                ed = b;
            } else {
                ed = Math.max(ed, b);
            }
        }
        t.add(new int[] {st, ed});
        int i = 0, j = 0;
        StringBuilder ans = new StringBuilder();
        while (i < n) {
            if (j == t.size()) {
                ans.append(s.substring(i));
                break;
            }
            st = t.get(j)[0];
            ed = t.get(j)[1];
            if (i < st) {
                ans.append(s.substring(i, st));
            }
            ++j;
            ans.append("<b>");
            ans.append(s.substring(st, ed + 1));
            ans.append("</b>");
            i = ed + 1;
        }
        return ans.toString();
    }
}
```
