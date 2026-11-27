# 2736. Maximum Sum Queries

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-sum-queries/

---

[中文文档](/solution/2700-2799/2736.Maximum%20Sum%20Queries/README.md)

## Description

<p>You are given two <strong>0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, each of length <code>n</code>, and a <strong>1-indexed 2D array</strong> <code>queries</code> where <code>queries[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>.</p>

<p>For the <code>i<sup>th</sup></code> query, find the <strong>maximum value</strong> of <code>nums1[j] + nums2[j]</code> among all indices <code>j</code> <code>(0 &lt;= j &lt; n)</code>, where <code>nums1[j] &gt;= x<sub>i</sub></code> and <code>nums2[j] &gt;= y<sub>i</sub></code>, or <strong>-1</strong> if there is no <code>j</code> satisfying the constraints.</p>

<p>Return <em>an array </em><code>answer</code><em> where </em><code>answer[i]</code><em> is the answer to the </em><code>i<sup>th</sup></code><em> query.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [4,3,1,2], nums2 = [2,4,9,5], queries = [[4,1],[1,3],[2,5]]
<strong>Output:</strong> [6,10,7]
<strong>Explanation:</strong> 
For the 1st query <code node="[object Object]">x<sub>i</sub> = 4</code>&nbsp;and&nbsp;<code node="[object Object]">y<sub>i</sub> = 1</code>, we can select index&nbsp;<code node="[object Object]">j = 0</code>&nbsp;since&nbsp;<code node="[object Object]">nums1[j] &gt;= 4</code>&nbsp;and&nbsp;<code node="[object Object]">nums2[j] &gt;= 1</code>. The sum&nbsp;<code node="[object Object]">nums1[j] + nums2[j]</code>&nbsp;is 6, and we can show that 6 is the maximum we can obtain.

For the 2nd query <code node="[object Object]">x<sub>i</sub> = 1</code>&nbsp;and&nbsp;<code node="[object Object]">y<sub>i</sub> = 3</code>, we can select index&nbsp;<code node="[object Object]">j = 2</code>&nbsp;since&nbsp;<code node="[object Object]">nums1[j] &gt;= 1</code>&nbsp;and&nbsp;<code node="[object Object]">nums2[j] &gt;= 3</code>. The sum&nbsp;<code node="[object Object]">nums1[j] + nums2[j]</code>&nbsp;is 10, and we can show that 10 is the maximum we can obtain. 

For the 3rd query <code node="[object Object]">x<sub>i</sub> = 2</code>&nbsp;and&nbsp;<code node="[object Object]">y<sub>i</sub> = 5</code>, we can select index&nbsp;<code node="[object Object]">j = 3</code>&nbsp;since&nbsp;<code node="[object Object]">nums1[j] &gt;= 2</code>&nbsp;and&nbsp;<code node="[object Object]">nums2[j] &gt;= 5</code>. The sum&nbsp;<code node="[object Object]">nums1[j] + nums2[j]</code>&nbsp;is 7, and we can show that 7 is the maximum we can obtain.

Therefore, we return&nbsp;<code node="[object Object]">[6,10,7]</code>.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [3,2,5], nums2 = [2,3,4], queries = [[4,4],[3,2],[1,1]]
<strong>Output:</strong> [9,9,9]
<strong>Explanation:</strong> For this example, we can use index&nbsp;<code node="[object Object]">j = 2</code>&nbsp;for all the queries since it satisfies the constraints for each query.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [2,1], nums2 = [2,3], queries = [[3,3]]
<strong>Output:</strong> [-1]
<strong>Explanation:</strong> There is one query in this example with <code node="[object Object]">x<sub>i</sub></code> = 3 and <code node="[object Object]">y<sub>i</sub></code> = 3. For every index, j, either nums1[j] &lt; <code node="[object Object]">x<sub>i</sub></code> or nums2[j] &lt; <code node="[object Object]">y<sub>i</sub></code>. Hence, there is no solution. 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == nums2.length</code>&nbsp;</li>
	<li><code>n ==&nbsp;nums1.length&nbsp;</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup>&nbsp;</code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>queries[i].length ==&nbsp;2</code></li>
	<li><code>x<sub>i</sub>&nbsp;== queries[i][1]</code></li>
	<li><code>y<sub>i</sub> == queries[i][2]</code></li>
	<li><code>1 &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Binary Indexed Tree

> **Thinking**
>
> Each query asks for the maximum $\textit{nums1}+\textit{nums2}$ among points with $\textit{nums1}\ge x$ and $\textit{nums2}\ge y$. Both arrays have length $10^5$, so scanning every point per query is impossible.
>
> This is a two-dimensional dominance maximum. Process points and queries in decreasing first coordinate so that when $(x,y)$ arrives, every point with $\textit{nums1}\ge x$ is already inserted. A Fenwick tree stores prefix maxima of the sums on reversed, discretized $\textit{nums2}$, which answers $\textit{nums2}\ge y$.

This problem belongs to the category of two-dimensional partial order problems.

A two-dimensional partial order problem is defined as follows: given several pairs of points $(a_1, b_1)$, $(a_2, b_2)$, ..., $(a_n, b_n)$, and a defined partial order relation, now given a point $(a_i, b_i)$, we need to find the number/maximum value of point pairs $(a_j, b_j)$ that satisfy the partial order relation. That is:

$$
\left(a_{j}, b_{j}\right) \prec\left(a_{i}, b_{i}\right) \stackrel{\text{def}}{=} a_{j} \lesseqgtr a_{i} \text{ and } b_{j} \lesseqgtr b_{i}
$$

The general solution to two-dimensional partial order problems is to sort one dimension and use a data structure to handle the second dimension (this data structure is generally a binary indexed tree).

For this problem, we can create an array $\textit{nums}$, where $\textit{nums}[i]=(\textit{nums}_1[i], \textit{nums}_2[i])$, and then sort $\textit{nums}$ in descending order according to $\textit{nums}_1$. We also sort the queries $\textit{queries}$ in descending order according to $x$.

Next, we iterate through each query $\textit{queries}[i] = (x, y)$. For the current query, we loop to insert the value of $\textit{nums}_2$ for all elements in $\textit{nums}$ that are greater than or equal to $x$ into the binary indexed tree. The binary indexed tree maintains the maximum value of $\textit{nums}_1 + \textit{nums}_2$ in the discretized $\textit{nums}_2$ interval. Therefore, we only need to query the maximum value corresponding to the interval greater than or equal to the discretized $y$ in the binary indexed tree. Note that since the binary indexed tree maintains the prefix maximum value, we can insert $\textit{nums}_2$ in reverse order into the binary indexed tree in the implementation.

The time complexity is $O((n + m) \log n + m \log m)$, and the space complexity is $O(n + m)$, where $n$ is the length of the array $\textit{nums}$, and $m$ is the length of the array $\textit{queries}$.

Similar problems:

- [2940. Find Building Where Alice and Bob Can Meet](https://github.com/doocs/leetcode/blob/main/solution/2900-2999/2940.Find%20Building%20Where%20Alice%20and%20Bob%20Can%20Meet/README_EN.md)

#### Java

```java
class BinaryIndexedTree {
    private int n;
    private int[] c;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
        Arrays.fill(c, -1);
    }

    public void update(int x, int v) {
        while (x <= n) {
            c[x] = Math.max(c[x], v);
            x += x & -x;
        }
    }

    public int query(int x) {
        int mx = -1;
        while (x > 0) {
            mx = Math.max(mx, c[x]);
            x -= x & -x;
        }
        return mx;
    }
}

class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[][] nums = new int[n][0];
        for (int i = 0; i < n; ++i) {
            nums[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(nums, (a, b) -> b[0] - a[0]);
        Arrays.sort(nums2);
        int m = queries.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> queries[j][0] - queries[i][0]);
        int[] ans = new int[m];
        int j = 0;
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (int i : idx) {
            int x = queries[i][0], y = queries[i][1];
            for (; j < n && nums[j][0] >= x; ++j) {
                int k = n - Arrays.binarySearch(nums2, nums[j][1]);
                tree.update(k, nums[j][0] + nums[j][1]);
            }
            int p = Arrays.binarySearch(nums2, y);
            int k = p >= 0 ? n - p : n + p + 1;
            ans[i] = tree.query(k);
        }
        return ans;
    }
}
```

### Solution 2: Sorting + Monotonic Stack + Binary Search

> **Thinking**
>
> The Fenwick tree needs discretization and index reversal. After popping points in decreasing $\textit{nums1}$, a monotonic stack keeps candidates in increasing $\textit{nums2}$ and decreasing sum, dropping a smaller $\textit{nums2}$ that is not better. A query binary-searches the first stack entry with $\textit{nums2}\ge y$.

We process queries in descending order of their corresponding $x$ threshold.
At the same time, we also sort number pairs in descending order of $\textit{nums1}[i]$.

For each $\textit{query}_j$, all number pairs satisfying $\textit{nums1}[i] \geq x_j$ are added to a monotonic stack.

Such a stack runs in ascending order of $\textit{nums2}[i]$ but descending order
of $\textit{nums1}[i] + \textit{nums2}[i]$, ensuring that any candidate with a larger $\textit{nums2}[i]$
has a smaller $\textit{nums1}[i] + \textit{nums2}[i]$ instead, so only effective candidates are kept.

For each $\textit{query}_j$, binary search locates the first stack entry having
$\textit{nums2}[i] \geq y_j$. Its corresponding $\textit{nums1}[i] + \textit{nums2}[i]$ is the answer.

The time complexity is $O((n + m) \log n + m \log m)$, and the space complexity is $O(n + m)$, where $n$ is the length of the array $\textit{nums2}$, and $m$ is the length of the array $\textit{queries}$.
