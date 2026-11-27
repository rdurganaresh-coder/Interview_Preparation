# 1390. Four Divisors

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/four-divisors/

---

[中文文档](/solution/1300-1399/1390.Four%20Divisors/README.md)

## Description

<p>Given an integer array <code>nums</code>, return <em>the sum of divisors of the integers in that array that have exactly four divisors</em>. If there is no such integer in the array, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [21,4,7]
<strong>Output:</strong> 32
<strong>Explanation:</strong> 
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [21,21]
<strong>Output:</strong> 64
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4,5]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Factor Decomposition

> **Thinking**
>
> Sum the divisors of every integer that has exactly four divisors. Values are at most $10^5$, so trial division up to $\sqrt{x}$ lists them all. We count and sum together and keep the sum only when the count is $4$.

We can perform factor decomposition on each number. If the number of factors is $4$, then this number meets the requirements of the problem, and we can add its factors to the answer.

The time complexity is $O(n \sqrt{n})$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans += f(x);
        }
        return ans;
    }

    private int f(int x) {
        int cnt = 2, s = x + 1;
        for (int i = 2; i <= x / i; ++i) {
            if (x % i == 0) {
                ++cnt;
                s += i;
                if (i * i != x) {
                    ++cnt;
                    s += x / i;
                }
            }
        }
        return cnt == 4 ? s : 0;
    }
}
```
