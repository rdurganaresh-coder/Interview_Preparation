# 1911. Maximum Alternating Subsequence Sum

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/maximum-alternating-subsequence-sum/

---

[中文文档](/solution/1900-1999/1911.Maximum%20Alternating%20Subsequence%20Sum/README.md)

## Description

<p>The <strong>alternating sum</strong> of a <strong>0-indexed</strong> array is defined as the <strong>sum</strong> of the elements at <strong>even</strong> indices <strong>minus</strong> the <strong>sum</strong> of the elements at <strong>odd</strong> indices.</p>

<ul>
	<li>For example, the alternating sum of <code>[4,2,5,3]</code> is <code>(4 + 5) - (2 + 3) = 4</code>.</li>
</ul>

<p>Given an array <code>nums</code>, return <em>the <strong>maximum alternating sum</strong> of any subsequence of </em><code>nums</code><em> (after <strong>reindexing</strong> the elements of the subsequence)</em>.</p>

<ul>
</ul>

<p>A <strong>subsequence</strong> of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements&#39; relative order. For example, <code>[2,7,4]</code> is a subsequence of <code>[4,<u>2</u>,3,<u>7</u>,2,1,<u>4</u>]</code> (the underlined elements), while <code>[2,4,2]</code> is not.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [<u>4</u>,<u>2</u>,<u>5</u>,3]
<strong>Output:</strong> 7
<strong>Explanation:</strong> It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,6,7,<u>8</u>]
<strong>Output:</strong> 8
<strong>Explanation:</strong> It is optimal to choose the subsequence [8] with alternating sum 8.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [<u>6</u>,2,<u>1</u>,2,4,<u>5</u>]
<strong>Output:</strong> 10
<strong>Explanation:</strong> It is optimal to choose the subsequence [6,1,5] with alternating sum (6 + 5) - 1 = 10.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Dynamic Programming

> **Thinking**
>
> Enumerating subsequences is exponential. With $n\le 10^5$ we need a linear DP on the parity of the last chosen index.
>
> Let $f[i]$ be the best alternating sum of the first $i$ elements whose last pick sits on an odd slot (subtracted), and $g[i]$ the best whose last pick sits on an even slot (added). Element $x$ is either appended to the opposite parity or skipped.
>
> The recurrences are $f[i]=\max(g[i-1]-x,f[i-1])$ and $g[i]=\max(f[i-1]+x,g[i-1])$; the answer is the larger of $f[n]$ and $g[n]$.

#### Java

```java
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] f = new long[n + 1];
        long[] g = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = Math.max(g[i - 1] - nums[i - 1], f[i - 1]);
            g[i] = Math.max(f[i - 1] + nums[i - 1], g[i - 1]);
        }
        return Math.max(f[n], g[n]);
    }
}
```

### Solution 2: Dynamic Programming (Space Optimization)

> **Thinking**
>
> Only the previous $f$ and $g$ are read, so two scalars updated left to right replace the arrays and drop extra space to $O(1)$.

$f[i]$ and $g[i]$ depend only on the previous index, so two variables are enough and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public long maxAlternatingSum(int[] nums) {
        long f = 0, g = 0;
        for (int x : nums) {
            long ff = Math.max(g - x, f);
            long gg = Math.max(f + x, g);
            f = ff;
            g = gg;
        }
        return Math.max(f, g);
    }
}
```
