# 1751. Maximum Number of Events That Can Be Attended II

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/

---

[中文文档](/solution/1700-1799/1751.Maximum%20Number%20of%20Events%20That%20Can%20Be%20Attended%20II/README.md)

## Description

<p>You are given an array of <code>events</code> where <code>events[i] = [startDay<sub>i</sub>, endDay<sub>i</sub>, value<sub>i</sub>]</code>. The <code>i<sup>th</sup></code> event starts at <code>startDay<sub>i</sub></code><sub> </sub>and ends at <code>endDay<sub>i</sub></code>, and if you attend this event, you will receive a value of <code>value<sub>i</sub></code>. You are also given an integer <code>k</code> which represents the maximum number of events you can attend.</p>

<p>You can only attend one event at a time. If you choose to attend an event, you must attend the <strong>entire</strong> event. Note that the end day is <strong>inclusive</strong>: that is, you cannot attend two events where one of them starts and the other ends on the same day.</p>

<p>Return <em>the <strong>maximum sum</strong> of values that you can receive by attending events.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1700-1799/1751.Maximum%20Number%20of%20Events%20That%20Can%20Be%20Attended%20II/images/screenshot-2021-01-11-at-60048-pm.png" style="width: 400px; height: 103px;" /></p>

<pre>
<strong>Input:</strong> events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
<strong>Output:</strong> 7
<strong>Explanation: </strong>Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1700-1799/1751.Maximum%20Number%20of%20Events%20That%20Can%20Be%20Attended%20II/images/screenshot-2021-01-11-at-60150-pm.png" style="width: 400px; height: 103px;" /></p>

<pre>
<strong>Input:</strong> events = [[1,2,4],[3,4,3],[2,3,10]], k = 2
<strong>Output:</strong> 10
<strong>Explanation:</strong> Choose event 2 for a total value of 10.
Notice that you cannot attend any other event as they overlap, and that you do <strong>not</strong> have to attend k events.</pre>

<p><strong class="example">Example 3:</strong></p>

<p><strong><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1700-1799/1751.Maximum%20Number%20of%20Events%20That%20Can%20Be%20Attended%20II/images/screenshot-2021-01-11-at-60703-pm.png" style="width: 400px; height: 126px;" /></strong></p>

<pre>
<strong>Input:</strong> events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3
<strong>Output:</strong> 9
<strong>Explanation:</strong> Although the events do not overlap, you can only attend 3 events. Pick the highest valued three.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= events.length</code></li>
	<li><code>1 &lt;= k * events.length &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= startDay<sub>i</sub> &lt;= endDay<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= value<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Memoization + Binary Search

> **Thinking**
>
> Attend at most $k$ non-overlapping events for maximum total value. After sorting by start time, we take or skip the current event and binary-search the next feasible one.
>
> $\textit{dfs}(i,k)$ is the best from event $i$ with $k$ slots left. Skipping goes to $i+1$; taking binary-searches the first start after this end and adds the value. Memoize the states.

First, we sort the events by their start time in ascending order. Then, we define a function $\textit{dfs}(i, k)$, which represents the maximum total value achievable by attending at most $k$ events starting from the $i$-th event. The answer is $\textit{dfs}(0, k)$.

The calculation process of the function $\textit{dfs}(i, k)$ is as follows:

If we do not attend the $i$-th event, the maximum value is $\textit{dfs}(i + 1, k)$. If we attend the $i$-th event, we can use binary search to find the first event whose start time is greater than the end time of the $i$-th event, denoted as $j$. Then, the maximum value is $\textit{dfs}(j, k - 1) + \textit{value}[i]$. We take the maximum of the two options:

$$
\textit{dfs}(i, k) = \max(\textit{dfs}(i + 1, k), \textit{dfs}(j, k - 1) + \textit{value}[i])
$$

Here, $j$ is the index of the first event whose start time is greater than the end time of the $i$-th event, which can be found using binary search.

Since the calculation of $\textit{dfs}(i, k)$ involves calls to $\textit{dfs}(i + 1, k)$ and $\textit{dfs}(j, k - 1)$, we can use memoization to store the computed values and avoid redundant calculations.

The time complexity is $O(n \log n + nk)$, and the space complexity is $O(nk)$, where $n$ is the number of events.

#### Java

```java
class Solution {
    private int[][] events;
    private int[][] f;
    private int n;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        this.events = events;
        n = events.length;
        f = new int[n][k + 1];
        return dfs(0, k);
    }

    private int dfs(int i, int k) {
        if (i >= n || k <= 0) {
            return 0;
        }
        if (f[i][k] != 0) {
            return f[i][k];
        }
        int j = search(events, events[i][1], i + 1);
        int ans = Math.max(dfs(i + 1, k), dfs(j, k - 1) + events[i][2]);
        return f[i][k] = ans;
    }

    private int search(int[][] events, int x, int lo) {
        int l = lo, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (events[mid][0] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```

### Solution 2: Dynamic Programming + Binary Search

> **Thinking**
>
> Solution 1 sorts by start and fills a suffix table. Sorting by end instead, $f[i][j]$ is the best using the first $i$ events and $j$ slots, binary-searching the last non-conflicting event.

Solution 1 sorts by start and fills a suffix table. Here we sort by end and define a prefix table.

First, sort the events, this time by end time in ascending order. Then define $f[i][j]$ as the maximum total value by attending at most $j$ events among the first $i$ events. The answer is $f[n][k]$.

For the $i$-th event, we can choose to attend it or not. If we do not attend, the maximum value is $f[i][j]$. If we attend, we can use binary search to find the last event whose end time is less than the start time of the $i$-th event, denoted as $h$. Then the maximum value is $f[h + 1][j - 1] + \textit{value}[i]$. We take the maximum of the two options:

$$
f[i + 1][j] = \max(f[i][j], f[h + 1][j - 1] + \textit{value}[i])
$$

Here, $h$ is the last event whose end time is less than the start time of the $i$-th event, which can be found by binary search.

The time complexity is $O(n \log n + nk)$, and the space complexity is $O(nk)$, where $n$ is the number of events.

Related problems:

- [1235. Maximum Profit in Job Scheduling](https://github.com/doocs/leetcode/blob/main/solution/1200-1299/1235.Maximum%20Profit%20in%20Job%20Scheduling/README_EN.md)
- [2008. Maximum Earnings From Taxi](https://github.com/doocs/leetcode/blob/main/solution/2000-2099/2008.Maximum%20Earnings%20From%20Taxi/README_EN.md)

#### Java

```java
class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= n; ++i) {
            int st = events[i - 1][0], val = events[i - 1][2];
            int p = search(events, st, i - 1);
            for (int j = 1; j <= k; ++j) {
                f[i][j] = Math.max(f[i - 1][j], f[p][j - 1] + val);
            }
        }
        return f[n][k];
    }

    private int search(int[][] events, int x, int hi) {
        int l = 0, r = hi;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (events[mid][1] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```

### Solution 3: Dynamic Programming + Binary Search

> **Thinking**
>
> Attend at most $k$ non-overlapping events for maximum total value. $k \times n \le 10^6$, so $n$ itself can be $10^6$ and listing subsets is impossible.
>
> After sorting by start, skipping calls $i+1$ with the same remaining slots before it returns, so the chain has length $n$ and overflows the stack.
>
> Later events and a smaller slot count are known if we walk backward. Let $f[i][c]$ be the best value from event $i$ with $c$ slots left, and fill $i$ from $n-1$ down to $0$.

First, we sort the events by their start time in ascending order. Let $f[i][c]$ be the maximum total value achievable by attending at most $c$ events starting from the $i$-th event. The answer is $f[0][k]$, and $f[n][c] = 0$.

Fill $i$ from $n - 1$ down to $0$. If we do not attend the $i$-th event, the maximum value is $f[i + 1][c]$. If $c > 0$ and we attend it, binary search finds the first event $j$ whose start time is greater than the end time of the $i$-th event. The value is then $f[j][c - 1] + \textit{value}[i]$. Take the larger of the two:

$$
f[i][c] = \max(f[i + 1][c], f[j][c - 1] + \textit{value}[i])
$$

Here, $j$ is the index of the first event whose start time is greater than the end time of the $i$-th event. Because $j > i$, $f[j]$ is already filled.

The time complexity is $O(n \log n + nk)$, and the space complexity is $O(nk)$, where $n$ is the number of events.

#### Java

```java
class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[][] f = new int[n + 1][k + 1];
        for (int i = n - 1; i >= 0; --i) {
            int ed = events[i][1], val = events[i][2];
            int j = search(events, ed, i + 1);
            for (int c = 0; c <= k; ++c) {
                f[i][c] = f[i + 1][c];
                if (c > 0) {
                    f[i][c] = Math.max(f[i][c], f[j][c - 1] + val);
                }
            }
        }
        return f[0][k];
    }

    private int search(int[][] events, int x, int lo) {
        int l = lo, r = events.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (events[mid][0] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```
