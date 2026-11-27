# 110. Balanced Binary Tree

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/balanced-binary-tree/

---

[中文文档](/solution/0100-0199/0110.Balanced%20Binary%20Tree/README.md)

## Description

<p>Given a binary tree, determine if it is <span data-keyword="height-balanced"><strong>height-balanced</strong></span>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0110.Balanced%20Binary%20Tree/images/balance_1.jpg" style="width: 342px; height: 221px;" />
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0110.Balanced%20Binary%20Tree/images/balance_2.jpg" style="width: 452px; height: 301px;" />
<pre>
<strong>Input:</strong> root = [1,2,2,3,3,null,null,4,4]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 5000]</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Bottom-Up Recursion

> **Thinking**
>
> Computing left and right heights from scratch at every node revisits the same subtrees and can hit $O(n^2)$; $n \le 5000$ is tight.
>
> Balance can be decided while computing height. A bottom-up pass returns the height, or a failure sentinel if a subtree is already unbalanced. One postorder walk answers both questions.

We define a function $\textit{height}(\textit{root})$ to calculate the height of a binary tree, with the following logic:

- If the binary tree $\textit{root}$ is null, return $0$.
- Otherwise, recursively calculate the heights of the left and right subtrees, denoted as $l$ and $r$ respectively. If either $l$ or $r$ is $-1$, or the absolute difference between $l$ and $r$ is greater than $1$, then return $-1$. Otherwise, return $\max(l, r) + 1$.

Therefore, if the function $\textit{height}(\textit{root})$ returns $-1$, it means the binary tree $\textit{root}$ is not balanced. Otherwise, it is balanced.

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
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return 1 + Math.max(l, r);
    }
}
```
