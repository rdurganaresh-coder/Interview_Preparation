# 1476. Subrectangle Queries

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/subrectangle-queries/

---

[中文文档](/solution/1400-1499/1476.Subrectangle%20Queries/README.md)

## Description

<p>Implement the class <code>SubrectangleQueries</code>&nbsp;which receives a <code>rows x cols</code> rectangle as a matrix of integers in the constructor and supports two methods:</p>

<p>1.<code>&nbsp;updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)</code></p>

<ul>
	<li>Updates all values with <code>newValue</code> in the subrectangle whose upper left coordinate is <code>(row1,col1)</code> and bottom right coordinate is <code>(row2,col2)</code>.</li>
</ul>

<p>2.<code>&nbsp;getValue(int row, int col)</code></p>

<ul>
	<li>Returns the current value of the coordinate <code>(row,col)</code> from&nbsp;the rectangle.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;SubrectangleQueries&quot;,&quot;getValue&quot;,&quot;updateSubrectangle&quot;,&quot;getValue&quot;,&quot;getValue&quot;,&quot;updateSubrectangle&quot;,&quot;getValue&quot;,&quot;getValue&quot;]
[[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
<strong>Output</strong>
[null,1,null,5,5,null,10,5]
<strong>Explanation</strong>
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);  
// The initial rectangle (4x3) looks like:
// 1 2 1
// 4 3 4
// 3 2 1
// 1 1 1
subrectangleQueries.getValue(0, 2); // return 1
subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
// After this update the rectangle looks like:
// 5 5 5
// 5 5 5
// 5 5 5
// 5 5 5 
subrectangleQueries.getValue(0, 2); // return 5
subrectangleQueries.getValue(3, 1); // return 5
subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
// After this update the rectangle looks like:
// 5   5   5
// 5   5   5
// 5   5   5
// 10  10  10 
subrectangleQueries.getValue(3, 1); // return 10
subrectangleQueries.getValue(0, 2); // return 5
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input</strong>
[&quot;SubrectangleQueries&quot;,&quot;getValue&quot;,&quot;updateSubrectangle&quot;,&quot;getValue&quot;,&quot;getValue&quot;,&quot;updateSubrectangle&quot;,&quot;getValue&quot;]
[[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
<strong>Output</strong>
[null,1,null,100,100,null,20]
<strong>Explanation</strong>
SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
subrectangleQueries.getValue(0, 0); // return 1
subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
subrectangleQueries.getValue(0, 0); // return 100
subrectangleQueries.getValue(2, 2); // return 100
subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
subrectangleQueries.getValue(2, 2); // return 20
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>There will be at most <code><font face="monospace">500</font></code>&nbsp;operations considering both methods:&nbsp;<code>updateSubrectangle</code> and <code>getValue</code>.</li>
	<li><code>1 &lt;= rows, cols &lt;= 100</code></li>
	<li><code>rows ==&nbsp;rectangle.length</code></li>
	<li><code>cols == rectangle[i].length</code></li>
	<li><code>0 &lt;= row1 &lt;= row2 &lt; rows</code></li>
	<li><code>0 &lt;= col1 &lt;= col2 &lt; cols</code></li>
	<li><code>1 &lt;= newValue, rectangle[i][j] &lt;= 10^9</code></li>
	<li><code>0 &lt;= row &lt; rows</code></li>
	<li><code>0 &lt;= col &lt; cols</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> There are at most $500$ updates on a $100\times 100$ grid. Rewriting every cell would cost up to $500\cdot 10^4$ writes. Store updates and, on query, scan them from newest to oldest for the first rectangle that covers the cell; otherwise return the original value.

#### Java

```java
class SubrectangleQueries {
    private int[][] g;
    private LinkedList<int[]> ops = new LinkedList<>();

    public SubrectangleQueries(int[][] rectangle) {
        g = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        ops.addFirst(new int[] {row1, col1, row2, col2, newValue});
    }

    public int getValue(int row, int col) {
        for (var op : ops) {
            if (op[0] <= row && row <= op[2] && op[1] <= col && col <= op[3]) {
                return op[4];
            }
        }
        return g[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
```
