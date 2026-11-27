# 1399. Count Largest Group

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-largest-group/

---

[中文文档](/solution/1300-1399/1399.Count%20Largest%20Group/README.md)

## Description

<p>You are given an integer <code>n</code>.</p>

<p>We need to group the numbers from <code>1</code> to <code>n</code> according to the sum of its digits. For example, the numbers 14 and 5 belong to the <strong>same</strong> group, whereas 13 and 3 belong to <strong>different</strong> groups.</p>

<p>Return the number of groups that have the largest size, i.e. the <strong>maximum</strong> number of elements.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 13
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
There are 4 groups with largest size.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are 2 groups [1], [2] of size 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Hash Table or Array

> **Thinking**
>
> Group $1..n$ by digit sum and count how many groups share the maximum size. $n \le 10^4$, so digit sums are at most $36$. Sum digits for each integer, tally group sizes, and track the current maximum size together with how many groups attain it.

We note that the number does not exceed $10^4$, so the sum of the digits also does not exceed $9 \times 4 = 36$. Therefore, we can use a hash table or an array of length $40$, denoted as $\textit{cnt}$, to count the number of each sum of digits, and use a variable $mx$ to represent the maximum count of the sum of digits.

We enumerate each number in $[1,..n]$, calculate its sum of digits $s$, then increment $\textit{cnt}[s]$ by $1$. If $mx < \textit{cnt}[s]$, we update $mx = \textit{cnt}[s]$ and set $\textit{ans}$ to $1$. If $mx = \textit{cnt}[s]$, we increment $\textit{ans}$ by $1$.

Finally, we return $\textit{ans}$.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the given number.

#### Java

```java
class Solution {
    public int countLargestGroup(int n) {
        int[] cnt = new int[40];
        int ans = 0, mx = 0;
        for (int i = 1; i <= n; ++i) {
            int s = 0;
            for (int x = i; x > 0; x /= 10) {
                s += x % 10;
            }
            ++cnt[s];
            if (mx < cnt[s]) {
                mx = cnt[s];
                ans = 1;
            } else if (mx == cnt[s]) {
                ++ans;
            }
        }
        return ans;
    }
}
```
