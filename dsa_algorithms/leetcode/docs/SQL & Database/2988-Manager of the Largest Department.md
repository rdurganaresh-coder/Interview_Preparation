# 2988. Manager of the Largest Department

**Difficulty:** Medium  
**Category:** SQL & Database  
**LeetCode:** https://leetcode.com/problems/manager-of-the-largest-department/

---

[中文文档](/solution/2900-2999/2988.Manager%20of%20the%20Largest%20Department/README.md)

## Description

<p>Table: <code>Employees</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| emp_id      | int     |
| emp_name    | varchar |
| dep_id      | int     |
| position    | varchar |
+-------------+---------+
emp_id is column of unique values for this table.
This table contains emp_id, emp_name, dep_id, and position.
</pre>

<p>Write a solution to find the <strong>name</strong> of the <strong>manager</strong> from the <strong>largest department</strong>. There may be multiple largest departments when the number of employees in those departments is the same.</p>

<p>Return <em>the result table sorted by </em><code>dep_id</code><em> in <strong>ascending</strong> order</em><em>.</em></p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Employees table:
+--------+----------+--------+---------------+
| emp_id | emp_name | dep_id | position      | 
+--------+----------+--------+---------------+
| 156    | Michael  | 107    | Manager       |
| 112    | Lucas    | 107    | Consultant    |    
| 8      | Isabella | 101    | Manager       | 
| 160    | Joseph   | 100    | Manager       | 
| 80     | Aiden    | 100    | Engineer      | 
| 190    | Skylar   | 100    | Freelancer    | 
| 196    | Stella   | 101    | Coordinator   |
| 167    | Audrey   | 100    | Consultant    |
| 97     | Nathan   | 101    | Supervisor    |
| 128    | Ian      | 101    | Administrator |
| 81     | Ethan    | 107    | Administrator |
+--------+----------+--------+---------------+
<strong>Output</strong>
+--------------+--------+
| manager_name | dep_id | 
+--------------+--------+
| Joseph       | 100    | 
| Isabella     | 101    | 
+--------------+--------+
<strong>Explanation</strong>
- Departments with IDs 100 and 101 each has a total of 4 employees, while department 107 has 3 employees. Since both departments 100 and 101 have an equal number of employees, their respective managers will be included.
Output table is ordered by dep_id in ascending order.

</pre>

## Solutions

### Solution 1: Grouping + Equi-Join + Subquery

> **Thinking**
>
> Count employees per department, join to manager rows, and keep departments whose count equals the global maximum. The subquery $\textit{MAX}(\textit{cnt})$ avoids aggregating managers again after the join.
>
> Sort by department id.

We can first count the number of employees in each department, denoted as table `T`. Then we join `T` with the `Employees` table, with the join condition being `T.dep_id = Employees.dep_id` and `Employees.position = 'Manager'`. This way, we can get the manager of each department. Finally, we filter out the department with the most employees.
