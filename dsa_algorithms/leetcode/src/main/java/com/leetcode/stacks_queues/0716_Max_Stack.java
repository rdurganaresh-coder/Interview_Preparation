package com.leetcode.stacks_queues;

class Node0716 {
    public int val;
    public Node0716 prev, next;

    public Node0716() {
    }

    public Node0716(int val) {
        this.val = val;
    }
}

class DoubleLinkedList0716 {
    private final Node0716 head = new Node0716();
    private final Node0716 tail = new Node0716();

    public DoubleLinkedList0716() {
        head.next = tail;
        tail.prev = head;
    }

    public Node0716 append(int val) {
        Node0716 node = new Node0716(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        return node;
    }

    public static Node0716 remove(Node0716 node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public Node0716 pop() {
        return remove(tail.prev);
    }

    public int peek() {
        return tail.prev.val;
    }
}

class MaxStack0716 {
    private DoubleLinkedList0716 stk = new DoubleLinkedList0716();
    private TreeMap<Integer, List<Node0716>> tm = new TreeMap<>();

    public MaxStack0716() {
    }

    public void push(int x) {
        Node0716 node = stk.append(x);
        tm.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
    }

    public int pop() {
        Node0716 node = stk.pop();
        List<Node0716> nodes = tm.get(node.val);
        int x = nodes.remove(nodes.size() - 1).val;
        if (nodes.isEmpty()) {
            tm.remove(node.val);
        }
        return x;
    }

    public int top() {
        return stk.peek();
    }

    public int peekMax() {
        return tm.lastKey();
    }

    public int popMax() {
        int x = peekMax();
        List<Node0716> nodes = tm.get(x);
        Node0716 node = nodes.remove(nodes.size() - 1);
        if (nodes.isEmpty()) {
            tm.remove(x);
        }
        DoubleLinkedList0716.remove(node);
        return x;
    }
}

/**
 * Your MaxStack0716 object will be instantiated and called as such:
 * MaxStack0716 obj = new MaxStack0716();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */