package com.leetcode.arrays_hashing_greedy;

class Solution2412 {
    public long minimumMoney(int[][] transactions) {
        long s = 0;
        for (var e : transactions) {
            s += Math.max(0, e[0] - e[1]);
        }
        long ans = 0;
        for (var e : transactions) {
            if (e[0] > e[1]) {
                ans = Math.max(ans, s + e[1]);
            } else {
                ans = Math.max(ans, s + e[0]);
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2412 _tcSol = new Solution2412();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "transactions = [[2,1],[5,0],[4,2]]");
        try {
            int[][] transactions = new int[][]{new int[]{2, 1}, new int[]{5, 0}, new int[]{4, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumMoney(transactions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "transactions = [[3,0],[0,3]]");
        try {
            int[][] transactions = new int[][]{new int[]{3, 0}, new int[]{0, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumMoney(transactions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}