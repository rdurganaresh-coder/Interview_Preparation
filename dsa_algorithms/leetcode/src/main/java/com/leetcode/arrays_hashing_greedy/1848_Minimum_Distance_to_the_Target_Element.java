package com.leetcode.arrays_hashing_greedy;

class Solution1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
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
        Solution1848 _tcSol = new Solution1848();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5], target = 5, start = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            int target = 5;
            int start = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMinDistance(nums, target, start)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1], target = 1, start = 0");
        try {
            int[] nums = new int[]{1};
            int target = 1;
            int start = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMinDistance(nums, target, start)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            int target = 1;
            int start = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.getMinDistance(nums, target, start)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}