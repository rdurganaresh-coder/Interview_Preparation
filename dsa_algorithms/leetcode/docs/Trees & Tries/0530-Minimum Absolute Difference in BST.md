# 530. Minimum Absolute Difference in BST

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/minimum-absolute-difference-in-bst/

---

[中文文档](/solution/0500-0599/0530.Minimum%20Absolute%20Difference%20in%20BST/README.md)

## Description

<p>Given the <code>root</code> of a Binary Search Tree (BST), return <em>the minimum absolute difference between the values of any two different nodes in the tree</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0530.Minimum%20Absolute%20Difference%20in%20BST/images/bst1.jpg" style="width: 292px; height: 301px;" />
<pre>
<strong>Input:</strong> root = [4,2,6,1,3]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0530.Minimum%20Absolute%20Difference%20in%20BST/images/bst2.jpg" style="width: 282px; height: 301px;" />
<pre>
<strong>Input:</strong> root = [1,0,48,null,null,12,49]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[2, 10<sup>4</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as 783: <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/" target="_blank">https://leetcode.com/problems/minimum-distance-between-bst-nodes/</a></p>

## Solutions

### Solution 1: Inorder Traversal

> **Thinking**
>
> The minimum pairwise difference on a general tree needs all pairs. In a BST, inorder is sorted, so the minimum lies between adjacent values.
>
> Walk inorder, keep the predecessor, and update with `val - pre`. Seed $\textit{pre}$ at $-\infty$ so the first node is skipped. One inorder pass suffices.

The problem requires us to find the minimum difference between the values of any two nodes. Since the inorder traversal of a binary search tree is an increasing sequence, we only need to find the minimum difference between the values of two adjacent nodes in the inorder traversal.

We can use a recursive method to implement the inorder traversal. During the process, we use a variable $\textit{pre}$ to save the value of the previous node. This way, we can calculate the minimum difference between the values of two adjacent nodes during the traversal.

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
    private final int inf = 1 << 30;
    private int ans = inf;
    private int pre = -inf;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        ans = Math.min(ans, root.val - pre);
        pre = root.val;
        dfs(root.right);
    }
}
```

### Solution 2: Explicit-Stack Inorder

> **Thinking**
>
> The minimum pairwise difference on a general tree needs all pairs. In a BST, inorder is sorted, so the minimum lies between adjacent values. Recursing inorder and subtracting the predecessor is correct on a short tree.
>
> The tree can contain $10^4$ nodes. A left chain makes this walk recurse once per node and overflow the call stack.
>
> Each node only needs the previous value. The walk does not need a return value, as long as the left subtree is finished before the node and the right subtree comes after.
>
> An explicit stack performs that inorder walk. On entry it pushes an exit marker and the left child; on exit it updates the answer with the current value minus the predecessor and pushes the right child. The predecessor starts at $-\infty$, so the first node does not become the answer.

The minimum difference between any two node values of a binary search tree is the minimum gap between adjacent values in its increasing inorder sequence.

An explicit stack walks the tree in that order, and $\textit{pre}$ stores the previous value, initially $-\infty$. On entry we push an exit marker and the left child. On exit we update the answer with the current value minus $\textit{pre}$, store the current value in $\textit{pre}$, and push the right child.

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

    public int getMinimumDifference(TreeNode root) {
        final int inf = 1 << 30;
        int ans = inf;
        int pre = -inf;
        if (root == null) {
            return ans;
        }
        Deque<Frame> stk = new ArrayDeque<>();
        stk.push(new Frame(root, 0));
        while (!stk.isEmpty()) {
            Frame cur = stk.pop();
            TreeNode node = cur.node;
            if (cur.state == 0) {
                stk.push(new Frame(node, 1));
                if (node.left != null) {
                    stk.push(new Frame(node.left, 0));
                }
                continue;
            }
            ans = Math.min(ans, node.val - pre);
            pre = node.val;
            if (node.right != null) {
                stk.push(new Frame(node.right, 0));
            }
        }
        return ans;
    }
}
```
