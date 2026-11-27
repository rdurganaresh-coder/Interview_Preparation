# 1008. Construct Binary Search Tree from Preorder Traversal

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

---

[中文文档](/solution/1000-1099/1008.Construct%20Binary%20Search%20Tree%20from%20Preorder%20Traversal/README.md)

## Description

<p>Given an array of integers preorder, which represents the <strong>preorder traversal</strong> of a BST (i.e., <strong>binary search tree</strong>), construct the tree and return <em>its root</em>.</p>

<p>It is <strong>guaranteed</strong> that there is always possible to find a binary search tree with the given requirements for the given test cases.</p>

<p>A <strong>binary search tree</strong> is a binary tree where for every node, any descendant of <code>Node.left</code> has a value <strong>strictly less than</strong> <code>Node.val</code>, and any descendant of <code>Node.right</code> has a value <strong>strictly greater than</strong> <code>Node.val</code>.</p>

<p>A <strong>preorder traversal</strong> of a binary tree displays the value of the node first, then traverses <code>Node.left</code>, then traverses <code>Node.right</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1000-1099/1008.Construct%20Binary%20Search%20Tree%20from%20Preorder%20Traversal/images/1266.png" style="height: 386px; width: 590px;" />
<pre>
<strong>Input:</strong> preorder = [8,5,1,7,10,12]
<strong>Output:</strong> [8,5,10,1,7,null,12]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> preorder = [1,3]
<strong>Output:</strong> [1,null,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= preorder.length &lt;= 100</code></li>
	<li><code>1 &lt;= preorder[i] &lt;= 1000</code></li>
	<li>All the values of <code>preorder</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1: DFS + Binary Search

> **Thinking**
>
> The first preorder value is the root; a linear scan finds the first larger key and splits the left and right subtrees. $n\le 100$ makes $O(n^2)$ acceptable, yet each split walks the same ranges again.
>
> A BST preorder segment still has every left-subtree key below the root and every right-subtree key above it, so the first index greater than the root can be found by binary search.
>
> $\textit{dfs}(i,j)$ builds a node from $\textit{preorder}[i]$, bisects to the right-subtree start, and recurses on both sides in $O(n \log n)$.

We design a function $\textit{dfs}(i, j)$ to construct a binary search tree from the nodes $\textit{preorder}[i]$ to $\textit{preorder}[j]$. The answer is $\textit{dfs}(0, n - 1)$.

In $\textit{dfs}(i, j)$, we first construct the root node, which is $\textit{preorder}[i]$. Then, we use binary search to find the first node greater than $\textit{preorder}[i]$ and get its index $\textit{mid}$. We set $\textit{dfs}(i + 1, \textit{mid} - 1)$ as the left subtree of the root node and $\textit{dfs}(\textit{mid}, j)$ as the right subtree of the root node.

Finally, we return the root node.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{preorder}$.

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
    private int[] preorder;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        return dfs(0, preorder.length - 1);
    }

    private TreeNode dfs(int i, int j) {
        if (i > j) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        int l = i + 1, r = j + 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (preorder[mid] > preorder[i]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        root.left = dfs(i + 1, l - 1);
        root.right = dfs(l, j);
        return root;
    }
}
```
