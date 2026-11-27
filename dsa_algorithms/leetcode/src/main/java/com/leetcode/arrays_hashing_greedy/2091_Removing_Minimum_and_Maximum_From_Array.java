package com.leetcode.arrays_hashing_greedy;

class Solution2091 {
    public int minimumDeletions(int[] nums) {
        int mi = 0, mx = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < nums[mi]) {
                mi = i;
            }
            if (nums[i] > nums[mx]) {
                mx = i;
            }
        }
        if (mi > mx) {
            int t = mx;
            mx = mi;
            mi = t;
        }
        return Math.min(Math.min(mx + 1, n - mi), mi + 1 + n - mx);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2091 _tcSol = new Solution2091();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,10,7,5,4,1,8,6]");
        try {
            int[] nums = new int[]{2, 10, 7, 5, 4, 1, 8, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDeletions(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,-4,19,1,8,-2,-3,5]");
        try {
            int[] nums = new int[]{0, -4, 19, 1, 8, -2, -3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDeletions(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [101]");
        try {
            int[] nums = new int[]{101};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDeletions(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}