# 771. Jewels and Stones

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/jewels-and-stones/

---

[中文文档](/solution/0700-0799/0771.Jewels%20and%20Stones/README.md)

## Description

<p>You&#39;re given strings <code>jewels</code> representing the types of stones that are jewels, and <code>stones</code> representing the stones you have. Each character in <code>stones</code> is a type of stone you have. You want to know how many of the stones you have are also jewels.</p>

<p>Letters are case sensitive, so <code>&quot;a&quot;</code> is considered a different type of stone from <code>&quot;A&quot;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> jewels = "aA", stones = "aAAbbbb"
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> jewels = "z", stones = "ZZ"
<strong>Output:</strong> 0
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;jewels.length, stones.length &lt;= 50</code></li>
	<li><code>jewels</code> and <code>stones</code> consist of only English letters.</li>
	<li>All the characters of&nbsp;<code>jewels</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1: Hash Table or Array

> **Thinking**
>
> Count how many stones are jewels. Length $50$: put jewels in a set and test each stone. Case matters.

We can first use a hash table or array $s$ to record all types of jewels. Then traverse all the stones, and if the current stone is a jewel, increment the answer by one.

The time complexity is $O(m+n)$, and the space complexity is $O(|\Sigma|)$, where $m$ and $n$ are the lengths of the strings $\textit{jewels}$ and $\textit{stones}$ respectively, and $\Sigma$ is the character set, which in this problem is the set of all uppercase and lowercase English letters.

#### Java

```java
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] s = new int[128];
        for (char c : jewels.toCharArray()) {
            s[c] = 1;
        }
        int ans = 0;
        for (char c : stones.toCharArray()) {
            ans += s[c];
        }
        return ans;
    }
}
```
