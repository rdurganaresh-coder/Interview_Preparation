package com.leetcode.sliding_window_two_pointers;

class Solution3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0, pre = 0, cur = 0;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            ++cur;
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                ans = Math.max(ans, Math.max(cur / 2, Math.min(pre, cur)));
                pre = cur;
                cur = 0;
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
        Solution3350 _tcSol = new Solution3350();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,5,7,8,9,2,3,4,3,1]");
        try {
            List<Integer> nums = _tcL(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIncreasingSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,4,4,4,5,6,7]");
        try {
            List<Integer> nums = _tcL(1, 2, 3, 4, 4, 4, 4, 5, 6, 7);
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIncreasingSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
