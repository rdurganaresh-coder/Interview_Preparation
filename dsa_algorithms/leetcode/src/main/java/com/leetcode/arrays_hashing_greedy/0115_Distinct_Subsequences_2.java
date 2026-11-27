package com.leetcode.arrays_hashing_greedy;

class Solution0115_2 {
    public int numDistinct(String s, String t) {
        int n = t.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (char a : s.toCharArray()) {
            for (int j = n; j > 0; --j) {
                char b = t.charAt(j - 1);
                if (a == b) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[n];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0115_2 _tcSol = new Solution0115_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"rabbbit\", t = \"rabbit\"");
        try {
            String s = "rabbbit";
            String t = "rabbit";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDistinct(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"babgbag\", t = \"bag\"");
        try {
            String s = "babgbag";
            String t = "bag";
            System.out.println("  Output  : " + _tcShow(_tcSol.numDistinct(s, t)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}