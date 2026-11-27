package com.leetcode.arrays_hashing_greedy;

class Solution3274 {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int x = coordinate1.charAt(0) - coordinate2.charAt(0);
        int y = coordinate1.charAt(1) - coordinate2.charAt(1);
        return (x + y) % 2 == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3274 _tcSol = new Solution3274();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "coordinate1 = \"a1\", coordinate2 = \"c3\"");
        try {
            String coordinate1 = "a1";
            String coordinate2 = "c3";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkTwoChessboards(coordinate1, coordinate2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "coordinate1 = \"a1\", coordinate2 = \"h3\"");
        try {
            String coordinate1 = "a1";
            String coordinate2 = "h3";
            System.out.println("  Output  : " + _tcShow(_tcSol.checkTwoChessboards(coordinate1, coordinate2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
