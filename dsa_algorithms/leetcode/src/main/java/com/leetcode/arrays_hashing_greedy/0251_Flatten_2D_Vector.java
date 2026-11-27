package com.leetcode.arrays_hashing_greedy;

class Vector2D0251 {
    private int i;
    private int j;
    private int[][] vec;

    public Vector2D0251(int[][] vec) {
        this.vec = vec;
    }

    public int next() {
        forward();
        return vec[i][j++];
    }

    public boolean hasNext() {
        forward();
        return i < vec.length;
    }

    private void forward() {
        while (i < vec.length && j >= vec[i].length) {
            ++i;
            j = 0;
        }
    }
}

/**
 * Your Vector2D0251 object will be instantiated and called as such:
 * Vector2D0251 obj = new Vector2D0251(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */