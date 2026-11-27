# 3466. Maximum Coin Collection

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/maximum-coin-collection/

---

[中文文档](/solution/3400-3499/3466.Maximum%20Coin%20Collection/README.md)

## Description

<p>Mario drives on a two-lane freeway with coins every mile. You are given two integer arrays, <code>lane1</code> and <code>lane2</code>, where the value at the <code>i<sup>th</sup></code> index represents the number of coins he <em>gains or loses</em> in the <code>i<sup>th</sup></code> mile in that lane.</p>

<ul>
	<li>If Mario is in lane 1 at mile <code>i</code> and <code>lane1[i] &gt; 0</code>, Mario gains <code>lane1[i]</code> coins.</li>
	<li>If Mario is in lane 1 at mile <code>i</code> and <code>lane1[i] &lt; 0</code>, Mario pays a toll and loses <code>abs(lane1[i])</code> coins.</li>
	<li>The same rules apply for <code>lane2</code>.</li>
</ul>

<p>Mario can enter the freeway anywhere and exit anytime after traveling <strong>at least</strong> one mile. Mario always enters the freeway on lane 1 but can switch lanes <strong>at most</strong> 2 times.</p>

<p>A <strong>lane switch</strong> is when Mario goes from lane 1 to lane 2 or vice versa.</p>

<p>Return the <strong>maximum</strong> number of coins Mario can earn after performing <strong>at most 2 lane switches</strong>.</p>

<p><strong>Note:</strong> Mario can switch lanes immediately upon entering or just before exiting the freeway.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">lane1 = [1,-2,-10,3], lane2 = [-5,10,0,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">14</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Mario drives the first mile on lane 1.</li>
	<li>He then changes to lane 2 and drives for two miles.</li>
	<li>He changes back to lane 1 for the last mile.</li>
</ul>

<p>Mario collects <code>1 + 10 + 0 + 3 = 14</code> coins.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">lane1 = [1,-1,-1,-1], lane2 = [0,3,4,-5]</span></p>

<p><strong>Output:</strong> <span class="example-io">8</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Mario starts at mile 0 in lane 1 and drives one mile.</li>
	<li>He then changes to lane 2 and drives for two more miles. He exits the freeway before mile 3.</li>
</ul>

<p>He collects <code>1 + 3 + 4 = 8</code> coins.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">lane1 = [-5,-4,-3], lane2 = [-1,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Mario enters at mile 1 and immediately switches to lane 2. He stays here the entire way.</li>
</ul>

<p>He collects a total of <code>2 + 3 = 5</code> coins.</p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">lane1 = [-3,-3,-3], lane2 = [9,-2,4]</span></p>

<p><strong>Output:</strong> 11</p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Mario starts at the beginning of the freeway and immediately switches to lane 2. He stays here the whole way.</li>
</ul>

<p>He collects a total of <code>9 + (-2) + 4 = 11</code> coins.</p>
</div>

<p><strong class="example">Example 5:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">lane1 = [-10], lane2 = [-2]</span></p>

<p><strong>Output:</strong> <span class="example-io">-2</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Since Mario must ride on the freeway for at least one mile, he rides just one mile in lane 2.</li>
</ul>

<p>He collects a total of -2 coins.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= lane1.length == lane2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= lane1[i], lane2[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Memoized Search

> **Thinking**
>
> Two lanes, at most two switches, start anywhere and exit anytime. $n\le 10^5$ forbids listing paths.
>
> A state stores the index, the lane, and remaining switches. The start index is enumerated outside so “not yet entered” is not a state.
>
> $\textit{dfs}(i,j,k)$ may stop here, continue on the same lane, or spend a switch (after a step or in place). The answer is the max of $\textit{dfs}(i,0,2)$ over starts.

We design a function $\textit{dfs}(i, j, k)$, which represents the maximum number of coins Mario can collect starting from position $i$, currently on lane $j$, with $k$ lane changes remaining. The answer is the maximum value of $\textit{dfs}(i, 0, 2)$ for all $i$.

The function $\textit{dfs}(i, j, k)$ is calculated as follows:

- If $i \geq n$, it means Mario has reached the end, return 0;
- If no lane change is made, Mario can drive 1 mile, then exit, or continue driving, taking the maximum of the two, i.e., $\max(x, \textit{dfs}(i + 1, j, k) + x)$;
- If a lane change is possible, there are two choices: drive 1 mile and then change lanes, or change lanes directly, taking the maximum of these two cases, i.e., $\max(\textit{dfs}(i + 1, j \oplus 1, k - 1) + x, \textit{dfs}(i, j \oplus 1, k - 1))$.
- Where $x$ represents the number of coins at the current position.

To avoid repeated calculations, we use memoized search to store the results that have already been computed.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ represents the length of the lanes.

#### Java

```java
class Solution {
    private int n;
    private int[] lane1;
    private int[] lane2;
    private Long[][][] f;

    public long maxCoins(int[] lane1, int[] lane2) {
        n = lane1.length;
        this.lane1 = lane1;
        this.lane2 = lane2;
        f = new Long[n][2][3];
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, dfs(i, 0, 2));
        }
        return ans;
    }

    private long dfs(int i, int j, int k) {
        if (i >= n) {
            return 0;
        }
        if (f[i][j][k] != null) {
            return f[i][j][k];
        }
        int x = j == 0 ? lane1[i] : lane2[i];
        long ans = Math.max(x, dfs(i + 1, j, k) + x);
        if (k > 0) {
            ans = Math.max(ans, dfs(i + 1, j ^ 1, k - 1) + x);
            ans = Math.max(ans, dfs(i, j ^ 1, k - 1));
        }
        return f[i][j][k] = ans;
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> Two lanes, at most two switches, start anywhere and exit anytime. $n\le 10^5$ forbids listing paths.
>
> A state is the mile, the lane, and the switches still left. Continuing always calls the next mile first, so the chain has depth $n$ and overflows the stack.
>
> The next mile and a smaller switch budget are known if we walk backward and fill the switch count from $0$ to $2$. Let $f[i][j][k]$ be the best score from mile $i$ on lane $j$ with $k$ switches left. The answer is the maximum of $f[i][0][2]$.

Let $f[i][j][k]$ be the maximum number of coins starting at mile $i$ on lane $j$ with $k$ lane changes left. Set $f[n][j][k] = 0$. The answer is the maximum of $f[i][0][2]$ over every start $i$.

Fill $i$ from $n - 1$ down to $0$. For each mile, fill $k$ from $0$ to $2$ and then both lanes. Let $x$ be the coins on lane $j$ at mile $i$. Mario may stop after this mile or stay on the same lane, which is $\max(x, f[i + 1][j][k] + x)$. When $k > 0$, he may also drive one mile and then switch, or switch in place before driving:

$$
\max(f[i + 1][j \oplus 1][k - 1] + x,\ f[i][j \oplus 1][k - 1])
$$

The in-place switch reads $k - 1$ at the same mile, which is already filled.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ represents the length of the lanes.

#### Java

```java
class Solution {
    public long maxCoins(int[] lane1, int[] lane2) {
        int n = lane1.length;
        long[][][] f = new long[n + 1][2][3];
        for (int i = n - 1; i >= 0; --i) {
            for (int k = 0; k < 3; ++k) {
                for (int j = 0; j < 2; ++j) {
                    long x = j == 0 ? lane1[i] : lane2[i];
                    long ans = Math.max(x, f[i + 1][j][k] + x);
                    if (k > 0) {
                        ans = Math.max(ans, f[i + 1][j ^ 1][k - 1] + x);
                        ans = Math.max(ans, f[i][j ^ 1][k - 1]);
                    }
                    f[i][j][k] = ans;
                }
            }
        }
        long ans = f[0][0][2];
        for (int i = 1; i < n; ++i) {
            ans = Math.max(ans, f[i][0][2]);
        }
        return ans;
    }
}
```
