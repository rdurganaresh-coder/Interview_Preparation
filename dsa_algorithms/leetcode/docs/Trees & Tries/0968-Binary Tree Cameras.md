# 968. Binary Tree Cameras

**Difficulty:** Hard  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/binary-tree-cameras/

---

[中文文档](/solution/0900-0999/0968.Binary%20Tree%20Cameras/README.md)

## Description

<p>You are given the <code>root</code> of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.</p>

<p>Return <em>the minimum number of cameras needed to monitor all nodes of the tree</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0900-0999/0968.Binary%20Tree%20Cameras/images/bst_cameras_01.png" style="width: 138px; height: 163px;" />
<pre>
<strong>Input:</strong> root = [0,0,null,0,0]
<strong>Output:</strong> 1
<strong>Explanation:</strong> One camera is enough to monitor all nodes if placed as shown.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0900-0999/0968.Binary%20Tree%20Cameras/images/bst_cameras_02.png" style="width: 139px; height: 312px;" />
<pre>
<strong>Input:</strong> root = [0,0,null,0,null,0,null,null,0]
<strong>Output:</strong> 2
<strong>Explanation:</strong> At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li>
	<li><code>Node.val == 0</code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming (Tree DP)

> **Thinking**
>
> A camera covers itself, its parent, and its children; we want as few as possible. The optimum at a node depends on the children, so we distinguish “has a camera / covered by a child / uncovered”. Tree DP returns the three minima bottom-up; the root may not stay uncovered.

For each node, we define three states:

- `a`: The current node has a camera
- `b`: The current node does not have a camera, but is monitored by its children
- `c`: The current node does not have a camera and is not monitored by its children

Next, we design a function $\textit{dfs}(\textit{root})$, which will return an array of length 3, representing the minimum number of cameras in the subtree rooted at $\textit{root}$ for the three states. The answer is $\min(\textit{dfs}(\textit{root})[0], \textit{dfs}(\textit{root})[1])$.

The calculation process of the function $\textit{dfs}(\textit{root})$ is as follows:

If $\textit{root}$ is null, return $[\textit{inf}, 0, 0]$, where $\textit{inf}$ represents a very large number, used to indicate an impossible situation.

Otherwise, we recursively calculate the left and right subtrees of $\textit{root}$, obtaining $[la, lb, lc]$ and $[ra, rb, rc]$ respectively.

- If the current node has a camera, then its left and right children must be in a monitored state, i.e., $a = \min(la, lb, lc) + \min(ra, rb, rc) + 1$.
- If the current node does not have a camera but is monitored by its children, then one or both of the children must have a camera, i.e., $b = \min(la + rb, lb + ra, la + ra)$.
- If the current node does not have a camera and is not monitored by its children, then the children must be monitored by their children, i.e., $c = lb + rb$.

Finally, we return $[a, b, c]$.

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
    public int minCameraCover(TreeNode root) {
        int[] ans = dfs(root);
        return Math.min(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {1 << 29, 0, 0};
        }
        var l = dfs(root.left);
        var r = dfs(root.right);
        int a = 1 + Math.min(Math.min(l[0], l[1]), l[2]) + Math.min(Math.min(r[0], r[1]), r[2]);
        int b = Math.min(Math.min(l[0] + r[1], l[1] + r[0]), l[0] + r[0]);
        int c = l[1] + r[1];
        return new int[] {a, b, c};
    }
}
```

### Solution 2: Tree DP on an Explicit Stack

> **Thinking**
>
> A camera covers itself, its parent, and its children, so the minimum depends on how each node is covered. Bottom-up, the three states are “has a camera”, “covered by a child”, and “uncovered”. On a short tree, returning those three minima is enough, and the root may not stay uncovered.
>
> The tree can contain $1000$ nodes. A left chain makes this postorder walk recurse once per node and overflow the call stack.
>
> The three states of a node depend only on the three states of its children, so children must be finished before their parent.
>
> An explicit stack performs that postorder walk. On entry it pushes an exit marker and the two children; on exit it writes the node’s states with the original three formulas. The answer is the smaller of the root’s first two states.

For each node, we define three states:

- `a`: The current node has a camera
- `b`: The current node does not have a camera, but is monitored by its children
- `c`: The current node does not have a camera and is not monitored by its children

A null node corresponds to $(\textit{inf}, 0, 0)$, where $\textit{inf}$ is a very large number used for an impossible situation.

We walk the binary tree in postorder with an explicit stack. On entry we push an exit marker, then the right child and the left child. On exit the children’s states are already stored as $[la, lb, lc]$ and $[ra, rb, rc]$.

- If the current node has a camera, then its left and right children must be in a monitored state, i.e., $a = \min(la, lb, lc) + \min(ra, rb, rc) + 1$.
- If the current node does not have a camera but is monitored by its children, then one or both of the children must have a camera, i.e., $b = \min(la + rb, lb + ra, la + ra)$.
- If the current node does not have a camera and is not monitored by its children, then the children must be monitored by their children, i.e., $c = lb + rb$.

The root must not stay uncovered, so the answer is $\min(a, b)$.

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
    private static final int INF = 1 << 29;

    private static class Frame {
        TreeNode node;
        int state;

        Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, int[]> sub = new IdentityHashMap<>();
        Deque<Frame> stk = new ArrayDeque<>();
        stk.push(new Frame(root, 0));
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
            int[] l = node.left == null ? new int[] {INF, 0, 0} : sub.get(node.left);
            int[] r = node.right == null ? new int[] {INF, 0, 0} : sub.get(node.right);
            int a = 1 + Math.min(Math.min(l[0], l[1]), l[2]) + Math.min(Math.min(r[0], r[1]), r[2]);
            int b = Math.min(Math.min(l[0] + r[1], l[1] + r[0]), l[0] + r[0]);
            int c = l[1] + r[1];
            sub.put(node, new int[] {a, b, c});
        }
        int[] ans = sub.get(root);
        return Math.min(ans[0], ans[1]);
    }
}
```
