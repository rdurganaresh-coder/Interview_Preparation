# 1005. Maximize Sum Of Array After K Negations

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

---

[中文文档](/solution/1000-1099/1005.Maximize%20Sum%20Of%20Array%20After%20K%20Negations/README.md)

## Description

<p>Given an integer array <code>nums</code> and an integer <code>k</code>, modify the array in the following way:</p>

<ul>
	<li>choose an index <code>i</code> and replace <code>nums[i]</code> with <code>-nums[i]</code>.</li>
</ul>

<p>You should apply this process exactly <code>k</code> times. You may choose the same index <code>i</code> multiple times.</p>

<p>Return <em>the largest possible sum of the array after modifying it in this way</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,2,3], k = 1
<strong>Output:</strong> 5
<strong>Explanation:</strong> Choose index 1 and nums becomes [4,-2,3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,-1,0,2], k = 3
<strong>Output:</strong> 6
<strong>Explanation:</strong> Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,-3,-1,5,-4], k = 2
<strong>Output:</strong> 13
<strong>Explanation:</strong> Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Greedy + Counting

> **Thinking**
>
> Repeatedly negating the current minimum $k$ times is optimal. Both $n$ and $k$ are at most $10^4$, but finding the minimum each time needs an extra selection structure. Values lie in $[-100,100]$, so we need not sort the original array.
>
> To maximize the sum we should flip the most negative numbers first. If an odd number of flips remain and there is no zero, the smallest positive value must be flipped once more.
>
> A frequency map consumes flips from $-100$ to $-1$, optionally flips the smallest positive, and finally sums value times count.

We observe that to maximize the sum of the array, we should try to turn the smallest negative numbers into positive numbers.

Given that the range of elements is $[-100, 100]$, we can use a hash table $\textit{cnt}$ to count the occurrences of each element in the array $\textit{nums}$. Then, starting from $-100$, we iterate through $x$. If $x$ exists in the hash table, we take $m = \min(\textit{cnt}[x], k)$ as the number of times to negate the element $x$. We then subtract $m$ from $\textit{cnt}[x]$, add $m$ to $\textit{cnt}[-x]$, and subtract $m$ from $k$. If $k$ becomes $0$, the operation is complete, and we exit the loop.

If $k$ is still odd and $\textit{cnt}[0] = 0$, we need to take the smallest positive number $x$ in $\textit{cnt}$, subtract $1$ from $\textit{cnt}[x]$, and add $1$ to $\textit{cnt}[-x]$.

Finally, we traverse the hash table $\textit{cnt}$ and sum the products of $x$ and $\textit{cnt}[x]$ to get the answer.

The time complexity is $O(n + M)$, and the space complexity is $O(M)$, where $n$ and $M$ are the length of the array $\textit{nums}$ and the size of the data range of $\textit{nums}$, respectively.

#### Java

```java
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        for (int x = -100; x < 0 && k > 0; ++x) {
            if (cnt.getOrDefault(x, 0) > 0) {
                int m = Math.min(cnt.get(x), k);
                cnt.merge(x, -m, Integer::sum);
                cnt.merge(-x, m, Integer::sum);
                k -= m;
            }
        }
        if ((k & 1) == 1 && cnt.getOrDefault(0, 0) == 0) {
            for (int x = 1; x <= 100; ++x) {
                if (cnt.getOrDefault(x, 0) > 0) {
                    cnt.merge(x, -1, Integer::sum);
                    cnt.merge(-x, 1, Integer::sum);
                    break;
                }
            }
        }
        int ans = 0;
        for (var e : cnt.entrySet()) {
            ans += e.getKey() * e.getValue();
        }
        return ans;
    }
}
```
