# 2583. Kth Largest Sum in a Binary Tree

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/

---

[中文文档](/solution/2500-2599/2583.Kth%20Largest%20Sum%20in%20a%20Binary%20Tree/README.md)

## Description

<p>You are given the <code>root</code> of a binary tree and a positive integer <code>k</code>.</p>

<p>The <strong>level sum</strong> in the tree is the sum of the values of the nodes that are on the <strong>same</strong> level.</p>

<p>Return<em> the </em><code>k<sup>th</sup></code><em> <strong>largest</strong> level sum in the tree (not necessarily distinct)</em>. If there are fewer than <code>k</code> levels in the tree, return <code>-1</code>.</p>

<p><strong>Note</strong> that two nodes are on the same level if they have the same distance from the root.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2500-2599/2583.Kth%20Largest%20Sum%20in%20a%20Binary%20Tree/images/binaryytreeedrawio-2.png" style="width: 301px; height: 284px;" />
<pre>
<strong>Input:</strong> root = [5,8,9,2,1,3,7,4,6], k = 2
<strong>Output:</strong> 13
<strong>Explanation:</strong> The level sums are the following:
- Level 1: 5.
- Level 2: 8 + 9 = 17.
- Level 3: 2 + 1 + 3 + 7 = 13.
- Level 4: 4 + 6 = 10.
The 2<sup>nd</sup> largest level sum is 13.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2500-2599/2583.Kth%20Largest%20Sum%20in%20a%20Binary%20Tree/images/treedrawio-3.png" style="width: 181px; height: 181px;" />
<pre>
<strong>Input:</strong> root = [1,2,null,3], k = 1
<strong>Output:</strong> 3
<strong>Explanation:</strong> The largest level sum is 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is <code>n</code>.</li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
</ul>

## Solutions

### Solution 1: BFS + Sorting

> **Thinking**
>
> Return the $k$-th largest level sum, or $-1$ if there are fewer than $k$ levels. BFS accumulates each level, then selects the $k$-th largest.

We can use BFS to traverse the binary tree, while recording the sum of nodes at each level, then sort the array of node sums, and finally return the $k$th largest node sum. Note that if the number of levels in the binary tree is less than $k$, then return $-1$.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree.

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> arr = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            long t = 0;
            for (int n = q.size(); n > 0; --n) {
                root = q.pollFirst();
                t += root.val;
                if (root.left != null) {
                    q.offer(root.left);
                }
                if (root.right != null) {
                    q.offer(root.right);
                }
            }
            arr.add(t);
        }
        if (arr.size() < k) {
            return -1;
        }
        Collections.sort(arr, Collections.reverseOrder());
        return arr.get(k - 1);
    }
}
```

### Solution 2: DFS + Sorting

> **Thinking**
>
> Solution 1 uses a queue. DFS with a depth index fills the same per-level totals; only the traversal differs before the $k$-th largest is taken.

We can also use DFS to traverse the binary tree, while recording the sum of nodes at each level, then sort the array of node sums, and finally return the $k$th largest node sum. Note that if the number of levels in the binary tree is less than $k$, then return $-1$.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree.

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
    private List<Long> arr = new ArrayList<>();

    public long kthLargestLevelSum(TreeNode root, int k) {
        dfs(root, 0);
        if (arr.size() < k) {
            return -1;
        }
        Collections.sort(arr, Collections.reverseOrder());
        return arr.get(k - 1);
    }

    private void dfs(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        if (arr.size() <= d) {
            arr.add(0L);
        }
        arr.set(d, arr.get(d) + root.val);
        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }
}
```
