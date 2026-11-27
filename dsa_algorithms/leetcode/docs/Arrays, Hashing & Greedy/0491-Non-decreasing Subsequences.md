# 491. Non-decreasing Subsequences

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/non-decreasing-subsequences/

---

[中文文档](/solution/0400-0499/0491.Non-decreasing%20Subsequences/README.md)

## Description

<p>Given an integer array <code>nums</code>, return <em>all the different possible non-decreasing subsequences of the given array with at least two elements</em>. You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,6,7,7]
<strong>Output:</strong> [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,4,3,2,1]
<strong>Output:</strong> [[4,4]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 15</code></li>
	<li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Every non-decreasing subsequence of length at least $2$, without duplicate lists. The array is unsorted, so we cannot sort then pick.
>
> DFS at index $u$: take $\textit{nums}[u]$ when it is $\ge \textit{last}$; skip it only when $\textit{nums}[u]\ne \textit{last}$. That second guard drops the duplicate of “skip a value then take the same value later”.
>
> $\textit{last}$ starts at a tiny sentinel so the first number is always eligible. Only sequences longer than $1$ are kept.

#### Java

```java
class Solution {
    private int[] nums;
    private List<List<Integer>> ans;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        ans = new ArrayList<>();
        dfs(0, -1000, new ArrayList<>());
        return ans;
    }

    private void dfs(int u, int last, List<Integer> t) {
        if (u == nums.length) {
            if (t.size() > 1) {
                ans.add(new ArrayList<>(t));
            }
            return;
        }
        if (nums[u] >= last) {
            t.add(nums[u]);
            dfs(u + 1, nums[u], t);
            t.remove(t.size() - 1);
        }
        if (nums[u] != last) {
            dfs(u + 1, last, t);
        }
    }
}
```
