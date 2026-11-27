package com.leetcode.design_data_structures;

class FrequencyTracker2671 {
    private Map<Integer, Integer> cnt = new HashMap<>();
    private Map<Integer, Integer> freq = new HashMap<>();

    public FrequencyTracker2671() {
    }

    public void add(int number) {
        freq.merge(cnt.getOrDefault(number, 0), -1, Integer::sum);
        cnt.merge(number, 1, Integer::sum);
        freq.merge(cnt.get(number), 1, Integer::sum);
    }

    public void deleteOne(int number) {
        if (cnt.getOrDefault(number, 0) > 0) {
            freq.merge(cnt.get(number), -1, Integer::sum);
            cnt.merge(number, -1, Integer::sum);
            freq.merge(cnt.get(number), 1, Integer::sum);
        }
    }

    public boolean hasFrequency(int frequency) {
        return freq.getOrDefault(frequency, 0) > 0;
    }
}

/**
 * Your FrequencyTracker2671 object will be instantiated and called as such:
 * FrequencyTracker2671 obj = new FrequencyTracker2671();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */