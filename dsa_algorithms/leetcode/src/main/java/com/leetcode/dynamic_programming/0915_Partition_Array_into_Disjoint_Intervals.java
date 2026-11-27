package com.leetcode.dynamic_programming;

class Solution0915 {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] mi = new int[n + 1];
        mi[n] = nums[n - 1];
        for (int i = n - 1; i >= 0; --i) {
            mi[i] = Math.min(nums[i], mi[i + 1]);
        }
        int mx = 0;
        for (int i = 1;; ++i) {
            int v = nums[i - 1];
            mx = Math.max(mx, v);
            if (mx <= mi[i]) {
                return i;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0915 _tcSol = new Solution0915();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,0,3,8,6]");
        try {
            int[] nums = new int[]{5, 0, 3, 8, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.partitionDisjoint(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,0,6,12]");
        try {
            int[] nums = new int[]{1, 1, 1, 0, 6, 12};
            System.out.println("  Output  : " + _tcShow(_tcSol.partitionDisjoint(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}