# 2553. Separate the Digits in an Array

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/separate-the-digits-in-an-array/

---

[中文文档](/solution/2500-2599/2553.Separate%20the%20Digits%20in%20an%20Array/README.md)

## Description

<p>Given an array of positive integers <code>nums</code>, return <em>an array </em><code>answer</code><em> that consists of the digits of each integer in </em><code>nums</code><em> after separating them in <strong>the same order</strong> they appear in </em><code>nums</code>.</p>

<p>To separate the digits of an integer is to get all the digits it has in the same order.</p>

<ul>
	<li>For example, for the integer <code>10921</code>, the separation of its digits is <code>[1,0,9,2,1]</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [13,25,83,77]
<strong>Output:</strong> [1,3,2,5,8,3,7,7]
<strong>Explanation:</strong> 
- The separation of 13 is [1,3].
- The separation of 25 is [2,5].
- The separation of 83 is [8,3].
- The separation of 77 is [7,7].
answer = [1,3,2,5,8,3,7,7]. Note that answer contains the separations in the same order.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [7,1,3,9]
<strong>Output:</strong> [7,1,3,9]
<strong>Explanation:</strong> The separation of each integer in nums is itself.
answer = [7,1,3,9].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> Split every integer into decimal digits, preserving order. Division by ten yields digits in reverse, so reverse each buffer before appending.

Split each number in the array into digits, then put the split numbers into the answer array in order.

The time complexity is $O(n \log_{10} M)$, and the space complexity is $O(n \log_{10} M)$, where $n$ is the length of the array $\textit{nums}$, and $M$ is the maximum value in the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int x : nums) {
            List<Integer> t = new ArrayList<>();
            for (; x > 0; x /= 10) {
                t.add(x % 10);
            }
            Collections.reverse(t);
            res.addAll(t);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 splits arithmetically. Converting to a string walks digits from high to low and avoids the reverse; the output is the same.
