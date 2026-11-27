# 2941. Maximum GCD-Sum of a Subarray

**Difficulty:** Hard  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/maximum-gcd-sum-of-a-subarray/

---

[中文文档](/solution/2900-2999/2941.Maximum%20GCD-Sum%20of%20a%20Subarray/README.md)

## Description

<p>You are given an array of integers <code>nums</code> and an integer <code>k</code>.</p>

<p>The <strong>gcd-sum</strong> of an array <code>a</code> is calculated as follows:</p>

<ul>
	<li>Let <code>s</code> be the sum of all the elements of <code>a</code>.</li>
	<li>Let <code>g</code> be the <strong>greatest common divisor</strong> of all the elements of <code>a</code>.</li>
	<li>The gcd-sum of <code>a</code> is equal to <code>s * g</code>.</li>
</ul>

<p>Return <em>the <strong>maximum gcd-sum</strong> of a subarray of</em> <code>nums</code> <em>with at least</em> <code>k</code> <em>elements.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,1,4,4,4,2], k = 2
<strong>Output:</strong> 48
<strong>Explanation:</strong> We take the subarray [4,4,4], the gcd-sum of this array is 4 * (4 + 4 + 4) = 48.
It can be shown that we can not select any other subarray with a gcd-sum greater than 48.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [7,3,9,4], k = 1
<strong>Output:</strong> 81
<strong>Explanation:</strong> We take the subarray [9], the gcd-sum of this array is 9 * 9 = 81.
It can be shown that we can not select any other subarray with a gcd-sum greater than 81.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The score of a subarray is its sum times its GCD, and the length is at least $k$. Trying every subarray is too slow for large $n$. Extending the right end only shrinks previous GCDs, and the number of distinct values is $O(\log A)$.
>
> Store in $f$ the leftmost index of each GCD. After reading $v$, take $\textit{gcd}$ with the old pairs, deduplicate into $g$, and append $(i,v)$. For segments of length at least $k$, multiply the prefix sum by that GCD and update the answer.

#### Java

```java
class Solution {
    public long maxGcdSum(int[] nums, int k) {
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        List<int[]> f = new ArrayList<>();
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            List<int[]> g = new ArrayList<>();
            for (var e : f) {
                int j = e[0], x = e[1];
                int y = gcd(x, nums[i]);
                if (g.isEmpty() || g.get(g.size() - 1)[1] != y) {
                    g.add(new int[] {j, y});
                }
            }
            f = g;
            f.add(new int[] {i, nums[i]});
            for (var e : f) {
                int j = e[0], x = e[1];
                if (i - j + 1 >= k) {
                    ans = Math.max(ans, (s[i + 1] - s[j]) * x);
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```
