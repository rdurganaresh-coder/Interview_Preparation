package com.leetcode.arrays_hashing_greedy;

class Solution0944 {
    public int minDeletionSize(String[] strs) {
        int m = strs[0].length(), n = strs.length;
        int ans = 0;
        for (int j = 0; j < m; ++j) {
            for (int i = 1; i < n; ++i) {
                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    ++ans;
                    break;
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
        Solution0944 _tcSol = new Solution0944();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strs = [\"cba\",\"daf\",\"ghi\"]");
        try {
            String[] strs = new String[]{"cba", "daf", "ghi"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletionSize(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strs = [\"a\",\"b\"]");
        try {
            String[] strs = new String[]{"a", "b"};
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