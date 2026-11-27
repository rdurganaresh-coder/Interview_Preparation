package com.leetcode.arrays_hashing_greedy;

class Solution0547_2 {
    private int[] p;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        int ans = n;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isConnected[i][j] == 1) {
                    int pa = find(i), pb = find(j);
                    if (pa != pb) {
                        p[pa] = pb;
                        --ans;
                    }
                }
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0547_2 _tcSol = new Solution0547_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "isConnected = [[1,1,0],[1,1,0],[0,0,1]]");
        try {
            int[][] isConnected = new int[][]{new int[]{1, 1, 0}, new int[]{1, 1, 0}, new int[]{0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findCircleNum(isConnected)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "isConnected = [[1,0,0],[0,1,0],[0,0,1]]");
        try {
            int[][] isConnected = new int[][]{new int[]{1, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.findCircleNum(isConnected)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}