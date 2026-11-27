# 3341. Find Minimum Time to Reach Last Room I

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/

---

[中文文档](/solution/3300-3399/3341.Find%20Minimum%20Time%20to%20Reach%20Last%20Room%20I/README.md)

## Description

<p>There is a dungeon with <code>n x m</code> rooms arranged as a grid.</p>

<p>You are given a 2D array <code>moveTime</code> of size <code>n x m</code>, where <code>moveTime[i][j]</code> represents the <strong>minimum</strong> time in seconds <strong>after</strong> which the room opens and can be moved to. You start from the room <code>(0, 0)</code> at time <code>t = 0</code> and can move to an <strong>adjacent</strong> room. Moving between adjacent rooms takes <em>exactly</em> one second.</p>

<p>Return the <strong>minimum</strong> time to reach the room <code>(n - 1, m - 1)</code>.</p>

<p>Two rooms are <strong>adjacent</strong> if they share a common wall, either <em>horizontally</em> or <em>vertically</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">moveTime = [[0,4],[4,4]]</span></p>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>

<p>The minimum time required is 6 seconds.</p>

<ul>
	<li>At time <code>t == 4</code>, move from room <code>(0, 0)</code> to room <code>(1, 0)</code> in one second.</li>
	<li>At time <code>t == 5</code>, move from room <code>(1, 0)</code> to room <code>(1, 1)</code> in one second.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">moveTime = [[0,0,0],[0,0,0]]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The minimum time required is 3 seconds.</p>

<ul>
	<li>At time <code>t == 0</code>, move from room <code>(0, 0)</code> to room <code>(1, 0)</code> in one second.</li>
	<li>At time <code>t == 1</code>, move from room <code>(1, 0)</code> to room <code>(1, 1)</code> in one second.</li>
	<li>At time <code>t == 2</code>, move from room <code>(1, 1)</code> to room <code>(1, 2)</code> in one second.</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">moveTime = [[0,1],[1,2]]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n == moveTime.length &lt;= 50</code></li>
	<li><code>2 &lt;= m == moveTime[i].length &lt;= 50</code></li>
	<li><code>0 &lt;= moveTime[i][j] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Dijkstra's Algorithm

> **Thinking**
>
> A move into $(x,y)$ cannot happen before $\textit{moveTime}[x][y]$, and every step costs $1$. Weights are nonnegative but depend on arrival time, so BFS is wrong.
>
> With $n,m \le 50$, Dijkstra on time is enough. The relaxation is $t=\max(\textit{moveTime}[x][y],\textit{dist}[i][j])+1$.
>
> The first time the priority queue pops the destination is the answer.

We define a two-dimensional array $\textit{dist}$, where $\textit{dist}[i][j]$ represents the minimum time required to reach room $(i, j)$ from the starting point. Initially, we set all elements in the $\textit{dist}$ array to infinity, and then set the $\textit{dist}$ value of the starting point $(0, 0)$ to $0$.

We use a priority queue $pq$ to store each state, where each state consists of three values $(d, i, j)$, representing the time $d$ required to reach room $(i, j)$ from the starting point. Initially, we add the starting point $(0, 0, 0)$ to $pq$.

In each iteration, we take the front element $(d, i, j)$ from $pq$. If $(i, j)$ is the endpoint, we return $d$. If $d$ is greater than $\textit{dist}[i][j]$, we skip this state. Otherwise, we enumerate the four adjacent positions $(x, y)$ of $(i, j)$. If $(x, y)$ is within the map, we calculate the final time $t$ from $(i, j)$ to $(x, y)$ as $t = \max(\textit{moveTime}[x][y], \textit{dist}[i][j]) + 1$. If $t$ is less than $\textit{dist}[x][y]$, we update the value of $\textit{dist}[x][y]$ and add $(t, x, y)$ to $pq$.

The time complexity is $O(nm \log (nm))$, and the space complexity is $O(nm)$, where $n$ and $m$ are the number of rows and columns of the map, respectively.

#### Java

```java
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (var row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0, 0});
        int[] dirs = {-1, 0, 1, 0, -1};
        while (true) {
            int[] p = pq.poll();
            int d = p[0], i = p[1], j = p[2];

            if (i == n - 1 && j == m - 1) {
                return d;
            }
            if (d > dist[i][j]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int t = Math.max(moveTime[x][y], dist[i][j]) + 1;
                    if (dist[x][y] > t) {
                        dist[x][y] = t;
                        pq.offer(new int[] {t, x, y});
                    }
                }
            }
        }
    }
}
```
