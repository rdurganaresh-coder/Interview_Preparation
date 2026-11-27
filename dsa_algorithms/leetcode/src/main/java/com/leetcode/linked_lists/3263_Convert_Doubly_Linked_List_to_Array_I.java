package com.leetcode.linked_lists;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution3263 {
    public int[] toArray(Node head) {
        List<Integer> ans = new ArrayList<>();
        for (; head != null; head = head.next) {
            ans.add(head.val);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
