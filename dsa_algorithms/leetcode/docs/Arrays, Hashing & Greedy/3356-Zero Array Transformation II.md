# 3356. Zero Array Transformation II

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/zero-array-transformation-ii/

---

[中文文档](/solution/3300-3399/3356.Zero%20Array%20Transformation%20II/README.md)

## Description

<p>You are given an integer array <code>nums</code> of length <code>n</code> and a 2D array <code>queries</code> where <code>queries[i] = [l<sub>i</sub>, r<sub>i</sub>, val<sub>i</sub>]</code>.</p>

<p>Each <code>queries[i]</code> represents the following action on <code>nums</code>:</p>

<ul>
	<li>Decrement the value at each index in the range <code>[l<sub>i</sub>, r<sub>i</sub>]</code> in <code>nums</code> by <strong>at most</strong> <code>val<sub>i</sub></code>.</li>
	<li>The amount by which each value is decremented can be chosen <strong>independently</strong> for each index.</li>
</ul>

<p>A <strong>Zero Array</strong> is an array with all its elements equal to 0.</p>

<p>Return the <strong>minimum</strong> possible <strong>non-negative</strong> value of <code>k</code>, such that after processing the first <code>k</code> queries in <strong>sequence</strong>, <code>nums</code> becomes a <strong>Zero Array</strong>. If no such <code>k</code> exists, return -1.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li><strong>For i = 0 (l = 0, r = 2, val = 1):</strong>
    <ul>
    	<li>Decrement values at indices <code>[0, 1, 2]</code> by <code>[1, 0, 1]</code> respectively.</li>
    	<li>The array will become <code>[1, 0, 1]</code>.</li>
    </ul>
    </li>
    <li><strong>For i = 1 (l = 0, r = 2, val = 1):</strong>
    <ul>
    	<li>Decrement values at indices <code>[0, 1, 2]</code> by <code>[1, 0, 1]</code> respectively.</li>
    	<li>The array will become <code>[0, 0, 0]</code>, which is a Zero Array. Therefore, the minimum value of <code>k</code> is 2.</li>
    </ul>
    </li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li><strong>For i = 0 (l = 1, r = 3, val = 2):</strong>
    <ul>
    	<li>Decrement values at indices <code>[1, 2, 3]</code> by <code>[2, 2, 1]</code> respectively.</li>
    	<li>The array will become <code>[4, 1, 0, 0]</code>.</li>
    </ul>
    </li>
    <li><strong>For i = 1 (l = 0, r = 2, val<span style="font-size: 13.3333px;"> </span>= 1):</strong>
    <ul>
    	<li>Decrement values at indices <code>[0, 1, 2]</code> by <code>[1, 1, 0]</code> respectively.</li>
    	<li>The array will become <code>[3, 0, 0, 0]</code>, which is not a Zero Array.</li>
    </ul>
    </li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 5 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>queries[i].length == 3</code></li>
	<li><code>0 &lt;= l<sub>i</sub> &lt;= r<sub>i</sub> &lt; nums.length</code></li>
	<li><code>1 &lt;= val<sub>i</sub> &lt;= 5</code></li>
</ul>

## Solutions

### Solution 1: Difference Array + Binary Search

> **Thinking**
>
> Queries now have weights and must be taken as a prefix. Longer prefixes are easier, so the feasible length is monotone.
>
> A check for $k$ writes the first $k$ weighted ranges into a difference array and tests whether every index is covered.
>
> Binary search yields the smallest feasible $k$, or $-1$ if even $m$ queries are not enough.

We notice that the more queries we use, the easier it is to turn the array into a zero array, which shows monotonicity. Therefore, we can use binary search to enumerate the number of queries and check whether the array can be turned into a zero array after the first $k$ queries.

We define the left boundary $l$ and right boundary $r$ for binary search, initially $l = 0$, $r = m + 1$, where $m$ is the number of queries. We define a function $\textit{check}(k)$ to indicate whether the array can be turned into a zero array after the first $k$ queries. We can use a difference array to maintain the value of each element.

Define an array $d$ of length $n + 1$, initialized to all $0$. For each of the first $k$ queries $[l, r, \textit{val}]$, we add $\textit{val}$ to $d[l]$ and subtract $\textit{val}$ from $d[r + 1]$.

Then we iterate through the array $d$ in the range $[0, n - 1]$, accumulating the prefix sum $s$. If $\textit{nums}[i] > s$, it means $\textit{nums}$ cannot be transformed into a zero array, so we return $\textit{false}$.

During the binary search, if $\textit{check}(k)$ returns $\textit{true}$, it means the array can be turned into a zero array, so we update the right boundary $r$ to $k$; otherwise, we update the left boundary $l$ to $k + 1$.

Finally, we check whether $l > m$. If so, return -1; otherwise, return $l$.

The time complexity is $O((n + m) \log m)$, and the space complexity is $O(n)$, where $n$ and $m$ are the lengths of the array $\textit{nums}$ and $\textit{queries}$, respectively.

#### Java

```java
class Solution {
    private int n;
    private int[] nums;
    private int[][] queries;

    public int minZeroArray(int[] nums, int[][] queries) {
        this.nums = nums;
        this.queries = queries;
        n = nums.length;
        int m = queries.length;
        int l = 0, r = m + 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l > m ? -1 : l;
    }

    private boolean check(int k) {
        int[] d = new int[n + 1];
        for (int i = 0; i < k; ++i) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            d[l] += val;
            d[r + 1] -= val;
        }
        for (int i = 0, s = 0; i < n; ++i) {
            s += d[i];
            if (nums[i] > s) {
                return false;
            }
        }
        return true;
    }
}
```
