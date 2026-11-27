package com.leetcode.design_data_structures;

class MyHashMap0706 {
    private int[] data = new int[1000001];

    public MyHashMap0706() {
        Arrays.fill(data, -1);
    }

    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }
}

/**
 * Your MyHashMap0706 object will be instantiated and called as such:
 * MyHashMap0706 obj = new MyHashMap0706();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */