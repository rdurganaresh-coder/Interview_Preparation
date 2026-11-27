# 3302. Find the Lexicographically Smallest Valid Sequence

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/

---

[中文文档](/solution/3300-3399/3302.Find%20the%20Lexicographically%20Smallest%20Valid%20Sequence/README.md)

## Description

<p>You are given two strings <code>word1</code> and <code>word2</code>.</p>

<p>A string <code>x</code> is called <strong>almost equal</strong> to <code>y</code> if you can change <strong>at most</strong> one character in <code>x</code> to make it <em>identical</em> to <code>y</code>.</p>

<p>A sequence of indices <code>seq</code> is called <strong>valid</strong> if:</p>

<ul>
	<li>The indices are sorted in <strong>ascending</strong> order.</li>
	<li><em>Concatenating</em> the characters at these indices in <code>word1</code> in <strong>the same</strong> order results in a string that is <strong>almost equal</strong> to <code>word2</code>.</li>
</ul>

<p>Return an array of size <code>word2.length</code> representing the <span data-keyword="lexicographically-smaller-array">lexicographically smallest</span> <strong>valid</strong> sequence of indices. If no such sequence of indices exists, return an <strong>empty</strong> array.</p>

<p><strong>Note</strong> that the answer must represent the <em>lexicographically smallest array</em>, <strong>not</strong> the corresponding string formed by those indices.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word1 = &quot;vbcca&quot;, word2 = &quot;abc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[0,1,2]</span></p>

<p><strong>Explanation:</strong></p>

<p>The lexicographically smallest valid sequence of indices is <code>[0, 1, 2]</code>:</p>

<ul>
	<li>Change <code>word1[0]</code> to <code>&#39;a&#39;</code>.</li>
	<li><code>word1[1]</code> is already <code>&#39;b&#39;</code>.</li>
	<li><code>word1[2]</code> is already <code>&#39;c&#39;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word1 = &quot;bacdc&quot;, word2 = &quot;abc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,4]</span></p>

<p><strong>Explanation:</strong></p>

<p>The lexicographically smallest valid sequence of indices is <code>[1, 2, 4]</code>:</p>

<ul>
	<li><code>word1[1]</code> is already <code>&#39;a&#39;</code>.</li>
	<li>Change <code>word1[2]</code> to <code>&#39;b&#39;</code>.</li>
	<li><code>word1[4]</code> is already <code>&#39;c&#39;</code>.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word1 = &quot;aaaaaa&quot;, word2 = &quot;aaabc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>

<p><strong>Explanation:</strong></p>

<p>There is no valid sequence of indices.</p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">word1 = &quot;abc&quot;, word2 = &quot;ab&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[0,1]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word2.length &lt; word1.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>word1</code> and <code>word2</code> consist only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Greedy + Two Pointers

> **Thinking**
>
> We need a subsequence of $\textit{word1}$ that matches $\textit{word2}$ after at most one change, and the index sequence must be lexicographically smallest. With $|\textit{word1}| \le 3 \times 10^5$, trying every change position is too slow.
>
> Smaller indices should be taken whenever they match. The remaining question is whether a mismatch should consume the single allowed change.
>
> A right-to-left scan builds $\textit{suf}[i]$, the earliest position of $\textit{word2}$ still matchable from $i$. Scanning left to right, we take an index on an exact match; otherwise we change only if no change has been used and $\textit{suf}[i+1] \le j+1$, so the suffix can still finish the pattern.

We first use two pointers to preprocess a suffix array $\textit{suf}$ from right to left, where $\textit{suf}[i]$ represents the smallest starting index in $\textit{word2}$ such that $\textit{word2}[\textit{suf}[i]:]$ is a subsequence of $\textit{word1}[i:]$. Specifically, we use a pointer $j$ pointing to the frontmost unmatched character in $\textit{word2}$, initially $j = n - 1$, and set $\textit{suf}[m] = n$. Starting from $i = m - 1$, we traverse $\textit{word1}$ from right to left. If $j \ge 0$ and $\textit{word1}[i] = \textit{word2}[j]$, it means $\textit{word2}[j]$ can be matched, so we decrement $j$ by one, and then set $\textit{suf}[i] = j + 1$.

Next, we traverse $\textit{word1}$ from left to right, using a pointer $j$ to denote the index of the character in $\textit{word2}$ that we currently need to match (initially $j = 0$), and a variable $\textit{changed}$ to record whether we have already modified a character. For each character $c$ at index $i$:

- If $c = \textit{word2}[j]$, choosing index $i$ is always no worse (the smaller the index, the smaller the lexicographical order of the sequence), so we directly add $i$ to the answer and increment $j$ by one;
- Otherwise, if we have not modified a character yet and $\textit{suf}[i+1] \le j + 1$, it means we can modify $\textit{word1}[i]$ to $\textit{word2}[j]$, and the remaining part $\textit{word2}[j+1:]$ can still be matched within $\textit{word1}[i+1:]$. In this case, we choose index $i$ and set $\textit{changed}$ to true.

When $j = n$, we have matched all of $\textit{word2}$ and can return the answer. If the traversal ends without completing the match, we return an empty array.

The time complexity is $O(m + n)$, and the space complexity is $O(m)$, where $m$ and $n$ are the lengths of the strings $\textit{word1}$ and $\textit{word2}$, respectively.

#### Java

```java
class Solution {
    public int[] validSequence(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int[] suf = new int[m + 1];
        suf[m] = n;

        int j = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j + 1;
        }

        int[] ans = new int[n];
        int size = 0;
        boolean changed = false;
        j = 0;

        for (int i = 0; i < m; i++) {
            char c = word1.charAt(i);
            if (c == word2.charAt(j) || (!changed && suf[i + 1] <= j + 1)) {
                if (c != word2.charAt(j)) {
                    changed = true;
                }
                ans[size++] = i;
                j++;
                if (j == n) {
                    return ans;
                }
            }
        }

        return new int[0];
    }
}
```
