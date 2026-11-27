package com.leetcode.sliding_window_two_pointers;

class DataStream2526 {
    private int cnt;
    private int val;
    private int k;

    public DataStream2526(int value, int k) {
        val = value;
        this.k = k;
    }

    public boolean consec(int num) {
        cnt = num == val ? cnt + 1 : 0;
        return cnt >= k;
    }
}

/**
 * Your DataStream2526 object will be instantiated and called as such:
 * DataStream2526 obj = new DataStream2526(value, k);
 * boolean param_1 = obj.consec(num);
 */