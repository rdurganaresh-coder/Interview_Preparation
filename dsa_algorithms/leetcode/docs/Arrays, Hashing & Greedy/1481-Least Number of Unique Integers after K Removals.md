# 1481. Least Number of Unique Integers after K Removals

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

---

[中文文档](/solution/1400-1499/1481.Least%20Number%20of%20Unique%20Integers%20after%20K%20Removals/README.md)

## Description

<p>Given an array of integers&nbsp;<code>arr</code>&nbsp;and an integer <code>k</code>.&nbsp;Find the <em>least number of unique integers</em>&nbsp;after removing <strong>exactly</strong> <code>k</code> elements<b>.</b></p>

<ol>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input: </strong>arr = [5,5,4], k = 1
<strong>Output: </strong>1
<strong>Explanation</strong>: Remove the single 4, only 5 is left.
</pre>

<strong class="example">Example 2:</strong>

<pre>
<strong>Input: </strong>arr = [4,3,1,1,3,3,2], k = 3
<strong>Output: </strong>2
<strong>Explanation</strong>: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length&nbsp;&lt;= 10^5</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 10^9</code></li>
	<li><code>0 &lt;= k&nbsp;&lt;= arr.length</code></li>
</ul>

## Solutions

### Solution 1: Hash Table + Sorting

> **Thinking**
>
> After $k$ deletions we want as few distinct values as possible, so delete the rarest first. Sort frequencies and spend $k$ on them; when $k$ runs out, the leftover distinct count is the answer.

We use the hash table $\textit{cnt}$ to count the number of times each integer in the array $\textit{arr}$ appears, and then sort the values in $\textit{cnt}$ in ascending order, and record them in the array $\textit{nums}$.

Next, we traverse the array $\textit{nums}$. For the current value that we traverse to $\textit{nums}[i]$, we subtract $k$ by $\textit{nums}[i]$. If $k \lt 0$, it means that we have removed $k$ elements, and the minimum number of different integers in the array is the length of $\textit{nums}$ minus the index $i$ that we traverse to at the current time. Return directly.

If we traverse to the end, it means that we have removed all the elements, and the minimum number of different integers in the array is $0$.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{arr}$.

#### Java

```java
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) {
            cnt.merge(x, 1, Integer::sum);
        }
        List<Integer> nums = new ArrayList<>(cnt.values());
        Collections.sort(nums);
        for (int i = 0, m = nums.size(); i < m; ++i) {
            k -= nums.get(i);
            if (k < 0) {
                return m - i;
            }
        }
        return 0;
    }
}
```
