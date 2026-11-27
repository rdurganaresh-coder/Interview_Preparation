# 1510. Stone Game IV

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/stone-game-iv/

---

[中文文档](/solution/1500-1599/1510.Stone%20Game%20IV/README.md)

## Description

<p>Alice and Bob take turns playing a game, with Alice starting first.</p>

<p>Initially, there are <code>n</code> stones in a pile. On each player&#39;s turn, that player makes a <em>move</em> consisting of removing <strong>any</strong> non-zero <strong>square number</strong> of stones in the pile.</p>

<p>Also, if a player cannot make a move, he/she loses the game.</p>

<p>Given a positive integer <code>n</code>, return <code>true</code> if and only if Alice wins the game otherwise return <code>false</code>, assuming both players play optimally.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> true
<strong>Explanation: </strong>Alice can remove 1 stone winning the game because Bob doesn&#39;t have any moves.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> false
<strong>Explanation: </strong>Alice can only remove 1 stone, after that Bob removes the last one winning the game (2 -&gt; 1 -&gt; 0).
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 4
<strong>Output:</strong> true
<strong>Explanation:</strong> n is already a perfect square, Alice can win with one move, removing 4 stones (4 -&gt; 0).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Memoization

> **Thinking**
>
> Players alternately remove a square number of stones from a pile of $n$; the one who takes the last stone wins. $n\le 10^5$, so expanding the full game tree would recompute the same remainder many times.
>
> A position depends only on the remaining count: it is winning if some move leaves the opponent in a losing position. Memoized $\textit{dfs}(i)$ answers whether the player to move wins with $i$ stones, trying every $j^2\le i$. Each state has $O(\sqrt{i})$ transitions.

We design a function $\textit{dfs}(i)$, which represents whether the current player can win the game when there are $i$ stones in the pile. If the current player can win, it returns $\textit{true}$; otherwise, it returns $\textit{false}$. The answer is $\textit{dfs}(n)$.

The calculation process of the function $\textit{dfs}(i)$ is as follows:

- If $i \leq 0$, it means the current player cannot make any move, so the current player loses the game, return $\textit{false}$;
- Otherwise, enumerate the number of stones $j$ that the current player can take away, where $j$ is a square number. If the other player cannot win the game after the current player takes away $j$ stones, then the current player wins the game, return $\textit{true}$. If all $j$ enumerated cannot satisfy the above condition, then the current player loses the game, return $\textit{false}$.

To avoid repeated calculations, we can use memoization, i.e., use an array $f$ to record the calculation results of the function $\textit{dfs}(i)$.

The time complexity is $O(n \sqrt{n})$, and the space complexity is $O(n)$, where $n$ is the number of stones in the pile.

#### Java

```java
class Solution {
    private Boolean[] f;

    public boolean winnerSquareGame(int n) {
        f = new Boolean[n + 1];
        return dfs(n);
    }

    private boolean dfs(int i) {
        if (i <= 0) {
            return false;
        }
        if (f[i] != null) {
            return f[i];
        }
        int k = (int) Math.sqrt(i);
        for (int j = 1; j <= k; j++) {
            if (!dfs(i - j * j)) {
                return f[i] = true;
            }
        }
        return f[i] = false;
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> Solution 1 already fills this win/loss table from fewer stones to more. The $f[i]$ below is that same table.

Solution 1 already fills this table from fewer stones to more. Define an array $f$, where $f[i]$ represents whether the current player can win the game when there are $i$ stones in the pile. If the current player can win, then $f[i]$ is $\textit{true}$, otherwise it is $\textit{false}$. The answer is $f[n]$.

We enumerate $i$ in the range $[1,..n]$, and enumerate $j$ in the range $[1,..i]$, where $j$ is a square number. If the other player cannot win the game after the current player takes away $j$ stones, then the current player wins the game, i.e., $f[i] = \textit{true}$. If all $j$ enumerated cannot satisfy the above condition, then the current player loses the game, i.e., $f[i] = \textit{false}$. Therefore, we can get the state transition equation:

$$
f[i]=
\begin{cases}
\textit{true}, & \text{if } \exists j \in [1,..i], j^2 \leq i \text{ and } f[i-j^2] = \textit{false}\\
\textit{false}, & \text{otherwise}
\end{cases}
$$

Finally, we return $f[n]$.

The time complexity is $O(n \sqrt{n})$, and the space complexity is $O(n)$, where $n$ is the number of stones in the pile.

#### Java

```java
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] f = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i / j; ++j) {
                if (!f[i - j * j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
```

### Solution 3: Dynamic Programming

> **Thinking**
>
> Expanding the whole game tree is exponential. There can be $10^5$ stones, and the first move always removes one stone, so the search has depth $n$. Whether a position is winning depends only on the remaining count, and only on smaller counts. Let $f[i]$ record a win with $i$ stones, with $f[0]$ losing, and scan $i$ upward. A square $j^2$ that leaves a losing position makes $f[i]$ winning.

Let $f[i]$ be whether the player to move wins with $i$ stones. $f[0]$ is $\textit{false}$, since no move remains. For $i$ from $1$ to $n$, enumerate squares $j^2 \le i$. If $f[i-j^2]$ is $\textit{false}$, the opponent loses from there, so $f[i]$ is $\textit{true}$ and the remaining squares can be skipped. If every square leaves a winning position for the opponent, $f[i]$ stays $\textit{false}$. The answer is $f[n]$.

The time complexity is $O(n \sqrt{n})$, and the space complexity is $O(n)$, where $n$ is the number of stones in the pile.

#### Java

```java
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] f = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i / j; ++j) {
                if (!f[i - j * j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
```
