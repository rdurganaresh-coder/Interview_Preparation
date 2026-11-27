# 1229. Meeting Scheduler

**Difficulty:** Medium  
**Category:** Heaps & Priority Queues  
**LeetCode:** https://leetcode.com/problems/meeting-scheduler/

---

[中文文档](/solution/1200-1299/1229.Meeting%20Scheduler/README.md)

## Description

<p>Given the availability time slots arrays <code>slots1</code> and <code>slots2</code> of two people and a meeting duration <code>duration</code>, return the <strong>earliest time slot</strong> that works for both of them and is of duration <code>duration</code>.</p>

<p>If there is no common time slot that satisfies the requirements, return an <strong>empty array</strong>.</p>

<p>The format of a time slot is an array of two elements <code>[start, end]</code> representing an inclusive time range from <code>start</code> to <code>end</code>.</p>

<p>It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots <code>[start1, end1]</code> and <code>[start2, end2]</code> of the same person, either <code>start1 &gt; end2</code> or <code>start2 &gt; end1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
<strong>Output:</strong> [60,68]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= slots1.length, slots2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>slots1[i].length, slots2[i].length == 2</code></li>
	<li><code>slots1[i][0] &lt; slots1[i][1]</code></li>
	<li><code>slots2[i][0] &lt; slots2[i][1]</code></li>
	<li><code>0 &lt;= slots1[i][j], slots2[i][j] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= duration &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Sorting + Two Pointers

> **Thinking**
>
> Each person has up to $10^4$ slots; checking every pair is $O(mn)$. After sorting by start, an overlap can only involve the two current slots: start is the max of starts, end the min of ends.
>
> If the overlap is long enough, we return the earliest such interval. Otherwise the slot that ends first cannot form an earlier feasible overlap with later slots of the other person, so we advance that pointer.
>
> Sorting walks candidates in time order; two pointers discard a hopeless slot each step, for a linear number of comparisons.

We can sort the free time intervals of both people, then use two pointers to traverse the two arrays and find the intersection of the free time intervals of both people. If the length of the intersection is greater than or equal to `duration`, return the start time of the intersection and the start time plus `duration`. Otherwise, if the end time of the first person's free time interval is less than the end time of the second person's free time interval, move the first person's pointer; otherwise, move the second person's pointer. Continue traversing until a suitable time interval is found or the traversal ends.

The time complexity is $O(m \log m + n \log n)$, and the space complexity is $O(\log m + \log n)$, where $m$ and $n$ are the lengths of the two arrays, respectively.

#### Java

```java
class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int m = slots1.length, n = slots2.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (end - start >= duration) {
                return Arrays.asList(start, start + duration);
            }
            if (slots1[i][1] < slots2[j][1]) {
                ++i;
            } else {
                ++j;
            }
        }
        return Collections.emptyList();
    }
}
```
