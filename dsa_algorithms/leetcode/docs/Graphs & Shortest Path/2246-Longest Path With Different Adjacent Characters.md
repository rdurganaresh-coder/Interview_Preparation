# 2246. Longest Path With Different Adjacent Characters

**Difficulty:** Hard  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/longest-path-with-different-adjacent-characters/

---

[中文文档](/solution/2200-2299/2246.Longest%20Path%20With%20Different%20Adjacent%20Characters/README.md)

## Description

<p>You are given a <strong>tree</strong> (i.e. a connected, undirected graph that has no cycles) <strong>rooted</strong> at node <code>0</code> consisting of <code>n</code> nodes numbered from <code>0</code> to <code>n - 1</code>. The tree is represented by a <strong>0-indexed</strong> array <code>parent</code> of size <code>n</code>, where <code>parent[i]</code> is the parent of node <code>i</code>. Since node <code>0</code> is the root, <code>parent[0] == -1</code>.</p>

<p>You are also given a string <code>s</code> of length <code>n</code>, where <code>s[i]</code> is the character assigned to node <code>i</code>.</p>

<p>Return <em>the length of the <strong>longest path</strong> in the tree such that no pair of <strong>adjacent</strong> nodes on the path have the same character assigned to them.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2200-2299/2246.Longest%20Path%20With%20Different%20Adjacent%20Characters/images/testingdrawio.png" style="width: 201px; height: 241px;" />
<pre>
<strong>Input:</strong> parent = [-1,0,0,1,1,2], s = &quot;abacbe&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The longest path where each two adjacent nodes have different characters in the tree is the path: 0 -&gt; 1 -&gt; 3. The length of this path is 3, so 3 is returned.
It can be proven that there is no longer path that satisfies the conditions. 
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2200-2299/2246.Longest%20Path%20With%20Different%20Adjacent%20Characters/images/graph2drawio.png" style="width: 201px; height: 221px;" />
<pre>
<strong>Input:</strong> parent = [-1,0,0,0], s = &quot;aabc&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The longest path where each two adjacent nodes have different characters is the path: 2 -&gt; 0 -&gt; 3. The length of this path is 3, so 3 is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == parent.length == s.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= parent[i] &lt;= n - 1</code> for all <code>i &gt;= 1</code></li>
	<li><code>parent[0] == -1</code></li>
	<li><code>parent</code> represents a valid tree.</li>
	<li><code>s</code> consists of only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Tree-shaped DP

> **Thinking**
>
> We want the longest tree path whose adjacent labels differ. $n \le 10^5$ forbids pairing endpoints. A path either stays in one subtree or is the join of two downward chains at a vertex.
>
> DFS returns the longest downward chain whose first step has a different character. For each child, join the current best chain with the new one when labels differ, and keep the best downward length. Adding one at the end counts the node itself.

First, we construct an adjacency list $g$ based on the array $\textit{parent}$, where $g[i]$ represents all child nodes of node $i$.

Then we start DFS from the root node. For each node $i$, we traverse each child node $j$ in $g[i]$. If $s[i] \neq s[j]$, then we can start from node $i$, pass through node $j$, and reach a leaf node. The length of this path is $x = 1 + \textit{dfs}(j)$. We use $mx$ to record the longest path length starting from node $i$. At the same time, we update the answer $\textit{ans} = \max(\textit{ans}, mx + x)$ during the traversal process.

Finally, we return $\textit{ans} + 1$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

#### Java

```java
class Solution {
    private List<Integer>[] g;
    private String s;
    private int ans;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        g = new List[n];
        this.s = s;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parent[i]].add(i);
        }
        dfs(0);
        return ans + 1;
    }

    private int dfs(int i) {
        int mx = 0;
        for (int j : g[i]) {
            int x = dfs(j) + 1;
            if (s.charAt(i) != s.charAt(j)) {
                ans = Math.max(ans, mx + x);
                mx = Math.max(mx, x);
            }
        }
        return mx;
    }
}
```

### Solution 2: Tree DP + Explicit Stack

> **Thinking**
>
> We want the longest tree path whose adjacent labels differ. With $n \le 10^5$, recursing from the root for every downward chain is too deep: a chain makes the call depth $n$.
>
> Such a path either stays inside one subtree or joins two downward chains at one vertex. When a node is left, each child's downward length is already known. The chain can be attached only when $s[i] \neq s[j]$, and its length is the child's length plus one. Join that chain with the best one already seen, then keep the longer of the two as this node's downward chain.
>
> An explicit stack of $(\textit{node}, \textit{state})$ runs the postorder. On entry we push the exit marker and then the children, and on exit we update the answer and the downward length. Adding one at the end counts the nodes on the path.

First, we construct an adjacency list $g$ based on the array $\textit{parent}$, where $g[i]$ represents all child nodes of node $i$.

An explicit stack walks from the root in postorder. When node $i$ is left, each child $j$ contributes $x$, one more than the longest chain downward from $j$. If $s[i] \neq s[j]$, update the answer with $\textit{ans} = \max(\textit{ans}, mx + x)$ and then set $mx = \max(mx, x)$. Here $mx$ is the longest downward chain from $i$ whose first step has a different character.

Finally, we return $\textit{ans} + 1$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

#### Java

```java
class Solution {
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parent[i]].add(i);
        }
        int[] down = new int[n];
        int ans = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], state = cur[1];
            if (state == 0) {
                stk.push(new int[] {i, 1});
                for (int j : g[i]) {
                    stk.push(new int[] {j, 0});
                }
            } else {
                int mx = 0;
                for (int j : g[i]) {
                    int x = down[j] + 1;
                    if (s.charAt(i) != s.charAt(j)) {
                        ans = Math.max(ans, mx + x);
                        mx = Math.max(mx, x);
                    }
                }
                down[i] = mx;
            }
        }
        return ans + 1;
    }
}
```
