# 1054. Distant Barcodes

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/distant-barcodes/

---

[中文文档](/solution/1000-1099/1054.Distant%20Barcodes/README.md)

## Description

<p>In a warehouse, there is a row of barcodes, where the <code>i<sup>th</sup></code> barcode is <code>barcodes[i]</code>.</p>

<p>Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> barcodes = [1,1,1,2,2,2]
<strong>Output:</strong> [2,1,2,1,2,1]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> barcodes = [1,1,1,1,2,2,3,3]
<strong>Output:</strong> [1,3,1,3,1,2,1,2]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= barcodes.length &lt;= 10000</code></li>
	<li><code>1 &lt;= barcodes[i] &lt;= 10000</code></li>
</ul>

## Solutions

### Solution 1: Counting + Sorting

> **Thinking**
>
> Adjacent values must differ. When the mode appears at most $\lceil n/2\rceil$ times a layout exists. Spreading high-frequency values onto even indices, then filling odd indices, keeps them apart.
>
> Sort by frequency descending and value ascending so equal numbers stay together and frequent ones come first. Write the first half to even slots and the rest to odd slots.
>
> The mode occupies every other even index and never sits next to itself.

First, we use a hash table or array $\textit{cnt}$ to count the number of occurrences of each number in the array $\textit{barcodes}$. Then, we sort the numbers in $\textit{barcodes}$ according to their occurrence times in $\textit{cnt}$ from large to small. If the occurrence times are the same, we sort them from small to large (to ensure the same numbers are adjacent).

Next, we create an answer array $\textit{ans}$ of length $n$. We traverse the sorted $\textit{barcodes}$, and sequentially fill the elements into the even index positions $0, 2, 4, \cdots$ of the answer array. Then, we fill the remaining elements into the odd index positions $1, 3, 5, \cdots$ of the answer array.

The time complexity is $O(n \log n)$, and the space complexity is $O(M)$, where $n$ and $M$ are the length of the array $\textit{barcodes}$ and the maximum value in the array $\textit{barcodes}$, respectively.

#### Java

```java
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        Integer[] t = new Integer[n];
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            t[i] = barcodes[i];
            mx = Math.max(mx, barcodes[i]);
        }
        int[] cnt = new int[mx + 1];
        for (int x : barcodes) {
            ++cnt[x];
        }
        Arrays.sort(t, (a, b) -> cnt[a] == cnt[b] ? a - b : cnt[b] - cnt[a]);
        int[] ans = new int[n];
        for (int k = 0, j = 0; k < 2; ++k) {
            for (int i = k; i < n; i += 2) {
                ans[i] = t[j++];
            }
        }
        return ans;
    }
}
```
