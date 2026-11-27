package com.leetcode.sliding_window_two_pointers;

class Solution0523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> d = new HashMap<>();
        d.put(0, -1);
        int s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s = (s + nums[i]) % k;
            if (!d.containsKey(s)) {
                d.put(s, i);
            } else if (i - d.get(s) > 1) {
                return true;
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
        Solution0523 _tcSol = new Solution0523();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [23,2,4,6,7], k = 6");
        try {
            int[] nums = new int[]{23, 2, 4, 6, 7};
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [23,2,6,4,7], k = 6");
        try {
            int[] nums = new int[]{23, 2, 6, 4, 7};
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [23,2,6,4,7], k = 13");
        try {
            int[] nums = new int[]{23, 2, 6, 4, 7};
            int k = 13;
            System.out.println("  Output  : " + _tcShow(_tcSol.checkSubarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}