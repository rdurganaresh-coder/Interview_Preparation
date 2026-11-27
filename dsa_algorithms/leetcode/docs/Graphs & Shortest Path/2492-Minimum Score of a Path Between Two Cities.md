# 2492. Minimum Score of a Path Between Two Cities

**Difficulty:** Medium  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/

---

[中文文档](/solution/2400-2499/2492.Minimum%20Score%20of%20a%20Path%20Between%20Two%20Cities/README.md)

## Description

<p>You are given a positive integer <code>n</code> representing <code>n</code> cities numbered from <code>1</code> to <code>n</code>. You are also given a <strong>2D</strong> array <code>roads</code> where <code>roads[i] = [a<sub>i</sub>, b<sub>i</sub>, distance<sub>i</sub>]</code> indicates that there is a <strong>bidirectional </strong>road between cities <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> with a distance equal to <code>distance<sub>i</sub></code>. The cities graph is not necessarily connected.</p>

<p>The <strong>score</strong> of a path between two cities is defined as the <strong>minimum </strong>distance of a road in this path.</p>

<p>Return the <strong>minimum </strong>possible score of a path between cities 1 and <code>n</code>.</p>

<p><strong>Note</strong>:</p>

<ul>
	<li>A path is a sequence of roads between two cities.</li>
	<li>It is allowed for a path to contain the same road <strong>multiple</strong> times, and you can visit cities 1 and <code>n</code> multiple times along the path.</li>
	<li>The test cases are generated such that there is <strong>at least</strong> one path between 1 and <code>n</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2492.Minimum%20Score%20of%20a%20Path%20Between%20Two%20Cities/images/graph11.png" style="width: 190px; height: 231px;" />
<pre>
<strong>Input:</strong> n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
<strong>Output:</strong> 5
<strong>Explanation:</strong> The path from city 1 to 4 with the minimum score is: 1 -&gt; 2 -&gt; 4. The score of this path is min(9,5) = 5.
It can be shown that no other path has less score.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2492.Minimum%20Score%20of%20a%20Path%20Between%20Two%20Cities/images/graph22.png" style="width: 190px; height: 231px;" />
<pre>
<strong>Input:</strong> n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The path from city 1 to 4 with the minimum score is: 1 -&gt; 2 -&gt; 1 -&gt; 3 -&gt; 4. The score of this path is min(2,2,4,7) = 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= roads.length &lt;= 10<sup>5</sup></code></li>
	<li><code>roads[i].length == 3</code></li>
	<li><code>1 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li><code>1 &lt;= distance<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
	<li>There are no repeated edges.</li>
	<li>There is at least one path between <code>1</code> and <code>n</code>.</li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> Edges may be reused and $1$ is connected to $n$. A path's score is its lightest edge, and any $1$– $n$ walk can reach every edge of that component, so the answer is the minimum weight in the component of $1$.
>
> DFS from $1$, updating the answer on every edge.

According to the problem description, each edge can be traversed multiple times, and it is guaranteed that node $1$ and node $n$ are in the same connected component. Therefore, the problem is actually asking for the minimum edge weight in the connected component containing node $1$.

We first build an undirected graph $g$ from $\textit{roads}$, then perform DFS starting from node $1$. While traversing the connected component, we update the answer with $\textit{ans} = \min(\textit{ans}, w)$ for each edge visited.

The time complexity is $O(n + m)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the number of nodes and edges, respectively.

#### Java

```java
class Solution {
    private int ans;
    private boolean[] vis;
    private List<int[]>[] g;

    public int minScore(int n, int[][] roads) {
        g = new ArrayList[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());

        for (int[] e : roads) {
            int a = e[0], b = e[1], w = e[2];
            g[a].add(new int[] {b, w});
            g[b].add(new int[] {a, w});
        }

        ans = Integer.MAX_VALUE;
        vis = new boolean[n + 1];

        dfs(1);
        return ans;
    }

    private void dfs(int a) {
        vis[a] = true;
        for (int[] nb : g[a]) {
            int b = nb[0], w = nb[1];
            ans = Math.min(ans, w);
            if (!vis[b]) {
                dfs(b);
            }
        }
    }
}
```

### Solution 2: BFS

> **Thinking**
>
> Method 1 walks the component of city $1$ by recursion and keeps the minimum edge weight. A chain of roads uses a call depth equal to the node count. The same visited set also works with a queue and expands the component layer by layer.

We can also use BFS to solve this problem. Enqueue node $1$ and expand the connected component layer by layer, updating the answer with $\textit{ans} = \min(\textit{ans}, w)$ whenever an edge is visited.

The time complexity is $O(n + m)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the number of nodes and edges, respectively.

#### Java

```java
class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());

        for (int[] e : roads) {
            int a = e[0], b = e[1], w = e[2];
            g[a].add(new int[] {b, w});
            g[b].add(new int[] {a, w});
        }

        boolean[] vis = new boolean[n + 1];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        vis[1] = true;
        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; --k) {
                int a = q.pollFirst();
                for (int[] nb : g[a]) {
                    int b = nb[0], w = nb[1];
                    ans = Math.min(ans, w);
                    if (!vis[b]) {
                        vis[b] = true;
                        q.offer(b);
                    }
                }
            }
        }
        return ans;
    }
}
```

### Solution 3: Explicit Stack

> **Thinking**
>
> Edges may be reused and $1$ is connected to $n$. A path's score is its lightest edge, and any $1$–$n$ walk can reach every edge of that component, so the answer is the minimum weight in the component of $1$. With $n \le 10^5$, recursing through that component is too deep: a chain makes the call depth $n$.
>
> An explicit stack starts at $1$. When a city is popped and still unvisited, every incident edge updates the minimum and unvisited neighbors are pushed.

According to the problem description, each edge can be traversed multiple times, and it is guaranteed that node $1$ and node $n$ are in the same connected component. Therefore, the problem is actually asking for the minimum edge weight in the connected component containing node $1$.

We first build an undirected graph $g$ from $\textit{roads}$, then walk from node $1$ with an explicit stack. When a node is popped, we update the answer with $\textit{ans} = \min(\textit{ans}, w)$ for each of its edges and push its unvisited neighbors.

The time complexity is $O(n + m)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the number of nodes and edges, respectively.

#### Java

```java
class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] g = new List[n + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : roads) {
            int a = e[0], b = e[1], w = e[2];
            g[a].add(new int[] {b, w});
            g[b].add(new int[] {a, w});
        }
        int ans = Integer.MAX_VALUE;
        boolean[] vis = new boolean[n + 1];
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(1);
        while (!stk.isEmpty()) {
            int a = stk.pop();
            if (vis[a]) {
                continue;
            }
            vis[a] = true;
            for (int[] nb : g[a]) {
                int b = nb[0], w = nb[1];
                ans = Math.min(ans, w);
                if (!vis[b]) {
                    stk.push(b);
                }
            }
        }
        return ans;
    }
}
```
