package com.leetcode.arrays_hashing_greedy;

class Solution3501 {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int active = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') {
                ++active;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (s.indexOf('0') < 0) {
            for (int i = 0; i < queries.length; ++i) {
                ans.add(active);
            }
            return ans;
        }

        int[][] zeros = new int[n][2];
        int z = 0;
        int[] idx = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    ++zeros[z - 1][1];
                } else {
                    zeros[z][0] = i;
                    zeros[z++][1] = 1;
                }
            }
            idx[i] = z - 1;
        }

        int m = z - 1;
        int K = m > 0 ? 32 - Integer.numberOfLeadingZeros(m) : 0;
        int[][] st = new int[Math.max(K, 1)][Math.max(m, 0)];
        for (int i = 0; i < m; ++i) {
            st[0][i] = zeros[i][1] + zeros[i + 1][1];
        }
        for (int k = 1; k < K; ++k) {
            for (int i = 0; i + (1 << k) <= m; ++i) {
                st[k][i] = Math.max(st[k - 1][i], st[k - 1][i + (1 << (k - 1))]);
            }
        }

        for (int[] q : queries) {
            int L = q[0], R = q[1];
            int iL = idx[L], iR = idx[R];
            int cntL = iL < 0 ? -1 : zeros[iL][1] - (L - zeros[iL][0]);
            int cntR = iR < 0 ? -1 : R - zeros[iR][0] + 1;
            int start = iL + 1;
            int end = iR - (s.charAt(R) == '0' ? 1 : 0);
            int best = active;
            if (start < end) {
                best = Math.max(best, active + query(st, m, start, end - 1));
            }
            if (s.charAt(L) == '0' && s.charAt(R) == '0' && iL + 1 == iR) {
                best = Math.max(best, active + cntL + cntR);
            }
            if (s.charAt(L) == '0' && iL + 1 < iR + (s.charAt(R) == '1' ? 1 : 0)) {
                best = Math.max(best, active + cntL + zeros[iL + 1][1]);
            }
            if (s.charAt(R) == '0' && iL < iR - 1) {
                best = Math.max(best, active + cntR + zeros[iR - 1][1]);
            }
            ans.add(best);
        }
        return ans;
    }

    private int query(int[][] st, int m, int l, int r) {
        if (l > r || m <= 0) {
            return 0;
        }
        int k = 31 - Integer.numberOfLeadingZeros(r - l + 1);
        return Math.max(st[k][l], st[k][r - (1 << k) + 1]);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3501 _tcSol = new Solution3501();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"01\", queries = [[0,1]]");
        try {
            String s = "01";
            int[][] queries = new int[][]{new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxActiveSectionsAfterTrade(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"0100\", queries = [[0,3],[0,2],[1,3],[2,3]]");
        try {
            String s = "0100";
            int[][] queries = new int[][]{new int[]{0, 3}, new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxActiveSectionsAfterTrade(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,3,1,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1000100\", queries = [[1,5],[0,6],[0,4]]");
        try {
            String s = "1000100";
            int[][] queries = new int[][]{new int[]{1, 5}, new int[]{0, 6}, new int[]{0, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxActiveSectionsAfterTrade(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[6,7,2]");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "s = \"01010\", queries = [[0,3],[1,4],[1,3]]");
        try {
            String s = "01010";
            int[][] queries = new int[][]{new int[]{0, 3}, new int[]{1, 4}, new int[]{1, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxActiveSectionsAfterTrade(s, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[4,4,2]");
        System.out.println();
    }
}
