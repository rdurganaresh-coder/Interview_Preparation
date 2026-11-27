package com.leetcode.arrays_hashing_greedy;

class Solution2209_2 {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + (floor.charAt(i) == '1' ? 1 : 0);
        }
        int[][] f = new int[n + 1][numCarpets + 1];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j <= numCarpets; ++j) {
                if (floor.charAt(i) == '0') {
                    f[i][j] = f[i + 1][j];
                } else if (j == 0) {
                    f[i][j] = s[n] - s[i];
                } else {
                    int cover = i + carpetLen <= n ? f[i + carpetLen][j - 1] : 0;
                    f[i][j] = Math.min(1 + f[i + 1][j], cover);
                }
            }
        }
        return f[0][numCarpets];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2209_2 _tcSol = new Solution2209_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "floor = \"10110101\", numCarpets = 2, carpetLen = 2");
        try {
            String floor = "10110101";
            int numCarpets = 2;
            int carpetLen = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumWhiteTiles(floor, numCarpets, carpetLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "floor = \"11111\", numCarpets = 2, carpetLen = 3");
        try {
            String floor = "11111";
            int numCarpets = 2;
            int carpetLen = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumWhiteTiles(floor, numCarpets, carpetLen)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
