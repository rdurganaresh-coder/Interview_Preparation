# 1413. Minimum Value to Get Positive Step by Step Sum

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/

---

[中文文档](/solution/1400-1499/1413.Minimum%20Value%20to%20Get%20Positive%20Step%20by%20Step%20Sum/README.md)

## Description

<p>Given an array of integers&nbsp;<code>nums</code>, you start with an initial <strong>positive</strong> value <em>startValue</em><em>.</em></p>

<p>In each iteration, you calculate the step by step sum of <em>startValue</em>&nbsp;plus&nbsp;elements in <code>nums</code>&nbsp;(from left to right).</p>

<p>Return the minimum <strong>positive</strong> value of&nbsp;<em>startValue</em> such that the step by step sum is never less than 1.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-3,2,-3,4,2]
<strong>Output:</strong> 5
<strong>Explanation: </strong>If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
<strong>step by step sum</strong>
<strong>startValue = 4 | startValue = 5 | nums</strong>
  (4 <strong>-3</strong> ) = 1  | (5 <strong>-3</strong> ) = 2    |  -3
  (1 <strong>+2</strong> ) = 3  | (2 <strong>+2</strong> ) = 4    |   2
  (3 <strong>-3</strong> ) = 0  | (4 <strong>-3</strong> ) = 1    |  -3
  (0 <strong>+4</strong> ) = 4  | (1 <strong>+4</strong> ) = 5    |   4
  (4 <strong>+2</strong> ) = 6  | (5 <strong>+2</strong> ) = 7    |   2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Minimum start value should be positive. 
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,-2,-3]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Every running sum must stay at least $1$. If the start value is $x$, then $x$ plus every prefix is $\ge 1$, so $x\ge 1-\min\textit{prefix}$. Also $x\ge 1$.
>
> $n\le 100$. One pass tracks the prefix and its minimum $t$; the answer is $\max(1,1-t)$.

#### Java

```java
class Solution {
    public int minStartValue(int[] nums) {
        int s = 0;
        int t = Integer.MAX_VALUE;
        for (int num : nums) {
            s += num;
            t = Math.min(t, s);
        }
        return Math.max(1, 1 - t);
    }
}
```

### Solution 2

> **Thinking**
>
> Method 1 tracks the minimum on the fly. Building all prefixes with `accumulate` and then taking $\min$ uses the same formula, only with an explicit prefix array.
