# 1710. Maximum Units on a Truck

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-units-on-a-truck/

---

[中文文档](/solution/1700-1799/1710.Maximum%20Units%20on%20a%20Truck/README.md)

## Description

<p>You are assigned to put some amount of boxes onto <strong>one truck</strong>. You are given a 2D array <code>boxTypes</code>, where <code>boxTypes[i] = [numberOfBoxes<sub>i</sub>, numberOfUnitsPerBox<sub>i</sub>]</code>:</p>

<ul>
	<li><code>numberOfBoxes<sub>i</sub></code> is the number of boxes of type <code>i</code>.</li>
	<li><code>numberOfUnitsPerBox<sub>i</sub></code><sub> </sub>is the number of units in each box of the type <code>i</code>.</li>
</ul>

<p>You are also given an integer <code>truckSize</code>, which is the <strong>maximum</strong> number of <strong>boxes</strong> that can be put on the truck. You can choose any boxes to put on the truck as long as the number&nbsp;of boxes does not exceed <code>truckSize</code>.</p>

<p>Return <em>the <strong>maximum</strong> total number of <strong>units</strong> that can be put on the truck.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
<strong>Output:</strong> 8
<strong>Explanation:</strong> There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
<strong>Output:</strong> 91
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= boxTypes.length &lt;= 1000</code></li>
	<li><code>1 &lt;= numberOfBoxes<sub>i</sub>, numberOfUnitsPerBox<sub>i</sub> &lt;= 1000</code></li>
	<li><code>1 &lt;= truckSize &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Greedy + Sorting

> **Thinking**
>
> Capacity is measured in boxes, but the objective is units. Boxes of one type share the same unit count, so denser types should be taken first.
>
> Sort by units per box descending and load $\min(\textit{truckSize},\textit{count})$ of each type, decreasing remaining capacity until it is gone.

According to the problem, we should choose as many units as possible. Therefore, we first sort `boxTypes` in descending order of the number of units.

Then we traverse `boxTypes` from front to back, choose up to $\textit{truckSize}$ boxes, and accumulate the number of units.

The time complexity is $O(n \log n)$, where $n$ is the length of the two-dimensional array $\textit{boxTypes}$.

#### Java

```java
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (var e : boxTypes) {
            int a = e[0], b = e[1];
            ans += b * Math.min(truckSize, a);
            truckSize -= a;
            if (truckSize <= 0) {
                break;
            }
        }
        return ans;
    }
}
```

### Solution 2: Counting Sort

> **Thinking**
>
> Solution 1 spends $O(n \log n)$ on sorting. Units per box are at most $1000$, so a counting array can store box counts by that value.
>
> Scan from $1000$ down to $1$ and load in the same greedy order, now in linear time.

We can also use the idea of counting sort, create an array $\textit{cnt}$ of length $1001$, where $\textit{cnt}[b]$ represents the number of boxes with $b$ units.

Then starting from the box with the maximum number of units, choose up to `truckSize` boxes, and accumulate the number of units.

The time complexity is $O(M)$, where $M$ is the maximum number of units. In this problem, $M=1000$.

#### Java

```java
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] cnt = new int[1001];
        for (var e : boxTypes) {
            int a = e[0], b = e[1];
            cnt[b] += a;
        }
        int ans = 0;
        for (int b = 1000; b > 0 && truckSize > 0; --b) {
            int a = cnt[b];
            if (a > 0) {
                ans += b * Math.min(truckSize, a);
                truckSize -= a;
            }
        }
        return ans;
    }
}
```
