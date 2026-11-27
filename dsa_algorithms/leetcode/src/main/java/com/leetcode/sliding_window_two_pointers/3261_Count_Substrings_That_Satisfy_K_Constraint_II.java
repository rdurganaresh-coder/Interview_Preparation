package com.leetcode.sliding_window_two_pointers;

class Solution3261 {
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int[] cnt = new int[2];
        int n = s.length();
        int[] d = new int[n];
        Arrays.fill(d, n);
        long[] pre = new long[n + 1];
        for (int i = 0, j = 0; j < n; ++j) {
            cnt[s.charAt(j) - '0']++;
            while (cnt[0] > k && cnt[1] > k) {
                d[i] = j;
                cnt[s.charAt(i++) - '0']--;
            }
            pre[j + 1] = pre[j] + j - i + 1;
        }
        int m = queries.length;
        long[] ans = new long[m];
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0], r = queries[i][1];
            int p = Math.min(r + 1, d[l]);
            long a = (1L + p - l) * (p - l) / 2;
            long b = pre[r + 1] - pre[p];
            ans[i] = a + b;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3261 _tcSol = new Solution3261();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"0001111\", k = 2, queries = [[0,6]]");
        try {
            String s = "0001111";
            int k = 2;
            int[][] queries = new int[][]{new int[]{0, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countKConstraintSubstrings(s, k, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[26]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"010101\", k = 1, queries = [[0,5],[1,4],[2,3]]");
        try {
            String s = "010101";
            int k = 1;
            int[][] queries = new int[][]{new int[]{0, 5}, new int[]{1, 4}, new int[]{2, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.countKConstraintSubstrings(s, k, queries)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[15,9,3]");
        System.out.println();
    }
}
