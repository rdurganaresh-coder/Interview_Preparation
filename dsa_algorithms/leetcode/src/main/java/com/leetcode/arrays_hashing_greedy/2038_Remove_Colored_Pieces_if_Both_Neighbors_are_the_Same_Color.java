package com.leetcode.arrays_hashing_greedy;

class Solution2038 {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int a = 0, b = 0;
        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && colors.charAt(j) == colors.charAt(i)) {
                ++j;
            }
            int m = j - i - 2;
            if (m > 0) {
                if (colors.charAt(i) == 'A') {
                    a += m;
                } else {
                    b += m;
                }
            }
        }
        return a > b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2038 _tcSol = new Solution2038();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "colors = \"AAABABB\"");
        try {
            String colors = "AAABABB";
            System.out.println("  Output  : " + _tcShow(_tcSol.winnerOfGame(colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "colors = \"AA\"");
        try {
            String colors = "AA";
            System.out.println("  Output  : " + _tcShow(_tcSol.winnerOfGame(colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "colors = \"ABBBBBBBAAA\"");
        try {
            String colors = "ABBBBBBBAAA";
            System.out.println("  Output  : " + _tcShow(_tcSol.winnerOfGame(colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}