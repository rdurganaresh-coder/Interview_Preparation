# 1191. K-Concatenation Maximum Sum

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/k-concatenation-maximum-sum/

---

[中文文档](/solution/1100-1199/1191.K-Concatenation%20Maximum%20Sum/README.md)

## Description

<p>Given an integer array <code>arr</code> and an integer <code>k</code>, modify the array by repeating it <code>k</code> times.</p>

<p>For example, if <code>arr = [1, 2]</code> and <code>k = 3 </code>then the modified array will be <code>[1, 2, 1, 2, 1, 2]</code>.</p>

<p>Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be <code>0</code> and its sum in that case is <code>0</code>.</p>

<p>As the answer can be very large, return the answer <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [1, 2], k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">9</span></p>

<p><strong>Explanation:</strong></p>

<p>The concatenated array is <code>[1, 2, 1, 2, 1, 2]</code>.</p>

<p>The maximum-sum subarray is the entire array, with sum 1 + 2 + 1 + 2 + 1 + 2 = 9.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [1, -2, 1], k = 5</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>The concatenated array is <code>[1, -2, 1, 1, -2, 1, 1, -2, 1, 1, -2, 1, 1, -2, 1]</code>.</p>

<p>The maximum-sum subarray is <code>[1, 1]</code>, formed by the last element of one copy and the first element of the next copy, with sum 1 + 1 = 2.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [-1, -2], k = 7</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>Every element in the concatenated array is negative, so no subarray has a positive sum. Therefore, the maximum possible sum is 0.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= arr[i] &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Prefix Sum + Case Discussion

> **Thinking**
>
> After repeating $\textit{arr}$ $k$ times, an optimal subarray spans at most the whole concatenation. Kadane on one copy gives $\textit{mxSub}$, plus the max prefix and min prefix (hence max suffix). For $k=1$ that is the answer; otherwise also consider prefix+suffix, and if the total is positive add $k-2$ full copies. $k$ can be $10^5$, so we never materialize the concatenation.

We denote the sum of all elements in the array $\textit{arr}$ as $s$, the maximum prefix sum as $\textit{mxPre}$, the minimum prefix sum as $\textit{miPre}$, and the maximum subarray sum as $\textit{mxSub}$.

We traverse the array $\textit{arr}$. For each element $x$, we update $s = s + x$, $\textit{mxPre} = \max(\textit{mxPre}, s)$, $\textit{miPre} = \min(\textit{miPre}, s)$, $\textit{mxSub} = \max(\textit{mxSub}, s - \textit{miPre})$.

Next, we consider the value of $k$:

- When $k = 1$, the answer is $\textit{mxSub}$.
- When $k \ge 2$, if the maximum subarray spans two $\textit{arr}$, then the answer is $\textit{mxPre} + \textit{mxSuf}$, where $\textit{mxSuf} = s - \textit{miPre}$.
- When $k \ge 2$ and $s > 0$, if the maximum subarray spans three $\textit{arr}$, then the answer is $(k - 2) \times s + \textit{mxPre} + \textit{mxSuf}$.

Finally, we return the result of the answer modulo $10^9 + 7$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{arr}$.

#### Java

```java
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long s = 0, mxPre = 0, miPre = 0, mxSub = 0;
        for (int x : arr) {
            s += x;
            mxPre = Math.max(mxPre, s);
            miPre = Math.min(miPre, s);
            mxSub = Math.max(mxSub, s - miPre);
        }
        long ans = mxSub;
        final int mod = (int) 1e9 + 7;
        if (k == 1) {
            return (int) (ans % mod);
        }
        long mxSuf = s - miPre;
        ans = Math.max(ans, mxPre + mxSuf);
        if (s > 0) {
            ans = Math.max(ans, (k - 2) * s + mxPre + mxSuf);
        }
        return (int) (ans % mod);
    }
}
```
