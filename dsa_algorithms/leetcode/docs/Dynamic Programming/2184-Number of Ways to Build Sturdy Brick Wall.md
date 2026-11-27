# 2184. Number of Ways to Build Sturdy Brick Wall

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/number-of-ways-to-build-sturdy-brick-wall/

---

[中文文档](/solution/2100-2199/2184.Number%20of%20Ways%20to%20Build%20Sturdy%20Brick%20Wall/README.md)

## Description

<p>You are given integers <code>height</code> and <code>width</code> which specify the dimensions of a brick wall you are building. You are also given a <strong>0-indexed</strong> array of <strong>unique</strong> integers <code>bricks</code>, where the <code>i<sup>th</sup></code> brick has a height of <code>1</code> and a width of <code>bricks[i]</code>. You have an <strong>infinite </strong>supply of each type of brick and bricks may <strong>not</strong> be rotated.</p>

<p>Each row in the wall must be exactly <code>width</code> units long. For the wall to be <strong>sturdy</strong>, adjacent rows in the wall should <strong>not </strong>join bricks at the same location, except at the ends of the wall.</p>

<p>Return <em>the number of ways to build a <strong>sturdy </strong>wall.</em> Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2100-2199/2184.Number%20of%20Ways%20to%20Build%20Sturdy%20Brick%20Wall/images/image-20220220190749-1.png" style="width: 919px; height: 250px;" />
<pre>
<strong>Input:</strong> height = 2, width = 3, bricks = [1,2]
<strong>Output:</strong> 2
<strong>Explanation:</strong>
The first two walls in the diagram show the only two ways to build a sturdy brick wall.
Note that the third wall in the diagram is not sturdy because adjacent rows join bricks 2 units from the left.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> height = 1, width = 1, bricks = [5]
<strong>Output:</strong> 0
<strong>Explanation:</strong>
There are no ways to build a sturdy wall because the only type of brick we have is longer than the width of the wall.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= height &lt;= 100</code></li>
	<li><code>1 &lt;= width &lt;= 10</code></li>
	<li><code>1 &lt;= bricks.length &lt;= 10</code></li>
	<li><code>1 &lt;= bricks[i] &lt;= 10</code></li>
	<li>All the values of <code>bricks</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Each row is a partition of the width, and vertical cracks of adjacent rows must not align. Height and brick types are limited, so we list all one-row layouts and their compatibility.
>
> DFS builds sequences of brick lengths summing to $\textit{width}$. Two sequences are incompatible if they share a prefix sum other than $0$ and $\textit{width}$. Row-to-row transfer is path counting on that graph: $dp[i][j]$ is the number of ways to use layout $j$ on row $i$.
>
> Initialize the first row with ones, add compatible predecessors, and sum the last row modulo $10^9+7$.

#### Java

```java
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private static final int MOD = (int) 1e9 + 7;
    private int width;
    private int[] bricks;

    public int buildWall(int height, int width, int[] bricks) {
        this.width = width;
        this.bricks = bricks;
        dfs(0);
        int n = res.size();
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n; ++i) {
            if (check(res.get(i), res.get(i))) {
                g[i].add(i);
            }
            for (int j = i + 1; j < n; ++j) {
                if (check(res.get(i), res.get(j))) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }
        int[][] dp = new int[height][n];
        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < height; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k : g[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            ans = (ans + dp[height - 1][j]) % MOD;
        }
        return ans;
    }

    private boolean check(List<Integer> a, List<Integer> b) {
        int s1 = a.get(0);
        int s2 = b.get(0);
        int i = 1, j = 1;
        while (i < a.size() && j < b.size()) {
            if (s1 == s2) {
                return false;
            }
            if (s1 < s2) {
                s1 += a.get(i++);
            } else {
                s2 += b.get(j++);
            }
        }
        return true;
    }

    private void dfs(int v) {
        if (v > width) {
            return;
        }
        if (v == width) {
            res.add(new ArrayList<>(t));
            return;
        }
        for (int x : bricks) {
            t.add(x);
            dfs(v + x);
            t.remove(t.size() - 1);
        }
    }
}
```
