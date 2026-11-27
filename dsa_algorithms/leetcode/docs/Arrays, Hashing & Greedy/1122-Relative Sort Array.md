# 1122. Relative Sort Array

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/relative-sort-array/

---

[中文文档](/solution/1100-1199/1122.Relative%20Sort%20Array/README.md)

## Description

<p>Given two arrays <code>arr1</code> and <code>arr2</code>, the elements of <code>arr2</code> are distinct, and all elements in <code>arr2</code> are also in <code>arr1</code>.</p>

<p>Sort the elements of <code>arr1</code> such that the relative ordering of items in <code>arr1</code> are the same as in <code>arr2</code>. Elements that do not appear in <code>arr2</code> should be placed at the end of <code>arr1</code> in <strong>ascending</strong> order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
<strong>Output:</strong> [2,2,2,1,4,3,3,9,6,7,19]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
<strong>Output:</strong> [22,28,8,6,17,44]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr1.length, arr2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= arr1[i], arr2[i] &lt;= 1000</code></li>
	<li>All the elements of <code>arr2</code> are <strong>distinct</strong>.</li>
	<li>Each&nbsp;<code>arr2[i]</code> is in <code>arr1</code>.</li>
</ul>

## Solutions

### Solution 1: Custom Sorting

> **Thinking**
>
> The sort key is the relative order in $\textit{arr2}$; values absent from $\textit{arr2}$ follow, sorted by themselves. A map stores each $\textit{arr2}$ index; the comparator uses that index if present and $1000+x$ otherwise, so one sort handles both groups. Values in $\textit{arr2}$ are unique, so indices are a stable order.

First, we use a hash table $\textit{pos}$ to record the position of each element in array $\textit{arr2}$. Then, we map each element in array $\textit{arr1}$ to a tuple $(\textit{pos}.\textit{get}(x, 1000 + x), x)$, and sort these tuples. Finally, we take out the second element of all tuples and return it.

The time complexity is $O(n \log n + m)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the lengths of arrays $\textit{arr1}$ and $\textit{arr2}$, respectively.

#### Java

```java
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> pos = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; ++i) {
            pos.put(arr2[i], i);
        }
        int[][] arr = new int[arr1.length][0];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = new int[] {arr1[i], pos.getOrDefault(arr1[i], arr2.length + arr1[i])};
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < arr.length; ++i) {
            arr1[i] = arr[i][0];
        }
        return arr1;
    }
}
```

### Solution 2: Counting Sort

> **Thinking**
>
> Method 1's comparison sort is $O(n \log n)$. When the value range is small, count frequencies in $\textit{arr1}$, emit values in $\textit{arr2}$ order, then scan the leftovers by value, which is linear.

We can use the idea of counting sort. First, count the occurrence of each element in array $\textit{arr1}$. Then, according to the order in array $\textit{arr2}$, put the elements in $\textit{arr1}$ into the answer array $\textit{ans}$ according to their occurrence. Finally, we traverse all elements in $\textit{arr1}$ and put the elements that do not appear in $\textit{arr2}$ in ascending order at the end of the answer array $\textit{ans}$.

The time complexity is $O(n + m)$, and the space complexity is $O(n)$, where $n$ and $m$ are the lengths of arrays $\textit{arr1}$ and $\textit{arr2}$ respectively.

#### Java

```java
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        int mi = 1001, mx = 0;
        for (int x : arr1) {
            ++cnt[x];
            mi = Math.min(mi, x);
            mx = Math.max(mx, x);
        }
        int m = arr1.length;
        int[] ans = new int[m];
        int i = 0;
        for (int x : arr2) {
            while (cnt[x] > 0) {
                --cnt[x];
                ans[i++] = x;
            }
        }
        for (int x = mi; x <= mx; ++x) {
            while (cnt[x] > 0) {
                --cnt[x];
                ans[i++] = x;
            }
        }
        return ans;
    }
}
```
