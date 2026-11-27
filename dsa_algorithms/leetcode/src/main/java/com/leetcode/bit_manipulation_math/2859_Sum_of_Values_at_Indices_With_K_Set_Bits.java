package com.leetcode.bit_manipulation_math;

class Solution2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                ans += nums.get(i);
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
        Solution2859 _tcSol = new Solution2859();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,10,1,5,2], k = 1");
        try {
            List<Integer> nums = _tcL(5, 10, 1, 5, 2);
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumIndicesWithKSetBits(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,3,2,1], k = 2");
        try {
            List<Integer> nums = _tcL(4, 3, 2, 1);
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.sumIndicesWithKSetBits(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}