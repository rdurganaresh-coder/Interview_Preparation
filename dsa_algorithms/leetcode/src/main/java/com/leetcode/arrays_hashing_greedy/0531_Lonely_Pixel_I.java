package com.leetcode.arrays_hashing_greedy;

class Solution0531 {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] == 'B') {
                    ++rows[i];
                    ++cols[j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
                    ++ans;
                }
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
        Solution0531 _tcSol = new Solution0531();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "picture = [[\"W\",\"W\",\"B\"],[\"W\",\"B\",\"W\"],[\"B\",\"W\",\"W\"]]");
        try {
            char[][] picture = new char[][]{new char[]{'W', 'W', 'B'}, new char[]{'W', 'B', 'W'}, new char[]{'B', 'W', 'W'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLonelyPixel(picture)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "picture = [[\"B\",\"B\",\"B\"],[\"B\",\"B\",\"W\"],[\"B\",\"B\",\"B\"]]");
        try {
            char[][] picture = new char[][]{new char[]{'B', 'B', 'B'}, new char[]{'B', 'B', 'W'}, new char[]{'B', 'B', 'B'}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findLonelyPixel(picture)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}