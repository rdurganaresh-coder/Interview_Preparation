package com.leetcode.arrays_hashing_greedy;

class Solution2141 {
    public long maxRunTime(int n, int[] batteries) {
        long l = 0, r = 0;
        for (int x : batteries) {
            r += x;
        }
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            long s = 0;
            for (int x : batteries) {
                s += Math.min(mid, x);
            }
            if (s >= n * mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2141 _tcSol = new Solution2141();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, batteries = [3,3,3]");
        try {
            int n = 2;
            int[] batteries = new int[]{3, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRunTime(n, batteries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, batteries = [1,1,1,1]");
        try {
            int n = 2;
            int[] batteries = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxRunTime(n, batteries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}