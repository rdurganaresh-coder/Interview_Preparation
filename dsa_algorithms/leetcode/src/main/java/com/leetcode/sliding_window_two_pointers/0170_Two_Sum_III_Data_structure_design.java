package com.leetcode.sliding_window_two_pointers;

class TwoSum0170 {
    private Map<Integer, Integer> cnt = new HashMap<>();

    public TwoSum0170() {
    }

    public void add(int number) {
        cnt.merge(number, 1, Integer::sum);
    }

    public boolean find(int value) {
        for (var e : cnt.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            int y = value - x;
            if (cnt.containsKey(y) && (x != y || v > 1)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum0170 object will be instantiated and called as such:
 * TwoSum0170 obj = new TwoSum0170();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */