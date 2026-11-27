# 1832. Check if the Sentence Is Pangram

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/check-if-the-sentence-is-pangram/

---

[中文文档](/solution/1800-1899/1832.Check%20if%20the%20Sentence%20Is%20Pangram/README.md)

## Description

<p>A <strong>pangram</strong> is a sentence where every letter of the English alphabet appears at least once.</p>

<p>Given a string <code>sentence</code> containing only lowercase English letters, return<em> </em><code>true</code><em> if </em><code>sentence</code><em> is a <strong>pangram</strong>, or </em><code>false</code><em> otherwise.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> sentence = &quot;thequickbrownfoxjumpsoverthelazydog&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> sentence contains at least one of every letter of the English alphabet.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> sentence = &quot;leetcode&quot;
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= sentence.length &lt;= 1000</code></li>
	<li><code>sentence</code> consists of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Array or Hash Table

> **Thinking**
>
> We must test whether every lowercase letter appears. A linear scan is enough; only the presence set matters.
>
> Insert characters into a set and check whether its size is $26$.

Traverse the string `sentence`, use an array or hash table to record the letters that have appeared, and finally check whether there are $26$ letters in the array or hash table.

The time complexity is $O(n)$, and the space complexity is $O(C)$, where $n$ is the length of the string $\textit{sentence}$, and $C$ is the size of the character set. In this problem, $C = 26$.

#### Java

```java
class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] vis = new boolean[26];
        for (int i = 0; i < sentence.length(); ++i) {
            vis[sentence.charAt(i) - 'a'] = true;
        }
        for (boolean v : vis) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
```

### Solution 2: Bit Manipulation

> **Thinking**
>
> Solution 1 stores a hash set. With only $26$ letters, bit $i$ of an integer $\textit{mask}$ can mark letter $i$. The sentence is a pangram iff $\textit{mask}=2^{26}-1$, using constant extra space.

We can also use an integer $\textit{mask}$ to record the letters that have appeared, where the $i$-th bit of $\textit{mask}$ indicates whether the $i$-th letter has appeared.

Finally, check whether there are $26$ $1$s in the binary representation of $\textit{mask}$, that is, check whether $\textit{mask}$ is equal to $2^{26} - 1$. If so, return `true`, otherwise return `false`.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $\textit{sentence}$.

#### Java

```java
class Solution {
    public boolean checkIfPangram(String sentence) {
        int mask = 0;
        for (int i = 0; i < sentence.length(); ++i) {
            mask |= 1 << (sentence.charAt(i) - 'a');
        }
        return mask == (1 << 26) - 1;
    }
}
```
