# 1464. Maximum Product of Two Elements in an Array

**Difficulty:** Easy  
**Category:** SQL & Database  
**LeetCode:** https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

---

[中文文档](/solution/1400-1499/1464.Maximum%20Product%20of%20Two%20Elements%20in%20an%20Array/README.md)

## Description

<p>You are given an array of integers <code>nums</code>.</p>

<p>Choose two <strong>different</strong> indices <code>i</code> and <code>j</code> of that array.</p>

<p>Return the <strong>maximum</strong> value of <code>(nums[i] - 1) * (nums[j] - 1)</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,4,5,2]
<strong>Output:</strong> 12 
<strong>Explanation:</strong> If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,5,4,5]
<strong>Output:</strong> 16
<strong>Explanation:</strong> Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,7]
<strong>Output:</strong> 12
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 500</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10^3</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> $n\le 500$. Enumerate every unordered pair and keep the maximum of $(a-1)(b-1)$.

#### Java

```java
class Solution {
    public int maxProduct(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                ans = Math.max(ans, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Method 1 is quadratic. The product grows with the two values, so sort and take the last two.

#### Java

```java
class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
```

### Solution 3

> **Thinking**
>
> Method 2 still sorts. One pass that keeps the largest and second-largest values is enough.

#### Java

```java
class Solution {
    public int maxProduct(int[] nums) {
        int a = 0, b = 0;
        for (int v : nums) {
            if (v > a) {
                b = a;
                a = v;
            } else if (v > b) {
                b = v;
            }
        }
        return (a - 1) * (b - 1);
    }
}
```
