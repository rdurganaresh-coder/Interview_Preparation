package com.leetcode.matrices_grids;

class Solution3200 {
    public int maxHeightOfTriangle(int red, int blue) {
        int ans = 0;
        for (int k = 0; k < 2; ++k) {
            int[] c = {red, blue};
            for (int i = 1, j = k; i <= c[j]; j ^= 1, ++i) {
                c[j] -= i;
                ans = Math.max(ans, i);
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
        Solution3200 _tcSol = new Solution3200();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "red = 2, blue = 4");
        try {
            int red = 2;
            int blue = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHeightOfTriangle(red, blue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "red = 2, blue = 1");
        try {
            int red = 2;
            int blue = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHeightOfTriangle(red, blue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "red = 1, blue = 1");
        try {
            int red = 1;
            int blue = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHeightOfTriangle(red, blue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "red = 10, blue = 1");
        try {
            int red = 10;
            int blue = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxHeightOfTriangle(red, blue)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}