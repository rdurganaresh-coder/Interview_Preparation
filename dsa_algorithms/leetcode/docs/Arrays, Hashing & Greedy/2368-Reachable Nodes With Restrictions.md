# 2368. Reachable Nodes With Restrictions

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/reachable-nodes-with-restrictions/

---

[中文文档](/solution/2300-2399/2368.Reachable%20Nodes%20With%20Restrictions/README.md)

## Description

<p>There is an undirected tree with <code>n</code> nodes labeled from <code>0</code> to <code>n - 1</code> and <code>n - 1</code> edges.</p>

<p>You are given a 2D integer array <code>edges</code> of length <code>n - 1</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> in the tree. You are also given an integer array <code>restricted</code> which represents <strong>restricted</strong> nodes.</p>

<p>Return <em>the <strong>maximum</strong> number of nodes you can reach from node </em><code>0</code><em> without visiting a restricted node.</em></p>

<p>Note that node <code>0</code> will <strong>not</strong> be a restricted node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2300-2399/2368.Reachable%20Nodes%20With%20Restrictions/images/ex1drawio.png" style="width: 402px; height: 322px;" />
<pre>
<strong>Input:</strong> n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The diagram above shows the tree.
We have that [0,1,2,3] are the only nodes that can be reached from node 0 without visiting a restricted node.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2300-2399/2368.Reachable%20Nodes%20With%20Restrictions/images/ex2drawio.png" style="width: 412px; height: 312px;" />
<pre>
<strong>Input:</strong> n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The diagram above shows the tree.
We have that [0,5,6] are the only nodes that can be reached from node 0 without visiting a restricted node.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li><code>edges</code> represents a valid tree.</li>
	<li><code>1 &lt;= restricted.length &lt; n</code></li>
	<li><code>1 &lt;= restricted[i] &lt; n</code></li>
	<li>All the values of <code>restricted</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> From node $0$ on a tree we cannot enter restricted nodes. $n \le 10^5$, so one traversal is enough. Treat restricted nodes as already visited.
>
> Build the adjacency list and DFS: mark the current node and recurse on unseen neighbors, returning the reachable count.

First, we construct an adjacency list $g$ based on the given edges, where $g[i]$ represents the list of nodes adjacent to node $i$. Then we define a hash table $\textit{vis}$ to record the restricted nodes or nodes that have been visited, and initially add the restricted nodes to $\textit{vis}$.

Next, we define a depth-first search function $\textit{dfs}(i)$, which represents the number of nodes that can be reached starting from node $i$. In the $\textit{dfs}(i)$ function, we first add node $i$ to $\textit{vis}$, then traverse the nodes $j$ adjacent to node $i$. If $j$ is not in $\textit{vis}$, we recursively call $\textit{dfs}(j)$ and add the return value to the result.

Finally, we return $\textit{dfs}(0)$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

#### Java

```java
class Solution {
    private List<Integer>[] g;
    private boolean[] vis;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        g = new List[n];
        vis = new boolean[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        for (int i : restricted) {
            vis[i] = true;
        }
        return dfs(0);
    }

    private int dfs(int i) {
        vis[i] = true;
        int ans = 1;
        for (int j : g[i]) {
            if (!vis[j]) {
                ans += dfs(j);
            }
        }
        return ans;
    }
}
```

### Solution 2: BFS

> **Thinking**
>
> Method 1 counts nodes reachable from $0$ by recursion and skips restricted nodes. A chain uses a call depth equal to the node count. The same visited set also works with a queue and counts reachable nodes layer by layer.

Similar to Solution 1, we first construct an adjacency list $g$ based on the given edges, then define a hash table $\textit{vis}$ to record the restricted nodes or nodes that have been visited, and initially add the restricted nodes to $\textit{vis}$.

Next, we use breadth-first search to traverse the entire graph and count the number of reachable nodes. We define a queue $q$, initially add node $0$ to $q$, and add node $0$ to $\textit{vis}$. Then we continuously take out node $i$ from $q$, accumulate the answer, and add the unvisited adjacent nodes of node $i$ to $q$ and $\textit{vis}$.

After the traversal, we return the answer.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

#### Java

```java
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] g = new List[n];
        boolean[] vis = new boolean[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        for (int v : restricted) {
            vis[v] = true;
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int ans = 0;
        for (vis[0] = true; !q.isEmpty(); ++ans) {
            int i = q.pollFirst();
            for (int j : g[i]) {
                if (!vis[j]) {
                    q.offer(j);
                    vis[j] = true;
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
> From node $0$ on a tree we cannot enter restricted nodes. With $n \le 10^5$, one traversal is enough. Treat restricted nodes as already visited so the walk never crosses them. Recursing to the next node is too deep: a chain makes the call depth $n$.
>
> After the adjacency list is built, an explicit stack runs a depth-first walk. When a node is popped and still unvisited, it counts toward the answer and its unvisited neighbors are pushed.

First, we construct an adjacency list $g$ based on the given edges, where $g[i]$ represents the list of nodes adjacent to node $i$. Then we define a hash table $\textit{vis}$ to record the restricted nodes or nodes that have been visited, and initially add the restricted nodes to $\textit{vis}$.

Next, an explicit stack walks from node $0$. When node $i$ is popped and still unvisited, we add it to $\textit{vis}$, count it, and push its unvisited neighbors.

Finally, we return the number of nodes counted.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

#### Java

```java
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        boolean[] vis = new boolean[n];
        for (int i : restricted) {
            vis[i] = true;
        }
        int ans = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(0);
        while (!stk.isEmpty()) {
            int i = stk.pop();
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            ++ans;
            for (int j : g[i]) {
                if (!vis[j]) {
                    stk.push(j);
                }
            }
        }
        return ans;
    }
}
```
