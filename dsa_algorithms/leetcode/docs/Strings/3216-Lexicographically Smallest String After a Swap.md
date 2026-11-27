# 3216. Lexicographically Smallest String After a Swap

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/

---

[中文文档](/solution/3200-3299/3216.Lexicographically%20Smallest%20String%20After%20a%20Swap/README.md)

## Description

<p>Given a string <code>s</code> containing only digits, return the <span data-keyword="lexicographically-smaller-string">lexicographically smallest string</span> that can be obtained after swapping <strong>adjacent</strong> digits in <code>s</code> with the same <strong>parity</strong> at most <strong>once</strong>.</p>

<p>Digits have the same parity if both are odd or both are even. For example, 5 and 9, as well as 2 and 4, have the same parity, while 6 and 9 do not.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;45320&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;43520&quot;</span></p>

<p><strong>Explanation: </strong></p>

<p><code>s[1] == &#39;5&#39;</code> and <code>s[2] == &#39;3&#39;</code> both have the same parity, and swapping them results in the lexicographically smallest string.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;001&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;001&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>There is no need to perform a swap because <code>s</code> is already the lexicographically smallest.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists only of digits.</li>
</ul>

## Solutions

### Solution 1: Greedy + Simulation

> **Thinking**
>
> We may swap adjacent same-parity digits at most once. $n\le 100$ would allow trying every legal swap, but the lexicographically best swap is the leftmost one.
>
> Scan left to right for the first adjacent pair with the same parity and a larger left digit, then swap and stop: a later swap cannot improve an already better prefix. If no such pair exists, the string is already minimal.

We can traverse the string $s$ from left to right. For each pair of adjacent digits, if they have the same parity and the previous digit is greater than the next digit, then we swap these two digits to make the lexicographical order of the string $s$ smaller, and then return the swapped string.

After the traversal, if no swappable pair of digits is found, it means the string $s$ is already in its smallest lexicographical order, and we can return it directly.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public String getSmallestString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 1; i < n; ++i) {
            char a = cs[i - 1], b = cs[i];
            if (a > b && a % 2 == b % 2) {
                cs[i] = a;
                cs[i - 1] = b;
                return new String(cs);
            }
        }
        return s;
    }
}
```
