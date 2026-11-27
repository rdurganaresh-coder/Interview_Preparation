package com.leetcode.arrays_hashing_greedy;

class Solution2134 {
    public int minSwaps(int[] nums) {
        int k = Arrays.stream(nums).sum();
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < k; ++i) {
            cnt += nums[i];
        }
        int mx = cnt;
        for (int i = k; i < n + k; ++i) {
            cnt += nums[i % n] - nums[(i - k + n) % n];
            mx = Math.max(mx, cnt);
        }
        return k - mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2134 _tcSol = new Solution2134();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,0,1,1,0,0]");
        try {
            int[] nums = new int[]{0, 1, 0, 1, 1, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,1,1,0,0,1,1,0]");
        try {
            int[] nums = new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,0,0,1]");
        try {
            int[] nums = new int[]{1, 1, 0, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}