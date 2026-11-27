# 56. Merge Intervals

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/merge-intervals/

---

[中文文档](/solution/0000-0099/0056.Merge%20Intervals/README.md)

## Description

<p>Given an array&nbsp;of <code>intervals</code>&nbsp;where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, merge all overlapping intervals, and return <em>an array of the non-overlapping intervals that cover all the intervals in the input</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> intervals = [[1,3],[2,6],[8,10],[15,18]]
<strong>Output:</strong> [[1,6],[8,10],[15,18]]
<strong>Explanation:</strong> Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> intervals = [[1,4],[4,5]]
<strong>Output:</strong> [[1,5]]
<strong>Explanation:</strong> Intervals [1,4] and [4,5] are considered overlapping.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> intervals = [[4,7],[1,4]]
<strong>Output:</strong> [[1,7]]
<strong>Explanation:</strong> Intervals [1,4] and [4,7] are considered overlapping.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Sorting + One-pass Traversal

> **Thinking**
>
> The first idea is to pick an interval and scan the rest for overlaps, merging until nothing changes. Correct, but worst-case $O(n^2)$ with a messy merge order. $n \le 10^4$ is tight.
>
> The waste is locating overlaps in unsorted input. After sorting by left endpoint, an interval can overlap only the interval we have not closed yet—later starts are larger, so they cannot skip over the middle and overlap again.
>
> So we sort, then scan once, keeping $st, ed$ as the interval under merge.

We can sort the intervals in ascending order by the left endpoint, and then traverse the intervals for merging operations.

The specific merging operation is as follows.

First, we add the first interval to the answer. Then, we consider each subsequent interval in turn:

- If the right endpoint of the last interval in the answer array is less than the left endpoint of the current interval, it means that the two intervals will not overlap, so we can directly add the current interval to the end of the answer array;
- Otherwise, it means that the two intervals overlap. We need to use the right endpoint of the current interval to update the right endpoint of the last interval in the answer array, setting it to the larger of the two.

Finally, we return the answer array.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the number of intervals.

#### Java

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int st = intervals[0][0], ed = intervals[0][1];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < intervals.length; ++i) {
            int s = intervals[i][0], e = intervals[i][1];
            if (ed < s) {
                ans.add(new int[] {st, ed});
                st = s;
                ed = e;
            } else {
                ed = Math.max(ed, e);
            }
        }
        ans.add(new int[] {st, ed});
        return ans.toArray(new int[ans.size()][]);
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 is already $O(n \log n)$ and correct. It still keeps a separate $st, ed$, writes only when the interval closes, and appends once more at the end.
>
> What it lacks is storing the current interval in the answer: put the first interval into $\textit{ans}$ immediately, then either extend $\textit{ans}[-1]$'s right end or append. Fewer variables, no final flush.

#### Java

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int s = intervals[i][0], e = intervals[i][1];
            if (ans.get(ans.size() - 1)[1] < s) {
                ans.add(intervals[i]);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], e);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
```

### Solution 3

> **Thinking**
>
> Solution 2 already mutates the last interval in the answer. The loop is still "look at one, patch if needed."
>
> What it lacks is merging by groups: fix left $l$, eat every overlapping interval in an inner loop while stretching $r$, then push $[l, r]$ once. Already-written answers are never rewritten.
