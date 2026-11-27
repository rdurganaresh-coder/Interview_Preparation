# 1131. Maximum of Absolute Value Expression

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-of-absolute-value-expression/

---

[中文文档](/solution/1100-1199/1131.Maximum%20of%20Absolute%20Value%20Expression/README.md)

## Description

<p>Given two arrays of integers with equal lengths, return the maximum value of:</p>

<p><code>|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|</code></p>

<p>where the maximum is taken over all <code>0 &lt;= i, j &lt; arr1.length</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
<strong>Output:</strong> 13
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
<strong>Output:</strong> 20
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= arr1.length == arr2.length &lt;= 40000</code></li>
	<li><code>-10^6 &lt;= arr1[i], arr2[i] &lt;= 10^6</code></li>
</ul>

## Solutions

### Solution 1: Mathematics + Enumeration

> **Thinking**
>
> Two layers of absolute value make a double loop $O(n^2)$. Expanding $|x_i-x_j|+|y_i-y_j|+|i-j|$ yields the range of $ax+by+\textit{index}$ under four sign pairs.
>
> For each $a,b\in\{\pm 1\}$ scan once for the max and min; the answer is the largest of those ranges, in linear time.

Let's denote $x_i = \textit{arr1}[i]$, $y_i = \textit{arr2}[i]$. Since the size relationship between $i$ and $j$ does not affect the value of the expression, we can assume $i \ge j$. Then the expression can be transformed into:

$$
| x_i - x_j | + | y_i - y_j | + i - j = \max \begin{cases} (x_i + y_i) - (x_j + y_j) \\ (x_i - y_i) - (x_j - y_j) \\ (-x_i + y_i) - (-x_j + y_j) \\ (-x_i - y_i) - (-x_j - y_j) \end{cases} + i - j\\
= \max \begin{cases} (x_i + y_i + i) - (x_j + y_j + j) \\ (x_i - y_i + i) - (x_j - y_j + j) \\ (-x_i + y_i + i) - (-x_j + y_j + j) \\ (-x_i - y_i + i) - (-x_j - y_j + j) \end{cases}
$$

Therefore, we just need to find the maximum value $mx$ and the minimum value $mi$ of $a \times x_i + b \times y_i + i$, where $a, b \in \{-1, 1\}$. The answer is the maximum value among all $mx - mi$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

Similar problems:

- [1330. Reverse Subarray To Maximize Array Value](https://github.com/doocs/leetcode/blob/main/solution/1300-1399/1330.Reverse%20Subarray%20To%20Maximize%20Array%20Value/README_EN.md)

#### Java

```java
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[] dirs = {1, -1, -1, 1, 1};
        final int inf = 1 << 30;
        int ans = -inf;
        int n = arr1.length;
        for (int k = 0; k < 4; ++k) {
            int a = dirs[k], b = dirs[k + 1];
            int mx = -inf, mi = inf;
            for (int i = 0; i < n; ++i) {
                mx = Math.max(mx, a * arr1[i] + b * arr2[i] + i);
                mi = Math.min(mi, a * arr1[i] + b * arr2[i] + i);
                ans = Math.max(ans, mx - mi);
            }
        }
        return ans;
    }
}
```
