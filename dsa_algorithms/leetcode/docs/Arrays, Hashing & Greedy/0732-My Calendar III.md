# 732. My Calendar III

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/my-calendar-iii/

---

[中文文档](/solution/0700-0799/0732.My%20Calendar%20III/README.md)

## Description

<p>A <code>k</code>-booking happens when <code>k</code> events have some non-empty intersection (i.e., there is some time that is common to all <code>k</code> events.)</p>

<p>You are given some events <code>[startTime, endTime)</code>, after each given event, return an integer <code>k</code> representing the maximum <code>k</code>-booking between all the previous events.</p>

<p>Implement the <code>MyCalendarThree</code> class:</p>

<ul>
	<li><code>MyCalendarThree()</code> Initializes the object.</li>
	<li><code>int book(int startTime, int endTime)</code> Returns an integer <code>k</code> representing the largest integer such that there exists a <code>k</code>-booking in the calendar.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;MyCalendarThree&quot;, &quot;book&quot;, &quot;book&quot;, &quot;book&quot;, &quot;book&quot;, &quot;book&quot;, &quot;book&quot;]
[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
<strong>Output</strong>
[null, 1, 1, 2, 3, 3, 3]

<strong>Explanation</strong>
MyCalendarThree myCalendarThree = new MyCalendarThree();
myCalendarThree.book(10, 20); // return 1
myCalendarThree.book(50, 60); // return 1
myCalendarThree.book(10, 40); // return 2
myCalendarThree.book(5, 15); // return 3
myCalendarThree.book(5, 10); // return 3
myCalendarThree.book(25, 55); // return 3

</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= startTime &lt; endTime &lt;= 10<sup>9</sup></code></li>
	<li>At most <code>400</code> calls will be made to <code>book</code>.</li>
</ul>

## Solutions

### Solution 1: Segment Tree

> **Thinking**
>
> After each booking we must report the current maximum overlap; at most $400$ calls. A difference scan works but still walks every key.
>
> This is the same range-add / range-max problem as Calendar II, without the cap at $2$. A dynamic segment tree updates the interval and queries the whole line.
>
> Nodes store the max and a lazy add. $O(\log n)$ per book.

A segment tree divides the entire interval into multiple non-contiguous subintervals, with the number of subintervals not exceeding $\log(\textit{width})$. To update the value of an element, we only need to update $\log(\textit{width})$ intervals, and these intervals are all contained within a larger interval that includes the element. When modifying intervals, we use **lazy propagation** to ensure efficiency.

- Each node of the segment tree represents an interval.
- The segment tree has a unique root node representing the entire range, such as $[1, N]$.
- Each leaf node of the segment tree represents a unit interval of length $1$, $[x, x]$.
- For each internal node $[l, r]$, its left child is $[l, \textit{mid}]$ and its right child is $[\textit{mid} + 1, r]$, where $\textit{mid} = \lfloor(l + r) / 2\rfloor$ (i.e., floor division).

For this problem, the segment tree nodes maintain the following information:

1. The maximum number of times the interval has been booked, $v$.
2. Lazy propagation marker, $\textit{add}$.

Since the time range is $10^9$, which is very large, we use dynamic node creation.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the number of bookings.

#### Java

```java
class Node {
    Node left;
    Node right;
    int l;
    int r;
    int mid;
    int v;
    int add;
    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
    }
}

class SegmentTree {
    private Node root = new Node(1, (int) 1e9 + 1);

    public SegmentTree() {
    }

    public void modify(int l, int r, int v) {
        modify(l, r, v, root);
    }

    public void modify(int l, int r, int v, Node node) {
        if (l > r) {
            return;
        }
        if (node.l >= l && node.r <= r) {
            node.v += v;
            node.add += v;
            return;
        }
        pushdown(node);
        if (l <= node.mid) {
            modify(l, r, v, node.left);
        }
        if (r > node.mid) {
            modify(l, r, v, node.right);
        }
        pushup(node);
    }

    public int query(int l, int r) {
        return query(l, r, root);
    }

    public int query(int l, int r, Node node) {
        if (l > r) {
            return 0;
        }
        if (node.l >= l && node.r <= r) {
            return node.v;
        }
        pushdown(node);
        int v = 0;
        if (l <= node.mid) {
            v = Math.max(v, query(l, r, node.left));
        }
        if (r > node.mid) {
            v = Math.max(v, query(l, r, node.right));
        }
        return v;
    }

    public void pushup(Node node) {
        node.v = Math.max(node.left.v, node.right.v);
    }

    public void pushdown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
        if (node.add != 0) {
            Node left = node.left, right = node.right;
            left.add += node.add;
            right.add += node.add;
            left.v += node.add;
            right.v += node.add;
            node.add = 0;
        }
    }
}

class MyCalendarThree {
    private SegmentTree tree = new SegmentTree();

    public MyCalendarThree() {
    }

    public int book(int start, int end) {
        tree.modify(start + 1, end, 1);
        return tree.query(1, (int) 1e9 + 1);
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
```
