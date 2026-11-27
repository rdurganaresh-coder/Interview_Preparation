package com.leetcode.sql_database;

class Solution1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int x = nums[i] * nums[j];
                cnt.merge(x, 1, Integer::sum);
            }
        }
        int ans = 0;
        for (int v : cnt.values()) {
            ans += v * (v - 1) / 2;
        }
        return ans << 3;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1726 _tcSol = new Solution1726();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,4,6]");
        try {
            int[] nums = new int[]{2, 3, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.tupleSameProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,4,5,10]");
        try {
            int[] nums = new int[]{1, 2, 4, 5, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.tupleSameProduct(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}