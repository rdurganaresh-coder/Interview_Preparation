# 2487. Remove Nodes From Linked List

**Difficulty:** Medium  
**Category:** Linked Lists  
**LeetCode:** https://leetcode.com/problems/remove-nodes-from-linked-list/

---

[中文文档](/solution/2400-2499/2487.Remove%20Nodes%20From%20Linked%20List/README.md)

## Description

<p>You are given the <code>head</code> of a linked list.</p>

<p>Remove every node which has a node with a greater value anywhere to the right side of it.</p>

<p>Return <em>the </em><code>head</code><em> of the modified linked list.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2400-2499/2487.Remove%20Nodes%20From%20Linked%20List/images/drawio.png" style="width: 631px; height: 51px;" />
<pre>
<strong>Input:</strong> head = [5,2,13,3,8]
<strong>Output:</strong> [13,8]
<strong>Explanation:</strong> The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = [1,1,1,1]
<strong>Output:</strong> [1,1,1,1]
<strong>Explanation:</strong> Every node has value 1, so no nodes are removed.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of the nodes in the given list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Monotonic Stack (Array)

> **Thinking**
>
> Delete a node if a strictly larger value exists to its right: keep the decreasing right-to-left suffix. At $n\le 10^5$, copy values, maintain a decreasing stack, then rebuild the list.

Store the node values in an array $\textit{nums}$, then scan $\textit{nums}$ with a monotonically decreasing stack. Pop while the current value is larger than the top, then push. Rebuild the list from the bottom of the stack.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the linked list.

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
    public ListNode removeNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        Deque<Integer> stk = new ArrayDeque<>();
        for (int v : nums) {
            while (!stk.isEmpty() && stk.peekLast() < v) {
                stk.pollLast();
            }
            stk.offerLast(v);
        }
        ListNode dummy = new ListNode();
        head = dummy;
        while (!stk.isEmpty()) {
            head.next = new ListNode(stk.pollFirst());
            head = head.next;
        }
        return dummy.next;
    }
}
```

### Solution 2: Monotonic Stack (In-place List)

> **Thinking**
>
> Method 1 allocates a value array and new nodes. The same stack can hold list nodes: pop while the top is smaller, then link the new top to the current node. A dummy of $+\infty$ avoids an empty stack.

Traverse the list directly with a monotonically decreasing stack of nodes. When the current value is larger, pop; then link the new top's $\textit{next}$ (or the dummy head) to the current node and push it. Return the dummy head's $\textit{next}$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the linked list.

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
    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(1 << 30, head);
        Deque<ListNode> stk = new ArrayDeque<>();
        stk.offerLast(dummy);
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (stk.peekLast().val < cur.val) {
                stk.pollLast();
            }
            stk.peekLast().next = cur;
            stk.offerLast(cur);
        }
        return dummy.next;
    }
}
```
