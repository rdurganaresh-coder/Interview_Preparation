package com.leetcode.arrays_hashing_greedy;

class AllOne0432 {
    Node0432 root = new Node0432();
    Map<String, Node0432> nodes = new HashMap<>();

    public AllOne0432() {
        root.next = root;
        root.prev = root;
    }

    public void inc(String key) {
        if (!nodes.containsKey(key)) {
            if (root.next == root || root.next.cnt > 1) {
                nodes.put(key, root.insert(new Node0432(key, 1)));
            } else {
                root.next.keys.add(key);
                nodes.put(key, root.next);
            }
        } else {
            Node0432 curr = nodes.get(key);
            Node0432 next = curr.next;
            if (next == root || next.cnt > curr.cnt + 1) {
                nodes.put(key, curr.insert(new Node0432(key, curr.cnt + 1)));
            } else {
                next.keys.add(key);
                nodes.put(key, next);
            }
            curr.keys.remove(key);
            if (curr.keys.isEmpty()) {
                curr.remove();
            }
        }
    }

    public void dec(String key) {
        Node0432 curr = nodes.get(key);
        if (curr.cnt == 1) {
            nodes.remove(key);
        } else {
            Node0432 prev = curr.prev;
            if (prev == root || prev.cnt < curr.cnt - 1) {
                nodes.put(key, prev.insert(new Node0432(key, curr.cnt - 1)));
            } else {
                prev.keys.add(key);
                nodes.put(key, prev);
            }
        }

        curr.keys.remove(key);
        if (curr.keys.isEmpty()) {
            curr.remove();
        }
    }

    public String getMaxKey() {
        return root.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return root.next.keys.iterator().next();
    }
}

class Node0432 {
    Node0432 prev;
    Node0432 next;
    int cnt;
    Set<String> keys = new HashSet<>();

    public Node0432() {
        this("", 0);
    }

    public Node0432(String key, int cnt) {
        this.cnt = cnt;
        keys.add(key);
    }

    public Node0432 insert(Node0432 node) {
        node.prev = this;
        node.next = this.next;
        node.prev.next = node;
        node.next.prev = node;
        return node;
    }

    public void remove() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}

/**
 * Your AllOne0432 object will be instantiated and called as such:
 * AllOne0432 obj = new AllOne0432();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */