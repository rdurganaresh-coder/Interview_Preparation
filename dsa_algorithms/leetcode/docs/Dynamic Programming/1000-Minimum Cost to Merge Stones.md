# 1000. Minimum Cost to Merge Stones

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/minimum-cost-to-merge-stones/

---

[中文文档](/solution/1000-1099/1000.Minimum%20Cost%20to%20Merge%20Stones/README.md)

## Description

<p>There are <code>n</code> piles of <code>stones</code> arranged in a row. The <code>i<sup>th</sup></code> pile has <code>stones[i]</code> stones.</p>

<p>A move consists of merging exactly <code>k</code> <strong>consecutive</strong> piles into one pile, and the cost of this move is equal to the total number of stones in these <code>k</code> piles.</p>

<p>Return <em>the minimum cost to merge all piles of stones into one pile</em>. If it is impossible, return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> stones = [3,2,4,1], k = 2
<strong>Output:</strong> 20
<strong>Explanation:</strong> We start with [3, 2, 4, 1].
We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
We merge [4, 1] for a cost of 5, and we are left with [5, 5].
We merge [5, 5] for a cost of 10, and we are left with [10].
The total cost was 20, and this is the minimum possible.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> stones = [3,2,4,1], k = 3
<strong>Output:</strong> -1
<strong>Explanation:</strong> After any merge operation, there are 2 piles left, and we can&#39;t merge anymore.  So the task is impossible.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> stones = [3,5,1,2,6], k = 3
<strong>Output:</strong> 25
<strong>Explanation:</strong> We start with [3, 5, 1, 2, 6].
We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
We merge [3, 8, 6] for a cost of 17, and we are left with [17].
The total cost was 25, and this is the minimum possible.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == stones.length</code></li>
	<li><code>1 &lt;= n &lt;= 30</code></li>
	<li><code>1 &lt;= stones[i] &lt;= 100</code></li>
	<li><code>2 &lt;= k &lt;= 30</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Enumerating every merge order is correct, but with $n \le 30$ the number of valid partitions grows too quickly to search. Each move only merges $K$ consecutive piles, so the cost is determined by subproblems of the form “turn a contiguous segment into a given number of piles,” and the same interval is reached by many orders.
>
> Each merge reduces the pile count by $K-1$, so a single pile exists only when $(n-1)\bmod (K-1)=0$; otherwise the answer is $-1$. When it is feasible, merging $[i,j]$ into $k$ piles means some prefix becomes $1$ pile and the suffix becomes $k-1$ piles; merging into $1$ pile means first obtaining $K$ piles and then paying the sum of that interval.
>
> We therefore fill $f[i][j][k]$ by increasing interval length and keep a prefix sum $s$ for $O(1)$ range sums. The split $h$ always uses $f[i][h][1]$ on the left, matching the consecutive-merge constraint. The answer is $f[1][n][1]$.

#### Java

```java
class Solution {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) {
            return -1;
        }
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            s[i] = s[i - 1] + stones[i - 1];
        }
        int[][][] f = new int[n + 1][n + 1][K + 1];
        final int inf = 1 << 20;
        for (int[][] g : f) {
            for (int[] e : g) {
                Arrays.fill(e, inf);
            }
        }
        for (int i = 1; i <= n; ++i) {
            f[i][i][1] = 0;
        }
        for (int l = 2; l <= n; ++l) {
            for (int i = 1; i + l - 1 <= n; ++i) {
                int j = i + l - 1;
                for (int k = 1; k <= K; ++k) {
                    for (int h = i; h < j; ++h) {
                        f[i][j][k] = Math.min(f[i][j][k], f[i][h][1] + f[h + 1][j][k - 1]);
                    }
                }
                f[i][j][1] = f[i][j][K] + s[j] - s[i - 1];
            }
        }
        return f[1][n][1];
    }
}
```
