# 1572. Matrix Diagonal Sum

**Difficulty:** Easy  
**Category:** Matrices & Grids  
**LeetCode:** https://leetcode.com/problems/matrix-diagonal-sum/

---

[中文文档](/solution/1500-1599/1572.Matrix%20Diagonal%20Sum/README.md)

## Description

<p>Given a&nbsp;square&nbsp;matrix&nbsp;<code>mat</code>, return the sum of the matrix diagonals.</p>

<p>Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1500-1599/1572.Matrix%20Diagonal%20Sum/images/sample_1911.png" style="width: 336px; height: 174px;" />
<pre>
<strong>Input:</strong> mat = [[<strong>1</strong>,2,<strong>3</strong>],
&nbsp;             [4,<strong>5</strong>,6],
&nbsp;             [<strong>7</strong>,8,<strong>9</strong>]]
<strong>Output:</strong> 25
<strong>Explanation: </strong>Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> mat = [[<strong>1</strong>,1,1,<strong>1</strong>],
&nbsp;             [1,<strong>1</strong>,<strong>1</strong>,1],
&nbsp;             [1,<strong>1</strong>,<strong>1</strong>,1],
&nbsp;             [<strong>1</strong>,1,1,<strong>1</strong>]]
<strong>Output:</strong> 8
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> mat = [[<strong>5</strong>]]
<strong>Output:</strong> 5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == mat.length == mat[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= mat[i][j] &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1: Row-by-Row Traversal

> **Thinking**
>
> Sum both diagonals of a square matrix; the center of an odd order would be counted twice. $n$ is small: take the two diagonal entries per row and skip the duplicate center.
>
> Row $i$ contributes $\textit{row}[i]$ and $\textit{row}[n-i-1]$. When those indices coincide, add once; otherwise add both. A single row scan finishes the sum.

We can traverse each row $\textit{row}[i]$ of the matrix. For each row, we calculate the elements on the two diagonals, i.e., $\textit{row}[i][i]$ and $\textit{row}[i][n - i - 1]$, where $n$ is the number of rows in the matrix. If $i = n - i - 1$, it means there is only one element on the diagonals of the current row; otherwise, there are two elements. We add these elements to the answer.

After traversing all rows, we get the answer.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the number of rows in the matrix.

#### Java

```java
class Solution {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        for (int i = 0; i < n; ++i) {
            int j = n - i - 1;
            ans += mat[i][i] + (i == j ? 0 : mat[i][j]);
        }
        return ans;
    }
}
```
