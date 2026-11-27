package com.leetcode.arrays_hashing_greedy;

class Solution0335 {
    public boolean isSelfCrossing(int[] distance) {
        int[] d = distance;
        for (int i = 3; i < d.length; ++i) {
            if (d[i] >= d[i - 2] && d[i - 1] <= d[i - 3]) {
                return true;
            }
            if (i >= 4 && d[i - 1] == d[i - 3] && d[i] + d[i - 4] >= d[i - 2]) {
                return true;
            }
            if (i >= 5 && d[i - 2] >= d[i - 4] && d[i - 1] <= d[i - 3]
                && d[i] >= d[i - 2] - d[i - 4] && d[i - 1] + d[i - 5] >= d[i - 3]) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0335 _tcSol = new Solution0335();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "distance = [2,1,1,2]");
        try {
            int[] distance = new int[]{2, 1, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.isSelfCrossing(distance)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "distance = [1,2,3,4]");
        try {
            int[] distance = new int[]{1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.isSelfCrossing(distance)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "distance = [1,1,1,2,1]");
        try {
            int[] distance = new int[]{1, 1, 1, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.isSelfCrossing(distance)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}