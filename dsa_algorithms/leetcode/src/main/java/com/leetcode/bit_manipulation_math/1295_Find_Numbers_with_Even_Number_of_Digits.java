package com.leetcode.bit_manipulation_math;

class Solution1295 {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            if (String.valueOf(x).length() % 2 == 0) {
                ++ans;
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
        Solution1295 _tcSol = new Solution1295();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [12,345,2,6,7896]");
        try {
            int[] nums = new int[]{12, 345, 2, 6, 7896};
            System.out.println("  Output  : " + _tcShow(_tcSol.findNumbers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [555,901,482,1771]");
        try {
            int[] nums = new int[]{555, 901, 482, 1771};
            System.out.println("  Output  : " + _tcShow(_tcSol.findNumbers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
