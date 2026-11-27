# 2239. Find Closest Number to Zero

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-closest-number-to-zero/

---

[中文文档](/solution/2200-2299/2239.Find%20Closest%20Number%20to%20Zero/README.md)

## Description

<p>Given an integer array <code>nums</code> of size <code>n</code>, return <em>the number with the value <strong>closest</strong> to </em><code>0</code><em> in </em><code>nums</code>. If there are multiple answers, return <em>the number with the <strong>largest</strong> value</em>.</p>
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [-4,-2,1,4,8]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
The distance from -4 to 0 is |-4| = 4.
The distance from -2 to 0 is |-2| = 2.
The distance from 1 to 0 is |1| = 1.
The distance from 4 to 0 is |4| = 4.
The distance from 8 to 0 is |8| = 8.
Thus, the closest number to 0 in the array is 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,-1,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Single Pass

> **Thinking**
>
> We want the value closest to zero, breaking ties toward the larger number. $n \le 10^3$ would allow a sort, but a single running optimum is enough.
>
> Scan once: replace the answer when the absolute value is smaller, or equal and the number itself is larger.

We define a variable $d$ to record the current minimum distance, initially $d=\infty$. Then we traverse the array, for each element $x$, we calculate $y=|x|$. If $y \lt d$ or $y=d$ and $x \gt \textit{ans}$, we update the answer $\textit{ans}=x$ and $d=y$.

After the traversal, return the answer.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = 0, d = 1 << 30;
        for (int x : nums) {
            int y = Math.abs(x);
            if (y < d || (y == d && x > ans)) {
                ans = x;
                d = y;
            }
        }
        return ans;
    }
}
```
