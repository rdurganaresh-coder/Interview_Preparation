# 1769. Minimum Number of Operations to Move All Balls to Each Box

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

---

[中文文档](/solution/1700-1799/1769.Minimum%20Number%20of%20Operations%20to%20Move%20All%20Balls%20to%20Each%20Box/README.md)

## Description

<p>You have <code>n</code> boxes. You are given a binary string <code>boxes</code> of length <code>n</code>, where <code>boxes[i]</code> is <code>&#39;0&#39;</code> if the <code>i<sup>th</sup></code> box is <strong>empty</strong>, and <code>&#39;1&#39;</code> if it contains <strong>one</strong> ball.</p>

<p>In one operation, you can move <strong>one</strong> ball from a box to an adjacent box. Box <code>i</code> is adjacent to box <code>j</code> if <code>abs(i - j) == 1</code>. Note that after doing so, there may be more than one ball in some boxes.</p>

<p>Return an array <code>answer</code> of size <code>n</code>, where <code>answer[i]</code> is the <strong>minimum</strong> number of operations needed to move all the balls to the <code>i<sup>th</sup></code> box.</p>

<p>Each <code>answer[i]</code> is calculated considering the <strong>initial</strong> state of the boxes.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> boxes = &quot;110&quot;
<strong>Output:</strong> [1,1,3]
<strong>Explanation:</strong> The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> boxes = &quot;001011&quot;
<strong>Output:</strong> [11,8,5,4,3,4]</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == boxes.length</code></li>
	<li><code>1 &lt;= n &lt;= 2000</code></li>
	<li><code>boxes[i]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Prefix Sums

> **Thinking**
>
> The cost of gathering every ball at box $i$ is the sum of index distances. $n\le 2000$ allows a double loop, but a linear recurrence exists.
>
> The left (right) cost follows from the neighbour: one more ball on that side increases the cost by the ball count. Precompute $\textit{left}[i]$ and $\textit{right}[i]$ and add them.

Precompute $\textit{left}[i]$ as the cost of moving all balls on the left of $i$ to position $i$, and $\textit{right}[i]$ as the cost of moving all balls on the right of $i$ to position $i$. The answer at $i$ is $\textit{left}[i] + \textit{right}[i]$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of $\textit{boxes}$.

#### Java

```java
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1, cnt = 0; i < n; ++i) {
            if (boxes.charAt(i - 1) == '1') {
                ++cnt;
            }
            left[i] = left[i - 1] + cnt;
        }
        for (int i = n - 2, cnt = 0; i >= 0; --i) {
            if (boxes.charAt(i + 1) == '1') {
                ++cnt;
            }
            right[i] = right[i + 1] + cnt;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = left[i] + right[i];
        }
        return ans;
    }
}
```

### Solution 2: Prefix Sums (Space Optimization)

> **Thinking**
>
> The two arrays in Solution 1 depend only on the previous cell. Accumulate the same recurrences into $\textit{ans}$ left-to-right and right-to-left, using constant extra space.

$\textit{left}[i]$ and $\textit{right}[i]$ in Solution 1 depend only on the previous position, so we can drop those arrays and accumulate into $\textit{ans}$ with one left-to-right pass and one right-to-left pass.

The time complexity is $O(n)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        for (int i = 1, cnt = 0; i < n; ++i) {
            if (boxes.charAt(i - 1) == '1') {
                ++cnt;
            }
            ans[i] = ans[i - 1] + cnt;
        }
        for (int i = n - 2, cnt = 0, s = 0; i >= 0; --i) {
            if (boxes.charAt(i + 1) == '1') {
                ++cnt;
            }
            s += cnt;
            ans[i] += s;
        }
        return ans;
    }
}
```

### Solution 3: Enumeration

> **Thinking**
>
> A direct implementation stores every ball index and, for each box, sums $|i-j|$. It passes for this $n$, at a worse constant than the prefix recurrences.

Collect every ball position, then for each box $i$ add $|i - j|$ for every ball $j$.

The time complexity is $O(nm)$, and the space complexity is $O(m)$, where $n$ is the length of $\textit{boxes}$ and $m$ is the number of balls.
