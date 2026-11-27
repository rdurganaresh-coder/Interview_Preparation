# 940. Distinct Subsequences II

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/distinct-subsequences-ii/

---

[中文文档](/solution/0900-0999/0940.Distinct%20Subsequences%20II/README.md)

## Description

<p>Given a string s, return <em>the number of <strong>distinct non-empty subsequences</strong> of</em> <code>s</code>. Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>
A <strong>subsequence</strong> of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., <code>&quot;ace&quot;</code> is a subsequence of <code>&quot;<u>a</u>b<u>c</u>d<u>e</u>&quot;</code> while <code>&quot;aec&quot;</code> is not.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abc&quot;
<strong>Output:</strong> 7
<strong>Explanation:</strong> The 7 distinct subsequences are &quot;a&quot;, &quot;b&quot;, &quot;c&quot;, &quot;ab&quot;, &quot;ac&quot;, &quot;bc&quot;, and &quot;abc&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aba&quot;
<strong>Output:</strong> 6
<strong>Explanation:</strong> The 6 distinct subsequences are &quot;a&quot;, &quot;b&quot;, &quot;ab&quot;, &quot;aa&quot;, &quot;ba&quot;, and &quot;aba&quot;.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aaa&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The 3 distinct subsequences are &quot;a&quot;, &quot;aa&quot; and &quot;aaa&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2000</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> Count distinct nonempty subsequences. $n\le 2000$, so listing subsets is impossible. Classify by last letter: $f[c]$ is the number of distinct subsequences now ending with $c$. On reading $c$, it may follow any previous subsequence or stand alone, so $f[c]\leftarrow \sum f+1$; a repeated $c$ overwrites the old family that ended with $c$.

We define $f[i]$ as the number of distinct subsequences ending with the $i$-th lowercase letter. Initially, all elements in $f$ are $0$.

Traverse the string $s$. For the current character $c$, update $f[c]$ to $\sum_{i=0}^{25} f[i] + 1$. Here $\sum_{i=0}^{25} f[i]$ is the number of distinct subsequences obtained so far, and $+1$ means the character $c$ itself can also be a subsequence.

Finally, the answer is $\sum_{i=0}^{25} f[i]$ modulo $10^9 + 7$.

The time complexity is $O(n \times C)$, and the space complexity is $O(C)$, where $n$ is the length of $s$ and $C$ is the size of the character set. In this problem, $C = 26$.

#### Java

```java
class Solution {
    public int distinctSubseqII(String s) {
        final int mod = (int) 1e9 + 7;
        int[] f = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int x = 1;
            for (int v : f) {
                x = (x + v) % mod;
            }
            f[s.charAt(i) - 'a'] = x;
        }
        int ans = 0;
        for (int v : f) {
            ans = (ans + v) % mod;
        }
        return ans;
    }
}
```

### Solution 2: Optimized Dynamic Programming

> **Thinking**
>
> Method 1 rescans $26$ cells on every update. Keep the running sum $\textit{ans}$; the increment is $\textit{ans}-f[i]+1$, so both $f[i]$ and $\textit{ans}$ update in $O(1)$.

Based on Solution 1, we can maintain a variable $\textit{ans}$ as the sum of all elements in $f$. Each time we update $f[i]$, the number of newly added distinct subsequences is $\textit{ans} - f[i] + 1$. We then update both $\textit{ans}$ and $f[i]$ accordingly.

The time complexity is $O(n)$, and the space complexity is $O(C)$.

Similar problems:

- [1987. Number of Unique Good Subsequences](https://github.com/doocs/leetcode/blob/main/solution/1900-1999/1987.Number%20of%20Unique%20Good%20Subsequences/README_EN.md)

#### Java

```java
class Solution {
    public int distinctSubseqII(String s) {
        final int mod = (int) 1e9 + 7;
        int[] f = new int[26];
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            int j = s.charAt(i) - 'a';
            int add = (ans + 1 + mod - f[j]) % mod;
            ans = (ans + add) % mod;
            f[j] = (f[j] + add) % mod;
        }
        return ans;
    }
}
```
