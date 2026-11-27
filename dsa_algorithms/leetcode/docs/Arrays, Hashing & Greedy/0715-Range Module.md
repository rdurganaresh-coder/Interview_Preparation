# 715. Range Module

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/range-module/

---

[中文文档](/solution/0700-0799/0715.Range%20Module/README.md)

## Description

<p>A Range Module is a module that tracks ranges of numbers. Design a data structure to track the ranges represented as <strong>half-open intervals</strong> and query about them.</p>

<p>A <strong>half-open interval</strong> <code>[left, right)</code> denotes all the real numbers <code>x</code> where <code>left &lt;= x &lt; right</code>.</p>

<p>Implement the <code>RangeModule</code> class:</p>

<ul>
	<li><code>RangeModule()</code> Initializes the object of the data structure.</li>
	<li><code>void addRange(int left, int right)</code> Adds the <strong>half-open interval</strong> <code>[left, right)</code>, tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval <code>[left, right)</code> that are not already tracked.</li>
	<li><code>boolean queryRange(int left, int right)</code> Returns <code>true</code> if every real number in the interval <code>[left, right)</code> is currently being tracked, and <code>false</code> otherwise.</li>
	<li><code>void removeRange(int left, int right)</code> Stops tracking every real number currently being tracked in the <strong>half-open interval</strong> <code>[left, right)</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;RangeModule&quot;, &quot;addRange&quot;, &quot;removeRange&quot;, &quot;queryRange&quot;, &quot;queryRange&quot;, &quot;queryRange&quot;]
[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
<strong>Output</strong>
[null, null, null, true, false, true]

<strong>Explanation</strong>
RangeModule rangeModule = new RangeModule();
rangeModule.addRange(10, 20);
rangeModule.removeRange(14, 16);
rangeModule.queryRange(10, 14); // return True,(Every number in [10, 14) is being tracked)
rangeModule.queryRange(13, 15); // return False,(Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
rangeModule.queryRange(16, 17); // return True, (The number 16 in [16, 17) is still being tracked, despite the remove operation)
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= left &lt; right &lt;= 10<sup>9</sup></code></li>
	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>addRange</code>, <code>queryRange</code>, and <code>removeRange</code>.</li>
</ul>

## Solutions

### Solution 1: Segment Tree

> **Thinking**
>
> Maintain add, remove, and covered-query on half-open ranges with endpoints up to $10^9$ and about $10^4$ operations. Merging an explicit interval list can scan many fragments per update.
>
> These are range assign / range query operations. A segment tree handles them in logarithmic time; the universe is too large to allocate fully, so we create nodes on demand and push lazy assign marks.
>
> Each node stores whether its segment is fully covered. A fully contained update writes the mark; a query returns $v$ on a covered node, otherwise pushes down and ands the two children. Each call is $O(\log n)$.

According to the problem description, we need to maintain a set of intervals, supporting operations of interval addition, deletion, and query. For the addition and deletion of intervals, we can use a segment tree to maintain the set of intervals.

The segment tree divides the entire interval into multiple non-continuous sub-intervals, the number of which does not exceed $\log(\textit{width})$. To update the value of an element, only $\log(\textit{width})$ intervals need to be updated, and these intervals are all included in a large interval containing the element. When modifying the interval, we need to use **lazy propagation** to ensure efficiency.

- Each node of the segment tree represents an interval;
- The segment tree has a unique root node, representing the entire statistical range, such as $[1,N]$;
- Each leaf node of the segment tree represents an elementary interval of length $1$, $[x,x]$;
- For each internal node $[l,r]$, its left child is $[l,\textit{mid}]$, and the right child is $[\textit{mid}+1,r]$, where $\textit{mid}=⌊(l+r)/2⌋$ (rounded down).

Due to the large data range of the problem, we can implement it with a dynamically allocated segment tree. A dynamically allocated segment tree means that we only allocate nodes when needed, instead of allocating all nodes at the beginning. This can save space, but it requires **lazy propagation** to maintain interval modification.

In terms of time complexity, the time complexity of each operation is $O(\log n)$. The space complexity is $O(m \log n)$. Here, $m$ is the number of operations, and $n$ is the data range.

#### Java

```java
class Node {
    Node left;
    Node right;
    int add;
    boolean v;
}

class SegmentTree {
    private Node root = new Node();

    public SegmentTree() {
    }

    public void modify(int left, int right, int v) {
        modify(left, right, v, 1, (int) 1e9, root);
    }

    public void modify(int left, int right, int v, int l, int r, Node node) {
        if (l >= left && r <= right) {
            node.v = v == 1;
            node.add = v;
            return;
        }
        pushdown(node);
        int mid = (l + r) >> 1;
        if (left <= mid) {
            modify(left, right, v, l, mid, node.left);
        }
        if (right > mid) {
            modify(left, right, v, mid + 1, r, node.right);
        }
        pushup(node);
    }

    public boolean query(int left, int right) {
        return query(left, right, 1, (int) 1e9, root);
    }

    public boolean query(int left, int right, int l, int r, Node node) {
        if (l >= left && r <= right) {
            return node.v;
        }
        pushdown(node);
        int mid = (l + r) >> 1;
        boolean v = true;
        if (left <= mid) {
            v = v && query(left, right, l, mid, node.left);
        }
        if (right > mid) {
            v = v && query(left, right, mid + 1, r, node.right);
        }
        return v;
    }

    public void pushup(Node node) {
        node.v = node.left != null && node.left.v && node.right != null && node.right.v;
    }

    public void pushdown(Node node) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add != 0) {
            node.left.add = node.add;
            node.right.add = node.add;
            node.left.v = node.add == 1;
            node.right.v = node.add == 1;
            node.add = 0;
        }
    }
}

class RangeModule {
    private SegmentTree tree = new SegmentTree();

    public RangeModule() {
    }

    public void addRange(int left, int right) {
        tree.modify(left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        return tree.query(left, right - 1);
    }

    public void removeRange(int left, int right) {
        tree.modify(left, right - 1, -1);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
```
