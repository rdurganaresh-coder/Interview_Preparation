# 270. Closest Binary Search Tree Value

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/closest-binary-search-tree-value/

---

[中文文档](/solution/0200-0299/0270.Closest%20Binary%20Search%20Tree%20Value/README.md)

## Description

<p>Given the <code>root</code> of a binary search tree and a <code>target</code> value, return <em>the value in the BST that is closest to the</em> <code>target</code>. If there are multiple answers, print the smallest.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0200-0299/0270.Closest%20Binary%20Search%20Tree%20Value/images/closest1-1-tree.jpg" style="width: 292px; height: 302px;" />
<pre>
<strong>Input:</strong> root = [4,2,5,1,3], target = 3.714286
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1], target = 4.428571
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Recursion

> **Thinking**
>
> We need not walk the whole BST: after comparing with $\textit{target}$ only one child can improve. Along the path we keep the closer value, breaking ties toward the smaller key.
>
> A recursion follows left or right accordingly.

We define a recursive function `dfs(node)`, which starts from the current node `node` and finds the node closest to the target value $\textit{target}$. We can update the answer by comparing the absolute difference between the current node's value and the target value. If the target value is less than the current node's value, we recursively search the left subtree; otherwise, we recursively search the right subtree.

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
    private int ans;
    private double target;
    private double diff = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        this.target = target;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        double nxt = Math.abs(node.val - target);
        if (nxt < diff || (nxt == diff && node.val < ans)) {
            diff = nxt;
            ans = node.val;
        }
        node = target < node.val ? node.left : node.right;
        dfs(node);
    }
}
```

### Solution 2: Iteration

> **Thinking**
>
> The same walk is an iteration and needs no call stack.

We can rewrite the recursive function in an iterative form, using a loop to simulate the recursive process. We start from the root node and check whether the absolute difference between the current node's value and the target value is less than the current minimum difference. If it is, we update the answer. Then, based on the size relationship between the target value and the current node's value, we decide to move to the left subtree or the right subtree. The loop ends when we traverse to a null node.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the number of nodes in the binary search tree.

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
    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        double diff = Double.MAX_VALUE;
        while (root != null) {
            double nxt = Math.abs(root.val - target);
            if (nxt < diff || (nxt == diff && root.val < ans)) {
                diff = nxt;
                ans = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        return ans;
    }
}
```
