package com.leetcode.strings;

class Solution2023 {
    public int numOfPairs(String[] nums, String target) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && target.equals(nums[i] + nums[j])) {
                    ++ans;
                }
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
        Solution2023 _tcSol = new Solution2023();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [\"777\",\"7\",\"77\",\"77\"], target = \"7777\"");
        try {
            String[] nums = new String[]{"777", "7", "77", "77"};
            String target = "7777";
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfPairs(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [\"123\",\"4\",\"12\",\"34\"], target = \"1234\"");
        try {
            String[] nums = new String[]{"123", "4", "12", "34"};
            String target = "1234";
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfPairs(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [\"1\",\"1\",\"1\"], target = \"11\"");
        try {
            String[] nums = new String[]{"1", "1", "1"};
            String target = "11";
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfPairs(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}