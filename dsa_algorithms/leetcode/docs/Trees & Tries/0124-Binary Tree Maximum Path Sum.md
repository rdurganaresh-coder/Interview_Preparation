# 124. Binary Tree Maximum Path Sum

**Difficulty:** Hard  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/binary-tree-maximum-path-sum/

---

[中文文档](/solution/0100-0199/0124.Binary%20Tree%20Maximum%20Path%20Sum/README.md)

## Description

<p>A <strong>path</strong> in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence <strong>at most once</strong>. Note that the path does not need to pass through the root.</p>

<p>The <strong>path sum</strong> of a path is the sum of the node&#39;s values in the path.</p>

<p>Given the <code>root</code> of a binary tree, return <em>the maximum <strong>path sum</strong> of any <strong>non-empty</strong> path</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0124.Binary%20Tree%20Maximum%20Path%20Sum/images/exx1.jpg" style="width: 322px; height: 182px;" />
<pre>
<strong>Input:</strong> root = [1,2,3]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The optimal path is 2 -&gt; 1 -&gt; 3 with a path sum of 2 + 1 + 3 = 6.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0124.Binary%20Tree%20Maximum%20Path%20Sum/images/exx2.jpg" />
<pre>
<strong>Input:</strong> root = [-10,9,20,null,null,15,7]
<strong>Output:</strong> 42
<strong>Explanation:</strong> The optimal path is 15 -&gt; 20 -&gt; 7 with a path sum of 15 + 20 + 7 = 42.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 3 * 10<sup>4</sup>]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Recursion

> **Thinking**
>
> A path may start anywhere, need not pass the root, and may bend at a node to take both children. Enumerating paths is impossible at $n \le 3\times 10^4$.
>
> The value a node can pass upward is its value plus the better non-negative child chain. The sum that uses both children only updates the global answer and cannot propagate. Negative contributions are dropped by taking $\max(0,\cdot)$ before returning.

When thinking about the classic routine of recursion problems in binary trees, we consider:

1. Termination condition (when to terminate recursion)
2. Recursively process the left and right subtrees
3. Merge the calculation results of the left and right subtrees

For this problem, we design a function $\textit{dfs}(\textit{root})$, which returns the maximum path sum of the binary tree with $\textit{root}$ as the root node.

The execution logic of the function $\textit{dfs}(\textit{root})$ is as follows:

If $\textit{root}$ does not exist, then $\textit{dfs}(\textit{root})$ returns $0$;

Otherwise, we recursively calculate the maximum path sum of the left and right subtrees of $\textit{root}$, denoted as $\textit{left}$ and $\textit{right}$. If $\textit{left}$ is less than $0$, then we set it to $0$, similarly, if $\textit{right}$ is less than $0$, then we set it to $0$.

Then, we update the answer with $\textit{root}.\textit{val} + \textit{left} + \textit{right}$. Finally, the function returns $\textit{root}.\textit{val} + \max(\textit{left}, \textit{right})$.

In the main function, we call $\textit{dfs}(\textit{root})$ to get the maximum path sum of each node, and the maximum value among them is the answer.

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
    private int ans = -1001;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        ans = Math.max(ans, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
```
