# 1112. Highest Grade For Each Student

**Difficulty:** Medium  
**Category:** SQL & Database  
**LeetCode:** https://leetcode.com/problems/highest-grade-for-each-student/

---

[中文文档](/solution/1100-1199/1112.Highest%20Grade%20For%20Each%20Student/README.md)

## Description

<p>Table: <code>Enrollments</code></p>

<pre>
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| student_id    | int     |
| course_id     | int     |
| grade         | int     |
+---------------+---------+
(student_id, course_id) is the primary key (combination of columns with unique values) of this table.
grade is never NULL.
</pre>

<p>&nbsp;</p>

<p>Write a solution to find the highest grade with its corresponding course for each student. In case of a tie, you should find the course with the smallest <code>course_id</code>.</p>

<p>Return the result table ordered by <code>student_id</code> in <strong>ascending order</strong>.</p>

<p>The&nbsp;result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Enrollments table:
+------------+-------------------+
| student_id | course_id | grade |
+------------+-----------+-------+
| 2          | 2         | 95    |
| 2          | 3         | 95    |
| 1          | 1         | 90    |
| 1          | 2         | 99    |
| 3          | 1         | 80    |
| 3          | 2         | 75    |
| 3          | 3         | 82    |
+------------+-----------+-------+
<strong>Output:</strong> 
+------------+-------------------+
| student_id | course_id | grade |
+------------+-----------+-------+
| 1          | 2         | 99    |
| 2          | 2         | 95    |
| 3          | 3         | 82    |
+------------+-----------+-------+
</pre>

## Solutions

### Solution 1: RANK() OVER() Window Function

> **Thinking**
>
> Each student keeps the highest grade, breaking ties by the smallest `course_id`. `RANK() OVER (PARTITION BY student_id ORDER BY grade DESC, course_id)` encodes that order in one pass; rows with rank $1$ are the answer, then sort by `student_id`.

We can use the `RANK() OVER()` window function to sort the grades of each student in descending order. If the grades are the same, we sort them in ascending order by course number, and then select the record with a rank of $1$ for each student.

### Solution 2: Subquery

> **Thinking**
>
> Method 1 needs a window function. Otherwise aggregate `MAX(grade)` per student, then keep those grades in the base table and take `MIN(course_id)`. The two aggregations implement “highest grade” and “smallest course among ties.”

We can first query the highest grade of each student, and then query the minimum course number corresponding to the highest grade of each student.
