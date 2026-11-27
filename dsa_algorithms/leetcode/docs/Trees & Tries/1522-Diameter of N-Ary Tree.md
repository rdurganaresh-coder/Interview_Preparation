# 1522. Diameter of N-Ary Tree

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/diameter-of-n-ary-tree/

---

[中文文档](/solution/1500-1599/1522.Diameter%20of%20N-Ary%20Tree/README.md)

## Description

<p>Given a <code>root</code> of an <code>N-ary tree</code>, you need to compute the length of the diameter of the tree.</p>

<p>The diameter of an N-ary tree is the length of the <strong>longest</strong> path between any two nodes in the tree. This path may or may not pass through the root.</p>

<p>(<em>Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.)</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1500-1599/1522.Diameter%20of%20N-Ary%20Tree/images/sample_2_1897.png" style="width: 324px; height: 173px;" /></p>

<pre>
<strong>Input:</strong> root = [1,null,3,2,4,null,5,6]
<strong>Output:</strong> 3
<strong>Explanation: </strong>Diameter is shown in red color.</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1500-1599/1522.Diameter%20of%20N-Ary%20Tree/images/sample_1_1897.png" style="width: 253px; height: 246px;" /></strong></p>

<pre>
<strong>Input:</strong> root = [1,null,2,null,3,4,null,5,null,6]
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 3:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1500-1599/1522.Diameter%20of%20N-Ary%20Tree/images/sample_3_1897.png" style="width: 369px; height: 326px;" /></p>

<pre>
<strong>Input:</strong> root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
<strong>Output:</strong> 7
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The depth of the n-ary tree is less than or equal to <code>1000</code>.</li>
	<li>The total number of nodes is between <code>[1, 10<sup>4</sup>]</code>.</li>
</ul>

## Solutions

### Solution 1: DFS (Post-order Diameter)

> **Thinking**
>
> The diameter of an $N$-ary tree is the longest distance between two nodes. The tree can have thousands of nodes, so careless double walks waste work. The diameter through a node is the sum of its two deepest child heights.
>
> A post-order DFS gathers child heights, updates a global answer with the sum of the two largest, and returns the node's own height. One traversal examines every candidate without building another graph.

Traverse each node in post-order, record the two deepest child heights $m_1$ and $m_2$, and update the diameter with $m_1+m_2$. The height of a subtree is one plus the deepest child height.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

#### Java

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private int ans;

    public int diameter(Node root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        int m1 = 0, m2 = 0;
        for (Node child : root.children) {
            int t = dfs(child);
            if (t > m1) {
                m2 = m1;
                m1 = t;
            } else if (t > m2) {
                m2 = t;
            }
        }
        ans = Math.max(ans, m1 + m2);
        return 1 + m1;
    }
}
```

### Solution 2: Build Graph + Two DFS

> **Thinking**
>
> Solution 1 folds the diameter into a tree DP. If we only have adjacency, or want the classic graph algorithm, that coupling is inconvenient. Build an undirected graph, walk from an arbitrary node to a farthest node, then walk again from there; the second distance is the diameter. The two DFS passes match the tree DP asymptotically and differ only in implementation.

Convert the $N$-ary tree into an undirected graph. DFS from an arbitrary node to find the farthest node, then DFS again from that node. The farthest distance of the second search is the diameter of the tree.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

#### Java

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private Map<Node, Set<Node>> g;
    private Set<Node> vis;
    private Node next;
    private int ans;

    public int diameter(Node root) {
        g = new HashMap<>();
        build(root);
        vis = new HashSet<>();
        next = root;
        ans = 0;
        dfs(next, 0);
        vis.clear();
        dfs(next, 0);
        return ans;
    }

    private void dfs(Node u, int t) {
        if (vis.contains(u)) {
            return;
        }
        vis.add(u);
        if (t > ans) {
            ans = t;
            next = u;
        }
        if (g.containsKey(u)) {
            for (Node v : g.get(u)) {
                dfs(v, t + 1);
            }
        }
    }

    private void build(Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            g.computeIfAbsent(root, k -> new HashSet<>()).add(child);
            g.computeIfAbsent(child, k -> new HashSet<>()).add(root);
            build(child);
        }
    }
}
```

### Solution 3: Explicit Stack (Post-order Diameter)

> **Thinking**
>
> The diameter of an $N$-ary tree is the longest path between any two nodes. The depth can reach $1000$, so a post-order recursion along a single-child chain uses a call depth equal to the node count and overflows Python once the chain reaches length $1000$. Each node only needs the finished heights of its children: the sum of the two largest updates the diameter, and the node's own height is one plus the deepest child. A stack therefore stores a node together with a state. State $0$ pushes the exit frame and then the children, so the children finish first. State $1$ reads those heights, updates the diameter, and records the current height.

Start at the root and walk in post-order. The stack holds a node and a state. In state $0$, push the same node with state $1$, then push every non-null child. In state $1$, every child height is already stored. Take the two largest heights $m_1$ and $m_2$, update the diameter with $m_1+m_2$, and record the current height as $m_1+1$. An empty root has diameter $0$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

#### Java

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Map<Node, Integer> height = new HashMap<>();
        Deque<Node> nodes = new ArrayDeque<>();
        Deque<Integer> states = new ArrayDeque<>();
        nodes.push(root);
        states.push(0);
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            int state = states.pop();
            if (state == 0) {
                nodes.push(node);
                states.push(1);
                List<Node> children = node.children;
                for (int i = children.size() - 1; i >= 0; --i) {
                    Node child = children.get(i);
                    if (child != null) {
                        nodes.push(child);
                        states.push(0);
                    }
                }
            } else {
                int m1 = 0, m2 = 0;
                for (Node child : node.children) {
                    int t = height.getOrDefault(child, 0);
                    if (t > m1) {
                        m2 = m1;
                        m1 = t;
                    } else if (t > m2) {
                        m2 = t;
                    }
                }
                ans = Math.max(ans, m1 + m2);
                height.put(node, m1 + 1);
            }
        }
        return ans;
    }
}
```

### Solution 4: Build Graph + Two Explicit Stacks

> **Thinking**
>
> Solution 1 already obtains the diameter from child heights. The classic tree algorithm instead expands the $N$-ary tree into an undirected graph and searches twice for a farthest node. Building that graph and walking a chain by recursion also reach depth $1000$. The build uses a stack and writes each parent-child edge in both directions. Each search marks a node when it is pushed, so the undirected edge back to the parent is not expanded. The first search starts at the root, and the second starts at the node found by the first. The second distance is the diameter.

Walk the tree with a stack and turn each parent-child edge into two undirected edges. Then search twice with an explicit stack. From the start node, a popped node updates the farthest node with its distance, and every unvisited neighbor is pushed with that distance plus one. The first start is the root. The second start is the farthest node from the first search. The farthest distance of the second search is the diameter.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

#### Java

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        Map<Node, List<Node>> g = new HashMap<>();
        Set<Node> seen = new HashSet<>();
        Deque<Node> stk = new ArrayDeque<>();
        stk.push(root);
        seen.add(root);
        while (!stk.isEmpty()) {
            Node u = stk.pop();
            for (Node child : u.children) {
                if (child == null || !seen.add(child)) {
                    continue;
                }
                g.computeIfAbsent(u, k -> new ArrayList<>()).add(child);
                g.computeIfAbsent(child, k -> new ArrayList<>()).add(u);
                stk.push(child);
            }
        }
        Node[] nxt = new Node[] {root};
        farthest(g, root, nxt);
        return farthest(g, nxt[0], nxt);
    }

    private int farthest(Map<Node, List<Node>> g, Node start, Node[] nxt) {
        Set<Node> vis = new HashSet<>();
        Deque<Node> nodes = new ArrayDeque<>();
        Deque<Integer> dist = new ArrayDeque<>();
        nodes.push(start);
        dist.push(0);
        vis.add(start);
        int best = 0;
        nxt[0] = start;
        while (!nodes.isEmpty()) {
            Node u = nodes.pop();
            int t = dist.pop();
            if (t > best) {
                best = t;
                nxt[0] = u;
            }
            List<Node> vs = g.get(u);
            if (vs == null) {
                continue;
            }
            for (Node v : vs) {
                if (vis.add(v)) {
                    nodes.push(v);
                    dist.push(t + 1);
                }
            }
        }
        return best;
    }
}
```
