package com.leetcode.sliding_window_two_pointers;

class Solution2913 {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            int[] s = new int[101];
            int cnt = 0;
            for (int j = i; j < n; ++j) {
                if (++s[nums.get(j)] == 1) {
                    ++cnt;
                }
                ans += cnt * cnt;
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
        Solution2913 _tcSol = new Solution2913();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1]");
        try {
            List<Integer> nums = _tcL(1, 2, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.sumCounts(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1]");
        try {
            List<Integer> nums = _tcL(1, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.sumCounts(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}