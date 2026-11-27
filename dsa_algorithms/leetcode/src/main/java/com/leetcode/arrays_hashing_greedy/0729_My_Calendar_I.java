package com.leetcode.arrays_hashing_greedy;

class MyCalendar0729 {
    private final TreeMap<Integer, Integer> tm = new TreeMap<>();

    public MyCalendar0729() {
    }

    public boolean book(int startTime, int endTime) {
        var e = tm.ceilingEntry(startTime + 1);
        if (e != null && e.getValue() < endTime) {
            return false;
        }
        tm.put(endTime, startTime);
        return true;
    }
}

/**
 * Your MyCalendar0729 object will be instantiated and called as such:
 * MyCalendar0729 obj = new MyCalendar0729();
 * boolean param_1 = obj.book(startTime,endTime);
 */
