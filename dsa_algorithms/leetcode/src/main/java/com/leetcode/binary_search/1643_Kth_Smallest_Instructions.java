package com.leetcode.binary_search;

class Solution1643 {
    public String kthSmallestPath(int[] destination, int k) {
        int v = destination[0], h = destination[1];
        int n = v + h;
        int[][] c = new int[n + 1][h + 1];
        c[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            c[i][0] = 1;
            for (int j = 1; j <= h; ++j) {
                c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = n; i > 0; --i) {
            if (h == 0) {
                ans.append('V');
            } else {
                int x = c[v + h - 1][h - 1];
                if (k > x) {
                    ans.append('V');
                    k -= x;
                    --v;
                } else {
                    ans.append('H');
                    --h;
                }
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1643 _tcSol = new Solution1643();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "destination = [2,3], k = 1");
        try {
            int[] destination = new int[]{2, 3};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallestPath(destination, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"HHHVV\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "destination = [2,3], k = 2");
        try {
            int[] destination = new int[]{2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallestPath(destination, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"HHVHV\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "destination = [2,3], k = 3");
        try {
            int[] destination = new int[]{2, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthSmallestPath(destination, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"HHVVH\"");
        System.out.println();
    }
}