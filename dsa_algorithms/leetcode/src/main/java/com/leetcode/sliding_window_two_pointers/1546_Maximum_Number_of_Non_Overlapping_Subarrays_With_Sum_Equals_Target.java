package com.leetcode.sliding_window_two_pointers;

class Solution1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            Set<Integer> vis = new HashSet<>();
            int s = 0;
            vis.add(0);
            while (i < n) {
                s += nums[i];
                if (vis.contains(s - target)) {
                    ++ans;
                    break;
                }
                ++i;
                vis.add(s);
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
        Solution1546 _tcSol = new Solution1546();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,1,1,1], target = 2");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 1};
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNonOverlapping(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,3,5,1,4,2,-9], target = 6");
        try {
            int[] nums = new int[]{-1, 3, 5, 1, 4, 2, -9};
            int target = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNonOverlapping(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}