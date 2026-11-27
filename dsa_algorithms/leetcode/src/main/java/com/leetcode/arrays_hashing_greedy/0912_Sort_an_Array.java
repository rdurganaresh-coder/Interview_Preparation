package com.leetcode.arrays_hashing_greedy;

class Solution0912 {
    private int[] nums;

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        quikcSort(0, nums.length - 1);
        return nums;
    }

    private void quikcSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int x = nums[(l + r) >> 1];
        int i = l - 1, j = r + 1;
        while (i < j) {
            while (nums[++i] < x) {
            }
            while (nums[--j] > x) {
            }
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        quikcSort(l, j);
        quikcSort(j + 1, r);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0912 _tcSol = new Solution0912();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [5,2,3,1]");
        try {
            int[] nums = new int[]{5, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,1,1,2,0,0]");
        try {
            int[] nums = new int[]{5, 1, 1, 2, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[0,0,1,1,2,5]");
        System.out.println();
    }
}