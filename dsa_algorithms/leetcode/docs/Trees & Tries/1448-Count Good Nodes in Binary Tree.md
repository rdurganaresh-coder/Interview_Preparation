# 1448. Count Good Nodes in Binary Tree

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/count-good-nodes-in-binary-tree/

---

[中文文档](/solution/1400-1499/1448.Count%20Good%20Nodes%20in%20Binary%20Tree/README.md)

## Description

<p>Given a binary tree <code>root</code>, a node <em>X</em> in the tree is named&nbsp;<strong>good</strong> if in the path from root to <em>X</em> there are no nodes with a value <em>greater than</em> X.</p>

<p>Return the number of <strong>good</strong> nodes in the binary tree.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><strong><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1400-1499/1448.Count%20Good%20Nodes%20in%20Binary%20Tree/images/test_sample_1.png" style="width: 263px; height: 156px;" /></strong></p>

<pre>
<strong>Input:</strong> root = [3,1,4,3,null,1,5]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Nodes in blue are <strong>good</strong>.
Root Node (3) is always a good node.
Node 4 -&gt; (3,4) is the maximum value in the path starting from the root.
Node 5 -&gt; (3,4,5) is the maximum value in the path
Node 3 -&gt; (3,1,3) is the maximum value in the path.</pre>

<p><strong class="example">Example 2:</strong></p>

<p><strong><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1400-1499/1448.Count%20Good%20Nodes%20in%20Binary%20Tree/images/test_sample_2.png" style="width: 157px; height: 161px;" /></strong></p>

<pre>
<strong>Input:</strong> root = [3,3,null,4,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong> Node 2 -&gt; (3, 3, 2) is not good, because &quot;3&quot; is higher than it.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = [1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Root is considered as <strong>good</strong>.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the binary tree is in the range&nbsp;<code>[1, 10^5]</code>.</li>
	<li>Each node&#39;s value is between <code>[-10^4, 10^4]</code>.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A node is good if nothing larger appears on the path from the root. $n\le 10^5$. DFS carries the path maximum $mx$; count the node when its value is at least $mx$, then update $mx$.

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

    public int goodNodes(TreeNode root) {
        dfs(root, -100000);
        return ans;
    }

    private void dfs(TreeNode root, int mx) {
        if (root == null) {
            return;
        }
        if (mx <= root.val) {
            ++ans;
            mx = root.val;
        }
        dfs(root.left, mx);
        dfs(root.right, mx);
    }
}
```

### Solution 2: Explicit Stack

> **Thinking**
>
> A node is good when no larger value appears on the path from the root. With $n$ up to $10^5$, one walk that carries the path maximum $mx$ is enough: count the node when its value is at least $mx$, then update $mx$.
>
> The walk enters the left child first. A left chain can be $n$ nodes long, so recursion overflows before the count is finished. Each node is compared only with the maximum on its own path, so the two children do not depend on each other.
>
> The nodes still to visit fit on an explicit stack together with the $mx$ from above. After a pop, a value at least $mx$ is counted and $mx$ becomes that value; the right child is pushed, then the left child, both with this $mx$, so the left child is handled first.
>
> The initial $mx$ is below the lower bound $-10^4$, so the root is always good. Each node is pushed once.

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
    public int goodNodes(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> limits = new ArrayDeque<>();
        if (root != null) {
            nodes.push(root);
            limits.push(-100000);
        }
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int mx = limits.pop();
            if (mx <= node.val) {
                ++ans;
                mx = node.val;
            }
            if (node.right != null) {
                nodes.push(node.right);
                limits.push(mx);
            }
            if (node.left != null) {
                nodes.push(node.left);
                limits.push(mx);
            }
        }
        return ans;
    }
}
```
