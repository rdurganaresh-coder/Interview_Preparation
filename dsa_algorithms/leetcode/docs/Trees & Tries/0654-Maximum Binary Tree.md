# 654. Maximum Binary Tree

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/maximum-binary-tree/

---

[中文文档](/solution/0600-0699/0654.Maximum%20Binary%20Tree/README.md)

## Description

<p>You are given an integer array <code>nums</code> with no duplicates. A <strong>maximum binary tree</strong> can be built recursively from <code>nums</code> using the following algorithm:</p>

<ol>
	<li>Create a root node whose value is the maximum value in <code>nums</code>.</li>
	<li>Recursively build the left subtree on the <strong>subarray prefix</strong> to the <strong>left</strong> of the maximum value.</li>
	<li>Recursively build the right subtree on the <strong>subarray suffix</strong> to the <strong>right</strong> of the maximum value.</li>
</ol>

<p>Return <em>the <strong>maximum binary tree</strong> built from </em><code>nums</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0600-0699/0654.Maximum%20Binary%20Tree/images/tree1.jpg" style="width: 302px; height: 421px;" />
<pre>
<strong>Input:</strong> nums = [3,2,1,6,0,5]
<strong>Output:</strong> [6,3,5,null,2,0,null,null,1]
<strong>Explanation:</strong> The recursive calls are as follow:
- The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
    - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
        - Empty array, so no child.
        - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
            - Empty array, so no child.
            - Only one element, so child is a node with value 1.
    - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
        - Only one element, so child is a node with value 0.
        - Empty array, so no child.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0600-0699/0654.Maximum%20Binary%20Tree/images/tree2.jpg" style="width: 182px; height: 301px;" />
<pre>
<strong>Input:</strong> nums = [3,2,1]
<strong>Output:</strong> [3,null,2,null,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
	<li>All integers in <code>nums</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The root is the interval maximum; children follow the same rule. A linear scan for the max is $O(n^2)$ worst-case, acceptable for $n\le 10^3$.
>
> Take `max` and its index, then recurse on the two sides.

#### Java

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length - 1);
    }

    private TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }
        int i = l;
        for (int j = l; j <= r; ++j) {
            if (nums[i] < nums[j]) {
                i = j;
            }
        }
        TreeNode root = new TreeNode(nums[i]);
        root.left = dfs(l, i - 1);
        root.right = dfs(i + 1, r);
        return root;
    }
}
```

### Solution 2

> **Thinking**
>
> Each max query in method 1 is linear. A segment tree answers range maxima in $O(\log n)$, so the same recursion becomes $O(n \log n)$.

#### Java

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private SegmentTree tree;
    private int[] nums;
    private static int[] d = new int[1010];

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        tree = new SegmentTree(nums);
        for (int i = 0; i < n; ++i) {
            d[nums[i]] = i + 1;
        }
        return dfs(1, n);
    }

    private TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }
        int val = tree.query(1, l, r);
        TreeNode root = new TreeNode(val);
        root.left = dfs(l, d[val] - 1);
        root.right = dfs(d[val] + 1, r);
        return root;
    }
}

class Node {
    int l;
    int r;
    int v;
}

class SegmentTree {
    Node[] tr;
    int[] nums;

    public SegmentTree(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        tr = new Node[n << 2];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node();
        }
        build(1, 1, n);
    }

    private void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) {
            tr[u].v = nums[l - 1];
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushup(u);
    }

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].v;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        int v = 0;
        if (l <= mid) {
            v = query(u << 1, l, r);
        }
        if (r > mid) {
            v = Math.max(v, query(u << 1 | 1, l, r));
        }
        return v;
    }

    private void pushup(int u) {
        tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
    }
}
```

### Solution 3

> **Thinking**
>
> The segment tree is extra structure. A decreasing stack finds the nearest greater neighbor on the left: the last popped node becomes the left child, and the new top takes the current node as its right child. One pass builds the tree.

#### Java

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stk = new ArrayDeque<>();
        for (int v : nums) {
            TreeNode node = new TreeNode(v);
            TreeNode last = null;
            while (!stk.isEmpty() && stk.peek().val < v) {
                last = stk.pop();
            }
            node.left = last;
            if (!stk.isEmpty()) {
                stk.peek().right = node;
            }
            stk.push(node);
        }
        return stk.getLast();
    }
}
```

### Solution 4: Explicit Stack

> **Thinking**
>
> The root is the maximum of an interval, and both children follow the same rule. $n \le 1000$, so a linear scan for each maximum is acceptable in time. On an increasing array the maximum is always at the right end, so the first call always handles the remaining $n-1$ elements on the left and the depth is $n$, past the default recursion limit.
>
> The root of a segment depends only on its two endpoints, so the subarray does not need to be copied.
>
> Store pending half-open intervals $[l, r)$ on an explicit stack, together with which side of the parent they hang from. Pop an interval, scan for its maximum, create the node, then push the right interval and the left interval. An empty interval is skipped.

Scan the half-open interval $[l, r)$ for the index $i$ of the maximum, and make $\textit{nums}[i]$ the root. The left child is the interval $[l, i)$ and the right child is $[i + 1, r)$. Pending intervals live on an explicit stack: after a root is created, push the right interval and then the left interval. Empty intervals are skipped. The first interval is $[0, n)$.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        TreeNode root = null;
        Deque<Frame> stk = new ArrayDeque<>();
        stk.push(new Frame(0, n - 1, null, 0));
        while (!stk.isEmpty()) {
            Frame cur = stk.pop();
            if (cur.l > cur.r) {
                continue;
            }
            int i = cur.l;
            for (int j = cur.l; j <= cur.r; ++j) {
                if (nums[i] < nums[j]) {
                    i = j;
                }
            }
            TreeNode node = new TreeNode(nums[i]);
            if (cur.parent == null) {
                root = node;
            } else if (cur.side == 0) {
                cur.parent.left = node;
            } else {
                cur.parent.right = node;
            }
            stk.push(new Frame(i + 1, cur.r, node, 1));
            stk.push(new Frame(cur.l, i - 1, node, 0));
        }
        return root;
    }

    private static class Frame {
        int l, r, side;
        TreeNode parent;

        Frame(int l, int r, TreeNode parent, int side) {
            this.l = l;
            this.r = r;
            this.parent = parent;
            this.side = side;
        }
    }
}
```

### Solution 5: Segment Tree + Explicit Stack

> **Thinking**
>
> Solution 1 builds the tree by recursion, but each maximum is still a linear scan. A segment tree answers a range maximum in $O(\log n)$. The left interval can still form a chain of length $n$, so those two child intervals go on the same explicit stack. The total time is $O(n \log n)$.

#### Java

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private SegmentTree tree;
    private int[] nums;
    private static int[] d = new int[1010];

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        tree = new SegmentTree(nums);
        for (int i = 0; i < n; ++i) {
            d[nums[i]] = i + 1;
        }
        TreeNode root = null;
        Deque<Frame> stk = new ArrayDeque<>();
        stk.push(new Frame(1, n, null, 0));
        while (!stk.isEmpty()) {
            Frame cur = stk.pop();
            if (cur.l > cur.r) {
                continue;
            }
            int val = tree.query(1, cur.l, cur.r);
            TreeNode node = new TreeNode(val);
            if (cur.parent == null) {
                root = node;
            } else if (cur.side == 0) {
                cur.parent.left = node;
            } else {
                cur.parent.right = node;
            }
            int i = d[val];
            stk.push(new Frame(i + 1, cur.r, node, 1));
            stk.push(new Frame(cur.l, i - 1, node, 0));
        }
        return root;
    }

    private static class Frame {
        int l, r, side;
        TreeNode parent;

        Frame(int l, int r, TreeNode parent, int side) {
            this.l = l;
            this.r = r;
            this.parent = parent;
            this.side = side;
        }
    }
}

class Node {
    int l;
    int r;
    int v;
}

class SegmentTree {
    Node[] tr;
    int[] nums;

    public SegmentTree(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        tr = new Node[n << 2];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node();
        }
        build(1, 1, n);
    }

    private void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) {
            tr[u].v = nums[l - 1];
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushup(u);
    }

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].v;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        int v = 0;
        if (l <= mid) {
            v = query(u << 1, l, r);
        }
        if (r > mid) {
            v = Math.max(v, query(u << 1 | 1, l, r));
        }
        return v;
    }

    private void pushup(int u) {
        tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
    }
}
```
