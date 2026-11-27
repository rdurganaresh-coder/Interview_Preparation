package com.leetcode.stacks_queues;

class FreqStack0895 {
    private Map<Integer, Integer> cnt = new HashMap<>();
    private PriorityQueue<int[]> q
        = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
    private int ts;

    public FreqStack0895() {
    }

    public void push(int val) {
        cnt.put(val, cnt.getOrDefault(val, 0) + 1);
        q.offer(new int[] {cnt.get(val), ++ts, val});
    }

    public int pop() {
        int val = q.poll()[2];
        cnt.put(val, cnt.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack0895 object will be instantiated and called as such:
 * FreqStack0895 obj = new FreqStack0895();
 * obj.push(val);
 * int param_2 = obj.pop();
 */