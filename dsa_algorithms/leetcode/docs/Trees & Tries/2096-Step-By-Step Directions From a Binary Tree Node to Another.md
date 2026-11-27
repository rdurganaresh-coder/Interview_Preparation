# 2096. Step-By-Step Directions From a Binary Tree Node to Another

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

---

[中文文档](/solution/2000-2099/2096.Step-By-Step%20Directions%20From%20a%20Binary%20Tree%20Node%20to%20Another/README.md)

## Description

<p>You are given the <code>root</code> of a <strong>binary tree</strong> with <code>n</code> nodes. Each node is uniquely assigned a value from <code>1</code> to <code>n</code>. You are also given an integer <code>startValue</code> representing the value of the start node <code>s</code>, and a different integer <code>destValue</code> representing the value of the destination node <code>t</code>.</p>

<p>Find the <strong>shortest path</strong> starting from node <code>s</code> and ending at node <code>t</code>. Generate step-by-step directions of such path as a string consisting of only the <strong>uppercase</strong> letters <code>&#39;L&#39;</code>, <code>&#39;R&#39;</code>, and <code>&#39;U&#39;</code>. Each letter indicates a specific direction:</p>

<ul>
	<li><code>&#39;L&#39;</code> means to go from a node to its <strong>left child</strong> node.</li>
	<li><code>&#39;R&#39;</code> means to go from a node to its <strong>right child</strong> node.</li>
	<li><code>&#39;U&#39;</code> means to go from a node to its <strong>parent</strong> node.</li>
</ul>

<p>Return <em>the step-by-step directions of the <strong>shortest path</strong> from node </em><code>s</code><em> to node</em> <code>t</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2000-2099/2096.Step-By-Step%20Directions%20From%20a%20Binary%20Tree%20Node%20to%20Another/images/eg1.png" style="width: 214px; height: 163px;" />
<pre>
<strong>Input:</strong> root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
<strong>Output:</strong> &quot;UURL&quot;
<strong>Explanation:</strong> The shortest path is: 3 &rarr; 1 &rarr; 5 &rarr; 2 &rarr; 6.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2000-2099/2096.Step-By-Step%20Directions%20From%20a%20Binary%20Tree%20Node%20to%20Another/images/eg2.png" style="width: 74px; height: 102px;" />
<pre>
<strong>Input:</strong> root = [2,1], startValue = 2, destValue = 1
<strong>Output:</strong> &quot;L&quot;
<strong>Explanation:</strong> The shortest path is: 2 &rarr; 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is <code>n</code>.</li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= Node.val &lt;= n</code></li>
	<li>All the values in the tree are <strong>unique</strong>.</li>
	<li><code>1 &lt;= startValue, destValue &lt;= n</code></li>
	<li><code>startValue != destValue</code></li>
</ul>

## Solutions

### Solution 1: Lowest Common Ancestor + DFS

> **Thinking**
>
> The unique path goes through the LCA. Upward edges become `U`; the descent uses `L`/`R`. Three tree walks are fine for $n \le 10^5$.
>
> Find the LCA, DFS both directions from it, replace the start path by `U`s, and concatenate.

We can first find the lowest common ancestor of nodes $\textit{startValue}$ and $\textit{destValue}$, denoted as $\textit{node}$. Then, starting from $\textit{node}$, we find the paths to $\textit{startValue}$ and $\textit{destValue}$ respectively. The path from $\textit{startValue}$ to $\textit{node}$ will consist of a number of $U$s, and the path from $\textit{node}$ to $\textit{destValue}$ will be the $\textit{path}$. Finally, we concatenate these two paths.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree.

#### Java

```java
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode node = lca(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        dfs(node, startValue, pathToStart);
        dfs(node, destValue, pathToDest);
        return "U".repeat(pathToStart.length()) + pathToDest.toString();
    }

    private TreeNode lca(TreeNode node, int p, int q) {
        if (node == null || node.val == p || node.val == q) {
            return node;
        }
        TreeNode left = lca(node.left, p, q);
        TreeNode right = lca(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }

    private boolean dfs(TreeNode node, int x, StringBuilder path) {
        if (node == null) {
            return false;
        }
        if (node.val == x) {
            return true;
        }
        path.append('L');
        if (dfs(node.left, x, path)) {
            return true;
        }
        path.setCharAt(path.length() - 1, 'R');
        if (dfs(node.right, x, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }
}
```

### Solution 2: Lowest Common Ancestor + DFS (Optimized)

> **Thinking**
>
> Solution 1 finds the LCA then walks twice more. Paths from the root share a prefix; stripping it is exactly “up to the LCA then down.” The extra LCA search disappears.
>
> Two DFS strings, skip the common prefix of length $i$, emit $(|\textit{start}|-i)$ `U`s plus the destination suffix.

We can start from $\textit{root}$, find the paths to $\textit{startValue}$ and $\textit{destValue}$, denoted as $\textit{pathToStart}$ and $\textit{pathToDest}$, respectively. Then, remove the longest common prefix of $\textit{pathToStart}$ and $\textit{pathToDest}$. At this point, the length of $\textit{pathToStart}$ is the number of $U$s in the answer, and the path of $\textit{pathToDest}$ is the path in the answer. We just need to concatenate these two paths.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree.

#### Java

```java
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        dfs(root, startValue, pathToStart);
        dfs(root, destValue, pathToDest);
        int i = 0;
        while (i < pathToStart.length() && i < pathToDest.length()
            && pathToStart.charAt(i) == pathToDest.charAt(i)) {
            ++i;
        }
        return "U".repeat(pathToStart.length() - i) + pathToDest.substring(i);
    }

    private boolean dfs(TreeNode node, int x, StringBuilder path) {
        if (node == null) {
            return false;
        }
        if (node.val == x) {
            return true;
        }
        path.append('L');
        if (dfs(node.left, x, path)) {
            return true;
        }
        path.setCharAt(path.length() - 1, 'R');
        if (dfs(node.right, x, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }
}
```

### Solution 3: Explicit-Stack Lowest Common Ancestor

> **Thinking**
>
> The shortest path goes through the lowest common ancestor. Every step above that ancestor is `U`, and the descent from the ancestor to the destination is `L` or `R`. Three linear walks fit $n \le 10^5$.
>
> Both the ancestor search and the direction search enter the left child first. A left chain can be $n$ nodes long, so recursion overflows before the direction string is finished.
>
> The ancestor is known only after both subtrees return: the current node is the ancestor when both sides found a target, otherwise the non-empty side is passed upward. An explicit stack separates “expand both children” from “both children have returned,” and the direction search pushes a backtrack marker before the left child. A failed left subtree rewrites the last step to `R` and searches the right child, stopping when the target is found.
>
> The length of the start path is the number of `U`s, concatenated with the path from the ancestor to the destination.

An explicit stack finds the lowest common ancestor of $\textit{startValue}$ and $\textit{destValue}$, denoted as $\textit{node}$. State $0$ expands the two children, and state $1$ decides the ancestor after both sides return: the current node when both sides are non-empty, otherwise the non-empty side. The same stack then walks from $\textit{node}$, recording `L` to the left and rewriting that step to `R` when the left subtree misses the target. The number of steps from $\textit{startValue}$ back to $\textit{node}$ is the number of `U`s, followed by the direction string from $\textit{node}$ to $\textit{destValue}$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree.

#### Java

```java
class Solution {
    private static class Frame {
        TreeNode node;
        int state;

        Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode node = lca(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        dfs(node, startValue, pathToStart);
        dfs(node, destValue, pathToDest);
        return "U".repeat(pathToStart.length()) + pathToDest.toString();
    }

    private TreeNode lca(TreeNode root, int p, int q) {
        Map<TreeNode, TreeNode> ret = new IdentityHashMap<>();
        Deque<Frame> stk = new ArrayDeque<>();
        stk.push(new Frame(root, 0));
        while (!stk.isEmpty()) {
            Frame cur = stk.pop();
            TreeNode node = cur.node;
            if (cur.state == 0) {
                if (node == null) {
                    continue;
                }
                if (node.val == p || node.val == q) {
                    ret.put(node, node);
                    continue;
                }
                stk.push(new Frame(node, 1));
                stk.push(new Frame(node.right, 0));
                stk.push(new Frame(node.left, 0));
            } else {
                TreeNode left = node.left == null ? null : ret.get(node.left);
                TreeNode right = node.right == null ? null : ret.get(node.right);
                if (left != null && right != null) {
                    ret.put(node, node);
                } else {
                    ret.put(node, left != null ? left : right);
                }
            }
        }
        return ret.get(root);
    }

    private boolean dfs(TreeNode start, int x, StringBuilder path) {
        Deque<Frame> stk = new ArrayDeque<>();
        stk.push(new Frame(start, 0));
        while (!stk.isEmpty()) {
            Frame cur = stk.pop();
            TreeNode node = cur.node;
            if (cur.state == 0) {
                if (node == null) {
                    continue;
                }
                if (node.val == x) {
                    return true;
                }
                path.append('L');
                stk.push(new Frame(node, 1));
                stk.push(new Frame(node.left, 0));
            } else if (cur.state == 1) {
                path.setCharAt(path.length() - 1, 'R');
                stk.push(new Frame(node, 2));
                stk.push(new Frame(node.right, 0));
            } else {
                path.deleteCharAt(path.length() - 1);
            }
        }
        return false;
    }
}
```

### Solution 4: Explicit-Stack Root Paths

> **Thinking**
>
> Solution 1 still runs a separate ancestor search and then walks twice from that ancestor. Paths from the root share a prefix, and stripping it is the same as climbing back to the ancestor and then descending, so the dedicated ancestor search can be dropped.
>
> The two direction searches can still follow a chain of length $n$, so they use the same explicit stack: push a backtrack marker, then the left child, and rewrite the last step to `R` when the left subtree fails.
>
> After the common prefix of length $i$ is removed, the answer is $(|\textit{start}|-i)$ `U`s plus the destination suffix.

An explicit stack walks from $\textit{root}$ to $\textit{startValue}$ and to $\textit{destValue}$, producing $\textit{pathToStart}$ and $\textit{pathToDest}$. A failed left subtree rewrites the last step to `R` before the right child is searched, so the strings match the previous depth-first order. After the longest common prefix is removed, the remaining length of $\textit{pathToStart}$ is the number of `U`s, and the remaining part of $\textit{pathToDest}$ is the downward path. Concatenate the two pieces.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the binary tree.

#### Java

```java
class Solution {
    private static class Frame {
        TreeNode node;
        int state;

        Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        dfs(root, startValue, pathToStart);
        dfs(root, destValue, pathToDest);
        int i = 0;
        while (i < pathToStart.length() && i < pathToDest.length()
            && pathToStart.charAt(i) == pathToDest.charAt(i)) {
            ++i;
        }
        return "U".repeat(pathToStart.length() - i) + pathToDest.substring(i);
    }

    private boolean dfs(TreeNode start, int x, StringBuilder path) {
        Deque<Frame> stk = new ArrayDeque<>();
        stk.push(new Frame(start, 0));
        while (!stk.isEmpty()) {
            Frame cur = stk.pop();
            TreeNode node = cur.node;
            if (cur.state == 0) {
                if (node == null) {
                    continue;
                }
                if (node.val == x) {
                    return true;
                }
                path.append('L');
                stk.push(new Frame(node, 1));
                stk.push(new Frame(node.left, 0));
            } else if (cur.state == 1) {
                path.setCharAt(path.length() - 1, 'R');
                stk.push(new Frame(node, 2));
                stk.push(new Frame(node.right, 0));
            } else {
                path.deleteCharAt(path.length() - 1);
            }
        }
        return false;
    }
}
```
