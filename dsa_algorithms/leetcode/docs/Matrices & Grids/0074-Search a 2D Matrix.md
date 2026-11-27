# 74. Search a 2D Matrix

**Difficulty:** Medium  
**Category:** Matrices & Grids  
**LeetCode:** https://leetcode.com/problems/search-a-2d-matrix/

---

[中文文档](/solution/0000-0099/0074.Search%20a%202D%20Matrix/README.md)

## Description

<p>You are given an <code>m x n</code> integer matrix <code>matrix</code> with the following two properties:</p>

<ul>
	<li>Each row is sorted in non-decreasing order.</li>
	<li>The first integer of each row is greater than the last integer of the previous row.</li>
</ul>

<p>Given an integer <code>target</code>, return <code>true</code> <em>if</em> <code>target</code> <em>is in</em> <code>matrix</code> <em>or</em> <code>false</code> <em>otherwise</em>.</p>

<p>You must write a solution in <code>O(log(m * n))</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0074.Search%20a%202D%20Matrix/images/mat.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0074.Search%20a%202D%20Matrix/images/mat2.jpg" style="width: 322px; height: 242px;" />
<pre>
<strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>-10<sup>4</sup> &lt;= matrix[i][j], target &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Binary Search

> **Thinking**
>
> A full scan is $O(mn)$. $m,n \le 100$ would pass, but the problem asks for $O(\log(mn))$.
>
> Two dimensions hide a single binary search. Each row increases, and the last of row $i$ is less than the first of row $i+1$, so concatenating rows is a sorted array of length $mn$. Logical index $\textit{mid}$ maps to $\textit{matrix}[\lfloor \textit{mid}/n\rfloor][\textit{mid} \bmod n]$, so we binary-search $[0,mn-1]$ without materializing the flatten.

We can logically unfold the two-dimensional matrix and then perform binary search.

The time complexity is $O(\log(mn))$, and the space complexity is $O(1)$, where $m$ and $n$ are the number of rows and columns of the matrix, respectively.

#### Java

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int x = mid / n, y = mid % n;
            if (matrix[x][y] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return matrix[left / n][left % n] == target;
    }
}
```

### Solution 2: Search from the Bottom Left or Top Right

> **Thinking**
>
> Method 1 flattens the matrix and binary-searches, which is $O(\log(mn))$, but it maps $\textit{mid}$ to coordinates and needs the last of one row to be less than the first of the next. Without that index map, row/column monotonicity lets a corner walk drop a whole row or column per comparison. The code is simpler; the cost is $O(m+n)$ time.

Here, we start searching from the bottom left corner and move towards the top right direction. We compare the current element $\textit{matrix}[i][j]$ with $\textit{target}$:

- If $\textit{matrix}[i][j] = \textit{target}$, we have found the target value and return `true`.
- If $\textit{matrix}[i][j] > \textit{target}$, all elements to the right of the current position in this row are greater than target, so we should move the pointer $i$ upwards, i.e., $i = i - 1$.
- If $\textit{matrix}[i][j] < \textit{target}$, all elements above the current position in this column are less than target, so we should move the pointer $j$ to the right, i.e., $j = j + 1$.

If we still can't find $\textit{target}$ after the search, return `false`.

The time complexity is $O(m + n)$, and the space complexity is $O(1)$, where $m$ and $n$ are the number of rows and columns of the matrix, respectively.

#### Java

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = m - 1, j = 0; i >= 0 && j < n;) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                --i;
            } else {
                ++j;
            }
        }
        return false;
    }
}
```
