package com.leetcode.matrices_grids;

class Solution2943 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int x = Math.min(f(hBars), f(vBars));
        return x * x;
    }

    private int f(int[] nums) {
        Arrays.sort(nums);
        int ans = 1, cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1] + 1) {
                ans = Math.max(ans, ++cnt);
            } else {
                cnt = 1;
            }
        }
        return ans + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2943 _tcSol = new Solution2943();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, m = 1, hBars = [2,3], vBars = [2]");
        try {
            int n = 2;
            int m = 1;
            int[] hBars = new int[]{2, 3};
            int[] vBars = new int[]{2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSquareHoleArea(n, m, hBars, vBars)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, m = 1, hBars = [2], vBars = [2]");
        try {
            int n = 1;
            int m = 1;
            int[] hBars = new int[]{2};
            int[] vBars = new int[]{2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSquareHoleArea(n, m, hBars, vBars)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, m = 3, hBars = [2,3], vBars = [2,4]");
        try {
            int n = 2;
            int m = 3;
            int[] hBars = new int[]{2, 3};
            int[] vBars = new int[]{2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximizeSquareHoleArea(n, m, hBars, vBars)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}