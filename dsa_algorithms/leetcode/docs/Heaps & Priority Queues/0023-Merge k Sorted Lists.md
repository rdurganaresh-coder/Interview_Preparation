# 23. Merge k Sorted Lists

**Difficulty:** Hard  
**Category:** Heaps & Priority Queues  
**LeetCode:** https://leetcode.com/problems/merge-k-sorted-lists/

---

[中文文档](/solution/0000-0099/0023.Merge%20k%20Sorted%20Lists/README.md)

## Description

<p>You are given an array of <code>k</code> linked-lists <code>lists</code>, each linked-list is sorted in ascending order.</p>

<p><em>Merge all the linked-lists into one sorted linked-list and return it.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> lists = [[1,4,5],[1,3,4],[2,6]]
<strong>Output:</strong> [1,1,2,3,4,4,5,6]
<strong>Explanation:</strong> The linked-lists are:
[
  1-&gt;4-&gt;5,
  1-&gt;3-&gt;4,
  2-&gt;6
]
merging them into one sorted linked list:
1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> lists = []
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> lists = [[]]
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>k == lists.length</code></li>
	<li><code>0 &lt;= k &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= lists[i].length &lt;= 500</code></li>
	<li><code>-10<sup>4</sup> &lt;= lists[i][j] &lt;= 10<sup>4</sup></code></li>
	<li><code>lists[i]</code> is sorted in <strong>ascending order</strong>.</li>
	<li>The sum of <code>lists[i].length</code> will not exceed <code>10<sup>4</sup></code>.</li>
</ul>

## Solutions

### Solution 1: Priority Queue (Min Heap)

> **Thinking**
>
> The first idea is pairwise merge: merge list $1$ with $2$, then fold in $3$, and so on. With $N \le 10^4$ nodes and $k \le 10^4$ lists, the worst case is $O(N \times k)$ and can time out. Dumping every node into an array and sorting also works, but ignores that each list is already sorted.
>
> The bottleneck is finding the smallest among $k$ heads at every step. A linear scan is $O(k)$ per node and does not fit.
>
> At any moment the next node is just the minimum of the current heads. A min-heap of those $k$ heads pops the smallest and pushes its successor.
>
> Each node enters and leaves the heap once, so the time is $O(N \log k)$ and the heap holds at most $k$ pointers.

We can create a min heap $pq$ to maintain the head nodes of all linked lists. Each time, we take out the node with the smallest value from the min heap, add it to the end of the result linked list, and then add the next node of this node to the heap. Repeat the above steps until the heap is empty.

The time complexity is $O(n \log k)$, and the space complexity is $O(k)$, where $n$ is the total number of all linked list nodes, and $k$ is the number of linked lists given in the problem.

#### Java

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
```
