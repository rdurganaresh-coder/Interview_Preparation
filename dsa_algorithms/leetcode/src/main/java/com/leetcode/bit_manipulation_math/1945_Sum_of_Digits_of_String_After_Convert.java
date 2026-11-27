package com.leetcode.bit_manipulation_math;

class Solution1945 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        s = sb.toString();
        while (k-- > 0) {
            int t = 0;
            for (char c : s.toCharArray()) {
                t += c - '0';
            }
            s = String.valueOf(t);
        }
        return Integer.parseInt(s);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1945 _tcSol = new Solution1945();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"iiii\", k = 1");
        try {
            String s = "iiii";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.getLucky(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "36");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"leetcode\", k = 2");
        try {
            String s = "leetcode";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getLucky(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"zbax\", k = 2");
        try {
            String s = "zbax";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getLucky(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();
    }
}