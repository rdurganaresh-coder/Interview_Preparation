package com.leetcode.design_data_structures;

class MovingAverage0346_2 {
    private Deque<Integer> q = new ArrayDeque<>();
    private int n;
    private int s;

    public MovingAverage0346_2(int size) {
        n = size;
    }

    public double next(int val) {
        if (q.size() == n) {
            s -= q.pollFirst();
        }
        q.offer(val);
        s += val;
        return s * 1.0 / q.size();
    }
}

/**
 * Your MovingAverage0346_2 object will be instantiated and called as such:
 * MovingAverage0346_2 obj = new MovingAverage0346_2(size);
 * double param_1 = obj.next(val);
 */