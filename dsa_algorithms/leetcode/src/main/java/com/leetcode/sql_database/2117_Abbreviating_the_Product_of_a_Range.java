package com.leetcode.sql_database;

class Solution2117 {

    public String abbreviateProduct(int left, int right) {
        int cnt2 = 0, cnt5 = 0;
        for (int i = left; i <= right; ++i) {
            int x = i;
            for (; x % 2 == 0; x /= 2) {
                ++cnt2;
            }
            for (; x % 5 == 0; x /= 5) {
                ++cnt5;
            }
        }
        int c = Math.min(cnt2, cnt5);
        cnt2 = cnt5 = c;
        long suf = 1;
        double pre = 1;
        boolean gt = false;
        for (int i = left; i <= right; ++i) {
            for (suf *= i; cnt2 > 0 && suf % 2 == 0; suf /= 2) {
                --cnt2;
            }
            for (; cnt5 > 0 && suf % 5 == 0; suf /= 5) {
                --cnt5;
            }
            if (suf >= (long) 1e10) {
                gt = true;
                suf %= (long) 1e10;
            }
            for (pre *= i; pre > 1e5; pre /= 10) {
            }
        }
        if (gt) {
            return (int) pre + "..." + String.format("%05d", suf % (int) 1e5) + "e" + c;
        }
        return suf + "e" + c;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2117 _tcSol = new Solution2117();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "left = 1, right = 4");
        try {
            int left = 1;
            int right = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.abbreviateProduct(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"24e0\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "left = 2, right = 11");
        try {
            int left = 2;
            int right = 11;
            System.out.println("  Output  : " + _tcShow(_tcSol.abbreviateProduct(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"399168e2\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "left = 371, right = 375");
        try {
            int left = 371;
            int right = 375;
            System.out.println("  Output  : " + _tcShow(_tcSol.abbreviateProduct(left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"7219856259e3\"");
        System.out.println();
    }
}