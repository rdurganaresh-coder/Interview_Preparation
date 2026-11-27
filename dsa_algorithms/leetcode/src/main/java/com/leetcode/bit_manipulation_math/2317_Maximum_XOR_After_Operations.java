package com.leetcode.bit_manipulation_math;

class Solution2317 {
    public int maximumXOR(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans |= x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2317 _tcSol = new Solution2317();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,2,4,6]");
        try {
            int[] nums = new int[]{3, 2, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumXOR(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,9,2]");
        try {
            int[] nums = new int[]{1, 2, 3, 9, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumXOR(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}