# 3174. Clear Digits

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/clear-digits/

---

[中文文档](/solution/3100-3199/3174.Clear%20Digits/README.md)

## Description

<p>You are given a string <code>s</code>.</p>

<p>Your task is to remove <strong>all</strong> digits by doing this operation repeatedly:</p>

<ul>
	<li>Delete the <em>first</em> digit and the <strong>closest</strong> <b>non-digit</b> character to its <em>left</em>.</li>
</ul>

<p>Return the resulting string after removing all digits.</p>

<p><strong>Note</strong> that the operation <em>cannot</em> be performed on a digit that does not have any non-digit character to its left.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abc&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;abc&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>There is no digit in the string.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;cb34&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p>First, we apply the operation on <code>s[2]</code>, and <code>s</code> becomes <code>&quot;c4&quot;</code>.</p>

<p>Then we apply the operation on <code>s[1]</code>, and <code>s</code> becomes <code>&quot;&quot;</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists only of lowercase English letters and digits.</li>
	<li>The input is generated such that it is possible to delete all digits.</li>
</ul>

## Solutions

### Solution 1: Stack + Simulation

> **Thinking**
>
> A digit deletes itself and the closest letter to its left. Repeatedly editing the string is quadratic.
>
> While scanning left to right the stack top is the nearest surviving character, so a digit simply pops.
>
> Push letters and pop on digits, then join the stack. Each character enters at most once.

We use a stack `stk` to simulate this process. We traverse the string `s`. If the current character is a digit, we pop the top element from the stack. Otherwise, we push the current character into the stack.

Finally, we concatenate the elements in the stack into a string and return it.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public String clearDigits(String s) {
        StringBuilder stk = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stk.deleteCharAt(stk.length() - 1);
            } else {
                stk.append(c);
            }
        }
        return stk.toString();
    }
}
```
