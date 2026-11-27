package com.leetcode.sliding_window_two_pointers;

class Solution3041 {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int ans = 1, prev = Integer.MIN_VALUE;
        int f0 = 1, f1 = 1;
        for (int x : nums) {
            if (x == prev) {
                f1 = f0 + 1;
            } else if (x == prev + 1) {
                ++f0;
                ++f1;
            } else if (x == prev + 2) {
                f0 = f1 + 1;
                f1 = 1;
            } else {
                f0 = 1;
                f1 = 1;
            }
            ans = Math.max(ans, Math.max(f0, f1));
            prev = x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3041 _tcSol = new Solution3041();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,5,1,1]");
        try {
            int[] nums = new int[]{2, 1, 5, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSelectedElements(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,4,7,10]");
        try {
            int[] nums = new int[]{1, 4, 7, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSelectedElements(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
