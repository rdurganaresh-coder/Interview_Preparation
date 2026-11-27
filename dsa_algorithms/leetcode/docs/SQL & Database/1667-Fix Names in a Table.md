# 1667. Fix Names in a Table

**Difficulty:** Easy  
**Category:** SQL & Database  
**LeetCode:** https://leetcode.com/problems/fix-names-in-a-table/

---

[中文文档](/solution/1600-1699/1667.Fix%20Names%20in%20a%20Table/README.md)

## Description

<p>Table: <code>Users</code></p>

<pre>
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| user_id        | int     |
| name           | varchar |
+----------------+---------+
user_id is the primary key (column with unique values) for this table.
This table contains the ID and the name of the user. The name consists of only lowercase and uppercase characters.
</pre>

<p>&nbsp;</p>

<p>Write a solution to fix the names so that only the first character is uppercase and the rest are lowercase.</p>

<p>Return the result table ordered by <code>user_id</code>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Users table:
+---------+-------+
| user_id | name  |
+---------+-------+
| 1       | aLice |
| 2       | bOB   |
+---------+-------+
<strong>Output:</strong> 
+---------+-------+
| user_id | name  |
+---------+-------+
| 1       | Alice |
| 2       | Bob   |
+---------+-------+
</pre>

## Solutions

### Solution 1

> **Thinking**
>
> Names must have a capital first letter and lowercase remainder. Concatenate $\texttt{UPPER}(\texttt{LEFT}(\textit{name},1))$ with $\texttt{LOWER}(\texttt{SUBSTRING}(\textit{name},2))$, then order by $\texttt{user\_id}$.

### Solution 2

> **Thinking**
>
> Solution 1's $\texttt{SUBSTRING}(\textit{name},2)$ omits the length and runs to the end. MySQL counts the third argument in characters, so $\texttt{CHAR\_LENGTH}(\textit{name})$ supplies that count and the slice from the second character is the same suffix.
