# 2464. Minimum Subarrays in a Valid Split

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/minimum-subarrays-in-a-valid-split/

---

[中文文档](/solution/2400-2499/2464.Minimum%20Subarrays%20in%20a%20Valid%20Split/README.md)

## Description

<p>You are given an integer array <code>nums</code>.</p>

<p>Splitting of an integer array <code>nums</code> into <strong>subarrays</strong> is <strong>valid</strong> if:</p>

<ul>
	<li>the <em>greatest common divisor</em> of the first and last elements of each subarray is <strong>greater</strong> than <code>1</code>, and</li>
	<li>each element of <code>nums</code> belongs to exactly one subarray.</li>
</ul>

<p>Return <em>the <strong>minimum</strong> number of subarrays in a <strong>valid</strong> subarray splitting of</em> <code>nums</code>. If a valid subarray splitting is not possible, return <code>-1</code>.</p>

<p><strong>Note</strong> that:</p>

<ul>
	<li>The <strong>greatest common divisor</strong> of two numbers is the largest positive integer that evenly divides both numbers.</li>
	<li>A <strong>subarray</strong> is a contiguous non-empty part of an array.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,6,3,4,3]
<strong>Output:</strong> 2
<strong>Explanation:</strong> We can create a valid split in the following way: [2,6] | [3,4,3].
- The starting element of the 1<sup>st</sup> subarray is 2 and the ending is 6. Their greatest common divisor is 2, which is greater than 1.
- The starting element of the 2<sup>nd</sup> subarray is 3 and the ending is 3. Their greatest common divisor is 3, which is greater than 1.
It can be proved that 2 is the minimum number of subarrays that we can obtain in a valid split.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,5]
<strong>Output:</strong> 2
<strong>Explanation:</strong> We can create a valid split in the following way: [3] | [5].
- The starting element of the 1<sup>st</sup> subarray is 3 and the ending is 3. Their greatest common divisor is 3, which is greater than 1.
- The starting element of the 2<sup>nd</sup> subarray is 5 and the ending is 5. Their greatest common divisor is 5, which is greater than 1.
It can be proved that 2 is the minimum number of subarrays that we can obtain in a valid split.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,1]
<strong>Output:</strong> -1
<strong>Explanation:</strong> It is impossible to create valid split.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Memoization Search

> **Thinking**
>
> A piece is valid iff the GCD of its endpoints exceeds $1$, and we want the fewest pieces. From $i$, try every right end $j$ and take $1+\textit{dfs}(j+1)$ when the GCD allows. Memoized $O(n^2)$ GCDs; return $-1$ if unbounded.

We design a function $\textit{dfs}(i)$ to represent the minimum number of partitions starting from index $i$. For index $i$, we can enumerate all partition points $j$, i.e., $i \leq j < n$, where $n$ is the length of the array. For each partition point $j$, we need to determine whether the greatest common divisor of $\textit{nums}[i]$ and $\textit{nums}[j]$ is greater than $1$. If it is greater than $1$, we can partition, and the number of partitions is $1 + \textit{dfs}(j + 1)$; otherwise, the number of partitions is $+\infty$. Finally, we take the minimum of all partition numbers.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    private int n;
    private int[] f;
    private int[] nums;
    private int inf = 0x3f3f3f3f;

    public int validSubarraySplit(int[] nums) {
        n = nums.length;
        f = new int[n];
        this.nums = nums;
        int ans = dfs(0);
        return ans < inf ? ans : -1;
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] > 0) {
            return f[i];
        }
        int ans = inf;
        for (int j = i; j < n; ++j) {
            if (gcd(nums[i], nums[j]) > 1) {
                ans = Math.min(ans, 1 + dfs(j + 1));
            }
        }
        f[i] = ans;
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> Enumerating every split is exponential. The array length reaches $1000$, and the next piece always starts strictly to the right, so a search from the left has depth $n$. A piece is valid exactly when the GCD of its endpoints is greater than $1$, so the answer from index $i$ depends only on later answers. Let $f[i]$ be the fewest pieces starting at $i$, with $f[n]=0$, and scan right endpoints from the end of the array, updating with $1+f[j+1]$ whenever $\gcd(\textit{nums}[i], \textit{nums}[j])>1$.

Let $f[i]$ be the minimum number of pieces starting at index $i$, with $f[n]=0$. For $i$ from $n-1$ down to $0$, enumerate the right endpoint $j$ ($i \leq j < n$). If $\gcd(\textit{nums}[i], \textit{nums}[j]) > 1$, the range $[i, j]$ is one valid piece, and $f[i]$ is updated with $1 + f[j + 1]$. If $f[0]$ is still infinite, no valid split exists and the answer is $-1$; otherwise the answer is $f[0]$.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int validSubarraySplit(int[] nums) {
        int n = nums.length;
        int inf = 0x3f3f3f3f;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            f[i] = inf;
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (gcd(nums[i], nums[j]) > 1) {
                    f[i] = Math.min(f[i], 1 + f[j + 1]);
                }
            }
        }
        return f[0] < inf ? f[0] : -1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```
