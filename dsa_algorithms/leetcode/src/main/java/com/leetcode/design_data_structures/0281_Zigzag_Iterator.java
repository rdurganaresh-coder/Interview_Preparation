package com.leetcode.design_data_structures;

class ZigzagIterator0281 {
    private int cur;
    private int size;
    private List<Integer> indexes = new ArrayList<>();
    private List<List<Integer>> vectors = new ArrayList<>();

    public ZigzagIterator0281(List<Integer> v1, List<Integer> v2) {
        cur = 0;
        size = 2;
        indexes.add(0);
        indexes.add(0);
        vectors.add(v1);
        vectors.add(v2);
    }

    public int next() {
        List<Integer> vector = vectors.get(cur);
        int index = indexes.get(cur);
        int res = vector.get(index);
        indexes.set(cur, index + 1);
        cur = (cur + 1) % size;
        return res;
    }

    public boolean hasNext() {
        int start = cur;
        while (indexes.get(cur) == vectors.get(cur).size()) {
            cur = (cur + 1) % size;
            if (start == cur) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your ZigzagIterator0281 object will be instantiated and called as such:
 * ZigzagIterator0281 i = new ZigzagIterator0281(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */