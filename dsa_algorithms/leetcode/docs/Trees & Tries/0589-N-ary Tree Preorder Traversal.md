# 589. N-ary Tree Preorder Traversal

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/n-ary-tree-preorder-traversal/

---

[中文文档](/solution/0500-0599/0589.N-ary%20Tree%20Preorder%20Traversal/README.md)

## Description

<p>Given the <code>root</code> of an n-ary tree, return <em>the preorder traversal of its nodes&#39; values</em>.</p>

<p>Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0589.N-ary%20Tree%20Preorder%20Traversal/images/narytreeexample.png" style="width: 100%; max-width: 300px;" /></p>

<pre>
<strong>Input:</strong> root = [1,null,3,2,4,null,5,6]
<strong>Output:</strong> [1,3,5,6,2,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0589.N-ary%20Tree%20Preorder%20Traversal/images/sample_4_964.png" style="width: 296px; height: 241px;" /></p>

<pre>
<strong>Input:</strong> root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
<strong>Output:</strong> [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
	<li>The height of the n-ary tree is less than or equal to <code>1000</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?</p>

## Solutions

### Solution 1: Recursion

> **Thinking**
>
> N-ary preorder is the root, then children from left to right. Recursion matches the definition.
>
> Append the root, then recurse on each child. An empty tree yields an empty list. Each node is visited once.

We can recursively traverse the entire tree. For each node, we first add the node's value to the answer, then recursively call the function for each of the node's children.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

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
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return ans;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        for (Node child : root.children) {
            dfs(child);
        }
    }
}
```

### Solution 2: Iteration (Stack Implementation)

> **Thinking**
>
> Solution 1 walks preorder by recursion, so a right spine uses a call depth equal to the node count. An explicit stack holds the nodes still to visit: push the right child before the left, and the pop order stays root, left, right.

This section uses an explicit stack.

We use a stack to help us get the pre-order traversal. We first push the root node into the stack. Since the pre-order traversal is root, left subtree, right subtree, and the characteristic of the stack is first in last out, we first add the node's value to the answer, then push each of the node's children into the stack in the order from right to left. We continue this process until the stack is empty.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

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
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        Deque<Node> stk = new ArrayDeque<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            Node node = stk.pop();
            ans.add(node.val);
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; --i) {
                stk.push(children.get(i));
            }
        }
        return ans;
    }
}
```

### Solution 3: Explicit Stack

> **Thinking**
>
> N-ary preorder records the root, then the children from left to right. Recursion on a chain of height $1000$ exhausts the call stack, and $1000$ is the height limit.
>
> The bottleneck is that chain: each call steps into the single next child, so the depth tracks the height.
>
> Preorder records the current node before visiting children, so the walk does not wait for a child to return.
>
> An explicit stack holds the nodes still to visit. Pop a node, append its value, then push its children from right to left so the leftmost child pops first. An empty tree returns an empty list.

Simulate preorder with a stack. Push the root, and after popping a node append its value, then push its children from right to left until the stack is empty.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

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
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        Deque<Node> stk = new ArrayDeque<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            Node node = stk.pop();
            ans.add(node.val);
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; --i) {
                stk.push(children.get(i));
            }
        }
        return ans;
    }
}
```
