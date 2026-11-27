# 316. Remove Duplicate Letters

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/remove-duplicate-letters/

---

[中文文档](/solution/0300-0399/0316.Remove%20Duplicate%20Letters/README.md)

## Description

<p>Given a string <code>s</code>, remove duplicate letters so that every letter appears once and only once. The relative order of the letters that were not removed must be preserved. You must make sure your result is <span data-keyword="lexicographically-smaller-string"><strong>the smallest in lexicographical order</strong></span> among all possible results.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;bcabc&quot;
<strong>Output:</strong> &quot;abc&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cbacdcbc&quot;
<strong>Output:</strong> &quot;acdb&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as 1081: <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/" target="_blank">https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/</a></p>

## Solutions

### Solution 1: Stack

> **Thinking**
>
> We want the lexicographically smallest subsequence that uses each present letter once. Searching all subsequences is too large.
>
> Record each letter's last index. Scan left to right: skip a letter already on the stack; otherwise pop a larger top while it still occurs later, then push. The monotone stack keeps the prefix small; last indices guarantee a popped letter can return.

We use an array `last` to record the last occurrence of each character, a stack to save the result string, and an array `vis` or an integer variable `mask` to record whether the current character is in the stack.

Traverse the string $s$, for each character $c$, if $c$ is not in the stack, we need to check whether the top element of the stack is greater than $c$. If it is greater than $c$ and the top element of the stack will appear later, we pop the top element of the stack and push $c$ into the stack.

Finally, concatenate the elements in the stack into a string and return it as the result.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] last = new int[26];
        for (int i = 0; i < n; ++i) {
            last[s.charAt(i) - 'a'] = i;
        }
        Deque<Character> stk = new ArrayDeque<>();
        int mask = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (((mask >> (c - 'a')) & 1) == 1) {
                continue;
            }
            while (!stk.isEmpty() && stk.peek() > c && last[stk.peek() - 'a'] > i) {
                mask ^= 1 << (stk.pop() - 'a');
            }
            stk.push(c);
            mask |= 1 << (c - 'a');
        }
        StringBuilder ans = new StringBuilder();
        for (char c : stk) {
            ans.append(c);
        }
        return ans.reverse().toString();
    }
}
```

### Solution 2

> **Thinking**
>
> Method 1 uses last indices to test leftover occurrences. Count frequencies first and decrement while scanning; pop the top while its remaining count is positive. The test is equivalent without storing last positions.
