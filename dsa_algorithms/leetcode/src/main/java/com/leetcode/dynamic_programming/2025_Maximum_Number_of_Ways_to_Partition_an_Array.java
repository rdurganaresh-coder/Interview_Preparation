package com.leetcode.dynamic_programming;

class Solution2025 {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        long[] s = new long[n];
        s[0] = nums[0];
        Map<Long, Integer> right = new HashMap<>();
        for (int i = 0; i < n - 1; ++i) {
            right.merge(s[i], 1, Integer::sum);
            s[i + 1] = s[i] + nums[i + 1];
        }
        int ans = 0;
        if (s[n - 1] % 2 == 0) {
            ans = right.getOrDefault(s[n - 1] / 2, 0);
        }
        Map<Long, Integer> left = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int d = k - nums[i];
            if ((s[n - 1] + d) % 2 == 0) {
                int t = left.getOrDefault((s[n - 1] + d) / 2, 0)
                    + right.getOrDefault((s[n - 1] - d) / 2, 0);
                ans = Math.max(ans, t);
            }
            left.merge(s[i], 1, Integer::sum);
            right.merge(s[i], -1, Integer::sum);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2025 _tcSol = new Solution2025();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,-1,2], k = 3");
        try {
            int[] nums = new int[]{2, -1, 2};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToPartition(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,0,0], k = 1");
        try {
            int[] nums = new int[]{0, 0, 0};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToPartition(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14], k = -33");
        try {
            int[] nums = new int[]{22, 4, -25, -20, -15, 15, -16, 7, 19, -10, 0, -13, -14};
            int k = -33;
            System.out.println("  Output  : " + _tcShow(_tcSol.waysToPartition(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}