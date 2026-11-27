package com.leetcode.arrays_hashing_greedy;

class Solution1748 {
    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        for (int x : nums) {
            ++cnt[x];
        }
        int ans = 0;
        for (int x = 0; x < 101; ++x) {
            if (cnt[x] == 1) {
                ans += x;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1748 _tcSol = new Solution1748();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,2]");
        try {
            int[] nums = new int[]{1, 2, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfUnique(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfUnique(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.sumOfUnique(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}