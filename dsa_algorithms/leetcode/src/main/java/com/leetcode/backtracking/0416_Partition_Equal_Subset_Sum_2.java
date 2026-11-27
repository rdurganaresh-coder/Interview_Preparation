package com.leetcode.backtracking;

class Solution0416_2 {
    public boolean canPartition(int[] nums) {
        // int s = Arrays.stream(nums).sum();
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        if (s % 2 == 1) {
            return false;
        }
        int m = s >> 1;
        boolean[] f = new boolean[m + 1];
        f[0] = true;
        for (int x : nums) {
            for (int j = m; j >= x; --j) {
                f[j] |= f[j - x];
            }
        }
        return f[m];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0416_2 _tcSol = new Solution0416_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,5,11,5]");
        try {
            int[] nums = new int[]{1, 5, 11, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.canPartition(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.canPartition(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}