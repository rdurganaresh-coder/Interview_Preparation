package com.leetcode.arrays_hashing_greedy;

class Solution0287 {
    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int v : nums) {
                if (v <= mid) {
                    ++cnt;
                }
            }
            if (cnt > mid) {
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
        Solution0287 _tcSol = new Solution0287();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,4,2,2]");
        try {
            int[] nums = new int[]{1, 3, 4, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDuplicate(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,1,3,4,2]");
        try {
            int[] nums = new int[]{3, 1, 3, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDuplicate(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,3,3,3,3]");
        try {
            int[] nums = new int[]{3, 3, 3, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDuplicate(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}