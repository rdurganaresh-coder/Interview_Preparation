package com.leetcode.arrays_hashing_greedy;

class MyCalendarTwo0731 {
    private final Map<Integer, Integer> tm = new TreeMap<>();

    public MyCalendarTwo0731() {
    }

    public boolean book(int startTime, int endTime) {
        tm.merge(startTime, 1, Integer::sum);
        tm.merge(endTime, -1, Integer::sum);
        int s = 0;
        for (int v : tm.values()) {
            s += v;
            if (s > 2) {
                tm.merge(startTime, -1, Integer::sum);
                tm.merge(endTime, 1, Integer::sum);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo0731 object will be instantiated and called as such:
 * MyCalendarTwo0731 obj = new MyCalendarTwo0731();
 * boolean param_1 = obj.book(startTime,endTime);
 */
