# 2589. Minimum Time to Complete All Tasks

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/minimum-time-to-complete-all-tasks/

---

[中文文档](/solution/2500-2599/2589.Minimum%20Time%20to%20Complete%20All%20Tasks/README.md)

## Description

<p>There is a computer that can run an unlimited number of tasks <strong>at the same time</strong>. You are given a 2D integer array <code>tasks</code> where <code>tasks[i] = [start<sub>i</sub>, end<sub>i</sub>, duration<sub>i</sub>]</code> indicates that the <code>i<sup>th</sup></code> task should run for a total of <code>duration<sub>i</sub></code> seconds (not necessarily continuous) within the <strong>inclusive</strong> time range <code>[start<sub>i</sub>, end<sub>i</sub>]</code>.</p>

<p>You may turn on the computer only when it needs to run a task. You can also turn it off if it is idle.</p>

<p>Return <em>the minimum time during which the computer should be turned on to complete all tasks</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> tasks = [[2,3,1],[4,5,1],[1,5,2]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 
- The first task can be run in the inclusive time range [2, 2].
- The second task can be run in the inclusive time range [5, 5].
- The third task can be run in the two inclusive time ranges [2, 2] and [5, 5].
The computer will be on for a total of 2 seconds.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> tasks = [[1,3,2],[2,5,3],[5,6,2]]
<strong>Output:</strong> 4
<strong>Explanation:</strong> 
- The first task can be run in the inclusive time range [2, 3].
- The second task can be run in the inclusive time ranges [2, 3] and [5, 5].
- The third task can be run in the two inclusive time range [5, 6].
The computer will be on for a total of 4 seconds.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= tasks.length &lt;= 2000</code></li>
	<li><code>tasks[i].length == 3</code></li>
	<li><code>1 &lt;= start<sub>i</sub>, end<sub>i</sub> &lt;= 2000</code></li>
	<li><code>1 &lt;= duration<sub>i</sub> &lt;= end<sub>i</sub> - start<sub>i</sub> + 1 </code></li>
</ul>

## Solutions

### Solution 1: Greedy + Sorting

> **Thinking**
>
> Each task needs $\textit{duration}$ integer times inside its closed interval, and the computer runs one task at a time. The timeline is only $2000$ long, but the assignments are many.
>
> Sort by end time and occupy the rightmost still-free instants, which later tasks are more likely to reuse. Subtract already taken points in the interval, then fill the remainder from the right.

We observe that the problem is equivalent to selecting $\textit{duration}$ integer time points in each interval $[\textit{start},..,\textit{end}]$, so that the total number of selected integer time points is minimized.

Therefore, we can first sort $\textit{tasks}$ in ascending order of end time $\textit{end}$. Then we greedily make selections. For each task, we start from the end time $\textit{end}$ and choose the points as late as possible from back to front. This way, these points are more likely to be reused by later tasks.

In our implementation, we can use an array $\textit{vis}$ of length $2010$ to record whether each time point has been selected. Then for each task, we first count the number of points $\textit{cnt}$ that have been selected in the interval $[\textit{start},..,\textit{end}]$, and then select $\textit{duration} - \textit{cnt}$ points from back to front, while recording the number of selected points $\textit{ans}$ and updating the $\textit{vis}$ array.

Finally, we return $\textit{ans}$.

The time complexity is $O(n \log n + nm)$, and the space complexity is $O(m)$, where $n$ and $m$ are the lengths of $\textit{tasks}$ and $\textit{vis}$ array, respectively. In this problem, $m = 2010$.

#### Java

```java
class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - b[1]);
        int[] vis = new int[2010];
        int ans = 0;
        for (var task : tasks) {
            int start = task[0], end = task[1], duration = task[2];
            for (int i = start; i <= end; ++i) {
                duration -= vis[i];
            }
            for (int i = end; i >= start && duration > 0; --i) {
                if (vis[i] == 0) {
                    --duration;
                    ans += vis[i] = 1;
                }
            }
        }
        return ans;
    }
}
```
