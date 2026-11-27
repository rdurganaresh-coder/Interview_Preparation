# 3367. Maximize Sum of Weights after Edge Removals

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximize-sum-of-weights-after-edge-removals/

---

[中文文档](/solution/3300-3399/3367.Maximize%20Sum%20of%20Weights%20after%20Edge%20Removals/README.md)

## Description

<p>There exists an <strong>undirected</strong> tree with <code>n</code> nodes numbered <code>0</code> to <code>n - 1</code>. You are given a 2D integer array <code>edges</code> of length <code>n - 1</code>, where <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>, w<sub>i</sub>]</code> indicates that there is an edge between nodes <code>u<sub>i</sub></code> and <code>v<sub>i</sub></code> with weight <code>w<sub>i</sub></code> in the tree.</p>

<p>Your task is to remove <em>zero or more</em> edges such that:</p>

<ul>
	<li>Each node has an edge with <strong>at most</strong> <code>k</code> other nodes, where <code>k</code> is given.</li>
	<li>The sum of the weights of the remaining edges is <strong>maximized</strong>.</li>
</ul>

<p>Return the <strong>maximum </strong>possible sum of weights for the remaining edges after making the necessary removals.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">edges = [[0,1,4],[0,2,2],[2,3,12],[2,4,6]], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">22</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3300-3399/3367.Maximize%20Sum%20of%20Weights%20after%20Edge%20Removals/images/test1drawio.png" style="width: 250px; height: 250px;" /></p>

<ul>
	<li>Node 2 has edges with 3 other nodes. We remove the edge <code>[0, 2, 2]</code>, ensuring that no node has edges with more than <code>k = 2</code> nodes.</li>
	<li>The sum of weights is 22, and we can&#39;t achieve a greater sum. Thus, the answer is 22.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">edges = [[0,1,5],[1,2,10],[0,3,15],[3,4,20],[3,5,5],[0,6,10]], k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">65</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Since no node has edges connecting it to more than <code>k = 3</code> nodes, we don&#39;t remove any edges.</li>
	<li>The sum of weights is 65. Thus, the answer is 65.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= n - 1</code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>edges[i].length == 3</code></li>
	<li><code><font face="monospace">0 &lt;= edges[i][0] &lt;= n - 1</font></code></li>
	<li><code><font face="monospace">0 &lt;= edges[i][1] &lt;= n - 1</font></code></li>
	<li><code><font face="monospace">1 &lt;= edges[i][2] &lt;= 10<sup>6</sup></font></code></li>
	<li>The input is generated such that <code>edges</code> form a valid tree.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> After deletions every degree is at most $k$, and we want the maximum remaining weight. With $n \le 10^5$ this is a tree DP.
>
> Each subtree returns two values: the best score when the parent edge is free (up to $k$ child edges) and when the parent edge already uses one slot (up to $k-1$).
>
> A child edge is worth keeping when $w+b-a>0$; we take the largest such gains. The root answer is the better of its two values.

#### Java

```java
class Solution {
    private List<int[]>[] g;
    private int k;

    public long maximizeSumOfWeights(int[][] edges, int k) {
        this.k = k;
        int n = edges.length + 1;
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        var ans = dfs(0, -1);
        return Math.max(ans[0], ans[1]);
    }

    private long[] dfs(int u, int fa) {
        long s = 0;
        List<Long> t = new ArrayList<>();
        for (var e : g[u]) {
            int v = e[0], w = e[1];
            if (v == fa) {
                continue;
            }
            var res = dfs(v, u);
            s += res[0];
            long d = w + res[1] - res[0];
            if (d > 0) {
                t.add(d);
            }
        }
        t.sort(Comparator.reverseOrder());
        for (int i = 0; i < Math.min(t.size(), k - 1); ++i) {
            s += t.get(i);
        }
        return new long[] {s + (t.size() >= k ? t.get(k - 1) : 0), s};
    }
}
```

### Solution 2: Tree DP + Explicit Stack

> **Thinking**
>
> After the deletions every degree is at most $k$, and the remaining weight should be as large as possible. With $n \le 10^5$, a recursive tree DP from the root is too deep: a chain makes the call depth $n$.
>
> The best score of a subtree depends on whether the parent edge already uses one slot. With that slot free the node may keep up to $k$ edges to its children; with the slot taken it may keep only $k - 1$. Add each child at the score that does not use its own parent edge, then keep a child edge only when the gain $w + b - a$ is positive, and only the largest of those gains.
>
> An explicit stack of $(\textit{node}, \textit{parent}, \textit{state})$ runs the postorder. On entry we push the exit marker and then the children, and on exit we store the two scores. The root has no parent edge, so the answer is the larger of its two values.

#### Java

```java
class Solution {
    public long maximizeSumOfWeights(int[][] edges, int k) {
        int n = edges.length + 1;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[] {v, w});
            g[v].add(new int[] {u, w});
        }
        long[] keep = new long[n];
        long[] reserve = new long[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int u = cur[0], fa = cur[1], state = cur[2];
            if (state == 0) {
                stk.push(new int[] {u, fa, 1});
                for (var e : g[u]) {
                    if (e[0] != fa) {
                        stk.push(new int[] {e[0], u, 0});
                    }
                }
            } else {
                long s = 0;
                List<Long> t = new ArrayList<>();
                for (var e : g[u]) {
                    int v = e[0], w = e[1];
                    if (v == fa) {
                        continue;
                    }
                    s += keep[v];
                    long d = w + reserve[v] - keep[v];
                    if (d > 0) {
                        t.add(d);
                    }
                }
                t.sort(Comparator.reverseOrder());
                for (int i = 0; i < Math.min(t.size(), k - 1); ++i) {
                    s += t.get(i);
                }
                reserve[u] = s;
                keep[u] = s + (t.size() >= k ? t.get(k - 1) : 0);
            }
        }
        return Math.max(keep[0], reserve[0]);
    }
}
```
