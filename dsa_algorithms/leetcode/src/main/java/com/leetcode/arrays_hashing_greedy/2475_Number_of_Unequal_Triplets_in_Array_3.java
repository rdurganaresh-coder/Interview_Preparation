package com.leetcode.arrays_hashing_greedy;

class Solution2475_3 {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.merge(v, 1, Integer::sum);
        }
        int ans = 0, a = 0;
        int n = nums.length;
        for (int b : cnt.values()) {
            int c = n - a - b;
            ans += a * b * c;
            a += b;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2475_3 _tcSol = new Solution2475_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,4,2,4,3]");
        try {
            int[] nums = new int[]{4, 4, 2, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.unequalTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.unequalTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}