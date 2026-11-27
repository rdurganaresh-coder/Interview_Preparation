package com.leetcode.sliding_window_two_pointers;

class Solution3487 {
    public int maxSum(int[] nums) {
        int mx = Arrays.stream(nums).max().getAsInt();
        if (mx <= 0) {
            return mx;
        }
        boolean[] s = new boolean[201];
        int ans = 0;
        for (int x : nums) {
            if (x < 0 || s[x]) {
                continue;
            }
            ans += x;
            s[x] = true;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3487 _tcSol = new Solution3487();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5]");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,0,1,1]");
        try {
            int[] nums = new int[]{1, 1, 0, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,-1,-2,1,0,-1]");
        try {
            int[] nums = new int[]{1, 2, -1, -2, 1, 0, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
