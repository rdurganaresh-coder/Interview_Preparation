# 743. Network Delay Time

**Difficulty:** Medium  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/network-delay-time/

---

[中文文档](/solution/0700-0799/0743.Network%20Delay%20Time/README.md)

## Description

<p>You are given a network of <code>n</code> nodes, labeled from <code>1</code> to <code>n</code>. You are also given <code>times</code>, a list of travel times as directed edges <code>times[i] = (u<sub>i</sub>, v<sub>i</sub>, w<sub>i</sub>)</code>, where <code>u<sub>i</sub></code> is the source node, <code>v<sub>i</sub></code> is the target node, and <code>w<sub>i</sub></code> is the time it takes for a signal to travel from source to target.</p>

<p>We will send a signal from a given node <code>k</code>. Return <em>the <strong>minimum</strong> time it takes for all the</em> <code>n</code> <em>nodes to receive the signal</em>. If it is impossible for all the <code>n</code> nodes to receive the signal, return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0700-0799/0743.Network%20Delay%20Time/images/931_example_1.png" style="width: 217px; height: 239px;" />
<pre>
<strong>Input:</strong> times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> times = [[1,2,1]], n = 2, k = 1
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> times = [[1,2,1]], n = 2, k = 2
<strong>Output:</strong> -1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= times.length &lt;= 6000</code></li>
	<li><code>times[i].length == 3</code></li>
	<li><code>1 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n</code></li>
	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
	<li><code>0 &lt;= w<sub>i</sub> &lt;= 100</code></li>
	<li>All the pairs <code>(u<sub>i</sub>, v<sub>i</sub>)</code> are <strong>unique</strong>. (i.e., no multiple edges.)</li>
</ul>

## Solutions

### Solution 1: Naive Dijkstra Algorithm

> **Thinking**
>
> The time for every node to hear a signal from $k$ is the longest shortest-path distance. $n\le 100$ admits naive Dijkstra in $O(n^2)$.
>
> Repeatedly pick the unused node with smallest tentative distance and relax its outgoing edges. An adjacency matrix stores weights, missing edges as $+\infty$.
>
> The answer is $\max(\textit{dist})$, or $-1$ if that value is still infinite.

We define $g[u][v]$ to represent the edge weight from node $u$ to node $v$. If there is no edge between node $u$ and node $v$, then $g[u][v] = +\infty$.

We maintain an array $\textit{dist}$, where $\textit{dist}[i]$ represents the shortest path length from node $k$ to node $i$. Initially, we set all $\textit{dist}[i]$ to $+\infty$, except for $\textit{dist}[k - 1] = 0$. We define an array $\textit{vis}$, where $\textit{vis}[i]$ indicates whether node $i$ has been visited. Initially, we set all $\textit{vis}[i]$ to $\textit{false}$.

Each time, we find the unvisited node $t$ with the smallest distance, and then perform relaxation operations centered on node $t$. For each node $j$, if $\textit{dist}[j] > \textit{dist}[t] + g[t][j]$, we update $\textit{dist}[j] = \textit{dist}[t] + g[t][j]$.

Finally, we return the maximum value in $\textit{dist}$ as the answer. If the answer is $+\infty$, it means there are unreachable nodes, and we return $-1$.

The time complexity is $O(n^2 + m)$, and the space complexity is $O(n^2)$, where $n$ and $m$ are the number of nodes and edges, respectively.

#### Java

```java
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n][n];
        int[] dist = new int[n];
        final int inf = 1 << 29;
        Arrays.fill(dist, inf);
        for (var e : g) {
            Arrays.fill(e, inf);
        }
        for (var e : times) {
            g[e[0] - 1][e[1] - 1] = e[2];
        }
        dist[k - 1] = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int t = -1;
            for (int j = 0; j < n; ++j) {
                if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            vis[t] = true;
            for (int j = 0; j < n; ++j) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        int ans = 0;
        for (int x : dist) {
            ans = Math.max(ans, x);
        }
        return ans == inf ? -1 : ans;
    }
}
```

### Solution 2: Heap-Optimized Dijkstra Algorithm

> **Thinking**
>
> Solution 1 scans all nodes to pick the next vertex; that is wasteful on a sparse graph. A heap pops the current best in $O(m \log m)$.
>
> Store an adjacency list. Pop $(d,u)$; skip stale distances; otherwise relax neighbors onto the heap. The answer is still the max finite distance.

We can use a priority queue (heap) to optimize the naive Dijkstra algorithm.

We define $g[u]$ to represent all adjacent edges of node $u$, and $\textit{dist}[u]$ to represent the shortest path length from node $k$ to node $u$. Initially, we set all $\textit{dist}[u]$ to $+\infty$, except for $\textit{dist}[k - 1] = 0$.

We define a priority queue $pq$, where each element is $(d, u)$, representing the distance $d$ from node $u$ to node $k$. Each time, we take out the node $(d, u)$ with the smallest distance from $pq$. If $d > \textit{dist}[u]$, we skip this node. Otherwise, we traverse all adjacent edges of node $u$. For each adjacent edge $(v, w)$, if $\textit{dist}[v] > \textit{dist}[u] + w$, we update $\textit{dist}[v] = \textit{dist}[u] + w$, and add $(\textit{dist}[v], v)$ to $\textit{pq}$.

Finally, we return the maximum value in $\textit{dist}$ as the answer. If the answer is $+\infty$, it means there are unreachable nodes, and we return $-1$.

The time complexity is $O(m \log m + n)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the number of nodes and edges, respectively.

#### Java

```java
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int inf = 1 << 29;
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : times) {
            g[e[0] - 1].add(new int[] {e[1] - 1, e[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, inf);
        dist[k - 1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, k - 1});
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int d = p[0], u = p[1];
            if (d > dist[u]) {
                continue;
            }
            for (var e : g[u]) {
                int v = e[0], w = e[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[] {dist[v], v});
                }
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == inf ? -1 : ans;
    }
}
```
