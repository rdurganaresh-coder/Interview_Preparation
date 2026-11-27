# 3220. Odd and Even Transactions

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/odd-and-even-transactions/

---

[中文文档](/solution/3200-3299/3220.Odd%20and%20Even%20Transactions/README.md)

## Description

<p>Table: <code>transactions</code></p>

<pre>
+------------------+------+
| Column Name      | Type | 
+------------------+------+
| transaction_id   | int  |
| amount           | int  |
| transaction_date | date |
+------------------+------+
The transactions_id column uniquely identifies each row in this table.
Each row of this table contains the transaction id, amount and transaction date.
</pre>

<p>Write a solution to find the <strong>sum of amounts</strong> for <strong>odd</strong> and <strong>even</strong> transactions for each day. If there are no odd or even transactions for a specific date, display as <code>0</code>.</p>

<p>Return <em>the result table ordered by</em> <code>transaction_date</code> <em>in <strong>ascending</strong> order</em>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example:</strong></p>

<div class="example-block">
<p><strong>Input:</strong></p>

<p><code>transactions</code> table:</p>

<pre class="example-io">
+----------------+--------+------------------+
| transaction_id | amount | transaction_date |
+----------------+--------+------------------+
| 1              | 150    | 2024-07-01       |
| 2              | 200    | 2024-07-01       |
| 3              | 75     | 2024-07-01       |
| 4              | 300    | 2024-07-02       |
| 5              | 50     | 2024-07-02       |
| 6              | 120    | 2024-07-03       |
+----------------+--------+------------------+
  </pre>

<p><strong>Output:</strong></p>

<pre class="example-io">
+------------------+---------+----------+
| transaction_date | odd_sum | even_sum |
+------------------+---------+----------+
| 2024-07-01       | 75      | 350      |
| 2024-07-02       | 0       | 350      |
| 2024-07-03       | 0       | 120      |
+------------------+---------+----------+
  </pre>

<p><strong>Explanation:</strong></p>

<ul>
	<li>For transaction dates:
	<ul>
		<li>2024-07-01:
		<ul>
			<li>Sum of amounts for odd transactions: 75</li>
			<li>Sum of amounts for even transactions: 150 + 200 = 350</li>
		</ul>
		</li>
		<li>2024-07-02:
		<ul>
			<li>Sum of amounts for odd transactions: 0</li>
			<li>Sum of amounts for even transactions: 300 + 50 = 350</li>
		</ul>
		</li>
		<li>2024-07-03:
		<ul>
			<li>Sum of amounts for odd transactions: 0</li>
			<li>Sum of amounts for even transactions: 120</li>
		</ul>
		</li>
	</ul>
	</li>
</ul>

<p><strong>Note:</strong> The output table is ordered by <code>transaction_date</code> in ascending order.</p>
</div>

## Solutions

### Solution 1: Grouping and Summing

> **Thinking**
>
> We need daily sums of odd and even amounts. A per-day loop would work, but splitting parity into two columns and grouping is cleaner.
>
> Keep `amount` when it is odd or even and write $0$ otherwise, then sum by `transaction_date` and sort ascending. Parity is decided per row; one aggregation finishes the query.

We can group the data by `transaction_date`, and then calculate the sum of transaction amounts for odd and even dates separately. Finally, sort by `transaction_date` in ascending order.
