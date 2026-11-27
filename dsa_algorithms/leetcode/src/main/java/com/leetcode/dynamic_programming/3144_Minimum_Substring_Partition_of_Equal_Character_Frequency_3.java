package com.leetcode.dynamic_programming;

class Solution3144_3 {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        Arrays.fill(f, n);
        f[0] = 0;
        for (int i = 0; i < n; ++i) {
            int[] cnt = new int[26];
            int k = 0, m = 0;
            for (int j = i; j >= 0; --j) {
                k += ++cnt[cs[j] - 'a'] == 1 ? 1 : 0;
                m = Math.max(m, cnt[cs[j] - 'a']);
                if (i - j + 1 == k * m) {
                    f[i + 1] = Math.min(f[i + 1], 1 + f[j]);
                }
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3144_3 _tcSol = new Solution3144_3();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"fabccddg\"");
        try {
            String s = "fabccddg";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSubstringsInPartition(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abababaccddb\"");
        try {
            String s = "abababaccddb";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSubstringsInPartition(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
