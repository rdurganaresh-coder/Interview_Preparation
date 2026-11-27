package com.leetcode.sliding_window_two_pointers;

class Solution2090 {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        long s = 0;
        for (int i = 0; i < n; ++i) {
            s += nums[i];
            if (i >= k * 2) {
                ans[i - k] = (int) (s / (k * 2 + 1));
                s -= nums[i - k * 2];
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
        Solution2090 _tcSol = new Solution2090();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [7,4,3,9,1,8,5,2,6], k = 3");
        try {
            int[] nums = new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getAverages(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1,-1,5,4,4,-1,-1,-1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [100000], k = 0");
        try {
            int[] nums = new int[]{100000};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.getAverages(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[100000]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [8], k = 100000");
        try {
            int[] nums = new int[]{8};
            int k = 100000;
            System.out.println("  Output  : " + _tcShow(_tcSol.getAverages(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1]");
        System.out.println();
    }
}
