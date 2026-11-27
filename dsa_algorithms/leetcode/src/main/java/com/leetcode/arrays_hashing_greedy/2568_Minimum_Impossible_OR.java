package com.leetcode.arrays_hashing_greedy;

class Solution2568 {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        for (int i = 0;; ++i) {
            if (!s.contains(1 << i)) {
                return 1 << i;
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2568 _tcSol = new Solution2568();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1]");
        try {
            int[] nums = new int[]{2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minImpossibleOR(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,3,2]");
        try {
            int[] nums = new int[]{5, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minImpossibleOR(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}