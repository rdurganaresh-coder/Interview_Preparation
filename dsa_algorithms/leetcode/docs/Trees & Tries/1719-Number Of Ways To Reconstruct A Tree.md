# 1719. Number Of Ways To Reconstruct A Tree

**Difficulty:** Hard  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/

---

[中文文档](/solution/1700-1799/1719.Number%20Of%20Ways%20To%20Reconstruct%20A%20Tree/README.md)

## Description

<p>You are given an array <code>pairs</code>, where <code>pairs[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>, and:</p>

<ul>
	<li>There are no duplicates.</li>
	<li><code>x<sub>i</sub> &lt; y<sub>i</sub></code></li>
</ul>

<p>Let <code>ways</code> be the number of rooted trees that satisfy the following conditions:</p>

<ul>
	<li>The tree consists of nodes whose values appeared in <code>pairs</code>.</li>
	<li>A pair <code>[x<sub>i</sub>, y<sub>i</sub>]</code> exists in <code>pairs</code> <strong>if and only if</strong> <code>x<sub>i</sub></code> is an ancestor of <code>y<sub>i</sub></code> or <code>y<sub>i</sub></code> is an ancestor of <code>x<sub>i</sub></code>.</li>
	<li><strong>Note:</strong> the tree does not have to be a binary tree.</li>
</ul>

<p>Two ways are considered to be different if there is at least one node that has different parents in both ways.</p>

<p>Return:</p>

<ul>
	<li><code>0</code> if <code>ways == 0</code></li>
	<li><code>1</code> if <code>ways == 1</code></li>
	<li><code>2</code> if <code>ways &gt; 1</code></li>
</ul>

<p>A <strong>rooted tree</strong> is a tree that has a single root node, and all edges are oriented to be outgoing from the root.</p>

<p>An <strong>ancestor</strong> of a node is any node on the path from the root to that node (excluding the node itself). The root has no ancestors.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1700-1799/1719.Number%20Of%20Ways%20To%20Reconstruct%20A%20Tree/images/trees2.png" style="width: 208px; height: 221px;" />
<pre>
<strong>Input:</strong> pairs = [[1,2],[2,3]]
<strong>Output:</strong> 1
<strong>Explanation:</strong> There is exactly one valid rooted tree, which is shown in the above figure.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1700-1799/1719.Number%20Of%20Ways%20To%20Reconstruct%20A%20Tree/images/tree.png" style="width: 234px; height: 241px;" />
<pre>
<strong>Input:</strong> pairs = [[1,2],[2,3],[1,3]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are multiple valid rooted trees. Three of them are shown in the above figures.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> pairs = [[1,2],[2,3],[2,4],[1,5]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no valid rooted trees.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= pairs.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= x<sub>i </sub>&lt; y<sub>i</sub> &lt;= 500</code></li>
	<li>The elements in <code>pairs</code> are unique.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Pairs encode ancestry: an edge exists iff one node is an ancestor of the other. We must report whether $0$, $1$, or more than one rooted tree fits.
>
> Larger pair-degree means closer to the root. Sort nodes by degree; a node's parent candidate is a neighbour of no-smaller degree.
>
> The candidate must be adjacent to every neighbour of the node. More than one node without a parent is impossible. Equal degrees on a parent-child pair yield multiple trees; otherwise exactly one.

#### Java

```java
class Solution {
    public int checkWays(int[][] pairs) {
        boolean[][] g = new boolean[510][510];
        List<Integer>[] v = new List[510];
        Arrays.setAll(v, k -> new ArrayList<>());
        for (int[] p : pairs) {
            int x = p[0], y = p[1];
            g[x][y] = true;
            g[y][x] = true;
            v[x].add(y);
            v[y].add(x);
        }
        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < 510; ++i) {
            if (!v[i].isEmpty()) {
                nodes.add(i);
                g[i][i] = true;
            }
        }
        nodes.sort(Comparator.comparingInt(a -> v[a].size()));
        boolean equal = false;
        int root = 0;
        for (int i = 0; i < nodes.size(); ++i) {
            int x = nodes.get(i);
            int j = i + 1;
            for (; j < nodes.size() && !g[x][nodes.get(j)]; ++j)
                ;
            if (j < nodes.size()) {
                int y = nodes.get(j);
                if (v[x].size() == v[y].size()) {
                    equal = true;
                }
                for (int z : v[x]) {
                    if (!g[y][z]) {
                        return 0;
                    }
                }
            } else {
                ++root;
            }
        }
        if (root > 1) {
            return 0;
        }
        return equal ? 2 : 1;
    }
}
```
