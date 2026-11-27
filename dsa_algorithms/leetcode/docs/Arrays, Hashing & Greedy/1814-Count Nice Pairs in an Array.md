# 1814. Count Nice Pairs in an Array

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-nice-pairs-in-an-array/

---

[中文文档](/solution/1800-1899/1814.Count%20Nice%20Pairs%20in%20an%20Array/README.md)

## Description

<p>You are given an array <code>nums</code> that consists of non-negative integers. Let us define <code>rev(x)</code> as the reverse of the non-negative integer <code>x</code>. For example, <code>rev(123) = 321</code>, and <code>rev(120) = 21</code>. A pair of indices <code>(i, j)</code> is <strong>nice</strong> if it satisfies all of the following conditions:</p>

<ul>
	<li><code>0 &lt;= i &lt; j &lt; nums.length</code></li>
	<li><code>nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])</code></li>
</ul>

<p>Return <em>the number of nice pairs of indices</em>. Since that number can be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [42,11,1,97]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [13,10,35,24,76]
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Equation Transformation + Hash Table

> **Thinking**
>
> A nice pair satisfies $\textit{nums}[i]+\textit{rev}(\textit{nums}[j])=\textit{nums}[j]+\textit{rev}(\textit{nums}[i])$. Checking every pair is $O(n^2 \log M)$. With $n\le 10^5$ this will not pass.
>
> Rearrangement yields $\textit{nums}[i]-\textit{rev}(\textit{nums}[i])=\textit{nums}[j]-\textit{rev}(\textit{nums}[j])$. Count each difference; the answer is $\sum C(v,2)$ over those frequencies, modulo $10^9+7$.

For the index pair $(i, j)$, if it satisfies the condition, then we have $\textit{nums}[i] + \textit{rev}(\textit{nums}[j]) = \textit{nums}[j] + \textit{rev}(\textit{nums}[i])$, which means $\textit{nums}[i] - \textit{nums}[j] = \textit{rev}(\textit{nums}[j]) - \textit{rev}(\textit{nums}[i])$.

Therefore, we can use $\textit{nums}[i] - \textit{rev}(\textit{nums}[i])$ as the key of a hash table and count the number of occurrences of each key. Finally, we calculate the combination of values corresponding to each key, add them up, and get the final answer.

Note that we need to perform modulo operation on the answer.

The time complexity is $O(n \log M)$, and the space complexity is $O(n)$, where $n$ and $M$ are the length of the $\textit{nums}$ array and the maximum value in the $\textit{nums}$ array, respectively.

#### Java

```java
class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            int y = x - rev(x);
            cnt.merge(y, 1, Integer::sum);
        }
        final int mod = (int) 1e9 + 7;
        long ans = 0;
        for (int v : cnt.values()) {
            ans = (ans + (long) v * (v - 1) / 2) % mod;
        }
        return (int) ans;
    }

    private int rev(int x) {
        int y = 0;
        for (; x > 0; x /= 10) {
            y = y * 10 + x % 10;
        }
        return y;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 finishes the histogram first and then sums combinations, which needs a second pass. The pairs are unordered, so while scanning we can add the current count of the same difference to the answer and then increment that key, avoiding an explicit $C(v,2)$ afterwards.

#### Java

```java
class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        final int mod = (int) 1e9 + 7;
        int ans = 0;
        for (int x : nums) {
            int y = x - rev(x);
            ans = (ans + cnt.getOrDefault(y, 0)) % mod;
            cnt.merge(y, 1, Integer::sum);
        }
        return ans;
    }

    private int rev(int x) {
        int y = 0;
        for (; x > 0; x /= 10) {
            y = y * 10 + x % 10;
        }
        return y;
    }
}
```
