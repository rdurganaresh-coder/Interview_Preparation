# 1973. Count Nodes Equal to Sum of Descendants

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants/

---

[中文文档](/solution/1900-1999/1973.Count%20Nodes%20Equal%20to%20Sum%20of%20Descendants/README.md)

## Description

<p>Given the <code>root</code> of a binary tree, return <em>the number of nodes where the value of the node is equal to the <strong>sum</strong> of the values of its descendants</em>.</p>

<p>A <strong>descendant</strong> of a node <code>x</code> is any node that is on the path from node <code>x</code> to some leaf node. The sum is considered to be <code>0</code> if the node has no descendants.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1900-1999/1973.Count%20Nodes%20Equal%20to%20Sum%20of%20Descendants/images/screenshot-2021-08-17-at-17-16-50-diagram-drawio-diagrams-net.png" style="width: 250px; height: 207px;" />
<pre>
<strong>Input:</strong> root = [10,3,4,2,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong>
For the node with value 10: The sum of its descendants is 3+4+2+1 = 10.
For the node with value 3: The sum of its descendants is 2+1 = 3.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1900-1999/1973.Count%20Nodes%20Equal%20to%20Sum%20of%20Descendants/images/screenshot-2021-08-17-at-17-25-21-diagram-drawio-diagrams-net.png" style="height: 196px; width: 200px;" />
<pre>
<strong>Input:</strong> root = [2,3,null,2,null]
<strong>Output:</strong> 0
<strong>Explanation:</strong>
No node has a value that is equal to the sum of its descendants.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1900-1999/1973.Count%20Nodes%20Equal%20to%20Sum%20of%20Descendants/images/screenshot-2021-08-17-at-17-23-53-diagram-drawio-diagrams-net.png" style="width: 50px; height: 50px;" />
<pre>
<strong>Input:</strong> root = [0]
<strong>Output:</strong> 1
For the node with value 0: The sum of its descendants is 0 since it has no descendants.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Each node is compared with the sum of its descendants. A fresh walk per node is quadratic.
>
> A post-order DFS returns the subtree sum: if left plus right equals the node, increment the answer, then return the node plus both children. One traversal suffices.

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

    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (l + r == root.val) {
            ++ans;
        }
        return root.val + l + r;
    }
}
```

### Solution 2: Explicit Stack

> **Thinking**
>
> Each node is compared with the sum of every descendant. A fresh walk per node is quadratic. Post-order already has both subtree sums when a node is finished, so one traversal can test the node and pass the total upward.
>
> $n$ reaches $10^5$. Post-order enters the left child first, so a left chain overflows the call stack before the sums are done. Values reach $10^5$, and a subtree sum can reach $10^{10}$, which does not fit in a 32-bit integer.
>
> The descendant sum is known only after both children return. An explicit stack separates “expand the children” from “both children have returned,” and the completion step reads the two subtree sums. Those sums are 64-bit integers. When their total equals the node, the answer increases, and the node’s own value is added for its parent.
>
> Each node is pushed once. A missing child contributes $0$.

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
    private static class Frame {
        TreeNode node;
        int state;

        Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public int equalToDescendants(TreeNode root) {
        int ans = 0;
        Map<TreeNode, Long> sub = new IdentityHashMap<>();
        Deque<Frame> stk = new ArrayDeque<>();
        if (root != null) {
            stk.push(new Frame(root, 0));
        }
        while (!stk.isEmpty()) {
            Frame cur = stk.pop();
            TreeNode node = cur.node;
            if (cur.state == 0) {
                stk.push(new Frame(node, 1));
                if (node.right != null) {
                    stk.push(new Frame(node.right, 0));
                }
                if (node.left != null) {
                    stk.push(new Frame(node.left, 0));
                }
                continue;
            }
            long l = node.left == null ? 0 : sub.get(node.left);
            long r = node.right == null ? 0 : sub.get(node.right);
            if (l + r == node.val) {
                ++ans;
            }
            sub.put(node, node.val + l + r);
        }
        return ans;
    }
}
```
