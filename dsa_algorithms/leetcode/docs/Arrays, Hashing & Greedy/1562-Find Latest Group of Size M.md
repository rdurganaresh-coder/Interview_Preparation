# 1562. Find Latest Group of Size M

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-latest-group-of-size-m/

---

[中文文档](/solution/1500-1599/1562.Find%20Latest%20Group%20of%20Size%20M/README.md)

## Description

<p>Given an array <code>arr</code> that represents a permutation of numbers from <code>1</code> to <code>n</code>.</p>

<p>You have a binary string of size <code>n</code> that initially has all its bits set to zero. At each step <code>i</code> (assuming both the binary string and <code>arr</code> are 1-indexed) from <code>1</code> to <code>n</code>, the bit at position <code>arr[i]</code> is set to <code>1</code>.</p>

<p>You are also given an integer <code>m</code>. Find the latest step at which there exists a group of ones of length <code>m</code>. A group of ones is a contiguous substring of <code>1</code>&#39;s such that it cannot be extended in either direction.</p>

<p>Return <em>the latest step at which there exists a group of ones of length <strong>exactly</strong></em> <code>m</code>. <em>If no such group exists, return</em> <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [3,5,1,2,4], m = 1
<strong>Output:</strong> 4
<strong>Explanation:</strong> 
Step 1: &quot;00<u>1</u>00&quot;, groups: [&quot;1&quot;]
Step 2: &quot;0010<u>1</u>&quot;, groups: [&quot;1&quot;, &quot;1&quot;]
Step 3: &quot;<u>1</u>0101&quot;, groups: [&quot;1&quot;, &quot;1&quot;, &quot;1&quot;]
Step 4: &quot;1<u>1</u>101&quot;, groups: [&quot;111&quot;, &quot;1&quot;]
Step 5: &quot;111<u>1</u>1&quot;, groups: [&quot;11111&quot;]
The latest step at which there exists a group of size 1 is step 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [3,1,5,4,2], m = 2
<strong>Output:</strong> -1
<strong>Explanation:</strong> 
Step 1: &quot;00<u>1</u>00&quot;, groups: [&quot;1&quot;]
Step 2: &quot;<u>1</u>0100&quot;, groups: [&quot;1&quot;, &quot;1&quot;]
Step 3: &quot;1010<u>1</u>&quot;, groups: [&quot;1&quot;, &quot;1&quot;, &quot;1&quot;]
Step 4: &quot;101<u>1</u>1&quot;, groups: [&quot;1&quot;, &quot;111&quot;]
Step 5: &quot;1<u>1</u>111&quot;, groups: [&quot;11111&quot;]
No group of size 2 exists during any step.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == arr.length</code></li>
	<li><code>1 &lt;= m &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arr[i] &lt;= n</code></li>
	<li>All integers in <code>arr</code> are <strong>distinct</strong>.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Zeros flip to ones in the order of $\textit{arr}$; we want the last time a contiguous block of length $m$ exists. $n\le 10^5$, so rebuilding the string each step is impossible. If $m=n$ the whole array fills at step $n$.
>
> A disjoint-set forest stores the size of each ones-component. Before a new index merges with a filled neighbor, if that neighbor's component has size exactly $m$, the group still exists at this step and we record it. Then union and update the size.

#### Java

```java
class Solution {
    private int[] p;
    private int[] size;

    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) {
            return n;
        }
        boolean[] vis = new boolean[n];
        p = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
            size[i] = 1;
        }
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            int v = arr[i] - 1;
            if (v > 0 && vis[v - 1]) {
                if (size[find(v - 1)] == m) {
                    ans = i;
                }
                union(v, v - 1);
            }
            if (v < n - 1 && vis[v + 1]) {
                if (size[find(v + 1)] == m) {
                    ans = i;
                }
                union(v, v + 1);
            }
            vis[v] = true;
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) {
            return;
        }
        p[pa] = pb;
        size[pb] += size[pa];
    }
}
```

### Solution 2

> **Thinking**
>
> The union-find lookups add a log factor, yet merges only touch interval endpoints. Store each ones-run's length at its two ends; a new point reads the neighboring end lengths, writes $l+r+1$ to the new ends, and checks whether $l$ or $r$ equals $m$. Updates are $O(1)$, so the total time is linear.

#### Java

```java
class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) {
            return n;
        }
        int[] cnt = new int[n + 2];
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            int v = arr[i];
            int l = cnt[v - 1], r = cnt[v + 1];
            if (l == m || r == m) {
                ans = i;
            }
            cnt[v - l] = l + r + 1;
            cnt[v + r] = l + r + 1;
        }
        return ans;
    }
}
```
