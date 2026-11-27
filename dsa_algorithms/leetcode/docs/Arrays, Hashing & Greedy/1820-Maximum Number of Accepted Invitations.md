# 1820. Maximum Number of Accepted Invitations

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-number-of-accepted-invitations/

---

[中文文档](/solution/1800-1899/1820.Maximum%20Number%20of%20Accepted%20Invitations/README.md)

## Description

<p>There are <code>m</code> boys and <code>n</code> girls in a class attending an upcoming party.</p>

<p>You are given an <code>m x n</code> integer matrix <code>grid</code>, where <code>grid[i][j]</code> equals <code>0</code> or <code>1</code>. If <code>grid[i][j] == 1</code>, then that means the <code>i<sup>th</sup></code> boy can invite the <code>j<sup>th</sup></code> girl to the party. A boy can invite at most<strong> one girl</strong>, and a girl can accept at most <strong>one invitation</strong> from a boy.</p>

<p>Return <em>the <strong>maximum</strong> possible number of accepted invitations.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,1,1],
               [1,0,1],
               [0,0,1]]
<strong>Output:</strong> 3<strong>
Explanation:</strong> The invitations are sent as follows:
- The 1<sup>st</sup> boy invites the 2<sup>nd</sup> girl.
- The 2<sup>nd</sup> boy invites the 1<sup>st</sup> girl.
- The 3<sup>rd</sup> boy invites the 3<sup>rd</sup> girl.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> grid = [[1,0,1,0],
               [1,0,0,0],
               [0,0,1,0],
               [1,1,1,0]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The invitations are sent as follows:
-The 1<sup>st</sup> boy invites the 3<sup>rd</sup> girl.
-The 2<sup>nd</sup> boy invites the 1<sup>st</sup> girl.
-The 3<sup>rd</sup> boy invites no one.
-The 4<sup>th</sup> boy invites the 2<sup>nd</sup> girl.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>grid.length == m</code></li>
	<li><code>grid[i].length == n</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>

## Solutions

### Solution 1: Hungarian Algorithm

> **Thinking**
>
> Boys and girls form a bipartite invitation graph; each person matches at most once. Enumerating matchings is exponential and $m,n\le 200$ forbids it.
>
> This is maximum bipartite matching. The Hungarian algorithm searches an augmenting path from each unmatched left vertex: DFS over unused right vertices, and rematch the previous partner if needed. Each left vertex is searched once, which is fast enough here.

This problem belongs to the maximum matching problem of bipartite graphs, which is suitable for solving with the Hungarian algorithm.

The core idea of the Hungarian algorithm is to continuously start from unmatched points, look for augmenting paths, and stop when there are no augmenting paths. This gives the maximum match.

The time complexity is $O(mn)$.

#### Java

```java
class Solution {
    private int[][] grid;
    private boolean[] vis;
    private int[] match;
    private int n;

    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        vis = new boolean[n];
        match = new int[n];
        Arrays.fill(match, -1);
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            Arrays.fill(vis, false);
            if (find(i)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean find(int i) {
        for (int j = 0; j < n; ++j) {
            if (grid[i][j] == 1 && !vis[j]) {
                vis[j] = true;
                if (match[j] == -1 || find(match[j])) {
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
```
