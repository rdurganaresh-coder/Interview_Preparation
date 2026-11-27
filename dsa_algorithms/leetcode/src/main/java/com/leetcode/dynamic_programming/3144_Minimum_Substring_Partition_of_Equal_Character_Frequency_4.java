package com.leetcode.dynamic_programming;

class Solution3144_4 {
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int[] cnt = new int[26];
            Map<Integer, Integer> freq = new HashMap<>(26);
            int ans = n - i;
            for (int j = i; j < n; ++j) {
                int k = cs[j] - 'a';
                if (cnt[k] > 0) {
                    if (freq.merge(cnt[k], -1, Integer::sum) == 0) {
                        freq.remove(cnt[k]);
                    }
                }
                ++cnt[k];
                freq.merge(cnt[k], 1, Integer::sum);
                if (freq.size() == 1) {
                    ans = Math.min(ans, 1 + f[j + 1]);
                }
            }
            f[i] = ans;
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3144_4 _tcSol = new Solution3144_4();
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
