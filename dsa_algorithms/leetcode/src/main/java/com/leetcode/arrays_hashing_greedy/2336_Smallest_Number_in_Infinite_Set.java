package com.leetcode.arrays_hashing_greedy;

class SmallestInfiniteSet2336 {
    private TreeSet<Integer> s = new TreeSet<>();

    public SmallestInfiniteSet2336() {
        for (int i = 1; i <= 1000; ++i) {
            s.add(i);
        }
    }

    public int popSmallest() {
        return s.pollFirst();
    }

    public void addBack(int num) {
        s.add(num);
    }
}

/**
 * Your SmallestInfiniteSet2336 object will be instantiated and called as such:
 * SmallestInfiniteSet2336 obj = new SmallestInfiniteSet2336();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */