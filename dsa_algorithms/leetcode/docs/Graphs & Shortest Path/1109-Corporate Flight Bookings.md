# 1109. Corporate Flight Bookings

**Difficulty:** Medium  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/corporate-flight-bookings/

---

[中文文档](/solution/1100-1199/1109.Corporate%20Flight%20Bookings/README.md)

## Description

<p>There are <code>n</code> flights that are labeled from <code>1</code> to <code>n</code>.</p>

<p>You are given an array of flight bookings <code>bookings</code>, where <code>bookings[i] = [first<sub>i</sub>, last<sub>i</sub>, seats<sub>i</sub>]</code> represents a booking for flights <code>first<sub>i</sub></code> through <code>last<sub>i</sub></code> (<strong>inclusive</strong>) with <code>seats<sub>i</sub></code> seats reserved for <strong>each flight</strong> in the range.</p>

<p>Return <em>an array </em><code>answer</code><em> of length </em><code>n</code><em>, where </em><code>answer[i]</code><em> is the total number of seats reserved for flight </em><code>i</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
<strong>Output:</strong> [10,55,45,25,25]
<strong>Explanation:</strong>
Flight labels:        1   2   3   4   5
Booking 1 reserved:  10  10
Booking 2 reserved:      20  20
Booking 3 reserved:      25  25  25  25
Total seats:         10  55  45  25  25
Hence, answer = [10,55,45,25,25]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> bookings = [[1,2,10],[2,2,15]], n = 2
<strong>Output:</strong> [10,25]
<strong>Explanation:</strong>
Flight labels:        1   2
Booking 1 reserved:  10  10
Booking 2 reserved:      15
Total seats:         10  25
Hence, answer = [10,25]

</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= bookings.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>bookings[i].length == 3</code></li>
	<li><code>1 &lt;= first<sub>i</sub> &lt;= last<sub>i</sub> &lt;= n</code></li>
	<li><code>1 &lt;= seats<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Difference Array

> **Thinking**
>
> Each booking adds the same amount on the closed range $[\textit{first},\textit{last}]$. Updating every flight in the range costs time proportional to the sum of lengths, worst-case $O(nm)$.
>
> A difference array adds $\textit{seats}$ at the left endpoint and subtracts it at $\textit{last}+1$, so each range update is two point updates. A final prefix sum restores the booked seats on every flight.

We notice that each booking is for $\textit{seats}$ seats on all flights within a certain interval `[first, last]`. Therefore, we can use the idea of a difference array. For each booking, we add $\textit{seats}$ to the number at the $\textit{first}$ position and subtract $\textit{seats}$ from the number at the `last + 1` position. Finally, we calculate the prefix sum of the difference array to get the total number of seats booked for each flight.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the number of flights.

#### Java

```java
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (var e : bookings) {
            int first = e[0], last = e[1], seats = e[2];
            ans[first - 1] += seats;
            if (last < n) {
                ans[last] -= seats;
            }
        }
        for (int i = 1; i < n; ++i) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
```

### Solution 2: Binary Indexed Tree + Difference Idea

> **Thinking**
>
> Method 1's difference array needs one final prefix pass and is offline. A Fenwick tree supports point add and prefix query in $O(\log n)$: add at $\textit{first}$, subtract at $\textit{last}+1$, then the prefix at $i$ is flight $i$'s seats. This problem does not need online queries, so the extra log factor is only an alternative implementation.

We can also use a binary indexed tree, combined with the idea of difference, to implement the above operations. We can consider each booking as booking `seats` seats on all flights within a certain interval `[first, last]`. Therefore, for each booking, we add `seats` to the $\textit{first}$ position of the binary indexed tree and subtract `seats` from the `last + 1` position of the binary indexed tree. Finally, we calculate the prefix sum for each position in the binary indexed tree to get the total number of seats booked for each flight.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the number of flights.

Here is a basic introduction to the binary indexed tree:

A binary indexed tree, also known as a "Binary Indexed Tree" or Fenwick tree. It can efficiently implement the following two operations:

1. **Single Point Update** `update(x, delta)`: Add a value delta to the number at position x in the sequence;
1. **Prefix Sum Query** `query(x)`: Query the interval sum of the sequence `[1,...x]`, that is, the prefix sum of position x.

The time complexity of these two operations is $O(\log n)$.

#### Java

```java
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (var e : bookings) {
            int first = e[0], last = e[1], seats = e[2];
            tree.update(first, seats);
            tree.update(last + 1, -seats);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = tree.query(i + 1);
        }
        return ans;
    }
}

class BinaryIndexedTree {
    private int n;
    private int[] c;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;
            x += x & -x;
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= x & -x;
        }
        return s;
    }
}
```
