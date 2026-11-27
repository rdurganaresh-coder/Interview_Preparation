# 222. Count Complete Tree Nodes

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/count-complete-tree-nodes/

---

[中文文档](/solution/0200-0299/0222.Count%20Complete%20Tree%20Nodes/README.md)

## Description

<p>Given the <code>root</code> of a <strong>complete</strong> binary tree, return the number of the nodes in the tree.</p>

<p>According to <strong><a href="http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees" target="_blank">Wikipedia</a></strong>, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between <code>1</code> and <code>2<sup>h</sup></code> nodes inclusive at the last level <code>h</code>.</p>

<p>Design an algorithm that runs in less than&nbsp;<code data-stringify-type="code">O(n)</code>&nbsp;time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0200-0299/0222.Count%20Complete%20Tree%20Nodes/images/complete.jpg" style="width: 372px; height: 302px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6]
<strong>Output:</strong> 6
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 5 * 10<sup>4</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 5 * 10<sup>4</sup></code></li>
	<li>The tree is guaranteed to be <strong>complete</strong>.</li>
</ul>

## Solutions

### Solution 1: Recursion

> **Thinking**
>
> A complete tree can still be counted by ordinary recursion: the size is $1$ plus the sizes of the two subtrees, visiting every node once.

We recursively traverse the entire tree and count the number of nodes.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the tree.

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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```

### Solution 2: Binary Search

> **Thinking**
>
> The linear walk ignores that the last level is packed left. If the left and right heights match, the left subtree is perfect and contributes $2^{\textit{left}}$ nodes (including the root), so we recurse only on the right; otherwise the right subtree is perfect and we recurse on the left.
>
> Each height walk is $O(\log n)$ and the recursion depth is $O(\log n)$, for $O(\log^2 n)$ time.

For this problem, we can also take advantage of the characteristics of a complete binary tree to design a faster algorithm.

Characteristics of a complete binary tree: leaf nodes can only appear on the bottom and second-to-bottom layers, and the leaf nodes on the bottom layer are concentrated on the left side of the tree. It should be noted that a full binary tree is definitely a complete binary tree, but a complete binary tree is not necessarily a full binary tree.

If the number of layers in a full binary tree is $h$, then the total number of nodes is $2^h - 1$.

We first count the heights of the left and right subtrees of $\textit{root}$, denoted as $\textit{left}$ and $\textit{right}$.

1. If $\textit{left} = \textit{right}$, it means that the left subtree is a full binary tree, so the total number of nodes in the left subtree is $2^{\textit{left}} - 1$. Plus the $\textit{root}$ node, it is $2^{\textit{left}}$. Then we recursively count the right subtree.
1. If $\textit{left} > \textit{right}$, it means that the right subtree is a full binary tree, so the total number of nodes in the right subtree is $2^{\textit{right}} - 1$. Plus the $\textit{root}$ node, it is $2^{\textit{right}}$. Then we recursively count the left subtree.

The time complexity is $O(\log^2 n)$.

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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) {
            return (1 << left) + countNodes(root.right);
        }
        return (1 << right) + countNodes(root.left);
    }

    private int depth(TreeNode root) {
        int d = 0;
        for (; root != null; root = root.left) {
            ++d;
        }
        return d;
    }
}
```
