package com.leetcode.arrays_hashing_greedy;

class Solution2731 {
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = (long) nums[i] + (s.charAt(i) == 'L' ? -d : d);
        }
        Arrays.sort(arr);
        long ans = 0, sum = 0;
        final int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; ++i) {
            ans = (ans + i * arr[i] - sum) % mod;
            sum += arr[i];
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2731 _tcSol = new Solution2731();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-2,0,2], s = \"RLL\", d = 3");
        try {
            int[] nums = new int[]{-2, 0, 2};
            String s = "RLL";
            int d = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumDistance(nums, s, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,0], s = \"RL\", d = 2");
        try {
            int[] nums = new int[]{1, 0};
            String s = "RL";
            int d = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumDistance(nums, s, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}