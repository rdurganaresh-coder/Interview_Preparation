# 527. Word Abbreviation

**Difficulty:** Hard  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/word-abbreviation/

---

[中文文档](/solution/0500-0599/0527.Word%20Abbreviation/README.md)

## Description

<p>Given an array of <strong>distinct</strong> strings <code>words</code>, return <em>the minimal possible <strong>abbreviations</strong> for every word</em>.</p>

<p>The following are the rules for a string abbreviation:</p>

<ol>
	<li>The <strong>initial</strong> abbreviation for each word is: the first character, then the number of characters in between, followed by the last character.</li>
	<li>If more than one word shares the <strong>same</strong> abbreviation, then perform the following operation:
	<ul>
		<li><strong>Increase</strong> the prefix (characters in the first part) of each of their abbreviations by <code>1</code>.
		<ul>
			<li>For example, say you start with the words <code>[&quot;abcdef&quot;,&quot;abndef&quot;]</code> both initially abbreviated as <code>&quot;a4f&quot;</code>. Then, a sequence of operations would be <code>[&quot;a4f&quot;,&quot;a4f&quot;]</code> -&gt; <code>[&quot;ab3f&quot;,&quot;ab3f&quot;]</code> -&gt; <code>[&quot;abc2f&quot;,&quot;abn2f&quot;]</code>.</li>
		</ul>
		</li>
		<li>This operation is repeated until every abbreviation is <strong>unique</strong>.</li>
	</ul>
	</li>
	<li>At the end, if an abbreviation did not make a word shorter, then keep it as the original word.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> words = ["like","god","internal","me","internet","interval","intension","face","intrusion"]
<strong>Output:</strong> ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> words = ["aa","aaa"]
<strong>Output:</strong> ["aa","aaa"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 400</code></li>
	<li><code>2 &lt;= words[i].length &lt;= 400</code></li>
	<li><code>words[i]</code> consists of lowercase English letters.</li>
	<li>All the strings of <code>words</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1: Grouped Trie

> **Thinking**
>
> An abbreviation is first letter + middle count + last letter; collisions need a longer prefix. Pairwise LCP is possible for $n \le 400$ but repeats the same prefix work.
>
> Only words that share length and last letter can collide, so group by $(|w|, w[-1])$. Insert each group into a trie that stores visit counts; the first unique node is the distinguishing prefix. Fall back to the original word when the abbreviation is not shorter.

We notice that if two words have the same abbreviation, their first and last letters must be the same, and their lengths must be the same. Therefore, we can group all words by length and last letter, and use a trie to store the information of each group of words.

The structure of each node in the trie is as follows:

- `children`: An array of length $26$, representing all child nodes of this node.
- `cnt`: The number of words passing through this node.

For each word, we insert it into the trie and record the `cnt` value of each node.

When querying, we start from the root node. For the current letter, if the `cnt` value of its corresponding child node is $1$, then we have found the unique abbreviation, and we return the length of the current prefix. Otherwise, we continue to traverse downwards. After the traversal, if we have not found a unique abbreviation, then we return the length of the original word. After getting the prefix lengths of all words, we check whether the abbreviation of the word is shorter than the original word. If it is, then we add it to the answer, otherwise we add the original word to the answer.

The time complexity is $O(L)$, and the space complexity is $O(L)$, where $L$ is the sum of the lengths of all words.

#### Java

```java
class Trie {
    private final Trie[] children = new Trie[26];
    private int cnt;

    public void insert(String w) {
        Trie node = this;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
            ++node.cnt;
        }
    }

    public int search(String w) {
        Trie node = this;
        int ans = 0;
        for (char c : w.toCharArray()) {
            ++ans;
            int idx = c - 'a';
            node = node.children[idx];
            if (node.cnt == 1) {
                return ans;
            }
        }
        return w.length();
    }
}

class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        Map<List<Integer>, Trie> tries = new HashMap<>();
        for (var w : words) {
            var key = List.of(w.length(), w.charAt(w.length() - 1) - 'a');
            tries.putIfAbsent(key, new Trie());
            tries.get(key).insert(w);
        }
        List<String> ans = new ArrayList<>();
        for (var w : words) {
            int m = w.length();
            var key = List.of(m, w.charAt(m - 1) - 'a');
            int cnt = tries.get(key).search(w);
            ans.add(cnt + 2 >= m ? w : w.substring(0, cnt) + (m - cnt - 1) + w.substring(m - 1));
        }
        return ans;
    }
}
```
