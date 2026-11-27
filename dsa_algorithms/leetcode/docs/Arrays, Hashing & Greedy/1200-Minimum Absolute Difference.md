# 1200. Minimum Absolute Difference

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/minimum-absolute-difference/

---

[中文文档](/solution/1200-1299/1200.Minimum%20Absolute%20Difference/README.md)

## Description

<p>Given an array of <strong>distinct</strong> integers <code>arr</code>, find all pairs of elements with the minimum absolute difference of any two elements.</p>

<p>Return a list of pairs in ascending order(with respect to pairs), each pair <code>[a, b]</code> follows</p>

<ul>
	<li><code>a, b</code> are from <code>arr</code></li>
	<li><code>a &lt; b</code></li>
	<li><code>b - a</code> equals to the minimum absolute difference of any two elements in <code>arr</code></li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [4,2,1,3]
<strong>Output:</strong> [[1,2],[2,3],[3,4]]
<strong>Explanation: </strong>The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,3,6,10,15]
<strong>Output:</strong> [[1,3]]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [3,8,-10,23,19,-4,-14,27]
<strong>Output:</strong> [[-14,-10],[19,23],[23,27]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>6</sup> &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Sorting

> **Thinking**
>
> Enumerating all pairs is $O(n^2)$, which is too slow for $n \le 10^5$.
>
> After sorting, the gap between any two values is at least the sum of adjacent gaps between them, so the global minimum absolute difference occurs only between neighbors.
>
> We therefore sort $\textit{arr}$, scan adjacent differences for the minimum $mi$, then collect every adjacent pair whose difference equals $mi$. Sorting shrinks the candidate set; the two linear passes compute the extremum and gather the answer.

According to the problem description, we need to find the minimum absolute difference between any two elements in the array $\textit{arr}$. Therefore, we can first sort the array $\textit{arr}$, then traverse the adjacent elements to get the minimum absolute difference $mi$.

Finally, we traverse the adjacent elements again to find all pairs of elements where the minimum absolute difference equals $mi$.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the length of the array $\textit{arr}$.

#### Java

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int mi = 1 << 30;
        for (int i = 0; i < n - 1; ++i) {
            mi = Math.min(mi, arr[i + 1] - arr[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            if (arr[i + 1] - arr[i] == mi) {
                ans.add(List.of(arr[i], arr[i + 1]));
            }
        }
        return ans;
    }
}
```
