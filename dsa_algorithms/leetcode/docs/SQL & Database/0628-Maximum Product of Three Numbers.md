# 628. Maximum Product of Three Numbers

**Difficulty:** Easy  
**Category:** SQL & Database  
**LeetCode:** https://leetcode.com/problems/maximum-product-of-three-numbers/

---

[中文文档](/solution/0600-0699/0628.Maximum%20Product%20of%20Three%20Numbers/README.md)

## Description

<p>You are given an integer array <code>nums</code>.</p>

<p>Find three numbers whose product is <strong>maximum</strong> and return the <strong>maximum</strong> product.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,-3]</span></p>

<p><strong>Output:</strong> <span class="example-io">-6</span></p>

<p><strong>Explanation:</strong></p>

<p>The only three numbers are 1, 2, and -3, so the maximum product is <code>1 * 2 * -3 = -6</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">24</span></p>

<p><strong>Explanation:</strong></p>

<p>The largest product comes from the three greatest numbers: <code>2 * 3 * 4 = 24</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [-1,-2,-3]</span></p>

<p><strong>Output:</strong> <span class="example-io">-6</span></p>

<p><strong>Explanation:</strong></p>

<p>The only three numbers are -1, -2, and -3, so the maximum product is <code>(-1) * (-2) * (-3) = -6</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;=&nbsp;10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Sorting + Case Analysis

> **Thinking**
>
> The maximum product of three numbers is either the three largest values or the two smallest (possibly negative) times the largest. Sorting is cheap for $n\le 10^4$.
>
> After sorting, compare $\textit{nums}[-1]\times \textit{nums}[-2]\times \textit{nums}[-3]$ with $\textit{nums}[-1]\times \textit{nums}[0]\times \textit{nums}[1]$.

First, we sort the array $\textit{nums}$, and then discuss two cases:

- If $\textit{nums}$ contains all non-negative or all non-positive numbers, the answer is the product of the last three numbers, i.e., $\textit{nums}[n-1] \times \textit{nums}[n-2] \times \textit{nums}[n-3]$;
- If $\textit{nums}$ contains both positive and negative numbers, the answer could be the product of the two smallest negative numbers and the largest positive number, i.e., $\textit{nums}[n-1] \times \textit{nums}[0] \times \textit{nums}[1]$, or the product of the last three numbers, i.e., $\textit{nums}[n-1] \times \textit{nums}[n-2] \times \textit{nums}[n-3]$.

Finally, return the maximum of the two cases.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int b = nums[n - 1] * nums[0] * nums[1];
        return Math.max(a, b);
    }
}
```

### Solution 2: Single Pass

> **Thinking**
>
> Sorting is more than we need: only the two smallest and three largest values matter. A linear pass (or `nlargest`) keeps those five extrema.

We can avoid sorting the array by maintaining five variables: $\textit{mi1}$ and $\textit{mi2}$ represent the two smallest numbers in the array, while $\textit{mx1}$, $\textit{mx2}$, and $\textit{mx3}$ represent the three largest numbers in the array.

Finally, return $\max(\textit{mi1} \times \textit{mi2} \times \textit{mx1}, \textit{mx1} \times \textit{mx2} \times \textit{mx3})$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int maximumProduct(int[] nums) {
        final int inf = 1 << 30;
        int mi1 = inf, mi2 = inf;
        int mx1 = -inf, mx2 = -inf, mx3 = -inf;
        for (int x : nums) {
            if (x < mi1) {
                mi2 = mi1;
                mi1 = x;
            } else if (x < mi2) {
                mi2 = x;
            }
            if (x > mx1) {
                mx3 = mx2;
                mx2 = mx1;
                mx1 = x;
            } else if (x > mx2) {
                mx3 = mx2;
                mx2 = x;
            } else if (x > mx3) {
                mx3 = x;
            }
        }
        return Math.max(mi1 * mi2 * mx1, mx1 * mx2 * mx3);
    }
}
```
