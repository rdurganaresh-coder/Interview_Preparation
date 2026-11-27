# 508. Most Frequent Subtree Sum

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/most-frequent-subtree-sum/

---

[中文文档](/solution/0500-0599/0508.Most%20Frequent%20Subtree%20Sum/README.md)

## Description

<p>Given the <code>root</code> of a binary tree, return the most frequent <strong>subtree sum</strong>. If there is a tie, return all the values with the highest frequency in any order.</p>

<p>The <strong>subtree sum</strong> of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0508.Most%20Frequent%20Subtree%20Sum/images/freq1-tree.jpg" style="width: 207px; height: 183px;" />
<pre>
<strong>Input:</strong> root = [5,2,-3]
<strong>Output:</strong> [2,-3,4]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0508.Most%20Frequent%20Subtree%20Sum/images/freq2-tree.jpg" style="width: 207px; height: 183px;" />
<pre>
<strong>Input:</strong> root = [5,2,-5]
<strong>Output:</strong> [2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Hash Table + DFS

> **Thinking**
>
> A subtree sum is left + right + root, so both children must be known first. Rescanning each subtree repeats work.
>
> A post-order DFS returns the current sum and a hash map counts frequencies. After the walk, keep the sums whose frequency is maximal. One traversal both sums and counts.

We can use a hash table $\textit{cnt}$ to record the frequency of each subtree sum. Then, we use depth-first search (DFS) to traverse the entire tree, calculate the sum of elements for each subtree, and update $\textit{cnt}$.

Finally, we traverse $\textit{cnt}$ to find all subtree sums that appear most frequently.

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
    private Map<Integer, Integer> cnt = new HashMap<>();
    private int mx;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> ans = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            if (e.getValue() == mx) {
                ans.add(e.getKey());
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int s = root.val + dfs(root.left) + dfs(root.right);
        mx = Math.max(mx, cnt.merge(s, 1, Integer::sum));
        return s;
    }
}
```

### Solution 2: Hash Table + Explicit Stack

> **Thinking**
>
> A subtree sum is the left sum plus the right sum plus the node value, so both children must be known first. Rescanning each subtree repeats work. Returning the sum from a postorder recursion is correct on a short tree.
>
> The tree can contain $10^4$ nodes. A left chain makes this postorder walk recurse once per node and overflow the call stack.
>
> Each sum depends only on the two children, so children must be finished before their parent. Frequencies can be counted in a hash table during the walk.
>
> An explicit stack performs that postorder walk. On entry it pushes an exit marker and the two children; on exit it writes the subtree sum into the hash table. After the walk, the sums with the highest frequency are the answer.

A hash table $\textit{cnt}$ records how often each subtree sum appears. An explicit stack walks the binary tree in postorder. On entry we push an exit marker, then the right child and the left child. On exit the children's sums are already stored, the current sum is those two plus the node value, and $\textit{cnt}$ is updated.

Finally we keep every subtree sum whose frequency is maximal.

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
    private static class Frame {
        TreeNode node;
        int state;

        Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<TreeNode, Integer> sub = new IdentityHashMap<>();
        int mx = 0;
        if (root != null) {
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
                int l = node.left == null ? 0 : sub.get(node.left);
                int r = node.right == null ? 0 : sub.get(node.right);
                int s = node.val + l + r;
                mx = Math.max(mx, cnt.merge(s, 1, Integer::sum));
                sub.put(node, s);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            if (e.getValue() == mx) {
                ans.add(e.getKey());
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
```
