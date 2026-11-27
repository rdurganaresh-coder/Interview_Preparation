# 3217. Delete Nodes From Linked List Present in Array

**Difficulty:** Medium  
**Category:** Linked Lists  
**LeetCode:** https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/

---

[中文文档](/solution/3200-3299/3217.Delete%20Nodes%20From%20Linked%20List%20Present%20in%20Array/README.md)

## Description

<p>You are given an array of integers <code>nums</code> and the <code>head</code> of a linked list. Return the <code>head</code> of the modified linked list after <strong>removing</strong> all nodes from the linked list that have a value that exists in <code>nums</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3], head = [1,2,3,4,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,5]</span></p>

<p><strong>Explanation:</strong></p>

<p><strong><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3200-3299/3217.Delete%20Nodes%20From%20Linked%20List%20Present%20in%20Array/images/linkedlistexample0.png" style="width: 400px; height: 66px;" /></strong></p>

<p>Remove the nodes with values 1, 2, and 3.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1], head = [1,2,1,2,1,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">[2,2,2]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3200-3299/3217.Delete%20Nodes%20From%20Linked%20List%20Present%20in%20Array/images/linkedlistexample1.png" style="height: 62px; width: 450px;" /></p>

<p>Remove the nodes with value 1.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [5], head = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,2,3,4]</span></p>

<p><strong>Explanation:</strong></p>

<p><strong><img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3200-3299/3217.Delete%20Nodes%20From%20Linked%20List%20Present%20in%20Array/images/linkedlistexample2.png" style="width: 400px; height: 83px;" /></strong></p>

<p>No node has value 5.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li>All elements in <code>nums</code> are unique.</li>
	<li>The number of nodes in the given list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
	<li>The input is generated such that there is at least one node in the linked list that has a value not present in <code>nums</code>.</li>
</ul>

## Solutions

### Solution 1: Hash Table

> **Thinking**
>
> We must delete list nodes whose values appear in $\textit{nums}$. With $n,m\le 10^5$, scanning the array at every node is quadratic.
>
> Put $\textit{nums}$ in a hash set for expected $O(1)$ tests. A dummy points at $\textit{head}$; if the successor's value is in the set, skip it, otherwise advance. One pass also covers a deleted head.

We can use a hash table $s$ to store all the elements in the array $\textit{nums}$. Then, we define a dummy node $\textit{dummy}$ and point it to the head node of the list $\textit{head}$.

Next, we traverse the list starting from the dummy node $\textit{dummy}$. If the value of the next node of the current node is in the hash table $s$, we make the current node point to the next next node; otherwise, we move the current node pointer to the next node.

Finally, we return the next node of the dummy node $\textit{dummy}$.

The time complexity is $O(n + m)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$, and $m$ is the length of the list $\textit{head}$.

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        ListNode dummy = new ListNode(0, head);
        for (ListNode pre = dummy; pre.next != null;) {
            if (s.contains(pre.next.val)) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
```
