# 3054. Binary Tree Nodes

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/binary-tree-nodes/

---

[中文文档](/solution/3000-3099/3054.Binary%20Tree%20Nodes/README.md)

## Description

<p>Table: <font face="monospace"><code>Tree</code></font></p>

<pre>
+-------------+------+ 
| Column Name | Type | 
+-------------+------+ 
| N           | int  | 
| P           | int  |
+-------------+------+
N is the column of unique values for this table.
Each row includes N and P, where N represents the value of a node in Binary Tree, and P is the parent of N.
</pre>

<p>Write a solution to find the node type of the Binary Tree. Output one of the following for each node:</p>

<ul>
	<li><strong>Root</strong>: if the node is the root node.</li>
	<li><strong>Leaf</strong>: if the node is the leaf node.</li>
	<li><strong>Inner</strong>: if the node is neither root nor leaf node.</li>
</ul>

<p>Return <em>the result table ordered by node value in <strong>ascending order</strong></em>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Tree table:
+---+------+
| N | P    | 
+---+------+
| 1 | 2    |
| 3 | 2    | 
| 6 | 8    | 
| 9 | 8    | 
| 2 | 5    | 
| 8 | 5    | 
| 5 | null | 
+---+------+
<strong>Output:</strong> 
+---+-------+
| N | Type  | 
+---+-------+
| 1 | Leaf  | 
| 2 | Inner |
| 3 | Leaf  |
| 5 | Root  |
| 6 | Leaf  |
| 8 | Inner |
| 9 | Leaf  |    
+---+-------+
<strong>Explanation:</strong> 
- Node 5 is the root node since it has no parent node.
- Nodes 1, 3, 6, and 9 are leaf nodes because they don&#39;t have any child nodes.
- Nodes 2, and 8 are inner nodes as they serve as parents to some of the nodes in the structure.
</pre>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as <a href="https://leetcode.com/problems/tree-node/description/" target="_blank"> 608: Tree Node.</a></p>

## Solutions

### Solution 1: Left Join

> **Thinking**
>
> A node’s role depends on having a parent and having a child. The parent is column $P$; children are other rows that point at this node.
>
> A left self-join on $t_1.N=t_2.P$ distinguishes a null $t_1.P$ (root) from a null $t_2$ (leaf) from an inner node.
>
> The join can duplicate nodes, so we take distinct $N$ and sort.

If a node's parent is null, then it is a root node; if a node is not the parent of any node, then it is a leaf node; otherwise, it is an internal node.

Therefore, we use left join to join the `Tree` table twice, with the join condition being `t1.N = t2.P`. If `t1.P` is null, then `t1.N` is a root node; if `t2.P` is null, then `t1.N` is a leaf node; otherwise, `t1.N` is an internal node.
