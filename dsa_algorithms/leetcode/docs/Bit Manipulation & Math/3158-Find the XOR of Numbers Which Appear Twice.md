# 3158. Find the XOR of Numbers Which Appear Twice

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice/

---

[中文文档](/solution/3100-3199/3158.Find%20the%20XOR%20of%20Numbers%20Which%20Appear%20Twice/README.md)

## Description

<p>You are given an array <code>nums</code>, where each number in the array appears <strong>either</strong><em> </em>once<em> </em>or<em> </em>twice.</p>

<p>Return the bitwise<em> </em><code>XOR</code> of all the numbers that appear twice in the array, or 0 if no number appears twice.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,1,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The only number that appears twice in&nbsp;<code>nums</code>&nbsp;is 1.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>No number appears twice in&nbsp;<code>nums</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,2,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>Numbers 1 and 2 appeared twice. <code>1 XOR 2 == 3</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 50</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 50</code></li>
	<li>Each number in <code>nums</code> appears either once or twice.</li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> XOR the values that occur exactly twice. The domain is tiny, so a frequency table is enough.
>
> Count in one pass and XOR keys whose frequency is $2$. An empty list yields $0$.
>
> `Counter` plus `reduce(xor, ...)` solves it in linear time.

We define an array or hash table `cnt` to record the occurrence of each number.

Next, we traverse the array `nums`. When a number appears twice, we perform an XOR operation with the answer.

Finally, we return the answer.

The time complexity is $O(n)$, and the space complexity is $O(M)$, where $n$ is the length of the array $\textit{nums}$, and $M$ is the maximum value in the array $\textit{nums}$ or the number of distinct numbers in the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int[] cnt = new int[51];
        int ans = 0;
        for (int x : nums) {
            if (++cnt[x] == 2) {
                ans ^= x;
            }
        }
        return ans;
    }
}
```

### Solution 2: Bit Manipulation

> **Thinking**
>
> A hash map is unnecessary when every value is at most $50$.
>
> A 64-bit mask records whether a value has been seen; the second sighting XORs it into the answer.
>
> If bit $x$ of $\textit{mask}$ is set, XOR $x$ into $\textit{ans}$; otherwise set the bit. Extra arrays disappear.

Since the given number range in the problem is $1 \leq \textit{nums}[i] \leq 50$, we can use a $64$-bit integer to store the occurrence of each number.

We define an integer $\textit{mask}$ to record whether each number has appeared.

Next, we traverse the array $\textit{nums}$. When a number appears twice, i.e., the $x$-th bit in the binary representation of $\textit{mask}$ is $1$, we perform an XOR operation with the answer. Otherwise, we set the $x$-th bit of $\textit{mask}$ to $1$.

Finally, we return the answer.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        long mask = 0;
        for (int x : nums) {
            if ((mask >> x & 1) == 1) {
                ans ^= x;
            } else {
                mask |= 1L << x;
            }
        }
        return ans;
    }
}
```
