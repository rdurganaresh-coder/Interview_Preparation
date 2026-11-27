# 2121. Intervals Between Identical Elements

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/intervals-between-identical-elements/

---

[中文文档](/solution/2100-2199/2121.Intervals%20Between%20Identical%20Elements/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> array of <code>n</code> integers <code>arr</code>.</p>

<p>The <strong>interval</strong> between two elements in <code>arr</code> is defined as the <strong>absolute difference</strong> between their indices. More formally, the <strong>interval</strong> between <code>arr[i]</code> and <code>arr[j]</code> is <code>|i - j|</code>.</p>

<p>Return <em>an array</em> <code>intervals</code> <em>of length</em> <code>n</code> <em>where</em> <code>intervals[i]</code> <em>is <strong>the sum of intervals</strong> between </em><code>arr[i]</code><em> and each element in </em><code>arr</code><em> with the same value as </em><code>arr[i]</code><em>.</em></p>

<p><strong>Note:</strong> <code>|x|</code> is the absolute value of <code>x</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [2,1,3,1,2,3,3]
<strong>Output:</strong> [4,2,7,2,4,4,5]
<strong>Explanation:</strong>
- Index 0: Another 2 is found at index 4. |0 - 4| = 4
- Index 1: Another 1 is found at index 3. |1 - 3| = 2
- Index 2: Two more 3s are found at indices 5 and 6. |2 - 5| + |2 - 6| = 7
- Index 3: Another 1 is found at index 1. |3 - 1| = 2
- Index 4: Another 2 is found at index 0. |4 - 0| = 4
- Index 5: Two more 3s are found at indices 2 and 6. |5 - 2| + |5 - 6| = 4
- Index 6: Two more 3s are found at indices 2 and 5. |6 - 2| + |6 - 5| = 5
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [10,5,10,10]
<strong>Output:</strong> [5,0,3,4]
<strong>Explanation:</strong>
- Index 0: Two more 10s are found at indices 2 and 3. |0 - 2| + |0 - 3| = 5
- Index 1: There is only one 5 in the array, so its sum of intervals to identical elements is 0.
- Index 2: Two more 10s are found at indices 0 and 3. |2 - 0| + |2 - 3| = 3
- Index 3: Two more 10s are found at indices 0 and 2. |3 - 0| + |3 - 2| = 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == arr.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arr[i] &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as <a href="https://leetcode.com/problems/sum-of-distances/description/" target="_blank"> 2615: Sum of Distances.</a></p>

## Solutions

### Solution 1

> **Thinking**
>
> For each $i$ we need $\sum_j |i-j|$ over indices with the same value. Grouping by value and summing pairs is $O(n^2)$ and fails for $n\le 10^5$.
>
> Indices of one value are sorted, $v_0,\ldots,v_{m-1}$. Moving from $v_{i-1}$ to $v_i$ by $\Delta$ increases the $i$ left positions by $\Delta$ and decreases the $m-i$ right positions by $\Delta$, so the all-pairs distance can be rolled from the sum relative to $v_0$.
>
> Collect indices by value, start from $\sum v-v_0\cdot m$, then sweep the group with that recurrence.

#### Java

```java
class Solution {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> d = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            d.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        long[] ans = new long[n];
        for (List<Integer> v : d.values()) {
            int m = v.size();
            long val = 0;
            for (int e : v) {
                val += e;
            }
            val -= 1L * m * v.get(0);
            for (int i = 0; i < v.size(); ++i) {
                int delta = i >= 1 ? v.get(i) - v.get(i - 1) : 0;
                val += 1L * i * delta - 1L * (m - i) * delta;
                ans[v.get(i)] = val;
            }
        }
        return ans;
    }
}
```
