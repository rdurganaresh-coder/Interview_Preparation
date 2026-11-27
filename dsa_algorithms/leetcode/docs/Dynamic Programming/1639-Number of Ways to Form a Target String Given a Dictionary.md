# 1639. Number of Ways to Form a Target String Given a Dictionary

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

---

[中文文档](/solution/1600-1699/1639.Number%20of%20Ways%20to%20Form%20a%20Target%20String%20Given%20a%20Dictionary/README.md)

## Description

<p>You are given a list of strings of the <strong>same length</strong> <code>words</code> and a string <code>target</code>.</p>

<p>Your task is to form <code>target</code> using the given <code>words</code> under the following rules:</p>

<ul>
	<li><code>target</code> should be formed from left to right.</li>
	<li>To form the <code>i<sup>th</sup></code> character (<strong>0-indexed</strong>) of <code>target</code>, you can choose the <code>k<sup>th</sup></code> character of the <code>j<sup>th</sup></code> string in <code>words</code> if <code>target[i] = words[j][k]</code>.</li>
	<li>Once you use the <code>k<sup>th</sup></code> character of the <code>j<sup>th</sup></code> string of <code>words</code>, you <strong>can no longer</strong> use the <code>x<sup>th</sup></code> character of any string in <code>words</code> where <code>x &lt;= k</code>. In other words, all characters to the left of or at index <code>k</code> become unusuable for every string.</li>
	<li>Repeat the process until you form the string <code>target</code>.</li>
</ul>

<p><strong>Notice</strong> that you can use <strong>multiple characters</strong> from the <strong>same string</strong> in <code>words</code> provided the conditions above are met.</p>

<p>Return <em>the number of ways to form <code>target</code> from <code>words</code></em>. Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;acca&quot;,&quot;bbbb&quot;,&quot;caca&quot;], target = &quot;aba&quot;
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 ways to form target.
&quot;aba&quot; -&gt; index 0 (&quot;<u>a</u>cca&quot;), index 1 (&quot;b<u>b</u>bb&quot;), index 3 (&quot;cac<u>a</u>&quot;)
&quot;aba&quot; -&gt; index 0 (&quot;<u>a</u>cca&quot;), index 2 (&quot;bb<u>b</u>b&quot;), index 3 (&quot;cac<u>a</u>&quot;)
&quot;aba&quot; -&gt; index 0 (&quot;<u>a</u>cca&quot;), index 1 (&quot;b<u>b</u>bb&quot;), index 3 (&quot;acc<u>a</u>&quot;)
&quot;aba&quot; -&gt; index 0 (&quot;<u>a</u>cca&quot;), index 2 (&quot;bb<u>b</u>b&quot;), index 3 (&quot;acc<u>a</u>&quot;)
&quot;aba&quot; -&gt; index 1 (&quot;c<u>a</u>ca&quot;), index 2 (&quot;bb<u>b</u>b&quot;), index 3 (&quot;acc<u>a</u>&quot;)
&quot;aba&quot; -&gt; index 1 (&quot;c<u>a</u>ca&quot;), index 2 (&quot;bb<u>b</u>b&quot;), index 3 (&quot;cac<u>a</u>&quot;)
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> words = [&quot;abba&quot;,&quot;baab&quot;], target = &quot;bab&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 4 ways to form target.
&quot;bab&quot; -&gt; index 0 (&quot;<u>b</u>aab&quot;), index 1 (&quot;b<u>a</u>ab&quot;), index 2 (&quot;ab<u>b</u>a&quot;)
&quot;bab&quot; -&gt; index 0 (&quot;<u>b</u>aab&quot;), index 1 (&quot;b<u>a</u>ab&quot;), index 3 (&quot;baa<u>b</u>&quot;)
&quot;bab&quot; -&gt; index 0 (&quot;<u>b</u>aab&quot;), index 2 (&quot;ba<u>a</u>b&quot;), index 3 (&quot;baa<u>b</u>&quot;)
&quot;bab&quot; -&gt; index 1 (&quot;a<u>b</u>ba&quot;), index 2 (&quot;ba<u>a</u>b&quot;), index 3 (&quot;baa<u>b</u>&quot;)
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 1000</code></li>
	<li>All strings in <code>words</code> have the same length.</li>
	<li><code>1 &lt;= target.length &lt;= 1000</code></li>
	<li><code>words[i]</code> and <code>target</code> contain only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Preprocessing + Memory Search

> **Thinking**
>
> Words share one length, letters in the same column are interchangeable, and columns must be taken left to right. Backtracking over words repeats work.
>
> Count letter $c$ in column $j$ as $\textit{cnt}[j][c]$. The state is “match $\textit{target}[i:]$ starting at column $j$”.
>
> Memoized $\textit{dfs}(i,j)$ either skips column $j$ or uses it for $\textit{target}[i]$ multiplied by the count. Finish $i$ yields $1$; run out of columns yields $0$.

We noticed that the length of each string in the string array $\textit{words}$ is the same, so let's remember $n$, then we can preprocess a two-dimensional array $\textit{cnt}$, where $\textit{cnt}[j][c]$ represents the string array $\textit{words}$ The number of characters $c$ in the $j$-th position of.

Next, we design a function $\textit{dfs}(i, j)$, which represents the number of schemes that construct $\textit{target}[i,..]$ and the currently selected character position from $\textit{words}$ is $j$. Then the answer is $\textit{dfs}(0, 0)$.

The calculation logic of function $\textit{dfs}(i, j)$ is as follows:

- If $i \geq m$, it means that all characters in $\textit{target}$ have been selected, then the number of schemes is $1$.
- If $j \geq n$, it means that all characters in $\textit{words}$ have been selected, then the number of schemes is $0$.
- Otherwise, we can choose not to select the character in the $j$-th position of $\textit{words}$, then the number of schemes is $\textit{dfs}(i, j + 1)$; or we choose the character in the $j$-th position of $\textit{words}$, then the number of schemes is $\textit{dfs}(i + 1, j + 1) \times \textit{cnt}[j][\textit{target}[i] - 'a']$.

Finally, we return $\textit{dfs}(0, 0)$. Note that the answer is taken in modulo operation.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ is the length of the string $\textit{target}$, and $n$ is the length of each string in the string array $\textit{words}$.

#### Java

```java
class Solution {
    private int m;
    private int n;
    private String target;
    private Integer[][] f;
    private int[][] cnt;
    private final int mod = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        m = target.length();
        n = words[0].length();
        f = new Integer[m][n];
        this.target = target;
        cnt = new int[n][26];
        for (var w : words) {
            for (int j = 0; j < n; ++j) {
                cnt[j][w.charAt(j) - 'a']++;
            }
        }
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= m) {
            return 1;
        }
        if (j >= n) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        long ans = dfs(i, j + 1);
        ans += 1L * dfs(i + 1, j + 1) * cnt[j][target.charAt(i) - 'a'];
        ans %= mod;
        return f[i][j] = (int) ans;
    }
}
```

### Solution 2: Preprocessing + Dynamic Programming

> **Thinking**
>
> Solution 1 fills a suffix table, so each state reads a later column. The same choice can be stored as a prefix: ways to build the first $i$ characters of $\textit{target}$ from the first $j$ columns.
>
> Skipping column $j-1$ copies $f[i][j-1]$. Taking it multiplies $f[i-1][j-1]$ by that column's count. With $f[0][\cdot]=1$, fill $i$ and $j$ in increasing order.

Similar to Solution 1, we can first preprocess a two-dimensional array $\textit{cnt}$, where $\textit{cnt}[j][c]$ represents the number of characters $c$ in the $j$-th position of the string array $\textit{words}$.

Next, we define $f[i][j]$ which represents the number of ways to construct the first $i$ characters of $\textit{target}$, and currently select characters from the first $j$ characters of each word in $\textit{words}$. Then the answer is $f[m][n]$. Initially $f[0][j] = 1$, where $0 \leq j \leq n$.

Consider $f[i][j]$, where $i \gt 0$, $j \gt 0$. We can choose not to select the character in the $j$-th position of $\textit{words}$, in which case the number of ways is $f[i][j - 1]$; or we choose the character in the $j$-th position of $\textit{words}$, in which case the number of ways is $f[i - 1][j - 1] \times \textit{cnt}[j - 1][\textit{target}[i - 1] - 'a']$. Finally, we add the number of ways in these two cases, which is the value of $f[i][j]$.

Finally, we return $f[m][n]$. Note the mod operation of the answer.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ is the length of the string $\textit{target}$, and $n$ is the length of each string in the string array $\textit{words}$.

#### Java

```java
class Solution {
    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();
        final int mod = (int) 1e9 + 7;
        long[][] f = new long[m + 1][n + 1];
        Arrays.fill(f[0], 1);
        int[][] cnt = new int[n][26];
        for (var w : words) {
            for (int j = 0; j < n; ++j) {
                cnt[j][w.charAt(j) - 'a']++;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                f[i][j] = f[i][j - 1] + f[i - 1][j - 1] * cnt[j - 1][target.charAt(i - 1) - 'a'];
                f[i][j] %= mod;
            }
        }
        return (int) f[m][n];
    }
}
```

### Solution 3: Preprocessing + Dynamic Programming

> **Thinking**
>
> Words share one length, and letters in the same column are interchangeable. Backtracking over the words repeats work once $m$ and $n$ reach $1000$.
>
> Count letter $c$ in column $j$ as $\textit{cnt}[j][c]$. Building $\textit{target}[i:]$ either skips column $j$ or uses it for the current character and multiplies by that count.
>
> Both choices read a later column. Walking from column $0$ to column $n$ is a chain of length $n$. Python raises RecursionError when $n=1000$.
>
> Fill a table instead. $f[i][j]$ is still the number of ways to build $\textit{target}[i:]$ from column $j$ onward. A finished target is $1$ and running out of columns is $0$, so set $f[m][j]=1$ first. Decreasing $i$ and $j$ leaves $f[i][j+1]$ and $f[i+1][j+1]$ already known.

Each string in $\textit{words}$ has the same length $n$, so preprocess $\textit{cnt}$, where $\textit{cnt}[j][c]$ is the number of times character $c$ appears in column $j$.

Let $f[i][j]$ be the number of ways to build $\textit{target}[i,..]$ starting from column $j$. The answer is $f[0][0]$.

When $i = m$, every character of $\textit{target}$ has been chosen, so the value is $1$. When $j = n$ and $i < m$, the columns are exhausted before the target is finished, so the value is $0$. Set $f[m][j] = 1$ for $0 \leq j \leq n$, and leave every other cell at $0$.

For the remaining states, let $i$ run from $m - 1$ down to $0$ and $j$ from $n - 1$ down to $0$. Skipping column $j$ contributes $f[i][j + 1]$. Taking it contributes $f[i + 1][j + 1] \times \textit{cnt}[j][\textit{target}[i] - 'a']$. Add the two contributions and reduce modulo $10^9 + 7$ to obtain $f[i][j]$.

The time complexity is $O(mn)$, and the space complexity is $O(mn)$, where $m$ is the length of $\textit{target}$, and $n$ is the length of each string in $\textit{words}$.

#### Java

```java
class Solution {
    public int numWays(String[] words, String target) {
        int m = target.length();
        int n = words[0].length();
        final int mod = (int) 1e9 + 7;
        int[][] cnt = new int[n][26];
        for (var w : words) {
            for (int j = 0; j < n; ++j) {
                cnt[j][w.charAt(j) - 'a']++;
            }
        }
        int[][] f = new int[m + 1][n + 1];
        for (int j = 0; j <= n; ++j) {
            f[m][j] = 1;
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                long ans = f[i][j + 1];
                ans += 1L * f[i + 1][j + 1] * cnt[j][target.charAt(i) - 'a'];
                f[i][j] = (int) (ans % mod);
            }
        }
        return f[0][0];
    }
}
```
