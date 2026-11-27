# 3223. Minimum Length of String After Operations

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/minimum-length-of-string-after-operations/

---

[中文文档](/solution/3200-3299/3223.Minimum%20Length%20of%20String%20After%20Operations/README.md)

## Description

<p>You are given a string <code>s</code>.</p>

<p>You can perform the following process on <code>s</code> <strong>any</strong> number of times:</p>

<ul>
	<li>Choose an index <code>i</code> in the string such that there is <strong>at least</strong> one character to the left of index <code>i</code> that is equal to <code>s[i]</code>, and <strong>at least</strong> one character to the right that is also equal to <code>s[i]</code>.</li>
	<li>Delete the <strong>closest</strong> occurrence of <code>s[i]</code> located to the <strong>left</strong> of <code>i</code>.</li>
	<li>Delete the <strong>closest</strong> occurrence of <code>s[i]</code> located to the <strong>right</strong> of <code>i</code>.</li>
</ul>

<p>Return the <strong>minimum</strong> length of the final string <code>s</code> that you can achieve.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abaacbcbb&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong><br />
We do the following operations:</p>

<ul>
	<li>Choose index 2, then remove the characters at indices 0 and 3. The resulting string is <code>s = &quot;bacbcbb&quot;</code>.</li>
	<li>Choose index 3, then remove the characters at indices 0 and 5. The resulting string is <code>s = &quot;acbcb&quot;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aa&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong><br />
We cannot perform any operations, so we return the length of the original string.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> An operation deletes one matching character on each side of a chosen letter. $n\le 2\times 10^5$, so editing the string in place would move too much. Deletions of one letter never depend on another, so the remainder is determined by that letter's frequency alone.
>
> An odd count leaves $1$ after symmetric deletes; an even count leaves $2$. Summing the $26$ counts is the shortest length; the delete order need not be simulated.

We can count the occurrences of each character in the string, and then iterate through the count array. If a character appears an odd number of times, then $1$ of that character remains in the end; if a character appears an even number of times, then $2$ of that character remain. We can sum the remaining counts of all characters to get the final length of the string.

The time complexity is $O(n)$, and the space complexity is $O(|\Sigma|)$, where $n$ is the length of the string $s$, and $|\Sigma|$ is the size of the character set, which is $26$ in this problem.

#### Java

```java
class Solution {
    public int minimumLength(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        int ans = 0;
        for (int x : cnt) {
            if (x > 0) {
                ans += x % 2 == 1 ? 1 : 2;
            }
        }
        return ans;
    }
}
```
