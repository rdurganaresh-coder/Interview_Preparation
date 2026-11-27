package com.leetcode.arrays_hashing_greedy;

class Solution0982 {
    public int countTriplets(int[] nums) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int[] cnt = new int[mx + 1];
        for (int x : nums) {
            for (int y : nums) {
                cnt[x & y]++;
            }
        }
        int ans = 0;
        for (int xy = 0; xy <= mx; ++xy) {
            for (int z : nums) {
                if ((xy & z) == 0) {
                    ans += cnt[xy];
                }
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
        Solution0982 _tcSol = new Solution0982();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,3]");
        try {
            int[] nums = new int[]{2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,0,0]");
        try {
            int[] nums = new int[]{0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.countTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "27");
        System.out.println();
    }
}