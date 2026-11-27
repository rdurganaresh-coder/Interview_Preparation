# 279. Perfect Squares

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/perfect-squares/

---

[中文文档](/solution/0200-0299/0279.Perfect%20Squares/README.md)

## Description

<p>Given an integer <code>n</code>, return <em>the least number of perfect square numbers that sum to</em> <code>n</code>.</p>

<p>A <strong>perfect square</strong> is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, <code>1</code>, <code>4</code>, <code>9</code>, and <code>16</code> are perfect squares while <code>3</code> and <code>11</code> are not.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 12
<strong>Output:</strong> 3
<strong>Explanation:</strong> 12 = 4 + 4 + 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 13
<strong>Output:</strong> 2
<strong>Explanation:</strong> 13 = 4 + 9.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming (Complete Knapsack)

> **Thinking**
>
> Perfect squares may be reused, so the fewest that sum to $n$ is an unbounded knapsack with items $1^2,\ldots,m^2$ where $m=\lfloor\sqrt{n}\rfloor$.
>
> $f[i][j]$ is the fewest squares among the first $i$ kinds that sum to $j$: skip $i^2$, or take one more copy.

#### Java

```java
class Solution {
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        int[][] f = new int[m + 1][n + 1];
        for (var g : f) {
            Arrays.fill(g, 1 << 30);
        }
        f[0][0] = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= i * i) {
                    f[i][j] = Math.min(f[i][j], f[i][j - i * i] + 1);
                }
            }
        }
        return f[m][n];
    }
}
```

### Solution 2: Optimized Dynamic Programming

> **Thinking**
>
> $f[i][j]$ depends only on $f[i-1][j]$ and $f[i][j-i^2]$, so a 1-D array updated in increasing $j$ is enough.

$f[i][j]$ depends only on $f[i - 1][j]$ and $f[i][j - i^2]$, so the table can be rolled into a 1D array of space $O(n)$. The time complexity stays $O(mn)$.

#### Java

```java
class Solution {
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        int[] f = new int[n + 1];
        Arrays.fill(f, 1 << 30);
        f[0] = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = i * i; j <= n; ++j) {
                f[j] = Math.min(f[j], f[j - i * i] + 1);
            }
        }
        return f[n];
    }
}
```
