# 390. Elimination Game

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/elimination-game/

---

[中文文档](/solution/0300-0399/0390.Elimination%20Game/README.md)

## Description

<p>You have a list <code>arr</code> of all integers in the range <code>[1, n]</code> sorted in a strictly increasing order. Apply the following algorithm on <code>arr</code>:</p>

<ul>
	<li>Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.</li>
	<li>Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.</li>
	<li>Keep repeating the steps again, alternating left to right and right to left, until a single number remains.</li>
</ul>

<p>Given the integer <code>n</code>, return <em>the last number that remains in</em> <code>arr</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 9
<strong>Output:</strong> 6
<strong>Explanation:</strong>
arr = [<u>1</u>, 2, <u>3</u>, 4, <u>5</u>, 6, <u>7</u>, 8, <u>9</u>]
arr = [2, <u>4</u>, 6, <u>8</u>]
arr = [<u>2</u>, 6]
arr = [6]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Delete every other number, alternating left-to-right and right-to-left. A list simulation is $O(n)$ for $n\le 10^9$. Each round halves the count; head, tail, and step have a closed update.
>
> Keep the current first $\textit{a1}$, last $an$, step, and count. A left-to-right pass always moves the head; a right-to-left pass moves it when the count is odd. The tail is symmetric. When one remains, return $\textit{a1}$.

#### Java

```java
class Solution {
    public int lastRemaining(int n) {
        int a1 = 1, an = n, step = 1;
        for (int i = 0, cnt = n; cnt > 1; cnt >>= 1, step <<= 1, ++i) {
            if (i % 2 == 1) {
                an -= step;
                if (cnt % 2 == 1) {
                    a1 += step;
                }
            } else {
                a1 += step;
                if (cnt % 2 == 1) {
                    an -= step;
                }
            }
        }
        return a1;
    }
}
```
