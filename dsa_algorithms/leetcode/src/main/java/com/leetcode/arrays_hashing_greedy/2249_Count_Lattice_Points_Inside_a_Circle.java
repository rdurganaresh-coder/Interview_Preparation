package com.leetcode.arrays_hashing_greedy;

class Solution2249 {
    public int countLatticePoints(int[][] circles) {
        int mx = 0, my = 0;
        for (var c : circles) {
            mx = Math.max(mx, c[0] + c[2]);
            my = Math.max(my, c[1] + c[2]);
        }
        int ans = 0;
        for (int i = 0; i <= mx; ++i) {
            for (int j = 0; j <= my; ++j) {
                for (var c : circles) {
                    int dx = i - c[0], dy = j - c[1];
                    if (dx * dx + dy * dy <= c[2] * c[2]) {
                        ++ans;
                        break;
                    }
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
        Solution2249 _tcSol = new Solution2249();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "circles = [[2,2,1]]");
        try {
            int[][] circles = new int[][]{new int[]{2, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countLatticePoints(circles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "circles = [[2,2,2],[3,4,1]]");
        try {
            int[][] circles = new int[][]{new int[]{2, 2, 2}, new int[]{3, 4, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countLatticePoints(circles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}