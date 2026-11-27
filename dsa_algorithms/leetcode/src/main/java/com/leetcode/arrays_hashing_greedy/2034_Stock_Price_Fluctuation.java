package com.leetcode.arrays_hashing_greedy;

class StockPrice2034 {
    private Map<Integer, Integer> d = new HashMap<>();
    private TreeMap<Integer, Integer> ls = new TreeMap<>();
    private int last;

    public StockPrice2034() {
    }

    public void update(int timestamp, int price) {
        if (d.containsKey(timestamp)) {
            int old = d.get(timestamp);
            if (ls.merge(old, -1, Integer::sum) == 0) {
                ls.remove(old);
            }
        }
        d.put(timestamp, price);
        ls.merge(price, 1, Integer::sum);
        last = Math.max(last, timestamp);
    }

    public int current() {
        return d.get(last);
    }

    public int maximum() {
        return ls.lastKey();
    }

    public int minimum() {
        return ls.firstKey();
    }
}

/**
 * Your StockPrice2034 object will be instantiated and called as such:
 * StockPrice2034 obj = new StockPrice2034();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */