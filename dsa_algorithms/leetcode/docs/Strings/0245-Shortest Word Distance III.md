# 245. Shortest Word Distance III

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/shortest-word-distance-iii/

---

[中文文档](/solution/0200-0299/0245.Shortest%20Word%20Distance%20III/README.md)

## Description

<p>Given an array of strings <code>wordsDict</code> and two strings that already exist in the array <code>word1</code> and <code>word2</code>, return <em>the shortest distance between the occurrence of these two words in the list</em>.</p>

<p><strong>Note</strong> that <code>word1</code> and <code>word2</code> may be the same. It is guaranteed that they represent <strong>two individual words</strong> in the list.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
<strong>Output:</strong> 1
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
<strong>Output:</strong> 3
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= wordsDict.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= wordsDict[i].length &lt;= 10</code></li>
	<li><code>wordsDict[i]</code> consists of lowercase English letters.</li>
	<li><code>word1</code> and <code>word2</code> are in <code>wordsDict</code>.</li>
</ul>

## Solutions

### Solution 1: Case Analysis

> **Thinking**
>
> $\textit{word1}$ may equal $\textit{word2}$, in which case the answer is the gap between consecutive occurrences of that word; otherwise it is the usual two-word gap.
>
> Track the last index accordingly: one pointer when the words coincide, two pointers when they differ.

First, we check whether $\textit{word1}$ and $\textit{word2}$ are equal:

- If they are equal, iterate through the array $\textit{wordsDict}$ to find two indices $i$ and $j$ of $\textit{word1}$, and compute the minimum value of $i-j$.
- If they are not equal, iterate through the array $\textit{wordsDict}$ to find the indices $i$ of $\textit{word1}$ and $j$ of $\textit{word2}$, and compute the minimum value of $i-j$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{wordsDict}$.

#### Java

```java
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int ans = wordsDict.length;
        if (word1.equals(word2)) {
            for (int i = 0, j = -1; i < wordsDict.length; ++i) {
                if (wordsDict[i].equals(word1)) {
                    if (j != -1) {
                        ans = Math.min(ans, i - j);
                    }
                    j = i;
                }
            }
        } else {
            for (int k = 0, i = -1, j = -1; k < wordsDict.length; ++k) {
                if (wordsDict[k].equals(word1)) {
                    i = k;
                }
                if (wordsDict[k].equals(word2)) {
                    j = k;
                }
                if (i != -1 && j != -1) {
                    ans = Math.min(ans, Math.abs(i - j));
                }
            }
        }
        return ans;
    }
}
```
