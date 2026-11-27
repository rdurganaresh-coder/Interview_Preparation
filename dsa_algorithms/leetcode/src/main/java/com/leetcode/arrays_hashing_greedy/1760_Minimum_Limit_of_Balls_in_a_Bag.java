package com.leetcode.arrays_hashing_greedy;

class Solution1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = Arrays.stream(nums).max().getAsInt();
        while (l < r) {
            int mid = (l + r) >> 1;
            long s = 0;
            for (int x : nums) {
                s += (x - 1) / mid;
            }
            if (s <= maxOperations) {
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
        Solution1760 _tcSol = new Solution1760();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [9], maxOperations = 2");
        try {
            int[] nums = new int[]{9};
            int maxOperations = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSize(nums, maxOperations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,4,8,2], maxOperations = 4");
        try {
            int[] nums = new int[]{2, 4, 8, 2};
            int maxOperations = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSize(nums, maxOperations)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
