# 796. Rotate String

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/rotate-string/

---

[中文文档](/solution/0700-0799/0796.Rotate%20String/README.md)

## Description

<p>Given two strings <code>s</code> and <code>goal</code>, return <code>true</code> <em>if and only if</em> <code>s</code> <em>can become</em> <code>goal</code> <em>after some number of <strong>shifts</strong> on</em> <code>s</code>.</p>

<p>A <strong>shift</strong> on <code>s</code> consists of moving the leftmost character of <code>s</code> to the rightmost position.</p>

<ul>
	<li>For example, if <code>s = &quot;abcde&quot;</code>, then it will be <code>&quot;bcdea&quot;</code> after one shift.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abcde&quot;, goal = &quot;cdeab&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>Rotating <code>s</code> to the left by 2 positions moves <code>&quot;ab&quot;</code> to the end, resulting in <code>&quot;cdeab&quot;</code>, which is equal to <code>goal</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;abcde&quot;, goal = &quot;abced&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>No sequence of rotations of <code>s</code> can produce <code>&quot;abced&quot;</code>. The characters appear in a different relative order, so <code>goal</code> is not a rotation of <code>s</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, goal.length &lt;= 100</code></li>
	<li><code>s</code> and <code>goal</code> consist of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Is $\textit{goal}$ a rotation of $s$? Unequal lengths fail; otherwise $\textit{goal}$ is a substring of $s+s$.

#### Java

```java
class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
```
