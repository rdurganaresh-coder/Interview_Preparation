# 670. Maximum Swap

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-swap/

---

[中文文档](/solution/0600-0699/0670.Maximum%20Swap/README.md)

## Description

<p>You are given an integer <code>num</code>. You can swap two digits at most once to get the maximum valued number.</p>

<p>Return <em>the maximum valued number you can get</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num = 2736
<strong>Output:</strong> 7236
<strong>Explanation:</strong> Swap the number 2 and the number 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num = 9973
<strong>Output:</strong> 9973
<strong>Explanation:</strong> No swap.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= num &lt;= 10<sup>8</sup></code></li>
</ul>

## Solutions

### Solution 1: Greedy Algorithm

> **Thinking**
>
> Swap at most two digits to maximize the number. Trying every pair is unnecessary.
>
> From the right, record the index of the largest digit to the right (inclusive). From the left, swap at the first $s[i]<s[d[i]]$. That raises the highest possible place.

First, we convert the number into a string $s$. Then, we traverse the string $s$ from right to left, using an array or hash table $d$ to record the position of the maximum number to the right of each number (it can be the position of the number itself).

Next, we traverse $d$ from left to right. If $s[i] < s[d[i]]$, we swap them and exit the traversal process.

Finally, we convert the string $s$ back into a number, which is the answer.

The time complexity is $O(\log M)$, and the space complexity is $O(\log M)$, where $M$ is the range of the number $\textit{num}$.

#### Java

```java
class Solution {
    public int maximumSwap(int num) {
        char[] s = String.valueOf(num).toCharArray();
        int n = s.length;
        int[] d = new int[n];
        for (int i = 0; i < n; ++i) {
            d[i] = i;
        }
        for (int i = n - 2; i >= 0; --i) {
            if (s[i] <= s[d[i + 1]]) {
                d[i] = d[i + 1];
            }
        }
        for (int i = 0; i < n; ++i) {
            int j = d[i];
            if (s[i] < s[j]) {
                char t = s[i];
                s[i] = s[j];
                s[j] = t;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(s));
    }
}
```

### Solution 2: Space Optimized Greedy

> **Thinking**
>
> Method 1 stores a right-max index array. One right-to-left scan can keep the best seen digit and the leftmost profitable swap, without the extra array.
