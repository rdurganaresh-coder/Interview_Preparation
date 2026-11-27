package com.leetcode.arrays_hashing_greedy;

class Solution0960 {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                boolean ok = true;
                for (String s : strs) {
                    if (s.charAt(j) > s.charAt(i)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0960 _tcSol = new Solution0960();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strs = [\"babca\",\"bbazb\"]");
        try {
            String[] strs = new String[]{"babca", "bbazb"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletionSize(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strs = [\"edcba\"]");
        try {
            String[] strs = new String[]{"edcba"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletionSize(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "strs = [\"ghi\",\"def\",\"abc\"]");
        try {
            String[] strs = new String[]{"ghi", "def", "abc"};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletionSize(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
