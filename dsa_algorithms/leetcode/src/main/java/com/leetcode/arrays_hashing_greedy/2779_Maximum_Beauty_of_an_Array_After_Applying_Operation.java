package com.leetcode.arrays_hashing_greedy;

class Solution2779 {
    public int maximumBeauty(int[] nums, int k) {
        int m = Arrays.stream(nums).max().getAsInt() + k * 2 + 2;
        int[] d = new int[m];
        for (int x : nums) {
            d[x]++;
            d[x + k * 2 + 1]--;
        }
        int ans = 0, s = 0;
        for (int x : d) {
            s += x;
            ans = Math.max(ans, s);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2779 _tcSol = new Solution2779();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,6,1,2], k = 2");
        try {
            int[] nums = new int[]{4, 6, 1, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBeauty(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,1], k = 10");
        try {
            int[] nums = new int[]{1, 1, 1, 1};
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBeauty(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}