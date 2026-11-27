# 3336. Find the Number of Subsequences With Equal GCD

**Difficulty:** Hard  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/

---

[中文文档](/solution/3300-3399/3336.Find%20the%20Number%20of%20Subsequences%20With%20Equal%20GCD/README.md)

## Description

<p>You are given an integer array <code>nums</code>.</p>

<p>Your task is to find the number of pairs of <strong>non-empty</strong> <span data-keyword="subsequence-array">subsequences</span> <code>(seq1, seq2)</code> of <code>nums</code> that satisfy the following conditions:</p>

<ul>
	<li>The subsequences <code>seq1</code> and <code>seq2</code> are <strong>disjoint</strong>, meaning <strong>no index</strong> of <code>nums</code> is common between them.</li>
	<li>The <span data-keyword="gcd-function">GCD</span> of the elements of <code>seq1</code> is equal to the GCD of the elements of <code>seq2</code>.</li>
</ul>

<p>Return the total number of such pairs.</p>

<p>Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">10</span></p>

<p><strong>Explanation:</strong></p>

<p>The subsequence pairs which have the GCD of their elements equal to 1 are:</p>

<ul>
	<li><code>([<strong><u>1</u></strong>, 2, 3, 4], [1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4])</code></li>
	<li><code>([<strong><u>1</u></strong>, 2, 3, 4], [1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, <strong><u>4</u></strong>])</code></li>
	<li><code>([<strong><u>1</u></strong>, 2, 3, 4], [1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>])</code></li>
	<li><code>([<strong><u>1</u></strong>, <strong><u>2</u></strong>, 3, 4], [1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>])</code></li>
	<li><code>([<strong><u>1</u></strong>, 2, 3, <strong><u>4</u></strong>], [1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4])</code></li>
	<li><code>([1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4], [<strong><u>1</u></strong>, 2, 3, 4])</code></li>
	<li><code>([1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, 4], [<strong><u>1</u></strong>, 2, 3, <strong><u>4</u></strong>])</code></li>
	<li><code>([1, <strong><u>2</u></strong>, <strong><u>3</u></strong>, <strong><u>4</u></strong>], [<strong><u>1</u></strong>, 2, 3, 4])</code></li>
	<li><code>([1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>], [<strong><u>1</u></strong>, 2, 3, 4])</code></li>
	<li><code>([1, 2, <strong><u>3</u></strong>, <strong><u>4</u></strong>], [<strong><u>1</u></strong>, <strong><u>2</u></strong>, 3, 4])</code></li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [10,20,30]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The subsequence pairs which have the GCD of their elements equal to 10 are:</p>

<ul>
	<li><code>([<strong><u>10</u></strong>, 20, 30], [10, <strong><u>20</u></strong>, <strong><u>30</u></strong>])</code></li>
	<li><code>([10, <strong><u>20</u></strong>, <strong><u>30</u></strong>], [<strong><u>10</u></strong>, 20, 30])</code></li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,1,1,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">50</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 200</code></li>
</ul>

## Solutions

### Solution 1: Memoization

> **Thinking**
>
> We count pairs of disjoint subsequences with equal GCD. With $n,M \le 200$, memoizing on index and the two running GCDs has about $n M^2$ states.
>
> Each value is skipped, folded into the first GCD, or folded into the second; an empty subsequence has GCD $0$.
>
> A finished state is valid when the two GCDs are equal. The initial call includes two empty subsequences, so we subtract $1$ before reducing modulo $10^9+7$.

We define a function $\textit{dfs}(i, j, k)$ as the number of ways when considering elements with indices $0 \sim i$, where the current GCD of the first subsequence is $j$ and that of the second subsequence is $k$. By convention, the GCD of an empty subsequence is $0$, and $\gcd(x, 0) = x$.

For the element at index $i$, there are three choices:

1. Skip it: transition to $\textit{dfs}(i - 1, j, k)$;
2. Put it into the first subsequence: transition to $\textit{dfs}(i - 1, \gcd(\textit{nums}[i], j), k)$;
3. Put it into the second subsequence: transition to $\textit{dfs}(i - 1, j, \gcd(\textit{nums}[i], k))$.

Base case: when $i \lt 0$, return $1$ if $j = k$, otherwise return $0$.

The initial call $\textit{dfs}(n - 1, 0, 0)$ counts all pairs with equal GCDs, including the case where both subsequences are empty. Therefore, we subtract $1$ and take the result modulo $10^9 + 7$.

The time complexity is $O(nm^2 \log m)$, and the space complexity is $O(nm^2)$, where $n$ is the length of the array and $m$ is the maximum value in the array.

#### Java

```java
class Solution {
    private int[] nums;
    private Integer[][][] f;
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        int m = 0;
        for (int x : nums) {
            if (x > m) m = x;
        }
        this.f = new Integer[n + 1][m + 1][m + 1];
        return (dfs(n, 0, 0) - 1 + MOD) % MOD;
    }

    private int dfs(int i, int j, int k) {
        if (i == 0) {
            return j == k ? 1 : 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        int x = nums[i - 1];
        int res = ((dfs(i - 1, j, k) + dfs(i - 1, gcd(x, j), k)) % MOD + dfs(i - 1, j, gcd(x, k)))
            % MOD;
        f[i][j][k] = res;
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> The memoized recursion pays for call depth and a three-dimensional cache. The same transitions fit a rolling table: a new $g$ receives the three choices for $x$.
>
> Space drops from $O(n M^2)$ to $O(M^2)$ and there is no recursion. The answer is still the diagonal sum minus one.
>
> Skipping zero cells in $f$ further reduces the practical constant.

We can convert the memoization in Solution 1 into an iterative DP.

Define $f[j][k]$ as the number of ways after processing the current elements such that the GCD of the first subsequence is $j$ and that of the second is $k$. Initially, $f[0][0] = 1$.

For each element $x$, transfer into a new array $g$:

$$
\begin{aligned}
g[j][k] &\mathrel{+}= f[j][k], \\
g[\gcd(j, x)][k] &\mathrel{+}= f[j][k], \\
g[j][\gcd(k, x)] &\mathrel{+}= f[j][k].
\end{aligned}
$$

These correspond to skipping $x$, putting $x$ into the first subsequence, and putting $x$ into the second subsequence, respectively. After processing all elements, the answer is $\sum_{i=0}^{m} f[i][i] - 1$, taken modulo $10^9 + 7$.

The time complexity is $O(nm^2 \log m)$, and the space complexity is $O(m^2)$, where $n$ is the length of the array and $m$ is the maximum value in the array.

#### Java

```java
class Solution {
    public int subsequencePairCount(int[] nums) {
        final int MOD = 1_000_000_007;
        int m = 0;
        for (int x : nums) {
            m = Math.max(m, x);
        }
        int[][] f = new int[m + 1][m + 1];
        f[0][0] = 1;
        for (int x : nums) {
            int[][] g = new int[m + 1][m + 1];
            for (int j = 0; j <= m; ++j) {
                for (int k = 0; k <= m; ++k) {
                    if (f[j][k] == 0) {
                        continue;
                    }
                    int v = f[j][k];
                    g[j][k] = (g[j][k] + v) % MOD;
                    int gj = gcd(j, x), gk = gcd(k, x);
                    g[gj][k] = (g[gj][k] + v) % MOD;
                    g[j][gk] = (g[j][gk] + v) % MOD;
                }
            }
            f = g;
        }
        long ans = 0;
        for (int i = 0; i <= m; ++i) {
            ans += f[i][i];
        }
        return (int) ((ans - 1 + MOD) % MOD);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```
