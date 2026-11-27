package com.leetcode.arrays_hashing_greedy;

class Solution0169 {
    public int majorityElement(int[] nums) {
        int cnt = 0, m = 0;
        for (int x : nums) {
            if (cnt == 0) {
                m = x;
                cnt = 1;
            } else {
                cnt += m == x ? 1 : -1;
            }
        }
        return m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0169 _tcSol = new Solution0169();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,3]");
        try {
            int[] nums = new int[]{3, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.majorityElement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,1,1,1,2,2]");
        try {
            int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.majorityElement(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}