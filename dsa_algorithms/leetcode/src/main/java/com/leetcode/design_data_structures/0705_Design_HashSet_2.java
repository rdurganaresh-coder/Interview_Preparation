package com.leetcode.design_data_structures;

class MyHashSet0705_2 {
    private static final int SIZE = 1000;
    private LinkedList[] data;

    public MyHashSet0705_2() {
        data = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        int idx = hash(key);
        data[idx].addFirst(key);
    }

    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        int idx = hash(key);
        data[idx].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int idx = hash(key);
        Iterator<Integer> it = data[idx].iterator();
        while (it.hasNext()) {
            Integer e = it.next();
            if (e == key) {
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key % SIZE;
    }
}

/**
 * Your MyHashSet0705_2 object will be instantiated and called as such:
 * MyHashSet0705_2 obj = new MyHashSet0705_2();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */