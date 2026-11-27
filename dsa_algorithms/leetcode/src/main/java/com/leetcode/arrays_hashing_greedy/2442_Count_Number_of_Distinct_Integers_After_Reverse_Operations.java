package com.leetcode.arrays_hashing_greedy;

class Solution2442 {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        for (int x : nums) {
            int y = 0;
            while (x > 0) {
                y = y * 10 + x % 10;
                x /= 10;
            }
            s.add(y);
        }
        return s.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2442 _tcSol = new Solution2442();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,13,10,12,31]");
        try {
            int[] nums = new int[]{1, 13, 10, 12, 31};
            System.out.println("  Output  : " + _tcShow(_tcSol.countDistinctIntegers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2]");
        try {
            int[] nums = new int[]{2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.countDistinctIntegers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}