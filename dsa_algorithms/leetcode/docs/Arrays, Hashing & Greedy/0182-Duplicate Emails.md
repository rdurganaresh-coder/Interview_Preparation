# 182. Duplicate Emails

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/duplicate-emails/

---

[中文文档](/solution/0100-0199/0182.Duplicate%20Emails/README.md)

## Description

<p>Table: <code>Person</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| email       | varchar |
+-------------+---------+
id is the primary key (column with unique values) for this table.
Each row of this table contains an email. The emails will not contain uppercase letters.
</pre>

<p>&nbsp;</p>

<p>Write a solution to report all the duplicate emails. Note that it&#39;s guaranteed that the email&nbsp;field is not NULL.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The&nbsp;result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Person table:
+----+---------+
| id | email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
<strong>Output:</strong> 
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
<strong>Explanation:</strong> a@b.com is repeated two times.
</pre>

## Solutions

### Solution 1: Group By + Having

> **Thinking**
>
> Find emails that occur more than once. Group by $\textit{email}$ and keep groups with $\textit{HAVING}\,\textit{COUNT}>1$. That is exactly “frequency above one”.

We can use the `GROUP BY` statement to group the data by the $\textit{email}$ field, and then use the $\textit{HAVING}$ statement to filter out the $\textit{email}$ addresses that appear more than once.

### Solution 2: Self-Join

> **Thinking**
>
> Solution 1 aggregates. A self-join on the same email and different $id$s also proves the email appears twice; then distinct. No $\textit{GROUP BY}$.

We can use a self-join to join the `Person` table with itself, and then filter out the records where the `id` is different but the `email` is the same.
