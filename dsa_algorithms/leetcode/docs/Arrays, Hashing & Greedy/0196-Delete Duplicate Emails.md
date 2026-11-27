# 196. Delete Duplicate Emails

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/delete-duplicate-emails/

---

[中文文档](/solution/0100-0199/0196.Delete%20Duplicate%20Emails/README.md)

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

<p>Write a solution to<strong> delete</strong> all duplicate emails, keeping only one unique email with the smallest <code>id</code>.</p>

<p>For SQL users, please note that you are supposed to write a <code>DELETE</code> statement and not a <code>SELECT</code> one.</p>

<p>For Pandas users, please note that you are supposed to modify <code>Person</code> in place.</p>

<p>After running your script, the answer shown is the <code>Person</code> table. The driver will first compile and run your piece of code and then show the <code>Person</code> table. The final order of the <code>Person</code> table <strong>does not matter</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Person table:
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
<strong>Output:</strong> 
+----+------------------+
| id | email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
<strong>Explanation:</strong> john@example.com is repeated two times. We keep the row with the smallest Id = 1.
</pre>

## Solutions

### Solution 1

> **Thinking**
>
> Keep the smallest $id$ per email. $\textit{MIN}(id)$ grouped by email is the survivor set; delete the rest. The extra subquery wrapper is what lets MySQL aggregate a table that is being deleted.

### Solution 2

> **Thinking**
>
> Solution 1 uses an aggregate subquery. $\textit{ROW\_NUMBER}$ partitioned by email and ordered by $id$ marks duplicates as numbers above $1$; delete those rows.

### Solution 3

> **Thinking**
>
> We need not compute the kept set first. Self-join on the same email with $\textit{p1}.id<\textit{p2}.id$ and delete the larger $id$. One $\textit{DELETE}\,\textit{JOIN}$.
