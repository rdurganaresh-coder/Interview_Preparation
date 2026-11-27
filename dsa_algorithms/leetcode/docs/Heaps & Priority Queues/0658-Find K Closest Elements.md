# 658. Find K Closest Elements

**Difficulty:** Medium  
**Category:** Heaps & Priority Queues  
**LeetCode:** https://leetcode.com/problems/find-k-closest-elements/

---

[中文文档](/solution/0600-0699/0658.Find%20K%20Closest%20Elements/README.md)

## Description

<p>Given a <strong>sorted</strong> integer array <code>arr</code>, two integers <code>k</code> and <code>x</code>, return the <code>k</code> closest integers to <code>x</code> in the array. The result should also be sorted in ascending order.</p>

<p>An integer <code>a</code> is closer to <code>x</code> than an integer <code>b</code> if:</p>

<ul>
	<li><code>|a - x| &lt; |b - x|</code>, or</li>
	<li><code>|a - x| == |b - x|</code> and <code>a &lt; b</code></li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [1,2,3,4,5], k = 4, x = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,3,4]</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [1,1,2,3,4,5], k = 4, x = -1</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,1,2,3]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= arr.length</code></li>
	<li><code>1 &lt;= arr.length &lt;= 10<sup>4</sup></code></li>
	<li><code>arr</code> is sorted in <strong>ascending</strong> order.</li>
	<li><code>-10<sup>4</sup> &lt;= arr[i], x &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Sort

> **Thinking**
>
> We need the $k$ closest values to $x$, reported in sorted order. Sorting by distance then taking $k$ is $O(n \log n)$.
>
> Sort by $|v-x|$, keep $k$ elements, and sort those by value.

#### Java

```java
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = Arrays.stream(arr)
                                .boxed()
                                .sorted((a, b) -> {
                                    int v = Math.abs(a - x) - Math.abs(b - x);
                                    return v == 0 ? a - b : v;
                                })
                                .collect(Collectors.toList());
        ans = ans.subList(0, k);
        Collections.sort(ans);
        return ans;
    }
}
```

### Solution 2: Two Pointers

> **Thinking**
>
> The answer is a contiguous slice. Shrink the farther endpoint until the window has length $k$; the slice is already sorted.

The $k$ elements closest to $x$ in a sorted array form one contiguous subarray.

Set pointers $l$ and $r$ at the two ends. Compare $x - \textit{arr}[l]$ with $\textit{arr}[r - 1] - x$ and drop the farther end until $r - l = k$.

The time complexity is $O(n)$.

#### Java

```java
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length;
        while (r - l > k) {
            if (x - arr[l] <= arr[r - 1] - x) {
                --r;
            } else {
                ++l;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i < r; ++i) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
```

### Solution 3: Binary Search

> **Thinking**
>
> Two pointers are linear. The best left bound in $[0,n-k]$ is monotone: compare $x-\textit{arr}[\textit{mid}]$ with $\textit{arr}[\textit{mid}+k]-x$ and binary-search it.

On top of method 2, binary-search the left boundary of the window of length $k$ over $[0, n - k]$. At $\textit{mid}$, move the window left when $x - \textit{arr}[\textit{mid}] \le \textit{arr}[\textit{mid} + k] - x$, and right otherwise.

The time complexity is $O(\log n)$.

#### Java

```java
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (x - arr[mid] <= arr[mid + k] - x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i < left + k; ++i) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
```
