package com.leetcode.arrays_hashing_greedy;

class Solution2154 {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        while (s.contains(original)) {
            original <<= 1;
        }
        return original;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2154 _tcSol = new Solution2154();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,3,6,1,12], original = 3");
        try {
            int[] nums = new int[]{5, 3, 6, 1, 12};
            int original = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findFinalValue(nums, original)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "24");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,7,9], original = 4");
        try {
            int[] nums = new int[]{2, 7, 9};
            int original = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findFinalValue(nums, original)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}