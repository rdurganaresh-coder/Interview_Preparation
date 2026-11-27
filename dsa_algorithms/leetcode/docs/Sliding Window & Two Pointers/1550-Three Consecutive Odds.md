# 1550. Three Consecutive Odds

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/three-consecutive-odds/

---

[中文文档](/solution/1500-1599/1550.Three%20Consecutive%20Odds/README.md)

## Description

Given an integer array <code>arr</code>, return <code>true</code>&nbsp;if there are three consecutive odd numbers in the array. Otherwise, return&nbsp;<code>false</code>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [2,6,4,1]
<strong>Output:</strong> false
<b>Explanation:</b> There are no three consecutive odds.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2,34,3,4,5,7,23,12]
<strong>Output:</strong> true
<b>Explanation:</b> [5,7,23] are three consecutive odds.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 1000</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Iteration + Counting

> **Thinking**
>
> Decide whether three consecutive odds exist. $n$ is small enough for one scan; no index structure is required.
>
> A counter tracks the current odd run: increment on an odd value and succeed at $3$; reset on an even value. Only adjacency matters, so extra memory is constant.

We use a variable $\textit{cnt}$ to record the current count of consecutive odd numbers.

Next, we iterate through the array. If the current element is odd, then $\textit{cnt}$ is incremented by one. If $\textit{cnt}$ equals 3, then return $\textit{True}$. If the current element is even, then $\textit{cnt}$ is reset to zero.

After the iteration, if three consecutive odd numbers are not found, then return $\textit{False}$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{arr}$.

#### Java

```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int x : arr) {
            if (x % 2 == 1) {
                if (++cnt == 3) {
                    return true;
                }
            } else {
                cnt = 0;
            }
        }
        return false;
    }
}
```

### Solution 2: Iteration + Bitwise Operation

> **Thinking**
>
> Solution 1 tests parity one element at a time. Three numbers are all odd iff their bitwise AND has the lowest bit set. AND-ing each window of three replaces the explicit counter.

Based on the properties of bitwise operations, the result of a bitwise AND operation between two numbers is odd if and only if both numbers are odd. If there are three consecutive numbers whose bitwise AND result is odd, then these three numbers are all odd.

Therefore, we only need to iterate through the array and check if there exists three consecutive numbers whose bitwise AND result is odd. If such numbers exist, return $\textit{True}$; otherwise, return $\textit{False}$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{arr}$.

#### Java

```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 2, n = arr.length; i < n; ++i) {
            if ((arr[i - 2] & arr[i - 1] & arr[i] & 1) == 1) {
                return true;
            }
        }
        return false;
    }
}
```
