# 3164. Find the Number of Good Pairs II

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-the-number-of-good-pairs-ii/

---

[中文文档](/solution/3100-3199/3164.Find%20the%20Number%20of%20Good%20Pairs%20II/README.md)

## Description

<p>You are given 2 integer arrays <code>nums1</code> and <code>nums2</code> of lengths <code>n</code> and <code>m</code> respectively. You are also given a <strong>positive</strong> integer <code>k</code>.</p>

<p>A pair <code>(i, j)</code> is called <strong>good</strong> if <code>nums1[i]</code> is divisible by <code>nums2[j] * k</code> (<code>0 &lt;= i &lt;= n - 1</code>, <code>0 &lt;= j &lt;= m - 1</code>).</p>

<p>Return the total number of <strong>good</strong> pairs.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums1 = [1,3,4], nums2 = [1,3,4], k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>
The 5 good pairs are <code>(0, 0)</code>, <code>(1, 0)</code>, <code>(1, 1)</code>, <code>(2, 0)</code>, and <code>(2, 2)</code>.</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums1 = [1,2,4,12], nums2 = [2,4], k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The 2 good pairs are <code>(3, 0)</code> and <code>(3, 1)</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n, m &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums1[i], nums2[j] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>3</sup></code></li>
</ul>

## Solutions

### Solution 1: Hash Table + Enumerate Multiples

> **Thinking**
>
> The predicate matches part I but lengths reach $10^5$, so a double loop fails.
>
> $x$ pairs with $y$ iff $k$ divides $x$ and $x/k$ is a multiple of $y$. After counting quotients, walk multiples of each $y$.
>
> Build $\textit{cnt1}$ from $\textit{nums1}$ values divisible by $k$. For each $x$ in $\textit{cnt2}$ step from $x$ to $mx$ and add $\textit{cnt1}[y]\cdot v$. An empty $\textit{cnt1}$ yields $0$.

We use a hash table $\textit{cnt1}$ to record the occurrence times of each number divided by $k$ in array $\textit{nums1}$, and a hash table $\textit{cnt2}$ to record the occurrence times of each number in array `nums2`.

Next, we enumerate each number $x$ in array `nums2`. For each number $x$, we enumerate its multiples $y$, where the range of $y$ is $[x, mx]$, where `mx` is the maximum key value in $\textit{cnt1}$. Then we count the sum of `cnt1[y]`, denoted as $s$. Finally, we add $s \times v$ to the answer, where $v$ is `cnt2[x]`.

The time complexity is $O(n + m + (M / k) \log m)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the lengths of arrays $\textit{nums1}$ and $\textit{nums2}$ respectively, and $M$ is the maximum value in array $\textit{nums1}$.

#### Java

```java
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> cnt1 = new HashMap<>();
        for (int x : nums1) {
            if (x % k == 0) {
                cnt1.merge(x / k, 1, Integer::sum);
            }
        }
        if (cnt1.isEmpty()) {
            return 0;
        }
        Map<Integer, Integer> cnt2 = new HashMap<>();
        for (int x : nums2) {
            cnt2.merge(x, 1, Integer::sum);
        }
        long ans = 0;
        int mx = Collections.max(cnt1.keySet());
        for (var e : cnt2.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            int s = 0;
            for (int y = x; y <= mx; y += x) {
                s += cnt1.getOrDefault(y, 0);
            }
            ans += 1L * s * v;
        }
        return ans;
    }
}
```
