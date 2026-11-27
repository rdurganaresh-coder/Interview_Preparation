# 673. Number of Longest Increasing Subsequence

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/number-of-longest-increasing-subsequence/

---

[中文文档](/solution/0600-0699/0673.Number%20of%20Longest%20Increasing%20Subsequence/README.md)

## Description

<p>Given an integer array&nbsp;<code>nums</code>, return <em>the number of longest increasing subsequences.</em></p>

<p><strong>Notice</strong> that the sequence has to be <strong>strictly</strong> increasing.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,5,4,7]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,2,2,2,2]
<strong>Output:</strong> 5
<strong>Explanation:</strong> The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2000</code></li>
	<li><code>-10<sup>6</sup> &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
	<li>The answer is guaranteed to fit inside a 32-bit integer.</li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> We need both the LIS length and how many such sequences exist. $n\le 2000$ allows $O(n^2)$.
>
> $f[i]$ and $\textit{cnt}[i]$ are the best length and count ending at $i$. Update or add when $\textit{nums}[j]<\textit{nums}[i]$. Sum $\textit{cnt}$ over positions that attain the global maximum length.

We define $f[i]$ as the length of the longest increasing subsequence ending with $\textit{nums}[i]$, and $\textit{cnt}[i]$ as the number of longest increasing subsequences ending with $\textit{nums}[i]$. Initially, $f[i]=1$, $\textit{cnt}[i]=1$. Also, we define $mx$ as the length of the longest increasing subsequence, and $\textit{ans}$ as the number of longest increasing subsequences.

For each $\textit{nums}[i]$, we enumerate all elements $\textit{nums}[j]$ in $\textit{nums}[0:i-1]$. If $\textit{nums}[j] < \textit{nums}[i]$, then $\textit{nums}[i]$ can be appended after $\textit{nums}[j]$ to form a longer increasing subsequence. If $f[i] < f[j] + 1$, it means the length of the longest increasing subsequence ending with $\textit{nums}[i]$ has increased, so we need to update $f[i]=f[j]+1$ and $\textit{cnt}[i]=\textit{cnt}[j]$. If $f[i]=f[j]+1$, it means we have found a longest increasing subsequence with the same length as before, so we need to increase $\textit{cnt}[i]$ by $\textit{cnt}[j]$. Then, if $mx < f[i]$, it means the length of the longest increasing subsequence has increased, so we need to update $mx=f[i]$ and $\textit{ans}=\textit{cnt}[i]$. If $mx=f[i]$, it means we have found a longest increasing subsequence with the same length as before, so we need to increase $\textit{ans}$ by $\textit{cnt}[i]$.

Finally, we return $\textit{ans}$.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] cnt = new int[n];
        int mx = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (f[i] == f[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (mx < f[i]) {
                mx = f[i];
                ans = cnt[i];
            } else if (mx == f[i]) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}
```

### Solution 2: Binary Indexed Tree

> **Thinking**
>
> Scanning all previous indices is the bottleneck. After compressing values, a Fenwick tree stores the best length and count among smaller keys, so each step is $O(\log n)$.

We can use a binary indexed tree to maintain the length and count of the longest increasing subsequence in the prefix interval. We remove duplicates from the array $\textit{nums}$ and sort it to get the array $\textit{arr}$. Then we enumerate each element $x$ in $\textit{nums}$, find the position $i$ of $x$ in the array $\textit{arr}$ by binary search, then query the length and count of the longest increasing subsequence in $[1,i-1]$, denoted as $v$ and $\textit{cnt}$, then update the length and count of the longest increasing subsequence in $[i]$ to $v+1$ and $\max(\textit{cnt},1)$. Finally, we query the length and count of the longest increasing subsequence in $[1,m]$, where $m$ is the length of the array $\textit{arr}$, which is the answer.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class BinaryIndexedTree {
    private int n;
    private int[] c;
    private int[] d;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
        d = new int[n + 1];
    }

    public void update(int x, int v, int cnt) {
        while (x <= n) {
            if (c[x] < v) {
                c[x] = v;
                d[x] = cnt;
            } else if (c[x] == v) {
                d[x] += cnt;
            }
            x += x & -x;
        }
    }

    public int[] query(int x) {
        int v = 0, cnt = 0;
        while (x > 0) {
            if (c[x] > v) {
                v = c[x];
                cnt = d[x];
            } else if (c[x] == v) {
                cnt += d[x];
            }
            x -= x & -x;
        }
        return new int[] {v, cnt};
    }
}

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] arr = Arrays.stream(nums).distinct().sorted().toArray();
        int m = arr.length;
        BinaryIndexedTree tree = new BinaryIndexedTree(m);
        for (int x : nums) {
            int i = Arrays.binarySearch(arr, x) + 1;
            int[] t = tree.query(i - 1);
            int v = t[0];
            int cnt = t[1];
            tree.update(i, v + 1, Math.max(cnt, 1));
        }
        return tree.query(m)[1];
    }
}
```
