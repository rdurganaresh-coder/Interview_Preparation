# 171. Excel Sheet Column Number

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/excel-sheet-column-number/

---

[中文文档](/solution/0100-0199/0171.Excel%20Sheet%20Column%20Number/README.md)

## Description

<p>Given a string <code>columnTitle</code> that represents the column title as appears in an Excel sheet, return <em>its corresponding column number</em>.</p>

<p>For example:</p>

<pre>
A -&gt; 1
B -&gt; 2
C -&gt; 3
...
Z -&gt; 26
AA -&gt; 27
AB -&gt; 28 
...
</pre>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> columnTitle = &quot;A&quot;
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> columnTitle = &quot;AB&quot;
<strong>Output:</strong> 28
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> columnTitle = &quot;ZY&quot;
<strong>Output:</strong> 701
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= columnTitle.length &lt;= 7</code></li>
	<li><code>columnTitle</code> consists only of uppercase English letters.</li>
	<li><code>columnTitle</code> is in the range <code>[&quot;A&quot;, &quot;FXSHRXW&quot;]</code>.</li>
</ul>

## Solutions

### Solution 1: Base Conversion

> **Thinking**
>
> Title to number is the inverse of problem $168$: each letter is a digit in $1\ldots 26$. Fold left to right with $\textit{ans}=\textit{ans}\times 26 + (c-'A'+1)$, the same pattern as parsing a decimal string.

The column name in Excel is a representation in base 26. For example, "AB" represents the column number $1 \times 26 + 2 = 28$.

Therefore, we can iterate through the string `columnTitle`, convert each character to its corresponding value, and then calculate the result.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $\textit{columnTitle}$.

#### Java

```java
class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); ++i) {
            ans = ans * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return ans;
    }
}
```
