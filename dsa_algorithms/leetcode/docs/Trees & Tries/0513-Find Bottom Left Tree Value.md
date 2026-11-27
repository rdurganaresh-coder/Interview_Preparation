# 513. Find Bottom Left Tree Value

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/find-bottom-left-tree-value/

---

[中文文档](/solution/0500-0599/0513.Find%20Bottom%20Left%20Tree%20Value/README.md)

## Description

<p>You are given the <code>root</code> of a binary tree.</p>

<p>Return the <strong>leftmost</strong> value in the <strong>last</strong> row of the tree.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0513.Find%20Bottom%20Left%20Tree%20Value/images/tree1.jpg" style="width: 302px; height: 182px;" />
<pre>
<strong>Input:</strong> root = [2,1,3]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The last row is [1,3], so the leftmost value is 1.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0513.Find%20Bottom%20Left%20Tree%20Value/images/tree2.jpg" style="width: 432px; height: 421px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,null,5,6,null,null,7]
<strong>Output:</strong> 7
<strong>Explanation:</strong> The last row contains only the node 7.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The bottom-left value is the first node of the last level in a level-order walk. In BFS the queue front is the leftmost node of the current level.
>
> Record the front at the start of each level and enqueue children. When the queue drains, the last recorded value is the answer. Level order processes the deepest level last.

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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            ans = q.peek().val;
            for (int i = q.size(); i > 0; --i) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> BFS uses an $O(w)$ queue. DFS only needs to remember the first time a greater depth appears.
>
> A left-then-right preorder meets the leftmost node of each depth first; update the answer only when the depth is strictly larger. Extra space is the recursion stack, and the result matches level order.

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
    private int ans = 0;
    private int mx = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode root, int curr) {
        if (root == null) {
            return;
        }
        dfs(root.left, curr + 1);
        dfs(root.right, curr + 1);
        if (mx < curr) {
            mx = curr;
            ans = root.val;
        }
    }
}
```
