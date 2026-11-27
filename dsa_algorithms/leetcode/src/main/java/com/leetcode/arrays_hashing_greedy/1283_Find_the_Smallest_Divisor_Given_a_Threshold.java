package com.leetcode.arrays_hashing_greedy;

class Solution1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 1000000;
        while (l < r) {
            int mid = (l + r) >> 1;
            int s = 0;
            for (int x : nums) {
                s += (x + mid - 1) / mid;
            }
            if (s <= threshold) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1283 _tcSol = new Solution1283();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,5,9], threshold = 6");
        try {
            int[] nums = new int[]{1, 2, 5, 9};
            int threshold = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestDivisor(nums, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [44,22,33,11,1], threshold = 5");
        try {
            int[] nums = new int[]{44, 22, 33, 11, 1};
            int threshold = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestDivisor(nums, threshold)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "44");
        System.out.println();
    }
}