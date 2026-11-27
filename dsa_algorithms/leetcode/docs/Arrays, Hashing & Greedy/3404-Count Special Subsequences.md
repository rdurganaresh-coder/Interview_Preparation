# 3404. Count Special Subsequences

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-special-subsequences/

---

[中文文档](/solution/3400-3499/3404.Count%20Special%20Subsequences/README.md)

## Description

<p>You are given an array <code>nums</code> consisting of positive integers.</p>

<p>A <strong>special subsequence</strong> is defined as a <span data-keyword="subsequence-array">subsequence</span> of length 4, represented by indices <code>(p, q, r, s)</code>, where <code>p &lt; q &lt; r &lt; s</code>. This subsequence <strong>must</strong> satisfy the following conditions:</p>

<ul>
	<li><code>nums[p] * nums[r] == nums[q] * nums[s]</code></li>
	<li>There must be <em>at least</em> <strong>one</strong> element between each pair of indices. In other words, <code>q - p &gt; 1</code>, <code>r - q &gt; 1</code> and <code>s - r &gt; 1</code>.</li>
</ul>

<p>Return the <em>number</em> of different <strong>special</strong> <strong>subsequences</strong> in <code>nums</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4,3,6,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>There is one special subsequence in <code>nums</code>.</p>

<ul>
	<li><code>(p, q, r, s) = (0, 2, 4, 6)</code>:
    <ul>
    	<li>This corresponds to elements <code>(1, 3, 3, 1)</code>.</li>
    	<li><code>nums[p] * nums[r] = nums[0] * nums[4] = 1 * 3 = 3</code></li>
    	<li><code>nums[q] * nums[s] = nums[2] * nums[6] = 3 * 1 = 3</code></li>
    </ul>
    </li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [3,4,3,4,3,4,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>There are three special subsequences in <code>nums</code>.</p>

<ul>
	<li><code>(p, q, r, s) = (0, 2, 4, 6)</code>:
    <ul>
    	<li>This corresponds to elements <code>(3, 3, 3, 3)</code>.</li>
    	<li><code>nums[p] * nums[r] = nums[0] * nums[4] = 3 * 3 = 9</code></li>
    	<li><code>nums[q] * nums[s] = nums[2] * nums[6] = 3 * 3 = 9</code></li>
    </ul>
    </li>
    <li><code>(p, q, r, s) = (1, 3, 5, 7)</code>:
    <ul>
    	<li>This corresponds to elements <code>(4, 4, 4, 4)</code>.</li>
    	<li><code>nums[p] * nums[r] = nums[1] * nums[5] = 4 * 4 = 16</code></li>
    	<li><code>nums[q] * nums[s] = nums[3] * nums[7] = 4 * 4 = 16</code></li>
    </ul>
    </li>
    <li><code>(p, q, r, s) = (0, 2, 5, 7)</code>:
    <ul>
    	<li>This corresponds to elements <code>(3, 3, 4, 4)</code>.</li>
    	<li><code>nums[p] * nums[r] = nums[0] * nums[5] = 3 * 4 = 12</code></li>
    	<li><code>nums[q] * nums[s] = nums[2] * nums[7] = 3 * 4 = 12</code></li>
    </ul>
    </li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>7 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A special subsequence needs spaced indices and $a/b=c/d$. A four-fold enumeration is $O(n^4)$ for $n\le 1000$. Even pairing the two ends twice still needs a cheap equality test for ratios.
>
> Equal ratios mean the reduced ordered pairs coincide. If we index every valid right pair $(c,d)$ by its reduced key, a left pair $(a,b)$ can be queried in $O(1)$.
>
> We first count all legal $(r,s)$ under the key $(\lfloor d/g\rfloor,\lfloor c/g\rfloor)$. Then we scan $q$ from left to right: answer queries that use this $q$ as the second term, and remove $(c,d)$ pairs that would violate $p<q<r<s$ after $q$ advances.

#### Java

```java
class Solution {
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int r = 4; r < n - 2; ++r) {
            int c = nums[r];
            for (int s = r + 2; s < n; ++s) {
                int d = nums[s];
                int g = gcd(c, d);
                cnt.merge(((d / g) << 12) | (c / g), 1, Integer::sum);
            }
        }
        long ans = 0;
        for (int q = 2; q < n - 4; ++q) {
            int b = nums[q];
            for (int p = 0; p < q - 1; ++p) {
                int a = nums[p];
                int g = gcd(a, b);
                ans += cnt.getOrDefault(((a / g) << 12) | (b / g), 0);
            }
            int c = nums[q + 2];
            for (int s = q + 4; s < n; ++s) {
                int d = nums[s];
                int g = gcd(c, d);
                cnt.merge(((d / g) << 12) | (c / g), -1, Integer::sum);
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
```
