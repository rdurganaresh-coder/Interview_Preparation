# 3127. Make a Square with the Same Color

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/make-a-square-with-the-same-color/

---

[中文文档](/solution/3100-3199/3127.Make%20a%20Square%20with%20the%20Same%20Color/README.md)

## Description

<p>You are given a 2D matrix <code>grid</code> of size <code>3 x 3</code> consisting only of characters <code>&#39;B&#39;</code> and <code>&#39;W&#39;</code>. Character <code>&#39;W&#39;</code> represents the white color, and character <code>&#39;B&#39;</code> represents the black color.</p>

<p>Your task is to change the color of <strong>at most one</strong> cell so that the matrix has a <code>2 x 2</code> square where all cells are of the same color.</p>

<p>Return <code>true</code> if it is possible to create a <code>2 x 2</code> square of the same color, otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<style type="text/css">.grid-container {
  display: grid;
  grid-template-columns: 30px 30px 30px;
  padding: 10px;
}
.grid-item {
  background-color: black;
  border: 1px solid gray;
  height: 30px;
  font-size: 30px;
  text-align: center;
}
.grid-item-white {
  background-color: white;
}
</style>
<style class="darkreader darkreader--sync" media="screen" type="text/css">
</style>
<p><strong class="example">Example 1:</strong></p>

<div class="grid-container">
<div class="grid-item">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item">&nbsp;</div>

<div class="grid-item">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item">&nbsp;</div>
</div>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[&quot;B&quot;,&quot;W&quot;,&quot;B&quot;],[&quot;B&quot;,&quot;W&quot;,&quot;W&quot;],[&quot;B&quot;,&quot;W&quot;,&quot;B&quot;]]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>It can be done by changing the color of the <code>grid[0][2]</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="grid-container">
<div class="grid-item">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item">&nbsp;</div>
</div>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[&quot;B&quot;,&quot;W&quot;,&quot;B&quot;],[&quot;W&quot;,&quot;B&quot;,&quot;W&quot;],[&quot;B&quot;,&quot;W&quot;,&quot;B&quot;]]</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>It cannot be done by changing at most one cell.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="grid-container">
<div class="grid-item">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item">&nbsp;</div>

<div class="grid-item">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>

<div class="grid-item grid-item-white">&nbsp;</div>
</div>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">grid = [[&quot;B&quot;,&quot;W&quot;,&quot;B&quot;],[&quot;B&quot;,&quot;W&quot;,&quot;W&quot;],[&quot;B&quot;,&quot;W&quot;,&quot;W&quot;]]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>The <code>grid</code> already contains a <code>2 x 2</code> square of the same color.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>grid.length == 3</code></li>
	<li><code>grid[i].length == 3</code></li>
	<li><code>grid[i][j]</code> is either <code>&#39;W&#39;</code> or <code>&#39;B&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> The board is $3\times 3$ and one recolor should create a monochrome $2\times 2$. Trying every cell to flip is possible but less direct than inspecting each window.
>
> A $2\times 2$ that is already unbalanced (three of one color) becomes solid after one change; a solid window needs none. Both cases are exactly “black count $\neq$ white count”.
>
> Enumerate the four windows, count `W` and `B`, and return true on the first imbalance. The board size is constant.

We can enumerate each $2 \times 2$ square, count the number of black and white cells. If the counts are not equal, then we can construct a square of the same color, and return `true`.

Otherwise, return `false` after the traversal.

The time complexity is $O(1)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public boolean canMakeSquare(char[][] grid) {
        final int[] dirs = {0, 0, 1, 1, 0};
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                int cnt1 = 0, cnt2 = 0;
                for (int k = 0; k < 4; ++k) {
                    int x = i + dirs[k], y = j + dirs[k + 1];
                    cnt1 += grid[x][y] == 'W' ? 1 : 0;
                    cnt2 += grid[x][y] == 'B' ? 1 : 0;
                }
                if (cnt1 != cnt2) {
                    return true;
                }
            }
        }
        return false;
    }
}
```
