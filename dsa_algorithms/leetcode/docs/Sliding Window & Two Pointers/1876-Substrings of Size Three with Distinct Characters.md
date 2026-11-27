# 1876. Substrings of Size Three with Distinct Characters

**Difficulty:** Easy  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

---

[中文文档](/solution/1800-1899/1876.Substrings%20of%20Size%20Three%20with%20Distinct%20Characters/README.md)

## Description

<p>A string is <strong>good</strong> if there are no repeated characters.</p>

<p>Given a string <code>s</code>​​​​​, return <em>the number of <strong>good substrings</strong> of length <strong>three </strong>in </em><code>s</code>​​​​​​.</p>

<p>Note that if there are multiple occurrences of the same substring, every occurrence should be counted.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters in a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;xyzzaz&quot;
<strong>Output:</strong> 1
<strong>Explanation:</strong> There are 4 substrings of size 3: &quot;xyz&quot;, &quot;yzz&quot;, &quot;zza&quot;, and &quot;zaz&quot;. 
The only good substring of length 3 is &quot;xyz&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aababcabc&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong> There are 7 substrings of size 3: &quot;aab&quot;, &quot;aba&quot;, &quot;bab&quot;, &quot;abc&quot;, &quot;bca&quot;, &quot;cab&quot;, and &quot;abc&quot;.
The good substrings are &quot;abc&quot;, &quot;bca&quot;, &quot;cab&quot;, and &quot;abc&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code>​​​​​​ consists of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: Sliding Window

> **Thinking**
>
> Count length-$3$ substrings with distinct characters. Checking every triple works; a sliding window generalizes to any $k$.
>
> Keep a duplicate-free window: $\textit{mask}$ marks letters inside it, and the left end advances on a repeat. When the window is at least length $3$, the triple ending at the right end is distinct and we add one.

We can maintain a sliding window such that the characters within the window are not repeated. Initially, we use a binary integer $\textit{mask}$ of length $26$ to represent the characters within the window, where the $i$-th bit being $1$ indicates that character $i$ has appeared in the window, otherwise it indicates that character $i$ has not appeared in the window.

Then, we traverse the string $s$. For each position $r$, if $s[r]$ has appeared in the window, we need to move the left boundary $l$ of the window to the right until there are no repeated characters in the window. After this, we add $s[r]$ to the window. At this point, if the length of the window is greater than or equal to $3$, then we have found a good substring of length $3$ ending at $s[r]$.

After the traversal, we have found the number of all good substrings.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $s$.

> This solution can be extended to find the number of good substrings of length $k$.

#### Java

```java
class Solution {
    public int countGoodSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for (int l = 0, r = 0, mask = 0; r < n; ++r) {
            int x = s.charAt(r) - 'a';
            while ((mask >> x & 1) == 1) {
                int y = s.charAt(l++) - 'a';
                mask ^= 1 << y;
            }
            mask |= 1 << x;
            ans += r - l + 1 >= 3 ? 1 : 0;
        }
        return ans;
    }
}
```
