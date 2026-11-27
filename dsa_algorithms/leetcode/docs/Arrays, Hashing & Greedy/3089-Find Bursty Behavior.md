# 3089. Find Bursty Behavior

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-bursty-behavior/

---

[中文文档](/solution/3000-3099/3089.Find%20Bursty%20Behavior/README.md)

## Description

<p>Table: <code>Posts</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| post_id     | int     |
| user_id     | int     |
| post_date   | date    |
+-------------+---------+
post_id is the primary key (column with unique values) for this table.
Each row of this table contains post_id, user_id, and post_date.
</pre>

<p>Write a solution to find users who demonstrate <strong>bursty behavior</strong> in their posting patterns during February <code>2024</code>. <strong>Bursty behavior</strong> is defined as <strong>any</strong> period of <strong>7</strong> <strong>consecutive</strong> days where a user&#39;s posting frequency is <strong>at least twice</strong> to their <strong>average</strong> weekly posting frequency for February <code>2024</code>.</p>

<p><strong>Note:</strong> Only include the dates from February <code>1</code> to February <code>28</code> in your analysis, which means you should count February as having exactly <code>4</code> weeks.</p>

<p>Return <em>the result table orderd by </em><code>user_id</code><em> in </em><strong>ascending</strong><em> order.</em></p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example:</strong></p>

<div class="example-block">
<p><strong>Input:</strong></p>

<p>Posts table:</p>

<pre class="example-io">
+---------+---------+------------+
| post_id | user_id | post_date  |
+---------+---------+------------+
| 1       | 1       | 2024-02-27 |
| 2       | 5       | 2024-02-06 |
| 3       | 3       | 2024-02-25 |
| 4       | 3       | 2024-02-14 |
| 5       | 3       | 2024-02-06 |
| 6       | 2       | 2024-02-25 |
+---------+---------+------------+
</pre>

<p><strong>Output:</strong></p>

<pre class="example-io">
+---------+----------------+------------------+
| user_id | max_7day_posts | avg_weekly_posts |
+---------+----------------+------------------+
| 1       | 1              | 0.2500           |
| 2       | 1              | 0.2500           |
| 5       | 1              | 0.2500           |
+---------+----------------+------------------+
</pre>

<p><strong>Explanation:</strong></p>

<ul>
	<li><strong>User 1:</strong> Made only 1 post in February, resulting in an average of 0.25 posts per week and a max of 1 post in any 7-day period.</li>
	<li><strong>User 2:</strong> Also made just 1 post, with the same average and max 7-day posting frequency as User 1.</li>
	<li><strong>User 5:</strong> Like Users 1 and 2, User 5 made only 1 post throughout February, leading to the same average and max 7-day posting metrics.</li>
	<li><strong>User 3:</strong> Although User 3 made more posts than the others (3 posts), they did not reach twice the average weekly posts in their consecutive 7-day window, so they are not listed in the output.</li>
</ul>

<p><b>Note:</b> Output table is ordered by user_id in ascending order.</p>
</div>

## Solutions

### Solution 1: Self-Join + Group Count

> **Thinking**
>
> A burst means some $7$-day window has at least twice the user’s average weekly posts in February $2024$. Both figures come from the same post table.
>
> A self-join on user with dates in $[d,d+6]$ counts each window; February posts divided by $4$ is the weekly average. We join them and keep the maximum window.
>
> The code builds the dated self-join, computes the February average, inner-joins, filters by the threshold, and aggregates.

We can use self-join to connect the `Posts` table with itself. The connection condition is `p1.user_id = p2.user_id` and `p2.post_date` is between `p1.post_date` and 6 days after `p1.post_date`. Then we group the connection results by `p1.user_id` and `p1.post_id` to count the number of posts for each user within 7 days of each day. We save this result in table `P`.

Next, we count the average number of posts per week for each user in February 2024 and save it in table `T`. Note that we need to find records where `post_date` is between `2024-02-01` and `2024-02-28`, group the records by `user_id`, then count the number of posts for each user, and finally divide by `4` to get the average number of posts per week. We save this result in table `T`.

Finally, we connect tables `P` and `T` with the condition `P.user_id = T.user_id`, then group by `user_id` to count the maximum number of posts within 7 days for each user. We then filter out records that meet the condition `max_7day_posts >= avg_weekly_posts * 2` to get the result. Note that we need to sort in ascending order by `user_id`.
