# 164. Maximum Gap

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-gap/

---

[中文文档](/solution/0100-0199/0164.Maximum%20Gap/README.md)

## Description

<p>Given an integer array <code>nums</code>, return <em>the maximum difference between two successive elements in its sorted form</em>. If the array contains less than two elements, return <code>0</code>.</p>

<p>You must write an algorithm that runs in linear time and uses linear extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,6,9,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [10]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The array contains less than 2 elements, therefore return 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Bucket Sort

> **Thinking**
>
> Maximum gap after sorting, in linear time. Comparison sorts are $O(n \log n)$; $n\le 10^5$. The max adjacent gap is at least $(\textit{max}-\textit{min})/(n-1)$. Bucket by that width: gaps inside a bucket are smaller than this lower bound, so the answer is between consecutive non-empty buckets (next min minus previous max). Each bucket stores only min and max.

Suppose $\textit{nums}$ has $n$ elements. After sorting them into $\textit{nums}_0 \le \cdots \le \textit{nums}_{n-1}$, the maximum adjacent gap $\textit{maxGap}$ satisfies

$$
\textit{nums}_{n-1} - \textit{nums}_0 = \sum_{i=1}^{n-1}(\textit{nums}_i - \textit{nums}_{i-1}) \le \textit{maxGap} \times (n-1).
$$

Hence $\textit{maxGap} \ge \dfrac{\textit{nums}_{n-1} - \textit{nums}_0}{n-1}$.

Use that lower bound as the bucket width, and at least $1$ when every value is equal. Values that fall in the same bucket differ by less than $\textit{maxGap}$, so a gap of size $\textit{maxGap}$ always crosses two buckets. Each bucket keeps only its minimum and its maximum, initialized to $+\infty$ and $-\infty$ to mark an empty bucket.

Place every value $v$ into bucket $\lfloor(v - \min) / \textit{bucketSize}\rfloor$. Smaller indices then hold smaller values. Scan the buckets from left to right. The minimum of the current non-empty bucket and the maximum of the previous non-empty bucket are adjacent in sorted order; their difference updates the answer. There is no gap before the first non-empty bucket.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of $\textit{nums}$.

#### Java

```java
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int inf = 0x3f3f3f3f;
        int mi = inf, mx = -inf;
        for (int v : nums) {
            mi = Math.min(mi, v);
            mx = Math.max(mx, v);
        }
        int bucketSize = Math.max(1, (mx - mi) / (n - 1));
        int bucketCount = (mx - mi) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][2];
        for (var bucket : buckets) {
            bucket[0] = inf;
            bucket[1] = -inf;
        }
        for (int v : nums) {
            int i = (v - mi) / bucketSize;
            buckets[i][0] = Math.min(buckets[i][0], v);
            buckets[i][1] = Math.max(buckets[i][1], v);
        }
        int prev = inf;
        int ans = 0;
        for (var bucket : buckets) {
            if (bucket[0] > bucket[1]) {
                continue;
            }
            ans = Math.max(ans, bucket[0] - prev);
            prev = bucket[1];
        }
        return ans;
    }
}
```
