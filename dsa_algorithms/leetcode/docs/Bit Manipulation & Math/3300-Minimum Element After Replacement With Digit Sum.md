# 3300. Minimum Element After Replacement With Digit Sum

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/

---

[中文文档](/solution/3300-3399/3300.Minimum%20Element%20After%20Replacement%20With%20Digit%20Sum/README.md)

## Description

<p>You are given an integer array <code>nums</code>.</p>

<p>You replace each element in <code>nums</code> with the <strong>sum</strong> of its digits.</p>

<p>Return the <strong>minimum</strong> element in <code>nums</code> after all replacements.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [10,12,13,14]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p><code>nums</code> becomes <code>[1, 3, 4, 5]</code> after all replacements, with minimum element 1.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p><code>nums</code> becomes <code>[1, 2, 3, 4]</code> after all replacements, with minimum element 1.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [999,19,199]</span></p>

<p><strong>Output:</strong> <span class="example-io">10</span></p>

<p><strong>Explanation:</strong></p>

<p><code>nums</code> becomes <code>[27, 10, 19]</code> after all replacements, with minimum element 10.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> We replace each element by the sum of its digits and then take the minimum. With $n \le 100$ and $M \le 10^4$, splitting digits costs only $O(\log M)$ per value, which is acceptable.
>
> Digit sums are independent, so there is no need to sort or tabulate. A single scan that keeps the running minimum suffices.
>
> For each $x$ we accumulate its decimal digits and return the minimum among those sums.

We can traverse the array $\textit{nums}$. For each number $x$, we calculate the sum of its digits $y$. The minimum value among all $y$ is the answer.

The time complexity is $O(n \log M)$, and the space complexity is $O(1)$, where $n$ and $M$ are the length of the array $\textit{nums}$ and the maximum value in the array, respectively.

#### Java

```java
class Solution {
    public int minElement(int[] nums) {
        int ans = 100;
        for (int x : nums) {
            int y = 0;
            for (; x > 0; x /= 10) {
                y += x % 10;
            }
            ans = Math.min(ans, y);
        }
        return ans;
    }
}
```
