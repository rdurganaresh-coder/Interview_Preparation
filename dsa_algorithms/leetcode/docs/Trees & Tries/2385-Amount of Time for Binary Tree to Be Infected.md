# 2385. Amount of Time for Binary Tree to Be Infected

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

---

[中文文档](/solution/2300-2399/2385.Amount%20of%20Time%20for%20Binary%20Tree%20to%20Be%20Infected/README.md)

## Description

<p>You are given the <code>root</code> of a binary tree with <strong>unique</strong> values, and an integer <code>start</code>. At minute <code>0</code>, an <strong>infection</strong> starts from the node with value <code>start</code>.</p>

<p>Each minute, a node becomes infected if:</p>

<ul>
	<li>The node is currently uninfected.</li>
	<li>The node is adjacent to an infected node.</li>
</ul>

<p>Return <em>the number of minutes needed for the entire tree to be infected.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2300-2399/2385.Amount%20of%20Time%20for%20Binary%20Tree%20to%20Be%20Infected/images/image-20220625231744-1.png" style="width: 400px; height: 306px;" />
<pre>
<strong>Input:</strong> root = [1,5,3,null,4,10,6,9,2], start = 3
<strong>Output:</strong> 4
<strong>Explanation:</strong> The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2300-2399/2385.Amount%20of%20Time%20for%20Binary%20Tree%20to%20Be%20Infected/images/image-20220625231812-2.png" style="width: 75px; height: 66px;" />
<pre>
<strong>Input:</strong> root = [1], start = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> At minute 0, the only node in the tree is infected so we return 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li>Each node has a <strong>unique</strong> value.</li>
	<li>A node with a value of <code>start</code> exists in the tree.</li>
</ul>

## Solutions

### Solution 1: Two DFS

> **Thinking**
>
> Infection travels along tree edges; the time is the eccentricity of $\textit{start}$. Up to $10^5$ nodes, so parent links must be explicit.
>
> The first DFS builds an undirected adjacency list; the second DFS from $\textit{start}$ returns the farthest depth. Both are linear.

First, we build a graph through one DFS, and get an adjacency list $g$, where $g[\textit{node}]$ represents all nodes connected to the node $\textit{node}$.

Then, we use $\textit{start}$ as the starting point, and search the entire tree through DFS to find the farthest distance, which is the answer.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree.

#### Java

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer, List<Integer>> g = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        dfs(root, null);
        return dfs2(start, -1);
    }

    private void dfs(TreeNode node, TreeNode fa) {
        if (node == null) {
            return;
        }
        if (fa != null) {
            g.computeIfAbsent(node.val, k -> new ArrayList<>()).add(fa.val);
            g.computeIfAbsent(fa.val, k -> new ArrayList<>()).add(node.val);
        }
        dfs(node.left, node);
        dfs(node.right, node);
    }

    private int dfs2(int node, int fa) {
        int ans = 0;
        for (int nxt : g.getOrDefault(node, List.of())) {
            if (nxt != fa) {
                ans = Math.max(ans, 1 + dfs2(nxt, node));
            }
        }
        return ans;
    }
}
```

### Solution 2: Explicit Stack

> **Thinking**
>
> Infection spreads along parent and child edges, so the minutes needed are the farthest distance from $\textit{start}$. Recording those edges and then returning a depth is correct on a short tree.
>
> The tree can contain $10^5$ nodes. A left chain makes both walks recurse once per node, which exceeds the call stack.
>
> Each walk only needs the current node and its parent, and a node's depth is one plus the maximum depth of its other neighbors. Those values can sit beside an explicit stack.
>
> The first stack records every parent edge in an undirected adjacency list, using the distinct node values as keys. The second stack enters a node, pushes its neighbors, and on exit writes one plus the maximum neighbor depth. The depth stored for $\textit{start}$ is the answer.

We traverse the binary tree with an explicit stack and record each parent-child edge in an undirected adjacency list $g$. Node values are distinct, so they are the graph keys.

A second explicit stack then walks outward from $\textit{start}$. On entry it pushes an exit marker and every neighbor except the parent; on exit the depth is one plus the maximum depth of those neighbors. The depth stored for $\textit{start}$ is the answer.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree.

#### Java

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static class Frame {
        TreeNode node;
        TreeNode fa;

        Frame(TreeNode node, TreeNode fa) {
            this.node = node;
            this.fa = fa;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        Deque<Frame> stk = new ArrayDeque<>();
        if (root != null) {
            stk.push(new Frame(root, null));
        }
        while (!stk.isEmpty()) {
            Frame cur = stk.pop();
            TreeNode node = cur.node;
            TreeNode fa = cur.fa;
            if (fa != null) {
                g.computeIfAbsent(node.val, k -> new ArrayList<>()).add(fa.val);
                g.computeIfAbsent(fa.val, k -> new ArrayList<>()).add(node.val);
            }
            if (node.right != null) {
                stk.push(new Frame(node.right, node));
            }
            if (node.left != null) {
                stk.push(new Frame(node.left, node));
            }
        }
        Map<Integer, Integer> dist = new HashMap<>();
        Deque<int[]> walk = new ArrayDeque<>();
        walk.push(new int[] {start, -1, 0});
        while (!walk.isEmpty()) {
            int[] cur = walk.pop();
            int node = cur[0], fa = cur[1], state = cur[2];
            List<Integer> nxts = g.getOrDefault(node, List.of());
            if (state == 0) {
                walk.push(new int[] {node, fa, 1});
                for (int i = nxts.size() - 1; i >= 0; --i) {
                    int nxt = nxts.get(i);
                    if (nxt != fa) {
                        walk.push(new int[] {nxt, node, 0});
                    }
                }
            } else {
                int best = 0;
                for (int nxt : nxts) {
                    if (nxt != fa) {
                        best = Math.max(best, 1 + dist.get(nxt));
                    }
                }
                dist.put(node, best);
            }
        }
        return dist.get(start);
    }
}
```
