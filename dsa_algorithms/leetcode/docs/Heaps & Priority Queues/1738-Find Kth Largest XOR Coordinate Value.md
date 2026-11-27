# 1738. Find Kth Largest XOR Coordinate Value

**Difficulty:** Medium  
**Category:** Heaps & Priority Queues  
**LeetCode:** https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/

---

[中文文档](/solution/1700-1799/1738.Find%20Kth%20Largest%20XOR%20Coordinate%20Value/README.md)

## Description

<p>You are given a 2D <code>matrix</code> of size <code>m x n</code>, consisting of non-negative integers. You are also given an integer <code>k</code>.</p>

<p>The <strong>value</strong> of coordinate <code>(a, b)</code> of the matrix is the XOR of all <code>matrix[i][j]</code> where <code>0 &lt;= i &lt;= a &lt; m</code> and <code>0 &lt;= j &lt;= b &lt; n</code> <strong>(0-indexed)</strong>.</p>

<p>Find the <code>k<sup>th</sup></code> largest value <strong>(1-indexed)</strong> of all the coordinates of <code>matrix</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> matrix = [[5,2],[1,6]], k = 1
<strong>Output:</strong> 7
<strong>Explanation:</strong> The value of coordinate (0,1) is 5 XOR 2 = 7, which is the largest value.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> matrix = [[5,2],[1,6]], k = 2
<strong>Output:</strong> 5
<strong>Explanation:</strong> The value of coordinate (0,0) is 5 = 5, which is the 2nd largest value.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> matrix = [[5,2],[1,6]], k = 3
<strong>Output:</strong> 4
<strong>Explanation:</strong> The value of coordinate (1,0) is 5 XOR 1 = 4, which is the 3rd largest value.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 1000</code></li>
	<li><code>0 &lt;= matrix[i][j] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= k &lt;= m * n</code></li>
</ul>

## Solutions

### Solution 1: Two-dimensional Prefix XOR + Sorting or Quick Selection

> **Thinking**
>
> The value at $(i,j)$ is the XOR of the prefix rectangle. Recomputing each rectangle is $O(m^2n^2)$ and fails for $m,n\le 1000$.
>
> 2D prefix XOR obeys $s[i][j]=s[i-1][j]\oplus s[i][j-1]\oplus s[i-1][j-1]\oplus \textit{matrix}[i-1][j-1]$, so all values are listed in $O(mn)$.
>
> Select the $k$-th largest from that list by sorting or a heap.

We define a two-dimensional prefix XOR array $s$, where $s[i][j]$ represents the XOR result of the elements in the first $i$ rows and the first $j$ columns of the matrix, i.e.,

$$
s[i][j] = \bigoplus_{0 \leq x \leq i, 0 \leq y \leq j} \textit{matrix}[x][y]
$$

And $s[i][j]$ can be calculated from the three elements $s[i - 1][j]$, $s[i][j - 1]$ and $s[i - 1][j - 1]$, i.e.,

$$
s[i][j] = s[i - 1][j] \oplus s[i][j - 1] \oplus s[i - 1][j - 1] \oplus \textit{matrix}[i - 1][j - 1]
$$

We traverse the matrix, calculate all $s[i][j]$, then sort them, and finally return the $k$th largest element. If you don't want to use sorting, you can also use the quick selection algorithm, which can optimize the time complexity.

The time complexity is $O(mn \log (mn))$ or $O(mn)$, and the space complexity is $O(mn)$, where $m$ and $n$ are the number of rows and columns of the matrix, respectively.

#### Java

```java
class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] s = new int[m + 1][n + 1];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                s[i + 1][j + 1] = s[i + 1][j] ^ s[i][j + 1] ^ s[i][j] ^ matrix[i][j];
                ans.add(s[i + 1][j + 1]);
            }
        }
        Collections.sort(ans);
        return ans.get(ans.size() - k);
    }
}
```
