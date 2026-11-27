# 294. Flip Game II

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/flip-game-ii/

---

[中文文档](/solution/0200-0299/0294.Flip%20Game%20II/README.md)

## Description

<p>You are playing a Flip Game with your friend.</p>

<p>You are given a string <code>currentState</code> that contains only <code>&#39;+&#39;</code> and <code>&#39;-&#39;</code>. You and your friend take turns to flip <strong>two consecutive</strong> <code>&quot;++&quot;</code> into <code>&quot;--&quot;</code>. The game ends when a person can no longer make a move, and therefore the other person will be the winner.</p>

<p>Return <code>true</code> <em>if the starting player can <strong>guarantee a win</strong></em>, and <code>false</code> otherwise.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> currentState = &quot;++++&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> The starting player can guarantee a win by flipping the middle &quot;++&quot; to become &quot;+--+&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> currentState = &quot;+&quot;
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= currentState.length &lt;= 60</code></li>
	<li><code>currentState[i]</code> is either <code>&#39;+&#39;</code> or <code>&#39;-&#39;</code>.</li>
	<li>There cannot be more than 20 consecutive <code>&#39;+&#39;</code>.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Derive your algorithm&#39;s runtime complexity.

## Solutions

### Solution 1

> **Thinking**
>
> Players flip $++$ in turn; the one who cannot move loses. A bit mask of length $n$ records pluses; we try each legal flip and see whether the opponent loses.
>
> Masks repeat, so we memoize $\textit{dfs}(\textit{mask})$: the position is winning if some move returns false for the opponent.

#### Java

```java
class Solution {
    private int n;
    private Map<Long, Boolean> memo = new HashMap<>();

    public boolean canWin(String currentState) {
        long mask = 0;
        n = currentState.length();
        for (int i = 0; i < n; ++i) {
            if (currentState.charAt(i) == '+') {
                mask |= 1 << i;
            }
        }
        return dfs(mask);
    }

    private boolean dfs(long mask) {
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
        for (int i = 0; i < n - 1; ++i) {
            if ((mask & (1 << i)) == 0 || (mask & (1 << (i + 1))) == 0) {
                continue;
            }
            if (dfs(mask ^ (1 << i) ^ (1 << (i + 1)))) {
                continue;
            }
            memo.put(mask, true);
            return true;
        }
        memo.put(mask, false);
        return false;
    }
}
```

### Solution 2

> **Thinking**
>
> The memoized search has $2^n$ states. Consecutive plus-runs are independent games. The Sprague–Grundy number of the position is the XOR of the runs; a nonzero XOR is a first-player win.

#### Java

```java
class Solution {
    private int n;
    private int[] sg;

    public boolean canWin(String currentState) {
        n = currentState.length();
        sg = new int[n + 1];
        Arrays.fill(sg, -1);
        int i = 0;
        int ans = 0;
        while (i < n) {
            int j = i;
            while (j < n && currentState.charAt(j) == '+') {
                ++j;
            }
            ans ^= win(j - i);
            i = j + 1;
        }
        return ans > 0;
    }

    private int win(int i) {
        if (sg[i] != -1) {
            return sg[i];
        }
        boolean[] vis = new boolean[n];
        for (int j = 0; j < i - 1; ++j) {
            vis[win(j) ^ win(i - j - 2)] = true;
        }
        for (int j = 0; j < n; ++j) {
            if (!vis[j]) {
                sg[i] = j;
                return j;
            }
        }
        return 0;
    }
}
```
