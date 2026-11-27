# 2538. Difference Between Maximum and Minimum Price Sum

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum/

---

[中文文档](/solution/2500-2599/2538.Difference%20Between%20Maximum%20and%20Minimum%20Price%20Sum/README.md)

## Description

<p>There exists an undirected and initially unrooted tree with <code>n</code> nodes indexed from <code>0</code> to <code>n - 1</code>. You are given the integer <code>n</code> and a 2D integer array <code>edges</code> of length <code>n - 1</code>, where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> in the tree.</p>

<p>Each node has an associated price. You are given an integer array <code>price</code>, where <code>price[i]</code> is the price of the <code>i<sup>th</sup></code> node.</p>

<p>The <strong>price sum</strong> of a given path is the sum of the prices of all nodes lying on that path.</p>

<p>The tree can be rooted at any node <code>root</code> of your choice. The incurred <strong>cost</strong> after choosing <code>root</code> is the difference between the maximum and minimum <strong>price sum</strong> amongst all paths starting at <code>root</code>.</p>

<p>Return <em>the <strong>maximum</strong> possible <strong>cost</strong></em> <em>amongst all possible root choices</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2500-2599/2538.Difference%20Between%20Maximum%20and%20Minimum%20Price%20Sum/images/example14.png" style="width: 556px; height: 231px;" />
<pre>
<strong>Input:</strong> n = 6, edges = [[0,1],[1,2],[1,3],[3,4],[3,5]], price = [9,8,7,6,10,5]
<strong>Output:</strong> 24
<strong>Explanation:</strong> The diagram above denotes the tree after rooting it at node 2. The first part (colored in red) shows the path with the maximum price sum. The second part (colored in blue) shows the path with the minimum price sum.
- The first path contains nodes [2,1,3,4]: the prices are [7,8,6,10], and the sum of the prices is 31.
- The second path contains the node [2] with the price [7].
The difference between the maximum and minimum price sum is 24. It can be proved that 24 is the maximum cost.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2500-2599/2538.Difference%20Between%20Maximum%20and%20Minimum%20Price%20Sum/images/p1_example2.png" style="width: 352px; height: 184px;" />
<pre>
<strong>Input:</strong> n = 3, edges = [[0,1],[1,2]], price = [1,1,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The diagram above denotes the tree after rooting it at node 0. The first part (colored in red) shows the path with the maximum price sum. The second part (colored in blue) shows the path with the minimum price sum.
- The first path contains nodes [0,1,2]: the prices are [1,1,1], and the sum of the prices is 3.
- The second path contains node [0] with a price [1].
The difference between the maximum and minimum price sum is 2. It can be proved that 2 is the maximum cost.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n - 1</code></li>
	<li><code>edges</code> represents a valid tree.</li>
	<li><code>price.length == n</code></li>
	<li><code>1 &lt;= price[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A path costs the sum of node prices minus the smaller endpoint; we want the maximum over all paths. Prices are positive, so this is the path sum minus one endpoint. Enumerating paths is $O(n^2)$.
>
> Tree DP keeps two values per subtree: the longest downward chain $a$ that still includes the far endpoint, and the longest chain $b$ after dropping that endpoint. Combining $a$ with a child's $d$, or $b$ with a child's $c$, covers the best path through the current node.

#### Java

```java
class Solution {
    private List<Integer>[] g;
    private long ans;
    private int[] price;

    public long maxOutput(int n, int[][] edges, int[] price) {
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        this.price = price;
        dfs(0, -1);
        return ans;
    }

    private long[] dfs(int i, int fa) {
        long a = price[i], b = 0;
        for (int j : g[i]) {
            if (j != fa) {
                var e = dfs(j, i);
                long c = e[0], d = e[1];
                ans = Math.max(ans, Math.max(a + d, b + c));
                a = Math.max(a, price[i] + c);
                b = Math.max(b, price[i] + d);
            }
        }
        return new long[] {a, b};
    }
}
```

### Solution 2: Tree DP + Explicit Stack

> **Thinking**
>
> A path costs the sum of node prices minus the smaller endpoint, and prices are positive, so that is the path sum minus one endpoint. With $n \le 10^5$, enumerating paths is $O(n^2)$, and recursing from the root for the two downward chains is too deep: a chain makes the call depth $n$.
>
> Each node keeps two values: the longest downward chain $a$ that still includes the far endpoint, and the longest chain $b$ after that endpoint is dropped. The best path through the node joins one of those chains with a child's chain of the other kind, $a$ with $d$ or $b$ with $c$.
>
> An explicit stack of $(\textit{node}, \textit{parent}, \textit{state})$ runs the postorder. On entry we push the exit marker and then the children, and on exit we update the answer from the children's two chains and store this node's $a$ and $b$.

#### Java

```java
class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        long[][] down = new long[n][2];
        long ans = 0;
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, -1, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], fa = cur[1], state = cur[2];
            if (state == 0) {
                stk.push(new int[] {i, fa, 1});
                for (int j : g[i]) {
                    if (j != fa) {
                        stk.push(new int[] {j, i, 0});
                    }
                }
            } else {
                long a = price[i], b = 0;
                for (int j : g[i]) {
                    if (j != fa) {
                        long c = down[j][0], d = down[j][1];
                        ans = Math.max(ans, Math.max(a + d, b + c));
                        a = Math.max(a, price[i] + c);
                        b = Math.max(b, price[i] + d);
                    }
                }
                down[i][0] = a;
                down[i][1] = b;
            }
        }
        return ans;
    }
}
```
