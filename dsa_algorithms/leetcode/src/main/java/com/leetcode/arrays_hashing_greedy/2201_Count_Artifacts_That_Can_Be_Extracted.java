package com.leetcode.arrays_hashing_greedy;

class Solution2201 {
    private Set<Integer> s = new HashSet<>();
    private int n;

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        this.n = n;
        for (var p : dig) {
            s.add(p[0] * n + p[1]);
        }
        int ans = 0;
        for (var a : artifacts) {
            ans += check(a);
        }
        return ans;
    }

    private int check(int[] a) {
        int x1 = a[0], y1 = a[1], x2 = a[2], y2 = a[3];
        for (int x = x1; x <= x2; ++x) {
            for (int y = y1; y <= y2; ++y) {
                if (!s.contains(x * n + y)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2201 _tcSol = new Solution2201();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, artifacts = [[0,0,0,0],[0,1,1,1]], dig = [[0,0],[0,1]]");
        try {
            int n = 2;
            int[][] artifacts = new int[][]{new int[]{0, 0, 0, 0}, new int[]{0, 1, 1, 1}};
            int[][] dig = new int[][]{new int[]{0, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.digArtifacts(n, artifacts, dig)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, artifacts = [[0,0,0,0],[0,1,1,1]], dig = [[0,0],[0,1],[1,1]]");
        try {
            int n = 2;
            int[][] artifacts = new int[][]{new int[]{0, 0, 0, 0}, new int[]{0, 1, 1, 1}};
            int[][] dig = new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.digArtifacts(n, artifacts, dig)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}