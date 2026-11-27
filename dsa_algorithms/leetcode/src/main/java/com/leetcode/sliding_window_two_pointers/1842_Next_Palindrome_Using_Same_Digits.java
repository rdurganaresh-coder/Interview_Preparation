package com.leetcode.sliding_window_two_pointers;

class Solution1842 {
    public String nextPalindrome(String num) {
        char[] nums = num.toCharArray();
        if (!nextPermutation(nums)) {
            return "";
        }
        int n = nums.length;
        for (int i = 0; i < n / 2; ++i) {
            nums[n - 1 - i] = nums[i];
        }
        return String.valueOf(nums);
    }

    private boolean nextPermutation(char[] nums) {
        int n = nums.length / 2;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }
        if (i < 0) {
            return false;
        }
        int j = n - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            --j;
        }
        swap(nums, i++, j);
        for (j = n - 1; i < j; ++i, --j) {
            swap(nums, i, j);
        }
        return true;
    }

    private void swap(char[] nums, int i, int j) {
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1842 _tcSol = new Solution1842();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"1221\"");
        try {
            String num = "1221";
            System.out.println("  Output  : " + _tcShow(_tcSol.nextPalindrome(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2112\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"32123\"");
        try {
            String num = "32123";
            System.out.println("  Output  : " + _tcShow(_tcSol.nextPalindrome(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = \"45544554\"");
        try {
            String num = "45544554";
            System.out.println("  Output  : " + _tcShow(_tcSol.nextPalindrome(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"54455445\"");
        System.out.println();
    }
}