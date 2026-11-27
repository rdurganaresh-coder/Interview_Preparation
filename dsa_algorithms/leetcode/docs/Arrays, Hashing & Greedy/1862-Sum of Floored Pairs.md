# 1862. Sum of Floored Pairs

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/sum-of-floored-pairs/

---

[中文文档](/solution/1800-1899/1862.Sum%20of%20Floored%20Pairs/README.md)

## Description

<p>Given an integer array <code>nums</code>, return the sum of <code>floor(nums[i] / nums[j])</code> for all pairs of indices <code>0 &lt;= i, j &lt; nums.length</code> in the array. Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>The <code>floor()</code> function returns the integer part of the division.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,5,9]
<strong>Output:</strong> 10
<strong>Explanation:</strong>
floor(2 / 5) = floor(2 / 9) = floor(5 / 9) = 0
floor(2 / 2) = floor(5 / 5) = floor(9 / 9) = 1
floor(5 / 2) = 2
floor(9 / 2) = 4
floor(9 / 5) = 1
We calculate the floor of the division for every pair of indices in the array then sum them up.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [7,7,7,7,7,7,7]
<strong>Output:</strong> 49
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Prefix Sum of Value Range + Optimized Enumeration

> **Thinking**
>
> We need $\sum_{i,j}\lfloor \textit{nums}[i]/\textit{nums}[j]\rfloor$. Pair enumeration is $O(n^2)$ and too slow for $n\le 10^5$.
>
> Values are at most $10^5$, so build a prefix of frequencies. For each denominator $y$ and quotient $d$, the count of numerators in $[dy,dy+y)$ is a prefix difference, multiplied by $\textit{cnt}[y]\cdot d$. The harmonic enumeration is $O(M \log M)$.

First, we count the occurrences of each element in the array $\textit{nums}$ and record them in the array $\textit{cnt}$. Then, we calculate the prefix sum of the array $\textit{cnt}$ and record it in the array $s$, i.e., $s[i]$ represents the count of elements less than or equal to $i$.

Next, we enumerate the denominator $y$ and the quotient $d$. Using the prefix sum array, we can calculate the count of the numerator $s[\min(mx, d \times y + y - 1)] - s[d \times y - 1]$, where $mx$ represents the maximum value in the array $\textit{nums}$. Then, we multiply the count of the numerator by the count of the denominator $\textit{cnt}[y]$, and then multiply by the quotient $d$. This gives us the value of all fractions that meet the conditions. By summing these values, we can get the answer.

The time complexity is $O(M \log M)$, and the space complexity is $O(M)$, where $M$ is the maximum value in the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        final int mod = (int) 1e9 + 7;
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int[] cnt = new int[mx + 1];
        int[] s = new int[mx + 1];
        for (int x : nums) {
            ++cnt[x];
        }
        for (int i = 1; i <= mx; ++i) {
            s[i] = s[i - 1] + cnt[i];
        }
        long ans = 0;
        for (int y = 1; y <= mx; ++y) {
            if (cnt[y] > 0) {
                for (int d = 1; d * y <= mx; ++d) {
                    ans += 1L * cnt[y] * d * (s[Math.min(mx, d * y + y - 1)] - s[d * y - 1]);
                    ans %= mod;
                }
            }
        }
        return (int) ans;
    }
}
```
