# 183. Customers Who Never Order

**Difficulty:** Easy  
**Category:** SQL & Database  
**LeetCode:** https://leetcode.com/problems/customers-who-never-order/

---

[中文文档](/solution/0100-0199/0183.Customers%20Who%20Never%20Order/README.md)

## Description

<p>Table: <code>Customers</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
+-------------+---------+
id is the primary key (column with unique values) for this table.
Each row of this table indicates the ID and name of a customer.
</pre>

<p>&nbsp;</p>

<p>Table: <code>Orders</code></p>

<pre>
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| customerId  | int  |
+-------------+------+
id is the primary key (column with unique values) for this table.
customerId is a foreign key (reference columns) of the ID from the Customers table.
Each row of this table indicates the ID of an order and the ID of the customer who ordered it.
</pre>

<p>&nbsp;</p>

<p>Write a solution to find all customers who never order anything.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Customers table:
+----+-------+
| id | name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Orders table:
+----+------------+
| id | customerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
<strong>Output:</strong> 
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
</pre>

## Solutions

### Solution 1: NOT IN

> **Thinking**
>
> Customers with no orders are those whose $id$ is outside the $\textit{customerId}$ set. $\textit{NOT IN}$ is that set difference. Watch the empty-list semantics of $\textit{NOT IN}$ on some engines.

List all customer IDs of existing orders, and use `NOT IN` to find customers who are not in the list.

### Solution 2: LEFT JOIN

> **Thinking**
>
> Solution 1 is awkward on a large subquery. A left join to orders, keeping rows whose $\textit{customerId}$ is null, avoids the $\textit{NOT IN}$/$\textit{NULL}$ trap and can use a join plan.

Use `LEFT JOIN` to join the tables and return the data where `CustomerId` is `NULL`.
