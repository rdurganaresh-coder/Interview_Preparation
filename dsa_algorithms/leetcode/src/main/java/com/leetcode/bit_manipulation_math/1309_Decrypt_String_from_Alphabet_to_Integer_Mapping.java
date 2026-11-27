package com.leetcode.bit_manipulation_math;

class Solution1309 {
    public String freqAlphabets(String s) {
        int i = 0, n = s.length();
        StringBuilder ans = new StringBuilder();
        while (i < n) {
            if (i + 2 < n && s.charAt(i + 2) == '#') {
                ans.append((char) ('a' + Integer.parseInt(s.substring(i, i + 2)) - 1));
                i += 3;
            } else {
                ans.append((char) ('a' + Integer.parseInt(s.substring(i, i + 1)) - 1));
                i++;
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1309 _tcSol = new Solution1309();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"10#11#12\"");
        try {
            String s = "10#11#12";
            System.out.println("  Output  : " + _tcShow(_tcSol.freqAlphabets(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"jkab\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"1326#\"");
        try {
            String s = "1326#";
            System.out.println("  Output  : " + _tcShow(_tcSol.freqAlphabets(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"acz\"");
        System.out.println();
    }
}
