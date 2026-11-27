# 538. Convert BST to Greater Tree

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/convert-bst-to-greater-tree/

---

[中文文档](/solution/0500-0599/0538.Convert%20BST%20to%20Greater%20Tree/README.md)

## Description

<p>Given the <code>root</code> of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.</p>

<p>As a reminder, a <em>binary search tree</em> is a tree that satisfies these constraints:</p>

<ul>
	<li>The left subtree of a node contains only nodes with keys <strong>less than</strong> the node&#39;s key.</li>
	<li>The right subtree of a node contains only nodes with keys <strong>greater than</strong> the node&#39;s key.</li>
	<li>Both the left and right subtrees must also be binary search trees.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0538.Convert%20BST%20to%20Greater%20Tree/images/tree.png" style="width: 500px; height: 341px;" />
<pre>
<strong>Input:</strong> root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
<strong>Output:</strong> [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [0,null,1]
<strong>Output:</strong> [1,null,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
	<li>All the values in the tree are <strong>unique</strong>.</li>
	<li><code>root</code> is guaranteed to be a valid binary search tree.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as 1038: <a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/" target="_blank">https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/</a></p>

## Solutions

### Solution 1

> **Thinking**
>
> Each node should become the sum of all keys not smaller than itself. In a BST those keys are exactly the nodes already seen in reverse inorder.
>
> Walk right-root-left, accumulate into $s$, and write $s$ back. The right subtree is processed first, so larger keys are already included. One traversal.

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
    private int s;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        s += root.val;
        root.val = s;
        dfs(root.left);
    }
}
```

### Solution 2

> **Thinking**
>
> Recursive reverse inorder uses an $O(h)$ stack. Morris temporarily links a node's inorder predecessor (leftmost of the right subtree) to recover the parent without a stack.
>
> Thread when going right, accumulate and write on the return visit, then unthread and go left. The order is still right-root-left, with constant extra space.

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
    public TreeNode convertBST(TreeNode root) {
        int s = 0;
        TreeNode node = root;
        while (root != null) {
            if (root.right == null) {
                s += root.val;
                root.val = s;
                root = root.left;
            } else {
                TreeNode next = root.right;
                while (next.left != null && next.left != root) {
                    next = next.left;
                }
                if (next.left == null) {
                    next.left = root;
                    root = root.right;
                } else {
                    s += root.val;
                    root.val = s;
                    next.left = null;
                    root = root.left;
                }
            }
        }
        return node;
    }
}
```

### Solution 3: Explicit Stack

> **Thinking**
>
> Each node should become the sum of every key not smaller than itself. In a BST those keys are exactly the nodes already seen in reverse inorder. Recursing down the right child and writing the sum back is correct on a short tree.
>
> The tree can contain $10^4$ nodes. A right chain makes this walk recurse once per node and overflow the call stack.
>
> The running sum depends only on the greater keys already visited. A node does not need a value returned from its children, as long as the right child is finished before the node and the left child comes after.
>
> An explicit stack performs that reverse inorder. On entry it pushes an exit marker and the right child; on exit it adds the node value into $s$, writes $s$ back, and pushes the left child.

An explicit stack walks the binary search tree in the order right, root, left. On entry we push an exit marker and the right child. On exit we add the node value into $s$, write $s$ back to the node, and push the left child.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary search tree.

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
        int state;

        Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        int s = 0;
        if (root == null) {
            return null;
        }
        Deque<Frame> stk = new ArrayDeque<>();
        stk.push(new Frame(root, 0));
        while (!stk.isEmpty()) {
            Frame cur = stk.pop();
            TreeNode node = cur.node;
            if (cur.state == 0) {
                stk.push(new Frame(node, 1));
                if (node.right != null) {
                    stk.push(new Frame(node.right, 0));
                }
                continue;
            }
            s += node.val;
            node.val = s;
            if (node.left != null) {
                stk.push(new Frame(node.left, 0));
            }
        }
        return root;
    }
}
```
