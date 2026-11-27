package com.leetcode.arrays_hashing_greedy;

class Solution0565_2 {
    public int arrayNesting(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            int j = i;
            while (nums[j] < n) {
                int k = nums[j];
                nums[j] = n;
                j = k;
                ++cnt;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0565_2 _tcSol = new Solution0565_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,4,0,3,1,6,2]");
        try {
            int[] nums = new int[]{5, 4, 0, 3, 1, 6, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayNesting(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,2]");
        try {
            int[] nums = new int[]{0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.arrayNesting(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}