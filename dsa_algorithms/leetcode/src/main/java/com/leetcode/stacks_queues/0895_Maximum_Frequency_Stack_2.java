package com.leetcode.stacks_queues;

class FreqStack0895_2 {
    private Map<Integer, Integer> cnt = new HashMap<>();
    private Map<Integer, Deque<Integer>> d = new HashMap<>();
    private int mx;

    public FreqStack0895_2() {
    }

    public void push(int val) {
        cnt.put(val, cnt.getOrDefault(val, 0) + 1);
        int t = cnt.get(val);
        d.computeIfAbsent(t, k -> new ArrayDeque<>()).push(val);
        mx = Math.max(mx, t);
    }

    public int pop() {
        int val = d.get(mx).pop();
        cnt.put(val, cnt.get(val) - 1);
        if (d.get(mx).isEmpty()) {
            --mx;
        }
        return val;
    }
}

/**
 * Your FreqStack0895_2 object will be instantiated and called as such:
 * FreqStack0895_2 obj = new FreqStack0895_2();
 * obj.push(val);
 * int param_2 = obj.pop();
 */