# 118. Pascal's Triangle

**Difficulty:** Easy  
**Category:** Matrices & Grids  
**LeetCode:** https://leetcode.com/problems/pascals-triangle/

---

[中文文档](/solution/0100-0199/0118.Pascal%27s%20Triangle/README.md)

## Description

<p>You are given an integer <code>numRows</code>.</p>

<p>Return the first <code>numRows</code> of <strong>Pascal&#39;s triangle</strong>.</p>

<p>In <strong>Pascal&#39;s triangle</strong>, each number is the sum of the two numbers directly above it and the first and last number on each row must be equal to 1, as shown below:</p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0100-0199/0118.Pascal%27s%20Triangle/images/PascalTriangleAnimated2.gif" style="height:240px; width:260px" />
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> numRows = 5
<strong>Output:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> numRows = 1
<strong>Output:</strong> [[1]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= numRows &lt;= 30</code></li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> Row $i$ is formed by adding adjacent entries of row $i-1$, with $1$s on both ends. $\textit{numRows}\le 30$, so building row by row is enough. Each row depends only on the previous one.

We first create an answer array $f$, then set the first row of $f$ to $[1]$. Next, starting from the second row, the first and last elements of each row are $1$, and for other elements $f[i][j] = f[i - 1][j - 1] + f[i - 1][j]$.

The time complexity is $O(n^2)$, and the space complexity is $O(1)$, where $n$ is the given number of rows.

#### Java

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> f = new ArrayList<>();
        f.add(List.of(1));
        for (int i = 0; i < numRows - 1; ++i) {
            List<Integer> g = new ArrayList<>();
            g.add(1);
            for (int j = 1; j < f.get(i).size(); ++j) {
                g.add(f.get(i).get(j - 1) + f.get(i).get(j));
            }
            g.add(1);
            f.add(g);
        }
        return f;
    }
}
```
