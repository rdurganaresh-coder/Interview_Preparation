# 2084. Drop Type 1 Orders for Customers With Type 0 Orders

**Difficulty:** Medium  
**Category:** SQL & Database  
**LeetCode:** https://leetcode.com/problems/drop-type-1-orders-for-customers-with-type-0-orders/

---

[中文文档](/solution/2000-2099/2084.Drop%20Type%201%20Orders%20for%20Customers%20With%20Type%200%20Orders/README.md)

## Description

<p>Table: <code>Orders</code></p>

<pre>
+-------------+------+
| Column Name | Type |
+-------------+------+
| order_id    | int  | 
| customer_id | int  |
| order_type  | int  | 
+-------------+------+
order_id is the column with unique values for this table.
Each row of this table indicates the ID of an order, the ID of the customer who ordered it, and the order type.
The orders could be of type 0 or type 1.
</pre>

<p>&nbsp;</p>

<p>Write a solution to report all the orders based on the following criteria:</p>

<ul>
	<li>If a customer has <strong>at least one</strong> order of type <code>0</code>, do <strong>not</strong> report any order of type <code>1</code> from that customer.</li>
	<li>Otherwise, report all the orders of the customer.</li>
</ul>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong>
Orders table:
+----------+-------------+------------+
| order_id | customer_id | order_type |
+----------+-------------+------------+
| 1        | 1           | 0          |
| 2        | 1           | 0          |
| 11       | 2           | 0          |
| 12       | 2           | 1          |
| 21       | 3           | 1          |
| 22       | 3           | 0          |
| 31       | 4           | 1          |
| 32       | 4           | 1          |
+----------+-------------+------------+
<strong>Output:</strong>
+----------+-------------+------------+
| order_id | customer_id | order_type |
+----------+-------------+------------+
| 31       | 4           | 1          |
| 32       | 4           | 1          |
| 1        | 1           | 0          |
| 2        | 1           | 0          |
| 11       | 2           | 0          |
| 22       | 3           | 0          |
+----------+-------------+------------+
<strong>Explanation:</strong>
Customer 1 has two orders of type 0. We return both of them.
Customer 2 has one order of type 0 and one order of type 1. We only return the order of type 0.
Customer 3 has one order of type 0 and one order of type 1. We only return the order of type 0.
Customer 4 has two orders of type 1. We return both of them.

</pre>

## Solutions

### Solution 1

> **Thinking**
>
> Customers who have a type-0 order must drop all type-1 rows; everyone else keeps theirs. Compute the set of customers with a type-0 order, then keep a row if it is type 0 or its customer is outside that set.
>
> A CTE plus `NOT EXISTS` encodes the filter.

### Solution 2

> **Thinking**
>
> Solution 1 uses a subquery. Self-join different types of the same customer: a type-1 row that matches a type-0 should drop. Keep rows with no mixed-type partner, or whose partner is type 1 (so the row itself is type 0), then distinct.
>
> Same result via `LEFT JOIN`.
