package com.leetcode.arrays_hashing_greedy;

class TimeMap0981 {
    private Map<String, TreeMap<Integer, String>> ktv = new HashMap<>();

    public TimeMap0981() {
    }

    public void set(String key, String value, int timestamp) {
        ktv.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!ktv.containsKey(key)) {
            return "";
        }
        var tv = ktv.get(key);
        Integer t = tv.floorKey(timestamp);
        return t == null ? "" : tv.get(t);
    }
}

/**
 * Your TimeMap0981 object will be instantiated and called as such:
 * TimeMap0981 obj = new TimeMap0981();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */