# 1002. Find Common Characters

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/find-common-characters/

---

[中文文档](/solution/1000-1099/1002.Find%20Common%20Characters/README.md)

## Description

<p>Given a string array <code>words</code>, return <em>an array of all characters that show up in all strings within the </em><code>words</code><em> (including duplicates)</em>. You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> words = ["bella","label","roller"]
<strong>Output:</strong> ["e","l","l"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> words = ["cool","lock","cook"]
<strong>Output:</strong> ["c","o"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 100</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 100</code></li>
	<li><code>words[i]</code> consists of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> Scanning every word for each letter is feasible: both the number of words and their lengths are at most $100$. Repeatedly walking the same alphabet still wastes comparisons.
>
> A letter appears in the answer as many times as its minimum frequency over all words — the intersection of the multisets.
>
> We therefore count the first word, take a pointwise $\min$ with every later word, and expand the counts. The alphabet has size $26$, so extra space is constant.

We use an array $\textit{cnt}$ of length $26$ to record the minimum number of times each character appears in all strings. Finally, we traverse the $\textit{cnt}$ array and add characters with a count greater than $0$ to the answer.

The time complexity is $O(n \sum w_i)$, and the space complexity is $O(|\Sigma|)$, where $n$ is the length of the string array $\textit{words}$, $w_i$ is the length of the $i$-th string in the array $\textit{words}$, and $|\Sigma|$ is the size of the character set, which is $26$ in this problem.

#### Java

```java
class Solution {
    public List<String> commonChars(String[] words) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, 20000);
        for (var w : words) {
            int[] t = new int[26];
            for (int i = 0; i < w.length(); ++i) {
                ++t[w.charAt(i) - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                cnt[i] = Math.min(cnt[i], t[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            ans.addAll(Collections.nCopies(cnt[i], String.valueOf((char) ('a' + i))));
        }
        return ans;
    }
}
```
