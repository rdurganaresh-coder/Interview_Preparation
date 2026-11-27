# 920. Number of Music Playlists

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/number-of-music-playlists/

---

[中文文档](/solution/0900-0999/0920.Number%20of%20Music%20Playlists/README.md)

## Description

<p>Your music player contains <code>n</code> different songs. You want to listen to <code>goal</code> songs (not necessarily different) during your trip. To avoid boredom, you will create a playlist so that:</p>

<ul>
	<li>Every song is played <strong>at least once</strong>.</li>
	<li>A song can only be played again only if <code>k</code> other songs have been played.</li>
</ul>

<p>Given <code>n</code>, <code>goal</code>, and <code>k</code>, return <em>the number of possible playlists that you can create</em>. Since the answer can be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 3, goal = 3, k = 1
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 possible playlists: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], and [3, 2, 1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 2, goal = 3, k = 0
<strong>Output:</strong> 6
<strong>Explanation:</strong> There are 6 possible playlists: [1, 1, 2], [1, 2, 1], [2, 1, 1], [2, 2, 1], [2, 1, 2], and [1, 2, 2].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 2, goal = 3, k = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are 2 possible playlists: [1, 2, 1] and [2, 1, 2].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= k &lt; n &lt;= goal &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> A playlist of length $\textit{goal}$ must use exactly $n$ distinct songs, and a repeat of the same song needs a gap of at least $k$. $\textit{goal},n\le 100$, so DP fits. $f[i][j]$ is the number of lists of $i$ songs using $j$ distinct ones: $n-j+1$ choices for a new song, and $j-k$ for a repeat when $j>k$. The answer is $f[\textit{goal}][n]$.

We define $f[i][j]$ to be the number of playlists that can be made from $i$ songs with exactly $j$ different songs. We have $f[0][0] = 1$ and the answer is $f[\textit{goal}][n]$.

For $f[i][j]$, we can choose a song that we have not listened before, so the previous state is $f[i - 1][j - 1]$, and there are $n - (j - 1) = n - j + 1$ options. Thus, $f[i][j] += f[i - 1][j - 1] \times (n - j + 1)$. We can also choose a song that we have listened before, so the previous state is $f[i - 1][j]$, and there are $j - k$ options. Thus, $f[i][j] += f[i - 1][j] \times (j - k)$, where $j \geq k$.

Therefore, we have the transition equation:

$$
f[i][j] = \begin{cases}
1 & i = 0, j = 0 \\
f[i - 1][j - 1] \times (n - j + 1) + f[i - 1][j] \times (j - k) & i \geq 1, j \geq 1
\end{cases}
$$

The final answer is $f[\textit{goal}][n]$.

The time complexity is $O(\textit{goal} n)$, and the space complexity is $O(\textit{goal} n)$, where $\textit{goal}$ and $n$ are the parameters given in the problem.

#### Java

```java
class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        final int mod = (int) 1e9 + 7;
        long[][] f = new long[goal + 1][n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= goal; ++i) {
            for (int j = 1; j <= n; ++j) {
                f[i][j] = f[i - 1][j - 1] * (n - j + 1);
                if (j > k) {
                    f[i][j] += f[i - 1][j] * (j - k);
                }
                f[i][j] %= mod;
            }
        }
        return (int) f[goal][n];
    }
}
```

### Solution 2: Dynamic Programming (Space Optimization)

> **Thinking**
>
> Layer $i$ depends only on $f[i-1][j-1]$ and $f[i-1][j]$, so the table rolls into one dimension and extra space becomes $O(n)$.

We notice that $f[i][j]$ is only related to $f[i - 1][j - 1]$ and $f[i - 1][j]$. Therefore, we can use a rolling array to optimize the space complexity, reducing the space complexity to $O(n)$.

#### Java

```java
class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        final int mod = (int) 1e9 + 7;
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= goal; ++i) {
            long[] g = new long[n + 1];
            for (int j = 1; j <= n; ++j) {
                g[j] = f[j - 1] * (n - j + 1);
                if (j > k) {
                    g[j] += f[j] * (j - k);
                }
                g[j] %= mod;
            }
            f = g;
        }
        return (int) f[n];
    }
}
```
