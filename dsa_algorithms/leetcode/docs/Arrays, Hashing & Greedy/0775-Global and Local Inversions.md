# 775. Global and Local Inversions

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/global-and-local-inversions/

---

[中文文档](/solution/0700-0799/0775.Global%20and%20Local%20Inversions/README.md)

## Description

<p>You are given an integer array <code>nums</code> of length <code>n</code> which represents a permutation of all the integers in the range <code>[0, n - 1]</code>.</p>

<p>The number of <strong>global inversions</strong> is the number of the different pairs <code>(i, j)</code> where:</p>

<ul>
	<li><code>0 &lt;= i &lt; j &lt; n</code></li>
	<li><code>nums[i] &gt; nums[j]</code></li>
</ul>

<p>The number of <strong>local inversions</strong> is the number of indices <code>i</code> where:</p>

<ul>
	<li><code>0 &lt;= i &lt; n - 1</code></li>
	<li><code>nums[i] &gt; nums[i + 1]</code></li>
</ul>

<p>Return <code>true</code> <em>if the number of <strong>global inversions</strong> is equal to the number of <strong>local inversions</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,0,2]
<strong>Output:</strong> true
<strong>Explanation:</strong> There is 1 global inversion and 1 local inversion.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,0]
<strong>Output:</strong> false
<strong>Explanation:</strong> There are 2 global inversions and 1 local inversion.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt; n</code></li>
	<li>All the integers of <code>nums</code> are <strong>unique</strong>.</li>
	<li><code>nums</code> is a permutation of all the numbers in the range <code>[0, n - 1]</code>.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Decide whether global inversions equal adjacent ones. $n\le 10^5$. Equivalently, there is no inversion of distance greater than $1$.
>
> No $i\le j-2$ with $\textit{nums}[i]>\textit{nums}[j]$. Track the prefix max of $\textit{nums}[0..i-2]$ and fail if it exceeds $\textit{nums}[i]$.

#### Java

```java
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int mx = 0;
        for (int i = 2; i < nums.length; ++i) {
            mx = Math.max(mx, nums[i - 2]);
            if (mx > nums[i]) {
                return false;
            }
        }
        return true;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 uses the closed form. Counting instead: adjacent pairs for local inversions, a Fenwick tree for global ones.
>
> Maintain their difference and fail when the global count pulls ahead. An extra $\log n$.

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
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        int cnt = 0;
        for (int i = 0; i < n && cnt >= 0; ++i) {
            cnt += (i < n - 1 && nums[i] > nums[i + 1] ? 1 : 0);
            cnt -= (i - tree.query(nums[i]));
            tree.update(nums[i] + 1, 1);
        }
        return cnt == 0;
    }
}
```
