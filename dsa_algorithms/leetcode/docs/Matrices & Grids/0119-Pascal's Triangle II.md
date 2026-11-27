# 119. Pascal's Triangle II

**Difficulty:** Easy  
**Category:** Matrices & Grids  
**LeetCode:** https://leetcode.com/problems/pascals-triangle-ii/

---

[中文文档](/solution/0100-0199/0119.Pascal%27s%20Triangle%20II/README.md)

## Description

<p>Given an integer <code>rowIndex</code>, return the <code>rowIndex<sup>th</sup></code> (<strong>0-indexed</strong>) row of the <strong>Pascal&#39;s triangle</strong>.</p>

<p>In <strong>Pascal&#39;s triangle</strong>, each number is the sum of the two numbers directly above it as shown:</p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0119.Pascal%27s%20Triangle%20II/images/PascalTriangleAnimated2.gif" style="height:240px; width:260px" />
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> rowIndex = 3
<strong>Output:</strong> [1,3,3,1]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> rowIndex = 0
<strong>Output:</strong> [1]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> rowIndex = 1
<strong>Output:</strong> [1,1]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= rowIndex &lt;= 33</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you optimize your algorithm to use only <code>O(rowIndex)</code> extra space?</p>

## Solutions

### Solution 1: Recursion

> **Thinking**
>
> We only need row $r$, not the whole triangle. The follow-up asks for $O(r)$ space. Updating $f[j] += f[j-1]$ from the right keeps the new row on the right and the old row on the left, so one array rolls forward to $\textit{rowIndex}$.

We create an array $f$ of length $\textit{rowIndex} + 1$, initially all elements are $1$.

Next, starting from the second row, we calculate the value of the $j$th element in the current row from back to front, $f[j] = f[j] + f[j - 1]$, where $j \in [1, i - 1]$.

Finally, return $f$.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the given number of rows.

#### Java

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> f = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; ++i) {
            f.add(1);
        }
        for (int i = 2; i < rowIndex + 1; ++i) {
            for (int j = i - 1; j > 0; --j) {
                f.set(j, f.get(j) + f.get(j - 1));
            }
        }
        return f;
    }
}
```
