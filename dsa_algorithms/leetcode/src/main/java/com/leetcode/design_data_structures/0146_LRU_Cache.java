package com.leetcode.design_data_structures;

class Node0146 {
    int key, val;
    Node0146 prev, next;

    Node0146() {
    }

    Node0146(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache0146 {
    private int size;
    private int capacity;
    private Node0146 head = new Node0146();
    private Node0146 tail = new Node0146();
    private Map<Integer, Node0146> cache = new HashMap<>();

    public LRUCache0146(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node0146 node = cache.get(key);
        removeNode(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node0146 node = cache.get(key);
            removeNode(node);
            node.val = value;
            addToHead(node);
        } else {
            Node0146 node = new Node0146(key, value);
            cache.put(key, node);
            addToHead(node);
            if (++size > capacity) {
                node = tail.prev;
                cache.remove(node.key);
                removeNode(node);
                --size;
            }
        }
    }

    private void removeNode(Node0146 node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node0146 node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
}

/**
 * Your LRUCache0146 object will be instantiated and called as such:
 * LRUCache0146 obj = new LRUCache0146(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
