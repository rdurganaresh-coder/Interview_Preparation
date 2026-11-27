# 2335. Minimum Amount of Time to Fill Cups

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/

---

[中文文档](/solution/2300-2399/2335.Minimum%20Amount%20of%20Time%20to%20Fill%20Cups/README.md)

## Description

<p>You have a water dispenser that can dispense cold, warm, and hot water. Every second, you can either fill up <code>2</code> cups with <strong>different</strong> types of water, or <code>1</code> cup of any type of water.</p>

<p>You are given a <strong>0-indexed</strong> integer array <code>amount</code> of length <code>3</code> where <code>amount[0]</code>, <code>amount[1]</code>, and <code>amount[2]</code> denote the number of cold, warm, and hot water cups you need to fill respectively. Return <em>the <strong>minimum</strong> number of seconds needed to fill up all the cups</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> amount = [1,4,2]
<strong>Output:</strong> 4
<strong>Explanation:</strong> One way to fill up the cups is:
Second 1: Fill up a cold cup and a warm cup.
Second 2: Fill up a warm cup and a hot cup.
Second 3: Fill up a warm cup and a hot cup.
Second 4: Fill up a warm cup.
It can be proven that 4 is the minimum number of seconds needed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> amount = [5,4,4]
<strong>Output:</strong> 7
<strong>Explanation:</strong> One way to fill up the cups is:
Second 1: Fill up a cold cup, and a hot cup.
Second 2: Fill up a cold cup, and a warm cup.
Second 3: Fill up a cold cup, and a warm cup.
Second 4: Fill up a warm cup, and a hot cup.
Second 5: Fill up a cold cup, and a hot cup.
Second 6: Fill up a cold cup, and a warm cup.
Second 7: Fill up a hot cup.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> amount = [5,0,0]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Every second, we fill up a cold cup.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>amount.length == 3</code></li>
	<li><code>0 &lt;= amount[i] &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Each second we fill two different cups or one cup. The total is at most $300$, so we may repeatedly decrement the two current maxima.
>
> Sort, decrease the two largest (or one if the second is already $0$), and repeat until all are zero. Each second absorbs as much demand as possible.

#### Java

```java
class Solution {
    public int fillCups(int[] amount) {
        int ans = 0;
        while (amount[0] + amount[1] + amount[2] > 0) {
            Arrays.sort(amount);
            ++ans;
            amount[2]--;
            amount[1] = Math.max(0, amount[1] - 1);
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Method 1 simulates second by second. After sorting $a \le b \le c$, a closed form exists: if $a+b \le c$, the two smaller amounts finish inside $c$ seconds; otherwise we always pair two cups, and the answer is $\lfloor (a+b+c+1)/2 \rfloor$.

#### Java

```java
class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[0] + amount[1] <= amount[2]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
}
```
