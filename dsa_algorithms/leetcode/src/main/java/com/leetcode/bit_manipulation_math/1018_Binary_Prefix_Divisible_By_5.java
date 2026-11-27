package com.leetcode.bit_manipulation_math;

class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int x = 0;
        for (int v : nums) {
            x = (x << 1 | v) % 5;
            ans.add(x == 0);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1018 _tcSol = new Solution1018();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,1]");
        try {
            int[] nums = new int[]{0, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.prefixesDivBy5(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false,false]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.prefixesDivBy5(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[false,false,false]");
        System.out.println();
    }
}