# 1422. Maximum Score After Splitting a String

**Difficulty:** Easy  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/maximum-score-after-splitting-a-string/

---

[中文文档](/solution/1400-1499/1422.Maximum%20Score%20After%20Splitting%20a%20String/README.md)

## Description

<p>Given a&nbsp;string <code>s</code>&nbsp;of zeros and ones, <em>return the maximum score after splitting the string into two <strong>non-empty</strong> substrings</em> (i.e. <strong>left</strong> substring and <strong>right</strong> substring).</p>

<p>The score after splitting a string is the number of <strong>zeros</strong> in the <strong>left</strong> substring plus the number of <strong>ones</strong> in the <strong>right</strong> substring.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;011101&quot;
<strong>Output:</strong> 5 
<strong>Explanation:</strong> 
All possible ways of splitting s into two non-empty substrings are:
left = &quot;0&quot; and right = &quot;11101&quot;, score = 1 + 4 = 5 
left = &quot;01&quot; and right = &quot;1101&quot;, score = 1 + 3 = 4 
left = &quot;011&quot; and right = &quot;101&quot;, score = 1 + 2 = 3 
left = &quot;0111&quot; and right = &quot;01&quot;, score = 1 + 1 = 2 
left = &quot;01110&quot; and right = &quot;1&quot;, score = 2 + 1 = 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;00111&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> When left = &quot;00&quot; and right = &quot;111&quot;, we get the maximum score = 2 + 3 = 5
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;1111&quot;
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 500</code></li>
	<li>The string <code>s</code> consists of characters <code>&#39;0&#39;</code> and <code>&#39;1&#39;</code> only.</li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> $n\le 500$ allows recounting at every split, but the score is only zeros on the left plus ones on the right.
>
> Start with the total number of ones on the right. Moving the cut: a $0$ increments the left, a $1$ decrements the right. Track the maximum $l+r$, and never cut after the last character.

We use two variables $l$ and $r$ to record the number of 0s in the left substring and the number of 1s in the right substring, respectively. Initially, $l = 0$, and $r$ is equal to the number of 1s in the string $s$.

We traverse the first $n - 1$ characters of the string $s$. For each position $i$, if $s[i] = 0$, then $l$ is incremented by 1; otherwise, $r$ is decremented by 1. Then we update the answer to be the maximum value of $l + r$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int maxScore(String s) {
        int l = 0, r = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') {
                ++r;
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            l += (s.charAt(i) - '0') ^ 1;
            r -= s.charAt(i) - '0';
            ans = Math.max(ans, l + r);
        }
        return ans;
    }
}
```
