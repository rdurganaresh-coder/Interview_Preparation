# 3351. Sum of Good Subsequences

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/sum-of-good-subsequences/

---

[中文文档](/solution/3300-3399/3351.Sum%20of%20Good%20Subsequences/README.md)

## Description

<p>You are given an integer array <code>nums</code>. A <strong>good </strong><span data-keyword="subsequence-array">subsequence</span> is defined as a subsequence of <code>nums</code> where the absolute difference between any <strong>two</strong> consecutive elements in the subsequence is <strong>exactly</strong> 1.</p>

<p>Return the <strong>sum</strong> of all <em>possible</em> <strong>good subsequences</strong> of <code>nums</code>.</p>

<p>Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p><strong>Note </strong>that a subsequence of size 1 is considered good by definition.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">14</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Good subsequences are: <code>[1]</code>, <code>[2]</code>, <code>[1]</code>, <code>[1,2]</code>, <code>[2,1]</code>, <code>[1,2,1]</code>.</li>
	<li>The sum of elements in these subsequences is 14.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,4,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">40</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Good subsequences are: <code>[3]</code>, <code>[4]</code>, <code>[5]</code>, <code>[3,4]</code>, <code>[4,5]</code>, <code>[3,4,5]</code>.</li>
	<li>The sum of elements in these subsequences is 40.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A good subsequence has consecutive absolute differences equal to $1$. With $n \le 10^5$ we cannot list subsequences; we DP on values.
>
> Let $g[x]$ be the number of good subsequences ending with $x$ and $f[x]$ their element sum. A new $x$ starts a singleton or appends to existing $x-1$ or $x+1$.
>
> Appending adds “old sum + old count $\times x$”. Updates follow input order so earlier copies of $x$ are included. The answer is the sum of all $f$, modulo $10^9+7$.

#### Java

```java
class Solution {
    public int sumOfGoodSubsequences(int[] nums) {
        final int mod = (int) 1e9 + 7;
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        long[] f = new long[mx + 1];
        long[] g = new long[mx + 1];
        for (int x : nums) {
            f[x] += x;
            g[x] += 1;
            if (x > 0) {
                f[x] = (f[x] + f[x - 1] + g[x - 1] * x % mod) % mod;
                g[x] = (g[x] + g[x - 1]) % mod;
            }
            if (x + 1 <= mx) {
                f[x] = (f[x] + f[x + 1] + g[x + 1] * x % mod) % mod;
                g[x] = (g[x] + g[x + 1]) % mod;
            }
        }
        long ans = 0;
        for (long x : f) {
            ans = (ans + x) % mod;
        }
        return (int) ans;
    }
}
```
