# 949. Largest Time for Given Digits

**Difficulty:** Medium  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/largest-time-for-given-digits/

---

[中文文档](/solution/0900-0999/0949.Largest%20Time%20for%20Given%20Digits/README.md)

## Description

<p>Given an array <code>arr</code> of 4 digits, find the latest 24-hour time that can be made using each digit <strong>exactly once</strong>.</p>

<p>24-hour times are formatted as <code>&quot;HH:MM&quot;</code>, where <code>HH</code> is between <code>00</code> and <code>23</code>, and <code>MM</code> is between <code>00</code> and <code>59</code>. The earliest 24-hour time is <code>00:00</code>, and the latest is <code>23:59</code>.</p>

<p>Return <em>the latest 24-hour time in <code>&quot;HH:MM&quot;</code> format</em>. If no valid time can be made, return an empty string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2,3,4]
<strong>Output:</strong> &quot;23:41&quot;
<strong>Explanation:</strong> The valid 24-hour times are &quot;12:34&quot;, &quot;12:43&quot;, &quot;13:24&quot;, &quot;13:42&quot;, &quot;14:23&quot;, &quot;14:32&quot;, &quot;21:34&quot;, &quot;21:43&quot;, &quot;23:14&quot;, and &quot;23:41&quot;. Of these times, &quot;23:41&quot; is the latest.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [5,5,5,5]
<strong>Output:</strong> &quot;&quot;
<strong>Explanation:</strong> There are no valid 24-hour times as &quot;55:55&quot; is not valid.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>arr.length == 4</code></li>
	<li><code>0 &lt;= arr[i] &lt;= 9</code></li>
</ul>

## Solutions

### Solution 1: Enumerate Hours and Minutes

> **Thinking**
>
> Form the latest valid time from four digits. There are only $24\times 60$ legal hour-minute pairs. Enumerate them from large to small and accept the first whose digit counts match the input.

Enumerate valid hours $h \in [0,23]$ and minutes $m \in [0,59]$ from large to small, and use a count array to check whether the four digits match the input. The first hit is the latest valid time.

The time complexity is $O(1)$, and the space complexity is $O(1)$.

### Solution 2: Brute Force (Permutations)

> **Thinking**
>
> Enumerating times is constant work; we may instead permute the four indices, build an hour and a minute, and keep the maximum legal value. $4! = 24$ permutations are equally affordable.

Enumerate all permutations of the four digits, check whether they form a valid time, and keep the maximum.

The time complexity is $O(4^3)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int ans = -1;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (i != j && j != k && i != k) {
                        int h = arr[i] * 10 + arr[j];
                        int m = arr[k] * 10 + arr[6 - i - j - k];
                        if (h < 24 && m < 60) {
                            ans = Math.max(ans, h * 60 + m);
                        }
                    }
                }
            }
        }
        return ans < 0 ? "" : String.format("%02d:%02d", ans / 60, ans % 60);
    }
}
```
