package com.leetcode.sliding_window_two_pointers;

class Solution3364 {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        final int inf = Integer.MAX_VALUE;
        int ans = inf;
        for (int i = 0; i < n; ++i) {
            int s = 0;
            for (int j = i; j < n; ++j) {
                s += nums.get(j);
                int k = j - i + 1;
                if (k >= l && k <= r && s > 0) {
                    ans = Math.min(ans, s);
                }
            }
        }
        return ans == inf ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution3364 _tcSol = new Solution3364();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3, -2, 1, 4], l = 2, r = 3");
        try {
            List<Integer> nums = _tcL(3, -2, 1, 4);
            int l = 2;
            int r = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSumSubarray(nums, l, r)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-2, 2, -3, 1], l = 2, r = 3");
        try {
            List<Integer> nums = _tcL(-2, 2, -3, 1);
            int l = 2;
            int r = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSumSubarray(nums, l, r)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1, 2, 3, 4], l = 2, r = 4");
        try {
            List<Integer> nums = _tcL(1, 2, 3, 4);
            int l = 2;
            int r = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSumSubarray(nums, l, r)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
