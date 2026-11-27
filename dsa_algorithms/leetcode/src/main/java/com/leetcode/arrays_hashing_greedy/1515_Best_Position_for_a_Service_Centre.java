package com.leetcode.arrays_hashing_greedy;

class Solution1515 {
    public double getMinDistSum(int[][] positions) {
        int n = positions.length;
        double x = 0, y = 0;
        for (int[] p : positions) {
            x += p[0];
            y += p[1];
        }
        x /= n;
        y /= n;
        double decay = 0.999;
        double eps = 1e-6;
        double alpha = 0.5;
        while (true) {
            double gradX = 0, gradY = 0;
            double dist = 0;
            for (int[] p : positions) {
                double a = x - p[0], b = y - p[1];
                double c = Math.sqrt(a * a + b * b);
                gradX += a / (c + 1e-8);
                gradY += b / (c + 1e-8);
                dist += c;
            }
            double dx = gradX * alpha, dy = gradY * alpha;
            if (Math.abs(dx) <= eps && Math.abs(dy) <= eps) {
                return dist;
            }
            x -= dx;
            y -= dy;
            alpha *= decay;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1515 _tcSol = new Solution1515();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "positions = [[0,1],[1,0],[1,2],[2,1]]");
        try {
            int[][] positions = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{1, 2}, new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getMinDistSum(positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4.00000");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "positions = [[1,1],[3,3]]");
        try {
            int[][] positions = new int[][]{new int[]{1, 1}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getMinDistSum(positions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2.82843");
        System.out.println();
    }
}