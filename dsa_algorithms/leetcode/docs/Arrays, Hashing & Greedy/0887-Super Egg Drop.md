# 887. Super Egg Drop

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/super-egg-drop/

---

[中文文档](/solution/0800-0899/0887.Super%20Egg%20Drop/README.md)

## Description

<p>You are given <code>k</code> identical eggs and you have access to a building with <code>n</code> floors labeled from <code>1</code> to <code>n</code>.</p>

<p>You know that there exists a floor <code>f</code> where <code>0 &lt;= f &lt;= n</code> such that any egg dropped at a floor <strong>higher</strong> than <code>f</code> will <strong>break</strong>, and any egg dropped <strong>at or below</strong> floor <code>f</code> will <strong>not break</strong>.</p>

<p>Each move, you may take an unbroken egg and drop it from any floor <code>x</code> (where <code>1 &lt;= x &lt;= n</code>). If the egg breaks, you can no longer use it. However, if the egg does not break, you may <strong>reuse</strong> it in future moves.</p>

<p>Return <em>the <strong>minimum number of moves</strong> that you need to determine <strong>with certainty</strong> what the value of </em><code>f</code> is.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> k = 1, n = 2
<strong>Output:</strong> 2
<strong>Explanation: </strong>
Drop the egg from floor 1. If it breaks, we know that f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> k = 2, n = 6
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> k = 3, n = 14
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= 100</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> With $k$ eggs and $n$ floors, minimize the worst-case drops. A cubic enumeration of the drop floor is heavy. For a fixed egg count the worst-case cost is monotone in the floor, so there is a floor that balances the break / survive subproblems.
>
> $\textit{dfs}(i,j)$ is $i$ floors and $j$ eggs. Binary-search the drop floor by comparing the two branches, then add one. One floor or one egg has a closed form.

#### Java

```java
class Solution {
    private int[][] f;

    public int superEggDrop(int k, int n) {
        f = new int[n + 1][k + 1];
        return dfs(n, k);
    }

    private int dfs(int i, int j) {
        if (i < 1) {
            return 0;
        }
        if (j == 1) {
            return i;
        }
        if (f[i][j] != 0) {
            return f[i][j];
        }
        int l = 1, r = i;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            int a = dfs(mid - 1, j - 1);
            int b = dfs(i - mid, j);
            if (a <= b) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return f[i][j] = Math.max(dfs(l - 1, j - 1), dfs(i - l, j)) + 1;
    }
}
```

### Solution 2

> **Thinking**
>
> The same transition fills $f[i][j]$ by floors and eggs, without recursion. One egg gives $f[i][1]=i$.
>
> The inner loop still binary-searches the balancing floor. The answer is $f[n][k]$, same asymptotics, flatter constants.

#### Java

```java
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= n; ++i) {
            f[i][1] = i;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 2; j <= k; ++j) {
                int l = 1, r = i;
                while (l < r) {
                    int mid = (l + r + 1) >> 1;
                    int a = f[mid - 1][j - 1];
                    int b = f[i - mid][j];
                    if (a <= b) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                f[i][j] = Math.max(f[l - 1][j - 1], f[i - l][j]) + 1;
            }
        }
        return f[n][k];
    }
}
```
