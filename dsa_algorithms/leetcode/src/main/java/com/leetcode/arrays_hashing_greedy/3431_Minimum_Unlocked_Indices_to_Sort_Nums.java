package com.leetcode.arrays_hashing_greedy;

class Solution3431 {
    public int minUnlockedIndices(int[] nums, int[] locked) {
        int n = nums.length;
        int first2 = n, first3 = n;
        int last1 = -1, last2 = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                last1 = i;
            } else if (nums[i] == 2) {
                first2 = Math.min(first2, i);
                last2 = i;
            } else {
                first3 = Math.min(first3, i);
            }
        }
        if (first3 < last1) {
            return -1;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (locked[i] == 1 && ((first2 <= i && i < last1) || (first3 <= i && i < last2))) {
                ++ans;
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
        Solution3431 _tcSol = new Solution3431();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,1,2,3,2], locked = [1,0,1,1,0,1]");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 3, 2};
            int[] locked = new int[]{1, 0, 1, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minUnlockedIndices(nums, locked)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,1,1,3,2,2], locked = [1,0,1,1,0,1,0]");
        try {
            int[] nums = new int[]{1, 2, 1, 1, 3, 2, 2};
            int[] locked = new int[]{1, 0, 1, 1, 0, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minUnlockedIndices(nums, locked)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,1,2,3,2,1], locked = [0,0,0,0,0,0,0]");
        try {
            int[] nums = new int[]{1, 2, 1, 2, 3, 2, 1};
            int[] locked = new int[]{0, 0, 0, 0, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minUnlockedIndices(nums, locked)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
