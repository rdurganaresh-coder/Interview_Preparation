package com.leetcode.arrays_hashing_greedy;

class Solution2873 {
    public long maximumTripletValue(int[] nums) {
        long ans = 0, mxDiff = 0;
        int mx = 0;
        for (int x : nums) {
            ans = Math.max(ans, mxDiff * x);
            mxDiff = Math.max(mxDiff, mx - x);
            mx = Math.max(mx, x);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2873 _tcSol = new Solution2873();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [12,6,1,2,7]");
        try {
            int[] nums = new int[]{12, 6, 1, 2, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTripletValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "77");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,10,3,4,19]");
        try {
            int[] nums = new int[]{1, 10, 3, 4, 19};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTripletValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "133");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTripletValue(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
