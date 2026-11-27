# 2816. Double a Number Represented as a Linked List

**Difficulty:** Medium  
**Category:** Linked Lists  
**LeetCode:** https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/

---

[中文文档](/solution/2800-2899/2816.Double%20a%20Number%20Represented%20as%20a%20Linked%20List/README.md)

## Description

<p>You are given the <code>head</code> of a <strong>non-empty</strong> linked list representing a non-negative integer without leading zeroes.</p>

<p>Return <em>the </em><code>head</code><em> of the linked list after <strong>doubling</strong> it</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2800-2899/2816.Double%20a%20Number%20Represented%20as%20a%20Linked%20List/images/example.png" style="width: 401px; height: 81px;" />
<pre>
<strong>Input:</strong> head = [1,8,9]
<strong>Output:</strong> [3,7,8]
<strong>Explanation:</strong> The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2800-2899/2816.Double%20a%20Number%20Represented%20as%20a%20Linked%20List/images/example2.png" style="width: 401px; height: 81px;" />
<pre>
<strong>Input:</strong> head = [9,9,9]
<strong>Output:</strong> [1,9,9,8]
<strong>Explanation:</strong> The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 10<sup>4</sup>]</code></li>
	<li><font face="monospace"><code>0 &lt;= Node.val &lt;= 9</code></font></li>
	<li>The input is generated such that the list represents a number that does not have leading zeros, except the number <code>0</code> itself.</li>
</ul>

## Solutions

### Solution 1: Reverse Linked List + Simulation

> **Thinking**
>
> The list stores digits from high to low, so doubling left to right makes carries awkward. Reverse the list, simulate multiplication by two with a carry, then reverse again.

First, we reverse the linked list, then simulate the multiplication operation, and finally reverse the linked list back.

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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int mul = 2, carry = 0;
        while (head != null) {
            int x = head.val * mul + carry;
            carry = x / 10;
            cur.next = new ListNode(x % 10);
            cur = cur.next;
            head = head.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
```
