# 2426. Number of Pairs Satisfying Inequality

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/number-of-pairs-satisfying-inequality/

---

[中文文档](/solution/2400-2499/2426.Number%20of%20Pairs%20Satisfying%20Inequality/README.md)

## Description

<p>You are given two <strong>0-indexed</strong> integer arrays <code>nums1</code> and <code>nums2</code>, each of size <code>n</code>, and an integer <code>diff</code>. Find the number of <strong>pairs</strong> <code>(i, j)</code> such that:</p>

<ul>
	<li><code>0 &lt;= i &lt; j &lt;= n - 1</code> <strong>and</strong></li>
	<li><code>nums1[i] - nums1[j] &lt;= nums2[i] - nums2[j] + diff</code>.</li>
</ul>

<p>Return<em> the <strong>number of pairs</strong> that satisfy the conditions.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [3,2,5], nums2 = [2,2,1], diff = 1
<strong>Output:</strong> 3
<strong>Explanation:</strong>
There are 3 pairs that satisfy the conditions:
1. i = 0, j = 1: 3 - 2 &lt;= 2 - 2 + 1. Since i &lt; j and 1 &lt;= 1, this pair satisfies the conditions.
2. i = 0, j = 2: 3 - 5 &lt;= 2 - 1 + 1. Since i &lt; j and -2 &lt;= 2, this pair satisfies the conditions.
3. i = 1, j = 2: 2 - 5 &lt;= 2 - 1 + 1. Since i &lt; j and -3 &lt;= 2, this pair satisfies the conditions.
Therefore, we return 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [3,-1], nums2 = [-2,2], diff = -1
<strong>Output:</strong> 0
<strong>Explanation:</strong>
Since there does not exist any pair that satisfies the conditions, we return 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums1.length == nums2.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= diff &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Binary Indexed Tree

> **Thinking**
>
> The inequality $\textit{nums1}[i]-\textit{nums2}[i]\le \textit{nums1}[j]-\textit{nums2}[j]+\textit{diff}$ for $i<j$ cannot be double-looped at $n\le 10^5$. With $v=a-b$ we count prior $v_i\le v_j+\textit{diff}$.
>
> After a shift, a Fenwick tree stores seen $v$. For each $j$ from left to right, query the prefix up to $v_j+\textit{diff}$, then insert $v_j$.

We can transform the inequality in the problem to $\textit{nums1}[i] - \textit{nums2}[i] \leq \textit{nums1}[j] - \textit{nums2}[j] + \textit{diff}$. Therefore, if we calculate the difference between the corresponding elements of the two arrays and get another array $\textit{nums}$, the problem is transformed into finding the number of pairs in $\textit{nums}$ that satisfy $\textit{nums}[i] \leq \textit{nums}[j] + \textit{diff}$.

We can enumerate $j$ from small to large, find out how many numbers before it satisfy $\textit{nums}[i] \leq \textit{nums}[j] + \textit{diff}$, and thus calculate the number of pairs. We can use a binary indexed tree to maintain the prefix sum, so we can find out how many numbers before it satisfy $\textit{nums}[i] \leq \textit{nums}[j] + \textit{diff}$ in $O(\log n)$ time.

The time complexity is $O(n \log n)$.

#### Java

```java
class BinaryIndexedTree {
    private int n;
    private int[] c;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public static final int lowbit(int x) {
        return x & -x;
    }

    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= lowbit(x);
        }
        return s;
    }
}

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        BinaryIndexedTree tree = new BinaryIndexedTree(100000);
        long ans = 0;
        for (int i = 0; i < nums1.length; ++i) {
            int v = nums1[i] - nums2[i];
            ans += tree.query(v + diff + 40000);
            tree.update(v + 40000, 1);
        }
        return ans;
    }
}
```
