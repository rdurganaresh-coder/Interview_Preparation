package com.leetcode.matrices_grids;

class Solution3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0, mx = 0;
        for (var d : dimensions) {
            int l = d[0], w = d[1];
            int t = l * l + w * w;
            if (mx < t) {
                mx = t;
                ans = l * w;
            } else if (mx == t) {
                ans = Math.max(ans, l * w);
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
        Solution3000 _tcSol = new Solution3000();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "dimensions = [[9,3],[8,6]]");
        try {
            int[][] dimensions = new int[][]{new int[]{9, 3}, new int[]{8, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.areaOfMaxDiagonal(dimensions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "48");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "dimensions = [[3,4],[4,3]]");
        try {
            int[][] dimensions = new int[][]{new int[]{3, 4}, new int[]{4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.areaOfMaxDiagonal(dimensions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();
    }
}