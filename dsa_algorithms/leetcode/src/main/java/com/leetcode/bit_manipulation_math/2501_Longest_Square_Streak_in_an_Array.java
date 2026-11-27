package com.leetcode.bit_manipulation_math;

class Solution2501 {
    public int longestSquareStreak(int[] nums) {
        Set<Long> s = new HashSet<>();
        for (long x : nums) {
            s.add(x);
        }
        int ans = -1;
        for (long x : s) {
            int t = 0;
            for (; s.contains(x); x *= x) {
                ++t;
            }
            if (t > 1) {
                ans = Math.max(ans, t);
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
        Solution2501 _tcSol = new Solution2501();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,6,16,8,2]");
        try {
            int[] nums = new int[]{4, 3, 6, 16, 8, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSquareStreak(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,3,5,6,7]");
        try {
            int[] nums = new int[]{2, 3, 5, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSquareStreak(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}