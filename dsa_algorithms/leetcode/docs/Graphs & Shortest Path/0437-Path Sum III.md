# 437. Path Sum III

**Difficulty:** Medium  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/path-sum-iii/

---

[中文文档](/solution/0400-0499/0437.Path%20Sum%20III/README.md)

## Description

<p>Given the <code>root</code> of a binary tree and an integer <code>targetSum</code>, return <em>the number of paths where the sum of the values&nbsp;along the path equals</em>&nbsp;<code>targetSum</code>.</p>

<p>The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0400-0499/0437.Path%20Sum%20III/images/pathsum3-1-tree.jpg" style="width: 450px; height: 386px;" />
<pre>
<strong>Input:</strong> root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
<strong>Output:</strong> 3
<strong>Explanation:</strong> The paths that sum to 8 are shown.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 1000]</code>.</li>
	<li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
	<li><code>-1000 &lt;= targetSum &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Hash Table + Prefix Sum + Recursion

> **Thinking**
>
> Paths must go downward. Trying every ancestor then walking down is $O(n^2)$. A path summing to $\textit{targetSum}$ is a current prefix minus some ancestor prefix.
>
> Accumulate the prefix $s$ in preorder and store prefix frequencies on the root-to-node path. $\textit{cnt}[s-\textit{targetSum}]$ counts valid paths ending here. Undo $s$ on the way back so another branch does not see it.
>
> $\textit{cnt}[0]=1$ accounts for a path that starts at the root. Lookup before insert so the current node is not used twice.

We can use the idea of prefix sums to recursively traverse the binary tree while using a hash table $\textit{cnt}$ to count the occurrences of each prefix sum along the path from the root to the current node.

We design a recursive function $\textit{dfs}(\textit{node}, s)$, where $\textit{node}$ represents the current node being traversed, and $s$ represents the prefix sum along the path from the root to the current node. The return value of the function is the number of paths ending at $\textit{node}$ or its subtree nodes with a sum equal to $\textit{targetSum}$. The final answer is $\textit{dfs}(\textit{root}, 0)$.

The recursive process of $\textit{dfs}(\textit{node}, s)$ is as follows:

- If the current node $\textit{node}$ is null, return $0$.
- Calculate the prefix sum $s$ along the path from the root to the current node.
- Use $\textit{cnt}[s - \textit{targetSum}]$ to represent the number of paths ending at the current node with a sum equal to $\textit{targetSum}$. Here, $\textit{cnt}[s - \textit{targetSum}]$ is the count of prefix sums equal to $s - \textit{targetSum}$ in $\textit{cnt}$.
- Increment the count of the prefix sum $s$ by $1$, i.e., $\textit{cnt}[s] = \textit{cnt}[s] + 1$.
- Recursively traverse the left and right child nodes of the current node by calling $\textit{dfs}(\textit{node}.\textit{left}, s)$ and $\textit{dfs}(\textit{node}.\textit{right}, s)$, and add their return values.
- After the return value is calculated, decrement the count of the prefix sum $s$ by $1$, i.e., $\textit{cnt}[s] = \textit{cnt}[s] - 1$.
- Finally, return the result.

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
    private Map<Long, Integer> cnt = new HashMap<>();
    private int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        cnt.put(0L, 1);
        this.targetSum = targetSum;
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, long s) {
        if (node == null) {
            return 0;
        }
        s += node.val;
        int ans = cnt.getOrDefault(s - targetSum, 0);
        cnt.merge(s, 1, Integer::sum);
        ans += dfs(node.left, s);
        ans += dfs(node.right, s);
        cnt.merge(s, -1, Integer::sum);
        return ans;
    }
}
```
