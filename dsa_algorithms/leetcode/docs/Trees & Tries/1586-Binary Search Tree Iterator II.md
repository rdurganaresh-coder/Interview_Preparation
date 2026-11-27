# 1586. Binary Search Tree Iterator II

**Difficulty:** Medium  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/binary-search-tree-iterator-ii/

---

[中文文档](/solution/1500-1599/1586.Binary%20Search%20Tree%20Iterator%20II/README.md)

## Description

<p>Implement the <code>BSTIterator</code> class that represents an iterator over the <strong><a href="https://en.wikipedia.org/wiki/Tree_traversal#In-order_(LNR)">in-order traversal</a></strong> of a binary search tree (BST):</p>

<ul>
	<li><code>BSTIterator(TreeNode root)</code> Initializes an object of the <code>BSTIterator</code> class. The <code>root</code> of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.</li>
	<li><code>boolean hasNext()</code> Returns <code>true</code> if there exists a number in the traversal to the right of the pointer, otherwise returns <code>false</code>.</li>
	<li><code>int next()</code> Moves the pointer to the right, then returns the number at the pointer.</li>
	<li><code>boolean hasPrev()</code> Returns <code>true</code> if there exists a number in the traversal to the left of the pointer, otherwise returns <code>false</code>.</li>
	<li><code>int prev()</code> Moves the pointer to the left, then returns the number at the pointer.</li>
</ul>

<p>Notice that by initializing the pointer to a non-existent smallest number, the first call to <code>next()</code> will return the smallest element in the BST.</p>

<p>You may assume that <code>next()</code> and <code>prev()</code> calls will always be valid. That is, there will be at least a next/previous number in the in-order traversal when <code>next()</code>/<code>prev()</code> is called.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<p><strong><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1500-1599/1586.Binary%20Search%20Tree%20Iterator%20II/images/untitled-diagram-1.png" style="width: 201px; height: 201px;" /></strong></p>

<pre>
<strong>Input</strong>
[&quot;BSTIterator&quot;, &quot;next&quot;, &quot;next&quot;, &quot;prev&quot;, &quot;next&quot;, &quot;hasNext&quot;, &quot;next&quot;, &quot;next&quot;, &quot;next&quot;, &quot;hasNext&quot;, &quot;hasPrev&quot;, &quot;prev&quot;, &quot;prev&quot;]
[[[7, 3, 15, null, null, 9, 20]], [null], [null], [null], [null], [null], [null], [null], [null], [null], [null], [null], [null]]
<strong>Output</strong>
[null, 3, 7, 3, 7, true, 9, 15, 20, false, true, 15, 9]

<strong>Explanation</strong>
// The underlined element is where the pointer currently is.
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]); // state is <u> </u> [3, 7, 9, 15, 20]
bSTIterator.next(); // state becomes [<u>3</u>, 7, 9, 15, 20], return 3
bSTIterator.next(); // state becomes [3, <u>7</u>, 9, 15, 20], return 7
bSTIterator.prev(); // state becomes [<u>3</u>, 7, 9, 15, 20], return 3
bSTIterator.next(); // state becomes [3, <u>7</u>, 9, 15, 20], return 7
bSTIterator.hasNext(); // return true
bSTIterator.next(); // state becomes [3, 7, <u>9</u>, 15, 20], return 9
bSTIterator.next(); // state becomes [3, 7, 9, <u>15</u>, 20], return 15
bSTIterator.next(); // state becomes [3, 7, 9, 15, <u>20</u>], return 20
bSTIterator.hasNext(); // return false
bSTIterator.hasPrev(); // return true
bSTIterator.prev(); // state becomes [3, 7, 9, <u>15</u>, 20], return 15
bSTIterator.prev(); // state becomes [3, 7, <u>9</u>, 15, 20], return 9
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>6</sup></code></li>
	<li>At most <code>10<sup>5</sup></code> calls will be made to <code>hasNext</code>, <code>next</code>, <code>hasPrev</code>, and <code>prev</code>.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you solve the problem without precalculating the values of the tree?

## Solutions

### Solution 1: In-order Traversal + Array

> **Thinking**
>
> The iterator must support both $\textit{next}$ and $\textit{prev}$ for up to $10^5$ calls. A stack that only stores the path to the current node can walk forward, but stepping back needs a predecessor search.
>
> An inorder walk flattens the BST into a sorted array; an index $i$ is the cursor. Next and prev become $i\pm 1$, and emptiness is a bound check. Initialization is linear; each later call is constant time.

We can use in-order traversal to store the values of all nodes in the binary search tree into an array $\textit{nums}$, and then use the array to implement the iterator. We define a pointer $i$, initially $i = -1$, which points to an element in the array $\textit{nums}$. Each time we call $\textit{next}()$, we add $1$ to the value of $i$ and return $\textit{nums}[i]$; each time we call $\textit{prev}()$, we subtract $1$ from the value of $i$ and return $\textit{nums}[i]$.

In terms of time complexity, initializing the iterator requires $O(n)$ time, where $n$ is the number of nodes in the binary search tree. Each call to $\textit{next}()$ and $\textit{prev}()$ requires $O(1)$ time. In terms of space complexity, we need $O(n)$ space to store the values of all nodes in the binary search tree.

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
class BSTIterator {
    private List<Integer> nums = new ArrayList<>();
    private int i = -1;

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    public boolean hasNext() {
        return i < nums.size() - 1;
    }

    public int next() {
        return nums.get(++i);
    }

    public boolean hasPrev() {
        return i > 0;
    }

    public int prev() {
        return nums.get(--i);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        nums.add(root.val);
        dfs(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */
```

### Solution 2: Explicit-Stack Inorder + Array

> **Thinking**
>
> The iterator must support both $\textit{next}$ and $\textit{prev}$ for up to $10^5$ calls. A stack that only stores the path to the current node can walk forward, but stepping back needs a predecessor search. Flattening the tree into a sorted array and moving an index is correct on a short tree.
>
> The tree can contain $10^5$ nodes. A left chain makes this inorder walk recurse once per node and overflow the call stack.
>
> Inorder of a BST is already nondecreasing. Each node finishes its left subtree, records itself, then visits the right subtree, and no return value is required.
>
> An explicit stack performs that inorder walk and writes the values into $\textit{nums}$. The cursor $i$ starts at $-1$. $\textit{next}$ and $\textit{prev}$ move $i$ by one and return $\textit{nums}[i]$; the bounds of $i$ answer whether another step exists.

An explicit stack walks the binary search tree inorder and stores every node value in an array $\textit{nums}$. On entry we push an exit marker and the left child; on exit we append the node value and push the right child. The cursor $i$ starts at $-1$. Each $\textit{next}()$ adds $1$ to $i$ and returns $\textit{nums}[i]$; each $\textit{prev}()$ subtracts $1$ from $i$ and returns $\textit{nums}[i]$.

In terms of time complexity, initializing the iterator requires $O(n)$ time, where $n$ is the number of nodes in the binary search tree. Each call to $\textit{next}()$ and $\textit{prev}()$ requires $O(1)$ time. In terms of space complexity, we need $O(n)$ space to store the values of all nodes in the binary search tree.

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
class BSTIterator {
    private static class Frame {
        TreeNode node;
        int state;

        Frame(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    private List<Integer> nums = new ArrayList<>();
    private int i = -1;

    public BSTIterator(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<Frame> stk = new ArrayDeque<>();
        stk.push(new Frame(root, 0));
        while (!stk.isEmpty()) {
            Frame cur = stk.pop();
            TreeNode node = cur.node;
            if (cur.state == 0) {
                stk.push(new Frame(node, 1));
                if (node.left != null) {
                    stk.push(new Frame(node.left, 0));
                }
                continue;
            }
            nums.add(node.val);
            if (node.right != null) {
                stk.push(new Frame(node.right, 0));
            }
        }
    }

    public boolean hasNext() {
        return i < nums.size() - 1;
    }

    public int next() {
        return nums.get(++i);
    }

    public boolean hasPrev() {
        return i > 0;
    }

    public int prev() {
        return nums.get(--i);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */
```
