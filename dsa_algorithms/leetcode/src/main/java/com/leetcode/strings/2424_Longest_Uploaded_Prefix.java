package com.leetcode.strings;

class LUPrefix2424 {
    private int r;
    private Set<Integer> s = new HashSet<>();

    public LUPrefix2424(int n) {
    }

    public void upload(int video) {
        s.add(video);
        while (s.contains(r + 1)) {
            ++r;
        }
    }

    public int longest() {
        return r;
    }
}

/**
 * Your LUPrefix2424 object will be instantiated and called as such:
 * LUPrefix2424 obj = new LUPrefix2424(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */