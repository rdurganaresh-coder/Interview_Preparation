package com.leetcode.design_data_structures;

class MovingAverage0346 {
    private int s;
    private int cnt;
    private int[] data;

    public MovingAverage0346(int size) {
        data = new int[size];
    }

    public double next(int val) {
        int i = cnt % data.length;
        s += val - data[i];
        data[i] = val;
        ++cnt;
        return s * 1.0 / Math.min(cnt, data.length);
    }
}

/**
 * Your MovingAverage0346 object will be instantiated and called as such:
 * MovingAverage0346 obj = new MovingAverage0346(size);
 * double param_1 = obj.next(val);
 */