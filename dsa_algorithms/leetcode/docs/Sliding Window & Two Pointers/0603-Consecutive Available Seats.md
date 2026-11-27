# 603. Consecutive Available Seats

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/consecutive-available-seats/

---

[中文文档](/solution/0600-0699/0603.Consecutive%20Available%20Seats/README.md)

## Description

<p>Table: <code>Cinema</code></p>

<pre>
+-------------+------+
| Column Name | Type |
+-------------+------+
| seat_id     | int  |
| free        | bool |
+-------------+------+
seat_id is an auto-increment column for this table.
Each row of this table indicates whether the i<sup>th</sup> seat is free or not. 1 means free while 0 means occupied.
</pre>

<p>&nbsp;</p>

<p>Find all the consecutive available seats in the cinema.</p>

<p>Return the result table <strong>ordered</strong> by <code>seat_id</code> <strong>in ascending order</strong>.</p>

<p>The test cases are generated so that more than two seats are consecutively available.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Cinema table:
+---------+------+
| seat_id | free |
+---------+------+
| 1       | 1    |
| 2       | 0    |
| 3       | 1    |
| 4       | 1    |
| 5       | 1    |
+---------+------+
<strong>Output:</strong> 
+---------+
| seat_id |
+---------+
| 3       |
| 4       |
| 5       |
+---------+
</pre>

## Solutions

### Solution 1: Self-Join

> **Thinking**
>
> A free seat counts only if it has a neighboring free seat. A correlated lookup of neighbors repeats the same probes.
>
> Self-join seats whose ids differ by $1$ and are both free; distinct ids in that join are the answer.

We can use a self-join to join the `Seat` table with itself, and then filter out the records where the `id` of the left seat is equal to the `id` of the right seat minus $1$, and where both seats are empty.

### Solution 2: Window Function

> **Thinking**
>
> The self-join materializes pairs. `LAG`/`LEAD` read the neighboring `free` flags on the same row; if the seat plus either neighbor sums to $2$, it belongs to a consecutive free pair.

We can use the `LAG` and `LEAD` functions (or `SUM() OVER(ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING)`) to obtain the information of adjacent seats, and then filter out the consecutive empty seats and sort them in a unique way.

### Solution 3

> **Thinking**
>
> A single sliding `SUM(free)` over the previous, current, and next rows replaces separate `LAG`/`LEAD`. A free seat with window sum greater than $1$ has at least one free neighbor.
