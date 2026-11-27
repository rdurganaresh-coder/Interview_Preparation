package com.leetcode.bit_manipulation_math;

class Solution1980_2 {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }
        return new String(ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1980_2 _tcSol = new Solution1980_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [\"01\",\"10\"]");
        try {
            String[] nums = new String[]{"01", "10"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDifferentBinaryString(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"11\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [\"00\",\"01\"]");
        try {
            String[] nums = new String[]{"00", "01"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDifferentBinaryString(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"11\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [\"111\",\"011\",\"001\"]");
        try {
            String[] nums = new String[]{"111", "011", "001"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDifferentBinaryString(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"101\"");
        System.out.println();
    }
}
