package com.leetcode.heaps_priority_queues;

class KthLargest0703 {
    private PriorityQueue<Integer> minQ;
    private int k;

    public KthLargest0703(int k, int[] nums) {
        this.k = k;
        minQ = new PriorityQueue<>(k);
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        minQ.offer(val);
        if (minQ.size() > k) {
            minQ.poll();
        }
        return minQ.peek();
    }
}

/**
 * Your KthLargest0703 object will be instantiated and called as such:
 * KthLargest0703 obj = new KthLargest0703(k, nums);
 * int param_1 = obj.add(val);
 */