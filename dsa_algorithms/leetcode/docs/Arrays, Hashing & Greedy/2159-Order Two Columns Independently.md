# 2159. Order Two Columns Independently

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/order-two-columns-independently/

---

[中文文档](/solution/2100-2199/2159.Order%20Two%20Columns%20Independently/README.md)

## Description

<p>Table: <code>Data</code></p>

<pre>
+-------------+------+
| Column Name | Type |
+-------------+------+
| first_col   | int  |
| second_col  | int  |
+-------------+------+
This table may contain duplicate rows.
</pre>

<p>&nbsp;</p>

<p>Write a solution to independently:</p>

<ul>
	<li>order <code>first_col</code> in <strong>ascending order</strong>.</li>
	<li>order <code>second_col</code> in <strong>descending order</strong>.</li>
</ul>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Data table:
+-----------+------------+
| first_col | second_col |
+-----------+------------+
| 4         | 2          |
| 2         | 3          |
| 3         | 1          |
| 1         | 4          |
+-----------+------------+
<strong>Output:</strong> 
+-----------+------------+
| first_col | second_col |
+-----------+------------+
| 1         | 4          |
| 2         | 3          |
| 3         | 2          |
| 4         | 1          |
+-----------+------------+
</pre>

## Solutions

### Solution 1

> **Thinking**
>
> The two columns must be sorted independently — the first ascending, the second descending — then aligned by row. Sorting the table as pairs would keep the original coupling.
>
> Window functions assign ranks in each column; a join on the rank lines up the independently ordered values.
>
> Number $\textit{first\_col}$ ascending and $\textit{second\_col}$ descending, then join on $rk$.
