package com.leetcode.sql_database;

class Solution2860 {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if ((i == 0 || nums.get(i - 1) < i) && (i == n || nums.get(i) > i)) {
                ans++;
            }
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
        Solution2860 _tcSol = new Solution2860();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1]");
        try {
            List<Integer> nums = _tcL(1, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.countWays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,0,3,3,6,7,2,7]");
        try {
            List<Integer> nums = _tcL(6, 0, 3, 3, 6, 7, 2, 7);
            System.out.println("  Output  : " + _tcShow(_tcSol.countWays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}