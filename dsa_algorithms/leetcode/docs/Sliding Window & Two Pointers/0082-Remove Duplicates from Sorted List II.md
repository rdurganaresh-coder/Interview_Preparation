# 82. Remove Duplicates from Sorted List II

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

---

[中文文档](/solution/0000-0099/0082.Remove%20Duplicates%20from%20Sorted%20List%20II/README.md)

## Description

<p>You are given the <code>head</code> of a <strong>sorted</strong> linked list.</p>

<p>Delete all nodes that have <strong>duplicate</strong> numbers, leaving only <strong>distinct</strong> numbers from the original list.</p>

<p>Return the linked list <strong>sorted</strong> as well.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0082.Remove%20Duplicates%20from%20Sorted%20List%20II/images/linkedlist1.jpg" style="width: 500px; height: 142px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,3,4,4,5]
<strong>Output:</strong> [1,2,5]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0000-0099/0082.Remove%20Duplicates%20from%20Sorted%20List%20II/images/linkedlist2.jpg" style="width: 500px; height: 205px;" />
<pre>
<strong>Input:</strong> head = [1,1,1,2,3]
<strong>Output:</strong> [2,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li>
</ul>

## Solutions

### Solution 1: Single Pass

> **Thinking**
>
> The first idea is count frequencies, then rebuild a list of values that appear once. Correct, and $n \le 300$ is tiny, but that wastes “already sorted, so duplicates are adjacent” and uses extra $O(n)$ space.
>
> The bottleneck is not using adjacency. Equal values form a contiguous run; one pass decides whether the whole run stays.
>
> The head may be deleted, so we need a dummy. And when a run is dropped, the predecessor must not advance into it. Keep $\textit{pre}$ on the last kept node and slide $\textit{cur}$ over the current value: if $\textit{pre}.\textit{next}$ is still $\textit{cur}$, the run has length one and $\textit{pre}$ moves; otherwise skip the whole run.

First, we create a dummy head node $\textit{dummy}$, and set $\textit{dummy}.\textit{next} = \textit{head}$. Then we create a pointer $\textit{pre}$ pointing to $\textit{dummy}$, and a pointer $\textit{cur}$ pointing to $\textit{head}$, and start traversing the linked list.

When the node value pointed by $\textit{cur}$ is the same as the node value pointed by $\textit{cur}.\textit{next}$, we let $\textit{cur}$ keep moving forward until the node value pointed by $\textit{cur}$ is different from the node value pointed by $\textit{cur}.\textit{next}$. At this point, we check whether $\textit{pre}.\textit{next}$ is equal to $\textit{cur}$. If they are equal, it means there are no duplicate nodes between $\textit{pre}$ and $\textit{cur}$, so we move $\textit{pre}$ to the position of $\textit{cur}$; otherwise, it means there are duplicate nodes between $\textit{pre}$ and $\textit{cur}$, so we set $\textit{pre}.\textit{next}$ to $\textit{cur}.\textit{next}$. Then we continue to move $\textit{cur}$ forward. Continue the above operation until $\textit{cur}$ is null, and the traversal ends.

Finally, return $\textit{dummy}.\textit{next}$.

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = cur;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
```
