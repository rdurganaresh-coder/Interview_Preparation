# 145. Binary Tree Postorder Traversal

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/binary-tree-postorder-traversal/

---

[中文文档](/solution/0100-0199/0145.Binary%20Tree%20Postorder%20Traversal/README.md)

## Description

<p>Given the <code>root</code> of a&nbsp;binary tree, return <em>the postorder traversal of its nodes&#39; values</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,null,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">[3,2,1]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0145.Binary%20Tree%20Postorder%20Traversal/images/screenshot-2024-08-29-202743.png" style="width: 200px; height: 264px;" /></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,5,null,8,null,null,6,7,9]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,6,7,5,2,9,8,3,1]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0145.Binary%20Tree%20Postorder%20Traversal/images/tree_2.png" style="width: 350px; height: 286px;" /></p>
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
	<li>The number of the nodes in the tree is in the range <code>[0, 100]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?

## Solutions

### Solution 1: Recursion

> **Thinking**
>
> Postorder is left, right, root. Recurse on both children, then record the root. $n\le 100$, so recursion is fine. The follow-up asks for iteration.

We first recursively traverse the left and right subtrees, then visit the root node.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree. The space complexity mainly depends on the stack space used for recursive calls.

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

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        ans.add(root.val);
    }
}
```

### Solution 2: Stack Implementation for Postorder Traversal

> **Thinking**
>
> Solution 1 uses the call stack. Root-right-left is preorder with children swapped; reversing it yields left-right-root. Traverse in that order with a stack and reverse the result, with no “second visit” flag.

The order of preorder traversal is: root, left, right. If we change the order of the left and right children, the order becomes: root, right, left. Finally, reversing the result gives us the postorder traversal result.

Therefore, the idea of using a stack to implement non-recursive traversal is as follows:

1. Define a stack $\textit{stk}$, and first push the root node into the stack.
2. If the stack is not empty, pop a node from the stack each time.
3. Process the node.
4. First push the left child of the node into the stack, then push the right child of the node into the stack (if there are child nodes).
5. Repeat steps 2-4.
6. Reverse the result to get the postorder traversal result.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree. The space complexity mainly depends on the stack space.

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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stk = new ArrayDeque<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            ans.addFirst(node.val);
            if (node.left != null) {
                stk.push(node.left);
            }
            if (node.right != null) {
                stk.push(node.right);
            }
        }
        return ans;
    }
}
```

### Solution 3: Morris Implementation for Postorder Traversal

> **Thinking**
>
> Solution 2 still needs an $O(n)$ stack and a reverse. Morris threads the tree in root-right-left order and reverses the output, so extra space becomes $O(1)$.

Morris traversal does not require a stack, and its space complexity is $O(1)$. The core idea is:

Traverse the binary tree nodes,

1. If the right subtree of the current node `root` is empty, add the current node value to the result list $\textit{ans}$, and update the current node to `root.left`.
1. If the right subtree of the current node `root` is not empty, find the leftmost node `next` of the right subtree (which is the successor of the `root` node in inorder traversal):
    - If the left subtree of the successor node `next` is empty, add the current node value to the result list $\textit{ans}$, then point the left subtree of the successor node to the current node `root`, and update the current node to `root.right`.
    - If the left subtree of the successor node `next` is not empty, point the left subtree of the successor node to null (i.e., disconnect `next` and `root`), and update the current node to `root.left`.
1. Repeat the above steps until the binary tree node is null, and the traversal ends.
1. Finally, return the reverse of the result list.

> The idea of Morris postorder traversal is consistent with Morris preorder traversal, just change the "root-left-right" of preorder to "root-right-left", and finally reverse the result to become "left-right-root".

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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        while (root != null) {
            if (root.right == null) {
                ans.addFirst(root.val);
                root = root.left;
            } else {
                TreeNode next = root.right;
                while (next.left != null && next.left != root) {
                    next = next.left;
                }
                if (next.left == null) {
                    ans.addFirst(root.val);
                    next.left = root;
                    root = root.right;
                } else {
                    next.left = null;
                    root = root.left;
                }
            }
        }
        return ans;
    }
}
```
