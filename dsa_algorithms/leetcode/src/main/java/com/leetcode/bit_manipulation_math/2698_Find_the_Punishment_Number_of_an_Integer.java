package com.leetcode.bit_manipulation_math;

class Solution2698 {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int x = i * i;
            if (check(x + "", 0, i)) {
                ans += x;
            }
        }
        return ans;
    }

    private boolean check(String s, int i, int x) {
        int m = s.length();
        if (i >= m) {
            return x == 0;
        }
        int y = 0;
        for (int j = i; j < m; ++j) {
            y = y * 10 + (s.charAt(j) - '0');
            if (y > x) {
                break;
            }
            if (check(s, j + 1, x - y)) {
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
        Solution2698 _tcSol = new Solution2698();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 10");
        try {
            int n = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.punishmentNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "182");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 37");
        try {
            int n = 37;
            System.out.println("  Output  : " + _tcShow(_tcSol.punishmentNumber(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1478");
        System.out.println();
    }
}