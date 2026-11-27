# 19. Remove Nth Node From End of List

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/remove-nth-node-from-end-of-list/

---

[中文文档](/solution/0000-0099/0019.Remove%20Nth%20Node%20From%20End%20of%20List/README.md)

## Description

<p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0019.Remove%20Nth%20Node%20From%20End%20of%20List/images/remove_ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], n = 2
<strong>Output:</strong> [1,2,3,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = [1], n = 1
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = [1,2], n = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>sz</code>.</li>
	<li><code>1 &lt;= sz &lt;= 30</code></li>
	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
	<li><code>1 &lt;= n &lt;= sz</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do this in one pass?</p>

## Solutions

### Solution 1: Fast and Slow Pointers

> **Thinking**
>
> The first idea is to count the length $L$, then walk $L-n$ steps and delete. $sz\le 30$ would pass, but the follow-up asks for one pass.
>
> Until we reach the end we do not know where the $n$-th node from the end is, and deletion still needs its predecessor. Give the fast pointer a head start of $n$ steps, then move both; when fast hits the tail, slow sits on the predecessor. A dummy node makes deleting the head the same as deleting a middle node.
>
> So one walk with fast and slow locates and removes the node.

We define two pointers `fast` and `slow`, both initially pointing to the dummy head node of the linked list.

Next, the `fast` pointer moves forward $n$ steps first, then `fast` and `slow` pointers move forward together until the `fast` pointer reaches the end of the linked list. At this point, the node pointed to by `slow.next` is the predecessor of the $n$-th node from the end, and we can delete it.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the linked list.

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
```
