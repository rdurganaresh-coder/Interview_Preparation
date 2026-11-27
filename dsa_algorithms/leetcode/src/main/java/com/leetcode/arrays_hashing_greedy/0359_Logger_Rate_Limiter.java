package com.leetcode.arrays_hashing_greedy;

class Logger0359 {
    private Map<String, Integer> ts = new HashMap<>();

    public Logger0359() {
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int t = ts.getOrDefault(message, 0);
        if (timestamp < t) {
            return false;
        }
        ts.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger0359 object will be instantiated and called as such:
 * Logger0359 obj = new Logger0359();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
