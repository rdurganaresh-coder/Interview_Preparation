package com.leetcode.trees_tries;

class Solution1361 {
    private int[] p;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        boolean[] vis = new boolean[n];
        for (int i = 0, m = n; i < m; ++i) {
            for (int j : new int[] {leftChild[i], rightChild[i]}) {
                if (j != -1) {
                    if (vis[j] || find(i) == find(j)) {
                        return false;
                    }
                    p[find(i)] = find(j);
                    vis[j] = true;
                    --n;
                }
            }
        }
        return n == 1;
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
        Solution1361 _tcSol = new Solution1361();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]");
        try {
            int n = 4;
            int[] leftChild = new int[]{1, -1, 3, -1};
            int[] rightChild = new int[]{2, -1, -1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validateBinaryTreeNodes(n, leftChild, rightChild)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]");
        try {
            int n = 4;
            int[] leftChild = new int[]{1, -1, 3, -1};
            int[] rightChild = new int[]{2, 3, -1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validateBinaryTreeNodes(n, leftChild, rightChild)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 2, leftChild = [1,0], rightChild = [-1,-1]");
        try {
            int n = 2;
            int[] leftChild = new int[]{1, 0};
            int[] rightChild = new int[]{-1, -1};
            System.out.println("  Output  : " + _tcShow(_tcSol.validateBinaryTreeNodes(n, leftChild, rightChild)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}