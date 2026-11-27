package com.leetcode.arrays_hashing_greedy;

class Solution3301 {
    public long maximumTotalSum(int[] maximumHeight) {
        long ans = 0;
        int mx = 1 << 30;
        Arrays.sort(maximumHeight);
        for (int i = maximumHeight.length - 1; i >= 0; --i) {
            int x = Math.min(maximumHeight[i], mx - 1);
            if (x <= 0) {
                return -1;
            }
            ans += x;
            mx = x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3301 _tcSol = new Solution3301();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "maximumHeight = [2,3,4,3]");
        try {
            int[] maximumHeight = new int[]{2, 3, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalSum(maximumHeight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "maximumHeight = [15,10]");
        try {
            int[] maximumHeight = new int[]{15, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalSum(maximumHeight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "25");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "maximumHeight = [2,2,1]");
        try {
            int[] maximumHeight = new int[]{2, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalSum(maximumHeight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
