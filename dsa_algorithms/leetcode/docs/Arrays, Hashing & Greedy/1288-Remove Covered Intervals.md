# 1288. Remove Covered Intervals

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/remove-covered-intervals/

---

[中文文档](/solution/1200-1299/1288.Remove%20Covered%20Intervals/README.md)

## Description

<p>Given an array <code>intervals</code> where <code>intervals[i] = [l<sub>i</sub>, r<sub>i</sub>]</code> represent the interval <code>[l<sub>i</sub>, r<sub>i</sub>)</code>, remove all intervals that are covered by another interval in the list.</p>

<p>The interval <code>[a, b)</code> is covered by the interval <code>[c, d)</code> if and only if <code>c &lt;= a</code> and <code>b &lt;= d</code>.</p>

<p>Return <em>the number of remaining intervals</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> intervals = [[1,4],[3,6],[2,8]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> Interval [3,6] is covered by [2,8], therefore it is removed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> intervals = [[1,4],[2,3]]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 1000</code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>0 &lt;= l<sub>i</sub> &lt; r<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
	<li>All the given intervals are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1: Sorting

> **Thinking**
>
> We drop intervals covered by another. Sorting by rising left end and, on ties, falling right end, an earlier interval cannot be covered by a later narrower one. We keep the largest right end seen: a strictly larger current right end is not covered. Sorting reduces 2-D containment to a 1-D right-end test.

We can sort the intervals in ascending order by their left endpoints, and if the left endpoints are the same, sort them in descending order by their right endpoints.

After sorting, we can traverse the intervals. If the right endpoint of the current interval is greater than the previous right endpoint, it means the current interval is not covered, and we increment the answer by one.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the number of intervals.

#### Java

```java
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int ans = 0, pre = Integer.MIN_VALUE;
        for (var e : intervals) {
            int cur = e[1];
            if (cur > pre) {
                ++ans;
                pre = cur;
            }
        }
        return ans;
    }
}
```
