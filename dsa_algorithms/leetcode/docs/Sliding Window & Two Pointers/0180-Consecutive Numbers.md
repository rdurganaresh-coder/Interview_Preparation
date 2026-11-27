# 180. Consecutive Numbers

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/consecutive-numbers/

---

[中文文档](/solution/0100-0199/0180.Consecutive%20Numbers/README.md)

## Description

<p>Table: <code>Logs</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
In SQL, id is the primary key for this table.
id is an autoincrement column starting from 1.
</pre>

<p>&nbsp;</p>

<p>Find all numbers that appear at least three times consecutively.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The&nbsp;result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Logs table:
+----+-----+
| id | num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+
<strong>Output:</strong> 
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
<strong>Explanation:</strong> 1 is the only number that appears consecutively for at least three times.
</pre>

## Solutions

### Solution 1: Two Joins

> **Thinking**
>
> Find numbers that appear at least three times in a row. Self-join the log twice, requiring adjacent $id$s to differ by $1$ and $\textit{num}$ to match. That pins a window of length $3$; then distinct the values.

We can use two joins to solve this problem.

First, we perform a self-join with the condition `l1.num = l2.num` and `l1.id = l2.id - 1`, so that we can find all numbers that appear at least twice in a row. Then, we perform another self-join with the condition `l2.num = l3.num` and `l2.id = l3.id - 1`, so that we can find all numbers that appear at least three times in a row. Finally, we only need to select the distinct `l2.num`.

### Solution 2: Window Function

> **Thinking**
>
> Solution 1 uses two joins. $\textit{LAG}/\textit{LEAD}$ fetch the neighboring $\textit{num}$s; equality of the three values is a run of length three, with less joining.

We can use the window functions $\textit{LAG}$ and $\textit{LEAD}$ to obtain the $\textit{num}$ of the previous row and the next row of the current row, and record them in the fields $a$ and $b$, respectively. Finally, we only need to filter out the rows where $a = \textit{num}$ and $b = \textit{num}$, which are the numbers that appear at least three times in a row. Note that we need to use the `DISTINCT` keyword to remove duplicates from the results.

We can also group the numbers by using the `IF` function to determine whether the $\textit{num}$ of the current row is equal to the $\textit{num}$ of the previous row. If they are equal, we set it to $0$, otherwise we set it to $1$. Then, we use the window function `SUM` to calculate the prefix sum, which is the grouping identifier. Finally, we only need to group by the grouping identifier and filter out the numbers with a row count greater than or equal to $3$ in each group. Similarly, we need to use the `DISTINCT` keyword to remove duplicates from the results.

### Solution 3

> **Thinking**
>
> Solution 2 only looks at windows of length $3$, so a longer run is reported in pieces. A flag that toggles when $\textit{num}$ changes, plus a prefix sum, assigns a group id to each run; $\textit{HAVING}\,\textit{COUNT}\ge 3$ keeps every run that is long enough.
