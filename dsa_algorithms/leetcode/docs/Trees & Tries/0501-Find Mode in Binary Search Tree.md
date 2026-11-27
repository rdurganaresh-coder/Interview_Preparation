# 501. Find Mode in Binary Search Tree

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/find-mode-in-binary-search-tree/

---

[中文文档](/solution/0500-0599/0501.Find%20Mode%20in%20Binary%20Search%20Tree/README.md)

## Description

<p>Given the <code>root</code> of a binary search tree (BST) with duplicates, return <em>all the <a href="https://en.wikipedia.org/wiki/Mode_(statistics)" target="_blank">mode(s)</a> (i.e., the most frequently occurred element) in it</em>.</p>

<p>If the tree has more than one mode, return them in <strong>any order</strong>.</p>

<p>Assume a BST is defined as follows:</p>

<ul>
	<li>The left subtree of a node contains only nodes with keys <strong>less than or equal to</strong> the node&#39;s key.</li>
	<li>The right subtree of a node contains only nodes with keys <strong>greater than or equal to</strong> the node&#39;s key.</li>
	<li>Both the left and right subtrees must also be binary search trees.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0501.Find%20Mode%20in%20Binary%20Search%20Tree/images/mode-tree.jpg" style="width: 142px; height: 222px;" />
<pre>
<strong>Input:</strong> root = [1,null,2,2]
<strong>Output:</strong> [2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

## Solutions

### Solution 1

> **Thinking**
>
> The mode is the value with the highest frequency. Hashing every node is $O(n)$ time and space and fits $n \le 10^4$, but ignores that the tree is a BST.
>
> Inorder yields a non-decreasing sequence, so equal values are adjacent. Track the predecessor, the current run length, and the best frequency: replace the answer when the run grows, append when it ties. One inorder pass collects every mode with $O(h)$ extra space.

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
    private int mx;
    private int cnt;
    private TreeNode prev;
    private List<Integer> res;

    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        cnt = prev != null && prev.val == root.val ? cnt + 1 : 1;
        if (cnt > mx) {
            res = new ArrayList<>(Arrays.asList(root.val));
            mx = cnt;
        } else if (cnt == mx) {
            res.add(root.val);
        }
        prev = root;
        dfs(root.right);
    }
}
```

### Solution 2: Explicit-Stack Inorder

> **Thinking**
>
> The mode is the value with the highest frequency. Hashing every node fits $n \le 10^4$ in time, but ignores that the tree is a BST.
>
> Inorder visits the left child first. A chain of $10^4$ nodes recurses once per node and overflows the call stack.
>
> Inorder is non-decreasing, so equal values are adjacent. The predecessor, the current run length, and the best frequency are enough; the walk does not need a return value.
>
> An explicit stack performs the inorder walk. On entry it pushes an exit marker and the left child; on exit the run length updates the answer, and then the right child is pushed. A longer run replaces the answer, and a tie appends the value.

An inorder walk of a binary search tree is non-decreasing, so equal values are adjacent. An explicit stack carries that walk together with the previous value, the current run length, and the best frequency. On entry we push an exit marker and the left child. On exit the run grows by one when the value matches its predecessor and otherwise restarts at $1$. A longer run replaces the answer, a tie appends the value, and then the right child is pushed.

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
    private static class Frame {
        TreeNode node;
        int state;

        Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public int[] findMode(TreeNode root) {
        Integer prev = null;
        int mx = 0;
        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Deque<Frame> stk = new ArrayDeque<>();
            stk.push(new Frame(root, 0));
            while (!stk.isEmpty()) {
                Frame cur = stk.pop();
                TreeNode node = cur.node;
                if (cur.state == 0) {
                    stk.push(new Frame(node, 1));
                    if (node.left != null) {
                        stk.push(new Frame(node.left, 0));
                    }
                    continue;
                }
                cnt = prev != null && prev == node.val ? cnt + 1 : 1;
                if (cnt > mx) {
                    res = new ArrayList<>(Arrays.asList(node.val));
                    mx = cnt;
                } else if (cnt == mx) {
                    res.add(node.val);
                }
                prev = node.val;
                if (node.right != null) {
                    stk.push(new Frame(node.right, 0));
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
```
