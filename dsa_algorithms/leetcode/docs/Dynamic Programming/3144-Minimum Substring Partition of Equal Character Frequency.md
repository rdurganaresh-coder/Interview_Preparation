# 3144. Minimum Substring Partition of Equal Character Frequency

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/minimum-substring-partition-of-equal-character-frequency/

---

[中文文档](/solution/3100-3199/3144.Minimum%20Substring%20Partition%20of%20Equal%20Character%20Frequency/README.md)

## Description

<p>Given a string <code>s</code>, you need to partition it into one or more <strong>balanced</strong> <span data-keyword="substring">substrings</span>. For example, if <code>s == &quot;ababcc&quot;</code> then <code>(&quot;abab&quot;, &quot;c&quot;, &quot;c&quot;)</code>, <code>(&quot;ab&quot;, &quot;abc&quot;, &quot;c&quot;)</code>, and <code>(&quot;ababcc&quot;)</code> are all valid partitions, but <code>(&quot;a&quot;, <strong>&quot;bab&quot;</strong>, &quot;cc&quot;)</code>, <code>(<strong>&quot;aba&quot;</strong>, &quot;bc&quot;, &quot;c&quot;)</code>, and <code>(&quot;ab&quot;, <strong>&quot;abcc&quot;</strong>)</code> are not. The unbalanced substrings are bolded.</p>

<p>Return the <strong>minimum</strong> number of substrings that you can partition <code>s</code> into.</p>

<p><strong>Note:</strong> A <strong>balanced</strong> string is a string where each character in the string occurs the same number of times.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;fabccddg&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>We can partition the string <code>s</code> into 3 substrings in one of the following ways: <code>(&quot;fab, &quot;ccdd&quot;, &quot;g&quot;)</code>, or <code>(&quot;fabc&quot;, &quot;cd&quot;, &quot;dg&quot;)</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abababaccddb&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>We can partition the string <code>s</code> into 2 substrings like so: <code>(&quot;abab&quot;, &quot;abaccddb&quot;)</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consists only of English lowercase letters.</li>
</ul>

## Solutions

### Solution 1: Memoized Search + Hash Table

> **Thinking**
>
> $s$ must be split into as few balanced pieces as possible, each with equal character frequencies. Full partitions are exponential; $n\le 1000$ allows quadratic DP.
>
> From index $i$, extending $j$ can test balance with frequency maps: a piece is legal when only one frequency remains. The optimum depends only on the start index.
>
> Memoize $\textit{dfs}(i)$: maintain $\textit{cnt}$ and $\textit{freq}$, and when $\textit{freq}$ has size $1$ take $1+\textit{dfs}(j+1)$. The empty suffix returns $0$.

We design a function $\textit{dfs}(i)$, which represents the minimum number of substrings starting from $s[i]$. The answer is $\textit{dfs}(0)$.

The calculation process of the function $\textit{dfs}(i)$ is as follows:

If $i \geq n$, it means all characters have been processed, so return $0$.

Otherwise, we maintain a hash table $\textit{cnt}$ to represent the frequency of each character in the current substring. Additionally, we maintain a hash table $\textit{freq}$ to represent the frequency of each character's occurrence count.

Then we enumerate $j$ from $i$ to $n-1$, representing the end position of the current substring. For each $j$, we update $\textit{cnt}$ and $\textit{freq}$, then check if the size of $\textit{freq}$ is $1$. If it is, we can split from $j+1$, and the answer is $1 + \textit{dfs}(j+1)$. We take the minimum answer among all $j$ as the return value of the function.

To avoid repeated calculations, we use memoized search.

The time complexity is $O(n^2)$, and the space complexity is $O(n|\Sigma|)$, where $n$ is the length of the string $s$, and $|\Sigma|$ represents the size of the character set, which is $26$ in this problem.

#### Java

```java
class Solution {
    private int n;
    private char[] s;
    private Integer[] f;

    public int minimumSubstringsInPartition(String s) {
        n = s.length();
        f = new Integer[n];
        this.s = s.toCharArray();
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        int[] cnt = new int[26];
        Map<Integer, Integer> freq = new HashMap<>(26);
        int ans = n - i;
        for (int j = i; j < n; ++j) {
            int k = s[j] - 'a';
            if (cnt[k] > 0) {
                if (freq.merge(cnt[k], -1, Integer::sum) == 0) {
                    freq.remove(cnt[k]);
                }
            }
            ++cnt[k];
            freq.merge(cnt[k], 1, Integer::sum);
            if (freq.size() == 1) {
                ans = Math.min(ans, 1 + dfs(j + 1));
            }
        }
        return f[i] = ans;
    }
}
```

### Solution 2: Memoized Search (Optimization)

> **Thinking**
>
> Method 1 keeps a second map of frequency-of-frequencies, which adds constants and fiddly updates.
>
> Balance is equivalent to length equaling (maximum frequency) times (number of distinct letters). Only $\textit{cnt}$ and that maximum $m$ are required.
>
> While extending $j$, update $m$ and recurse when $j-i+1=m\cdot|\textit{cnt}|$. The state is still the start index, with a shorter inner loop.

We can optimize Solution 1 by not maintaining the $\textit{freq}$ hash table. Instead, we only need to maintain a hash table $\textit{cnt}$, which represents the frequency of each character in the current substring. Additionally, we maintain two variables $k$ and $m$ to represent the number of distinct characters in the current substring and the maximum frequency of any character, respectively. For a substring $s[i..j]$, if $j-i+1 = m \times k$, then this substring is a balanced substring.

The time complexity is $O(n^2)$, and the space complexity is $O(n|\Sigma|)$, where $n$ is the length of the string $s$, and $|\Sigma|$ represents the size of the character set, which is $26$ in this problem.

#### Java

```java
class Solution {
    private int n;
    private char[] s;
    private Integer[] f;

    public int minimumSubstringsInPartition(String s) {
        n = s.length();
        f = new Integer[n];
        this.s = s.toCharArray();
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        int[] cnt = new int[26];
        int ans = n - i;
        int k = 0, m = 0;
        for (int j = i; j < n; ++j) {
            k += ++cnt[s[j] - 'a'] == 1 ? 1 : 0;
            m = Math.max(m, cnt[s[j] - 'a']);
            if (j - i + 1 == k * m) {
                ans = Math.min(ans, 1 + dfs(j + 1));
            }
        }
        return f[i] = ans;
    }
}
```

### Solution 3: Dynamic Programming

> **Thinking**
>
> Solution 2 already fills this minimum from the end of the string. The same transition can be written on prefixes.
>
> Let $f[i]$ be the fewest pieces for the prefix of length $i$. For each right end $i$, expand left to $j$ and relax $f[i+1]$ with $f[j]+1$ when the piece is balanced.
>
> The table yields $f[n]$, using linear DP memory plus one count map.

The minimum number of pieces can also be stored on prefixes. Define the state $f[i]$ as the minimum number of substrings required to partition the first $i$ characters. Initially, $f[0] = 0$, and the rest $f[i] = +\infty$ or $f[i] = n$.

Next, we enumerate $i$ from $0$ to $n-1$. For each $i$, we maintain a hash table $\textit{cnt}$ to represent the frequency of each character in the current substring. Additionally, we maintain two variables $k$ and $m$ to represent the number of distinct characters in the current substring and the maximum frequency of any character, respectively. For a substring $s[j..i]$, if $i-j+1 = m \times k$, then this substring is a balanced substring. At this point, we can partition from $j$, so $f[i+1] = \min(f[i+1], f[j] + 1)$.

The final answer is $f[n]$.

The time complexity is $O(n^2)$, and the space complexity is $O(n + |\Sigma|)$, where $n$ is the length of the string $s$, and $|\Sigma|$ represents the size of the character set, which is $26$ in this problem.

#### Java

```java
class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        Arrays.fill(f, n);
        f[0] = 0;
        for (int i = 0; i < n; ++i) {
            int[] cnt = new int[26];
            int k = 0, m = 0;
            for (int j = i; j >= 0; --j) {
                k += ++cnt[cs[j] - 'a'] == 1 ? 1 : 0;
                m = Math.max(m, cnt[cs[j] - 'a']);
                if (i - j + 1 == k * m) {
                    f[i + 1] = Math.min(f[i + 1], 1 + f[j]);
                }
            }
        }
        return f[n];
    }
}
```

### Solution 4: Dynamic Programming + Hash Table

> **Thinking**
>
> Enumerating every partition is exponential. The string length reaches $1000$, and a single character is already a balanced piece, so the first transition always moves to the next index and the search has depth $n$. Whether a piece is balanced depends only on the frequencies inside it, so the answer from index $i$ depends only on later answers. Let $f[i]$ be the fewest pieces starting at $i$, with $f[n]=0$, and scan right endpoints from the end, updating with $1+f[j+1]$ when $\textit{freq}$ contains only one frequency.

Let $f[i]$ be the minimum number of substrings starting at index $i$, with $f[n]=0$. For $i$ from $n-1$ down to $0$, keep a hash table $\textit{cnt}$ of character frequencies in the current piece and a hash table $\textit{freq}$ of how often each frequency occurs. Enumerate the right endpoint $j$ from $i$ to $n-1$, append $s[j]$, and update both tables. If $\textit{freq}$ has size $1$, then $s[i..j]$ is balanced and $f[i]$ is updated with $1+f[j+1]$. Every character can stand alone, so $n-i$ is a valid upper bound. The answer is $f[0]$.

The time complexity is $O(n^2)$, and the space complexity is $O(n + |\Sigma|)$, where $n$ is the length of the string $s$, and $|\Sigma|$ represents the size of the character set, which is $26$ in this problem.

#### Java

```java
class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int[] cnt = new int[26];
            Map<Integer, Integer> freq = new HashMap<>(26);
            int ans = n - i;
            for (int j = i; j < n; ++j) {
                int k = cs[j] - 'a';
                if (cnt[k] > 0) {
                    if (freq.merge(cnt[k], -1, Integer::sum) == 0) {
                        freq.remove(cnt[k]);
                    }
                }
                ++cnt[k];
                freq.merge(cnt[k], 1, Integer::sum);
                if (freq.size() == 1) {
                    ans = Math.min(ans, 1 + f[j + 1]);
                }
            }
            f[i] = ans;
        }
        return f[0];
    }
}
```

### Solution 5: Dynamic Programming (Optimization)

> **Thinking**
>
> Solution 1 deletes the old frequency and inserts the new one on every appended character. Balance is the same as the piece length equaling the maximum frequency times the number of distinct letters, so one $\textit{cnt}$ is enough. The answer at index $i$ still depends only on the right, so $f[i]$ is filled from the end. While extending $j$, track the number of distinct letters $k$ and the maximum frequency $m$, and update with $1+f[j+1]$ when $j-i+1=k\cdot m$.

The $\textit{freq}$ table in Solution 1 can be dropped. Keep only the character counts $\textit{cnt}$, the number of distinct letters $k$, and the maximum frequency $m$. $f[i]$ is still the fewest pieces starting at index $i$, with $f[n]=0$. Scan the start index from the right and extend $j$ to the right. If $j-i+1 = m \times k$, then $s[i..j]$ is balanced and $f[i]$ is updated with $1+f[j+1]$. The answer is $f[0]$.

The time complexity is $O(n^2)$, and the space complexity is $O(n + |\Sigma|)$, where $n$ is the length of the string $s$, and $|\Sigma|$ represents the size of the character set, which is $26$ in this problem.

#### Java

```java
class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int[] cnt = new int[26];
            int ans = n - i;
            int k = 0, m = 0;
            for (int j = i; j < n; ++j) {
                k += ++cnt[cs[j] - 'a'] == 1 ? 1 : 0;
                m = Math.max(m, cnt[cs[j] - 'a']);
                if (j - i + 1 == k * m) {
                    ans = Math.min(ans, 1 + f[j + 1]);
                }
            }
            f[i] = ans;
        }
        return f[0];
    }
}
```
