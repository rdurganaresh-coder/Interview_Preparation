# 206. Reverse Linked List

**Difficulty:** Easy  
**Category:** Linked Lists  
**LeetCode:** https://leetcode.com/problems/reverse-linked-list/

---

[中文文档](/solution/0200-0299/0206.Reverse%20Linked%20List/README.md)

## Description

<p>Given the <code>head</code> of a singly linked list, reverse the list, and return <em>the reversed list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0200-0299/0206.Reverse%20Linked%20List/images/rev1ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [5,4,3,2,1]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0200-0299/0206.Reverse%20Linked%20List/images/rev1ex2.jpg" style="width: 182px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2]
<strong>Output:</strong> [2,1]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is the range <code>[0, 5000]</code>.</li>
	<li><code>-5000 &lt;= Node.val &lt;= 5000</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> A linked list can be reversed either iteratively or recursively. Could you implement both?</p>

## Solutions

### Solution 1: Head Insertion Method

> **Thinking**
>
> Storing nodes in an array and rebuilding backwards works, but only pointer rewrites are needed. Head insertion reverses the list in one pass: each node is inserted immediately after a dummy.
>
> When the scan ends, $\textit{dummy}.\textit{next}$ is the new head and extra space is constant.

We create a dummy node $\textit{dummy}$, then traverse the linked list and insert each node after the $\textit{dummy}$ node. After traversal, return $\textit{dummy}.\textit{next}$.

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
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}
```

### Solution 2: Recursion

> **Thinking**
>
> Head insertion is already linear. We can instead reverse the suffix recursively, then attach the current node behind the new tail.
>
> The pointer updates are shorter, at the cost of $O(n)$ call-stack space.

We recursively reverse all nodes from the second node to the end of the list, then attach the $\textit{head}$ to the end of the reversed list.

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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ans;
    }
}
```
