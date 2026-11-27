# 2238. Number of Times a Driver Was a Passenger

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/number-of-times-a-driver-was-a-passenger/

---

[中文文档](/solution/2200-2299/2238.Number%20of%20Times%20a%20Driver%20Was%20a%20Passenger/README.md)

## Description

<p>Table: <code>Rides</code></p>

<pre>
+--------------+------+
| Column Name  | Type |
+--------------+------+
| ride_id      | int  |
| driver_id    | int  |
| passenger_id | int  |
+--------------+------+
ride_id is the column with unique values for this table.
Each row of this table contains the ID of the driver and the ID of the passenger that rode in ride_id.
Note that driver_id != passenger_id.
</pre>

<p>&nbsp;</p>

<p>Write a solution&nbsp;to report the ID of each driver and the number of times they were a passenger.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Rides table:
+---------+-----------+--------------+
| ride_id | driver_id | passenger_id |
+---------+-----------+--------------+
| 1       | 7         | 1            |
| 2       | 7         | 2            |
| 3       | 11        | 1            |
| 4       | 11        | 7            |
| 5       | 11        | 7            |
| 6       | 11        | 3            |
+---------+-----------+--------------+
<strong>Output:</strong> 
+-----------+-----+
| driver_id | cnt |
+-----------+-----+
| 7         | 2   |
| 11        | 0   |
+-----------+-----+
<strong>Explanation:</strong> 
There are two drivers in all the given rides: 7 and 11.
The driver with ID = 7 was a passenger two times.
The driver with ID = 11 was never a passenger.
</pre>

## Solutions

### Solution 1

> **Thinking**
>
> For every driver that appears, count how many times that person rode as a passenger; the count is $0$ if they never did. Grouping $\textit{Rides}$ by passenger would drop people who only drove.
>
> Take distinct $\textit{driver\_id}$ values and left-join $\textit{Rides}$ on $\textit{driver\_id} = \textit{passenger\_id}$. Counting $\textit{passenger\_id}$ keeps the zeros.
