# 1164. Product Price at a Given Date

**Difficulty:** Medium  
**Category:** SQL & Database  
**LeetCode:** https://leetcode.com/problems/product-price-at-a-given-date/

---

[中文文档](/solution/1100-1199/1164.Product%20Price%20at%20a%20Given%20Date/README.md)

## Description

<p>Table: <code>Products</code></p>

<pre>
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| product_id    | int     |
| new_price     | int     |
| change_date   | date    |
+---------------+---------+
(product_id, change_date) is the primary key (combination of columns with unique values) of this table.
Each row of this table indicates that the price of some product was changed to a new price at some date.</pre>

<p>Initially, all products have price 10.</p>

<p>Write a solution to find the prices of all products on the date <code>2019-08-16</code>.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Products table:
+------------+-----------+-------------+
| product_id | new_price | change_date |
+------------+-----------+-------------+
| 1          | 20        | 2019-08-14  |
| 2          | 50        | 2019-08-14  |
| 1          | 30        | 2019-08-15  |
| 1          | 35        | 2019-08-16  |
| 2          | 65        | 2019-08-17  |
| 3          | 20        | 2019-08-18  |
+------------+-----------+-------------+
<strong>Output:</strong> 
+------------+-------+
| product_id | price |
+------------+-------+
| 2          | 50    |
| 1          | 35    |
| 3          | 10    |
+------------+-------+
</pre>

## Solutions

### Solution 1: Subquery + Join

> **Thinking**
>
> Each product keeps the last price change on or before $2019$-$08$-$16$, or $10$ if none. A subquery takes `MAX(change_date)` in that window per product and joins back for the price. The distinct product list left-joins that result so missing prices become $10$.

We can use a subquery to find the price of the last price change for each product before the given date, and record it in the `P` table. Then, we can find all `product_id`s in the `T` table. Finally, we can left join the `T` table with the `P` table on `product_id` to get the final result.

### Solution 2

> **Thinking**
>
> Method 1 finds the last change with an aggregate subquery. Method 2 left-joins in-range changes and `RANK`s them by `change_date` descending, keeping $rk=1$. Rows with no change still rank $1$, and `IFNULL` fills $10$.
