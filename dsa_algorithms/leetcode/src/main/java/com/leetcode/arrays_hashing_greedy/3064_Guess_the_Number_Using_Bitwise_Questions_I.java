package com.leetcode.arrays_hashing_greedy;

/**
 * Definition of commonSetBits API (defined in the parent class Problem).
 * int commonSetBits(int num);
 */

class Solution3064 extends Problem {
    public int findNumber() {
        int n = 0;
        for (int i = 0; i < 32; ++i) {
            if (commonSetBits(1 << i) > 0) {
                n |= 1 << i;
            }
        }
        return n;
    }
}