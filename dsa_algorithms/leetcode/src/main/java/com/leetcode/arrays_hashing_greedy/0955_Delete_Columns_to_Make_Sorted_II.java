package com.leetcode.arrays_hashing_greedy;

class Solution0955 {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        boolean[] st = new boolean[n - 1];
        int ans = 0;
        for (int j = 0; j < m; ++j) {
            boolean mustDel = false;
            for (int i = 0; i < n - 1; ++i) {
                if (!st[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    mustDel = true;
                    break;
                }
            }
            if (mustDel) {
                ++ans;
            } else {
                for (int i = 0; i < n - 1; ++i) {
                    if (!st[i] && strs[i].charAt(j) < strs[i + 1].charAt(j)) {
                        st[i] = true;
                    }
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0955 _tcSol = new Solution0955();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strs = [\"ca\",\"bb\",\"ac\"]");
        try {
            String[] strs = new String[]{"ca", "bb", "ac"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletionSize(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strs = [\"xc\",\"yb\",\"za\"]");
        try {
            String[] strs = new String[]{"xc", "yb", "za"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletionSize(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "strs = [\"zyx\",\"wvu\",\"tsr\"]");
        try {
            String[] strs = new String[]{"zyx", "wvu", "tsr"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletionSize(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
