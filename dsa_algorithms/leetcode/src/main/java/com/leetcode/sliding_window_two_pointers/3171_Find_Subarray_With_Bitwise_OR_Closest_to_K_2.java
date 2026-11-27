package com.leetcode.sliding_window_two_pointers;

class Solution3171_2 {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        Set<Integer> pre = new HashSet<>();
        for (int x : nums) {
            Set<Integer> cur = new HashSet<>();
            for (int y : pre) {
                cur.add(x | y);
            }
            cur.add(x);
            for (int y : cur) {
                ans = Math.min(ans, Math.abs(y - k));
            }
            pre = cur;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3171_2 _tcSol = new Solution3171_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,4,5], k = 3");
        try {
            int[] nums = new int[]{1, 2, 4, 5};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,1,3], k = 2");
        try {
            int[] nums = new int[]{1, 3, 1, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1], k = 10");
        try {
            int[] nums = new int[]{1};
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDifference(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}