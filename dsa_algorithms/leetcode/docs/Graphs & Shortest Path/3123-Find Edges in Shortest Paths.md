# 3123. Find Edges in Shortest Paths

**Difficulty:** Hard  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/find-edges-in-shortest-paths/

---

[中文文档](/solution/3100-3199/3123.Find%20Edges%20in%20Shortest%20Paths/README.md)

## Description

<p>You are given an undirected weighted graph of <code>n</code> nodes numbered from 0 to <code>n - 1</code>. The graph consists of <code>m</code> edges represented by a 2D array <code>edges</code>, where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>, w<sub>i</sub>]</code> indicates that there is an edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> with weight <code>w<sub>i</sub></code>.</p>

<p>Consider all the shortest paths from node 0 to node <code>n - 1</code> in the graph. You need to find a <strong>boolean</strong> array <code>answer</code> where <code>answer[i]</code> is <code>true</code> if the edge <code>edges[i]</code> is part of <strong>at least</strong> one shortest path. Otherwise, <code>answer[i]</code> is <code>false</code>.</p>

<p>Return the array <code>answer</code>.</p>

<p><strong>Note</strong> that the graph may not be connected.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3100-3199/3123.Find%20Edges%20in%20Shortest%20Paths/images/graph35drawio-1.png" style="height: 129px; width: 250px;" />
<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 6, edges = [[0,1,4],[0,2,1],[1,3,2],[1,4,3],[1,5,1],[2,3,1],[3,5,3],[4,5,2]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[true,true,true,false,true,true,true,false]</span></p>

<p><strong>Explanation:</strong></p>

<p>The following are <strong>all</strong> the shortest paths between nodes 0 and 5:</p>

<ul>
	<li>The path <code>0 -&gt; 1 -&gt; 5</code>: The sum of weights is <code>4 + 1 = 5</code>.</li>
	<li>The path <code>0 -&gt; 2 -&gt; 3 -&gt; 5</code>: The sum of weights is <code>1 + 1 + 3 = 5</code>.</li>
	<li>The path <code>0 -&gt; 2 -&gt; 3 -&gt; 1 -&gt; 5</code>: The sum of weights is <code>1 + 1 + 2 + 1 = 5</code>.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3100-3199/3123.Find%20Edges%20in%20Shortest%20Paths/images/graphhhh.png" style="width: 185px; height: 136px;" />
<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 4, edges = [[2,0,1],[0,1,1],[0,3,4],[3,2,2]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[true,false,false,true]</span></p>

<p><strong>Explanation:</strong></p>

<p>There is one shortest path between nodes 0 and 3, which is the path <code>0 -&gt; 2 -&gt; 3</code> with the sum of weights <code>1 + 2 = 3</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>m == edges.length</code></li>
	<li><code>1 &lt;= m &lt;= min(5 * 10<sup>4</sup>, n * (n - 1) / 2)</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li><code>1 &lt;= w<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
	<li>There are no repeated edges.</li>
</ul>

## Solutions

### Solution 1: Heap Optimized Dijkstra

> **Thinking**
>
> Each edge must be tested for membership in some shortest $0$– $n-1$ path. Rerunning Dijkstra per edge repeats the same search $m$ times.
>
> Undirected edge $(a,b,w)$ lies on a shortest path iff walking backward from $n-1$ along $\textit{dist}[a]=\textit{dist}[b]+w$ reaches it. One backward BFS marks every such edge.
>
> Compute $\textit{dist}$ with heap Dijkstra, then BFS from $n-1$ and flag edges that satisfy the equality. If $n-1$ is unreachable every answer is false.

First, we create an adjacency list $g$ to store the edges of the graph. Then we create an array $\textit{dist}$ to store the shortest distance from node $0$ to other nodes. We initialize $\textit{dist}[0] = 0$, and the distance of other nodes is initialized to infinity.

Then, we use the Dijkstra algorithm to calculate the shortest distance from node $0$ to other nodes. The specific steps are as follows:

1. Create a priority queue $q$ to store the distance and node number of the nodes. Initially, add node $0$ to the queue with a distance of $0$.
2. Take a node $a$ from the queue. If the distance $da$ of $a$ is greater than $\textit{dist}[a]$, it means that $a$ has been updated, so skip it directly.
3. Traverse all neighbor nodes $b$ of node $a$. If $\textit{dist}[b] > \textit{dist}[a] + w$, update $\textit{dist}[b] = \textit{dist}[a] + w$, and add node $b$ to the queue.
4. Repeat steps 2 and 3 until the queue is empty.

Next, we create an answer array $\textit{ans}$ of length $m$, initially all elements are $\textit{false}$. If $\textit{dist}[n - 1]$ is infinity, it means that node $0$ cannot reach node $n - 1$, return $\textit{ans}$ directly. Otherwise, we start from node $n - 1$, traverse all edges, if the edge $(a, b, i)$ satisfies $\textit{dist}[a] = \textit{dist}[b] + w$, set $\textit{ans}[i]$ to $\textit{true}$, and add node $b$ to the queue.

Finally, return the answer.

The time complexity is $O(m \log m)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the number of nodes and edges respectively.

#### Java

```java
class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int m = edges.length;
        for (int i = 0; i < m; ++i) {
            int a = edges[i][0], b = edges[i][1], w = edges[i][2];
            g[a].add(new int[] {b, w, i});
            g[b].add(new int[] {a, w, i});
        }
        long[] dist = new long[n];
        final long inf = (long) 1e18;
        Arrays.fill(dist, inf);
        dist[0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[] {0, 0});
        while (!pq.isEmpty()) {
            var p = pq.poll();
            long da = p[0];
            int a = (int) p[1];
            if (da > dist[a]) {
                continue;
            }
            for (var e : g[a]) {
                int b = e[0], w = e[1];
                if (dist[b] > dist[a] + w) {
                    dist[b] = dist[a] + w;
                    pq.offer(new long[] {dist[b], b});
                }
            }
        }
        boolean[] ans = new boolean[m];
        if (dist[n - 1] == inf) {
            return ans;
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(n - 1);
        while (!q.isEmpty()) {
            int a = q.poll();
            for (var e : g[a]) {
                int b = e[0], w = e[1], i = e[2];
                if (dist[a] == dist[b] + w) {
                    ans[i] = true;
                    q.offer(b);
                }
            }
        }
        return ans;
    }
}
```
