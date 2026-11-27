# 2916. Subarrays Distinct Element Sum of Squares II

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/

---

[中文文档](/solution/2900-2999/2916.Subarrays%20Distinct%20Element%20Sum%20of%20Squares%20II/README.md)

## Description

<p>You are given a <strong>0-indexed </strong>integer array <code>nums</code>.</p>

<p>The <strong>distinct count</strong> of a subarray of <code>nums</code> is defined as:</p>

<ul>
	<li>Let <code>nums[i..j]</code> be a subarray of <code>nums</code> consisting of all the indices from <code>i</code> to <code>j</code> such that <code>0 &lt;= i &lt;= j &lt; nums.length</code>. Then the number of distinct values in <code>nums[i..j]</code> is called the distinct count of <code>nums[i..j]</code>.</li>
</ul>

<p>Return <em>the sum of the <strong>squares</strong> of <strong>distinct counts</strong> of all subarrays of </em><code>nums</code>.</p>

<p>Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>A subarray is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,1]
<strong>Output:</strong> 15
<strong>Explanation:</strong> Six possible subarrays are:
[1]: 1 distinct value
[2]: 1 distinct value
[1]: 1 distinct value
[1,2]: 2 distinct values
[2,1]: 2 distinct values
[1,2,1]: 2 distinct values
The sum of the squares of the distinct counts in all subarrays is equal to 1<sup>2</sup> + 1<sup>2</sup> + 1<sup>2</sup> + 2<sup>2</sup> + 2<sup>2</sup> + 2<sup>2</sup> = 15.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong> Three possible subarrays are:
[2]: 1 distinct value
[2]: 1 distinct value
[2,2]: 1 distinct value
The sum of the squares of the distinct counts in all subarrays is equal to 1<sup>2</sup> + 1<sup>2</sup> + 1<sup>2</sup> = 3.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Segment Tree + Hash Table

> **Thinking**
>
> Enumerating every subarray and squaring its distinct count is too slow once $n \le 10^5$. Fixing the right endpoint $r$ and scanning left still evaluates each subarray on its own, so the cost remains $O(n^2)$.
>
> Let $f(l, r)$ be the number of distinct values in $\textit{nums}[l..r]$. If $\textit{nums}[r]$ last appeared at $p$, or $p = -1$ on its first occurrence, then $f(l, r) = f(l, r - 1) + 1$ only when $l > p$. The identity $(x + 1)^2 = x^2 + 2x + 1$ turns that increment into an update of the sum of squares.
>
> Thus $f(\cdot, r)$ changes by one range addition, while the answer needs the sum of squares over every left endpoint. A segment tree stores both the range sum and the sum of squares, and a lazy tag defers the increment. Scanning $r$ from left to right, we add one on $[p + 1, r]$ and read the value at the root.

We scan the array by the right endpoint $r$ from left to right. A hash map $\textit{last}$ stores the latest index of each value, or $-1$ if it has not appeared. Let $f(l)$ be the number of distinct elements in $\textit{nums}[l..r]$. If $\textit{nums}[r]$ previously occurred at $p$, only the values $f(l)$ with $l \in [p + 1, r]$ increase by $1$.

Each segment-tree node keeps the range sum $\textit{sum}$, the sum of squares $\textit{sumSq}$, and a lazy tag for range addition. Adding $v$ to a range of length $\textit{len}$ updates them by

$$
\begin{aligned}
\textit{sumSq} &\leftarrow \textit{sumSq} + 2 \cdot v \cdot \textit{sum} + v^{2} \cdot \textit{len}, \\
\textit{sum} &\leftarrow \textit{sum} + v \cdot \textit{len}.
\end{aligned}
$$

Positions to the right of $r$ stay $0$, so the root's $\textit{sumSq}$ after each update is the sum of squares of distinct counts of every subarray ending at $r$. Summing these contributions modulo $10^9 + 7$ gives the answer.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    private static final int MOD = 1000000007;

    static class Node {
        int l, r;
        long sum, sumSq;
        int lazy;
    }

    static class SegmentTree {
        Node[] tr;

        SegmentTree(int n) {
            tr = new Node[n << 2];
            for (int i = 0; i < tr.length; i++) {
                tr[i] = new Node();
            }
            build(1, 0, n - 1);
        }

        void build(int u, int l, int r) {
            tr[u].l = l;
            tr[u].r = r;
            if (l == r) {
                return;
            }
            int mid = (l + r) >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
        }

        void apply(int u, int v) {
            long len = tr[u].r - tr[u].l + 1L;
            long add = v;
            tr[u].sumSq += 2 * add * tr[u].sum + add * add * len;
            tr[u].sum += add * len;
            tr[u].lazy += v;
        }

        void pushdown(int u) {
            if (tr[u].lazy != 0) {
                apply(u << 1, tr[u].lazy);
                apply(u << 1 | 1, tr[u].lazy);
                tr[u].lazy = 0;
            }
        }

        void pushup(int u) {
            tr[u].sum = tr[u << 1].sum + tr[u << 1 | 1].sum;
            tr[u].sumSq = tr[u << 1].sumSq + tr[u << 1 | 1].sumSq;
        }

        void modify(int u, int l, int r, int v) {
            if (tr[u].l >= l && tr[u].r <= r) {
                apply(u, v);
                return;
            }
            pushdown(u);
            int mid = (tr[u].l + tr[u].r) >> 1;
            if (l <= mid) {
                modify(u << 1, l, r, v);
            }
            if (r > mid) {
                modify(u << 1 | 1, l, r, v);
            }
            pushup(u);
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);
        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int p = last.getOrDefault(nums[i], -1);
            st.modify(1, p + 1, i, 1);
            last.put(nums[i], i);
            ans = (ans + st.tr[1].sumSq) % MOD;
        }
        return (int) ans;
    }
}
```
