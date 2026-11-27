package com.leetcode.matrices_grids;

class Solution0492 {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[] {area / w, w};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0492 _tcSol = new Solution0492();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "area = 4");
        try {
            int area = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.constructRectangle(area)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "area = 37");
        try {
            int area = 37;
            System.out.println("  Output  : " + _tcShow(_tcSol.constructRectangle(area)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[37,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "area = 122122");
        try {
            int area = 122122;
            System.out.println("  Output  : " + _tcShow(_tcSol.constructRectangle(area)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[427,286]");
        System.out.println();
    }
}