# 2601. Prime Subtraction Operation

**Difficulty:** Medium  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/prime-subtraction-operation/

---

[中文文档](/solution/2600-2699/2601.Prime%20Subtraction%20Operation/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> of length <code>n</code>.</p>

<p>You can perform the following operation as many times as you want:</p>

<ul>
	<li>Pick an index <code>i</code> that you haven&rsquo;t picked before, and pick a prime <code>p</code> <strong>strictly less than</strong> <code>nums[i]</code>, then subtract <code>p</code> from <code>nums[i]</code>.</li>
</ul>

<p>Return <em>true if you can make <code>nums</code> a strictly increasing array using the above operation and false otherwise.</em></p>

<p>A <strong>strictly increasing array</strong> is an array whose each element is strictly greater than its preceding element.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,9,6,10]
<strong>Output:</strong> true
<strong>Explanation:</strong> In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
After the second operation, nums is sorted in strictly increasing order, so the answer is true.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [6,8,11,12]
<strong>Output:</strong> true
<strong>Explanation: </strong>Initially nums is sorted in strictly increasing order, so we don&#39;t need to make any operations.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,8,3]
<strong>Output:</strong> false
<strong>Explanation:</strong> It can be proven that there is no way to perform operations to make nums sorted in strictly increasing order, so the answer is false.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code><font face="monospace">nums.length == n</font></code></li>
</ul>

## Solutions

### Solution 1: Preprocessing prime numbers + binary search

> **Thinking**
>
> Each index may subtract a prime at most once, and the array must become strictly increasing. Greedy left-to-right may compress a value too far for later positions. Enumerating primes at every index is feasible for $n \le 1000$ and values at most $1000$, but the scan direction still matters.
>
> The rightmost value $\textit{nums}[n-1]$ is freer when larger, so we process from right to left. When $\textit{nums}[i] \ge \textit{nums}[i+1]$, we must subtract a prime strictly larger than $\textit{nums}[i]-\textit{nums}[i+1]$ and smaller than $\textit{nums}[i]$, taking the smallest such prime so the left side keeps as much room as possible.
>
> We therefore sieve primes up to $1000$ into $p$ and binary-search the least prime above that lower bound. If none exists, the array cannot be made strictly increasing.

We first preprocess all the primes within $1000$ and record them in the array $p$.

For each element $\textit{nums}[i]$ in the array $\textit{nums}$, we need to find a prime $p[j]$ such that $p[j] \gt \textit{nums}[i] - \textit{nums}[i + 1]$ and $p[j]$ is as small as possible. If there is no such prime, it means that it cannot be strictly increased by subtraction operations, return `false`. If there is such a prime, we will subtract $p[j]$ from $\textit{nums}[i]$ and continue to process the next element.

If all the elements in $\textit{nums}$ are processed, it means that it can be strictly increased by subtraction operations, return `true`.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public boolean primeSubOperation(int[] nums) {
        List<Integer> p = new ArrayList<>();
        for (int i = 2; i <= 1000; ++i) {
            boolean ok = true;
            for (int j : p) {
                if (i % j == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                p.add(i);
            }
        }
        int n = nums.length;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            int j = search(p, nums[i] - nums[i + 1]);
            if (j == p.size() || p.get(j) >= nums[i]) {
                return false;
            }
            nums[i] -= p.get(j);
        }
        return true;
    }

    private int search(List<Integer> nums, int x) {
        int l = 0, r = nums.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums.get(mid) > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```

### Solution 2: Preprocessing prime numbers

> **Thinking**
>
> Solution 1 binary-searches the prime table each time. With values at most $1000$, we can index directly: let $p[x]$ be the least prime that is at least $x$. The lower bound $\textit{nums}[i]-\textit{nums}[i+1]$ then becomes a single array access, removing the search.
>
> The rest is unchanged: still right-to-left, still subtracting that smallest prime.
