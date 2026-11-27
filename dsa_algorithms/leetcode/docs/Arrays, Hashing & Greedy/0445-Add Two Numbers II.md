# 445. Add Two Numbers II

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/add-two-numbers-ii/

---

[中文文档](/solution/0400-0499/0445.Add%20Two%20Numbers%20II/README.md)

## Description

<p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.</p>

<p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0400-0499/0445.Add%20Two%20Numbers%20II/images/sumii-linked-list.jpg" style="width: 523px; height: 342px;" />
<pre>
<strong>Input:</strong> l1 = [7,2,4,3], l2 = [5,6,4]
<strong>Output:</strong> [7,8,0,7]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
<strong>Output:</strong> [8,0,7]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> l1 = [0], l2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
	<li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Could you solve it without reversing the input lists?</p>

## Solutions

### Solution 1

> **Thinking**
>
> The lists store the high digit first, so we cannot add from the heads as in Add Two Numbers. Reversing twice more is pointer-heavy.
>
> Push both lists onto stacks, pop the low digits, add with carry, and insert each new node at the front of the answer. A leftover carry becomes one more head insert.
>
> The stacks make the low end come out first; head insertion restores high-digit-first order without reversing the lists.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        for (; l1 != null; l1 = l1.next) {
            s1.push(l1.val);
        }
        for (; l2 != null; l2 = l2.next) {
            s2.push(l2.val);
        }
        ListNode dummy = new ListNode();
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int s = (s1.isEmpty() ? 0 : s1.pop()) + (s2.isEmpty() ? 0 : s2.pop()) + carry;
            // ListNode node = new ListNode(s % 10, dummy.next);
            // dummy.next = node;
            dummy.next = new ListNode(s % 10, dummy.next);
            carry = s / 10;
        }
        return dummy.next;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 already adds via two stacks. Solution 2 is the same skeleton: pop, add, insert at the dummy head, until both stacks and the carry are gone.
