package com.leetcode.bit_manipulation_math;

class Solution1461 {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int m = 1 << k;
        if (n - k + 1 < m) {
            return false;
        }
        Set<String> ss = new HashSet<>();
        for (int i = 0; i < n - k + 1; ++i) {
            ss.add(s.substring(i, i + k));
        }
        return ss.size() == m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1461 _tcSol = new Solution1461();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"00110110\", k = 2");
        try {
            String s = "00110110";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.hasAllCodes(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"0110\", k = 1");
        try {
            String s = "0110";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.hasAllCodes(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"0110\", k = 2");
        try {
            String s = "0110";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.hasAllCodes(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
