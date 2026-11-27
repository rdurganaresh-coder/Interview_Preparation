# 3451. Find Invalid IP Addresses

**Difficulty:** Hard  
**Category:** Backtracking  
**LeetCode:** https://leetcode.com/problems/find-invalid-ip-addresses/

---

[中文文档](/solution/3400-3499/3451.Find%20Invalid%20IP%20Addresses/README.md)

## Description

<p>Table: <code> logs</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| log_id      | int     |
| ip          | varchar |
| status_code | int     |
+-------------+---------+
log_id is the unique key for this table.
Each row contains server access log information including IP address and HTTP status code.
</pre>

<p>Write a solution to find <strong>invalid IP addresses</strong>. Each octet in an IP address contains between <code>1</code> and <code>3</code> digits. An IPv4 address is invalid if it meets any of these conditions:</p>

<ul>
	<li>Contains a number <strong>greater than</strong> <code>255</code> in any octet.</li>
	<li>Has <strong>leading zeros</strong> in any octet (for example, <code>01.02.03.04</code>).</li>
	<li>Has <strong>fewer or more</strong> than <code>4</code> octets.</li>
</ul>

<p>Return <em>the result table </em><em>ordered by</em> <code>invalid_count</code>,&nbsp;<code>ip</code>&nbsp;<em>in <strong>descending</strong> order respectively</em>.&nbsp;</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example:</strong></p>

<div class="example-block">
<p><strong>Input:</strong></p>

<p>logs table:</p>

<pre class="example-io">
+--------+---------------+-------------+
| log_id | ip            | status_code | 
+--------+---------------+-------------+
| 1      | 192.168.1.1   | 200         | 
| 2      | 256.1.2.3     | 404         | 
| 3      | 192.168.001.1 | 200         | 
| 4      | 192.168.1.1   | 200         | 
| 5      | 192.168.1     | 500         | 
| 6      | 256.1.2.3     | 404         | 
| 7      | 192.168.001.1 | 200         | 
+--------+---------------+-------------+
</pre>

<p><strong>Output:</strong></p>

<pre class="example-io">
+---------------+--------------+
| ip            | invalid_count|
+---------------+--------------+
| 256.1.2.3     | 2            |
| 192.168.001.1 | 2            |
| 192.168.1     | 1            |
+---------------+--------------+
</pre>

<p><strong>Explanation:</strong></p>

<ul>
	<li>256.1.2.3&nbsp;is invalid because 256 &gt; 255</li>
	<li>192.168.001.1&nbsp;is invalid because of leading zeros</li>
	<li>192.168.1&nbsp;is invalid because it has only 3 octets</li>
</ul>

<p>The output table is ordered by invalid_count, ip in descending order respectively.</p>
</div>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> We count invalid IPv4 addresses in the logs. A valid address has four octets, each a $0..255$ integer with no leading zeros.
>
> A SQL regex can express this, but leading zeros plus ranges are awkward; splitting in Pandas is clearer.
>
> Split on `.`, check that each piece is a digit string in range and equals $\textit{str}(\textit{int})$. Count invalid IPs and sort by count then address, both descending.

We can determine if an IP address is invalid based on the following conditions:

1. The number of `.` in the IP address is not equal to $3$;
2. Any octet in the IP address starts with `0`;
3. Any octet in the IP address is greater than $255$.

Then we group the invalid IP addresses and count the occurrences of each invalid IP address `invalid_count`, and finally sort by `invalid_count` and `ip` in descending order.
