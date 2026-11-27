# 1295. Find Numbers with Even Number of Digits

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

---

[中文文档](/solution/1200-1299/1295.Find%20Numbers%20with%20Even%20Number%20of%20Digits/README.md)

## Description

<p>Given an array <code>nums</code> of integers, return how many of them contain an <strong>even number</strong> of digits.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [12,345,2,6,7896]
<strong>Output:</strong> 2
<strong>Explanation: 
</strong>12 contains 2 digits (even number of digits).&nbsp;
345 contains 3 digits (odd number of digits).&nbsp;
2 contains 1 digit (odd number of digits).&nbsp;
6 contains 1 digit (odd number of digits).&nbsp;
7896 contains 4 digits (even number of digits).&nbsp;
Therefore only 12 and 7896 contain an even number of digits.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [555,901,482,1771]
<strong>Output:</strong> 1 
<strong>Explanation: </strong>
Only 1771 contains an even number of digits.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 500</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> With $n \le 500$ we convert each number to a decimal string and test the length's parity. Repeated division by $10$ also counts digits; the string form is shorter.

We traverse each element $x$ in the array $\textit{nums}$. For the current element $x$, we directly convert it to a string and then check if its length is even. If it is, we increment the answer by one.

After the traversal is complete, we return the answer.

The time complexity is $O(n \log M)$, and the space complexity is $O(\log M)$, where $n$ is the length of the array $\textit{nums}$, and $M$ is the maximum value of the elements in the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            if (String.valueOf(x).length() % 2 == 0) {
                ++ans;
            }
        }
        return ans;
    }
}
```
