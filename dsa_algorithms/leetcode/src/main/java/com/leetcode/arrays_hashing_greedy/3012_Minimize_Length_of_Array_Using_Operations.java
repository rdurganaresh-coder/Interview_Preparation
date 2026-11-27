package com.leetcode.arrays_hashing_greedy;

class Solution3012 {
    public int minimumArrayLength(int[] nums) {
        int mi = Arrays.stream(nums).min().getAsInt();
        int cnt = 0;
        for (int x : nums) {
            if (x % mi != 0) {
                return 1;
            }
            if (x == mi) {
                ++cnt;
            }
        }
        return (cnt + 1) / 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3012 _tcSol = new Solution3012();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,4,3,1]");
        try {
            int[] nums = new int[]{1, 4, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumArrayLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,5,5,10,5]");
        try {
            int[] nums = new int[]{5, 5, 5, 10, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumArrayLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,3,4]");
        try {
            int[] nums = new int[]{2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumArrayLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}