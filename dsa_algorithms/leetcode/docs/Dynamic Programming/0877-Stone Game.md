# 877. Stone Game

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/stone-game/

---

[中文文档](/solution/0800-0899/0877.Stone%20Game/README.md)

## Description

<p>Alice and Bob play a game with piles of stones. There are an <strong>even</strong> number of piles arranged in a row, and each pile has a <strong>positive</strong> integer number of stones <code>piles[i]</code>.</p>

<p>The objective of the game is to end with the most stones. The <strong>total</strong> number of stones across all the piles is <strong>odd</strong>, so there are no ties.</p>

<p>Alice and Bob take turns, with <strong>Alice starting first</strong>. Each turn, a player takes the entire pile of stones either from the <strong>beginning</strong> or from the <strong>end</strong> of the row. This continues until there are no more piles left, at which point the person with the <strong>most stones wins</strong>.</p>

<p>Assuming Alice and Bob play optimally, return <code>true</code><em> if Alice wins the game, or </em><code>false</code><em> if Bob wins</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> piles = [5,3,4,5]
<strong>Output:</strong> true
<strong>Explanation:</strong> 
Alice starts first, and can only take the first 5 or the last 5.
Say she takes the first 5, so that the row becomes [3, 4, 5].
If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> piles = [3,7,2,3]
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= piles.length &lt;= 500</code></li>
	<li><code>piles.length</code> is <strong>even</strong>.</li>
	<li><code>1 &lt;= piles[i] &lt;= 500</code></li>
	<li><code>sum(piles[i])</code> is <strong>odd</strong>.</li>
</ul>

## Solutions

### Solution 1: Memoization Search

> **Thinking**
>
> Players take from either end of a zero-sum pile array; we ask whether Alice scores more. With $\le 500$ piles, the state is the net score on interval $[i,j]$.
>
> $\textit{dfs}(i,j)$ is the max of $\textit{piles}[i]-\textit{dfs}(i+1,j)$ and $\textit{piles}[j]-\textit{dfs}(i,j-1)$. A positive net score wins. Alice always wins under the constraints, but the code still computes the interval DP.

We design a function $\textit{dfs}(i, j)$ that represents the maximum difference in the number of stones between the current player and the other player when considering piles from the $i$-th to the $j$-th. The answer is then $\textit{dfs}(0, n - 1) \gt 0$.

The function $\textit{dfs}(i, j)$ is computed as follows:

- If $i \gt j$, there are no stones left, so the current player cannot take any stones and the difference is $0$, i.e., $\textit{dfs}(i, j) = 0$.
- Otherwise, the current player has two choices: if they take the $i$-th pile, the difference between the current player and the other player is $\textit{piles}[i] - \textit{dfs}(i + 1, j)$; if they take the $j$-th pile, the difference is $\textit{piles}[j] - \textit{dfs}(i, j - 1)$. The current player will choose the option with the larger difference, so $\textit{dfs}(i, j) = \max(\textit{piles}[i] - \textit{dfs}(i + 1, j), \textit{piles}[j] - \textit{dfs}(i, j - 1))$.

Finally, we only need to check whether $\textit{dfs}(0, n - 1) \gt 0$.

To avoid redundant computation, we can use memoization: we use an array $f$ to record all values of $\textit{dfs}(i, j)$, so that when the function is called again, we can directly retrieve the answer from $f$ without recomputing.

The time complexity is $O(n^2)$, and the space complexity is $O(n^2)$, where $n$ is the number of stone piles.

#### Java

```java
class Solution {
    private int[] piles;
    private int[][] f;

    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        int n = piles.length;
        f = new int[n][n];
        return dfs(0, n - 1) > 0;
    }

    private int dfs(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (f[i][j] != 0) {
            return f[i][j];
        }
        return f[i][j] = Math.max(piles[i] - dfs(i + 1, j), piles[j] - dfs(i, j - 1));
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> The memoized recurrence tabulates without recursion. $f[i][j]$ is the net score on $[i,j]$, filled from the length-$1$ diagonal outward.
>
> The transition matches Method 1. The answer is whether $f[0][n-1]$ is positive.

We can also use dynamic programming. Define $f[i][j]$ as the maximum difference in the number of stones the current player can obtain over the other player from piles $\textit{piles}[i..j]$. The final answer is then $f[0][n - 1] \gt 0$.

Initially, $f[i][i] = \textit{piles}[i]$, because with only one pile, the current player can only take that pile, and the difference is $\textit{piles}[i]$.

For $f[i][j]$ where $i \lt j$, there are two cases:

- If the current player takes pile $\textit{piles}[i]$, the remaining piles are $\textit{piles}[i + 1..j]$, and it becomes the other player's turn, so $f[i][j] = \textit{piles}[i] - f[i + 1][j]$.
- If the current player takes pile $\textit{piles}[j]$, the remaining piles are $\textit{piles}[i..j - 1]$, and it becomes the other player's turn, so $f[i][j] = \textit{piles}[j] - f[i][j - 1]$.

Therefore, the final state transition equation is $f[i][j] = \max(\textit{piles}[i] - f[i + 1][j], \textit{piles}[j] - f[i][j - 1])$.

Finally, we only need to check whether $f[0][n - 1] \gt 0$.

The time complexity is $O(n^2)$, and the space complexity is $O(n^2)$, where $n$ is the number of stone piles.

Similar problems:

- [486. Predict the Winner](https://github.com/doocs/leetcode/blob/main/solution/0400-0499/0486.Predict%20the%20Winner/README_EN.md)

#### Java

```java
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][i] = piles[i];
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = Math.max(piles[i] - f[i + 1][j], piles[j] - f[i][j - 1]);
            }
        }
        return f[0][n - 1] > 0;
    }
}
```
