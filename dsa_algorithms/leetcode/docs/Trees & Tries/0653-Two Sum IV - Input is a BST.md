# 653. Two Sum IV - Input is a BST

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

---

[中文文档](/solution/0600-0699/0653.Two%20Sum%20IV%20-%20Input%20is%20a%20BST/README.md)

## Description

<p>Given the <code>root</code> of a binary search tree and an integer <code>k</code>, return <code>true</code> <em>if there exist two elements in the BST such that their sum is equal to</em> <code>k</code>, <em>or</em> <code>false</code> <em>otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0600-0699/0653.Two%20Sum%20IV%20-%20Input%20is%20a%20BST/images/sum_tree_1.jpg" style="width: 400px; height: 229px;" />
<pre>
<strong>Input:</strong> root = [5,3,6,2,4,null,7], k = 9
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0600-0699/0653.Two%20Sum%20IV%20-%20Input%20is%20a%20BST/images/sum_tree_2.jpg" style="width: 400px; height: 229px;" />
<pre>
<strong>Input:</strong> root = [5,3,6,2,4,null,7], k = 28
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
	<li><code>root</code> is guaranteed to be a <strong>valid</strong> binary search tree.</li>
	<li><code>-10<sup>5</sup> &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Find two nodes summing to $k$. Inorder plus two pointers works after collecting values.
>
> A set of seen values during a walk is enough: if $k-\textit{val}$ is present, return true. The BST order is not required.

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
    private Set<Integer> vis = new HashSet<>();
    private int k;

    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (vis.contains(k - root.val)) {
            return true;
        }
        vis.add(root.val);
        return dfs(root.left) || dfs(root.right);
    }
}
```

### Solution 2

> **Thinking**
>
> DFS can be replaced by BFS with the same seen-set test; only the traversal order changes.

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
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        Set<Integer> vis = new HashSet<>();
        while (!q.isEmpty()) {
            for (int n = q.size(); n > 0; --n) {
                TreeNode node = q.poll();
                if (vis.contains(k - node.val)) {
                    return true;
                }
                vis.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return false;
    }
}
```

### Solution 3: Hash Set and Explicit Stack

> **Thinking**
>
> Find two nodes whose values sum to $k$. Inorder plus two pointers works after collecting every value. A set of values already seen is enough: if $k$ minus the current value is present, return true. On a short tree one depth-first walk does this, and the BST order is not required.
>
> The tree can contain $10^4$ nodes. A left chain makes this walk recurse once per node and overflow the call stack.
>
> Each node depends only on values already visited. The children do not need to return before the node is checked.
>
> An explicit stack keeps that depth-first order. Pop a node, test $k$ minus its value, then store the value and push the right child and the left child. The set belongs to this call only.

A hash set stores values already visited, and an explicit stack walks the tree depth-first. When a node is popped, return true if $k$ minus its value is already in the set. Otherwise store the value and push the non-null right child and left child.

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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> vis = new HashSet<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        if (root != null) {
            stk.push(root);
        }
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            if (vis.contains(k - node.val)) {
                return true;
            }
            vis.add(node.val);
            if (node.right != null) {
                stk.push(node.right);
            }
            if (node.left != null) {
                stk.push(node.left);
            }
        }
        return false;
    }
}
```
