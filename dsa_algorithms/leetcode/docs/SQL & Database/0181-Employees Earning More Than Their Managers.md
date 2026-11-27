# 181. Employees Earning More Than Their Managers

**Difficulty:** Easy  
**Category:** SQL & Database  
**LeetCode:** https://leetcode.com/problems/employees-earning-more-than-their-managers/

---

[中文文档](/solution/0100-0199/0181.Employees%20Earning%20More%20Than%20Their%20Managers/README.md)

## Description

<p>Table: <code>Employee</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| salary      | int     |
| managerId   | int     |
+-------------+---------+
id is the primary key (column with unique values) for this table.
Each row of this table indicates the ID of an employee, their name, salary, and the ID of their manager.
</pre>

<p>&nbsp;</p>

<p>Write a solution&nbsp;to find the employees who earn more than their managers.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Employee table:
+----+-------+--------+-----------+
| id | name  | salary | managerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | Null      |
| 4  | Max   | 90000  | Null      |
+----+-------+--------+-----------+
<strong>Output:</strong> 
+----------+
| Employee |
+----------+
| Joe      |
+----------+
<strong>Explanation:</strong> Joe is the only employee who earns more than his manager.
</pre>

## Solutions

### Solution 1: Self-Join + Conditional Filtering

> **Thinking**
>
> Employees and managers share one table; $\textit{managerId}$ points at the manager row. A self-join lines up each employee with that manager, then we keep names whose salary is strictly larger.

We can find employees' salaries and their managers' salaries by self-joining the `Employee` table, then filter out employees whose salaries are higher than their managers' salaries.
