package com.leetcode.arrays_hashing_greedy;

class Solution0403_2 {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] f = new boolean[n][n];
        f[0][0] = true;
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k - 1 > j) {
                    break;
                }
                f[i][k] = f[j][k - 1] || f[j][k] || f[j][k + 1];
                if (i == n - 1 && f[i][k]) {
                    return true;
                }
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
        Solution0403_2 _tcSol = new Solution0403_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [0,1,3,5,6,8,12,17]");
        try {
            int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
            System.out.println("  Output  : " + _tcShow(_tcSol.canCross(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [0,1,2,3,4,8,9,11]");
        try {
            int[] stones = new int[]{0, 1, 2, 3, 4, 8, 9, 11};
            System.out.println("  Output  : " + _tcShow(_tcSol.canCross(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}