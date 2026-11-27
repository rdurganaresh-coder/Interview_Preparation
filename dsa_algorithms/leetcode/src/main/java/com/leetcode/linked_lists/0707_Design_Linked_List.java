package com.leetcode.linked_lists;

class MyLinkedList0707 {
    private ListNode dummy = new ListNode();
    private int cnt;

    public MyLinkedList0707() {
    }

    public int get(int index) {
        if (index < 0 || index >= cnt) {
            return -1;
        }
        var cur = dummy.next;
        while (index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(cnt, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > cnt) {
            return;
        }
        var pre = dummy;
        while (index-- > 0) {
            pre = pre.next;
        }
        pre.next = new ListNode(val, pre.next);
        ++cnt;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= cnt) {
            return;
        }
        var pre = dummy;
        while (index-- > 0) {
            pre = pre.next;
        }
        var t = pre.next;
        pre.next = t.next;
        t.next = null;
        --cnt;
    }
}

/**
 * Your MyLinkedList0707 object will be instantiated and called as such:
 * MyLinkedList0707 obj = new MyLinkedList0707();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */