package com.leetcode.arrays_hashing_greedy;

class Solution2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        for (int i = 0; i < n; ++i) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        for (int i = 0; i < n; ++i) {
            additionalRocks -= capacity[i];
            if (additionalRocks < 0) {
                return i;
            }
        }
        return n;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2279 _tcSol = new Solution2279();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2");
        try {
            int[] capacity = new int[]{2, 3, 4, 5};
            int[] rocks = new int[]{1, 2, 4, 4};
            int additionalRocks = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBags(capacity, rocks, additionalRocks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100");
        try {
            int[] capacity = new int[]{10, 2, 2};
            int[] rocks = new int[]{2, 2, 0};
            int additionalRocks = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBags(capacity, rocks, additionalRocks)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
