package com.leetcode.arrays_hashing_greedy;

class Solution3224 {
    public int minChanges(int[] nums, int k) {
        int[] d = new int[k + 2];
        int n = nums.length;
        for (int i = 0; i < n / 2; ++i) {
            int x = Math.min(nums[i], nums[n - i - 1]);
            int y = Math.max(nums[i], nums[n - i - 1]);
            d[0] += 1;
            d[y - x] -= 1;
            d[y - x + 1] += 1;
            d[Math.max(y, k - x) + 1] -= 1;
            d[Math.max(y, k - x) + 1] += 2;
        }
        int ans = n, s = 0;
        for (int x : d) {
            s += x;
            ans = Math.min(ans, s);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3224 _tcSol = new Solution3224();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,1,2,4,3], k = 4");
        try {
            int[] nums = new int[]{1, 0, 1, 2, 4, 3};
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minChanges(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,2,3,3,6,5,4], k = 6");
        try {
            int[] nums = new int[]{0, 1, 2, 3, 3, 6, 5, 4};
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minChanges(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}