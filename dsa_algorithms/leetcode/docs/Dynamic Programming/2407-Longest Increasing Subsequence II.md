# 2407. Longest Increasing Subsequence II

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/longest-increasing-subsequence-ii/

---

[中文文档](/solution/2400-2499/2407.Longest%20Increasing%20Subsequence%20II/README.md)

## Description

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>.</p>

<p>Find the longest subsequence of <code>nums</code> that meets the following requirements:</p>

<ul>
	<li>The subsequence is <strong>strictly increasing</strong> and</li>
	<li>The difference between adjacent elements in the subsequence is <strong>at most</strong> <code>k</code>.</li>
</ul>

<p>Return<em> the length of the <strong>longest</strong> <strong>subsequence</strong> that meets the requirements.</em></p>

<p>A <strong>subsequence</strong> is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,2,1,4,3,4,5,8,15], k = 3
<strong>Output:</strong> 5
<strong>Explanation:</strong>
The longest subsequence that meets the requirements is [1,3,4,5,8].
The subsequence has a length of 5, so we return 5.
Note that the subsequence [1,3,4,5,8,15] does not meet the requirements because 15 - 8 = 7 is larger than 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [7,4,5,1,8,12,4,7], k = 5
<strong>Output:</strong> 4
<strong>Explanation:</strong>
The longest subsequence that meets the requirements is [4,5,8,12].
The subsequence has a length of 4, so we return 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,5], k = 1
<strong>Output:</strong> 1
<strong>Explanation:</strong>
The longest subsequence that meets the requirements is [1].
The subsequence has a length of 1, so we return 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i], k &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Segment Tree

> **Thinking**
>
> Classic LIS is $O(n^2)$, which fails at $n\le 10^5$, and adjacent values may differ by at most $k$. The best length ending at $v$ is one plus the maximum $f$ on $[v-k,v-1]$, so we need range-max queries and point updates on the value domain.
>
> Values lie in $[1,10^5]$. A segment tree stores $f[v]$; for each $v$ query then update, in $O(n \log V)$.

We assume that $f[v]$ represents the length of the longest increasing subsequence ending with the number $v$.

We traverse each element $v$ in the array $\textit{nums}$, with the state transition equation: $f[v] = \max(f[v], f[x])$, where the range of $x$ is $[v-k, v-1]$.

Therefore, we need a data structure to maintain the maximum value of the interval. It is not difficult to think of using a segment tree.

The segment tree divides the entire interval into multiple discontinuous subintervals, and the number of subintervals does not exceed $\log(\textit{width})$. To update the value of an element, only $\log(\textit{width})$ intervals need to be updated, and these intervals are all contained in a large interval that contains the element.

- Each node of the segment tree represents an interval;
- The segment tree has a unique root node, which represents the entire statistical range, such as $[1,N]$;
- Each leaf node of the segment tree represents an elementary interval of length $1$, $[x, x]$;
- For each internal node $[l,r]$, its left child is $[l,\textit{mid}]$, and the right child is $[\textit{mid}+1,r]$, where $\textit{mid} = \left \lfloor \frac{l+r}{2} \right \rfloor$.

For this problem, the information maintained by the segment tree node is the maximum value within the interval range.

The time complexity is $O(n \log n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int mx = nums[0];
        for (int v : nums) {
            mx = Math.max(mx, v);
        }
        SegmentTree tree = new SegmentTree(mx);
        int ans = 0;
        for (int v : nums) {
            int t = tree.query(1, v - k, v - 1) + 1;
            ans = Math.max(ans, t);
            tree.modify(1, v, t);
        }
        return ans;
    }
}

class Node {
    int l;
    int r;
    int v;
}

class SegmentTree {
    private Node[] tr;

    public SegmentTree(int n) {
        tr = new Node[4 * n];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node();
        }
        build(1, 1, n);
    }

    public void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) {
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
    }

    public void modify(int u, int x, int v) {
        if (tr[u].l == x && tr[u].r == x) {
            tr[u].v = v;
            return;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (x <= mid) {
            modify(u << 1, x, v);
        } else {
            modify(u << 1 | 1, x, v);
        }
        pushup(u);
    }

    public void pushup(int u) {
        tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
    }

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].v;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        int v = 0;
        if (l <= mid) {
            v = query(u << 1, l, r);
        }
        if (r > mid) {
            v = Math.max(v, query(u << 1 | 1, l, r));
        }
        return v;
    }
}
```
