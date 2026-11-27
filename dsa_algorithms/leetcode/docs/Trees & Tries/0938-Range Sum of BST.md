# 938. Range Sum of BST

**Difficulty:** Easy  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/range-sum-of-bst/

---

[中文文档](/solution/0900-0999/0938.Range%20Sum%20of%20BST/README.md)

## Description

<p>Given the <code>root</code> node of a binary search tree and two integers <code>low</code> and <code>high</code>, return <em>the sum of values of all nodes with a value in the <strong>inclusive</strong> range </em><code>[low, high]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0900-0999/0938.Range%20Sum%20of%20BST/images/bst1.jpg" style="width: 400px; height: 222px;" />
<pre>
<strong>Input:</strong> root = [10,5,15,3,7,null,18], low = 7, high = 15
<strong>Output:</strong> 32
<strong>Explanation:</strong> Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0900-0999/0938.Range%20Sum%20of%20BST/images/bst2.jpg" style="width: 400px; height: 335px;" />
<pre>
<strong>Input:</strong> root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
<strong>Output:</strong> 23
<strong>Explanation:</strong> Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 2 * 10<sup>4</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= low &lt;= high &lt;= 10<sup>5</sup></code></li>
	<li>All <code>Node.val</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> Sum BST nodes whose values lie in $[\textit{low},\textit{high}]$. A full traversal works, but the search-tree order prunes: skip the left subtree when the current value is already $\le \textit{low}$, and skip the right when it is already $\ge \textit{high}$. Recurse and add nodes that fall inside the interval.

We design a function $\textit{dfs}(\textit{root})$, which represents the sum of the values of all nodes in the subtree with $\textit{root}$ as the root, and the values are within the range $[\textit{low}, \textit{high}]$. The answer is $\textit{dfs}(\textit{root})$.

The execution logic of the function $\textit{dfs}(\textit{root})$ is as follows:

- If $\textit{root}$ is null, return $0$.
- If the value $x$ of $\textit{root}$ is within the range $[\textit{low}, \textit{high}]$, then the initial answer of the function $\textit{dfs}(\textit{root})$ is $x$, otherwise it is $0$.
- If $x > \textit{low}$, it means that there may be nodes in the left subtree of $\textit{root}$ with values within the range $[\textit{low}, \textit{high}]$, so we need to recursively call $\textit{dfs}(\textit{root}.\textit{left})$ and add the result to the answer.
- If $x < \textit{high}$, it means that there may be nodes in the right subtree of $\textit{root}$ with values within the range $[\textit{low}, \textit{high}]$, so we need to recursively call $\textit{dfs}(\textit{root}.\textit{right})$ and add the result to the answer.
- Finally, return the answer.

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int x = root.val;
        int ans = low <= x && x <= high ? x : 0;
        if (x > low) {
            ans += dfs(root.left, low, high);
        }
        if (x < high) {
            ans += dfs(root.right, low, high);
        }
        return ans;
    }
}
```
