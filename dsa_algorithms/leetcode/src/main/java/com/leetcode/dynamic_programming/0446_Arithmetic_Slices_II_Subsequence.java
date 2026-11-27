package com.leetcode.dynamic_programming;

class Solution0446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        Arrays.setAll(f, k -> new HashMap<>());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                Long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].merge(d, cnt + 1, Integer::sum);
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
        Solution0446 _tcSol = new Solution0446();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,4,6,8,10]");
        try {
            int[] nums = new int[]{2, 4, 6, 8, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfArithmeticSlices(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [7,7,7,7,7]");
        try {
            int[] nums = new int[]{7, 7, 7, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfArithmeticSlices(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}