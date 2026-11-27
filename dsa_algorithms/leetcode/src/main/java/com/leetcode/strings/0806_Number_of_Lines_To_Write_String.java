package com.leetcode.strings;

class Solution0806 {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1, last = 0;
        for (int i = 0; i < s.length(); ++i) {
            int w = widths[s.charAt(i) - 'a'];
            if (last + w <= 100) {
                last += w;
            } else {
                ++lines;
                last = w;
            }
        }
        return new int[] {lines, last};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0806 _tcSol = new Solution0806();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = \"abcdefghijklmnopqrstuvwxyz\"");
        try {
            int[] widths = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
            String s = "abcdefghijklmnopqrstuvwxyz";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfLines(widths, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,60]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = \"bbbcccdddaaa\"");
        try {
            int[] widths = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
            String s = "bbbcccdddaaa";
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfLines(widths, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,4]");
        System.out.println();
    }
}