package com.leetcode.arrays_hashing_greedy;

class Solution3048 {
    private int[] nums;
    private int[] changeIndices;

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        this.nums = nums;
        this.changeIndices = changeIndices;
        int m = changeIndices.length;
        int l = 1, r = m + 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l > m ? -1 : l;
    }

    private boolean check(int t) {
        int[] last = new int[nums.length + 1];
        for (int s = 0; s < t; ++s) {
            last[changeIndices[s]] = s;
        }
        int decrement = 0;
        int marked = 0;
        for (int s = 0; s < t; ++s) {
            int i = changeIndices[s];
            if (last[i] == s) {
                if (decrement < nums[i - 1]) {
                    return false;
                }
                decrement -= nums[i - 1];
                ++marked;
            } else {
                ++decrement;
            }
        }
        return marked == nums.length;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3048 _tcSol = new Solution3048();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,2,0], changeIndices = [2,2,2,2,3,2,2,1]");
        try {
            int[] nums = new int[]{2, 2, 0};
            int[] changeIndices = new int[]{2, 2, 2, 2, 3, 2, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.earliestSecondToMarkIndices(nums, changeIndices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3], changeIndices = [1,1,1,2,1,1,1]");
        try {
            int[] nums = new int[]{1, 3};
            int[] changeIndices = new int[]{1, 1, 1, 2, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.earliestSecondToMarkIndices(nums, changeIndices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0,1], changeIndices = [2,2,2]");
        try {
            int[] nums = new int[]{0, 1};
            int[] changeIndices = new int[]{2, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.earliestSecondToMarkIndices(nums, changeIndices)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}