package com.leetcode.stacks_queues;

class CustomStack1381 {
    private int[] stk;
    private int[] add;
    private int i;

    public CustomStack1381(int maxSize) {
        stk = new int[maxSize];
        add = new int[maxSize];
    }

    public void push(int x) {
        if (i < stk.length) {
            stk[i++] = x;
        }
    }

    public int pop() {
        if (i <= 0) {
            return -1;
        }
        int ans = stk[--i] + add[i];
        if (i > 0) {
            add[i - 1] += add[i];
        }
        add[i] = 0;
        return ans;
    }

    public void increment(int k, int val) {
        if (i > 0) {
            add[Math.min(i, k) - 1] += val;
        }
    }
}

/**
 * Your CustomStack1381 object will be instantiated and called as such:
 * CustomStack1381 obj = new CustomStack1381(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */