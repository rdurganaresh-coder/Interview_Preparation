# 94. Binary Tree Inorder Traversal

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/binary-tree-inorder-traversal/

---

[中文文档](/solution/0000-0099/0094.Binary%20Tree%20Inorder%20Traversal/README.md)

## Description

<p>Given the <code>root</code> of a binary tree, return <em>the inorder traversal of its nodes&#39; values</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,3,2]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0094.Binary%20Tree%20Inorder%20Traversal/images/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;" /></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,2,6,5,7,1,3,9,8]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0094.Binary%20Tree%20Inorder%20Traversal/images/tree_2.png" style="width: 350px; height: 286px;" /></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = []</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?

## Solutions

### Solution 1: Recursive Traversal

> **Thinking**
>
> Inorder is left, root, right. A tree is already recursive, so the first idea is recursion: finish the left subtree, record the root, then walk the right. $n \le 100$, so an $O(n)$ call stack is fine. The follow-up is what asks for iteration.

We first recursively traverse the left subtree, then visit the root node, and finally recursively traverse the right subtree.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree, and the space complexity mainly depends on the stack space of the recursive call.

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
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}
```

### Solution 2: Stack Implementation for Non-recursive Traversal

> **Thinking**
>
> Solution 1 is correct; the follow-up drops the call stack. Recursion is “go left until you cannot, then pop, visit, and turn right”. An explicit stack simulates that: push while a left child exists, otherwise pop, visit, and move to the right child. Same order as inorder, still $O(n)$ space.

The non-recursive approach is as follows:

1. Define a stack `stk`.
2. Push the left nodes of the tree into the stack in sequence.
3. When the left node is null, pop and process the top element of the stack.
4. Repeat steps 2-3.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree, and the space complexity mainly depends on the stack space.

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            if (root != null) {
                stk.push(root);
                root = root.left;
            } else {
                root = stk.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}
```

### Solution 3: Morris Implementation for In-order Traversal

> **Thinking**
>
> A stack still costs $O(h)$. Morris notices that the successor of the rightmost node in the left subtree is the current root, and that right pointer is unused. Temporarily thread it to the root, walk down the left chain, then undo the link on the way back. The tree’s null pointers become the stack, inorder is preserved, and extra space is $O(1)$.

Morris traversal does not require a stack, so the space complexity is $O(1)$. The core idea is:

Traverse the binary tree nodes,

1. If the left subtree of the current node `root` is null, **add the current node value to the result list `ans`**, and update the current node to `root.right`.
2. If the left subtree of the current node `root` is not null, find the rightmost node `prev` of the left subtree (which is the predecessor node of the `root` node in in-order traversal):
    - If the right subtree of the predecessor node `prev` is null, point the right subtree of the predecessor node to the current node `root`, and update the current node to `root.left`.
    - If the right subtree of the predecessor node `prev` is not null, **add the current node value to the result list `ans`**, then point the right subtree of the predecessor node to null (i.e., disconnect `prev` and `root`), and update the current node to `root.right`.
3. Repeat the above steps until the binary tree node is null, and the traversal ends.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the number of nodes in the binary tree.

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                ans.add(root.val);
                root = root.right;
            } else {
                TreeNode prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                } else {
                    ans.add(root.val);
                    prev.right = null;
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
```
