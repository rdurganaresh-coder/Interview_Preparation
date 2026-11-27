# 1466. Reorder Routes to Make All Paths Lead to the City Zero

**Difficulty:** Medium  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

---

[中文文档](/solution/1400-1499/1466.Reorder%20Routes%20to%20Make%20All%20Paths%20Lead%20to%20the%20City%20Zero/README.md)

## Description

<p>There are <code>n</code> cities numbered from <code>0</code> to <code>n - 1</code> and <code>n - 1</code> roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.</p>

<p>Roads are represented by <code>connections</code> where <code>connections[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> represents a road from city <code>a<sub>i</sub></code> to city <code>b<sub>i</sub></code>.</p>

<p>This year, there will be a big event in the capital (city <code>0</code>), and many people want to travel to this city.</p>

<p>Your task consists of reorienting some roads such that each city can visit the city <code>0</code>. Return the <strong>minimum</strong> number of edges changed.</p>

<p>It&#39;s <strong>guaranteed</strong> that each city can reach city <code>0</code> after reorder.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1400-1499/1466.Reorder%20Routes%20to%20Make%20All%20Paths%20Lead%20to%20the%20City%20Zero/images/sample_1_1819.png" style="width: 311px; height: 189px;" />
<pre>
<strong>Input:</strong> n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
<strong>Output:</strong> 3
<strong>Explanation: </strong>Change the direction of edges show in red such that each node can reach the node 0 (capital).
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1400-1499/1466.Reorder%20Routes%20to%20Make%20All%20Paths%20Lead%20to%20the%20City%20Zero/images/sample_2_1819.png" style="width: 509px; height: 79px;" />
<pre>
<strong>Input:</strong> n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
<strong>Output:</strong> 2
<strong>Explanation: </strong>Change the direction of edges show in red such that each node can reach the node 0 (capital).
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 3, connections = [[1,0],[2,0]]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>connections.length == n - 1</code></li>
	<li><code>connections[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n - 1</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> Ignoring direction, the graph is a tree; every city must reach $0$. Walking outward from $0$, an original forward edge must be reversed. Store cost $1$ with the given direction and $0$ with the reverse, then DFS the costs.

The route map given in the problem has $n$ nodes and $n-1$ edges. If we ignore the direction of the edges, then these $n$ nodes form a tree. The problem requires us to change the direction of some edges so that each node can reach node $0$.

We might as well consider starting from node $0$ and reaching all other nodes. The direction is opposite to the problem description, which means that when we build the graph, for the directed edge $[a, b]$, we should regard it as the directed edge $[b, a]$. That is to say, if it is from $a$ to $b$, we need to change the direction once; if it is from $b$ to $a$, no direction change is needed.

Next, we only need to start from node $0$, search all other nodes, and during the process, if we encounter an edge that needs to change direction, we accumulate the number of direction changes once.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the problem.

#### Java

```java
class Solution {
    private List<int[]>[] g;

    public int minReorder(int n, int[][] connections) {
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : connections) {
            int a = e[0], b = e[1];
            g[a].add(new int[] {b, 1});
            g[b].add(new int[] {a, 0});
        }
        return dfs(0, -1);
    }

    private int dfs(int a, int fa) {
        int ans = 0;
        for (var e : g[a]) {
            int b = e[0], c = e[1];
            if (b != fa) {
                ans += c + dfs(b, a);
            }
        }
        return ans;
    }
}
```

### Solution 2: BFS

> **Thinking**
>
> Method 1 walks the same adjacency list by recursion and counts edges that must be reversed. A chain of roads uses a call depth equal to the node count. BFS leaves $0$ level by level and adds the edge cost the first time a neighbor is seen, so the visit order differs from the recursion.

We can use the Breadth-First Search (BFS) method, starting from node $0$, to search all other nodes. During the process, if we encounter an edge that requires a change of direction, we increment the count of direction changes.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the problem.

#### Java

```java
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : connections) {
            int a = e[0], b = e[1];
            g[a].add(new int[] {b, 1});
            g[b].add(new int[] {a, 0});
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        boolean[] vis = new boolean[n];
        vis[0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int a = q.poll();
            for (var e : g[a]) {
                int b = e[0], c = e[1];
                if (!vis[b]) {
                    vis[b] = true;
                    q.offer(b);
                    ans += c;
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
> Ignoring direction, the graph is a tree. Walking outward from $0$, an original forward edge must be reversed. $n$ can reach $5\times 10^4$. On a chain the first recursive call always follows the only child, so the depth is $n$ and exceeds the default recursion limit.
>
> The cost of a tree edge is known as soon as the walk leaves its parent, so the total does not have to wait for the subtree to return.
>
> An explicit stack starts at $0$. After a node is popped, each neighbor that is not the parent adds its edge cost and is pushed. A forward edge costs $1$ and a reverse edge costs $0$.

The route map given in the problem has $n$ nodes and $n-1$ edges. If we ignore the direction of the edges, then these $n$ nodes form a tree. The problem requires us to change the direction of some edges so that each node can reach node $0$.

We might as well consider starting from node $0$ and reaching all other nodes. The direction is opposite to the problem description, which means that when we build the graph, for the directed edge $[a, b]$, we should regard it as the directed edge $[b, a]$. That is to say, if it is from $a$ to $b$, we need to change the direction once; if it is from $b$ to $a$, no direction change is needed.

An explicit stack walks the tree from node $0$. After a node is popped, each neighbor that is not the parent adds its edge weight to the answer and is pushed. A forward edge has weight $1$, and a reverse edge has weight $0$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the problem.

#### Java

```java
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : connections) {
            int a = e[0], b = e[1];
            g[a].add(new int[] {b, 1});
            g[b].add(new int[] {a, 0});
        }
        int ans = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int a = cur[0], fa = cur[1];
            for (var e : g[a]) {
                int b = e[0], c = e[1];
                if (b != fa) {
                    ans += c;
                    stk.push(new int[] {b, a});
                }
            }
        }
        return ans;
    }
}
```
