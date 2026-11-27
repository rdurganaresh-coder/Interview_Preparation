# 3115. Maximum Prime Difference

**Difficulty:** Medium  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/maximum-prime-difference/

---

[中文文档](/solution/3100-3199/3115.Maximum%20Prime%20Difference/README.md)

## Description

<p>You are given an integer array <code>nums</code>.</p>

<p>Return an integer that is the <strong>maximum</strong> distance between the <strong>indices</strong> of two (not necessarily different) prime numbers in <code>nums</code><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,2,9,5,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong> <code>nums[1]</code>, <code>nums[3]</code>, and <code>nums[4]</code> are prime. So the answer is <code>|4 - 1| = 3</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,8,2,8]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong> <code>nums[2]</code> is prime. Because there is just one prime number, the answer is <code>|2 - 2| = 0</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
	<li>The input is generated such that the number of prime numbers in the <code>nums</code> is at least one.</li>
</ul>

## Solutions

### Solution 1: Traversal

> **Thinking**
>
> The answer is the index gap between the leftmost and rightmost primes. Comparing every prime pair only rediscovers those two ends.
>
> Primality of a single value is $O(\sqrt{M})$, and both length and magnitude are modest, so locating the two ends is enough.
>
> Scan left for the first prime index $i$ and right for the last prime index $j$, then return $j-i$. Interior values never affect the distance.

According to the problem description, we need to find the index $i$ of the first prime number, then find the index $j$ of the last prime number, and return $j - i$ as the answer.

Therefore, we can traverse the array from left to right to find the index $i$ of the first prime number, then traverse the array from right to left to find the index $j$ of the last prime number. The answer is $j - i$.

The time complexity is $O(n \sqrt{M})$, and the space complexity is $O(1)$, where $n$ and $M$ are the length of the array $\textit{nums}$ and the maximum value in the array, respectively.

#### Java

```java
class Solution {
    public int maximumPrimeDifference(int[] nums) {
        for (int i = 0;; ++i) {
            if (isPrime(nums[i])) {
                for (int j = nums.length - 1;; --j) {
                    if (isPrime(nums[j])) {
                        return j - i;
                    }
                }
            }
        }
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int v = 2; v * v <= x; ++v) {
            if (x % v == 0) {
                return false;
            }
        }
        return true;
    }
}
```
