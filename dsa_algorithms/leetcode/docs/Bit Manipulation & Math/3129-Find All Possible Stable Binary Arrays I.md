# 3129. Find All Possible Stable Binary Arrays I

**Difficulty:** Medium  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/

---

[中文文档](/solution/3100-3199/3129.Find%20All%20Possible%20Stable%20Binary%20Arrays%20I/README.md)

## Description

<p>You are given 3 positive integers <code>num_zeros</code>, <code>num_ones</code>, and <code>limit</code>.</p>

<p>A <span data-keyword="binary-array">binary array</span> <code>arr</code> is called <strong>stable</strong> if:</p>

<ul>
	<li>The number of occurrences of 0 in <code>arr</code> is <strong>exactly </strong><code>num_zeros</code>.</li>
	<li>The number of occurrences of 1 in <code>arr</code> is <strong>exactly</strong> <code>num_ones</code>.</li>
	<li>Each <span data-keyword="subarray-nonempty">subarray</span> of <code>arr</code> with a size greater than <code>limit</code> must contain <strong>at least</strong> one occurrence of <strong>both</strong> 0 and 1.</li>
</ul>

<p>Return an integer denoting the <em>total</em> number of <strong>stable</strong> binary arrays.</p>

<p>Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">zero = 1, one = 1, limit = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The two possible stable binary arrays are <code>[1,0]</code> and <code>[0,1]</code>, as both arrays have a single 0 and a single 1, and no subarray has a length greater than 2.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">zero = 1, one = 2, limit = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The only possible stable binary array is <code>[1,0,1]</code>.</p>

<p>Note that the binary arrays <code>[1,1,0]</code> and <code>[0,1,1]</code> have subarrays of length 2 with identical elements, hence, they are not stable.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">zero = 3, one = 3, limit = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">14</span></p>

<p><strong>Explanation:</strong></p>

<p>All the possible stable binary arrays are <code>[0,0,1,0,1,1]</code>, <code>[0,0,1,1,0,1]</code>, <code>[0,1,0,0,1,1]</code>, <code>[0,1,0,1,0,1]</code>, <code>[0,1,0,1,1,0]</code>, <code>[0,1,1,0,0,1]</code>, <code>[0,1,1,0,1,0]</code>, <code>[1,0,0,1,0,1]</code>, <code>[1,0,0,1,1,0]</code>, <code>[1,0,1,0,0,1]</code>, <code>[1,0,1,0,1,0]</code>, <code>[1,0,1,1,0,0]</code>, <code>[1,1,0,0,1,0]</code>, and <code>[1,1,0,1,0,0]</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= zero, one, limit &lt;= 200</code></li>
</ul>

## Solutions

### Solution 1: Memoized Search

> **Thinking**
>
> A stable array never has more than $\textit{limit}$ equal bits in a row. Backtracking over $\textit{zero}$ zeros and $\textit{one}$ ones explodes.
>
> Validity after a prefix depends only on remaining zeros and ones and on which bit is written next. Overflow is the case of writing $\textit{limit}+1$ equal bits after the opposite bit.
>
> Let $\textit{dfs}(i,j,k)$ be the number of ways with $i$ zeros and $j$ ones left and next bit $k$. Add the same-color and other-color transitions and subtract the overflow term. Memoization yields $O(\textit{zero} \textit{one})$ states.

We define a function $\textit{dfs}(i, j, k)$ to represent the number of stable binary arrays that satisfy the problem conditions when there are $i$ zeros and $j$ ones remaining to place, and the next digit to fill is $k$. Then the answer is $\textit{dfs}(\textit{zero}, \textit{one}, 0) + \textit{dfs}(\textit{zero}, \textit{one}, 1)$.

The computation process of $\textit{dfs}(i, j, k)$ is as follows:

- If $i \lt 0$ or $j \lt 0$, return $0$.
- If $i = 0$, then return $1$ when $k = 1$ and $j \leq \textit{limit}$; otherwise return $0$.
- If $j = 0$, then return $1$ when $k = 0$ and $i \leq \textit{limit}$; otherwise return $0$.
- If $k = 0$, we consider the case where the previous digit is $0$, i.e., $\textit{dfs}(i - 1, j, 0)$, and the case where the previous digit is $1$, i.e., $\textit{dfs}(i - 1, j, 1)$. If the previous digit is $0$, there may be more than $\textit{limit}$ zeros in a subarray, which means the case where the $(\textit{limit} + 1)$-th digit from the end is $1$ is invalid, so we subtract this case: $\textit{dfs}(i - \textit{limit} - 1, j, 1)$.
- If $k = 1$, we consider the case where the previous digit is $0$, i.e., $\textit{dfs}(i, j - 1, 0)$, and the case where the previous digit is $1$, i.e., $\textit{dfs}(i, j - 1, 1)$. If the previous digit is $1$, there may be more than $\textit{limit}$ ones in a subarray, which means the case where the $(\textit{limit} + 1)$-th digit from the end is $0$ is invalid, so we subtract this case: $\textit{dfs}(i, j - \textit{limit} - 1, 0)$.

To avoid repeated computation, we use memoized search.

The time complexity is $O(\textit{zero} \textit{one})$, and the space complexity is $O(\textit{zero} \textit{one})$.

#### Java

```java
class Solution {
    private final int mod = (int) 1e9 + 7;
    private Long[][][] f;
    private int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        f = new Long[zero + 1][one + 1][2];
        this.limit = limit;
        return (int) ((dfs(zero, one, 0) + dfs(zero, one, 1)) % mod);
    }

    private long dfs(int i, int j, int k) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0) {
            return k == 1 && j <= limit ? 1 : 0;
        }
        if (j == 0) {
            return k == 0 && i <= limit ? 1 : 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        if (k == 0) {
            f[i][j][k]
                = (dfs(i - 1, j, 0) + dfs(i - 1, j, 1) - dfs(i - limit - 1, j, 1) + mod) % mod;
        } else {
            f[i][j][k]
                = (dfs(i, j - 1, 0) + dfs(i, j - 1, 1) - dfs(i, j - limit - 1, 0) + mod) % mod;
        }
        return f[i][j][k];
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> The recurrence has no aftereffect; recursion still pays cache and call overhead near the upper limits.
>
> The same transition fills a table $f[i][j][k]$: $i$ zeros and $j$ ones used, last bit $k$.
>
> Base cases are monochrome strings no longer than $\textit{limit}$. After iterating with a modulus, read $f[\textit{zero}][\textit{one}][0]+f[\textit{zero}][\textit{one}][1]$.

We can also convert the memoized search in Solution 1 into dynamic programming.

We define $f[i][j][k]$ as the number of stable binary arrays that use $i$ zeros and $j$ ones, with the last digit being $k$. Then the answer is $f[\textit{zero}][\textit{one}][0] + f[\textit{zero}][\textit{one}][1]$.

Initially, we have $f[i][0][0] = 1$, where $1 \leq i \leq \min(\textit{limit}, \textit{zero})$; and $f[0][j][1] = 1$, where $1 \leq j \leq \min(\textit{limit}, \textit{one})$.

The state transition equations are as follows:

- $f[i][j][0] = f[i - 1][j][0] + f[i - 1][j][1] - f[i - \textit{limit} - 1][j][1]$.
- $f[i][j][1] = f[i][j - 1][0] + f[i][j - 1][1] - f[i][j - \textit{limit} - 1][0]$.

The time complexity is $O(\textit{zero} \textit{one})$, and the space complexity is $O(\textit{zero} \textit{one})$.

#### Java

```java
class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int mod = (int) 1e9 + 7;
        long[][][] f = new long[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(zero, limit); ++i) {
            f[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); ++j) {
            f[0][j][1] = 1;
        }
        for (int i = 1; i <= zero; ++i) {
            for (int j = 1; j <= one; ++j) {
                long x = i - limit - 1 < 0 ? 0 : f[i - limit - 1][j][1];
                long y = j - limit - 1 < 0 ? 0 : f[i][j - limit - 1][0];
                f[i][j][0] = (f[i - 1][j][0] + f[i - 1][j][1] - x + mod) % mod;
                f[i][j][1] = (f[i][j - 1][0] + f[i][j - 1][1] - y + mod) % mod;
            }
        }
        return (int) ((f[zero][one][0] + f[zero][one][1]) % mod);
    }
}
```
