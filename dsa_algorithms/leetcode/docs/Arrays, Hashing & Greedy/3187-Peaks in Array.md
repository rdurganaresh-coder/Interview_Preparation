# 3187. Peaks in Array

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/peaks-in-array/

---

[中文文档](/solution/3100-3199/3187.Peaks%20in%20Array/README.md)

## Description

<p>A <strong>peak</strong> in an array <code>arr</code> is an element that is <strong>greater</strong> than its previous and next element in <code>arr</code>.</p>

<p>You are given an integer array <code>nums</code> and a 2D integer array <code>queries</code>.</p>

<p>You have to process queries of two types:</p>

<ul>
	<li><code>queries[i] = [1, l<sub>i</sub>, r<sub>i</sub>]</code>, determine the count of <strong>peak</strong> elements in the <span data-keyword="subarray">subarray</span> <code>nums[l<sub>i</sub>..r<sub>i</sub>]</code>.</li>
	<li><code>queries[i] = [2, index<sub>i</sub>, val<sub>i</sub>]</code>, change <code>nums[index<sub>i</sub>]</code> to <code><font face="monospace">val<sub>i</sub></font></code>.</li>
</ul>

<p>Return an array <code>answer</code> containing the results of the queries of the first type in order.</p>

<p><strong>Notes:</strong></p>

<ul>
	<li>The <strong>first</strong> and the <strong>last</strong> element of an array or a subarray <strong>cannot</strong> be a peak.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,1,4,2,5], queries = [[2,3,4],[1,0,4]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[0]</span></p>

<p><strong>Explanation:</strong></p>

<p>First query: We change <code>nums[3]</code> to 4 and <code>nums</code> becomes <code>[3,1,4,4,5]</code>.</p>

<p>Second query: The number of peaks in the <code>[3,1,4,4,5]</code> is 0.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,1,4,2,1,5], queries = [[2,2,4],[1,0,2],[1,0,4]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[0,1]</span></p>

<p><strong>Explanation:</strong></p>

<p>First query: <code>nums[2]</code> should become 4, but it is already set to 4.</p>

<p>Second query: The number of peaks in the <code>[4,1,4]</code> is 0.</p>

<p>Third query: The second 4 is a peak in the <code>[4,1,4,2,1]</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>queries[i][0] == 1</code> or <code>queries[i][0] == 2</code></li>
	<li>For all <code>i</code> that:
	<ul>
		<li><code>queries[i][0] == 1</code>: <code>0 &lt;= queries[i][1] &lt;= queries[i][2] &lt;= nums.length - 1</code></li>
		<li><code>queries[i][0] == 2</code>: <code>0 &lt;= queries[i][1] &lt;= nums.length - 1</code>, <code>1 &lt;= queries[i][2] &lt;= 10<sup>5</sup></code></li>
	</ul>
	</li>
</ul>

## Solutions

### Solution 1: Binary Indexed Tree

> **Thinking**
>
> A peak is an interior index strictly above both neighbors. Range peak counts plus point updates make rebuilding $O(nq)$.
>
> Peaks are $0/1$ indicators, so a Fenwick tree range-sums them. An assignment at $\textit{idx}$ only changes peaks at $\textit{idx}-1,\textit{idx},\textit{idx}+1$.
>
> Insert the initial peaks. A query sums $(l+1,r-1)$. An update subtracts the three old flags, writes the new value, and adds the new flags.

According to the problem description, for $0 < i < n - 1$, if it satisfies $\textit{nums}[i - 1] < \textit{nums}[i]$ and $\textit{nums}[i] > \textit{nums}[i + 1]$, we can consider $\textit{nums}[i]$ as $1$, otherwise as $0$. Thus, for operation $1$, i.e., querying the number of peak elements in the subarray $\textit{nums}[l..r]$, it is equivalent to querying the number of $1$s in the interval $[l + 1, r - 1]$. We can use a binary indexed tree to maintain the number of $1$s in the interval $[1, n - 1]$.

For operation $1$, i.e., updating $\textit{nums}[\textit{idx}]$ to $\textit{val}$, it will only affect the values at positions $\textit{idx} - 1$, $\textit{idx}$, and $\textit{idx} + 1$, so we only need to update these three positions. Specifically, we can first remove the peak elements at these three positions, then update the value of $\textit{nums}[\textit{idx}]$, and finally add back the peak elements at these three positions.

The time complexity is $O((n + q) \log n)$, and the space complexity is $O(n)$, where $n$ and $q$ are the lengths of the array $\textit{nums}$ and the query array $\textit{queries}$, respectively.

#### Java

```java
class BinaryIndexedTree {
    private int n;
    private int[] c;

    public BinaryIndexedTree(int n) {
        this.n = n;
        this.c = new int[n + 1];
    }

    public void update(int x, int delta) {
        for (; x <= n; x += x & -x) {
            c[x] += delta;
        }
    }

    public int query(int x) {
        int s = 0;
        for (; x > 0; x -= x & -x) {
            s += c[x];
        }
        return s;
    }
}

class Solution {
    private BinaryIndexedTree tree;
    private int[] nums;

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        this.nums = nums;
        tree = new BinaryIndexedTree(n - 1);
        for (int i = 1; i < n - 1; ++i) {
            update(i, 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (var q : queries) {
            if (q[0] == 1) {
                int l = q[1] + 1, r = q[2] - 1;
                ans.add(l > r ? 0 : tree.query(r) - tree.query(l - 1));
            } else {
                int idx = q[1], val = q[2];
                for (int i = idx - 1; i <= idx + 1; ++i) {
                    update(i, -1);
                }
                nums[idx] = val;
                for (int i = idx - 1; i <= idx + 1; ++i) {
                    update(i, 1);
                }
            }
        }
        return ans;
    }

    private void update(int i, int val) {
        if (i <= 0 || i >= nums.length - 1) {
            return;
        }
        if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
            tree.update(i, val);
        }
    }
}
```
