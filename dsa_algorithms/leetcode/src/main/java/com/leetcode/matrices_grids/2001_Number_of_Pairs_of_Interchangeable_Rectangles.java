package com.leetcode.matrices_grids;

class Solution2001 {
    public long interchangeableRectangles(int[][] rectangles) {
        long ans = 0;
        Map<Long, Integer> cnt = new HashMap<>();
        for (var e : rectangles) {
            int w = e[0], h = e[1];
            int g = gcd(w, h);
            w /= g;
            h /= g;
            long x = (long) w * 100001 + h;
            ans += cnt.getOrDefault(x, 0);
            cnt.merge(x, 1, Integer::sum);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2001 _tcSol = new Solution2001();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rectangles = [[4,8],[3,6],[10,20],[15,30]]");
        try {
            int[][] rectangles = new int[][]{new int[]{4, 8}, new int[]{3, 6}, new int[]{10, 20}, new int[]{15, 30}};
            System.out.println("  Output  : " + _tcShow(_tcSol.interchangeableRectangles(rectangles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rectangles = [[4,5],[7,8]]");
        try {
            int[][] rectangles = new int[][]{new int[]{4, 5}, new int[]{7, 8}};
            System.out.println("  Output  : " + _tcShow(_tcSol.interchangeableRectangles(rectangles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}