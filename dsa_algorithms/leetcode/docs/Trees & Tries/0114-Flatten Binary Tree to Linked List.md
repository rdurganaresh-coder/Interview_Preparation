# 114. Flatten Binary Tree to Linked List

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

---

[中文文档](/solution/0100-0199/0114.Flatten%20Binary%20Tree%20to%20Linked%20List/README.md)

## Description

<p>Given the <code>root</code> of a binary tree, flatten the tree into a &quot;linked list&quot;:</p>

<ul>
	<li>The &quot;linked list&quot; should use the same <code>TreeNode</code> class where the <code>right</code> child pointer points to the next node in the list and the <code>left</code> child pointer is always <code>null</code>.</li>
	<li>The &quot;linked list&quot; should be in the same order as a <a href="https://en.wikipedia.org/wiki/Tree_traversal#Pre-order,_NLR" target="_blank"><strong>pre-order</strong><strong> traversal</strong></a> of the binary tree.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0114.Flatten%20Binary%20Tree%20to%20Linked%20List/images/flaten.jpg" style="width: 500px; height: 226px;" />
<pre>
<strong>Input:</strong> root = [1,2,5,3,4,null,6]
<strong>Output:</strong> [1,null,2,null,3,null,4,null,5,null,6]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 2000]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Can you flatten the tree in-place (with <code>O(1)</code> extra space)?

## Solutions

### Solution 1: Find Predecessor Node

> **Thinking**
>
> A preorder flatten can build a new list with recursion or a stack, but the follow-up asks for $O(1)$ extra space in place. $n \le 2000$.
>
> After the left subtree in preorder comes the original right subtree. The rightmost node of the left subtree is that predecessor: splice the old right onto it, move the left subtree to `right`, and clear `left`. Walk the right spine; no recursion stack is needed.

The visit order of preorder traversal is "root, left subtree, right subtree". After the last node of the left subtree is visited, the right subtree node of the root node will be visited next.

Therefore, for the current node, if its left child node is not null, we find the rightmost node of the left subtree as the predecessor node, and then assign the right child node of the current node to the right child node of the predecessor node. Then assign the left child node of the current node to the right child node of the current node, and set the left child node of the current node to null. Then take the right child node of the current node as the next node and continue processing until all nodes are processed.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the number of nodes in the tree.

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
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = root.right;

                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 already splices predecessors in $O(1)$ space. This is the same idea with a different write-up: save both children, hang the left subtree on the right, attach the old right to its rightmost node, and step along `right`.
