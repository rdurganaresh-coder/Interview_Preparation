package com.leetcode.design_data_structures;

class HitCounter0362 {
    private List<Integer> ts = new ArrayList<>();

    public HitCounter0362() {
    }

    public void hit(int timestamp) {
        ts.add(timestamp);
    }

    public int getHits(int timestamp) {
        int l = search(timestamp - 300 + 1);
        return ts.size() - l;
    }

    private int search(int x) {
        int l = 0, r = ts.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (ts.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

/**
 * Your HitCounter0362 object will be instantiated and called as such:
 * HitCounter0362 obj = new HitCounter0362();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */