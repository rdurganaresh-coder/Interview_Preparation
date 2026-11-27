# 956. Tallest Billboard

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/tallest-billboard/

---

[中文文档](/solution/0900-0999/0956.Tallest%20Billboard/README.md)

## Description

<p>You are installing a billboard and want it to have the largest height. The billboard will have two steel supports, one on each side. Each steel support must be an equal height.</p>

<p>You are given a collection of <code>rods</code> that can be welded together. For example, if you have rods of lengths <code>1</code>, <code>2</code>, and <code>3</code>, you can weld them together to make a support of length <code>6</code>.</p>

<p>Return <em>the largest possible height of your billboard installation</em>. If you cannot support the billboard, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> rods = [1,2,3,6]
<strong>Output:</strong> 6
<strong>Explanation:</strong> We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> rods = [1,2,3,4,5,6]
<strong>Output:</strong> 10
<strong>Explanation:</strong> We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> rods = [1,2]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The billboard cannot be supported, so we return 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= rods.length &lt;= 20</code></li>
	<li><code>1 &lt;= rods[i] &lt;= 1000</code></li>
	<li><code>sum(rods[i]) &lt;= 5000</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Each rod goes left, right, or is discarded; the two sides should match and be as tall as possible. $3^n$ assignments are too many. The useful state is the largest common height after considering rod $i$ with current difference $j$. Three transitions cover the choices; a difference of $0$ is a feasible height. Memoization cuts repeats.

#### Java

```java
class Solution {
    private Integer[][] f;
    private int[] rods;
    private int n;

    public int tallestBillboard(int[] rods) {
        int s = 0;
        for (int x : rods) {
            s += x;
        }
        n = rods.length;
        this.rods = rods;
        f = new Integer[n][s + 1];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= n) {
            return j == 0 ? 0 : -(1 << 30);
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        int ans = Math.max(dfs(i + 1, j), dfs(i + 1, j + rods[i]));
        ans = Math.max(ans, dfs(i + 1, Math.abs(rods[i] - j)) + Math.min(j, rods[i]));
        return f[i][j] = ans;
    }
}
```

### Solution 2

> **Thinking**
>
> The search becomes bottom-up: $f[i][j]$ is the best common height using the first $i$ rods with difference $j$. The transitions match the recursion, without call overhead. The answer is $f[n][0]$.

#### Java

```java
class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int s = 0;
        for (int x : rods) {
            s += x;
        }
        int[][] f = new int[n + 1][s + 1];
        for (var e : f) {
            Arrays.fill(e, -(1 << 30));
        }
        f[0][0] = 0;
        for (int i = 1, t = 0; i <= n; ++i) {
            int x = rods[i - 1];
            t += x;
            for (int j = 0; j <= t; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= x) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - x]);
                }
                if (j + x <= t) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j + x] + x);
                }
                if (j < x) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][x - j] + x - j);
                }
            }
        }
        return f[n][0];
    }
}
```
