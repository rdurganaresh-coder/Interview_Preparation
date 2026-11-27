package com.leetcode.design_data_structures;

class ATM2241 {
    private int[] d = {20, 50, 100, 200, 500};
    private int m = d.length;
    private long[] cnt = new long[5];

    public ATM2241() {
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; ++i) {
            cnt[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] ans = new int[m];
        for (int i = m - 1; i >= 0; --i) {
            ans[i] = (int) Math.min(amount / d[i], cnt[i]);
            amount -= ans[i] * d[i];
        }
        if (amount > 0) {
            return new int[] {-1};
        }
        for (int i = 0; i < m; ++i) {
            cnt[i] -= ans[i];
        }
        return ans;
    }
}

/**
 * Your ATM2241 object will be instantiated and called as such:
 * ATM2241 obj = new ATM2241();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
