package com.leetcode.sliding_window_two_pointers;

class Solution0325 {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Long, Integer> d = new HashMap<>();
        d.put(0L, -1);
        int ans = 0;
        long s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            ans = Math.max(ans, i - d.getOrDefault(s - k, i));
            d.putIfAbsent(s, i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0325 _tcSol = new Solution0325();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-1,5,-2,3], k = 3");
        try {
            int[] nums = new int[]{1, -1, 5, -2, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubArrayLen(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-2,-1,2,1], k = 1");
        try {
            int[] nums = new int[]{-2, -1, 2, 1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSubArrayLen(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}