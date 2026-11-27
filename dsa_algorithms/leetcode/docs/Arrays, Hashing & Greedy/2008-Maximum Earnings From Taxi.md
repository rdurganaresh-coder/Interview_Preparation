# 2008. Maximum Earnings From Taxi

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-earnings-from-taxi/

---

[中文文档](/solution/2000-2099/2008.Maximum%20Earnings%20From%20Taxi/README.md)

## Description

<p>There are <code>n</code> points on a road you are driving your taxi on. The <code>n</code> points on the road are labeled from <code>1</code> to <code>n</code> in the direction you are going, and you want to drive from point <code>1</code> to point <code>n</code> to make money by picking up passengers. You cannot change the direction of the taxi.</p>

<p>The passengers are represented by a <strong>0-indexed</strong> 2D integer array <code>rides</code>, where <code>rides[i] = [start<sub>i</sub>, end<sub>i</sub>, tip<sub>i</sub>]</code> denotes the <code>i<sup>th</sup></code> passenger requesting a ride from point <code>start<sub>i</sub></code> to point <code>end<sub>i</sub></code> who is willing to give a <code>tip<sub>i</sub></code> dollar tip.</p>

<p>For<strong> each </strong>passenger <code>i</code> you pick up, you <strong>earn</strong> <code>end<sub>i</sub> - start<sub>i</sub> + tip<sub>i</sub></code> dollars. You may only drive <b>at most one </b>passenger at a time.</p>

<p>Given <code>n</code> and <code>rides</code>, return <em>the <strong>maximum</strong> number of dollars you can earn by picking up the passengers optimally.</em></p>

<p><strong>Note:</strong> You may drop off a passenger and pick up a different passenger at the same point.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 5, rides = [<u>[2,5,4]</u>,[1,5,1]]
<strong>Output:</strong> 7
<strong>Explanation:</strong> We can pick up passenger 0 to earn 5 - 2 + 4 = 7 dollars.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 20, rides = [[1,6,1],<u>[3,10,2]</u>,<u>[10,12,3]</u>,[11,12,2],[12,15,2],<u>[13,18,1]</u>]
<strong>Output:</strong> 20
<strong>Explanation:</strong> We will pick up the following passengers:
- Drive passenger 1 from point 3 to point 10 for a profit of 10 - 3 + 2 = 9 dollars.
- Drive passenger 2 from point 10 to point 12 for a profit of 12 - 10 + 3 = 5 dollars.
- Drive passenger 5 from point 13 to point 18 for a profit of 18 - 13 + 1 = 6 dollars.
We earn 9 + 5 + 6 = 20 dollars in total.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= rides.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>rides[i].length == 3</code></li>
	<li><code>1 &lt;= start<sub>i</sub> &lt; end<sub>i</sub> &lt;= n</code></li>
	<li><code>1 &lt;= tip<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Memoization Search + Binary Search

> **Thinking**
>
> After sorting rides by start, ride $i$ only combines with later rides whose start is $\ge \textit{end}_i$. Subsets are infeasible for $m \le 3 \times 10^4$; the state is the best profit from index $i$.
>
> Skip goes to $i+1$; take binary-searches the first start $\ge \textit{end}_i$ as $j$ and adds distance, tip, and $\textit{dfs}(j)$.
>
> Memoization evaluates each $i$ once in $O(m \log m)$.

First, we sort $\textit{rides}$ in ascending order by $\textit{start}$. Then we design a function $\textit{dfs}(i)$, which represents the maximum tip that can be obtained from accepting orders starting from the $i$-th passenger. The answer is $\textit{dfs}(0)$.

The calculation process of the function $\textit{dfs}(i)$ is as follows:

For the $i$-th passenger, we can choose to accept or not to accept the order. If we don't accept the order, the maximum tip that can be obtained is $\textit{dfs}(i + 1)$. If we accept the order, we can use binary search to find the first passenger encountered after the drop-off point of the $i$-th passenger, denoted as $j$. The maximum tip that can be obtained is $\textit{dfs}(j) + \textit{end}_i - \textit{start}_i + \textit{tip}_i$. Take the larger of the two. That is:

$$
\textit{dfs}(i) = \max(\textit{dfs}(i + 1), \textit{dfs}(j) + \textit{end}_i - \textit{start}_i + \textit{tip}_i)
$$

Where $j$ is the smallest index that satisfies $\textit{start}_j \ge \textit{end}_i$, which can be obtained by binary search.

In this process, we can use memoization search to save the answer of each state to avoid repeated calculations.

The time complexity is $O(m \log m)$, and the space complexity is $O(m)$, where $m$ is the length of $\textit{rides}$.

#### Java

```java
class Solution {
    private int m;
    private int[][] rides;
    private Long[] f;

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);
        m = rides.length;
        f = new Long[m];
        this.rides = rides;
        return dfs(0);
    }

    private long dfs(int i) {
        if (i >= m) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        int[] r = rides[i];
        int st = r[0], ed = r[1], tip = r[2];
        int j = search(ed, i + 1);
        return f[i] = Math.max(dfs(i + 1), dfs(j) + ed - st + tip);
    }

    private int search(int x, int l) {
        int r = m;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (rides[mid][0] >= x) {
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
> Solution 1 sorts by start and fills one suffix table. Sorting by end instead lets $f[i]$ be the best profit among the first $i$ rides, with no aftereffect.
>
> Skip is $f[i-1]$; take binary-searches the last end $\le \textit{start}_i$.

Solution 1 sorts by start and fills a suffix table. Here we sort by end and define a prefix table.

First, sort $\textit{rides}$, this time we sort by $\textit{end}$ in ascending order. Then define $f[i]$, which represents the maximum tip that can be obtained from the first $i$ passengers. Initially, $f[0] = 0$, and the answer is $f[m]$.

For the $i$-th passenger, we can choose to accept or not to accept the order. If we don't accept the order, the maximum tip that can be obtained is $f[i-1]$. If we accept the order, we can use binary search to find the last passenger whose drop-off point is not greater than $\textit{start}_i$ before the $i$-th passenger gets on the car, denoted as $j$. The maximum tip that can be obtained is $f[j] + \textit{end}_i - \textit{start}_i + \textit{tip}_i$. Take the larger of the two. That is:

$$
f[i] = \max(f[i - 1], f[j] + \textit{end}_i - \textit{start}_i + \textit{tip}_i)
$$

Where $j$ is the largest index that satisfies $\textit{end}_j \le \textit{start}_i$, which can be obtained by binary search.

The time complexity is $O(m \log m)$, and the space complexity is $O(m)$, where $m$ is the length of $\textit{rides}$.

Similar problems:

- [1235. Maximum Profit in Job Scheduling](https://github.com/doocs/leetcode/blob/main/solution/1200-1299/1235.Maximum%20Profit%20in%20Job%20Scheduling/README_EN.md)
- [1751. Maximum Number of Events That Can Be Attended II](https://github.com/doocs/leetcode/blob/main/solution/1700-1799/1751.Maximum%20Number%20of%20Events%20That%20Can%20Be%20Attended%20II/README_EN.md)

#### Java

```java
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        int m = rides.length;
        long[] f = new long[m + 1];
        for (int i = 1; i <= m; ++i) {
            int[] r = rides[i - 1];
            int st = r[0], ed = r[1], tip = r[2];
            int j = search(rides, st + 1, i);
            f[i] = Math.max(f[i - 1], f[j] + ed - st + tip);
        }
        return f[m];
    }

    private int search(int[][] nums, int x, int r) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid][1] >= x) {
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
> After sorting rides by start, ride $i$ only combines with later rides whose start is $\ge \textit{end}_i$. Subsets are infeasible for $m \le 3 \times 10^4$; the state is the best profit from index $i$.
>
> Skip depends on $i+1$ and take depends on the first later start $\ge \textit{end}_i$. A search of that recurrence still calls $i+1$ before it returns, so the chain has length $m$ and overflows the stack.
>
> Later indices are known if we walk from the end. Let $f[i]$ be that profit, with $f[m] = 0$, and binary-search $j$ while filling $i$ from $m-1$ down to $0$.

First, we sort $\textit{rides}$ in ascending order by $\textit{start}$. Let $f[i]$ be the maximum earnings from the $i$-th passenger onward. The answer is $f[0]$, and $f[m] = 0$.

We fill $f$ from $i = m - 1$ down to $0$. For the $i$-th passenger we can skip the order, which keeps $f[i + 1]$, or accept it. Binary search finds the first passenger $j$ whose start is at least $\textit{end}_i$. Accepting earns $f[j] + \textit{end}_i - \textit{start}_i + \textit{tip}_i$. Take the larger of the two:

$$
f[i] = \max(f[i + 1], f[j] + \textit{end}_i - \textit{start}_i + \textit{tip}_i)
$$

Where $j$ is the smallest index that satisfies $\textit{start}_j \ge \textit{end}_i$. Because $j > i$, $f[j]$ is already filled.

The time complexity is $O(m \log m)$, and the space complexity is $O(m)$, where $m$ is the length of $\textit{rides}$.

#### Java

```java
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);
        int m = rides.length;
        long[] f = new long[m + 1];
        for (int i = m - 1; i >= 0; --i) {
            int st = rides[i][0], ed = rides[i][1], tip = rides[i][2];
            int j = search(rides, ed, i + 1);
            f[i] = Math.max(f[i + 1], f[j] + ed - st + tip);
        }
        return f[0];
    }

    private int search(int[][] rides, int x, int l) {
        int r = rides.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (rides[mid][0] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```
