# 1094. Car Pooling

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/car-pooling/

---

[中文文档](/solution/1000-1099/1094.Car%20Pooling/README.md)

## Description

<p>There is a car with <code>capacity</code> empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).</p>

<p>You are given the integer <code>capacity</code> and an array <code>trips</code> where <code>trips[i] = [numPassengers<sub>i</sub>, from<sub>i</sub>, to<sub>i</sub>]</code> indicates that the <code>i<sup>th</sup></code> trip has <code>numPassengers<sub>i</sub></code> passengers and the locations to pick them up and drop them off are <code>from<sub>i</sub></code> and <code>to<sub>i</sub></code> respectively. The locations are given as the number of kilometers due east from the car&#39;s initial location.</p>

<p>Passengers are dropped off before new passengers are picked up at the same location. At every point along the route, the total number of passengers in the car must not exceed <code>capacity</code>.</p>

<p>Return <code>true</code> if it is possible to pick up and drop off all passengers for all the given trips, or <code>false</code> otherwise.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> trips = [[2,1,5],[3,3,7]], capacity = 4
<strong>Output:</strong> false
<strong>Explanation:</strong>
At kilometer 1, 2 passengers are picked up, so the car holds 2.
At kilometer 3, 3 more are picked up, so the car holds 5.
Since 5 &gt; capacity = 4, the trips cannot all be completed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> trips = [[2,1,5],[3,3,7]], capacity = 5
<strong>Output:</strong> true
<strong>Explanation:</strong>
At kilometer 1, the car holds 2 passengers.
At kilometer 3, the car holds 5 passengers.
At kilometer 5, the first 2 are dropped off, so the car holds 3.
At kilometer 7, the last 3 are dropped off, so the car holds 0.
The maximum occupancy is 5, which never exceeds capacity = 5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= trips.length &lt;= 1000</code></li>
	<li><code>trips[i].length == 3</code></li>
	<li><code>1 &lt;= numPassengers<sub>i</sub> &lt;= 100</code></li>
	<li><code>0 &lt;= from<sub>i</sub> &lt; to<sub>i</sub> &lt;= 1000</code></li>
	<li><code>1 &lt;= capacity &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Difference Array

> **Thinking**
>
> Each trip adds passengers on $[\textit{from},to)$. We need the load never to exceed capacity. Locations are at most $1000$, so a difference array is enough.
>
> Add at the start, subtract at the end, then prefix-sum and test every position against $\textit{capacity}$.
>
> The array runs to the latest drop-off; empty stops keep the previous load.

We can use the idea of a difference array, adding the number of passengers to the starting point of each trip and subtracting from the end point. Finally, we just need to check whether the prefix sum of the difference array does not exceed the maximum passenger capacity of the car.

The time complexity is $O(n)$, and the space complexity is $O(M)$, where $n$ is the number of trips, and $M$ is the maximum end point in the trips. In this problem, $M \le 1000$.

#### Java

```java
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] d = new int[1001];
        for (var trip : trips) {
            int x = trip[0], f = trip[1], t = trip[2];
            d[f] += x;
            d[t] -= x;
        }
        int s = 0;
        for (int x : d) {
            s += x;
            if (s > capacity) {
                return false;
            }
        }
        return true;
    }
}
```
