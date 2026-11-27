package com.leetcode.arrays_hashing_greedy;

class Solution0458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base = minutesToTest / minutesToDie + 1;
        int res = 0;
        for (int p = 1; p < buckets; p *= base) {
            ++res;
        }
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0458 _tcSol = new Solution0458();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "buckets = 4, minutesToDie = 15, minutesToTest = 15");
        try {
            int buckets = 4;
            int minutesToDie = 15;
            int minutesToTest = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.poorPigs(buckets, minutesToDie, minutesToTest)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "buckets = 4, minutesToDie = 15, minutesToTest = 30");
        try {
            int buckets = 4;
            int minutesToDie = 15;
            int minutesToTest = 30;
            System.out.println("  Output  : " + _tcShow(_tcSol.poorPigs(buckets, minutesToDie, minutesToTest)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}