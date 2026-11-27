package com.leetcode.design_data_structures;

class RLEIterator0900 {
    private int[] encoding;
    private int i;
    private int j;

    public RLEIterator0900(int[] encoding) {
        this.encoding = encoding;
    }

    public int next(int n) {
        while (i < encoding.length) {
            if (encoding[i] - j < n) {
                n -= (encoding[i] - j);
                i += 2;
                j = 0;
            } else {
                j += n;
                return encoding[i + 1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator0900 object will be instantiated and called as such:
 * RLEIterator0900 obj = new RLEIterator0900(encoding);
 * int param_1 = obj.next(n);
 */