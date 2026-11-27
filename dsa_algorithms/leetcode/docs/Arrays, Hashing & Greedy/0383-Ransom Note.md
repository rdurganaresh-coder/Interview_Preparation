# 383. Ransom Note

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/ransom-note/

---

[中文文档](/solution/0300-0399/0383.Ransom%20Note/README.md)

## Description

<p>Given two strings <code>ransomNote</code> and <code>magazine</code>, return <code>true</code><em> if </em><code>ransomNote</code><em> can be constructed by using the letters from </em><code>magazine</code><em> and </em><code>false</code><em> otherwise</em>.</p>

<p>Each letter in <code>magazine</code> can only be used once in <code>ransomNote</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> ransomNote = "a", magazine = "b"
<strong>Output:</strong> false
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> ransomNote = "aa", magazine = "ab"
<strong>Output:</strong> false
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> ransomNote = "aa", magazine = "aab"
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= ransomNote.length, magazine.length &lt;= 10<sup>5</sup></code></li>
	<li><code>ransomNote</code> and <code>magazine</code> consist of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Hash Table or Array

> **Thinking**
>
> Can `ransomNote` be formed from `magazine` letters? A multiset inclusion.
>
> Count magazine frequencies, then decrement along the note; a negative count means shortage. The alphabet has size $26$.

We can use a hash table or an array $\textit{cnt}$ of length $26$ to record the number of times each character appears in the string `magazine`. Then traverse the string `ransomNote`, for each character $c$ in it, we decrease the number of $c$ by $1$ in $\textit{cnt}$. If the number of $c$ is less than $0$ after the decrease, it means that the number of $c$ in `magazine` is not enough, so it cannot be composed of `ransomNote`, just return $\textit{false}$.

Otherwise, after the traversal, it means that each character in `ransomNote` can be found in `magazine`. Therefore, return $\textit{true}$.

The time complexity is $O(m + n)$, and the space complexity is $O(C)$, where $m$ and $n$ are the lengths of the strings $\textit{ransomNote}$ and $\textit{magazine}$ respectively; and $C$ is the size of the character set, which is $26$ in this question.

#### Java

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            ++cnt[magazine.charAt(i) - 'a'];
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            if (--cnt[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
```
