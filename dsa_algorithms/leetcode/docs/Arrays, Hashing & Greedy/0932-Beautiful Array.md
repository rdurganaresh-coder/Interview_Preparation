# 932. Beautiful Array

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/beautiful-array/

---

[中文文档](/solution/0900-0999/0932.Beautiful%20Array/README.md)

## Description

<p>An array <code>nums</code> of length <code>n</code> is <strong>beautiful</strong> if:</p>

<ul>
	<li><code>nums</code> is a permutation of the integers in the range <code>[1, n]</code>.</li>
	<li>For every <code>0 &lt;= i &lt; j &lt; n</code>, there is no index <code>k</code> with <code>i &lt; k &lt; j</code> where <code>2 * nums[k] == nums[i] + nums[j]</code>.</li>
</ul>

<p>Given the integer <code>n</code>, return <em>any <strong>beautiful</strong> array </em><code>nums</code><em> of length </em><code>n</code>. There will be at least one valid answer for the given <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 4
<strong>Output:</strong> [2,1,4,3]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> [3,1,2,5,4]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A beautiful array forbids $2A_k=A_i+A_j$. The left side is even, so an odd/even pair $A_i,A_j$ is always safe. Affine-map a smaller beautiful array into the odds and the evens and concatenate; the map preserves beauty, and divide-and-conquer builds $1..n$.

#### Java

```java
class Solution {
    public int[] beautifulArray(int n) {
        if (n == 1) {
            return new int[] {1};
        }
        int[] left = beautifulArray((n + 1) >> 1);
        int[] right = beautifulArray(n >> 1);
        int[] ans = new int[n];
        int i = 0;
        for (int x : left) {
            ans[i++] = x * 2 - 1;
        }
        for (int x : right) {
            ans[i++] = x * 2;
        }
        return ans;
    }
}
```
