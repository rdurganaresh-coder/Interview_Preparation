package com.leetcode.sliding_window_two_pointers;

class Solution2537 {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        long ans = 0, cur = 0;
        int i = 0;
        for (int x : nums) {
            cur += cnt.merge(x, 1, Integer::sum) - 1;
            while (cur - cnt.get(nums[i]) + 1 >= k) {
                cur -= cnt.merge(nums[i++], -1, Integer::sum);
            }
            if (cur >= k) {
                ans += i + 1;
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
        Solution2537 _tcSol = new Solution2537();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,1,1,1], k = 10");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 1};
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGood(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,1,4,3,2,2,4], k = 2");
        try {
            int[] nums = new int[]{3, 1, 4, 3, 2, 2, 4};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGood(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}