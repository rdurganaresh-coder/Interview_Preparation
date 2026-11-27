package com.leetcode.backtracking;

class Solution2862 {
    public long maximumSum(List<Integer> nums) {
        long ans = 0;
        int n = nums.size();
        for (int k = 1; k <= n; ++k) {
            long t = 0;
            for (int j = 1; k * j * j <= n; ++j) {
                t += nums.get(k * j * j - 1);
            }
            ans = Math.max(ans, t);
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
        Solution2862 _tcSol = new Solution2862();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [8,7,3,5,7,2,4,9]");
        try {
            List<Integer> nums = _tcL(8, 7, 3, 5, 7, 2, 4, 9);
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [8,10,3,8,1,13,7,9,4]");
        try {
            List<Integer> nums = _tcL(8, 10, 3, 8, 1, 13, 7, 9, 4);
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}
