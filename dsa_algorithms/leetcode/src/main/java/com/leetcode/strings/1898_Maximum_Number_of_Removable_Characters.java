package com.leetcode.strings;

class Solution1898 {
    private char[] s;
    private char[] p;
    private int[] removable;

    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, r = removable.length;
        this.s = s.toCharArray();
        this.p = p.toCharArray();
        this.removable = removable;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int k) {
        boolean[] rem = new boolean[s.length];
        for (int i = 0; i < k; ++i) {
            rem[removable[i]] = true;
        }
        int i = 0, j = 0;
        while (i < s.length && j < p.length) {
            if (!rem[i] && p[j] == s[i]) {
                ++j;
            }
            ++i;
        }
        return j == p.length;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1898 _tcSol = new Solution1898();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcacb\", p = \"ab\", removable = [3,1,0]");
        try {
            String s = "abcacb";
            String p = "ab";
            int[] removable = new int[]{3, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumRemovals(s, p, removable)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcbddddd\", p = \"abcd\", removable = [3,2,1,4,5,6]");
        try {
            String s = "abcbddddd";
            String p = "abcd";
            int[] removable = new int[]{3, 2, 1, 4, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumRemovals(s, p, removable)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"abcab\", p = \"abc\", removable = [0,1,2,3,4]");
        try {
            String s = "abcab";
            String p = "abc";
            int[] removable = new int[]{0, 1, 2, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumRemovals(s, p, removable)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
