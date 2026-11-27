# 1100. Find K-Length Substrings With No Repeated Characters

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/

---

[中文文档](/solution/1100-1199/1100.Find%20K-Length%20Substrings%20With%20No%20Repeated%20Characters/README.md)

## Description

<p>Given a string <code>s</code> and an integer <code>k</code>, return <em>the number of substrings in </em><code>s</code><em> of length </em><code>k</code><em> with no repeated characters</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;havefunonleetcode&quot;, k = 5
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 substrings they are: &#39;havef&#39;,&#39;avefu&#39;,&#39;vefun&#39;,&#39;efuno&#39;,&#39;etcod&#39;,&#39;tcode&#39;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;home&quot;, k = 5
<strong>Output:</strong> 0
<strong>Explanation:</strong> Notice k can be larger than the length of s. In this case, it is not possible to find any substring.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
	<li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Sliding Window + Hash Table

> **Thinking**
>
> Checking every substring of length $k$ for uniqueness costs $O(nk)$. With $n,k\le 10^4$ this can pass, yet adjacent windows differ by only one character entering and one leaving.
>
> Maintain a window of length $k$ and a frequency map: add $s[i]$, drop $s[i-k]$, and remove a key when its count hits zero. The map has exactly $k$ keys if and only if every character in the window appears once, so that test increments the answer.

We maintain a sliding window of length $k$, and use a hash table $\textit{cnt}$ to count the occurrences of each character in the window.

First, we add the first $k$ characters of the string $s$ to the hash table $\textit{cnt}$, and check whether the size of $\textit{cnt}$ is equal to $k$. If it is, it means that all characters in the window are different, and the answer $\textit{ans}$ is incremented by one.

Next, we start to traverse the string $s$ from $k$. Each time we add $s[i]$ to the hash table $\textit{cnt}$, and at the same time subtract $s[i-k]$ from the hash table $\textit{cnt}$ by one. If $\textit{cnt}[s[i-k]]$ is equal to $0$ after subtraction, we remove $s[i-k]$ from the hash table $\textit{cnt}$. If the size of the hash table $\textit{cnt}$ is equal to $k$ at this time, it means that all characters in the window are different, and the answer $\textit{ans}$ is incremented by one.

Finally, return the answer $\textit{ans}$.

The time complexity is $O(n)$, and the space complexity is $O(\min(k, |\Sigma|))$, where $n$ is the length of the string $s$; and $\Sigma$ is the character set, in this problem the character set is lowercase English letters, so $|\Sigma| = 26$.

#### Java

```java
class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int n = s.length();
        if (n < k) {
            return 0;
        }
        Map<Character, Integer> cnt = new HashMap<>(k);
        for (int i = 0; i < k; ++i) {
            cnt.merge(s.charAt(i), 1, Integer::sum);
        }
        int ans = cnt.size() == k ? 1 : 0;
        for (int i = k; i < n; ++i) {
            cnt.merge(s.charAt(i), 1, Integer::sum);
            if (cnt.merge(s.charAt(i - k), -1, Integer::sum) == 0) {
                cnt.remove(s.charAt(i - k));
            }
            ans += cnt.size() == k ? 1 : 0;
        }
        return ans;
    }
}
```
