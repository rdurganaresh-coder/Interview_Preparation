# 250. Count Univalue Subtrees

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-univalue-subtrees/

---

[中文文档](/solution/0200-0299/0250.Count%20Univalue%20Subtrees/README.md)

## Description

<p>Given the <code>root</code> of a binary tree, return <em>the number of <strong>uni-value</strong> </em><span data-keyword="subtree"><em>subtrees</em></span>.</p>

<p>A <strong>uni-value subtree</strong> means all nodes of the subtree have the same value.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0200-0299/0250.Count%20Univalue%20Subtrees/images/unival_e1.jpg" style="width: 450px; height: 258px;" />
<pre>
<strong>Input:</strong> root = [5,1,5,5,5,null,5]
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [5,5,5,5,5,null,5]
<strong>Output:</strong> 6
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of the node in the tree will be in the range <code>[0, 1000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A subtree is univalue iff both children are univalue and the root equals those children. One bottom-up walk can count them.
>
> $\textit{dfs}$ reports whether the subtree is univalue: if both sides succeed and the (possibly missing) child values equal the root, increment and return true.

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
    private int ans;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if (!l || !r) {
            return false;
        }
        int a = root.left == null ? root.val : root.left.val;
        int b = root.right == null ? root.val : root.right.val;
        if (a == b && b == root.val) {
            ++ans;
            return true;
        }
        return false;
    }
}
```
