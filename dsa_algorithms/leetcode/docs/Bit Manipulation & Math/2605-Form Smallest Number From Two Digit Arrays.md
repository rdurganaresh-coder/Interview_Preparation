# 2605. Form Smallest Number From Two Digit Arrays

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/

---

[中文文档](/solution/2600-2699/2605.Form%20Smallest%20Number%20From%20Two%20Digit%20Arrays/README.md)

## Description

Given two arrays of <strong>unique</strong> digits <code>nums1</code> and <code>nums2</code>, return <em>the <strong>smallest</strong> number that contains <strong>at least</strong> one digit from each array</em>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [4,1,3], nums2 = [5,7]
<strong>Output:</strong> 15
<strong>Explanation:</strong> The number 15 contains the digit 1 from nums1 and the digit 5 from nums2. It can be proven that 15 is the smallest number we can have.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [3,5,2,6], nums2 = [3,1,7]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The number 3 contains the digit 3 which exists in both arrays.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 9</code></li>
	<li><code>1 &lt;= nums1[i], nums2[i] &lt;= 9</code></li>
	<li>All digits in each array are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> The answer has at most two digits, one from each array. Both arrays have length at most $9$, so enumerating every pair covers a shared digit and a concatenation of two distinct digits.
>
> If $a=b$, the one-digit $a$ beats any two-digit number; otherwise we compare $10a+b$ and $10b+a$, keeping the global minimum.

We observe that if there are the same numbers in the arrays $\textit{nums1}$ and $\textit{nums2}$, then the minimum of the same numbers is the smallest number. Otherwise, we take the number $a$ in the array $\textit{nums1}$ and the number $b$ in the array $\textit{nums2}$, and concatenate the two numbers $a$ and $b$ into two numbers, and take the smaller number.

The time complexity is $O(mn)$, and the space complexity is $O(1)$, where $m$ and $n$ are the lengths of the arrays $\textit{nums1}$ and $\textit{nums2}$.

#### Java

```java
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int ans = 100;
        for (int a : nums1) {
            for (int b : nums2) {
                if (a == b) {
                    ans = Math.min(ans, a);
                } else {
                    ans = Math.min(ans, Math.min(a * 10 + b, b * 10 + a));
                }
            }
        }
        return ans;
    }
}
```

### Solution 2: Hash Table or Array + Enumeration

> **Thinking**
>
> Solution 1 compares every pair. Once a shared digit exists, the smallest shared value is the answer and concatenations are irrelevant; otherwise only the two minima need to be concatenated.
>
> An intersection set (or a direct $\min$ on each array) reduces the nested loops to a linear scan.

We can use a hash table or array to record the numbers in the arrays $\textit{nums1}$ and $\textit{nums2}$, and then enumerate $1 \sim 9$. If $i$ appears in both arrays, then $i$ is the smallest number. Otherwise, we take the number $a$ in the array $\textit{nums1}$ and the number $b$ in the array $\textit{nums2}$, and concatenate the two numbers $a$ and $b$ into two numbers, and take the smaller number.

The time complexity is $O(m + n)$, and the space complexity is $O(C)$, where $m$ and $n$ are the lengths of the arrays $\textit{nums1}$ and $\textit{nums2}$ respectively; and $C$ is the range of the numbers in the arrays $\textit{nums1}$ and $\textit{nums2}$, and the range in this problem is $C = 10$.

#### Java

```java
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        boolean[] s1 = new boolean[10];
        boolean[] s2 = new boolean[10];
        for (int x : nums1) {
            s1[x] = true;
        }
        for (int x : nums2) {
            s2[x] = true;
        }
        int a = 0, b = 0;
        for (int i = 1; i < 10; ++i) {
            if (s1[i] && s2[i]) {
                return i;
            }
            if (a == 0 && s1[i]) {
                a = i;
            }
            if (b == 0 && s2[i]) {
                b = i;
            }
        }
        return Math.min(a * 10 + b, b * 10 + a);
    }
}
```

### Solution 3: Bit Operation

> **Thinking**
>
> Digits lie in $1..9$, so sets become bit masks. A nonempty bitwise AND yields the lowest shared digit; otherwise we concatenate the lowest bit of each mask.
>
> The observation matches Solution 2; only the set representation shrinks to constant-space bit operations.

Since the range of the numbers is $1 \sim 9$, we can use a binary number with a length of $10$ to represent the numbers in the arrays $\textit{nums1}$ and $\textit{nums2}$. We use $\textit{mask1}$ to represent the numbers in the array $\textit{nums1}$, and use $\textit{mask2}$ to represent the numbers in the array $\textit{nums2}$.

If the number $\textit{mask}$ obtained by performing a bitwise AND operation on $\textit{mask1}$ and $\textit{mask2}$ is not equal to $0$, then we extract the position of the last $1$ in the number $\textit{mask}$, which is the smallest number.

Otherwise, we extract the position of the last $1$ in $\textit{mask1}$ and $\textit{mask2}$ respectively, and denote them as $a$ and $b$, respectively. Then the smallest number is $\min(a \times 10 + b, b \times 10 + a)$.

The time complexity is $O(m + n)$, and the space complexity is $O(1)$, where $m$ and $n$ are the lengths of the arrays $\textit{nums1}$ and $\textit{nums2}$ respectively.

#### Java

```java
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int mask1 = 0, mask2 = 0;
        for (int x : nums1) {
            mask1 |= 1 << x;
        }
        for (int x : nums2) {
            mask2 |= 1 << x;
        }
        int mask = mask1 & mask2;
        if (mask != 0) {
            return Integer.numberOfTrailingZeros(mask);
        }
        int a = Integer.numberOfTrailingZeros(mask1);
        int b = Integer.numberOfTrailingZeros(mask2);
        return Math.min(a * 10 + b, b * 10 + a);
    }
}
```
