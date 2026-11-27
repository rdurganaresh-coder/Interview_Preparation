package com.leetcode.sql_database;

class Solution0465 {
    public int minTransfers(int[][] transactions) {
        int[] g = new int[12];
        for (var t : transactions) {
            g[t[0]] -= t[2];
            g[t[1]] += t[2];
        }
        List<Integer> nums = new ArrayList<>();
        for (int x : g) {
            if (x != 0) {
                nums.add(x);
            }
        }
        int m = nums.size();
        int[] f = new int[1 << m];
        Arrays.fill(f, 1 << 29);
        f[0] = 0;
        for (int i = 1; i < 1 << m; ++i) {
            int s = 0;
            for (int j = 0; j < m; ++j) {
                if ((i >> j & 1) == 1) {
                    s += nums.get(j);
                }
            }
            if (s == 0) {
                f[i] = Integer.bitCount(i) - 1;
                for (int j = (i - 1) & i; j > 0; j = (j - 1) & i) {
                    f[i] = Math.min(f[i], f[j] + f[i ^ j]);
                }
            }
        }
        return f[(1 << m) - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0465 _tcSol = new Solution0465();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "transactions = [[0,1,10],[2,0,5]]");
        try {
            int[][] transactions = new int[][]{new int[]{0, 1, 10}, new int[]{2, 0, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTransfers(transactions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "transactions = [[0,1,10],[1,0,1],[1,2,5],[2,0,5]]");
        try {
            int[][] transactions = new int[][]{new int[]{0, 1, 10}, new int[]{1, 0, 1}, new int[]{1, 2, 5}, new int[]{2, 0, 5}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTransfers(transactions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}