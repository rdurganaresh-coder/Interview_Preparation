# 1380. Lucky Numbers in a Matrix

**Difficulty:** Easy  
**Category:** Matrices & Grids  
**LeetCode:** https://leetcode.com/problems/lucky-numbers-in-a-matrix/

---

[中文文档](/solution/1300-1399/1380.Lucky%20Numbers%20in%20a%20Matrix/README.md)

## Description

<p>Given an <code>m x n</code> matrix of <strong>distinct </strong>numbers, return <em>all <strong>lucky numbers</strong> in the matrix in <strong>any </strong>order</em>.</p>

<p>A <strong>lucky number</strong> is an element of the matrix such that it is the minimum element in its row and maximum in its column.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> matrix = [[3,7,8],[9,11,13],[15,16,17]]
<strong>Output:</strong> [15]
<strong>Explanation:</strong> 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
<strong>Output:</strong> [12]
<strong>Explanation:</strong> 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> matrix = [[7,8],[1,2]]
<strong>Output:</strong> [7]
<strong>Explanation:</strong> 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 &lt;= n, m &lt;= 50</code></li>
	<li><code>1 &lt;= matrix[i][j] &lt;= 10<sup>5</sup></code>.</li>
	<li>All elements in the matrix are distinct.</li>
</ul>

## Solutions

### Solution 1: Maintain Row Minimum and Column Maximum

> **Thinking**
>
> A lucky number is the minimum of its row and the maximum of its column. All entries are distinct, so the intersection of the set of row minima and the set of column maxima is exactly the answer.

We can use two arrays $\textit{rows}$ and $\textit{cols}$ to record the minimum value of each row and the maximum value of each column in the matrix. Then, we traverse each element in the matrix, checking whether this element is the minimum value of its row and the maximum value of its column. If it is, then this element is a lucky number, and we add it to the answer array.

After the traversal is finished, we return the answer array.

The time complexity is $O(mn)$, and the space complexity is $O(m + n)$, where $m$ and $n$ are the number of rows and columns in the matrix, respectively.

#### Java

```java
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        Arrays.fill(rows, 1 << 30);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rows[i] = Math.min(rows[i], matrix[i][j]);
                cols[j] = Math.max(cols[j], matrix[i][j]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rows[i] == cols[j]) {
                    ans.add(rows[i]);
                }
            }
        }
        return ans;
    }
}
```
