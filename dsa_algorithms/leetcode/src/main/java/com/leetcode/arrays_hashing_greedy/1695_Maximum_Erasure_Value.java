package com.leetcode.arrays_hashing_greedy;

class Solution1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int[] d = new int[10001];
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
        int ans = 0, j = 0;
        for (int i = 1; i <= n; ++i) {
            int v = nums[i - 1];
            j = Math.max(j, d[v]);
            ans = Math.max(ans, s[i] - s[j]);
            d[v] = i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1695 _tcSol = new Solution1695();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,2,4,5,6]");
        try {
            int[] nums = new int[]{4, 2, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumUniqueSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "17");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,2,1,2,5,2,1,2,5]");
        try {
            int[] nums = new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumUniqueSubarray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}