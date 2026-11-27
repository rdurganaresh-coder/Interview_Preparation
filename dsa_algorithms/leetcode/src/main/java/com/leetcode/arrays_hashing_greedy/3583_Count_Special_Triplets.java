package com.leetcode.arrays_hashing_greedy;

class Solution3583 {
    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int x : nums) {
            right.merge(x, 1, Integer::sum);
        }
        long ans = 0;
        final int mod = (int) 1e9 + 7;
        for (int x : nums) {
            right.merge(x, -1, Integer::sum);
            ans = (ans + 1L * left.getOrDefault(x * 2, 0) * right.getOrDefault(x * 2, 0) % mod)
                % mod;
            left.merge(x, 1, Integer::sum);
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3583 _tcSol = new Solution3583();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [6,3,6]");
        try {
            int[] nums = new int[]{6, 3, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.specialTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,0,0]");
        try {
            int[] nums = new int[]{0, 1, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.specialTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [8,4,2,8,4]");
        try {
            int[] nums = new int[]{8, 4, 2, 8, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.specialTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}