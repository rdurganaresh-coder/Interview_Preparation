# 1183. Maximum Number of Ones

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-number-of-ones/

---

[中文文档](/solution/1100-1199/1183.Maximum%20Number%20of%20Ones/README.md)

## Description

<p>Consider a matrix <code>M</code> with dimensions <code>width * height</code>, such that every cell has value <code>0</code>&nbsp;or <code>1</code>, and any <strong>square</strong>&nbsp;sub-matrix of <code>M</code> of size <code>sideLength * sideLength</code>&nbsp;has at most <code>maxOnes</code>&nbsp;ones.</p>

<p>Return the maximum possible number of ones that the matrix <code>M</code> can have.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> width = 3, height = 3, sideLength = 2, maxOnes = 1
<strong>Output:</strong> 4
<strong>Explanation:</strong>
In a 3*3 matrix, no 2*2 sub-matrix can have more than 1 one.
The best solution that has 4 ones is:
[1,0,1]
[0,0,0]
[1,0,1]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> width = 3, height = 3, sideLength = 2, maxOnes = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong>
[1,0,1]
[1,0,1]
[1,0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= width, height &lt;= 100</code></li>
	<li><code>1 &lt;= sideLength &lt;= width, height</code></li>
	<li><code>0 &lt;= maxOnes &lt;= sideLength * sideLength</code></li>
</ul>

## Solutions

### Solution 1: Count Equivalent Positions

> **Thinking**
>
> The matrix tiles a $\textit{sideLength}\times \textit{sideLength}$ motif that holds at most $\textit{maxOnes}$ ones. Cell $(i,j)$ is tied to $(i\bmod x,j\bmod x)$; that residual's frequency is the payoff of placing a one there. Count the $x^2$ residuals and sum the largest $\textit{maxOnes}$.

For convenience, let's denote $x = \textit{sideLength}$.

Consider a $x \times x$ square, we need to select at most $\textit{maxOnes}$ points inside the square and set them to 1. Note that when the point at coordinate $(i, j)$ is selected, all points at coordinates $(i\pm k_1 \times x, j\pm k_2 \times x)$ can be equivalently set to 1. Therefore, we calculate the number of equivalent positions of the coordinate $(i, j)$ in the matrix, and select the top $\textit{maxOnes}$ with the most quantities.

The time complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns of the matrix, respectively.

#### Java

```java
class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int x = sideLength;
        int[] cnt = new int[x * x];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                int k = (i % x) * x + (j % x);
                ++cnt[k];
            }
        }
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 0; i < maxOnes; ++i) {
            ans += cnt[cnt.length - i - 1];
        }
        return ans;
    }
}
```
