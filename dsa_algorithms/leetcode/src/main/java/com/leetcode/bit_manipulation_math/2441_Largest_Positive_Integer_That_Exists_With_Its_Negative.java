package com.leetcode.bit_manipulation_math;

class Solution2441 {
    public int findMaxK(int[] nums) {
        int ans = -1;
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        for (int x : s) {
            if (s.contains(-x)) {
                ans = Math.max(ans, x);
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
        Solution2441 _tcSol = new Solution2441();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-1,2,-3,3]");
        try {
            int[] nums = new int[]{-1, 2, -3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxK(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,10,6,7,-7,1]");
        try {
            int[] nums = new int[]{-1, 10, 6, 7, -7, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxK(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [-10,8,6,7,-2,-3]");
        try {
            int[] nums = new int[]{-10, 8, 6, 7, -2, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxK(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}