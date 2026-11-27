package com.leetcode.arrays_hashing_greedy;

class Solution2656 {
    public int maximizeSum(int[] nums, int k) {
        int x = 0;
        for (int v : nums) {
            x = Math.max(x, v);
        }
        return k * x + k * (k - 1) / 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2656 _tcSol = new Solution2656();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,5,5], k = 2");
        try {
            int[] nums = new int[]{5, 5, 5};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}