# 1230. Toss Strange Coins

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/toss-strange-coins/

---

[中文文档](/solution/1200-1299/1230.Toss%20Strange%20Coins/README.md)

## Description

<p>You have some coins.&nbsp; The <code>i</code>-th&nbsp;coin has a probability&nbsp;<code>prob[i]</code> of facing heads when tossed.</p>

<p>Return the probability that the number of coins facing heads equals <code>target</code> if you toss every coin exactly once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> prob = [0.4], target = 1
<strong>Output:</strong> 0.40000
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> prob = [0.5,0.5,0.5,0.5,0.5], target = 0
<strong>Output:</strong> 0.03125
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prob.length &lt;= 1000</code></li>
	<li><code>0 &lt;= prob[i] &lt;= 1</code></li>
	<li><code>0 &lt;= target&nbsp;</code><code>&lt;= prob.length</code></li>
	<li>Answers will be accepted as correct if they are within <code>10^-5</code> of the correct answer.</li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> Coins have distinct heads probabilities; we want exactly $\textit{target}$ heads. $n \le 1000$ rules out subset enumeration. The probability of $j$ heads among the first $i$ coins depends only on the first $i-1$: tails keeps $j$, heads comes from $j-1$.
>
> Let $f[i][j]$ be that probability, with $f[0][0]=1$. Filling in coin order yields $f[n][\textit{target}]$. The table unrolls the convolution of independent trials.

Let $f[i][j]$ represent the probability of having $j$ coins facing up in the first $i$ coins, and initially $f[0][0]=1$. The answer is $f[n][\textit{target}]$.

Consider $f[i][j]$, where $i \geq 1$. If the current coin is facing down, then $f[i][j] = (1 - p) \times f[i - 1][j]$; If the current coin is facing up and $j \gt 0$, then $f[i][j] = p \times f[i - 1][j - 1]$. Therefore, the state transition equation is:

$$
f[i][j] = \begin{cases}
(1 - p) \times f[i - 1][j], & j = 0 \\
(1 - p) \times f[i - 1][j] + p \times f[i - 1][j - 1], & j \gt 0
\end{cases}
$$

where $p$ represents the probability of the $i$-th coin facing up.

The time complexity is $O(n \textit{target})$, and the space complexity is $O(n \textit{target})$, where $n$ is the number of coins.

#### Java

```java
class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] f = new double[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= Math.min(i, target); ++j) {
                f[i][j] = (1 - prob[i - 1]) * f[i - 1][j];
                if (j > 0) {
                    f[i][j] += prob[i - 1] * f[i - 1][j - 1];
                }
            }
        }
        return f[n][target];
    }
}
```

### Solution 2: Dynamic Programming (Space Optimization)

> **Thinking**
>
> In Solution 1, row $i$ reads only the previous row. A one-dimensional array updated from large $j$ to small avoids overwriting $f[j-1]$ still needed for the heads transition. Space becomes $O(\textit{target})$; the recurrence is unchanged.

$f[i][j]$ depends only on the previous row. Update $j$ from large to small so the space complexity becomes $O(\textit{target})$.

#### Java

```java
class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        double[] f = new double[target + 1];
        f[0] = 1;
        for (double p : prob) {
            for (int j = target; j >= 0; --j) {
                f[j] *= (1 - p);
                if (j > 0) {
                    f[j] += p * f[j - 1];
                }
            }
        }
        return f[target];
    }
}
```
