# 923. 3Sum With Multiplicity

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/3sum-with-multiplicity/

---

[中文文档](/solution/0900-0999/0923.3Sum%20With%20Multiplicity/README.md)

## Description

<p>Given an integer array <code>arr</code>, and an integer <code>target</code>, return the number of tuples <code>i, j, k</code> such that <code>i &lt; j &lt; k</code> and <code>arr[i] + arr[j] + arr[k] == target</code>.</p>

<p>As the answer can be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,1,2,2,3,3,4,4,5,5], target = 8
<strong>Output:</strong> 20
<strong>Explanation: </strong>
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,1,2,2,2,2], target = 5
<strong>Output:</strong> 12
<strong>Explanation: </strong>
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [2,1,3], target = 6
<strong>Output:</strong> 1
<strong>Explanation:</strong> (1, 2, 3) occured one time in the array so we return 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= arr.length &lt;= 3000</code></li>
	<li><code>0 &lt;= arr[i] &lt;= 100</code></li>
	<li><code>0 &lt;= target &lt;= 300</code></li>
</ul>

## Solutions

### Solution 1: Counting + Enumeration

> **Thinking**
>
> Count triples summing to $\textit{target}$. Values lie in $[0,100]$ and $n\le 3000$, so a cubic enumeration is tight. Count frequencies, then enumerate $i<j$; the third value $c=\textit{target}-a-b$ must lie after $j$.
>
> Decrement $b$ before looking up $c$, so the counter only represents the suffix, and each lookup is $O(1)$.

We can use a hash table or an array $\textit{cnt}$ of length $101$ to count the occurrence of each element in the array $\textit{arr}$.

Then, we enumerate each element $\textit{arr}[j]$ in the array $\textit{arr}$, first subtract one from $\textit{cnt}[\textit{arr}[j]]$, and then enumerate the elements $\textit{arr}[i]$ before $\textit{arr}[j]$, calculate $c = \textit{target} - \textit{arr}[i] - \textit{arr}[j]$. If $c$ is in the range of $[0, 100]$, then the answer is increased by $\textit{cnt}[c]$, and finally return the answer.

Note that the answer may exceed ${10}^9 + 7$, so take the modulus after each addition operation.

The time complexity is $O(n^2)$, and the space complexity is $O(C)$, where $n$ is the length of the array $\textit{arr}$, and $C$ is the maximum value of the elements in the array $\textit{arr}$, in this problem $C = 100$.

#### Java

```java
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        final int mod = (int) 1e9 + 7;
        int[] cnt = new int[101];
        for (int x : arr) {
            ++cnt[x];
        }
        int n = arr.length;
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            --cnt[arr[j]];
            for (int i = 0; i < j; ++i) {
                int c = target - arr[i] - arr[j];
                if (c >= 0 && c < cnt.length) {
                    ans = (ans + cnt[c]) % mod;
                }
            }
        }
        return ans;
    }
}
```
