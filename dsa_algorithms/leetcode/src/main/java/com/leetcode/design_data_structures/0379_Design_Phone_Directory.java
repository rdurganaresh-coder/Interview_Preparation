package com.leetcode.design_data_structures;

class PhoneDirectory0379 {
    private Set<Integer> available = new HashSet<>();

    public PhoneDirectory0379(int maxNumbers) {
        for (int i = 0; i < maxNumbers; ++i) {
            available.add(i);
        }
    }

    public int get() {
        if (available.isEmpty()) {
            return -1;
        }
        int x = available.iterator().next();
        available.remove(x);
        return x;
    }

    public boolean check(int number) {
        return available.contains(number);
    }

    public void release(int number) {
        available.add(number);
    }
}

/**
 * Your PhoneDirectory0379 object will be instantiated and called as such:
 * PhoneDirectory0379 obj = new PhoneDirectory0379(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */