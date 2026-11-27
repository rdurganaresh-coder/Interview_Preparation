package com.leetcode.dynamic_programming;

class Solution3218 {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int ans = 0;
        int i = m - 2, j = n - 2;
        int h = 1, v = 1;
        while (i >= 0 || j >= 0) {
            if (j < 0 || (i >= 0 && horizontalCut[i] > verticalCut[j])) {
                ans += horizontalCut[i--] * v;
                ++h;
            } else {
                ans += verticalCut[j--] * h;
                ++v;
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
        Solution3218 _tcSol = new Solution3218();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "m = 3, n = 2, horizontalCut = [1,3], verticalCut = [5]");
        try {
            int m = 3;
            int n = 2;
            int[] horizontalCut = new int[]{1, 3};
            int[] verticalCut = new int[]{5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(m, n, horizontalCut, verticalCut)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "m = 2, n = 2, horizontalCut = [7], verticalCut = [4]");
        try {
            int m = 2;
            int n = 2;
            int[] horizontalCut = new int[]{7};
            int[] verticalCut = new int[]{4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumCost(m, n, horizontalCut, verticalCut)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}