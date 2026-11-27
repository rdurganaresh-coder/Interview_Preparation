package com.leetcode.bit_manipulation_math;

class Solution2243 {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            int n = s.length();
            StringBuilder t = new StringBuilder();
            for (int i = 0; i < n; i += k) {
                int x = 0;
                for (int j = i; j < Math.min(i + k, n); ++j) {
                    x += s.charAt(j) - '0';
                }
                t.append(x);
            }
            s = t.toString();
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2243 _tcSol = new Solution2243();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"11111222223\", k = 3");
        try {
            String s = "11111222223";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.digitSum(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"135\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"00000000\", k = 3");
        try {
            String s = "00000000";
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.digitSum(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"000\"");
        System.out.println();
    }
}