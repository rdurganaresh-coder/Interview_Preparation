package com.leetcode.dynamic_programming;

class Solution3282 {
    public long findMaximumScore(List<Integer> nums) {
        long ans = 0;
        int mx = 0;
        for (int i = 0; i + 1 < nums.size(); ++i) {
            mx = Math.max(mx, nums.get(i));
            ans += mx;
        }
        return ans;
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
        Solution3282 _tcSol = new Solution3282();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,1,5]");
        try {
            List<Integer> nums = _tcL(1, 3, 1, 5);
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximumScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,3,1,3,2]");
        try {
            List<Integer> nums = _tcL(4, 3, 1, 3, 2);
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaximumScore(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}
