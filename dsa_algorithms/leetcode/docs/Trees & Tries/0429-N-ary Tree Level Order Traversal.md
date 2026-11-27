# 429. N-ary Tree Level Order Traversal

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/n-ary-tree-level-order-traversal/

---

[中文文档](/solution/0400-0499/0429.N-ary%20Tree%20Level%20Order%20Traversal/README.md)

## Description

<p>Given an n-ary tree, return the <em>level order</em> traversal of its nodes&#39; values.</p>

<p><em>Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0400-0499/0429.N-ary%20Tree%20Level%20Order%20Traversal/images/narytreeexample.png" style="width: 100%; max-width: 300px;" /></p>

<pre>
<strong>Input:</strong> root = [1,null,3,2,4,null,5,6]
<strong>Output:</strong> [[1],[3,2,4],[5,6]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0400-0499/0429.N-ary%20Tree%20Level%20Order%20Traversal/images/sample_4_964.png" style="width: 296px; height: 241px;" /></p>

<pre>
<strong>Input:</strong> root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
<strong>Output:</strong> [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The height of the n-ary tree is less than or equal to <code>1000</code></li>
	<li>The total number of nodes is between <code>[0, 10<sup>4</sup>]</code></li>
</ul>

## Solutions

### Solution 1: BFS

> **Thinking**
>
> Level order groups values by depth. A depth-first walk without a layer index would mix levels.
>
> A queue holds the current layer: snapshot its length, pop that many nodes into a row, and enqueue their children. An empty root yields an empty list.
>
> The snapshot of the queue length isolates one layer and keeps left-to-right order.

First, we check if the root node is null. If it is, we return an empty list directly.

Otherwise, we create a queue $q$ and initially add the root node to the queue.

When the queue is not empty, we loop through the following operations:

1. Create an empty list $t$ to store the values of the current level nodes.
2. For each node in the queue, add its value to $t$ and add its child nodes to the queue.
3. Add $t$ to the result list $\textit{ans}$.

Finally, return the result list $\textit{ans}$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the N-ary tree.

#### Java

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> t = new ArrayList<>();
            for (int n = q.size(); n > 0; --n) {
                root = q.poll();
                t.add(root.val);
                q.addAll(root.children);
            }
            ans.add(t);
        }
        return ans;
    }
}
```

### Solution 2: DFS

> **Thinking**
>
> Solution 1 needs a queue. Recursing with a depth $i$ and appending to $\textit{ans}[i]$ (growing the list when needed) produces the same rows.
>
> The call stack carries the layer index; children are still written left to right.

We can use the Depth-First Search method to traverse the entire tree.

We define a helper function $\textit{dfs}(\textit{root}, i)$, where $\textit{root}$ represents the current node, and $i$ represents the current level.

In the $\textit{dfs}$ function, we first check if $\textit{root}$ is null. If it is, we return directly.

Otherwise, we check if the length of $\textit{ans}$ is less than or equal to $i$. If it is, it means that the current level has not been added to $\textit{ans}$ yet, so we need to add an empty list first. Then we add the value of $\textit{root}$ to $\textit{ans}[i]$.

Next, we traverse all child nodes of $\textit{root}$. For each child node, we call $\textit{dfs}(\textit{child}, i + 1)$.

In the main function, we call $\textit{dfs}(\textit{root}, 0)$ and return $\textit{ans}$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the N-ary tree.

#### Java

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(Node root, int i) {
        if (root == null) {
            return;
        }
        if (ans.size() <= i) {
            ans.add(new ArrayList<>());
        }
        ans.get(i++).add(root.val);
        for (Node child : root.children) {
            dfs(child, i);
        }
    }
}
```
