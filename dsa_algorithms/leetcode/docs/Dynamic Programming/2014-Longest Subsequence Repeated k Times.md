# 2014. Longest Subsequence Repeated k Times

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/longest-subsequence-repeated-k-times/

---

[中文文档](/solution/2000-2099/2014.Longest%20Subsequence%20Repeated%20k%20Times/README.md)

## Description

<p>You are given a string <code>s</code> of length <code>n</code>, and an integer <code>k</code>. You are tasked to find the <strong>longest subsequence repeated</strong> <code>k</code> times in string <code>s</code>.</p>

<p>A <strong>subsequence</strong> is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.</p>

<p>A subsequence <code>seq</code> is <strong>repeated</strong> <code>k</code> times in the string <code>s</code> if <code>seq * k</code> is a subsequence of <code>s</code>, where <code>seq * k</code> represents a string constructed by concatenating <code>seq</code> <code>k</code> times.</p>

<ul>
	<li>For example, <code>&quot;bba&quot;</code> is repeated <code>2</code> times in the string <code>&quot;bababcba&quot;</code>, because the string <code>&quot;bbabba&quot;</code>, constructed by concatenating <code>&quot;bba&quot;</code> <code>2</code> times, is a subsequence of the string <code>&quot;<strong><u>b</u></strong>a<strong><u>bab</u></strong>c<strong><u>ba</u></strong>&quot;</code>.</li>
</ul>

<p>Return <em>the <strong>longest subsequence repeated</strong> </em><code>k</code><em> times in string </em><code>s</code><em>. If multiple such subsequences are found, return the <strong>lexicographically largest</strong> one. If there is no such subsequence, return an <strong>empty</strong> string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="example 1" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2000-2099/2014.Longest%20Subsequence%20Repeated%20k%20Times/images/longest-subsequence-repeat-k-times.png" style="width: 457px; height: 99px;" />
<pre>
<strong>Input:</strong> s = &quot;letsleetcode&quot;, k = 2
<strong>Output:</strong> &quot;let&quot;
<strong>Explanation:</strong> There are two longest subsequences repeated 2 times: &quot;let&quot; and &quot;ete&quot;.
&quot;let&quot; is the lexicographically largest one.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;bb&quot;, k = 2
<strong>Output:</strong> &quot;b&quot;
<strong>Explanation:</strong> The longest subsequence repeated 2 times is &quot;b&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ab&quot;, k = 2
<strong>Output:</strong> &quot;&quot;
<strong>Explanation:</strong> There is no subsequence repeated 2 times. Empty string is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == s.length</code></li>
	<li><code>2 &lt;= k &lt;= 2000</code></li>
	<li><code>2 &lt;= n &lt; min(2001, k * 8)</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: BFS

> **Thinking**
>
> Since $n < \min(2001, k \cdot 8)$, a $k$-repeated subsequence has length at most $\lfloor n/k \rfloor \le 7$. A letter must occur at least $k$ times to appear in the answer.
>
> With short candidates, BFS from short to long makes the last success the longest, and appending letters in order makes it lexicographically largest among that length.
>
> The queue starts from `""` and appends letters with count $\ge k$; $\textit{check}$ matches $t$ in $s$ for $k$ rounds.

We can first count the occurrences of each character in the string, and then store the characters that appear at least $k$ times in a list $cs$ in ascending order. Next, we can use BFS to enumerate all possible subsequences.

We define a queue $q$, initially putting the empty string into the queue. Then, we take out a string $\textit{cur}$ from the queue and try to append each character $c \in cs$ to the end of $\textit{cur}$ to form a new string $\textit{nxt}$. If $\textit{nxt}$ is a subsequence that can be repeated $k$ times, we add it to the answer and put $\textit{nxt}$ back into the queue for further processing.

We need an auxiliary function $\textit{check}(t, k)$ to determine whether the string $t$ is a repeated $k$ times subsequence of string $s$. Specifically, we can use two pointers to traverse $s$ and $t$. If we can find all characters of $t$ in $s$ and repeat this process $k$ times, then return $\textit{true}$; otherwise, return $\textit{false}$.

#### Java

```java
class Solution {
    private char[] s;

    public String longestSubsequenceRepeatedK(String s, int k) {
        this.s = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : this.s) {
            cnt[c - 'a']++;
        }

        List<Character> cs = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; ++c) {
            if (cnt[c - 'a'] >= k) {
                cs.add(c);
            }
        }
        Deque<String> q = new ArrayDeque<>();
        q.offer("");
        String ans = "";
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (char c : cs) {
                String nxt = cur + c;
                if (check(nxt, k)) {
                    ans = nxt;
                    q.offer(nxt);
                }
            }
        }
        return ans;
    }

    private boolean check(String t, int k) {
        int i = 0;
        for (char c : s) {
            if (c == t.charAt(i)) {
                i++;
                if (i == t.length()) {
                    if (--k == 0) {
                        return true;
                    }
                    i = 0;
                }
            }
        }
        return false;
    }
}
```
