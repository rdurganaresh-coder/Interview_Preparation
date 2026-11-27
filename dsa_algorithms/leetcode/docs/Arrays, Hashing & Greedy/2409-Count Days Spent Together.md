# 2409. Count Days Spent Together

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-days-spent-together/

---

[中文文档](/solution/2400-2499/2409.Count%20Days%20Spent%20Together/README.md)

## Description

<p>Alice and Bob are traveling to Rome for separate business meetings.</p>

<p>You are given 4 strings <code>arriveAlice</code>, <code>leaveAlice</code>, <code>arriveBob</code>, and <code>leaveBob</code>. Alice will be in the city from the dates <code>arriveAlice</code> to <code>leaveAlice</code> (<strong>inclusive</strong>), while Bob will be in the city from the dates <code>arriveBob</code> to <code>leaveBob</code> (<strong>inclusive</strong>). Each will be a 5-character string in the format <code>&quot;MM-DD&quot;</code>, corresponding to the month and day of the date.</p>

<p>Return<em> the total number of days that Alice and Bob are in Rome together.</em></p>

<p>You can assume that all dates occur in the <strong>same</strong> calendar year, which is <strong>not</strong> a leap year. Note that the number of days per month can be represented as: <code>[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arriveAlice = &quot;08-15&quot;, leaveAlice = &quot;08-18&quot;, arriveBob = &quot;08-16&quot;, leaveBob = &quot;08-19&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> Alice will be in Rome from August 15 to August 18. Bob will be in Rome from August 16 to August 19. They are both in Rome together on August 16th, 17th, and 18th, so the answer is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arriveAlice = &quot;10-01&quot;, leaveAlice = &quot;10-31&quot;, arriveBob = &quot;11-01&quot;, leaveBob = &quot;12-31&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no day when Alice and Bob are in Rome together, so we return 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>All dates are provided in the format <code>&quot;MM-DD&quot;</code>.</li>
	<li>Alice and Bob&#39;s arrival dates are <strong>earlier than or equal to</strong> their leaving dates.</li>
	<li>The given dates are valid dates of a <strong>non-leap</strong> year.</li>
</ul>

## Solutions

### Solution 1: Prefix Sum

> **Thinking**
>
> Days together are the length of the intersection of two closed intervals. Scanning every day of the year fits the constraints, but the inputs are $\texttt{MM-DD}$ strings, so both comparison and counting need one shared index.
>
> Adding the preceding month lengths on each conversion repeats the same constant work. Lexicographic order of this format matches the calendar, so the overlap runs from the later arrival to the earlier departure. Month lengths in a non-leap year are fixed; once their prefix sums $f$ are known, month $m$ and day $d$ is day $f_{m-1}+d$ of the year.
>
> The two endpoints are converted through $f$, then subtracted and adjusted by one. If the start falls after the end, the intersection is empty.

We take the later arrival and the earlier departure, map both dates to a day of the year with the month-length prefix, and return the length of that closed interval.

The time complexity is $O(1)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    static final int[] f = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public int countDaysTogether(
        String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String start = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
        int d1
            = f[Integer.parseInt(start.substring(0, 2)) - 1] + Integer.parseInt(start.substring(3));
        int d2 = f[Integer.parseInt(end.substring(0, 2)) - 1] + Integer.parseInt(end.substring(3));
        return Math.max(d2 - d1 + 1, 0);
    }
}
```
