package com.leetcode.arrays_hashing_greedy;

class Solution0945_2 {
    public int minIncrementForUnique(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt() + nums.length;
        int[] cnt = new int[m];
        for (int x : nums) {
            ++cnt[x];
        }
        int ans = 0;
        for (int i = 0; i < m - 1; ++i) {
            int diff = cnt[i] - 1;
            if (diff > 0) {
                cnt[i + 1] += diff;
                ans += diff;
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
        Solution0945_2 _tcSol = new Solution0945_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2]");
        try {
            int[] nums = new int[]{1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minIncrementForUnique(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,1,2,1,7]");
        try {
            int[] nums = new int[]{3, 2, 1, 2, 1, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minIncrementForUnique(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
