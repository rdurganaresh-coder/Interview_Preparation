package com.leetcode.arrays_hashing_greedy;

class Solution1133 {
    public int largestUniqueNumber(int[] nums) {
        int[] cnt = new int[1001];
        for (int x : nums) {
            ++cnt[x];
        }
        for (int x = 1000; x >= 0; --x) {
            if (cnt[x] == 1) {
                return x;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1133 _tcSol = new Solution1133();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,7,3,9,4,9,8,3,1]");
        try {
            int[] nums = new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestUniqueNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [9,9,8,8]");
        try {
            int[] nums = new int[]{9, 9, 8, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.largestUniqueNumber(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}