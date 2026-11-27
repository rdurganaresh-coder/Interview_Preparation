package com.leetcode.dynamic_programming;

class Solution2915 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] f = new int[n + 1][target + 1];
        final int inf = 1 << 30;
        for (int[] g : f) {
            Arrays.fill(g, -inf);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            int x = nums.get(i - 1);
            for (int j = 0; j <= target; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= x) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - x] + 1);
                }
            }
        }
        return f[n][target] <= 0 ? -1 : f[n][target];
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
        Solution2915 _tcSol = new Solution2915();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5], target = 9");
        try {
            List<Integer> nums = _tcL(1, 2, 3, 4, 5);
            int target = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLongestSubsequence(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,1,3,2,1,5], target = 7");
        try {
            List<Integer> nums = _tcL(4, 1, 3, 2, 1, 5);
            int target = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLongestSubsequence(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,5,4,5], target = 3");
        try {
            List<Integer> nums = _tcL(1, 1, 5, 4, 5);
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.lengthOfLongestSubsequence(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}