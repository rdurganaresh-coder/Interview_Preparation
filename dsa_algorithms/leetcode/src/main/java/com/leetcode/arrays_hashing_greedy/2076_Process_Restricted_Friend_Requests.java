package com.leetcode.arrays_hashing_greedy;

class Solution2076 {
    private int[] p;

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        int m = requests.length;
        boolean[] ans = new boolean[m];
        for (int i = 0; i < m; ++i) {
            int u = requests[i][0], v = requests[i][1];
            int pu = find(u), pv = find(v);
            if (pu == pv) {
                ans[i] = true;
            } else {
                boolean ok = true;
                for (var r : restrictions) {
                    int px = find(r[0]), py = find(r[1]);
                    if ((pu == px && pv == py) || (pu == py && pv == px)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    ans[i] = true;
                    p[pu] = pv;
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
        Solution2076 _tcSol = new Solution2076();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, restrictions = [[0,1]], requests = [[0,2],[2,1]]");
        try {
            int n = 3;
            int[][] restrictions = new int[][]{new int[]{0, 1}};
            int[][] requests = new int[][]{new int[]{0, 2}, new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.friendRequests(n, restrictions, requests)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, restrictions = [[0,1]], requests = [[1,2],[0,2]]");
        try {
            int n = 3;
            int[][] restrictions = new int[][]{new int[]{0, 1}};
            int[][] requests = new int[][]{new int[]{1, 2}, new int[]{0, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.friendRequests(n, restrictions, requests)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 5, restrictions = [[0,1],[1,2],[2,3]], requests = [[0,4],[1,2],[3,1],[3,4]]");
        try {
            int n = 5;
            int[][] restrictions = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}};
            int[][] requests = new int[][]{new int[]{0, 4}, new int[]{1, 2}, new int[]{3, 1}, new int[]{3, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.friendRequests(n, restrictions, requests)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[true,false,true,false]");
        System.out.println();
    }
}