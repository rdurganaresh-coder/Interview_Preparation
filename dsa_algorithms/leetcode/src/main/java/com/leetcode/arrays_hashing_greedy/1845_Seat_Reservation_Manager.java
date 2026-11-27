package com.leetcode.arrays_hashing_greedy;

class SeatManager1845 {
    private PriorityQueue<Integer> q = new PriorityQueue<>();

    public SeatManager1845(int n) {
        for (int i = 1; i <= n; ++i) {
            q.offer(i);
        }
    }

    public int reserve() {
        return q.poll();
    }

    public void unreserve(int seatNumber) {
        q.offer(seatNumber);
    }
}

/**
 * Your SeatManager1845 object will be instantiated and called as such:
 * SeatManager1845 obj = new SeatManager1845(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */