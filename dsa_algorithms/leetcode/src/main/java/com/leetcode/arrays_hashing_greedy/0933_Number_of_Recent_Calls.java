package com.leetcode.arrays_hashing_greedy;

class RecentCounter0933 {
    private Deque<Integer> q = new ArrayDeque<>();

    public RecentCounter0933() {
    }

    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter0933 object will be instantiated and called as such:
 * RecentCounter0933 obj = new RecentCounter0933();
 * int param_1 = obj.ping(t);
 */
