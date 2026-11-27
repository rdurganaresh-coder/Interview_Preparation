package com.leetcode.dynamic_programming;

class Solution2369_3 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n + 1];
        f[n] = true;
        for (int i = n - 1; i >= 0; --i) {
            boolean a = i + 1 < n && nums[i] == nums[i + 1];
            boolean b = i + 2 < n && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2];
            boolean c = i + 2 < n && nums[i + 1] - nums[i] == 1 && nums[i + 2] - nums[i + 1] == 1;
            f[i] = (a && f[i + 2]) || ((b || c) && f[i + 3]);
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2369_3 _tcSol = new Solution2369_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,4,4,5,6]");
        try {
            int[] nums = new int[]{4, 4, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.validPartition(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,2]");
        try {
            int[] nums = new int[]{1, 1, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.validPartition(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
