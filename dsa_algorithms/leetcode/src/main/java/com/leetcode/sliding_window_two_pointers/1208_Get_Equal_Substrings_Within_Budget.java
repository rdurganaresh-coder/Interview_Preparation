package com.leetcode.sliding_window_two_pointers;

class Solution1208 {
    private int maxCost;
    private int[] f;
    private int n;

    public int equalSubstring(String s, String t, int maxCost) {
        n = s.length();
        f = new int[n + 1];
        this.maxCost = maxCost;
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(s.charAt(i) - t.charAt(i));
            f[i + 1] = f[i] + x;
        }
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int x) {
        for (int i = 0; i + x - 1 < n; ++i) {
            int j = i + x - 1;
            if (f[j + 1] - f[i] <= maxCost) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1208 _tcSol = new Solution1208();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcd\", t = \"bcdf\", maxCost = 3");
        try {
            String s = "abcd";
            String t = "bcdf";
            int maxCost = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalSubstring(s, t, maxCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcd\", t = \"cdef\", maxCost = 3");
        try {
            String s = "abcd";
            String t = "cdef";
            int maxCost = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalSubstring(s, t, maxCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"abcd\", t = \"acde\", maxCost = 0");
        try {
            String s = "abcd";
            String t = "acde";
            int maxCost = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.equalSubstring(s, t, maxCost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}