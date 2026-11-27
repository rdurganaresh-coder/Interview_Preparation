package com.leetcode.arrays_hashing_greedy;

class Solution2903 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int mi = 0;
        int mx = 0;
        for (int i = indexDifference; i < nums.length; ++i) {
            int j = i - indexDifference;
            if (nums[j] < nums[mi]) {
                mi = j;
            }
            if (nums[j] > nums[mx]) {
                mx = j;
            }
            if (nums[i] - nums[mi] >= valueDifference) {
                return new int[] {mi, i};
            }
            if (nums[mx] - nums[i] >= valueDifference) {
                return new int[] {mx, i};
            }
        }
        return new int[] {-1, -1};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2903 _tcSol = new Solution2903();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,1,4,1], indexDifference = 2, valueDifference = 4");
        try {
            int[] nums = new int[]{5, 1, 4, 1};
            int indexDifference = 2;
            int valueDifference = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findIndices(nums, indexDifference, valueDifference)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,1], indexDifference = 0, valueDifference = 0");
        try {
            int[] nums = new int[]{2, 1};
            int indexDifference = 0;
            int valueDifference = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.findIndices(nums, indexDifference, valueDifference)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3], indexDifference = 2, valueDifference = 4");
        try {
            int[] nums = new int[]{1, 2, 3};
            int indexDifference = 2;
            int valueDifference = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.findIndices(nums, indexDifference, valueDifference)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[-1,-1]");
        System.out.println();
    }
}