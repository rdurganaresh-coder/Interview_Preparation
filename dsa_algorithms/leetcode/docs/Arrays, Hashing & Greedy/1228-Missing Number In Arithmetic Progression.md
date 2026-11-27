# 1228. Missing Number In Arithmetic Progression

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/missing-number-in-arithmetic-progression/

---

[中文文档](/solution/1200-1299/1228.Missing%20Number%20In%20Arithmetic%20Progression/README.md)

## Description

<p>In some array <code>arr</code>, the values were in arithmetic progression: the values <code>arr[i + 1] - arr[i]</code> are all equal for every <code>0 &lt;= i &lt; arr.length - 1</code>.</p>

<p>A value from <code>arr</code> was removed that <strong>was not the first or last value in the array</strong>.</p>

<p>Given <code>arr</code>, return <em>the removed value</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [5,7,11,13]
<strong>Output:</strong> 9
<strong>Explanation:</strong> The previous array was [5,7,<strong>9</strong>,11,13].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [15,13,12]
<strong>Output:</strong> 14
<strong>Explanation:</strong> The previous array was [15,<strong>14</strong>,13,12].</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= arr.length &lt;= 1000</code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10<sup>5</sup></code></li>
	<li>The given array is <strong>guaranteed</strong> to be a valid array.</li>
</ul>

## Solutions

### Solution 1: Arithmetic Series Sum Formula

> **Thinking**
>
> The array is an arithmetic progression with one term removed, $n \le 1000$. The full sequence has $n+1$ terms and known endpoints, so its sum follows the closed formula; subtracting the array sum yields the missing term. One summation suffices; we never compute the common difference.

The sum formula for an arithmetic series is $\frac{(a_1 + a_n)n}{2}$, where $n$ is the number of terms in the arithmetic series, the first term is $a_1$, and the last term is $a_n$.

Since the array given in the problem is an arithmetic series with one missing number, the number of terms in the array is $n + 1$, the first term is $a_1$, and the last term is $a_n$. Therefore, the sum of the array is $\frac{(a_1 + a_n)(n + 1)}{2}$.

Thus, the missing number is $\frac{(a_1 + a_n)(n + 1)}{2} - \sum_{i = 0}^n a_i$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int x = (arr[0] + arr[n - 1]) * (n + 1) / 2;
        int y = Arrays.stream(arr).sum();
        return x - y;
    }
}
```

### Solution 2: Find Common Difference + Traverse

> **Thinking**
>
> The sum formula yields the missing value without using the common difference. Computing $d$ from the endpoints and length, then scanning for a gap not equal to $d$, recovers the missing term at the break; if every gap matches, all values are equal. Same linear time, closer to the definition of the progression.

Since the array given in the problem is an arithmetic series with one missing number, the first term is $a_1$, and the last term is $a_n$. The common difference $d$ is $\frac{a_n - a_1}{n}$.

Traverse the array, and if $a_i \neq a_{i - 1} + d$, then return $a_{i - 1} + d$.

If the traversal completes without finding the missing number, it means all numbers in the array are equal. In this case, directly return the first number of the array.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int d = (arr[n - 1] - arr[0]) / n;
        for (int i = 1; i < n; ++i) {
            if (arr[i] != arr[i - 1] + d) {
                return arr[i - 1] + d;
            }
        }
        return arr[0];
    }
}
```
