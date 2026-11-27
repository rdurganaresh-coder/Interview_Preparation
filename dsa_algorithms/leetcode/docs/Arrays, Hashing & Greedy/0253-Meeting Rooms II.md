# 253. Meeting Rooms II

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/meeting-rooms-ii/

---

[中文文档](/solution/0200-0299/0253.Meeting%20Rooms%20II/README.md)

## Description

<p>Given an array of meeting time intervals <code>intervals</code> where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, return <em>the minimum number of conference rooms required</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> intervals = [[0,30],[5,10],[15,20]]
<strong>Output:</strong> 2
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> intervals = [[7,10],[2,4]]
<strong>Output:</strong> 1
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;intervals.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Difference Array

> **Thinking**
>
> The number of rooms is the peak number of meetings underway. Add $1$ at each start and $-1$ at each end; the prefix sum is the occupancy.
>
> A difference array up to the latest end time, then one scan, yields that peak.

We can implement this using a difference array.

First, we find the maximum end time of all the meetings, denoted as $m$. Then, we create a difference array $d$ of length $m + 1$. For each meeting, we add to the corresponding positions in the difference array: $d[l] = d[l] + 1$ for the start time, and $d[r] = d[r] - 1$ for the end time.

Next, we calculate the prefix sum of the difference array and find the maximum value of the prefix sum, which represents the minimum number of meeting rooms required.

The time complexity is $O(n + m)$, and the space complexity is $O(m)$, where $n$ is the number of meetings and $m$ is the maximum end time.

#### Java

```java
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int m = 0;
        for (var e : intervals) {
            m = Math.max(m, e[1]);
        }
        int[] d = new int[m + 1];
        for (var e : intervals) {
            ++d[e[0]];
            --d[e[1]];
        }
        int ans = 0, s = 0;
        for (int v : d) {
            s += v;
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
```

### Solution 2: Difference (Hash Map)

> **Thinking**
>
> A large time horizon wastes an $O(m)$ array. A hash map stores updates only at endpoints; sorting the keys and taking a prefix-sum peak is equivalent.

If the meeting times span a large range, we can use a hash map instead of a difference array.

First, we create a hash map $d$, where we add to the corresponding positions for each meeting's start time and end time: $d[l] = d[l] + 1$ for the start time, and $d[r] = d[r] - 1$ for the end time.

Then, we sort the hash map by its keys, calculate the prefix sum of the hash map, and find the maximum value of the prefix sum, which represents the minimum number of meeting rooms required.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the number of meetings.

#### Java

```java
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> d = new TreeMap<>();
        for (var e : intervals) {
            d.merge(e[0], 1, Integer::sum);
            d.merge(e[1], -1, Integer::sum);
        }
        int ans = 0, s = 0;
        for (var e : d.values()) {
            s += e;
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
```
