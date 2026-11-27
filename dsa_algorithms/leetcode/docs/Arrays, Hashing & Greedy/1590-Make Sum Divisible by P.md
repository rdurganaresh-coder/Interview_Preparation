# 1590. Make Sum Divisible by P

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/make-sum-divisible-by-p/

---

[中文文档](/solution/1500-1599/1590.Make%20Sum%20Divisible%20by%20P/README.md)

## Description

<p>Given an array of positive integers <code>nums</code>, remove the <strong>smallest</strong> subarray (possibly <strong>empty</strong>) such that the <strong>sum</strong> of the remaining elements is divisible by <code>p</code>. It is <strong>not</strong> allowed to remove the whole array.</p>

<p>Return <em>the length of the smallest subarray that you need to remove, or </em><code>-1</code><em> if it&#39;s impossible</em>.</p>

<p>A <strong>subarray</strong> is defined as a contiguous block of elements in the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,1,4,2], p = 6
<strong>Output:</strong> 1
<strong>Explanation:</strong> The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [6,3,5,2], p = 9
<strong>Output:</strong> 2
<strong>Explanation:</strong> We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3], p = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= p &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Prefix Sum + Hash Table

> **Thinking**
>
> Delete the shortest subarray so the remaining sum is divisible by $p$. $n\le 10^5$ rules out enumerating intervals. If the total is $k$ modulo $p$, the deleted piece must be $k$ modulo $p$ as well.
>
> Scan prefix sums modulo $p$ and remember the last index of each residue. At residue $\textit{cur}$, look up $(\textit{cur}-k)\bmod p$; the gap is a candidate deletion. Deleting the entire array is forbidden.

First, we calculate the sum of all elements in the array $\textit{nums}$ modulo $p$, denoted as $k$. If $k$ is $0$, it means the sum of all elements in the array $\textit{nums}$ is a multiple of $p$, so we directly return $0$.

If $k$ is not $0$, we need to find the shortest subarray such that removing this subarray makes the sum of the remaining elements modulo $p$ equal to $0$.

We can traverse the array $\textit{nums}$, maintaining the current prefix sum modulo $p$, denoted as $\textit{cur}$. We use a hash table $\textit{last}$ to record the last occurrence of each prefix sum modulo $p$.

If there exists a subarray ending at $\textit{nums}[i]$ such that removing this subarray makes the sum of the remaining elements modulo $p$ equal to $0$, we need to find a previous prefix sum modulo $p$ equal to $\textit{target}$ at position $j$ such that $(\textit{target} + k - \textit{cur}) \bmod p = 0$. If found, we can remove the subarray $\textit{nums}[j+1,..i]$ to make the sum of the remaining elements modulo $p$ equal to $0$.

Therefore, if there exists a $\textit{target} = (\textit{cur} - k + p) \bmod p$, we can update the answer to $\min(\textit{ans}, i - j)$. Then, we update $\textit{last}[\textit{cur}]$ to $i$. We continue traversing the array $\textit{nums}$ until the end to get the answer.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int minSubarray(int[] nums, int p) {
        int k = 0;
        for (int x : nums) {
            k = (k + x) % p;
        }
        if (k == 0) {
            return 0;
        }
        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1);
        int n = nums.length;
        int ans = n;
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            cur = (cur + nums[i]) % p;
            int target = (cur - k + p) % p;
            if (last.containsKey(target)) {
                ans = Math.min(ans, i - last.get(target));
            }
            last.put(cur, i);
        }
        return ans == n ? -1 : ans;
    }
}
```
