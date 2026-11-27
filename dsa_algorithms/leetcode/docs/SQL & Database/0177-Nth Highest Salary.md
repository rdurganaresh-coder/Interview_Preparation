# 177. Nth Highest Salary

**Difficulty:** Medium  
**Category:** SQL & Database  
**LeetCode:** https://leetcode.com/problems/nth-highest-salary/

---

[中文文档](/solution/0100-0199/0177.Nth%20Highest%20Salary/README.md)

## Description

<p>Table: <code>Employee</code></p>

<pre>
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
id is the primary key (column with unique values) for this table.
Each row of this table contains information about the salary of an employee.
</pre>

<p>&nbsp;</p>

<p>Write a solution to find the <code>n<sup>th</sup></code> highest <strong>distinct</strong> salary from the <code>Employee</code> table. If there are less than <code>n</code> distinct salaries, return&nbsp;<code>null</code>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
n = 2
<strong>Output:</strong> 
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> 
Employee table:
+----+--------+
| id | salary |
+----+--------+
| 1  | 100    |
+----+--------+
n = 2
<strong>Output:</strong> 
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| null                   |
+------------------------+
</pre>

## Solutions

### Solution 1

> **Thinking**
>
> Generalize “second highest” to the $N$-th: distinct salaries descending, then index $N-1$. $N<1$ or fewer than $N$ distinct values yields $\textit{NULL}$. In SQL, $\textit{LIMIT}\,1\,\textit{OFFSET}\,N-1$ finds that row; an outer query turns an empty result into $\textit{NULL}$.
