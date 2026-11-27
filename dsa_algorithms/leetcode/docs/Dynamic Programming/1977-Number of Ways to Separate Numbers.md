# 1977. Number of Ways to Separate Numbers

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/number-of-ways-to-separate-numbers/

---

[中文文档](/solution/1900-1999/1977.Number%20of%20Ways%20to%20Separate%20Numbers/README.md)

## Description

<p>You wrote down many <strong>positive</strong> integers in a string called <code>num</code>. However, you realized that you forgot to add commas to seperate the different numbers. You remember that the list of integers was <strong>non-decreasing</strong> and that <strong>no</strong> integer had leading zeros.</p>

<p>Return <em>the <strong>number of possible lists of integers</strong> that you could have written down to get the string </em><code>num</code>. Since the answer may be large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = &quot;327&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> You could have written down the numbers:
3, 27
327
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = &quot;094&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> No numbers can have leading zeros and all numbers must be positive.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> num = &quot;0&quot;
<strong>Output:</strong> 0
<strong>Explanation:</strong> No numbers can have leading zeros and all numbers must be positive.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num.length &lt;= 3500</code></li>
	<li><code>num</code> consists of digits <code>&#39;0&#39;</code> through <code>&#39;9&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Dynamic Programming + Prefix Sum

> **Thinking**
>
> We split the digit string into non-decreasing integers without leading zeros. Exponential cuts become an $O(n^2)$ DP for $n\le 3500$.
>
> $dp[i][j]$ is the number of ways for the first $i$ digits whose last part has length $j$. A shorter previous part is always smaller and is added via a prefix sum; equal lengths use an LCP table to compare.
>
> $dp[i][j]$ also stores that prefix, so the answer is $dp[n][n]$.

Define $dp[i][j]$ to represent the number of ways to partition the first $i$ characters of the string `num` such that the length of the last number is $j$. Clearly, the answer is $\sum_{j=0}^{n} dp[n][j]$. The initial value is $dp[0][0] = 1$.

For $dp[i][j]$, the end of the previous number should be $i-j$. We can enumerate $dp[i-j][k]$, where $k \le j$. For the part where $k < j$, i.e., the number of ways with a length less than $j$ can be directly added to $dp[i][j]$, i.e., $dp[i][j] = \sum_{k=0}^{j-1} dp[i-j][k]$. Because the previous number is shorter, it means it is smaller than the current number. Here, prefix sum can be used for optimization.

However, when $k = j$, we need to compare the sizes of the two numbers of the same length. If the previous number is larger than the current number, this situation is invalid, and we should not add it to $dp[i][j]$. Otherwise, we can add it to $dp[i][j]$. Here, we can preprocess the "longest common prefix" in $O(n^2)$ time, and then compare the sizes of two numbers of the same length in $O(1)$ time.

The time complexity is $O(n^2)$, and the space complexity is $O(n^2)$, where $n$ is the length of the string $\textit{num}$.

#### Java

```java
class Solution {
    public int numberOfCombinations(String num) {
        final int mod = (int) 1e9 + 7;
        int n = num.length();
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (num.charAt(i) == num.charAt(j)) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                }
            }
        }
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                int v = 0;
                if (num.charAt(i - j) != '0') {
                    if (i - j - j >= 0) {
                        int x = lcp[i - j][i - j - j];
                        if (x >= j || num.charAt(i - j + x) >= num.charAt(i - j - j + x)) {
                            v = dp[i - j][j];
                        }
                    }
                    if (v == 0) {
                        v = dp[i - j][Math.min(j - 1, i - j)];
                    }
                }
                dp[i][j] = (dp[i][j - 1] + v) % mod;
            }
        }
        return dp[n][n];
    }
}
```
