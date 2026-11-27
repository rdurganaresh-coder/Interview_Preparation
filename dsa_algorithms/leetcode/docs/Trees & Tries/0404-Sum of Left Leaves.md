# 404. Sum of Left Leaves

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/sum-of-left-leaves/

---

[中文文档](/solution/0400-0499/0404.Sum%20of%20Left%20Leaves/README.md)

## Description

<p>Given the <code>root</code> of a binary tree, return <em>the sum of all left leaves.</em></p>

<p>A <strong>leaf</strong> is a node with no children. A <strong>left leaf</strong> is a leaf that is the left child of another node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0400-0499/0404.Sum%20of%20Left%20Leaves/images/leftsum-tree.jpg" style="width: 277px; height: 302px;" />
<pre>
<strong>Input:</strong> root = [3,9,20,null,null,15,7]
<strong>Output:</strong> 24
<strong>Explanation:</strong> There are two left leaves in the binary tree, with values 9 and 15 respectively.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Recursion

> **Thinking**
>
> A left leaf is a left child with no children, not an arbitrary left subtree. Scanning a subtree from every node would revisit nodes.
>
> One recursion suffices: always walk the right child; if the left child is a leaf, add its value, otherwise recurse. An empty tree contributes $0$. Treating a leaf as both children being null avoids an extra walk.

First, we check if `root` is null. If it is, we return $0$.

Otherwise, we recursively call the `sumOfLeftLeaves` function to calculate the sum of all left leaves in `root`'s right subtree, and assign the result to the answer variable $\textit{ans}$. Then we check if `root`'s left child exists. If it does, we check if it is a leaf node. If it is a leaf node, we add its value to the answer variable $\textit{ans}$. Otherwise, we recursively call the `sumOfLeftLeaves` function to calculate the sum of all left leaves in `root`'s left subtree, and add the result to the answer variable $\textit{ans}$.

Finally, we return the answer.

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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = sumOfLeftLeaves(root.right);
        if (root.left != null) {
            if (root.left.left == root.left.right) {
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeaves(root.left);
            }
        }
        return ans;
    }
}
```

### Solution 2: Stack

> **Thinking**
>
> The same classification, implemented with an explicit stack: pop a node, add a left leaf or push the left child, and push a right child when it exists.
>
> Asymptotics are unchanged; the call stack is no longer implicit.

We can also convert the recursion in Solution 1 to iteration, using a stack to simulate the recursion process.

Similar to Solution 1, we first check if `root` is null. If it is, we return $0$.

Otherwise, we initialize the answer variable $\textit{ans}$ to $0$, and then initialize a stack $\textit{stk}$ and add `root` to the stack.

While the stack is not empty, we pop the top element `root` from the stack. If `root`'s left child exists, we check if it is a leaf node. If it is a leaf node, we add its value to the answer variable $\textit{ans}$. Otherwise, we add its left child to the stack. Then we check if `root`'s right child exists. If it does, we add it to the stack.

Finally, we return the answer.

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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stk = new ArrayDeque<>();
        stk.push(root);
        int ans = 0;
        while (!stk.isEmpty()) {
            root = stk.pop();
            if (root.left != null) {
                if (root.left.left == root.left.right) {
                    ans += root.left.val;
                } else {
                    stk.push(root.left);
                }
            }
            if (root.right != null) {
                stk.push(root.right);
            }
        }
        return ans;
    }
}
```
