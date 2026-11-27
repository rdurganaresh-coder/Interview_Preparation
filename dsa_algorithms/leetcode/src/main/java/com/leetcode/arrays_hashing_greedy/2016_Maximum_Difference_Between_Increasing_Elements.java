package com.leetcode.arrays_hashing_greedy;

class Solution2016 {
    public int maximumDifference(int[] nums) {
        int mi = 1 << 30;
        int ans = -1;
        for (int x : nums) {
            if (x > mi) {
                ans = Math.max(ans, x - mi);
            } else {
                mi = x;
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
        Solution2016 _tcSol = new Solution2016();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [7,1,5,4]");
        try {
            int[] nums = new int[]{7, 1, 5, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [9,4,3,2]");
        try {
            int[] nums = new int[]{9, 4, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,5,2,10]");
        try {
            int[] nums = new int[]{1, 5, 2, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumDifference(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}