# 3160. Find the Number of Distinct Colors Among the Balls

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/

---

[中文文档](/solution/3100-3199/3160.Find%20the%20Number%20of%20Distinct%20Colors%20Among%20the%20Balls/README.md)

## Description

<p>You are given an integer <code>limit</code> and a 2D array <code>queries</code> of size <code>n x 2</code>.</p>

<p>There are <code>limit + 1</code> balls with <strong>distinct</strong> labels in the range <code>[0, limit]</code>. Initially, all balls are uncolored. For every query in <code>queries</code> that is of the form <code>[x, y]</code>, you mark ball <code>x</code> with the color <code>y</code>. After each query, you need to find the number of colors among the balls.</p>

<p>Return an array <code>result</code> of length <code>n</code>, where <code>result[i]</code> denotes the number of colors <em>after</em> <code>i<sup>th</sup></code> query.</p>

<p><strong>Note</strong> that when answering a query, lack of a color <em>will not</em> be considered as a color.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">limit = 4, queries = [[1,4],[2,5],[1,3],[3,4]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,2,3]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3100-3199/3160.Find%20the%20Number%20of%20Distinct%20Colors%20Among%20the%20Balls/images/ezgifcom-crop.gif" style="width: 455px; height: 145px;" /></p>

<ul>
	<li>After query 0, ball 1 has color 4.</li>
	<li>After query 1, ball 1 has color 4, and ball 2 has color 5.</li>
	<li>After query 2, ball 1 has color 3, and ball 2 has color 5.</li>
	<li>After query 3, ball 1 has color 3, ball 2 has color 5, and ball 3 has color 4.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">limit = 4, queries = [[0,1],[1,2],[2,2],[3,4],[4,5]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,2,3,4]</span></p>

<p><strong>Explanation:</strong></p>

<p><strong><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3100-3199/3160.Find%20the%20Number%20of%20Distinct%20Colors%20Among%20the%20Balls/images/ezgifcom-crop2.gif" style="width: 457px; height: 144px;" /></strong></p>

<ul>
	<li>After query 0, ball 0 has color 1.</li>
	<li>After query 1, ball 0 has color 1, and ball 1 has color 2.</li>
	<li>After query 2, ball 0 has color 1, and balls 1 and 2 have color 2.</li>
	<li>After query 3, ball 0 has color 1, balls 1 and 2 have color 2, and ball 3 has color 4.</li>
	<li>After query 4, ball 0 has color 1, balls 1 and 2 have color 2, ball 3 has color 4, and ball 4 has color 5.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= limit &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= n == queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>queries[i].length == 2</code></li>
	<li><code>0 &lt;= queries[i][0] &lt;= limit</code></li>
	<li><code>1 &lt;= queries[i][1] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Double Hash Tables

> **Thinking**
>
> Each update paints one ball and asks how many distinct colors exist. $\textit{limit}$ may be $10^9$, so an array of balls is impossible, and rescanning after every paint is too slow.
>
> Only the painted ball changes: increment the new color, decrement the old one and drop it at zero. The number of keys is the answer.
>
> Map balls to colors in $g$ and colors to counts in $\textit{cnt}$. After each query append $\textit{len}(\textit{cnt})$.

We use a hash table `g` to record the color of each ball, and another hash table $\textit{cnt}$ to record the count of each color.

Next, we traverse the array `queries`. For each query $(x, y)$, we increase the count of color $y$ by $1$, then check whether ball $x$ has been colored. If it has, we decrease the count of the color of ball $x$ by $1$. If the count drops to $0$, we remove it from the hash table $\textit{cnt}$. Then, we update the color of ball $x$ to $y$, and add the current size of the hash table $\textit{cnt}$ to the answer array.

After the traversal, we return the answer array.

The time complexity is $O(m)$, and the space complexity is $O(m)$, where $m$ is the length of the array $\textit{queries}$.

#### Java

```java
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> g = new HashMap<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int x = queries[i][0], y = queries[i][1];
            cnt.merge(y, 1, Integer::sum);
            if (g.containsKey(x) && cnt.merge(g.get(x), -1, Integer::sum) == 0) {
                cnt.remove(g.get(x));
            }
            g.put(x, y);
            ans[i] = cnt.size();
        }
        return ans;
    }
}
```
