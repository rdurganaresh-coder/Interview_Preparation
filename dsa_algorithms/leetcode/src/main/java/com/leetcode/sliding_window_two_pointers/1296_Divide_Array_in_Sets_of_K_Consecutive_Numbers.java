package com.leetcode.sliding_window_two_pointers;

class Solution1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        for (int x : nums) {
            if (cnt.getOrDefault(x, 0) > 0) {
                for (int y = x; y < x + k; ++y) {
                    if (cnt.merge(y, -1, Integer::sum) < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1296 _tcSol = new Solution1296();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,3,4,4,5,6], k = 4");
        try {
            int[] nums = new int[]{1, 2, 3, 3, 4, 4, 5, 6};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossibleDivide(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3");
        try {
            int[] nums = new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossibleDivide(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,4], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.isPossibleDivide(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
