package com.leetcode.arrays_hashing_greedy;

class Solution2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        long v = (long) length * width * height;
        int bulky = length >= 10000 || width >= 10000 || height >= 10000 || v >= 1000000000 ? 1 : 0;
        int heavy = mass >= 100 ? 1 : 0;
        String[] d = {"Neither", "Bulky", "Heavy", "Both"};
        int i = heavy << 1 | bulky;
        return d[i];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2525 _tcSol = new Solution2525();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "length = 1000, width = 35, height = 700, mass = 300");
        try {
            int length = 1000;
            int width = 35;
            int height = 700;
            int mass = 300;
            System.out.println("  Output  : " + _tcShow(_tcSol.categorizeBox(length, width, height, mass)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Heavy\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "length = 200, width = 50, height = 800, mass = 50");
        try {
            int length = 200;
            int width = 50;
            int height = 800;
            int mass = 50;
            System.out.println("  Output  : " + _tcShow(_tcSol.categorizeBox(length, width, height, mass)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Neither\"");
        System.out.println();
    }
}