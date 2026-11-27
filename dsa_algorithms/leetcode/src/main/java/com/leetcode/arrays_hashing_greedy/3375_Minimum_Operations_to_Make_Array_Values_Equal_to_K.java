package com.leetcode.arrays_hashing_greedy;

class Solution3375 {
    public int minOperations(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        int mi = 1 << 30;
        for (int x : nums) {
            if (x < k) {
                return -1;
            }
            mi = Math.min(mi, x);
            s.add(x);
        }
        return s.size() - (mi == k ? 1 : 0);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3375 _tcSol = new Solution3375();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,2,5,4,5], k = 2");
        try {
            int[] nums = new int[]{5, 2, 5, 4, 5};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1,2], k = 2");
        try {
            int[] nums = new int[]{2, 1, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [9,7,5,3], k = 1");
        try {
            int[] nums = new int[]{9, 7, 5, 3};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
