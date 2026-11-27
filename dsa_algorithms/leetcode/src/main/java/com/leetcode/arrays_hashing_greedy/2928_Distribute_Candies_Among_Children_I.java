package com.leetcode.arrays_hashing_greedy;

class Solution2928 {
    public int distributeCandies(int n, int limit) {
        if (n > 3 * limit) {
            return 0;
        }
        long ans = comb2(n + 2);
        if (n > limit) {
            ans -= 3 * comb2(n - limit + 1);
        }
        if (n - 2 >= 2 * limit) {
            ans += 3 * comb2(n - 2 * limit);
        }
        return (int) ans;
    }

    private long comb2(int n) {
        return 1L * n * (n - 1) / 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2928 _tcSol = new Solution2928();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, limit = 2");
        try {
            int n = 5;
            int limit = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.distributeCandies(n, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, limit = 3");
        try {
            int n = 3;
            int limit = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.distributeCandies(n, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}