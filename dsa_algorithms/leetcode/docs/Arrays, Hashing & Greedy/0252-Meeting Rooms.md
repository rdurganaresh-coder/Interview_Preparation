# 252. Meeting Rooms

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/meeting-rooms/

---

[中文文档](/solution/0200-0299/0252.Meeting%20Rooms/README.md)

## Description

<p>You are given an array of meeting times&nbsp;<code>intervals</code> where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>.</p>

<p>A person can attend all meetings if no two meeting intervals overlap. Meetings ending at time <code>t</code> and starting at time <code>t</code> <strong>do not</strong> overlap.</p>

<p>​​​​​​​Return <code>true</code> if a person can attend all meetings. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> intervals = [[0,30],[5,10],[15,20]]
<strong>Output:</strong> false
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> intervals = [[7,10],[2,4]]
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>0 &lt;= start<sub>i</sub> &lt;&nbsp;end<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Sorting

> **Thinking**
>
> One person cannot attend two overlapping meetings. After sorting by start time, it is enough that each meeting ends no later than the next one starts.

We sort the meetings based on their start times, and then iterate through the sorted meetings. If the start time of the current meeting is less than the end time of the previous meeting, it indicates that there is an overlap between the two meetings, and we return `false`. Otherwise, we continue iterating.

If no overlap is found by the end of the iteration, we return `true`.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the number of meetings.

#### Java

```java
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}
```
