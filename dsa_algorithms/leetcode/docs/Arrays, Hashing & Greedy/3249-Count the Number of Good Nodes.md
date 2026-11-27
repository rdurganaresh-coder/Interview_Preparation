# 3249. Count the Number of Good Nodes

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-the-number-of-good-nodes/

---

[中文文档](/solution/3200-3299/3249.Count%20the%20Number%20of%20Good%20Nodes/README.md)

## Description

<p>There is an <strong>undirected</strong> tree with <code>n</code> nodes labeled from <code>0</code> to <code>n - 1</code>, and rooted at node <code>0</code>. You are given a 2D integer array <code>edges</code> of length <code>n - 1</code>, where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> in the tree.</p>

<p>A node is <strong>good</strong> if all the <span data-keyword="subtree">subtrees</span> rooted at its children have the same size.</p>

<p>Return the number of <strong>good</strong> nodes in the given tree.</p>

<p>A <strong>subtree</strong> of <code>treeName</code> is a tree consisting of a node in <code>treeName</code> and all of its descendants.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]</span></p>

<p><strong>Output:</strong> <span class="example-io">7</span></p>

<p><strong>Explanation:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3200-3299/3249.Count%20the%20Number%20of%20Good%20Nodes/images/tree1.png" style="width: 360px; height: 158px;" />
<p>All of the nodes of the given tree are good.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">edges = [[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]]</span></p>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3200-3299/3249.Count%20the%20Number%20of%20Good%20Nodes/images/screenshot-2024-06-03-193552.png" style="width: 360px; height: 303px;" />
<p>There are 6 good nodes in the given tree. They are colored in the image above.</p>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">edges = [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]]</span></p>

<p><strong>Output:</strong> <span class="example-io">12</span></p>

<p><strong>Explanation:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3200-3299/3249.Count%20the%20Number%20of%20Good%20Nodes/images/rob.jpg" style="width: 450px; height: 277px;" />
<p>All nodes except node 9 are good.</p>
</div>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li>The input is generated such that <code>edges</code> represents a valid tree.</li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> A node is good when all of its subtrees have equal size. $n\le 10^5$ forbids recomputing subtrees at every node. One DFS can compare child sizes on the way back and count the node itself.
>
> $\textit{dfs}(a,fa)$ returns the subtree size; $a$ is good if every child returns the same value. Root an unrooted tree at $0$. The time is linear.

First, we construct the adjacency list $g$ of the tree based on the given edges $\textit{edges}$, where $g[a]$ represents all the neighboring nodes of node $a$.

Next, we design a function $\textit{dfs}(a, fa)$ to calculate the number of nodes in the subtree rooted at node $a$ and to accumulate the count of good nodes. Here, $fa$ represents the parent node of node $a$.

The execution process of the function $\textit{dfs}(a, fa)$ is as follows:

1. Initialize variables $\textit{pre} = -1$, $\textit{cnt} = 1$, $ok = 1$, representing the number of nodes in a subtree of node $a$, the total number of nodes in all subtrees of node $a$, and whether node $a$ is a good node, respectively.
2. Traverse all neighboring nodes $b$ of node $a$. If $b$ is not equal to $fa$, recursively call $\textit{dfs}(b, a)$, with the return value being $\textit{cur}$, and add $\textit{cur}$ to $\textit{cnt}$. If $\textit{pre} < 0$, assign $\textit{cur}$ to $\textit{pre}$; otherwise, if $\textit{pre}$ is not equal to $\textit{cur}$, it means the number of nodes in different subtrees of node $a$ is different, and set $ok$ to $0$.
3. Finally, add $ok$ to the answer and return $\textit{cnt}$.

In the main function, we call $\textit{dfs}(0, -1)$ and return the final answer.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ represents the number of nodes.

#### Java

```java
class Solution {
    private int ans;
    private List<Integer>[] g;

    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs(0, -1);
        return ans;
    }

    private int dfs(int a, int fa) {
        int pre = -1, cnt = 1, ok = 1;
        for (int b : g[a]) {
            if (b != fa) {
                int cur = dfs(b, a);
                cnt += cur;
                if (pre < 0) {
                    pre = cur;
                } else if (pre != cur) {
                    ok = 0;
                }
            }
        }
        ans += ok;
        return cnt;
    }
}
```

### Solution 2: Explicit Stack

> **Thinking**
>
> A node is good when every child subtree has the same size. $n$ can reach $10^5$, so recomputing subtrees at every node is quadratic. On a chain the first recursive call always follows the only child, so the depth is $n$ and exceeds the default recursion limit.
>
> A subtree size is known only after every child has been finished.
>
> An explicit stack walks the tree in postorder. On entry, push the exit marker and then the children. On exit, read each child's subtree size. If those sizes match, the current node is good, and its own subtree size is stored. The unrooted tree is rooted at $0$.

First, we construct the adjacency list $g$ of the tree based on the given edges $\textit{edges}$, where $g[a]$ represents all the neighboring nodes of node $a$.

An explicit stack walks the tree from node $0$ in postorder. Entering a node pushes that node's exit marker and then its children, so the children finish first. On exit, each child's subtree size is already stored. Initialize $\textit{pre} = -1$, $\textit{cnt} = 1$, and $ok = 1$. For each child, add its subtree size to $\textit{cnt}$. If that size differs from $\textit{pre}$, set $ok$ to $0$. Then add $ok$ to the answer and store $\textit{cnt}$ as the current node's subtree size.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ represents the number of nodes.

#### Java

```java
class Solution {
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int ans = 0;
        int[] sz = new int[n];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int a = cur[0], fa = cur[1], state = cur[2];
            if (state == 0) {
                stk.push(new int[] {a, fa, 1});
                for (int b : g[a]) {
                    if (b != fa) {
                        stk.push(new int[] {b, a, 0});
                    }
                }
            } else {
                int pre = -1, cnt = 1, ok = 1;
                for (int b : g[a]) {
                    if (b != fa) {
                        int curSz = sz[b];
                        cnt += curSz;
                        if (pre < 0) {
                            pre = curSz;
                        } else if (pre != curSz) {
                            ok = 0;
                        }
                    }
                }
                ans += ok;
                sz[a] = cnt;
            }
        }
        return ans;
    }
}
```
