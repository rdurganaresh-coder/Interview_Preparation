package com.leetcode.linked_lists;

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
class Solution0382 {
    private ListNode head;
    private Random random = new Random();

    public Solution0382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int ans = 0, n = 0;
        for (ListNode node = head; node != null; node = node.next) {
            ++n;
            int x = 1 + random.nextInt(n);
            if (n == x) {
                ans = node.val;
            }
        }
        return ans;
    }
}

/**
 * Your Solution0382 object will be instantiated and called as such:
 * Solution0382 obj = new Solution0382(head);
 * int param_1 = obj.getRandom();
 */