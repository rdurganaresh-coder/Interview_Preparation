# 1361. Validate Binary Tree Nodes

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/validate-binary-tree-nodes/

---

[中文文档](/solution/1300-1399/1361.Validate%20Binary%20Tree%20Nodes/README.md)

## Description

<p>You have <code>n</code> binary tree nodes numbered from <code>0</code> to <code>n - 1</code> where node <code>i</code> has two children <code>leftChild[i]</code> and <code>rightChild[i]</code>, return <code>true</code> if and only if <strong>all</strong> the given nodes form <strong>exactly one</strong> valid binary tree.</p>

<p>If node <code>i</code> has no left child then <code>leftChild[i]</code> will equal <code>-1</code>, similarly for the right child.</p>

<p>Note that the nodes have no values and that we only use the node numbers in this problem.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1300-1399/1361.Validate%20Binary%20Tree%20Nodes/images/1503_ex1.png" style="width: 195px; height: 287px;" />
<pre>
<strong>Input:</strong> n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1300-1399/1361.Validate%20Binary%20Tree%20Nodes/images/1503_ex2.png" style="width: 183px; height: 272px;" />
<pre>
<strong>Input:</strong> n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1300-1399/1361.Validate%20Binary%20Tree%20Nodes/images/1503_ex3.png" style="width: 82px; height: 174px;" />
<pre>
<strong>Input:</strong> n = 2, leftChild = [1,0], rightChild = [-1,-1]
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == leftChild.length == rightChild.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>-1 &lt;= leftChild[i], rightChild[i] &lt;= n - 1</code></li>
</ul>

## Solutions

### Solution 1: Union-Find

> **Thinking**
>
> Left and right child arrays on $n$ nodes should form exactly one binary tree. Failures are a second parent, a cycle, or more than one component. Union-find rejects a child that already has a parent or an edge inside one component; otherwise it merges and decreases the component count, which must finish at $1$.

We can traverse each node $i$ and its corresponding left and right children $l$, $r$, using an array $\textit{vis}$ to record whether the node has a parent:

- If the child node already has a parent, it means there are multiple fathers, which does not meet the condition, so we return `false` directly.
- If the child node and the parent node are already in the same connected component, it means a cycle will be formed, which does not meet the condition, so we return `false` directly.
- Otherwise, we perform a union operation, set the corresponding position of the $\textit{vis}$ array to `true`, and decrease the number of connected components by $1$.

After the traversal, we check whether the number of connected components in the union-find set is $1$. If it is, we return `true`, otherwise, we return `false`.

The time complexity is $O(n \alpha(n))$, and the space complexity is $O(n)$, where $n$ is the number of nodes, and $\alpha(n)$ is the inverse Ackermann function, which is less than $5$.

#### Java

```java
class Solution {
    private int[] p;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        boolean[] vis = new boolean[n];
        for (int i = 0, m = n; i < m; ++i) {
            for (int j : new int[] {leftChild[i], rightChild[i]}) {
                if (j != -1) {
                    if (vis[j] || find(i) == find(j)) {
                        return false;
                    }
                    p[find(i)] = find(j);
                    vis[j] = true;
                    --n;
                }
            }
        }
        return n == 1;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
```

### Solution 2: Indegree Counting + BFS

> **Thinking**
>
> Union-find tracks parents and components. Counting indegrees finds the unique root (or fails). BFS from that root rejects a revisited child and finally requires every node to be seen, without a parent array.

We can first count the indegree of each node, i.e., how many parents point to it. If there is no node with indegree $0$, it means there is a cycle in the graph, so we return `false` directly; otherwise, that node is the root.

Next, we perform a breadth-first search starting from the root. During the traversal, if a child node has already been visited, it means the node has multiple parents or there is a cycle in the graph, so we return `false` directly.

After the traversal, we check whether the number of visited nodes equals $n$. If so, all nodes form exactly one valid binary tree and we return `true`; otherwise, we return `false`.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes.

#### Java

```java
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indeg = new int[n];
        for (int c : leftChild) {
            if (c != -1) {
                indeg[c]++;
            }
        }
        for (int c : rightChild) {
            if (c != -1) {
                indeg[c]++;
            }
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                root = i;
                break;
            }
        }
        if (root == -1) {
            return false;
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.add(root);
        Set<Integer> vis = new HashSet<>();
        vis.add(root);

        while (!q.isEmpty()) {
            int i = q.poll();
            int j = leftChild[i];
            if (j != -1) {
                if (vis.contains(j)) {
                    return false;
                }
                vis.add(j);
                q.add(j);
            }

            j = rightChild[i];
            if (j != -1) {
                if (vis.contains(j)) {
                    return false;
                }
                vis.add(j);
                q.add(j);
            }
        }

        return vis.size() == n;
    }
}
```
