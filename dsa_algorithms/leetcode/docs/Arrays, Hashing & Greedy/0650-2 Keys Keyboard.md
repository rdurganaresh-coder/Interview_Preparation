# 650. 2 Keys Keyboard

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/2-keys-keyboard/

---

[中文文档](/solution/0600-0699/0650.2%20Keys%20Keyboard/README.md)

## Description

<p>There is only one character <code>&#39;A&#39;</code> on the screen of a notepad. You can perform one of two operations on this notepad for each step:</p>

<ul>
	<li>Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).</li>
	<li>Paste: You can paste the characters which are copied last time.</li>
</ul>

<p>Given an integer <code>n</code>, return <em>the minimum number of operations to get the character</em> <code>&#39;A&#39;</code> <em>exactly</em> <code>n</code> <em>times on the screen</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> Initially, we have one character &#39;A&#39;.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get &#39;AA&#39;.
In step 3, we use Paste operation to get &#39;AAA&#39;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Memoization Search

> **Thinking**
>
> Start from one `A` and reach $n$ by copy and paste. The search tree of sequences is wide.
>
> If the last step pastes a block of length $n/j$ into $j$ copies, $\textit{dfs}(n)=\min(\textit{dfs}(n/j)+j)$. Memoize over factors; $n=1$ costs $0$.

#### Java

```java
class Solution {
    private int[] f;

    public int minSteps(int n) {
        f = new int[n + 1];
        Arrays.fill(f, -1);
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 1) {
            return 0;
        }
        if (f[n] != -1) {
            return f[n];
        }
        int ans = n;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                ans = Math.min(ans, dfs(n / i) + i);
            }
        }
        f[n] = ans;
        return ans;
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> Memoization is top-down. The same recurrences fill $dp[i]$ bottom-up over factors, without recursion.

#### Java

```java
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            dp[i] = i;
        }
        dp[1] = 0;
        for (int i = 2; i < n + 1; ++i) {
            for (int j = 2; j * j <= i; ++j) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }
}
```

### Solution 3: Math

> **Thinking**
>
> The optimum equals the sum of prime factors of $n$: factor $i$ is one copy plus $i-1$ pastes. Factorize $n$ and skip the DP table.

Factorize $n$; each prime factor $i$ costs $i$ operations.

#### Java

```java
class Solution {
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; n > 1; ++i) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
}
```
