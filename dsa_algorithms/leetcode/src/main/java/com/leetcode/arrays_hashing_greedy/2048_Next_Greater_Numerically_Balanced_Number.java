package com.leetcode.arrays_hashing_greedy;

class Solution2048 {
    public int nextBeautifulNumber(int n) {
        for (int x = n + 1;; ++x) {
            int[] cnt = new int[10];
            for (int y = x; y > 0; y /= 10) {
                ++cnt[y % 10];
            }
            boolean ok = true;
            for (int y = x; y > 0; y /= 10) {
                if (y % 10 != cnt[y % 10]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return x;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2048 _tcSol = new Solution2048();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1");
        try {
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.nextBeautifulNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1000");
        try {
            int n = 1000;
            System.out.println("  Output  : " + _tcShow(_tcSol.nextBeautifulNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1333");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3000");
        try {
            int n = 3000;
            System.out.println("  Output  : " + _tcShow(_tcSol.nextBeautifulNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3133");
        System.out.println();
    }
}