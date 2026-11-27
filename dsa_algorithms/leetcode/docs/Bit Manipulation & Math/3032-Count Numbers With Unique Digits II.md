# 3032. Count Numbers With Unique Digits II

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/count-numbers-with-unique-digits-ii/

---

[中文文档](/solution/3000-3099/3032.Count%20Numbers%20With%20Unique%20Digits%20II/README.md)

## Description

Given two <strong>positive</strong> integers <code>a</code> and <code>b</code>, return <em>the count of numbers having&nbsp;<strong>unique</strong> digits in the range</em> <code>[a, b]</code> <em>(<strong>inclusive</strong>).</em>
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> a = 1, b = 20
<strong>Output:</strong> 19
<strong>Explanation:</strong> All the numbers in the range [1, 20] have unique digits except 11. Hence, the answer is 19.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> a = 9, b = 19
<strong>Output:</strong> 10
<strong>Explanation:</strong> All the numbers in the range [9, 19] have unique digits except 11. Hence, the answer is 10. 
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> a = 80, b = 120
<strong>Output:</strong> 27
<strong>Explanation:</strong> There are 41 numbers in the range [80, 120], 27 of which have unique digits.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= a &lt;= b &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: State Compression + Digit DP

> **Thinking**
>
> We count integers in $[a,b]$ with distinct digits, i.e. $f(b)-f(a-1)$. Digit enumeration must handle leading zeros and repeats.
>
> A bit mask of used digits plus a tight flag is a standard digit DP. $b \le 1000$ keeps the state tiny.
>
> We memoize $\textit{dfs}(\textit{pos}, \textit{mask}, \textit{limit})$. Leading zeros do not occupy the mask; a zero mask means no digit has been placed yet.

The problem asks to count how many numbers in the range $[a, b]$ have unique digits. We can solve this problem using state compression and digit DP.

We can use a function $f(n)$ to count how many numbers in the range $[1, n]$ have unique digits. Then the answer is $f(b) - f(a - 1)$.

In addition, we can use a binary number to record the digits that have appeared in the number. For example, if the digits $1, 3, 5$ have appeared in the number, we can use $10101$ to represent this state.

Next, we use memoization search to implement digit DP. We search from the starting point to the bottom layer to get the number of schemes, return the answer layer by layer and accumulate it, and finally get the final answer from the search starting point.

The basic steps are as follows:

1. We convert the number $n$ into a string $\textit{num}$, where $\textit{num}[0]$ is the highest digit and $\textit{num}[\textit{len} - 1]$ is the lowest digit.
2. Based on the problem information, we design a function $\textit{dfs}(\textit{pos}, \textit{mask}, \textit{limit})$, where $\textit{pos}$ represents the current processing position, $\textit{mask}$ represents the digits that have appeared in the current number, and $\textit{limit}$ represents whether there is a limit at the current position. If $\textit{limit}$ is true, then the digit at the current position cannot exceed $\textit{num}[\textit{pos}]$.

The answer is $\textit{dfs}(0, 0, \textit{true})$.

The time complexity is $O(10m 2^{10})$, and the space complexity is $O(m 2^{10})$, where $m$ is the number of digits in $b$.

#### Java

```java
class Solution {
    private String num;
    private Integer[][] f;

    public int numberCount(int a, int b) {
        num = String.valueOf(a - 1);
        f = new Integer[num.length()][1 << 10];
        int x = dfs(0, 0, true);
        num = String.valueOf(b);
        f = new Integer[num.length()][1 << 10];
        int y = dfs(0, 0, true);
        return y - x;
    }

    private int dfs(int pos, int mask, boolean limit) {
        if (pos >= num.length()) {
            return mask > 0 ? 1 : 0;
        }
        if (!limit && f[pos][mask] != null) {
            return f[pos][mask];
        }
        int up = limit ? num.charAt(pos) - '0' : 9;
        int ans = 0;
        for (int i = 0; i <= up; ++i) {
            if ((mask >> i & 1) == 1) {
                continue;
            }
            int nxt = mask == 0 && i == 0 ? 0 : mask | 1 << i;
            ans += dfs(pos + 1, nxt, limit && i == up);
        }
        if (!limit) {
            f[pos][mask] = ans;
        }
        return ans;
    }
}
```

### Solution 2: Enumeration

> **Thinking**
>
> $a,b \le 1000$, so the digit-DP tables are unnecessary.
>
> Enumerating every integer in the range and testing digit uniqueness with a set is shorter and fast enough.

Since $1 \le a \le b \le 1000$, we can enumerate every integer in $[a, b]$ and check whether its digits are unique.

The time complexity is $O((b - a + 1) \log b)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public int numberCount(int a, int b) {
        int res = 0;
        for (int i = a; i <= b; ++i) {
            if (isValid(i)) {
                ++res;
            }
        }
        return res;
    }
    private boolean isValid(int n) {
        boolean[] present = new boolean[10];
        Arrays.fill(present, false);
        while (n > 0) {
            int dig = n % 10;
            if (present[dig]) {
                return false;
            }
            present[dig] = true;
            n /= 10;
        }
        return true;
    }
}
```
