# 2926. Maximum Balanced Subsequence Sum

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/maximum-balanced-subsequence-sum/

---

[中文文档](/solution/2900-2999/2926.Maximum%20Balanced%20Subsequence%20Sum/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>.</p>

<p>A <strong>subsequence</strong> of <code>nums</code> having length <code>k</code> and consisting of <strong>indices</strong> <code>i<sub>0</sub>&nbsp;&lt;&nbsp;i<sub>1</sub> &lt;&nbsp;... &lt; i<sub>k-1</sub></code> is <strong>balanced</strong> if the following holds:</p>

<ul>
	<li><code>nums[i<sub>j</sub>] - nums[i<sub>j-1</sub>] &gt;= i<sub>j</sub> - i<sub>j-1</sub></code>, for every <code>j</code> in the range <code>[1, k - 1]</code>.</li>
</ul>

<p>A <strong>subsequence</strong> of <code>nums</code> having length <code>1</code> is considered balanced.</p>

<p>Return <em>an integer denoting the <strong>maximum</strong> possible <strong>sum of elements</strong> in a <strong>balanced</strong> subsequence of </em><code>nums</code>.</p>

<p>A <strong>subsequence</strong> of an array is a new <strong>non-empty</strong> array that is formed from the original array by deleting some (<strong>possibly none</strong>) of the elements without disturbing the relative positions of the remaining elements.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,3,5,6]
<strong>Output:</strong> 14
<strong>Explanation:</strong> In this example, the subsequence [3,5,6] consisting of indices 0, 2, and 3 can be selected.
nums[2] - nums[0] &gt;= 2 - 0.
nums[3] - nums[2] &gt;= 3 - 2.
Hence, it is a balanced subsequence, and its sum is the maximum among the balanced subsequences of nums.
The subsequence consisting of indices 1, 2, and 3 is also valid.
It can be shown that it is not possible to get a balanced subsequence with a sum greater than 14.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,-1,-3,8]
<strong>Output:</strong> 13
<strong>Explanation:</strong> In this example, the subsequence [5,8] consisting of indices 0 and 3 can be selected.
nums[3] - nums[0] &gt;= 3 - 0.
Hence, it is a balanced subsequence, and its sum is the maximum among the balanced subsequences of nums.
It can be shown that it is not possible to get a balanced subsequence with a sum greater than 13.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [-2,-1]
<strong>Output:</strong> -1
<strong>Explanation:</strong> In this example, the subsequence [-1] can be selected.
It is a balanced subsequence, and its sum is the maximum among the balanced subsequences of nums.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming + Binary Indexed Tree

> **Thinking**
>
> Balance $\textit{nums}[i]-\textit{nums}[j] \ge i-j$ rewrites as $\textit{nums}[i]-i \ge \textit{nums}[j]-j$. On $\textit{arr}[t]=\textit{nums}[t]-t$ we want a nondecreasing index sequence maximizing the sum of $\textit{nums}$. The naive $f[i]=\textit{nums}[i]+\max_{j<i, \textit{arr}[j]\le \textit{arr}[i]} f[j]$ (or just $\textit{nums}[i]$) is $O(n^2)$ for $n \le 10^5$.
>
> After compressing $\textit{arr}$, a Fenwick tree stores the best $f$ among values up to a threshold. Scan in index order, query, then insert; a final prefix maximum is the answer.

According to the problem description, we can transform the inequality $\textit{nums}[i] - \textit{nums}[j] \ge i - j$ into $\textit{nums}[i] - i \ge \textit{nums}[j] - j$. Therefore, we consider defining a new array $\textit{arr}$, where $\textit{arr}[i] = \textit{nums}[i] - i$. A balanced subsequence satisfies that for any $j < i$, $\textit{arr}[j] \le \textit{arr}[i]$. The problem is transformed into selecting an increasing subsequence in $\textit{arr}$ such that the corresponding sum in $\textit{nums}$ is maximized.

Suppose $i$ is the index of the last element in the subsequence, then we consider the index $j$ of the second to last element in the subsequence. If $\textit{arr}[j] \le \textit{arr}[i]$, we can consider whether to add $j$ to the subsequence.

Therefore, we define $f[i]$ as the maximum sum of $\textit{nums}$ when the index of the last element in the subsequence is $i$. The answer is $\max_{i=0}^{n-1} f[i]$.

The state transition equation is:

$$
f[i] = \max(\max_{j=0}^{i-1} f[j], 0) + \textit{nums}[i]
$$

where $j$ satisfies $\textit{arr}[j] \le \textit{arr}[i]$.

We can use a Binary Indexed Tree to maintain the maximum value of the prefix, i.e., for each $\textit{arr}[i]$, we maintain the maximum value of $f[i]$ in the prefix $\textit{arr}[0..i]$.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class BinaryIndexedTree {
    private int n;
    private long[] c;
    private final long inf = 1L << 60;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new long[n + 1];
        Arrays.fill(c, -inf);
    }

    public void update(int x, long v) {
        while (x <= n) {
            c[x] = Math.max(c[x], v);
            x += x & -x;
        }
    }

    public long query(int x) {
        long mx = -inf;
        while (x > 0) {
            mx = Math.max(mx, c[x]);
            x -= x & -x;
        }
        return mx;
    }
}

class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = nums[i] - i;
        }
        Arrays.sort(arr);
        int m = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                arr[m++] = arr[i];
            }
        }
        BinaryIndexedTree tree = new BinaryIndexedTree(m);
        for (int i = 0; i < n; ++i) {
            int j = search(arr, nums[i] - i, m) + 1;
            long v = Math.max(tree.query(j), 0) + nums[i];
            tree.update(j, v);
        }
        return tree.query(m);
    }

    private int search(int[] nums, int x, int r) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```
