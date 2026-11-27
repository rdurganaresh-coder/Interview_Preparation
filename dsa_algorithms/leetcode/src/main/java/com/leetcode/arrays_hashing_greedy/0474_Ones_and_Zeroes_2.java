package com.leetcode.arrays_hashing_greedy;

class Solution0474_2 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] cnt = count(s);
            for (int i = m; i >= cnt[0]; --i) {
                for (int j = n; j >= cnt[1]; --j) {
                    f[i][j] = Math.max(f[i][j], f[i - cnt[0]][j - cnt[1]] + 1);
                }
            }
        }
        return f[m][n];
    }

    private int[] count(String s) {
        int[] cnt = new int[2];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - '0'];
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0474_2 _tcSol = new Solution0474_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strs = [\"10\",\"0001\",\"111001\",\"1\",\"0\"], m = 5, n = 3");
        try {
            String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
            int m = 5;
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxForm(strs, m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strs = [\"10\",\"0\",\"1\"], m = 1, n = 1");
        try {
            String[] strs = new String[]{"10", "0", "1"};
            int m = 1;
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxForm(strs, m, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}