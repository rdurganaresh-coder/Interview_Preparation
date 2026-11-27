# 1. Two Sum

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/two-sum/

---

[中文文档](/solution/0000-0099/0001.Two%20Sum/README.md)

## Description

<p>You are given an array of integers <code>nums</code>&nbsp;and an integer <code>target</code>, return <em>indices of the two numbers such that they add up to <code>target</code></em>.</p>

<p>You may assume that each input would have <strong><em>exactly</em> one solution</strong>, and you may not use the <em>same</em> element twice.</p>

<p>You can return the answer in any order.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<p><strong>Input:</strong> <code>nums = [2,7,11,15], target = 9</code></p>

<p><strong>Output:</strong> <code>[0,1]</code></p>

<p><strong>Explanation:</strong></p>

<p>The sum of <code>nums[0]</code> and <code>nums[1]</code> is <code>2 + 7 = 9</code>, which equals the target. Therefore, the indices <code>[0, 1]</code> are returned.</p>

<p><strong>Example 2:</strong></p>

<p><strong>Input:</strong> <code>nums = [3,2,4], target = 6</code></p>

<p><strong>Output:</strong> <code>[1,2]</code></p>

<p><strong>Explanation:</strong></p>

<p>The sum of <code>nums[1]</code> and <code>nums[2]</code> is <code>2 + 4 = 6</code>, which equals the target. Therefore, the indices <code>[1, 2]</code> are returned.</p>

<p><strong>Example 3:</strong></p>

<p><strong>Input:</strong> <code>nums = [3,3], target = 6</code></p>

<p><strong>Output:</strong> <code>[0,1]</code></p>

<p><strong>Explanation:</strong></p>

<p>The sum of <code>nums[0]</code> and <code>nums[1]</code> is <code>3 + 3 = 6</code>, which equals the target. Therefore, the indices <code>[0, 1]</code> are returned.</p>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
	<li><strong>Only one valid answer exists.</strong></li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:&nbsp;</strong>Can you come up with an algorithm that is less than <code>O(n<sup>2</sup>)</code><font face="monospace">&nbsp;</font>time complexity?

## Solutions

### Solution 1: Hash Table

> **Thinking**
>
> The first idea is a nested loop: pick $x$, then scan for $\textit{target}-x$. Correct, but $O(n^2)$. $n \le 10^4$ might pass, yet the follow-up asks for faster.
>
> The bottleneck is repeatedly searching for the complement among numbers already seen. A hash table makes that lookup expected $O(1)$. Walk once, storing value $\to$ index: when we see $x$, ask whether $\textit{target}-x$ already appeared; if yes, return the two indices; if not, store $x$.
>
> Look up before inserting. Insert-then-lookup would reuse the same index on $[3,3]$, $\textit{target}=6$. Lookup-first guarantees the match is an earlier index.

We can use a hash table $d$ to store each element and its corresponding index.

Traverse the array $\textit{nums}$, for the current element $\textit{nums}[i]$, we first check if $\textit{target} - \textit{nums}[i]$ is in the hash table $d$. If it is in $d$, it means the $\textit{target}$ value has been found, and we return the indices of $\textit{target} - \textit{nums}[i]$ and $i$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0;; ++i) {
            int x = nums[i];
            int y = target - x;
            if (d.containsKey(y)) {
                return new int[] {d.get(y), i};
            }
            d.put(x, i);
        }
    }
}
```
