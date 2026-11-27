# 823. Binary Trees With Factors

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/binary-trees-with-factors/

---

[中文文档](/solution/0800-0899/0823.Binary%20Trees%20With%20Factors/README.md)

## Description

<p>Given an array of unique integers, <code>arr</code>, where each integer <code>arr[i]</code> is strictly greater than <code>1</code>.</p>

<p>We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node&#39;s value should be equal to the product of the values of its children.</p>

<p>Return <em>the number of binary trees we can make</em>. The answer may be too large so return the answer <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [2,4]
<strong>Output:</strong> 3
<strong>Explanation:</strong> We can make these trees: <code>[2], [4], [4, 2, 2]</code></pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [2,4,5,10]
<strong>Output:</strong> 7
<strong>Explanation:</strong> We can make these trees: <code>[2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]</code>.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 1000</code></li>
	<li><code>2 &lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
	<li>All the values of <code>arr</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> We count binary trees whose nodes come from $\textit{arr}$ and whose children multiply to the parent. Values are distinct and $n\le 1000$, so process them in increasing order so children are ready before parents.
>
> $f[i]$ is the number of trees rooted at $\textit{arr}[i]$. For each left child $b$, if $a/b$ is also present, add $f[b]\cdot f[c]$. Every value has the single-node tree, and the answer is the sum of $f$ modulo $10^9+7$.

#### Java

```java
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        final int mod = (int) 1e9 + 7;
        Arrays.sort(arr);
        int n = arr.length;
        long[] f = new long[n];
        Arrays.fill(f, 1);
        Map<Integer, Integer> idx = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            idx.put(arr[i], i);
        }
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            for (int j = 0; j < i; ++j) {
                int b = arr[j];
                if (a % b == 0) {
                    int c = a / b;
                    if (idx.containsKey(c)) {
                        int k = idx.get(c);
                        f[i] = (f[i] + f[j] * f[k]) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for (long v : f) {
            ans = (ans + v) % mod;
        }
        return (int) ans;
    }
}
```
