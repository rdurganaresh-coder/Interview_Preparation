# 2200. Find All K-Distant Indices in an Array

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/

---

[中文文档](/solution/2200-2299/2200.Find%20All%20K-Distant%20Indices%20in%20an%20Array/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> and two integers <code>key</code> and <code>k</code>. A <strong>k-distant index</strong> is an index <code>i</code> of <code>nums</code> for which there exists at least one index <code>j</code> such that <code>|i - j| &lt;= k</code> and <code>nums[j] == key</code>.</p>

<p>Return <em>a list of all k-distant indices sorted in <strong>increasing order</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,4,9,1,3,9,5], key = 9, k = 1
<strong>Output:</strong> [1,2,3,4,5,6]
<strong>Explanation:</strong> Here, <code>nums[2] == key</code> and <code>nums[5] == key.
- For index 0, |0 - 2| &gt; k and |0 - 5| &gt; k, so there is no j</code> where <code>|0 - j| &lt;= k</code> and <code>nums[j] == key. Thus, 0 is not a k-distant index.
- For index 1, |1 - 2| &lt;= k and nums[2] == key, so 1 is a k-distant index.
- For index 2, |2 - 2| &lt;= k and nums[2] == key, so 2 is a k-distant index.
- For index 3, |3 - 2| &lt;= k and nums[2] == key, so 3 is a k-distant index.
- For index 4, |4 - 5| &lt;= k and nums[5] == key, so 4 is a k-distant index.
- For index 5, |5 - 5| &lt;= k and nums[5] == key, so 5 is a k-distant index.
- For index 6, |6 - 5| &lt;= k and nums[5] == key, so 6 is a k-distant index.
</code>Thus, we return [1,2,3,4,5,6] which is sorted in increasing order. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,2,2,2,2], key = 2, k = 2
<strong>Output:</strong> [0,1,2,3,4]
<strong>Explanation:</strong> For all indices i in nums, there exists some index j such that |i - j| &lt;= k and nums[j] == key, so every index is a k-distant index. 
Hence, we return [0,1,2,3,4].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>key</code> is an integer from the array <code>nums</code>.</li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> We need every index within distance $k$ of some occurrence of $\textit{key}$. Checking a window of width $2k$ around each $i$, or scanning the whole array for a valid $j$, is $O(n^2)$. With $n \le 10^3$ this bound is acceptable.
>
> Only existence of a $\textit{key}$ in $[i-k, i+k]$ matters. Fix $i$, scan $j$, and as soon as $|i-j| \le k$ and $\textit{nums}[j] = \textit{key}$, record $i$ and leave the inner loop.

We enumerate the index $i$ in the range $[0, n)$, and for each index $i$, we enumerate the index $j$ in the range $[0, n)$. If $|i - j| \leq k$ and $\textit{nums}[j] = \textit{key}$, then $i$ is a K-nearest neighbor index. We add $i$ to the answer array, then break the inner loop and enumerate the next index $i$.

The time complexity is $O(n^2)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (Math.abs(i - j) <= k && nums[j] == key) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}
```

### Solution 2: Preprocessing + Binary Search

> **Thinking**
>
> Solution 1 rescan the array for every $i$ and never reuses the known positions of $\textit{key}$. Those positions can be collected once and queried in logarithmic time.
>
> Store every index of $\textit{key}$ in a sorted list $\textit{idx}$. For each $i$, binary-search $\textit{idx}$ for a value in $[i-k, i+k]$ via $\textit{bisect\_left}$ and $\textit{bisect\_right}$. If $l \le r$, then $i$ is valid. The time becomes $O(n \log n)$.

We can preprocess to get the indices of all elements equal to $\textit{key}$, recorded in the array $\textit{idx}$. All index elements in the array $\textit{idx}$ are sorted in ascending order.

Next, we enumerate the index $i$. For each index $i$, we can use binary search to find elements in the range $[i - k, i + k]$ in the array $\textit{idx}$. If there are elements, then $i$ is a K-nearest neighbor index. We add $i$ to the answer array.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                idx.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int l = Collections.binarySearch(idx, i - k);
            int r = Collections.binarySearch(idx, i + k + 1);
            l = l < 0 ? -l - 1 : l;
            r = r < 0 ? -r - 2 : r - 1;
            if (l <= r) {
                ans.add(i);
            }
        }
        return ans;
    }
}
```

### Solution 3: Two Pointers

> **Thinking**
>
> Solution 2 already avoids rescanning $\textit{key}$, but still stores an index array and binary-searches twice per $i$. As $i$ increases, the leftmost $j$ with $j \ge i-k$ and $\textit{nums}[j] = \textit{key}$ only moves right.
>
> Advance a pointer $j$ monotonically: increment while $j < i-k$ or the current cell is not $\textit{key}$. If afterwards $j \le i+k$, then $i$ is a K-distant index. One pass, $O(1)$ extra space.

We enumerate the index $i$, and use a pointer $j$ to point to the smallest index that satisfies $j \geq i - k$ and $\textit{nums}[j] = \textit{key}$. If $j$ exists and $j \leq i + k$, then $i$ is a K-nearest neighbor index. We add $i$ to the answer array.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 0; i < n; ++i) {
            while (j < i - k || (j < n && nums[j] != key)) {
                ++j;
            }
            if (j < n && j <= i + k) {
                ans.add(i);
            }
        }
        return ans;
    }
}
```
