# 884. Uncommon Words from Two Sentences

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/uncommon-words-from-two-sentences/

---

[中文文档](/solution/0800-0899/0884.Uncommon%20Words%20from%20Two%20Sentences/README.md)

## Description

<p>A <strong>sentence</strong> is a string of single-space separated words where each word consists only of lowercase letters.</p>

<p>A word is <strong>uncommon</strong> if it appears exactly once in one of the sentences, and <strong>does not appear</strong> in the other sentence.</p>

<p>Given two <strong>sentences</strong> <code>s1</code> and <code>s2</code>, return <em>a list of all the <strong>uncommon words</strong></em>. You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s1 = &quot;this apple is sweet&quot;, s2 = &quot;this apple is sour&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[&quot;sweet&quot;,&quot;sour&quot;]</span></p>

<p><strong>Explanation:</strong></p>

<p>The word <code>&quot;sweet&quot;</code> appears only in <code>s1</code>, while the word <code>&quot;sour&quot;</code> appears only in <code>s2</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s1 = &quot;apple apple&quot;, s2 = &quot;banana&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[&quot;banana&quot;]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s1.length, s2.length &lt;= 200</code></li>
	<li><code>s1</code> and <code>s2</code> consist of lowercase English letters and spaces.</li>
	<li><code>s1</code> and <code>s2</code> do not have leading or trailing spaces.</li>
	<li>All the words in <code>s1</code> and <code>s2</code> are separated by a single space.</li>
</ul>

## Solutions

### Solution 1: Hash Table

> **Thinking**
>
> A word is uncommon if it appears once across both sentences. The sentences are short, so a combined counter is enough.
>
> Split both sentences into one counter; keys with count $1$ are the answer.

According to the problem description, as long as a word appears once, it meets the requirements of the problem. Therefore, we use a hash table `cnt` to record all words and their occurrence counts.

Then we traverse the hash table, and take out all strings that appear only once.

The time complexity is $O(m + n)$, and the space complexity is $O(m + n)$, where $m$ and $n$ are the lengths of strings $\textit{s1}$ and $\textit{s2}$, respectively.

#### Java

```java
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String s : s1.split(" ")) {
            cnt.merge(s, 1, Integer::sum);
        }
        for (String s : s2.split(" ")) {
            cnt.merge(s, 1, Integer::sum);
        }
        List<String> ans = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            if (e.getValue() == 1) {
                ans.add(e.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }
}
```
