package com.leetcode.design_data_structures;

class MyHashSet0705 {
    private boolean[] data = new boolean[1000001];

    public MyHashSet0705() {
    }

    public void add(int key) {
        data[key] = true;
    }

    public void remove(int key) {
        data[key] = false;
    }

    public boolean contains(int key) {
        return data[key];
    }
}

/**
 * Your MyHashSet0705 object will be instantiated and called as such:
 * MyHashSet0705 obj = new MyHashSet0705();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */