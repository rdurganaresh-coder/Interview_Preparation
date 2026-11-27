# 1067. Digit Count in Range

**Difficulty:** Hard  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/digit-count-in-range/

---

[中文文档](/solution/1000-1099/1067.Digit%20Count%20in%20Range/README.md)

## Description

<p>Given a single-digit integer <code>d</code> and two integers <code>low</code> and <code>high</code>, return <em>the number of times that </em><code>d</code><em> occurs as a digit in all integers in the inclusive range </em><code>[low, high]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> d = 1, low = 1, high = 13
<strong>Output:</strong> 6
<strong>Explanation:</strong> The digit d = 1 occurs 6 times in 1, 10, 11, 12, 13.
Note that the digit d = 1 occurs twice in the number 11.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> d = 3, low = 100, high = 250
<strong>Output:</strong> 35
<strong>Explanation:</strong> The digit d = 3 occurs 35 times in 103,113,123,130,131,...,238,239,243.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= d &lt;= 9</code></li>
	<li><code>1 &lt;= low &lt;= high &lt;= 2 * 10<sup>8</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Counting digit $d$ on $[\textit{low},\textit{high}]$ cannot enumerate values up to $2\times 10^8$. The range is $f(\textit{high})-f(\textit{low}-1)$, where $f(n)$ counts occurrences in $1..n$.
>
> Digit DP tracks how many times $d$ is already used, leading zeros, and the upper bound. Leading zeros must not count a $0$ when $d=0$.
>
> Split $n$ into digits and memoize $\textit{dfs}(\textit{pos},\textit{cnt},\textit{lead},\textit{limit})$.

#### Java

```java
class Solution {
    private int d;
    private int[] a = new int[11];
    private int[][] dp = new int[11][11];

    public int digitsCount(int d, int low, int high) {
        this.d = d;
        return f(high) - f(low - 1);
    }

    private int f(int n) {
        for (var e : dp) {
            Arrays.fill(e, -1);
        }
        int len = 0;
        while (n > 0) {
            a[++len] = n % 10;
            n /= 10;
        }
        return dfs(len, 0, true, true);
    }

    private int dfs(int pos, int cnt, boolean lead, boolean limit) {
        if (pos <= 0) {
            return cnt;
        }
        if (!lead && !limit && dp[pos][cnt] != -1) {
            return dp[pos][cnt];
        }
        int up = limit ? a[pos] : 9;
        int ans = 0;
        for (int i = 0; i <= up; ++i) {
            if (i == 0 && lead) {
                ans += dfs(pos - 1, cnt, lead, limit && i == up);
            } else {
                ans += dfs(pos - 1, cnt + (i == d ? 1 : 0), false, limit && i == up);
            }
        }
        if (!lead && !limit) {
            dp[pos][cnt] = ans;
        }
        return ans;
    }
}
```
