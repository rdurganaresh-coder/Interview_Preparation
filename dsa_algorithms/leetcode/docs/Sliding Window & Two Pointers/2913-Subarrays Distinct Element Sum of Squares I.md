# 2913. Subarrays Distinct Element Sum of Squares I

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/

---

[中文文档](/solution/2900-2999/2913.Subarrays%20Distinct%20Element%20Sum%20of%20Squares%20I/README.md)

## Description

<p>You are given a <strong>0-indexed </strong>integer array <code>nums</code>.</p>

<p>The <strong>distinct count</strong> of a subarray of <code>nums</code> is defined as:</p>

<ul>
	<li>Let <code>nums[i..j]</code> be a subarray of <code>nums</code> consisting of all the indices from <code>i</code> to <code>j</code> such that <code>0 &lt;= i &lt;= j &lt; nums.length</code>. Then the number of distinct values in <code>nums[i..j]</code> is called the distinct count of <code>nums[i..j]</code>.</li>
</ul>

<p>Return <em>the sum of the <strong>squares</strong> of <strong>distinct counts</strong> of all subarrays of </em><code>nums</code>.</p>

<p>A subarray is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,1]
<strong>Output:</strong> 15
<strong>Explanation:</strong> Six possible subarrays are:
[1]: 1 distinct value
[2]: 1 distinct value
[1]: 1 distinct value
[1,2]: 2 distinct values
[2,1]: 2 distinct values
[1,2,1]: 2 distinct values
The sum of the squares of the distinct counts in all subarrays is equal to 1<sup>2</sup> + 1<sup>2</sup> + 1<sup>2</sup> + 2<sup>2</sup> + 2<sup>2</sup> + 2<sup>2</sup> = 15.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> Three possible subarrays are:
[1]: 1 distinct value
[1]: 1 distinct value
[1,1]: 1 distinct value
The sum of the squares of the distinct counts in all subarrays is equal to 1<sup>2</sup> + 1<sup>2</sup> + 1<sup>2</sup> = 3.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> We need $\sum \textit{distinct}(\textit{sub})^2$. $n \le 100$ lets us enumerate all $O(n^2)$ subarrays. Fix the left end $i$ and extend $j$ while inserting into a set, adding $|s|^2$ each time.
>
> The value domain is also at most $100$, so set operations are cheap. A closed-form contribution is unnecessary.

We can enumerate the left endpoint index $i$ of the subarray, and for each $i$, we enumerate the right endpoint index $j$ in the range $[i, n)$, and calculate the distinct count of $\textit{nums}[i..j]$ by adding the count of $\textit{nums}[j]$ to a set $s$, and then taking the square of the size of $s$ as the contribution of $\textit{nums}[i..j]$ to the answer.

After the enumeration, we return the answer.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            int[] s = new int[101];
            int cnt = 0;
            for (int j = i; j < n; ++j) {
                if (++s[nums.get(j)] == 1) {
                    ++cnt;
                }
                ans += cnt * cnt;
            }
        }
        return ans;
    }
}
```
