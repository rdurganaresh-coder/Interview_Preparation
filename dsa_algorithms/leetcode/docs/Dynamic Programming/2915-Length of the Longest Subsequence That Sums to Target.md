# 2915. Length of the Longest Subsequence That Sums to Target

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/

---

[中文文档](/solution/2900-2999/2915.Length%20of%20the%20Longest%20Subsequence%20That%20Sums%20to%20Target/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> array of integers <code>nums</code>, and an integer <code>target</code>.</p>

<p>Return <em>the <strong>length of the longest subsequence</strong> of</em> <code>nums</code> <em>that sums up to</em> <code>target</code>. <em>If no such subsequence exists, return</em> <code>-1</code>.</p>

<p>A <strong>subsequence</strong> is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3,4,5], target = 9
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are 3 subsequences with a sum equal to 9: [4,5], [1,3,5], and [2,3,4]. The longest subsequences are [1,3,5], and [2,3,4]. Hence, the answer is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,1,3,2,1,5], target = 7
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 5 subsequences with a sum equal to 7: [4,3], [4,1,2], [4,2,1], [1,1,5], and [1,3,2,1]. The longest subsequence is [1,3,2,1]. Hence, the answer is 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,5,4,5], target = 3
<strong>Output:</strong> -1
<strong>Explanation:</strong> It can be shown that nums has no subsequence that sums up to 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>1 &lt;= target &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> The longest subsequence whose sum is exactly $\textit{target}$ is a 0-1 knapsack ($n,\textit{target} \le 1000$). Let $f[i][j]$ be the best length using the first $i$ numbers to make $j$, with unreachable states at $-\infty$.
>
> The recurrence takes the better of skipping $x$ and taking it. If $f[n][\textit{target}]$ is non-positive, no solution exists.

We define $f[i][j]$ as the length of the longest subsequence that selects several numbers from the first $i$ numbers and the sum of these numbers is exactly $j$. Initially, $f[0][0]=0$, and all other positions are $-\infty$.

For $f[i][j]$, we consider the $i$th number $x$. If we do not select $x$, then $f[i][j]=f[i-1][j]$. If we select $x$, then $f[i][j]=f[i-1][j-x]+1$, where $j\ge x$. Therefore, we have the state transition equation:

$$
f[i][j]=\max\{f[i-1][j],f[i-1][j-x]+1\}
$$

The final answer is $f[n][\textit{target}]$. If $f[n][\textit{target}]\le0$, there is no subsequence with a sum of $\textit{target}$, return $-1$.

The time complexity is $O(n \textit{target})$, and the space complexity is $O(n \textit{target})$, where $n$ is the length of the array, and $\textit{target}$ is the target value.

#### Java

```java
class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] f = new int[n + 1][target + 1];
        final int inf = 1 << 30;
        for (int[] g : f) {
            Arrays.fill(g, -inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            int x = nums.get(i - 1);
            for (int j = 0; j <= target; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= x) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - x] + 1);
                }
            }
        }
        return f[n][target] <= 0 ? -1 : f[n][target];
    }
}
```

### Solution 2: Optimized Dynamic Programming

> **Thinking**
>
> Method 1’s $f[i][j]$ depends only on the previous row, so the first index drops. Each number is used at most once, therefore the inner loop walks capacities downward. Space becomes $O(\textit{target})$ with the same answer.

$f[i][j]$ depends only on the previous row $f[i-1][\cdot]$, so the first dimension can be dropped. Each number is used at most once, so $j$ is updated from large to small. The space complexity becomes $O(\textit{target})$.

#### Java

```java
class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] f = new int[target + 1];
        final int inf = 1 << 30;
        Arrays.fill(f, -inf);
        f[0] = 0;
        for (int x : nums) {
            for (int j = target; j >= x; --j) {
                f[j] = Math.max(f[j], f[j - x] + 1);
            }
        }
        return f[target] <= 0 ? -1 : f[target];
    }
}
```
