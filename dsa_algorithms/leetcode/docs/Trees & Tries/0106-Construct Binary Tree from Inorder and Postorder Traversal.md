# 106. Construct Binary Tree from Inorder and Postorder Traversal

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

---

[中文文档](/solution/0100-0199/0106.Construct%20Binary%20Tree%20from%20Inorder%20and%20Postorder%20Traversal/README.md)

## Description

<p>Given two integer arrays <code>inorder</code> and <code>postorder</code> where <code>inorder</code> is the inorder traversal of a binary tree and <code>postorder</code> is the postorder traversal of the same tree, construct and return <em>the binary tree</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0106.Construct%20Binary%20Tree%20from%20Inorder%20and%20Postorder%20Traversal/images/tree.jpg" style="width: 277px; height: 302px;" />
<pre>
<strong>Input:</strong> inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
<strong>Output:</strong> [3,9,20,null,null,15,7]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> inorder = [-1], postorder = [-1]
<strong>Output:</strong> [-1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= inorder.length &lt;= 3000</code></li>
	<li><code>postorder.length == inorder.length</code></li>
	<li><code>-3000 &lt;= inorder[i], postorder[i] &lt;= 3000</code></li>
	<li><code>inorder</code> and <code>postorder</code> consist of <strong>unique</strong> values.</li>
	<li>Each value of <code>postorder</code> also appears in <code>inorder</code>.</li>
	<li><code>inorder</code> is <strong>guaranteed</strong> to be the inorder traversal of the tree.</li>
	<li><code>postorder</code> is <strong>guaranteed</strong> to be the postorder traversal of the tree.</li>
</ul>

## Solutions

### Solution 1: Hash Table + Recursion

> **Thinking**
>
> The last postorder value is the root; inorder again splits left and right. Linear search for the root each time can be $O(n^2)$. Values are unique, so we index inorder first. The last value of the current postorder slice is the root; the count of inorder values to its left is the left-subtree size, which splits the remaining postorder into two recursive ranges.

The last node in the post-order traversal is the root node. We can find the position of the root node in the in-order traversal, and then recursively construct the left and right subtrees.

Specifically, we first use a hash table $d$ to store the position of each node in the in-order traversal. Then we design a recursive function $\textit{dfs}(i, j, n)$, where $i$ and $j$ represent the starting positions of the in-order and post-order traversals, respectively, and $n$ represents the number of nodes in the subtree. The function logic is as follows:

- If $n \leq 0$, it means the subtree is empty, return a null node.
- Otherwise, take out the last node $v$ of the post-order traversal, and then find the position $k$ of $v$ in the in-order traversal using the hash table $d$. Then the number of nodes in the left subtree is $k - i$, and the number of nodes in the right subtree is $n - k + i - 1$.
- Recursively construct the left subtree $\textit{dfs}(i, j, k - i)$ and the right subtree $\textit{dfs}(k + 1, j + k - i, n - k + i - 1)$, connect them to the root node, and finally return the root node.

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
    private Map<Integer, Integer> d = new HashMap<>();
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        int n = inorder.length;
        for (int i = 0; i < n; ++i) {
            d.put(inorder[i], i);
        }
        return dfs(0, 0, n);
    }

    private TreeNode dfs(int i, int j, int n) {
        if (n <= 0) {
            return null;
        }
        int v = postorder[j + n - 1];
        int k = d.get(v);
        TreeNode l = dfs(i, j, k - i);
        TreeNode r = dfs(k + 1, j + k - i, n - k + i - 1);
        return new TreeNode(v, l, r);
    }
}
```
