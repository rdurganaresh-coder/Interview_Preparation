# 2581. Count Number of Possible Root Nodes

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-number-of-possible-root-nodes/

---

[中文文档](/solution/2500-2599/2581.Count%20Number%20of%20Possible%20Root%20Nodes/README.md)

## Description

<p>Alice has an undirected tree with <code>n</code> nodes labeled from <code>0</code> to <code>n - 1</code>. The tree is represented as a 2D integer array <code>edges</code> of length <code>n - 1</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> in the tree.</p>

<p>Alice wants Bob to find the root of the tree. She allows Bob to make several <strong>guesses</strong> about her tree. In one guess, he does the following:</p>

<ul>
	<li>Chooses two <strong>distinct</strong> integers <code>u</code> and <code>v</code> such that there exists an edge <code>[u, v]</code> in the tree.</li>
	<li>He tells Alice that <code>u</code> is the <strong>parent</strong> of <code>v</code> in the tree.</li>
</ul>

<p>Bob&#39;s guesses are represented by a 2D integer array <code>guesses</code> where <code>guesses[j] = [u<sub>j</sub>, v<sub>j</sub>]</code> indicates Bob guessed <code>u<sub>j</sub></code> to be the parent of <code>v<sub>j</sub></code>.</p>

<p>Alice being lazy, does not reply to each of Bob&#39;s guesses, but just says that <strong>at least</strong> <code>k</code> of his guesses are <code>true</code>.</p>

<p>Given the 2D integer arrays <code>edges</code>, <code>guesses</code> and the integer <code>k</code>, return <em>the <strong>number of possible nodes</strong> that can be the root of Alice&#39;s tree</em>. If there is no such tree, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2500-2599/2581.Count%20Number%20of%20Possible%20Root%20Nodes/images/ex-1.png" style="width: 727px; height: 250px;" /></p>

<pre>
<strong>Input:</strong> edges = [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> 
Root = 0, correct guesses = [1,3], [0,1], [2,4]
Root = 1, correct guesses = [1,3], [1,0], [2,4]
Root = 2, correct guesses = [1,3], [1,0], [2,4]
Root = 3, correct guesses = [1,0], [2,4]
Root = 4, correct guesses = [1,3], [1,0]
Considering 0, 1, or 2 as root node leads to 3 correct guesses.

</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2500-2599/2581.Count%20Number%20of%20Possible%20Root%20Nodes/images/ex-2.png" style="width: 600px; height: 303px;" /></p>

<pre>
<strong>Input:</strong> edges = [[0,1],[1,2],[2,3],[3,4]], guesses = [[1,0],[3,4],[2,1],[3,2]], k = 1
<strong>Output:</strong> 5
<strong>Explanation:</strong> 
Root = 0, correct guesses = [3,4]
Root = 1, correct guesses = [1,0], [3,4]
Root = 2, correct guesses = [1,0], [2,1], [3,4]
Root = 3, correct guesses = [1,0], [2,1], [3,2], [3,4]
Root = 4, correct guesses = [1,0], [2,1], [3,2]
Considering any node as root will give at least 1 correct guess. 

</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>edges.length == n - 1</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= guesses.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub>, u<sub>j</sub>, v<sub>j</sub> &lt;= n - 1</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li><code>u<sub>j</sub> != v<sub>j</sub></code></li>
	<li><code>edges</code> represents a valid tree.</li>
	<li><code>guesses[j]</code> is an edge of the tree.</li>
	<li><code>guesses</code> is unique.</li>
	<li><code>0 &lt;= k &lt;= guesses.length</code></li>
</ul>

## Solutions

### Solution 1: Tree DP (change root)

> **Thinking**
>
> The root is unknown; guesses are directed edges. A node is valid if, when it is the root, at least $k$ guesses match. A DFS from every root is $O(n^2)$.
>
> First count matches $\textit{cnt}$ with root $0$. Moving the root to a neighbour $j$ drops edge $(i,j)$ as a parent-to-child and adds $(j,i)$ if guessed. A second DFS visits every root with this $O(1)$ update.

First, we traverse the given edge set $\textit{edges}$ and convert it to an adjacency list $g$ where $g[i]$ represents the adjacent nodes of node $i$. Use a hash map $gs$ to record the given guess set $\textit{guesses}$.

Then, we start from node $0$ and perform a DFS to count the number of edges in $\textit{guesses}$ among all the nodes that can be reached from node $0$. We use the variable $\textit{cnt}$ to record this number.

Next, we start from node $0$ and perform a DFS to count the number of edges in $\textit{guesses}$ in each tree with $0$ as the root. If the number is greater than or equal to $k$, it means that this node is a possible root node, and we add $1$ to the answer.

Therefore, the problem becomes to count the number of edges in $\textit{guesses}$ in each tree with each node as the root. We already know that there are $\textit{cnt}$ edges in $\textit{guesses}$ among all the nodes that can be reached from node $0$. We can maintain this value by adding or subtracting the current edge in $\textit{guesses}$ in DFS.

Assume that we are currently traversing node $i$ and $\textit{cnt}$ represents the number of edges in $\textit{guesses}$ with $i$ as the root node. Then, for each adjacent node $j$ of $i$, we need to calculate the number of edges in $\textit{guesses}$ with $j$ as the root node. If $(i, j)$ is in $\textit{guesses}$, then there is no edge $(i, j)$ in the tree with $j$ as the root node, so $\textit{cnt}$ should decrease by $1$. If $(j, i)$ is in $\textit{guesses}$, then there is an extra edge $(i, j)$ in the tree with $j$ as the root node, so $\textit{cnt}$ should increase by $1$. That is, $f[j] = f[i] + (j, i) \in \textit{guesses} - (i, j) \in \textit{guesses}$. Where $f[i]$ represents the number of edges in $\textit{guesses}$ with $i$ as the root node.

The time complexity is $O(n + m)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the lengths of $\textit{edges}$ and $\textit{guesses}$ respectively.

#### Java

```java
class Solution {
    private List<Integer>[] g;
    private Map<Long, Integer> gs = new HashMap<>();
    private int ans;
    private int k;
    private int cnt;
    private int n;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        n = edges.length + 1;
        g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        for (var e : guesses) {
            int a = e[0], b = e[1];
            gs.merge(f(a, b), 1, Integer::sum);
        }
        dfs1(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs1(int i, int fa) {
        for (int j : g[i]) {
            if (j != fa) {
                cnt += gs.getOrDefault(f(i, j), 0);
                dfs1(j, i);
            }
        }
    }

    private void dfs2(int i, int fa) {
        ans += cnt >= k ? 1 : 0;
        for (int j : g[i]) {
            if (j != fa) {
                int a = gs.getOrDefault(f(i, j), 0);
                int b = gs.getOrDefault(f(j, i), 0);
                cnt -= a;
                cnt += b;
                dfs2(j, i);
                cnt -= b;
                cnt += a;
            }
        }
    }

    private long f(int i, int j) {
        return 1L * i * n + j;
    }
}
```

### Solution 2: Re-rooting DP + Explicit Stack

> **Thinking**
>
> The root is unknown, and each guess is a directed edge. A node is valid when at least $k$ guesses match after it becomes the root. With $n\le 10^5$, a separate walk from every root is quadratic, and recursion along a chain overflows Python once the chain reaches length $1000$. Moving the root across one edge changes only that edge: from parent $i$ to child $j$, $(i,j)$ is no longer parent-to-child and $(j,i)$ becomes parent-to-child. The first stack therefore starts at $0$ and adds each guess whose direction matches the parent-child edge, producing $\textit{cnt}$. The second stack stores the adjusted count in the frame. A popped node is counted when that value is at least $k$, and the child receives $\textit{cnt}-(i,j)+(j,i)$.

Turn $\textit{edges}$ into an adjacency list $g$, and store $\textit{guesses}$ in a hash map $gs$. An explicit stack walks the tree from node $0$. When the walk moves to a child $j$, add the multiplicity of $(i,j)$ in $gs$ to $\textit{cnt}$. After this walk, $\textit{cnt}$ is the number of correct guesses with root $0$.

The second stack reroots the tree. Each frame stores a node, its parent, and the number of correct guesses when that node is the root. It starts with $(0,-1,\textit{cnt})$. When node $i$ is popped, add $1$ to the answer if the stored count is at least $k$. For a neighbor $j$, $(i,j)$ is no longer parent-to-child and $(j,i)$ becomes parent-to-child, so the count passed to $j$ is $c-gs[(i,j)]+gs[(j,i)]$.

The time complexity is $O(n + m)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the lengths of $\textit{edges}$ and $\textit{guesses}$ respectively.

#### Java

```java
class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        Map<Long, Integer> gs = new HashMap<>();
        for (var e : guesses) {
            gs.merge(1L * e[0] * n + e[1], 1, Integer::sum);
        }
        int cnt = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1];
            for (int j : g[i]) {
                if (j != fa) {
                    cnt += gs.getOrDefault(1L * i * n + j, 0);
                    stk.push(new int[] {j, i});
                }
            }
        }
        int ans = 0;
        Deque<int[]> walk = new ArrayDeque<>();
        walk.push(new int[] {0, -1, cnt});
        while (!walk.isEmpty()) {
            int[] cur = walk.pop();
            int i = cur[0], fa = cur[1], c = cur[2];
            if (c >= k) {
                ++ans;
            }
            for (int j : g[i]) {
                if (j != fa) {
                    int a = gs.getOrDefault(1L * i * n + j, 0);
                    int b = gs.getOrDefault(1L * j * n + i, 0);
                    walk.push(new int[] {j, i, c - a + b});
                }
            }
        }
        return ans;
    }
}
```
