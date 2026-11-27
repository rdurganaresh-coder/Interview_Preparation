# 2316. Count Unreachable Pairs of Nodes in an Undirected Graph

**Difficulty:** Medium  
**Category:** Linked Lists  
**LeetCode:** https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/

---

[中文文档](/solution/2300-2399/2316.Count%20Unreachable%20Pairs%20of%20Nodes%20in%20an%20Undirected%20Graph/README.md)

## Description

<p>You are given an integer <code>n</code>. There is an <strong>undirected</strong> graph with <code>n</code> nodes, numbered from <code>0</code> to <code>n - 1</code>. You are given a 2D integer array <code>edges</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> denotes that there exists an <strong>undirected</strong> edge connecting nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code>.</p>

<p>Return <em>the <strong>number of pairs</strong> of different nodes that are <strong>unreachable</strong> from each other</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2300-2399/2316.Count%20Unreachable%20Pairs%20of%20Nodes%20in%20an%20Undirected%20Graph/images/tc-3.png" style="width: 267px; height: 169px;" />
<pre>
<strong>Input:</strong> n = 3, edges = [[0,1],[0,2],[1,2]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2300-2399/2316.Count%20Unreachable%20Pairs%20of%20Nodes%20in%20an%20Undirected%20Graph/images/tc-2.png" style="width: 295px; height: 269px;" />
<pre>
<strong>Input:</strong> n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
<strong>Output:</strong> 14
<strong>Explanation:</strong> There are 14 pairs of nodes that are unreachable from each other:
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
Therefore, we return 14.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= edges.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li>There are no repeated edges.</li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> Unreachable pairs sit in different components. $n \le 10^5$, so we cannot enumerate pairs. The count is the product of component sizes.
>
> DFS yields each component size $t$. Multiply by the sum $s$ of earlier sizes, then add $t$ into $s$. Each vertex and edge is visited once.

For any two nodes in an undirected graph, if there is a path between them, then they are mutually reachable.

Therefore, we can use depth-first search to find the number of nodes $t$ in each connected component, and then multiply the current number of nodes $t$ in the connected component by the number of nodes $s$ in all previous connected components to obtain the number of unreachable node pairs in the current connected component, which is $s \times t$. Then, we add $t$ to $s$ and continue to search for the next connected component until all connected components have been searched, and we can obtain the final answer.

The time complexity is $O(n + m)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the number of nodes and edges, respectively.

#### Java

```java
class Solution {
    private List<Integer>[] g;
    private boolean[] vis;

    public long countPairs(int n, int[][] edges) {
        g = new List[n];
        vis = new boolean[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        long ans = 0, s = 0;
        for (int i = 0; i < n; ++i) {
            int t = dfs(i);
            ans += s * t;
            s += t;
        }
        return ans;
    }

    private int dfs(int i) {
        if (vis[i]) {
            return 0;
        }
        vis[i] = true;
        int cnt = 1;
        for (int j : g[i]) {
            cnt += dfs(j);
        }
        return cnt;
    }
}
```

### Solution 2: Explicit Stack

> **Thinking**
>
> Unreachable pairs sit in different components. With $n \le 10^5$ we cannot enumerate pairs. The count is the product of component sizes.
>
> Recursing from a node into each neighbor reaches depth equal to the component size on a chain. In Python the generator inside `sum` adds another frame, so a few hundred nodes already overflow the call stack. A component's size does not depend on visit order.
>
> Each component therefore uses an explicit stack: a node is marked when it is pushed, counted when it is popped, and only unmarked neighbors are pushed. Multiply the size $t$ by the sum $s$ of earlier sizes, then add $t$ into $s$.

For any two nodes in an undirected graph, if there is a path between them, then they are mutually reachable.

An explicit stack finds the number of nodes $t$ in each connected component. Starting from an unvisited node, we mark a node when pushing it, count it when popping it, and push only unmarked neighbors. Multiply $t$ by the number of nodes $s$ in all previous components to obtain the unreachable pairs $s \times t$, then add $t$ to $s$. Repeat until every node has been visited.

The time complexity is $O(n + m)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the number of nodes and edges, respectively.

#### Java

```java
class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        boolean[] vis = new boolean[n];
        long ans = 0, s = 0;
        for (int i = 0; i < n; ++i) {
            int t = dfs(g, vis, i);
            ans += s * t;
            s += t;
        }
        return ans;
    }

    private int dfs(List<Integer>[] g, boolean[] vis, int i) {
        if (vis[i]) {
            return 0;
        }
        vis[i] = true;
        int cnt = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(i);
        while (!stk.isEmpty()) {
            int u = stk.pop();
            ++cnt;
            for (int j : g[u]) {
                if (!vis[j]) {
                    vis[j] = true;
                    stk.push(j);
                }
            }
        }
        return cnt;
    }
}
```
