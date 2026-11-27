# 104. Maximum Depth of Binary Tree

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/maximum-depth-of-binary-tree/

---

[中文文档](/solution/0100-0199/0104.Maximum%20Depth%20of%20Binary%20Tree/README.md)

## Description

<p>Given the <code>root</code> of a binary tree, return <em>its maximum depth</em>.</p>

<p>A binary tree&#39;s <strong>maximum depth</strong>&nbsp;is the number of nodes along the longest path from the root node down to the farthest leaf node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0104.Maximum%20Depth%20of%20Binary%20Tree/images/tmp-tree.jpg" style="width: 400px; height: 277px;" />
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,null,2]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1: Recursion

> **Thinking**
>
> Depth is the number of nodes on the longest root-to-leaf path. Level-order counting of layers works, and $n \le 10^4$ is fine. A tree is recursive: the depth is one plus the larger of the two subtree depths, and the empty tree has depth $0$. Recurse on both children and take the max.

Recursively traverse the left and right subtrees, calculate the maximum depth of the left and right subtrees, and then take the maximum value plus $1$.

The time complexity is $O(n)$, where $n$ is the number of nodes in the binary tree. Each node is traversed only once in the recursion.

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l, r);
    }
}
```
