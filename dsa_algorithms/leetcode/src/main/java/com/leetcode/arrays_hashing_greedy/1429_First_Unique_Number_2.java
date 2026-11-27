package com.leetcode.arrays_hashing_greedy;

class FirstUnique1429_2 {
    private Map<Integer, Integer> cnt = new HashMap<>();
    private Deque<Integer> q = new ArrayDeque<>();

    public FirstUnique1429_2(int[] nums) {
        for (int v : nums) {
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            q.offer(v);
        }
    }

    public int showFirstUnique() {
        while (!q.isEmpty() && cnt.get(q.peekFirst()) != 1) {
            q.poll();
        }
        return q.isEmpty() ? -1 : q.peekFirst();
    }

    public void add(int value) {
        cnt.put(value, cnt.getOrDefault(value, 0) + 1);
        q.offer(value);
    }
}

/**
 * Your FirstUnique1429_2 object will be instantiated and called as such:
 * FirstUnique1429_2 obj = new FirstUnique1429_2(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */