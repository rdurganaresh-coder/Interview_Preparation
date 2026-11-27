# 2734. Lexicographically Smallest String After Substring Operation

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/

---

[中文文档](/solution/2700-2799/2734.Lexicographically%20Smallest%20String%20After%20Substring%20Operation/README.md)

## Description

<p>Given a string <code>s</code> consisting of lowercase English letters. Perform the following operation:</p>

<ul>
	<li>Select any non-empty <span data-keyword="substring-nonempty">substring</span> then replace every letter of the substring with the preceding letter of the English alphabet. For example, &#39;b&#39; is converted to &#39;a&#39;, and &#39;a&#39; is converted to &#39;z&#39;.</li>
</ul>

<p>Return the <span data-keyword="lexicographically-smaller-string"><strong>lexicographically smallest</strong></span> string <strong>after performing the operation</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;cbabc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;baabc&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Perform the operation on the substring starting at index 0, and ending at index 1 inclusive.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;aa&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;az&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Perform the operation on the last letter.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;acbbc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;abaab&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Perform the operation on the substring starting at index 1, and ending at index 4 inclusive.</p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;leetcode&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;kddsbncd&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>Perform the operation on the entire string.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists of lowercase English letters</li>
</ul>

## Solutions

### Solution 1: Greedy Algorithm

> **Thinking**
>
> We must decrement every letter in one contiguous substring once ($a$ wraps to $z$) and want the lexicographically smallest result. Trying every substring is impossible at $n\le 10^5$.
>
> Decrementing $a$ yields $z$, so $a$ should be avoided. Starting at the leftmost non-$a$ run and stopping before the next $a$ drops the earliest possible position. If the string is all $a$, the mandatory operation turns the last character into $z$.

We can traverse the string $s$ from left to right, find the position $i$ of the first character that is not 'a', and then find the position $j$ of the first 'a' character starting from $i$. We decrement each character in $s[i:j]$, and finally return the processed string.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public String smallestString(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == 'a') {
            ++i;
        }
        if (i == n) {
            return s.substring(0, n - 1) + "z";
        }
        int j = i;
        char[] cs = s.toCharArray();
        while (j < n && cs[j] != 'a') {
            cs[j] = (char) (cs[j] - 1);
            ++j;
        }
        return String.valueOf(cs);
    }
}
```
