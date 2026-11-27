# 2519. Count the Number of K-Big Indices

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-the-number-of-k-big-indices/

---

[中文文档](/solution/2500-2599/2519.Count%20the%20Number%20of%20K-Big%20Indices/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> and a positive integer <code>k</code>.</p>

<p>We call an index <code>i</code> <strong>k-big</strong> if the following conditions are satisfied:</p>

<ul>
	<li>There exist at least <code>k</code> different indices <code>idx1</code> such that <code>idx1 &lt; i</code> and <code>nums[idx1] &lt; nums[i]</code>.</li>
	<li>There exist at least <code>k</code> different indices <code>idx2</code> such that <code>idx2 &gt; i</code> and <code>nums[idx2] &lt; nums[i]</code>.</li>
</ul>

<p>Return <em>the number of k-big indices</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,3,6,5,2,3], k = 2
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are only two 2-big indices in nums:
- i = 2 --&gt; There are two valid idx1: 0 and 1. There are three valid idx2: 2, 3, and 4.
- i = 3 --&gt; There are two valid idx1: 0 and 1. There are two valid idx2: 3 and 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1], k = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no 3-big indices in nums.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i], k &lt;= nums.length</code></li>
</ul>

## Solutions

### Solution 1: Binary Indexed Tree

> **Thinking**
>
> Index $i$ is $k$-big iff at least $k$ strictly smaller values lie to its left and the same holds on the right. Scanning both sides for every $i$ is quadratic at $n\le 10^5$.
>
> Values can be treated as up to $n$. Two Fenwick trees store frequencies. Insert every value into the right tree first; when scanning left to right, remove the current value from the right, query how many stored values are $<v$ on each side, then insert $v$ on the left. Each index costs $O(\log n)$.

We maintain two binary indexed trees, one records the number of elements smaller than the current position on the left, and the other records the number of elements smaller than the current position on the right.

We traverse the array, and for the current position, if the number of elements smaller than the current position on the left is greater than or equal to $k$, and the number of elements smaller than the current position on the right is greater than or equal to $k$, then the current position is a `k-big`, and we increment the answer by one.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class BinaryIndexedTree {
    private int n;
    private int[] c;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;
            x += x & -x;
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= x & -x;
        }
        return s;
    }
}

class Solution {
    public int kBigIndices(int[] nums, int k) {
        int n = nums.length;
        BinaryIndexedTree tree1 = new BinaryIndexedTree(n);
        BinaryIndexedTree tree2 = new BinaryIndexedTree(n);
        for (int v : nums) {
            tree2.update(v, 1);
        }
        int ans = 0;
        for (int v : nums) {
            tree2.update(v, -1);
            if (tree1.query(v - 1) >= k && tree2.query(v - 1) >= k) {
                ++ans;
            }
            tree1.update(v, 1);
        }
        return ans;
    }
}
```
